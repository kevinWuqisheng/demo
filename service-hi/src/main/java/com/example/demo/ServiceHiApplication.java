package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}
	private static final Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());


	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

//	@RequestMapping("/hi")
//	public String callHome(){
//		LOG.log(Level.INFO, "calling trace service-hi  ");
//		return restTemplate.getForObject("http://localhost:8989/miya", String.class);
//	}
//	@RequestMapping("/aaaa")
//	public String aaaa(){
//		LOG.log(Level.INFO, "calling aaaa");
//		return "aaaaaaaaaaaaaaaaaaaa";
//	}


//	@Value("${server.port}")
//	String port;
//	@RequestMapping("/hi")
//	public String home(@RequestParam String name) {
//		return "hi "+name+",i am from port:" +port;
//	}

	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public String home(@RequestParam String name) {
		return "hi "+name+",i am from port:" +port;
	}

	public String hiError(String name) {
		return "hi,"+name+",sorry,error!";
	}
}
