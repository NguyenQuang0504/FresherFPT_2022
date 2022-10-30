package demo.repository;

import demo.models.UseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseServiceRepository extends JpaRepository<UseService, String> {
}
