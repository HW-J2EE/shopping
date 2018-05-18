package shopping.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(
		basePackages= {
				"shopping.config", "shopping.service", "shopping.mapper",
				"shopping.listener","shopping.common"
		})
@Import(value= {
		DataSourceConfig.class,
		CosConfig.class
})
public class RootConfig {
	
}
