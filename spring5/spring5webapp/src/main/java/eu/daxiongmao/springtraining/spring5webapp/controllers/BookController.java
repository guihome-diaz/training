package eu.daxiongmao.springtraining.spring5webapp.controllers;

import eu.daxiongmao.springtraining.spring5webapp.model.Book;
import eu.daxiongmao.springtraining.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    /**
     * Complete constructor that Spring will use for IoC
     */
    public BookController(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * To get the list of books and embedded that data into the query model ; then return the name of the view to display
     *
     * @param model Spring MVC - query model
     * @return view to display
     */
    @RequestMapping("/books")
    public String getBooks(final Model model) {
        // retrieve DB data
        final List<Book> books = bookRepository.findAll();
        // forward data to the client (=> put it into the Model DTO as 'books')
        model.addAttribute("books", books);
        // name of the view to display
        return "books";
    }
}
