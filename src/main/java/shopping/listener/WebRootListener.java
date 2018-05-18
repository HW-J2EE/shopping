package shopping.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.stereotype.Component;
import org.springframework.web.util.WebAppRootListener;

@Component
public class WebRootListener extends WebAppRootListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.setProperty("ImageRoot", event.getServletContext().getRealPath("/")+"image");
		super.contextInitialized(event);
	}
}
