package ca.zl.jms.server;

import javax.sql.DataSource;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.openwire.OpenWireFormat;
import org.apache.activemq.store.PersistenceAdapter;
import org.apache.activemq.store.jdbc.JDBCPersistenceAdapter;
import org.apache.activemq.store.jdbc.LeaseDatabaseLocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:my-beans.xml")
public class ActiveMQAppConfiguration {
  @Autowired
  private BrokerService broker;

  @Bean
  public PersistenceAdapter persistenceAdapter(DataSource dataSource,
      @Value("${activemq.broker.name}") String brokerName) throws Exception {
    JDBCPersistenceAdapter jdbcPersistenceAdapter =
        new JDBCPersistenceAdapter(dataSource, new OpenWireFormat());
    broker.setPersistenceAdapter(jdbcPersistenceAdapter);
    LeaseDatabaseLocker locker = new LeaseDatabaseLocker();
    locker.setDataSource(dataSource);
    locker.setLeaseHolderId(brokerName);
    // TODO: externalize the value into application.properties
    //This value must be greater than the LockKeepAlivePeriod
    locker.setLockAcquireSleepInterval(5000);
    jdbcPersistenceAdapter.setLocker(locker);
    // TODO: externalize the value into application.properties
    jdbcPersistenceAdapter.setLockKeepAlivePeriod(1000);
    broker.start();
    return jdbcPersistenceAdapter;
  }
}
