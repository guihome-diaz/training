package eu.daxiongmao.springtraining.injection.services;

/**
 * <h1>Example of a Bean factory.</h1>
 * <p>This will <strong>create and return a particular bean depending on the request</strong>.<br>
 * This is very useful when you want to have runtime changes (ex: databases connections / change environment [local, DV, PP, PR, ..]<br>
 * <br>
 * <strong>Careful</strong>: don't forget to call the factory on changes</p>
 * <p>(i) The class isn't annotated, this is manually declared as a Spring bean in the GreetingConfig class</p>
 */
public class GreetingServiceFactory {

    /**
     * To instantiate and return a new bean corresponding to the user request.
     *
     * @param lang ISO lang code 639-1 (3 letters, see https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes)
     * @return instance that to use to match user's request
     * @throws IllegalArgumentException the given code is either invalid or not applicable to the current application
     */
    public GreetingService createGreetingService(final String lang) {
        if (lang == null || lang.trim().isEmpty()) {
            throw new IllegalArgumentException("Factory requires a valid lang code ISO code 639-1 (3 letters).");
        }

        GreetingService service = null;
        switch (lang) {
            case "en":
                service = new GreetingServiceEnImpl();
                break;
            case "fr":
                service = new GreetingServiceFrImpl();
                break;
            case "sv":
                service = new GreetingServiceSvImpl();
                break;
            case "zh":
                service = new GreetingServiceZhImpl();
                break;
            case "de":
                service = new GreetingServiceDeImpl();
                break;
            default:
                throw new IllegalArgumentException("This factory does not support the given lang code: " + lang);
        }
        return service;
    }
}
