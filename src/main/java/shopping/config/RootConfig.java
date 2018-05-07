package shopping.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(
		basePackages= {
				"shopping.config", "shopping.service", "shopping.mapper"
		})
@Import(DataSourceConfig.class)
public class RootConfig {
	
}
