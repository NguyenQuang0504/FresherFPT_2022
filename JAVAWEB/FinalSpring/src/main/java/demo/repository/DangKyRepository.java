package demo.repository;

import demo.dto.DangKyDTO;
import demo.models.DangKyDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DangKyRepository extends JpaRepository<DangKyDV, String> {

    @Transactional
    @Modifying
    @Query(value = "SELECT DangKyDV.maKH, DangKyDV.hoTen, DangKyDV.sdt, DangKyDV.giaTriTT, GoiCuoc.MaGC, GoiCuoc.tenGC, GoiCuoc.tocDo, GoiCuoc.giaCuoc FROM DangKyDV" +
            " INNER JOIN GoiCuoc ON DangKyDV.MaGC = GoiCuoc.MaGC", nativeQuery = true)
    List<DangKyDTO> find();



    @Transactional
    @Modifying
    @Query(value = "SELECT DangKyDV.maKH, DangKyDV.hoTen, DangKyDV.sdt, DangKyDV.giaTriTT, GoiCuoc.MaGC, GoiCuoc.tenGC, GoiCuoc.tocDo, GoiCuoc.giaCuoc FROM DangKyDV" +
            " INNER JOIN GoiCuoc ON DangKyDV.MaGC = GoiCuoc.MaGC WHERE DangKyDV.hoTen LIKE ?1 AND  GoiCuoc.tenGC LIKE ?2", nativeQuery = true)
    List<DangKyDTO> search(String nameKH, String nameGC);

    @Transactional
    @Query(value = "SELECT * FROM DangKyDV WHERE maKH = ?1", nativeQuery = true)
    DangKyDV getKH(String maKH);
}
