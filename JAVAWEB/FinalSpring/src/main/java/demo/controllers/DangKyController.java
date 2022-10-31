package demo.controllers;

import demo.dto.DangKyDTO;
import demo.models.DangKyDV;
import demo.models.GoiCuoc;
import demo.service.DangKyService;
import demo.service.GoiCuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
/*
* @author: QuangNV51
* @since: 31/10/2022 15:02
* @description:
*/

@Controller
@RequestMapping("/dangKy")
public class DangKyController {
    @Autowired
    private DangKyService dangKyService;

    @Autowired
    private GoiCuocService goiCuocService;

    /*
    * @author: QuangNV51
    * @since: 31/10/2022 15:02
    * @description:
    */
    @GetMapping("/create")
    public String create(Model model){
        DangKyDV dangKyDV = new DangKyDV();
        LocalDate dateDk = java.time.LocalDate.now();
        List<GoiCuoc> goiCuoc = goiCuocService.findAll();
        model.addAttribute("goiCuocs", goiCuoc);
        LocalDate dateKt = dateDk.plusYears(1);
        model.addAttribute("ngayDk", dateDk);
        model.addAttribute("ngayKt", dateKt);
        dangKyDV.setNgayKT(String.valueOf(dateKt));
        model.addAttribute("dangKy", dangKyDV);
        return "create_dk";
    }

    /*
    * @author: QuangNV51
    * @since: 31/10/2022 15:02
    * @description:
    */
    @PostMapping("/save")
    public String save(@ModelAttribute DangKyDV dangKy, Model model){
        GoiCuoc goiCuoc = goiCuocService.findById(dangKy.getGoiCuoc().getMaGC());
        System.out.println(dangKy.getDiaChi());
        Integer giaTriHD = goiCuoc.getGiaCuoc()*12;
        Integer giaTriTT = giaTriHD - (giaTriHD*(dangKy.getChetKhau()/100));
        dangKy.setGiaTriTT(giaTriTT);
        dangKyService.save(dangKy);
        return "redirect:/dangKy/list";
    }

    /*
    * @author: QuangNV51
    * @since: 31/10/2022 15:02
    * @description:
    */
    @GetMapping("/list")
    public String show(Model model){
        List<DangKyDTO> list = dangKyService.find();
        model.addAttribute("goiCuocs", goiCuocService.findAll());
        model.addAttribute("dangKys", list);
        return "list_dk";
    }

    /*
    * @author: QuangNV51
    * @since: 31/10/2022 15:02
    * @description:
    */
    @GetMapping("/search")
    public String search(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){
        String nameKH = httpServletRequest.getParameter("nameKH");
        String nameGC = httpServletRequest.getParameter("nameGC");
        List<DangKyDTO> dangKyDTOList = dangKyService.search(nameKH, nameGC);
        List<DangKyDTO> list = dangKyService.find();
        model.addAttribute("goiCuocs", goiCuocService.findAll());
        model.addAttribute("dangKys", dangKyDTOList);
        return "list_dk";
    }

    /*
    * @author: QuangNV51
    * @since: 31/10/2022 15:57
    * @description:
    */
    @GetMapping("/update")
    public String update(@RequestParam("maKH") String maKH, Model model){
        System.out.println(maKH);
        DangKyDV dangKyDV = dangKyService.findDK(maKH);
        List<GoiCuoc> goiCuoc = goiCuocService.findAll();
        System.out.println(dangKyDV.getDiaChi());
        model.addAttribute("goiCuocs", goiCuoc);
        model.addAttribute("dangKy", dangKyDV);
        return "update_dk";
    }

    /*
    * @author: QuangNV51
    * @since: 31/10/2022 16:04
    * @description: 
    */
    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute DangKyDV dangKy, Model model){
        GoiCuoc goiCuoc = goiCuocService.findById(dangKy.getGoiCuoc().getMaGC());
        System.out.println(dangKy.getDiaChi());
        Integer giaTriHD = goiCuoc.getGiaCuoc()*12;
        Integer giaTriTT = giaTriHD - (giaTriHD*(dangKy.getChetKhau()/100));
        dangKy.setGiaTriTT(giaTriTT);
        dangKyService.save(dangKy);
        model.addAttribute("message", "Update success!!!");
        List<DangKyDTO> list = dangKyService.find();
        model.addAttribute("goiCuocs", goiCuocService.findAll());
        model.addAttribute("dangKys", list);
        return "list_dk";
    }
}
