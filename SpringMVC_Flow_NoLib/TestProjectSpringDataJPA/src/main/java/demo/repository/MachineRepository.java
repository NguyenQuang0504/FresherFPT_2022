package demo.repository;

import demo.models.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine, String> {

    @Query(value = "SELECT * FROM May WHERE MaMay = ?1", nativeQuery = true)
    Machine find(String maMay);

    @Query(value = "select * from May order by maMay offset ?1 rows FETCH NEXT ?2 rows only", nativeQuery = true)
    List<Machine> getAllPageAble(int i, int size);
}
