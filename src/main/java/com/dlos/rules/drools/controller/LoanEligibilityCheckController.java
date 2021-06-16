package com.dlos.rules.drools.controller;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlos.rules.drools.config.DroolsAutoConfiguration;
import com.dlos.rules.drools.domain.LoanEligibilityCheck;

@RestController
public class LoanEligibilityCheckController {
	
	private final Logger log = LogManager.getLogger(LoanEligibilityCheckController.class);


    private final KieContainer kieContainer;

    public LoanEligibilityCheckController(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @RequestMapping(value = "/loanDeviation", method = RequestMethod.GET, produces = "application/json")
    public LoanEligibilityCheck getQuestions(@RequestParam(required = true) Integer creditScore, @RequestParam(required = true) Integer income) {
    	
    	LoanEligibilityCheck loanEligibilityReq = new LoanEligibilityCheck(creditScore,income);
            	
    	KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(loanEligibilityReq);
        
        int ruleFiredCount = kieSession.fireAllRules();
        
        kieSession.dispose();
        
        log.info("Total Rules Fired: "+ ruleFiredCount);
        
       
        
        return loanEligibilityReq;
    }
}
