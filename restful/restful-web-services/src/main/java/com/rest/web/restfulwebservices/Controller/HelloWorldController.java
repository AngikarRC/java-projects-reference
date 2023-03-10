package com.rest.web.restfulwebservices.Controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.rest.web.restfulwebservices.BeanClass;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/hello-world")
	public String HelloWorld() {
		return "Practise SpringBoot";
	}
	
	@GetMapping("/hello-world-bean")
	public BeanClass beanClass() {
		return new BeanClass("This is practising beans!");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public BeanClass helloWorldPathVariable(@PathVariable("name") String name) {
		return new BeanClass(String.format("Hello World, %s", name));
	}
	
//	@GetMapping(path = "/hello-world-internationalized")
//	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
//		return messageSource.getMessage("good.morning.message", null, 
//									locale);
//	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}

}
