package com.benjaminrperry.goalservice

import com.benjaminrperry.client.goal.GoalClient
import com.benjaminrperry.client.goal.configuration.ClientUrlProperties
import com.benjaminrperry.client.goal.rest.RestGoalClient
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@SpringBootTest(classes=TestConfig.class)
class RabbitClientSpec extends Specification {

    @Autowired
    GoalClient goalClient

    def 'can create Goal'() {
        given:
        def description = 'this is a test goal'
        when:
        def result = goalClient.createGoal(description)
        then:
        result.id
        result.description == description
    }

    @Configuration
    static class TestConfig {

        @SpringBean
        RestTemplate restTemplate = new RestTemplate()

        @SpringBean
        ClientUrlProperties clientUrlProperties = new ClientUrlProperties("http://localhost:8080/goal", "http://localhost:8080/goal", "http://localhost:8080/goal/{id}")

        @Bean
        GoalClient goalClient(){
            return new RestGoalClient(restTemplate, clientUrlProperties)
        }

    }



}