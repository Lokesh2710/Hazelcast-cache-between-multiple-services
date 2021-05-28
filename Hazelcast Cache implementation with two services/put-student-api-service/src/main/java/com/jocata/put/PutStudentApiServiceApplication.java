package com.jocata.put;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.jocata.put.model.Student;

@SpringBootApplication
public class PutStudentApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PutStudentApiServiceApplication.class, args);
	}
	

	@Bean
	public Config hazelCastConfig() {
		return new Config().setManagementCenterConfig(
				new ManagementCenterConfig().setEnabled(true).setUrl("http://localhost:8080/hazelcast-mancenter"));

	}

	@Bean
	public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
		return Hazelcast.newHazelcastInstance(hazelCastConfig);
	}

	@Bean
	public Map<String, Student> accountMap(HazelcastInstance hazelcastInstance) {
		return hazelcastInstance.getMap("accountMap");
	}
}
