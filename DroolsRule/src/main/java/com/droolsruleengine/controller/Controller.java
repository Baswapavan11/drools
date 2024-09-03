package com.droolsruleengine.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import com.droolsruleengine.model.Driver;
import com.droolsruleengine.model.Order;
import com.droolsruleengine.model.Rules;
import com.droolsruleengine.repository.RulesRepo;

import jakarta.websocket.server.PathParam;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {


    @Autowired
    private RulesRepo repo;

    /**
     *
     * @param id
     * @return
     */
    public String getStringrule(Long id) {
        StringBuilder rulest = new StringBuilder();
        Optional<Rules> rules = repo.findById(id);
        Rules rul = rules.get();
        rulest.append(rul.getRule()).append("\n");
        return rulest.toString();
    }

    //endpoint to run the rules of order
    @PostMapping("/order")
    public Order orderNow(@RequestBody Order order,@RequestParam Long id) {
//		long p = 2;
        KieSession kieSession = getKieSession(id);
        kieSession.insert(order);
        kieSession.fireAllRules();
        return order;
    }

    // endpoint to run the rules of driver
    @PostMapping("/driver")
    public Driver incentive(@RequestBody Driver driver,@RequestParam Long id) {
        KieSession kieSession = getKieSession(id);
        kieSession.insert(driver);
        kieSession.fireAllRules();
        return driver;
    }
    
    @GetMapping("/testing")
    public String getData() throws InterruptedException{
    	System.out.println("java");
    	Thread.sleep(10000);
    	System.out.println("compiler");
    	return "data";
    }
    /**
     *
     * @param id
     * @return
     */
    public KieSession getKieSession(Long id) {
    	
        String rules = getStringrule(id);
        File file = new File("src/main/resources/rules.drl");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(rules);
            System.out.println("DRL file written successfully: "+ "Peak Hour Pricing");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(rules);
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("rules.drl"));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        KieContainer kiecontainer = kieServices.newKieContainer(kieModule.getReleaseId());
        return kiecontainer.newKieSession();

    }

    @PostMapping("addRule")
    public Rules addRules(@RequestBody Rules rules) {
     return repo.save(rules);
    }
}