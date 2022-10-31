package demo.repository;

import demo.models.GoiCuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoiCuocRepository extends JpaRepository<GoiCuoc, String> {
    @Query(value = "SELECT * FROM GoiCuoc WHERE MaGC = ?1", nativeQuery = true)
    GoiCuoc getGoiCuoc(String maGC);
}
