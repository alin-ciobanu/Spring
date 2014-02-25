package ro.bets.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by yozmo on 2/20/14.
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ro.bets.repository")
@ComponentScan(basePackages = {"ro.bets.controller", "ro.bets.service"})
//@PropertySource("classpath:ro/bets/config/application.properties")
public class InfrastructureConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/YOZMO_DB");
        dataSource.setUsername("root");
        dataSource.setPassword("jovial");
        return dataSource;
    }

    protected
    @Bean
    JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter ret = new HibernateJpaVendorAdapter();
        return completeVendor(ret);
    }

    private AbstractJpaVendorAdapter completeVendor(AbstractJpaVendorAdapter jpaVendorAdapter) {
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

    @Bean
    @Autowired
    AbstractEntityManagerFactoryBean entityManagerFactory
            (JpaVendorAdapter jpaVendorAdapter, DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        containerEntityManagerFactoryBean.setDataSource(dataSource);
        containerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        containerEntityManagerFactoryBean.setPackagesToScan(domainPackages());
        return containerEntityManagerFactoryBean;
    }

    private String[] domainPackages(){
        return new String[]{"ro.bets.domain"};
    }

    @Bean
    @Autowired
    public org.springframework.transaction.PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
