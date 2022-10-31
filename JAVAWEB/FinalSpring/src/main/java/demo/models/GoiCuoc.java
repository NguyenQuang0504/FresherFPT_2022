package demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/*
* @author: QuangNV51
* @since: 2022/10/31 13:29
* @description:
*/
@Entity
public class GoiCuoc {
    @Id
    private String MaGC;

    @Column
    private String tenGC;

    @Column
    private String tocDo;

    @Column
    private Integer giaCuoc;

    @OneToMany(mappedBy = "goiCuoc")
    private List<DangKyDV> dangKyDVS;

    /*
     * @author: QuangNV51
     * @since: 2022/10/31 13:29
     * @description:
     */

    public GoiCuoc(String maGC, String tenGC, String tocDo, Integer giaCuoc, List<DangKyDV> dangKyDVS) {
        MaGC = maGC;
        this.tenGC = tenGC;
        this.tocDo = tocDo;
        this.giaCuoc = giaCuoc;
        this.dangKyDVS = dangKyDVS;
    }

    /*
     * @author: QuangNV51
     * @since: 2022/10/31 13:29
     * @description:
     */

    public GoiCuoc(String maGC, String tenGC, String tocDo, Integer giaCuoc) {
        MaGC = maGC;
        this.tenGC = tenGC;
        this.tocDo = tocDo;
        this.giaCuoc = giaCuoc;
    }

    /*
     * @author: QuangNV51
     * @since: 2022/10/31 13:29
     * @description:
     */

    public GoiCuoc() {
    }

    public String getMaGC() {
        return MaGC;
    }

    public void setMaGC(String maGC) {
        MaGC = maGC;
    }

    public String getTenGC() {
        return tenGC;
    }

    public void setTenGC(String tenGC) {
        this.tenGC = tenGC;
    }

    public String getTocDo() {
        return tocDo;
    }

    public void setTocDo(String tocDo) {
        this.tocDo = tocDo;
    }

    public Integer getGiaCuoc() {
        return giaCuoc;
    }

    public void setGiaCuoc(Integer giaCuoc) {
        this.giaCuoc = giaCuoc;
    }

    public List<DangKyDV> getDangKyDVS() {
        return dangKyDVS;
    }

    public void setDangKyDVS(List<DangKyDV> dangKyDVS) {
        this.dangKyDVS = dangKyDVS;
    }

    /*
     * @author: QuangNV51
     * @since: 2022/10/31 13:29
     * @description:
     */
    @Override
    public String toString() {
        return "GoiCuoc{" +
                "MaGC='" + MaGC + '\'' +
                ", tenGC='" + tenGC + '\'' +
                ", tocDo='" + tocDo + '\'' +
                ", giaCuoc=" + giaCuoc +
                ", dangKyDVS=" + dangKyDVS +
                '}';
    }
}
