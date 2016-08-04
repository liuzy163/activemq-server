This demonstrates using SpringBoot to deploy a fully configurable ActiveMQ broker into a Tomcat server. 
You can remove the Tomcat container by replacing the dependency artificat spring-boot-starter-web with spring-boot-starter. You may need to start the ActiveMQ in a non-daemon thread, or create a long living bean. 

You can follow  https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-activemq if VM based broker is good enough for you.

Note: If you use mssql, you may want to specify your artifact repository that provides sql server jdbc driver.  