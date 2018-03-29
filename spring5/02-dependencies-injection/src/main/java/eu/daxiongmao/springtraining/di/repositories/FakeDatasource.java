package eu.daxiongmao.springtraining.di.repositories;

/**
 * This represents a fake datasource that rely on custom properties defined in #{@link classpath:custom-properties.properties} file.
 *
 * @author Guillaume Diaz, based on Spring 5 "beginner to Guru" training for John Tompson
 * @version 1.0
 * @since 2018-03 : training section 6, lecture 70
 */
public class FakeDatasource {

    private String dbUrl;
    private String dbPassword;
    private String dbUsername;

    public FakeDatasource(final String dbUrl, final String dbPassword, final String dbUsername) {
        this.dbUrl = dbUrl;
        this.dbPassword = dbPassword;
        this.dbUsername = dbUsername;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(final String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(final String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(final String dbUsername) {
        this.dbUsername = dbUsername;
    }

    @Override
    public String toString() {
        return String.format("URL: %s | login: %s", dbUrl, dbUsername);
    }
}
