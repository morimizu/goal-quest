package com.benjaminrperry.goalservice

import com.benjaminrperry.client.goal.GoalClient
import com.benjaminrperry.goalquest.goalservice.GoalServiceApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = GoalServiceApplication.class)
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

}