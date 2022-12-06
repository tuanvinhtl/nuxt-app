def gv

pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
        DOCKERHUB_CREDENTIALS = credentials('docker-hub')
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    tools {
        nodejs '16.4.1'
        docker 'docker:latest'
    }
    stages {
        stage('Initial scripts') {
            steps {
                script {
                    gv = load 'script.groovy'
                    def dockerHome = tool 'docker:latest'
                    env.PATH = "${dockerHome}/bin:${env.PATH}"
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
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                script {
                    gv.test()
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploy..'
                }
            }
        }
        stage('Building image') {
            steps {
                script {
                    sh "docker -v"
                }
            }
        }
    }
}
