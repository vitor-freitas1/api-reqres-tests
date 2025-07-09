// Jenkinsfile

pipeline {
    agent any

    tools {
        maven 'Maven-3.9.10' 
    }

    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Baixando o código do repositório...'
                git 'https://github.com/vitor-freitas1/api-reqres-tests.git'
            }
        }

        stage('Test') {
            steps {
                echo 'Compilando o projeto e rodando os testes...'
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'Processo finalizado. Publicando relatórios...'
            junit 'target/surefire-reports/*.xml'
        }
    }
}
