package eu.daxiongmao.springtraining.chuck.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

/**
 * Chuck Norris jokes and facts - because you can always learn from the best there is! :D
 */
@Service
public class ChuckNorrisJokeService implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    /**
     * To autowired the spring bean that is declared in the Java config class.
     * @param chuckNorrisQuotes spring bean to inject
     */
    public ChuckNorrisJokeService(ChuckNorrisQuotes chuckNorrisQuotes) {
        this.chuckNorrisQuotes = chuckNorrisQuotes;
    }

    @Override
    public String getJoke() {
        // You can either instantiate the class manually (cf below) or use a Spring bean (current code)
        //ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();
        return chuckNorrisQuotes.getRandomQuote();
    }
}
