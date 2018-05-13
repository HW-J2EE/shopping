package shopping.config;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories("shopping.mongoRes")
@PropertySource("classpath:shopping/config/mongo.properties")
public class MongoConfig extends AbstractMongoConfiguration{

	@Autowired
	private Environment env;
	
	@Override
	public MongoClient mongoClient() {
		MongoCredential credential = MongoCredential.createCredential(
				env.getProperty("mongo.user"), 
				"j2ee", 
				env.getProperty("mongo.passwd").toCharArray()
		);
		return new MongoClient(
				new ServerAddress(
						env.getProperty("mongo.host"), 
						env.getProperty("mongo.port", Integer.class)
						),
				Arrays.asList(credential)
		);
	}

	@Override
	protected String getDatabaseName() {
		return "j2ee";
	}

}
