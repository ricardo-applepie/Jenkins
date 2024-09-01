pipeline {
  agent any
  tools {
    maven "MAVEN"
    jdk  "OracleJDK11"
  } 
  stages {
    stage ('Fetch Code') {
      steps {
        git branch: 'main', url 'https://github.com/hkhcoder/vprofile-project.git'
      }
    }

    stage ('Build') {
      steps {
        sh 'nvm install -DskipTests'
      }
      post {
        success {
         echo 'Archiving artifacts now'
        }
      }
    }
    stage ('unit test') {
      steps {
        sh 'mvn test'
      }
    }
  }
}