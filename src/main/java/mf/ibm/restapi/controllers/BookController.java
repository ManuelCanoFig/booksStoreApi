package mf.ibm.restapi.controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import mf.ibm.restapi.model.Book;
import mf.ibm.restapi.services.BookService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("")
    public List<Book> getBooks(){
        return bookService.listAllBooks();
    }

    @PostMapping("")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        if (!book.getTitle().isEmpty() && !book.getAuthor().isEmpty() && !book.getPublisher().isEmpty()) {
            bookService.saveBook(book);
            return ResponseEntity.status(HttpStatus.OK).body("Book added");
        }else{
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body("Bad request");
        }

    }


    @GetMapping("/getEvenBooks")
    public  ResponseEntity<?> getEvenBooks(){
        List<Book> books = bookService.listAllBooks();
        //Creating JSON array
        JSONArray jo1 = new JSONArray();

        for(Book book : books){
            //System.out.println("Count vowels"+ bookService.countVowels(book.getTitle() ,book.getTitle().length()));
            int sumVowel = bookService.countVowels(book.getTitle(),book.getTitle().length());
            System.out.println("Title: "+book.getTitle()+", sum of vowels "+ sumVowel);
            //Adding json objects to json array, we add only the ones with even publicationYear.
            JSONObject jo = new JSONObject();
            if(sumVowel%2 == 0){
                jo.put("title",book.getTitle());
                jo.put("vowels", sumVowel);
                jo.put("publicationYear",book.getPublicationYear());
                jo1.put(jo);
            }
        }

       return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jo1.toString());
    }

}
