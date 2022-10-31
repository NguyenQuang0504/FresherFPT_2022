package demo.controllers;

import demo.models.DangKyThueXe;
import demo.models.XeThue;
import demo.service.DangKyThueXeService;
import demo.service.XeThueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private XeThueService xeThueService;

    @Autowired
    private DangKyThueXeService dangKyThueXeService;

    @GetMapping("/creat")
    public String creat(Model model){
        List<XeThue> xeThues = xeThueService.findAll();
        model.addAttribute("xeThues", xeThues);
        model.addAttribute("dangKy", new DangKyThueXe());
        return "dang_ky_thue_xe";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute DangKyThueXe dangKy, Model model) throws ParseException {
        System.out.println(dangKy.toString());
        XeThue xeThue = xeThueService.findById(dangKy.getXeThue().getMaXe());

        // set total Money
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = format.parse(dangKy.getGioKT());
        Date date2 = format.parse(dangKy.getGioBD());
        long time = date1.getTime() - date2.getTime();
        Double hourUse = Double.valueOf(time/(60 * 60 * 1000) % 24);
        Double total = hourUse*xeThue.getDonGia();
        System.out.println("Gio sd: " +hourUse);

        // set khuyen mai
        String date = String.valueOf(dangKy.getNgayThue());
        LocalDate localDate1 = LocalDate.parse(date,
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //get thu trong tuan
        DayOfWeek dayOfWeek = DayOfWeek.from(localDate1);
        System.out.println("Thu trong tuan: "+dayOfWeek.name());
        if (dayOfWeek.name() != "SUNDAY" && dayOfWeek.name() != "SATURDAY"){
            Double km = total*(0.1);
            System.out.println(km);
            total = (total - km);
        }
        //
        dangKy.setTongTien(total);
        dangKyThueXeService.save(dangKy);
        return "redirect:/home/list";
    }

    @GetMapping("/list")
    public String showList(Model model){
        List<DangKyThueXe> dangKyThueXeList = dangKyThueXeService.findAll();
        model.addAttribute("dangKys", dangKyThueXeList);
        return "ds_dang_ky";
    }

}
