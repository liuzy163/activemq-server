package ca.zl.jms.server;

import org.apache.activemq.broker.BrokerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ActiveMqApplication {

    public static void main(String[] args) {
    	BrokerFactory.setStartDefault(false);
        SpringApplication.run(ActiveMqApplication.class, args);
    }
}
