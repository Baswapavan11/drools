package com.droolsruleengine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //
    @Column( columnDefinition = "TEXT", nullable = false)

    private String rule;
    //
    private String ruleName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Rules(long id, String rule, String ruleName) {
        super();
        this.id = id;
        this.rule = rule;
        this.ruleName = ruleName;
    }

    @Override
    public String toString() {
        return "Rules [id=" + id + ", rule=" + rule + ", ruleName=" + ruleName + "]";
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Rules() {
        super();
        // TODO Auto-generated constructor stub
    }

}
