package com.meeplehub.service;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

public class ReportGenerator {

    public ReportGenerator(){
        System.out.println("ReportGenerator created");
    }
    public void generate(){
        System.out.println("Generating report...");
    }
}

