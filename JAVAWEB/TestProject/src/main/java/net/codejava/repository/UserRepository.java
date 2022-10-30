package net.codejava.repository;

import net.codejava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM UserLogin WHERE id=?1", nativeQuery = true)
    User getById(int id);

    @Query(value = "UPDATE UserLogin SET userName = ?2, password = ?3 WHERE id = ?1", nativeQuery = true)
    void update(int id, String userName, String password);

    @Query(value = "SElECT * FROM UserLogin WHERE userName LIKE %?1%", nativeQuery = true)
    List<User> search(String keyword);
}
