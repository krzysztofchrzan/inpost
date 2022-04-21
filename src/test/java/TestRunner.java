import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features/" },
        plugin = {
                "pretty",
                "json:target/reports/json/report.json",
                "html:target/reports/html/report.html",
        },
        glue = { "gui", "api" }
)
public class TestRunner {}
