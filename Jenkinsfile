// @Library('jk_shared_lib@master') _

pipeline {
    agent { 
        kubernetes {
            label 'DevBuilds'
        }    
    }
    
    options {
		buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
		disableConcurrentBuilds()
    }

    stages{
        stage('LocalPing'){
            steps {
                sh "ping -c3 google.com"                 
            }
        }
        stage('Dev-Deployment'){
            steps{
                sshagent(credentials: ['dev-keys-creds']) {
                    sh "ssh -o BatchMode=yes -o StrictHostKeyChecking=no jenkins@192.168.1.140 'uptime'"
                }
            }
        }
        stage('Prd-Deployment'){
            steps{
                sshagent(credentials: ['prd-keys-creds']) {
                    sh "ssh -o BatchMode=yes -o StrictHostKeyChecking=no jenkins@192.168.1.141 'uptime'"
                }
            }
        }

    }
}