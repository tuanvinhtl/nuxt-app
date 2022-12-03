pipeline {
    agent any
    tools {
      nodejs '16.4.1'
    }
    stages {
        stage('Pulling packages') {
            steps {
                echo 'Pulling..'
                sh 'npm install'
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'npm run build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
