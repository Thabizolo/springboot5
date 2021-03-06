package guru.springframework.spring5webapp.controllers;


import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/book")
    public String getBook(Model model){
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
