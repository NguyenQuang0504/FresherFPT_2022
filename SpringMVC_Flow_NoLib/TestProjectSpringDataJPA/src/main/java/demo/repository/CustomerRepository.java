package demo.repository;

import demo.dto.CustomerUseDTO;
import demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "SELECT * FROM KhachHang WHERE MaKH = ?1", nativeQuery = true)
    Customer find(String maKH);

    @Query(value = "select * from KhachHang order by maKH offset ?1 rows FETCH NEXT ?2 rows only", nativeQuery = true)
    List<Customer> findAllPageAble(int current, int size);

    @Transactional
    @Modifying
    @Query(value = "SELECT KhachHang.tenKH, KhachHang.maKH, May.maMay, May.viTri, May.trangThai, SuDungMay.ngayBD, SuDungMay.gioBD,\n" +
            "SuDungMay.thoigianSD, SuDungDV.MaDV, SuDungDV.ngaySD, SuDungDV.gioSD, SuDungDV.soLuong FROM KhachHang INNER JOIN SuDungDV ON KhachHang.maKH = SuDungDV.maKH\n" +
            "INNER JOIN SuDungMay ON KhachHang.maKH = SuDungMay.maKH INNER JOIN May ON May.maMay = SuDungMay.maMay;", nativeQuery = true)
    List<CustomerUseDTO> getAllCustomerUse();
}
