package org.dav.ndw.interview.tickets.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = Constants.APP_PACKAGE)
@EnableTransactionManagement
@PropertySource(value = Constants.DB_PROPERTIES_PATH)
public class HibernateConfig {
    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return transactionManager;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(Constants.APP_MODEL_PACKAGE);
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty(Constants.DB_DRIVER_CLASS_NAME));
        dataSource.setUrl(environment.getRequiredProperty(Constants.DB_URL));
        dataSource.setUsername(environment.getRequiredProperty(Constants.DB_USER_NAME));
        dataSource.setPassword(environment.getRequiredProperty(Constants.DB_PASSWORD));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(Constants.DB_HIBERNATE_DIALECT, environment.getRequiredProperty(Constants.DB_HIBERNATE_DIALECT));
        properties.put(Constants.DB_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(Constants.DB_HIBERNATE_SHOW_SQL));
        return properties;
    }
}
