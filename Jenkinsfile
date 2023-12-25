pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "Building the applications..."
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building the docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')])
                        sh 'docker build -t htoohtoo24/my-java-repo:jma-2.0 .'          
                        sh "echo $PASS | docker login -u $USER --password-stdin" 
                        sh 'docker push  htoohtoo24/my-java-repo:jma-2.0'         
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "Deploying the application"
                }
            }
        }
    }   
}