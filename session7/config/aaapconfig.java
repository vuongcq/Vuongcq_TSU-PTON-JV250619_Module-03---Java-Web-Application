package com.ra.session7.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.ra.session7"})
@EnableTransactionManagement
public class aaapconfig {
    // khai báo viewResolver
    // khai báo dataSource
    // khai báo hibernate properties
    // cấu hình entityManagerFactory
    // Cấu hình entityManager
    // Cấu hình transaction

    // khai báo viewResolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // Cấu hình DataSource để kết nối đến CSDL
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver/categories_db");
        dataSource.setUrl("jdbc:mysql://localhost:3306");
        dataSource.setUsername("vuongcq");
        dataSource.setPassword("123456@");
        return dataSource;
    }

    // Cấu hình HibernateProperties
    @Bean
    public Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2dll.auto","update");
        properties.setProperty("dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.setProperty("hibernate.show_sql","true");
        return properties;
    }

    //Cấu hình EntityManagerFacetory
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("com.ra.session7/model/entity");
        // khởi tạo 1 đối tượng JpaVenderAdapter là 1 chuẩn Interface
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setJpaProperties(additionalProperties());
        return entityManagerFactoryBean;
    }

    // CẤu hình EntityManager
    @Qualifier(value = "entityManager") // @Autowired + chỉ định rõ đối tượng tiêm
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory){
        return entityManagerFactory.createEntityManager();
    }
}
