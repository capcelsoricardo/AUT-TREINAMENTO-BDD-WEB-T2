package curso.treinamento.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/"},
		glue	 = {"curso.treinamento.steps", "curso.treinamento.setup"},
		tags	 = {"@LoginComSucesso"},
		snippets = SnippetType.UNDERSCORE,
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json", 
				"pretty:target/cucumber-pretty.txt", "junit:target/cucumber-results.xml"} 
		
		)

public class RunnerTest {}
