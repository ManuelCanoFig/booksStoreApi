package mf.ibm.restapi.repositories;

import mf.ibm.restapi.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Integer> {
}
