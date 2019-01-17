package fr.villedenice.bibliotheque.webservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WSConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/bibliotheque/*");
	}
	@Bean(name = "work")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema workSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("WorkPort");
		wsdl11Definition.setLocationUri("/bibliotheque");
		wsdl11Definition.setTargetNamespace("http://www.elibrary.fr/work-ws");
		wsdl11Definition.setSchema(workSchema);
		return wsdl11Definition;
	}
	@Bean
	public XsdSchema workSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsds/work.xsd"));
	}
}
