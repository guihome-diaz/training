package eu.daxiongmao.springtraining.spring5webapp.bootstrap;

import eu.daxiongmao.springtraining.spring5webapp.model.Author;
import eu.daxiongmao.springtraining.spring5webapp.model.Book;
import eu.daxiongmao.springtraining.spring5webapp.repositories.AuthorRepository;
import eu.daxiongmao.springtraining.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * To populate the database with fake content on application's startup.
 */
@Component
public class FakeDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    /**
     * Complete constructor.
     * This is how you can inject beans instead of using @Autowired with spring (since Spring 4.3)
     * @param authorRepository author repository bean
     * @param bookRepository book repository bean
     */
    public FakeDataBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // Method called on application startup.
        initData();
    }


    public void initData() {
        /* You must always persist data in the following order:

        ### Actions:
        - Create the author                     - Create object 1  # 'mappedBy' object: @ManyToMany(mappedBy = "authors")
        - Save the author in DB                 - Persist object 1
        ### Output:
        - 1 author in DB                        - 1 new entity saved

        ### Actions:
        - Create books                          - Create object 2  # Object with @JoinColumn defintion
        - Bind book-author                      - Do the binding on object 2 (because we're going to save it)
        - Save book                             - Save object 2
        ### Output:
        - 1 book + 1 relation                   - 1 new entity + 1 relation between object 1 and 2
         */

        // ***** NOMINAL examples *****
        // "Bilateral" association (actually the association is done through the last element "lEtranger").
        // Binding only occurs when you persist the 2nd end of the association
        Author camus = new Author("Albert", "Camus");
        Book lEtranger = new Book("L'Étranger", "9782070306022", "Gallimard");
        lEtranger.getAuthors().add(camus);
        camus.getBooks().add(lEtranger);
        authorRepository.save(camus);
        bookRepository.save(lEtranger);

        // Single association
        Author stExupery = new Author("Antoine", "de Saint-Exupéry");
        authorRepository.save(stExupery);
        Book petitPrince = new Book("Le petit prince", "9782070612758", "Gallimard");
        petitPrince.getAuthors().add(stExupery);
        bookRepository.save(petitPrince);

        // Multiple associations to 1 author
        Author dumas = new Author("Alexandre", "Dumas");
        authorRepository.save(dumas);
        Book mousquetaires = new Book("Les 3 mousquetaires", "9788853009050", "Hachette");
        mousquetaires.getAuthors().add(dumas);
        bookRepository.save(mousquetaires);
        Book monteCristo = new Book("Le compte de Monte-Cristo", "9782013225021", "Hachette");
        monteCristo.getAuthors().add(dumas);
        bookRepository.save(monteCristo);
        Book margot = new Book("La reine Margot", "9782715213630", "Flammarion");
        margot.getAuthors().add(dumas);
        bookRepository.save(margot);


        // ***** ERROR examples *****
        // Book is saved before the author!
        // Association will not work because the @JoinColumn entity was saved first
        Book miserables = new Book("Les Misérables", "9782035834256", "Flammarion");
        bookRepository.save(miserables);
        Author hugo = new Author("Victor", "Hugo");
        hugo.getBooks().add(miserables);
        authorRepository.save(hugo);

        // No binding because books aren't saved
        Book traiteTolerance = new Book("Traité sur la tolérance", "9782290075289", "Larousse");
        Book candide = new Book("Candide ou l'optimisme", "9782070413751", "Larousse");
        Author voltaire = new Author("", "Voltaire");
        voltaire.getBooks().add(traiteTolerance);
        voltaire.getBooks().add(candide);
        authorRepository.save(voltaire);
    }

}
