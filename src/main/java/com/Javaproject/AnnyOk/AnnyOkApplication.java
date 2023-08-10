package com.Javaproject.AnnyOk;

import com.Javaproject.AnnyOk.datasource.PostgresDatasource;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;

@SpringBootApplication
public class AnnyOkApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnyOkApplication.class, args);
	}

//	@Bean
//	public JdbcTemplate jdbcTemplate (HikariDataSource datasource) {
//		return new JdbcTemplate((Connection) datasource);
//	}

}
