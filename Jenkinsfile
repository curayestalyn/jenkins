pipeline {
    agent any

    tools {
        maven 'MAVEN'
    }
    stages {
        stage('Build') {
            steps {
            git url: 'https://github.com/estalyncuray/jenkins.git', branch: 'main',credentialsId:'github-credential'
                sh 'mvn clean compile'
                echo 'Application is in Build process'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn -DskipTests'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}