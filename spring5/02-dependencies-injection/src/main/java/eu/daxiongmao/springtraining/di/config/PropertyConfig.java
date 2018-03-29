package eu.daxiongmao.springtraining.di.config;

import eu.daxiongmao.springtraining.di.repositories.FakeDatasource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Configuration class to interact with application's properties files: embedded or external.<br>
 * You need to add in "propertySource" all embedded properties to load from src∕main∕resources
 */
@Configuration
@PropertySource("classpath:/custom-properties.properties")
public class PropertyConfig {

    @Value("${db.datasource.username}")
    private String dbDatasourceUsername;

    @Value("${db.datasource.password}")
    private String dbDatasourcePassword;

    @Value("${db.datasource.url}")
    private String dbDatasourceUrl;


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
}
