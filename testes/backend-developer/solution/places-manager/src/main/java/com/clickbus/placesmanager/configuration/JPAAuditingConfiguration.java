package com.clickbus.placesmanager.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.clickbus.placesmanager.repository"})
@EnableJpaAuditing
@EntityScan(basePackages = {"com.clickbus.placesmanager.entities"})
@Configuration
public class JPAAuditingConfiguration {
}
