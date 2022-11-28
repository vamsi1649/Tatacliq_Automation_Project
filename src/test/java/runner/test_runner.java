package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/brands/brands.feature"}, glue="definition",plugin= {"html:testoutput/cucumber1.html"})
public class test_runner  {
	
}