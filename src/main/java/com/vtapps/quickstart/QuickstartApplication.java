package com.vtapps.quickstart;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@SpringBootApplication
@Log4j2
public class QuickstartApplication implements CommandLineRunner {
	private final DataSource dataSource;

	public QuickstartApplication(DataSource dataSource){
		this.dataSource=dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Data Source:"+dataSource.toString());
		JdbcTemplate restTemplate=new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}
