def call(credens, userName, ipName, jarName){
  sshagent([credens]) {
          //copy jar file to tomcat folder
          sh "scp -o StrictHostKeyChecking=no /target/${jarName}.jar ${userName}@${ipName}:/opt/tomcat9/webapps"
          sh "ssh ${userName}@${ipName} /opt/tomcat9/bin/shutdown.sh"
          sh "ssh ${userName}@${ipName} /opt/tomcat9/bin/startup.sh"
        }
}
