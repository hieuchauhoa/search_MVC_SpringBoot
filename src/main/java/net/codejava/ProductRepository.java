package net.codejava;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//ham search, file nay giong DAL, chua cac cau truy van sql lay data tu DB
public interface ProductRepository extends JpaRepository<Product, Long> {
     
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
            + " OR p.brand LIKE %?1%"
            + " OR p.madein LIKE %?1%"
            + " OR CONCAT(p.price, '') LIKE %?1%")
    public List<Product> search(String keyword);

}
