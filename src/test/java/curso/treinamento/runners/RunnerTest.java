package curso.treinamento.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/"},
		glue	 = {"curso.treinamento.steps", "curso.treinamento.setup"},
		tags	 = {"@LoginComSucesso or @LoginInvalido"},
		snippets = SnippetType.UNDERSCORE,
		monochrome = true,
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"} 
		
		)

public class RunnerTest {}
