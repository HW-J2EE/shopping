package shopping.config;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:/shopping/config/datasource.properties")
@MapperScan("shopping.mapper")
public class DataSourceConfig {
	
	@Autowired
	private Environment env;
	/**
	 * 数据源
	 * @return
	 * @throws SQLException 
	 */
	@Bean 
	public DataSource dataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("dataSource.diverClass"));
		dataSource.setUrl(env.getProperty("dataSource.url"));
		dataSource.setUsername(env.getProperty("dataSource.user"));
		dataSource.setPassword(env.getProperty("dataSource.passwd"));
		return dataSource;
	}
	/**
	 * sql工厂
	 * @return
	 * @throws IOException
	 * @throws SQLException 
	 */
	@Bean 
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException, SQLException {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath:shopping/mapper/*.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("shopping.model");
		return sqlSessionFactoryBean;
	}
	/**
	 * 事务管理器
	 * @return
	 * @throws SQLException 
	 */
	@Bean
	public DataSourceTransactionManager transactionManager() throws SQLException {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
}
