package com.ccdev.springdatajpa.testing;

import com.ccdev.springdatajpa.entities.entity2.Author;
import com.ccdev.springdatajpa.entities.entity2.Book;
import com.ccdev.springdatajpa.repositories.repository2.AuthorRepository;
import com.ccdev.springdatajpa.repositories.repository2.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Component
public class testing2 implements CommandLineRunner {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;


    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setName("Author");

        Book book1 = new Book();
        book1.setName("Cien años de soledad");

        Book book2 = new Book();
        book2.setName("El general en su laberinto");

        author.getBooks().add(book1);
        author.getBooks().add(book2);

        authorRepository.save(author);

        Optional<Author> authorSaved = authorRepository.findById(author.getId());
        authorSaved.ifPresent(a ->{
            System.out.println("Author ID: "+ a.getId());

            a.setName("Gabriel Garcia Marquez ");
            authorRepository.save(a);

            System.out.println("Update Name: "+a.getName());
        });

        List<Author> authors = authorRepository.findAll();
        System.out.println("Authors List");
        for(Author a:authors){
            System.out.println(a.getName());
        }

        authorRepository.delete(author);
        System.out.println("author deleted");
    }
}
