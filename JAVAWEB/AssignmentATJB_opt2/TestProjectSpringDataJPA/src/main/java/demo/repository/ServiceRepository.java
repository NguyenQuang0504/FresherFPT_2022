package demo.repository;

import demo.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {

    @Query(value = "SELECT * FROM DichVu WHERE MaDV = ?1", nativeQuery = true)
    Service findByIdDV(String maDV);


    @Query(value = "select * from DichVu order by maDV offset ?1 rows FETCH NEXT ?2 rows only", nativeQuery = true)
    List<Service> getAllPageAble(int i, int size);
}
