package packageTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.util.Date;
import java.util.Scanner;

public class TestJavaDateTime {
    public static void main(String[] args) {
        //Date
        LocalDate date = LocalDate.now();

        // Lay ra ngay tu LocalDate
        System.out.println("Ngay :" + date.getDayOfMonth());

        //Lay ra thang tu LocalDate
        System.out.println("Thang :" + date.getMonthValue());

        // lay ra nam tu LocalDate
        System.out.println("Nam:" + date.getYear());

        //Lay thu trong tuan
        System.out.println("Thu: " + date.getDayOfWeek());

        // Lay so ngay lon nhat va nho nhat cua thang
        System.out.println("Ngay nhieu nhat:" +date.getMonth().maxLength());
        System.out.println("Ngay it nhat: " +date.getMonth().minLength());

        //Chuyen doi format
        System.out.println("Sau khi format: " +date.format(DateTimeFormatter.BASIC_ISO_DATE));

        // Lay ngay hien tai cong them 30 ngay
        System.out.println("Ngay hien tai them 30 day:" + date.plusDays(30));

        //Lay ngay hien tai tru di 1 thang
//        ChronoUnit là một enum thi hành interface TemporalUnit, nó cung cấp các đơn vị tính tiêu chuẩn được sử dụng trong Java Date Time API.
//        Về cơ bản các đơn vị tính này là đủ để sử dụng, tuy nhiên nếu muốn có một đơn vị tính tuỳ biến hãy viết một lớp thi hành interface TemporalUnit.
        System.out.println("Tru 1 thang" + date.minus(1, ChronoUnit.MONTHS));

        // Dua ra ngay thang chung ta dua vao
        System.out.println(LocalDate.of(2022, 10, 19));

        // Kiem tra ngay co xay ra trong nam nhuan
        System.out.println("Nam nhuan " +LocalDate.of(2023, 10, 1).isLeapYear());

        // Kiem tra isBefore hoac isAfter cua 2 khoang thoi gian
        System.out.println(date.isAfter(LocalDate.of(2025,10,10)));

        //Time
        LocalTime time = LocalTime.now();

        // Lay ra giay trong gio
        System.out.println("Giay" + time.getSecond());

        // Lay ra phut trong gio
        System.out.println("Phut: " + time.getMinute());

        // Lay ra gio
        System.out.println("Gio: " + time.getHour());

        // Cong them 1 gio
        System.out.println("Cong them gio: " +time.plus(1, ChronoUnit.HOURS));

        // Tru bot 1 phut
        System.out.println("Tru bot phut: " +time.minus(10, ChronoUnit.MINUTES));

        // Thoi gian hien tai
        System.out.println("Thoi gian hien tai la: " +time);
        String date3 = String.valueOf(LocalDate.now());
        System.out.println(date3);
        LocalDate localDate = LocalDate.now();
        String date12 = String.valueOf(localDate);
        System.out.println(date12);
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date3);
            Date datef = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            System.out.println(date1.compareTo(datef));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
