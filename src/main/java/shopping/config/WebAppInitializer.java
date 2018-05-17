package shopping.config;



import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	private static final int BLOCK_SIZE = 1024*1024;
	/**
	 * root配置，spring配置，主要配置数据库、事务等
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
		
	}
	
	/**
	 * web配置，springmvc配置，定义DispatcherServlet加载应用上下文 
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		super.customizeRegistration(registration);
		registration.setMultipartConfig(new MultipartConfigElement("/", 10*BLOCK_SIZE, 20*BLOCK_SIZE, 0));
	}
	
	/**
	 * 请求路径映射
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
		return new Filter[] {
				characterEncodingFilter
		};
	}
}
