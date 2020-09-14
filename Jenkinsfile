@Library('jk_shared_lib@master') _

pipeline {
    agent any 

    options {
		buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
		disableConcurrentBuilds()
    }

    stages{
        stage('LocalPing'){
            steps {
                wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'xterm']){
                    dir("./"){
                        sh "ls -a"
                        sh "ping -c5 google.com"
                    }
                }                 
            }
        }
        stage('Deploy') {
            steps{
                sshagent(credentials: ['ssh_priv']) {
                    sh "ssh -o StrictHostKeyChecking=no centos@63.33.51.136 uptime"
                    sh "ssh -o StrictHostKeyChecking=no centos@63.33.51.136 uname -ras"
                    sh "ssh -o StrictHostKeyChecking=no centos@63.33.51.136 hostname -f"
                    sh "ssh -t -t -t -o BatchMode=yes -o StrictHostKeyChecking=no centos@63.33.51.136 sudo systemctl restart nginx"
                    sh "ssh -t -t -t -o BatchMode=yes -o  StrictHostKeyChecking=no centos@63.33.51.136 sudo systemctl status nginx"
                }
            }
        }

    }
}