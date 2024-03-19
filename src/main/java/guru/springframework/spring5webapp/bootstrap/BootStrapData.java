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
        Publisher java = new Publisher("Java", "Brazil","street","123", "123");
        publisherRepository.save(java);


        Author eric  = new Author("Eric", "Legrande");
        Book ddd = new Book("Domain Driver Design", "157842963");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(java);
        java.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(java);

        Author jacques  = new Author("Jacques", "Costeau");
        Book noEJB = new Book("J2EE", "785214963");
        jacques.getBooks().add(noEJB);
        noEJB.getAuthors().add(jacques);
        noEJB.setPublisher(java);
        java.getBooks().add(noEJB);
        authorRepository.save(jacques);
        bookRepository.save(noEJB);
        publisherRepository.save(java);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books:" + bookRepository.count() );


        System.out.println("Number of Publishers:" + publisherRepository.count() );
        System.out.println("Number of Publisher Books:" + java.getBooks().size());

        System.out.println("Number of Authors:" + authorRepository.count() );

    }
}
