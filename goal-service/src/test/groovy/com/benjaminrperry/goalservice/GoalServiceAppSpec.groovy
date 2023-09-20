package com.benjaminrperry.goalservice

import com.benjaminrperry.goalquest.goalservice.GoalServiceApplication
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = GoalServiceApplication.class)
class GoalServiceAppSpec extends Specification {

    def 'context loads'(){
        true
    }
}