package shopping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import shopping.common.CosTool;

@Configuration
@PropertySource("classpath:shopping/config/cos.properties")
public class CosConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public CosTool cosTool() {
		return new CosTool(env);
	}
}
