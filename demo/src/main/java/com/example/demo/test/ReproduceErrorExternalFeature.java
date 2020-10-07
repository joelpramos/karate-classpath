package com.example.demo.test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Controller;

@Controller
public class ReproduceErrorExternalFeature implements ApplicationListener<ApplicationReadyEvent> {


    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        // note this file is successfully loadedsys
        // but the call of framework-utils.feature from karate-config.js is not

        if (System.getProperty("external.feature") != null) {
            System.out.println("External property " + System.getProperty("external.feature"));

            Runner.Builder runnerBuilder = Runner.path(System.getProperty("external.feature"));
            Results results = runnerBuilder.parallel(1);
        } else {
            System.out.println("skipping as external feature is missing");
        }
    }
}
