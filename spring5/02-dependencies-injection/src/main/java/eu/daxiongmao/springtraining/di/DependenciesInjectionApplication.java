package eu.daxiongmao.springtraining.di;

import eu.daxiongmao.springtraining.di.controllers.MyController;
import eu.daxiongmao.springtraining.di.repositories.FakeDatasource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// By default spring boot's component scan search for beans in the package and sub-packages of the @springBootApplication
// (i) To add other package you can use a custom component scan. You must add the same trick on the jUnits !
// Be careful !! This is an override: you must add again the root package as well
@ComponentScan(basePackages = {"eu.daxiongmao.springtraining.injection.services", "eu.daxiongmao.springtraining.di"})
public class DependenciesInjectionApplication {

    public static void main(final String[] args) {
        // Default Spring Boot launcher that returns the loaded context
        final ApplicationContext appContext = SpringApplication.run(DependenciesInjectionApplication.class, args);

        // ****** Basic dependency injection example: get annotated beans **********
        // Retrieve instance by type
        final MyController myController1 = appContext.getBean(MyController.class);
        // retrieve instance by name (spring use camelCase by default)
        final MyController myController2 = (MyController) appContext.getBean("myController");

        // Control that both objects refers to the same instance
        if (myController1.hashCode() == myController2.hashCode()) {
            System.out.println(myController1.helloWorld());
        } else {
            throw new IllegalStateException("We expect the different references to point to the same object. Your configuration is wrong.");
        }


        // ******** Another example: get beans that are declared in the @Configuration class *********
        final FakeDatasource fakeDatasource = (FakeDatasource) appContext.getBean(FakeDatasource.class);
        System.out.println(fakeDatasource.toString());


        // ******** Advanced dependency injection *********


    }
}
