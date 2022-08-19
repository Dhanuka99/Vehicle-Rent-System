package lk.dmax.spring.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "lk.dmax.spring.repo")
public class JPAConfig {


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds,JpaVendorAdapter ap){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setJpaVendorAdapter(ap);
        factoryBean.setPackagesToScan("lk/dmax/spring/entity");
        return factoryBean;
    }

    @Bean
    public DataSource dataSource() throws NamingException {
//          JndiTemplate jndiTemplate = new JndiTemplate();
//         return (DataSource) jndiTemplate.lookup("java:comp/env/jdbc/pool");

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getRequiredProperty("my.driver"));
//        dataSource.setUrl(env.getRequiredProperty("db.url"));
//        dataSource.setUsername(env.getRequiredProperty("db.username"));
//        dataSource.setPassword(env.getRequiredProperty("db.password"));
//        return dataSource;
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/DMAX?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("11356");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter vendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
        adapter.setDatabase(Database.MYSQL);
        adapter.setGenerateDdl(true);
        adapter.setShowSql(true);
        return adapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory em){
        return new JpaTransactionManager(em);
    }
}
