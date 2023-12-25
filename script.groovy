def buildJar() {
    echo "Building the application..."
    sh 'mvn package'
}

def buildImage() {
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t htoohtoo24/my-java-repo:jma-2.0 .'          
        sh "echo $PASS | docker login -u $USER --password-stdin" 
        sh 'docker push  htoohtoo24/my-java-repo:jma-2.0'
    }
}

def deployApp() {
    echo 'Deploying the application...'
} 


return this