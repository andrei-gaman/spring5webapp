package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("Alex", "address", "Aspen", "607220");
        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Metro", "123");

        publisherRepository.save(publisher);

        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);

        authorRepository.save(eric);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("Exodus", "12313123");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);
        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);

        authorRepository.save(rod);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());

    }
}
