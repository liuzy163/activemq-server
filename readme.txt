This demonstrates using SpringBoot to deploy a fully configurable ActiveMQ broker into a Tomcat server. 
You can remove the Tomcat container by replacing the dependency artificat spring-boot-starter-web with spring-boot-starter. You may need to start the ActiveMQ in a non-daemon thread, or create a long living bean. 

You can follow  https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-activemq if VM based broker is good enough for you.

Note: If you use mssql, you may want to specify your artifact repository that provides sql server jdbc driver.

How to run

Option#1: Use all defaults
	java -jar activemq-server.jar
Option#2: customize properties in a file, i.e. e:/activemq-server-production.properties
	java -Dspring.config.location=e:/activemq-server-production -jar activemq-server.jar
	================================================
	The content of e:/activemq-server-production.properties is
	===============================================
	#Tomcat
	server.port=9999
	
	#ActiveMQ
	activemq.data=/activemq-data
	broker.name=Broker1
	spring.activemq.broker-url=tcp://0.0.0.0:61626
	
	#DB
	spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
	spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=jms
	spring.datasource.username=myUsername
	spring.datasource.password=myPassword
	
	
	#jmx
	spring.jmx.enabled=true
	
	#log
	logging.path=/logs
	  