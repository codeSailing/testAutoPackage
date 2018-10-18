//package com.zhum.demo; /**
// * @author: zhum
// * @description:
// * @create: 2018-10-11 17:17
// **/
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * Created by gyz on 2017/11/27 0027.
// */
//@Configuration
//@MapperScan(basePackages = "com.zhum.demo.mapper", sqlSessionTemplateRef = "goodsPriceSqlSessionTemplate")
//public class GoodsPriceDataSourceConfig {
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource goodsPriceDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @Primary
//    public SqlSessionFactory goodsPriceSqlSessionFactory(@Qualifier("goodsPriceDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapping/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean
//    @Primary
//    public DataSourceTransactionManager shareBaseTransactionManager(@Qualifier("goodsPriceDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean
//    @Primary
//    public SqlSessionTemplate goodsPriceSqlSessionTemplate(@Qualifier("goodsPriceSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
