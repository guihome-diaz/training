package eu.daxiongmao.springtraining.di;

import eu.daxiongmao.springtraining.di.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependenciesInjectionApplication {

	public static void main(String[] args) {
		// Default Spring Boot launcher that returns the loaded context
        ApplicationContext appContext  = SpringApplication.run(DependenciesInjectionApplication.class, args);

        // ****** Basic dependency injection example **********
        // Retrieve instance by type
        MyController myController1 = appContext.getBean(MyController.class);
        // retrieve instance by name (spring use camelCase by default)
        MyController myController2 = (MyController) appContext.getBean("myController");

        // Control that both objects refers to the same instance
        if (myController1.hashCode() == myController2.hashCode()) {
            System.out.println(myController1.helloWorld());
        } else {
            throw new IllegalStateException("We expect the different references to point to the same object. Your configuration is wrong.");
        }

    }
}
