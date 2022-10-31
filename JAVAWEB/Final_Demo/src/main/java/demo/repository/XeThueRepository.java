package demo.repository;

import demo.models.XeThue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface XeThueRepository extends JpaRepository<XeThue, String> {
    @Query(value = "SELECT * FROM XeThue WHERE maXe = ?1", nativeQuery = true)
    XeThue findByIdXeThue(String id);
}
