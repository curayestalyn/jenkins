pipeline {
    agent any

    tools {
        maven 'MAVEN'
    }
    stages {
        stage('Build') {
            steps {
            git url: 'https://github.com/estalyncuray/jenkins.git', branch: 'develop',credentialsId:'github-credential'
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'mvn -Dmaven.test.skip=true'
            }
        }
        stage('Configure reports') {
                        steps {
                            sh 'mvn verify'
                            jacoco classPattern: 'target/classes', execPattern: 'target/coverage-reports/jacoco-ut.exec', sourcePattern: 'src/main/java'
                            jacoco sourceExclusionPattern: '**/*.html,**/*.js,**/*.css'
                            jacoco runAlways: true
                        }
                    }
        stage('SonarQube') {
            steps {
                                    withSonarQubeEnv('sonarqube') {
                                        sh 'mvn sonar:sonar \
                                        -Dsonar.projectKey=musker \
                                        -Dsonar.projectName=Musker \
                                        -Dsonar.sources=src/main \
                                        -Dsonar.java.binaries=target/classes'
                                    }
            }
        }
        stage('Quality Gate') {
            steps {
                timeout(time:5, unit:'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy process'
            }
        }
    }
}