package eu.daxiongmao.springtraining.chuck.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

/**
 * Chuck Norris jokes and facts - because you can always learn from the best there is! :D
 */
@Service
public class ChuckNorrisJokeService implements JokeService {

    @Override
    public String getJoke() {
        ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();
        return chuckNorrisQuotes.getRandomQuote();
    }
}
