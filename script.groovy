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


// def buildImage() {
//     echo "building the docker image..."
//     withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//         sh 'docker build -t nanajanashia/demo-app:jma-2.0 .'
//         sh "echo $PASS | docker login -u $USER --password-stdin"
//         sh 'docker push nanajanashia/demo-app:jma-2.0'
//     }
// } 


return this