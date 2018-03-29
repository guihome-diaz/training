package eu.daxiongmao.springtraining.di.repositories;

public class FakeJms {

    private String dbUrl;
    private String dbPassword;
    private String dbUsername;

    public FakeJms(final String dbUrl, final String dbPassword, final String dbUsername) {
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
