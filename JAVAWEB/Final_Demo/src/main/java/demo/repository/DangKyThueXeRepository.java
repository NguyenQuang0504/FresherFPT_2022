package demo.repository;

import demo.models.DangKyThueXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DangKyThueXeRepository extends JpaRepository<DangKyThueXe, String> {
}
