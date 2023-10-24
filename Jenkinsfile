pipeline {
    agent any
        stages {
            stage('Clean e install') {
                steps {
                    sh 'mvn clean install -DskipTests=true'
                }
            }

            stage('Testes Unitarios') {
                steps {
                    sh 'mvn test'
                }
            }

            stage('Derrubando o container antigo') {
                steps {
                    script {
                        try {
                            sh 'docker rmi hair-pass-app'
                        } catch (Exception e) {
                            sh 'echo $e'
                        }
                    }
                }
            }

            stage('Build da nova imagem') {
                steps {
                    script {
                        sh 'docker-compose build'
                    }
                }
            }

            stage('Deploy Backend') {
                steps {
                    script {
                        sh 'docker images'
                    }
                }
            }
        }
}
