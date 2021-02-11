package com.Config;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.Do" })
@SuppressWarnings(value="unused")
public class HibernateConfig {

	
	@Autowired
	private Environment environment;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.Do" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
		
	}

	 @Bean
	 public DataSource dataSource() 
	 {
	        BasicDataSource dataSource = new BasicDataSource();
	        dataSource.setDriverClassName("com.sap.db.jdbc.Driver");
	        dataSource.setUrl("jdbc:sap://zeus.hana.prod.eu-central-1.whitney.dbaas.ondemand.com:23803?encrypt=true&validateCertificate=true&currentschema=F2DBF663DB4440C78BE264383B56EB40_0R155DTK9D1TQ8KIM69A5TP4P_RT");
	        
	        //dataSource.setUrl("jdbc:sap://localhost:23803");
	        //URL FOR LOCAL HOST
	        
	        //dataSource.setUrl("jdbc:sap://vadbirn.nwtrial.od.sap.biz:30248/");
	        //URL FOR DEPLOYING
	        
	        dataSource.setUsername("F2DBF663DB4440C78BE264383B56EB40_0R155DTK9D1TQ8KIM69A5TP4P_RT");
	        
	        //dataSource.setUsername("F2DBF663DB4440C78BE264383B56EB40_0R155DTK9D1TQ8KIM69A5TP4P_RT");
	        
	        
	        dataSource.setPassword("Yb2zD3.hvKOQuQ597SmR.U8ETkIR5VZV_NNMfVO18JJAA-pijjGaUHou35R3v0UT-QOeaOUfmQhba1XMgW3JC0HAV.Kly3iNou5fFCDECb1UW3M4GjYWfl0tQpEhKW.4");
	        
	        //dataSource.setPassword("Yb2zD3.hvKOQuQ597SmR.U8ETkIR5VZV_NNMfVO18JJAA-pijjGaUHou35R3v0UT-QOeaOUfmQhba1XMgW3JC0HAV.Kly3iNou5fFCDECb1UW3M4GjYWfl0tQpEhKW.4");
	        
	        return dataSource;
	    }
	 @SuppressWarnings(value="serial")
	    Properties hibernateProperties() {
	        return new Properties() {
	            {
	                setProperty("hibernate.hbm2ddl.auto", "update");
	                setProperty("hibernate.dialect", "org.hibernate.dialect.HANAColumnStoreDialect");
	                setProperty("hibernate.show_sql", "true");
	            }
	        };
	    }

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
	
	
}
