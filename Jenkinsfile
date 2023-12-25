pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }
    stages {
        stage('build') {
            steps {
                script {
                    echo 'Building the application...'
                    echo "Building Version ${NEW_VERSION}"
                }
            }
        }
        stage('test') {
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                    withCredentials([
                        usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD)
                    ]) {
                        sh "some script ${USER} and ${PWD}"
                    }
                    // echo "Deploying with ${SERVER_CREDENTIALS}"
                    // sh "${SERVER_CREDENTIALS}"
                }
            }
        }
    }
}
