package mf.ibm.restapi.repositories;

import mf.ibm.restapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
