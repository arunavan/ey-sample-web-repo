pipeline {
    agent any

  //  environment
 //   {
  //  dockerpassword=credentials('dockerpassword') // ADP docker repo password from Jenkins.
  //  }
    
    stages {
            stage('Compile and Clean') { 
                steps {
                       bat 'mvn compile'
                      }
            }
       
	        stage('Junit5 Test') { 
                 steps {
	                bat 'mvn test'
                  }
            }

	    stage('Jacoco Coverage Report') {
        	     steps{
            		jacoco()
		          }
	        }
		stage('SonarQube'){
			steps{
				bat label: '', script: '''mvn sonar:sonar \
				-Dsonar.host.url=http://CDLVDIDEVMAN500:9000 \
				-Dsonar.login=c0909bf6713cd534393d47364d1da553431a220d'''
				}	
   			}
        stage('Maven Build') { 
            steps {
                bat 'mvn clean install'
                  }
            }
        stage('Build Docker image'){
           steps {
                      //   	docker build -t nodejs-server -f Dockerfile.arg --build-arg UBUNTU_VERSION=18.04
		             //--build-arg CUDA_VERSION=10.0
                     //bat 'docker build -t  docker.repository.esi.adp.com/clientcentral/training:docker_jenkins_springboot:${BUILD_NUMBER} .'
           	    bat 'docker image build -t sampleproject  .'
		         }
             }
        stage('Docker Login'){
            steps {
              echo "docker login from console"
                //docker login docker.repository.esi.adp.com -u clientcentralcicd -p $adpdtrrepopassword
            }                
        }
        stage('Docker Push'){
            steps {
                bat 'docker push docker.repository.esi.adp.com/clientcentral/training:season2-batch3-sampleproject'
            }
        }
        stage('Docker deploy'){
            steps {
                bat 'docker run -itd -p  8086:8086 sampleproject'
             }
        }
     //    stage('Docker Login'){
            //docker login docker.repository.esi.adp.com -u clientcentralcicd -p $adpdtrrepopassword
	    //withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
    //        steps {
                 //withCredentials([string(credentialsId: 'DockerId', variable: 'dockerpassword')]) {
	//	   withCredentials([string(credentialsId: 'dockerpassword', variable: 'dockerpassword')]) {
     //               bat 'docker login docker.repository.esi.adp.com -u clientcentralcicd -p ${dockerpassword}'
    //             }
  //          }                
  //      }
  //      stage('Docker Push'){
    //        steps {
    //            bat 'docker push docker.repository.esi.adp.com/clientcentral/training:docker_jenkins_springboot'
   //         }
  //      }
  //      stage('Docker deploy'){
  //          steps {
               
  //              bat 'docker run -itd -p  8086:8086 docker.repository.esi.adp.com/clientcentral/training:docker_jenkins_springboot'
  //          }
  //      }
       // stage('Archiving') { 
          //  steps {
             //    archiveArtifacts '**/target/*.jar'
          //  }
     //   }
     
    }
}
