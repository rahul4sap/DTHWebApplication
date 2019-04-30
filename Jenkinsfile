pipeline {
  environment {
    registry = "projectblockbuster/dthwebapplication"
    registryCredential = 'dockerhublogin'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/project-blockbuster/DTHWebApplication.git'
      }
    }
    stage('Build') {
       steps {
         sh 'mvn compile'
       }
    }
    stage('Test') {
      steps {
        sh 'mvn test -DskipITs'
      }
    }
    stage('Package') {
      steps {
        sh 'mvn package -Dskip.surefire.tests -DskipITs'
      }
    }
    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    stage('Deploy Image') {
      steps{
         script {
            docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
  }
}
