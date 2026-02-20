pipeline {
    agent any
    tools { maven 'maven' }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/vanik642/SampleDemoFramework.git'
            }
        }

        stage('Regression Automation Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regression.xml -Denv=qa"
                }
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }

        stage('Publish Allure Reports') {
            steps {
                allure([
                    results: [[path: 'allure-results']],
                    reportBuildPolicy: 'ALWAYS'
                ])
            }
        }

        stage("Deploy to QA") { steps { echo "Deploy QA done" } }
        stage("Deploy to Stage") { steps { echo "Deploy Stage done" } }
        stage("Deploy to PROD") { steps { echo "Deploy PROD done" } }
    }
}
