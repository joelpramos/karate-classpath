package com.example.demo.test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Controller;

@Controller
public class ReproduceErrorLoadingFeature implements ApplicationListener<ApplicationReadyEvent> {


    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        // note this file is successfully loadedsys
        // but the call of framework-utils.feature from karate-config.js is not

        //System.out.println("External property " + System.getProperty("external.feature"));
        if(System.getProperty("external.feature") == null) {
            System.out.println("testing as external.feature JVM property is null");
            Runner.Builder runnerBuilder = Runner.path("classpath:test-feature.feature");
            Results results = runnerBuilder.parallel(1);
        }
    }
}
