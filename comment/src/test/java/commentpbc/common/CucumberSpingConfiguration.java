package commentpbc.common;

import commentpbc.CommentApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CommentApplication.class })
public class CucumberSpingConfiguration {}
