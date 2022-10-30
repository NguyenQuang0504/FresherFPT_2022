package demo.repository;

import demo.models.UseMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseMachineRepository extends JpaRepository<UseMachine, String> {
}
