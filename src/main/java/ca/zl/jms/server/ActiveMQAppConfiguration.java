package ca.zl.jms.server;

import javax.sql.DataSource;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.openwire.OpenWireFormat;
import org.apache.activemq.store.PersistenceAdapter;
import org.apache.activemq.store.jdbc.JDBCPersistenceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:my-beans.xml")
public class ActiveMQAppConfiguration {
	@Autowired
	private BrokerService broker;

	@Bean
	public PersistenceAdapter persistenceAdapter(DataSource dataSource) throws Exception {
		JDBCPersistenceAdapter jdbcPersistenceAdapter = new JDBCPersistenceAdapter(dataSource, new OpenWireFormat());
		broker.setPersistenceAdapter(jdbcPersistenceAdapter);
		broker.start();
		return jdbcPersistenceAdapter;
	}
}
