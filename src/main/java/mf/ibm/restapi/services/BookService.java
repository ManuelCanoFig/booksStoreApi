package mf.ibm.restapi.services;

import mf.ibm.restapi.model.Book;
import mf.ibm.restapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> listAllBooks(){
        return  bookRepository.findAll();

    }
    public List<Book> listAllBooksAsc(){
        return  bookRepository.findAll(Sort.by("publicationYear").ascending());

    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }


    public  int vowels(char c){
        if(c == 'A' || c == 'a' || c == 'E' ||  c == 'e' || c == 'I' ||  c == 'i' ||  c == 'O' || c =='o' || c =='U' || c =='u'){
            return  1;
        }else{
            return 0;
        }
    }

    public int countVowels(String str, int strLength){
        //System.out.println(strLength);
        //Base Case
        if(strLength == 1){
            return vowels(str.charAt(strLength-1));
        }

        //System.out.println(countVowels(str, strLength - 1));
        //System.out.println(sum);
       //System.out.println(strLength - 1);
        return countVowels(str, strLength - 1) + vowels(str.charAt(strLength - 1));
    }
}
