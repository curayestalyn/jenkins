pipeline {
    agent any

    tools {
        maven 'MAVEN'
    }
    stages {
        stage('Build') {
            steps {
            git url: 'https://github.com/estalyncuray/jenkins.git', branch: 'main',
                sh 'mvn clean compile'
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