package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class BootstrapDev implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public BootstrapDev(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }



    private void initData(){

        //p Publisher
        Publisher publisher = new Publisher();
        publisher.setName("Harper Collins");
        publisher.setAddress("Harper Collins Publishers, 195 Broadway, New York, NY 10007");
        publisherRepository.save(publisher);


        //p Eric
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain driven Design","1234", publisher);
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);


        //p Publisher
        Publisher publisher1 = new Publisher();
        publisher1.setName("John Willey & Sons");
        publisher1.setAddress("111 River Street Hoboken, NJ 07030-5774");
        publisherRepository.save(publisher1);

        //p Rod
        Author rod = new Author("Rod", "Johnson");
        Book book1 = new Book("J2EE Development without using EJBs",  "23444", publisher1);
        rod.getBooks().add(book1);
        book1.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(book1);


    }


}
