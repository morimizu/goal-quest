package com.benjaminrperry.goalservice

import com.benjaminrperry.goalservice.messaging.RabbitGoalClient
import com.benjaminrperry.goalservice.service.GoalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = GoalServiceApplication.class)
class RabbitClientSpec extends Specification {
    @Autowired
    RabbitGoalClient rabbitGoalClient

    def 'can create Goal'() {
        given:
        def description = 'this is a test goal'
        when:
        def result = rabbitGoalClient.createGoal(description)
        then:
        result.id
        result.description == description
    }

}