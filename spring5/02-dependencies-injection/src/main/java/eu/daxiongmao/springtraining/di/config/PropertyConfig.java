package eu.daxiongmao.springtraining.di.config;

import eu.daxiongmao.springtraining.di.repositories.FakeDatasource;
import eu.daxiongmao.springtraining.di.repositories.FakeJms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * Configuration class to interact with application's properties files: embedded or external.<br>
 * You need to add in "propertySource" all embedded properties to load from src∕main∕resources.<br>
 * <br>
 * You don't need to add the default spring's "application.properties" and "application.yml" files: they will be loaded
 * automatically - no matter what!
 */
@Configuration
//@PropertySource({"classpath:/datasource.properties", "classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    /**
     * to access OS environment variables, if need be.
     */
    @Autowired
    Environment env;

    // Important note!
    // Each property "db.datasource.username" can be override by the O.S environment variable DB_DATASOURCE_USERNAME.

    @Value("${db.datasource.username}")
    private String dbDatasourceUsername;

    @Value("${db.datasource.password}")
    private String dbDatasourcePassword;

    @Value("${db.datasource.url}")
    private String dbDatasourceUrl;


    @Value("${jms.username}")
    private String jmsUsername;

    @Value("${jms.password}")
    private String jmsPassword;

    @Value("${jms.url}")
    private String jmsUrl;

    @Value("${developer.mood}")
    private String developerMood;

    /**
     * <p>
     * This will actually read the files on application startup and load the properties into the spring context.<br>
     * You can retrieve properties with springEl: @Value("${myProp}")
     * </p>
     * <p>
     * <strong>You must use a STATIC bean!</strong><br>
     * See <a href="https://stackoverflow.com/questions/30874244/bean-annotation-on-a-static-method">Stack-overflow discussion</a><br>
     * <quote>Special consideration must be taken for @Bean methods that return Spring BeanFactoryPostProcessor (BFPP) types.
     * Because BFPP objects must be instantiated very early in the container lifecycle, they can interfere with
     * processing of annotations such as @Autowired, @Value, and @PostConstruct within @Configuration classes.
     * To avoid these lifecycle issues, mark BFPP-returning @Bean methods as static</quote>
     * </p>
     *
     * @return application's properties loader
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer getApplicationProperties() {
        final PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        // TODO add here custom configuration to load many files at once, set the encoding, no error on missing files, etc.
        return propertySourcesPlaceholderConfigurer;
    }

    /**
     * @return fake datasource that relies on external file's properties
     */
    @Bean
    public FakeDatasource getFakeDatasource() {
        return new FakeDatasource(dbDatasourceUrl, dbDatasourcePassword, dbDatasourceUsername);
    }

    /**
     * @return fake JMS that relies on external file's properties
     */
    @Bean
    public FakeJms getFakeJms() {
        return new FakeJms(jmsUrl, jmsPassword, jmsUsername);
    }
}
