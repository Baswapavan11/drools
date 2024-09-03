package com.droolsruleengine.configuration;


import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/*
@Configuration
public class DroolConfig {

    private KieServices kieServices = KieServices.Factory.get();



    */
/**
     *
     * @return
     * @throws IOException
     *//*

    // Method to create and return a KieFileSystem containing the DRL file
    private KieFileSystem getKieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("offer.drl")); // Load DRL file from classpath
        return kieFileSystem;
    }

    */
/**
     *
     * @return
     * @throws IOException
     *//*

    // Bean to create and return a KieContainer, which is a repository of all
    // KieBase instances
    @Bean
    public KieContainer getKieContainer() throws IOException {
        System.out.println("Container created");
        KieFileSystem kieFileSystem = getKieFileSystem();
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem).buildAll(); // Build all KieBases in the KieFileSystem
        KieModule kieModule = kb.getKieModule(); // Get the KieModule from the KieBuilder
        return kieServices.newKieContainer(kieModule.getReleaseId()); // Create a KieContainer with the KieModule
    }

    // Bean to create and return a KieSession, which is used to interact with the
    // rules
    @Bean
    public KieSession getKieSession() throws IOException {
        System.out.println("Session created...");
        return getKieContainer().newKieSession(); // Create a new KieSession from the KieContainer
    }
    
    
}*/
