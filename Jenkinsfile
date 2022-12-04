def gv

pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
    }
    tools {
      nodejs '16.4.1'
    }
    stages {
        stage('Initial scripts') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('Pulling packages') {
            steps {
                script {
                    gv.pullPackages()
                }
            }
        }
        stage('Build') {
            steps {
               script {
                    gv.build()
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    gv.test()
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    gv.deploy()
                }
            }
        }
    }
}
