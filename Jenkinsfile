pipeline 
{
    agent any
    
    tools{
        maven 'maven'
        }

    stages 
    
    {
		
		
        stage('Build') 
        {
            steps
            {
				 withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']){
                 git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                 sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            }
            post 
            {
                success
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        
        
        
        stage("Deploy to QA"){
            steps{
                echo("deploy to qa done")
            }
        }
        
        
        
                
      stage('Regression Automation Tests') {
            steps {
				withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']){
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/vanik642/NewDemoRepos.git'
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regression.xml -Denv=qa"
                    
                }
                }
            }
        }
                
   
        
        
        
        stage("Deploy to PROD"){
            steps{
                echo("deploy to PROD")
            }
        }
        
        
    }
}