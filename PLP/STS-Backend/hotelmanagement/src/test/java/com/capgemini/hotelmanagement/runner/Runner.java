package com.capgemini.hotelmanagement.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(features="Features", glue={"com.capgemini.hotelmanagement"})
public class Runner extends AbstractTestNGCucumberTests {
	
}
