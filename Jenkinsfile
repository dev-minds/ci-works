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
    }
}