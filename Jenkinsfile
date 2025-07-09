// Jenkinsfile

pipeline {
    agent any // Diz ao Jenkins para rodar em qualquer máquina (agente) disponível

    tools {
        // Garante que o Jenkins use a versão correta do Maven que está configurada nele
        // O nome 'Maven-3.9.10' deve ser igual ao nome da ferramenta configurada no seu Jenkins
        maven 'Maven-3.9.10' 
    }

    triggers {
        githubPush()
    }

    stages {
        // Estágio 1: Baixar o Código do GitHub
        stage('Checkout') {
            steps {
                echo 'Baixando o código do repositório...'
                // O Jenkins clona o repositório automaticamente quando configurado
                // Mas podemos adicionar o comando explícito se necessário
                git 'https://github.com/vitor-freitas1/api-reqres-tests.git'
            }
        }

        // Estágio 2: Executar os Testes com Maven
        stage('Test') {
            steps {
                echo 'Compilando o projeto e rodando os testes...'
                // Comando para rodar no Windows. Se o Jenkins estiver em Linux, use: sh 'mvn test'
                bat 'mvn test'
            }
        }
    }

    post {
        // Ações que rodam no final, mesmo que os testes falhem
        always {
            echo 'Processo finalizado. Publicando relatórios...'
            // Este passo crucial lê os relatórios XML gerados pelo Maven
            // e exibe os resultados dos testes na interface do Jenkins.
            junit 'target/surefire-reports/*.xml'
        }
    }
}
