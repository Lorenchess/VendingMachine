package Day1.localdate.codealong;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        ld = LocalDate.parse("2009-05-20");
        System.out.println(ld);

        ld = LocalDate.parse("03/30/2017", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(ld);

        //convert to string
        String isoDate = ld.toString();
        System.out.println(isoDate);
        ld = LocalDate.parse(isoDate);
        System.out.println(ld);

        //formatting ld
        String formatted = ld.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(formatted);

        formatted = ld.format(DateTimeFormatter.ofPattern("+++MM*dd*yyyy+++"));
        System.out.println(formatted);

        formatted = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);

        LocalDate past = ld.minusDays(6);
        formatted = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);

        past = ld.minusMonths(9);
        formatted = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);

        System.out.println("============PERIOD=============");

        Period diff = ld.until(past);
        System.out.println("Period " +diff);

       //converting legacy date
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        formatted = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(formatted);

        //legacy
        Date legacyDate = new Date();
        System.out.println(legacyDate);

        GregorianCalendar legacyCalendar = new GregorianCalendar();
        System.out.println(legacyCalendar);

        ZonedDateTime zdt = ZonedDateTime.ofInstant(legacyDate.toInstant(), ZoneId.systemDefault());
        ld = zdt.toLocalDate();
        System.out.println(ld);

        zdt = legacyCalendar.toZonedDateTime();
        ld = zdt.toLocalDate();
        System.out.println(ld);


        System.out.println("====================================");
       LocalDate ldn = LocalDate.now();
        System.out.println("date now "+ldn);

        System.out.println("year now " +ldn.getYear()); //2022
        System.out.println("month now " +ldn.getMonth());//APRIL
        System.out.println("month now "+ ldn.getDayOfMonth()); //4
        System.out.println("day of week " + ldn.getDayOfWeek());//MONDAY
        System.out.println("month " + ldn.getMonthValue()); //4


        int monthLD = ldn.getMonthValue();
        String month = String.valueOf(monthLD);
        System.out.println(month);
        int dayOfMonth = ldn.getDayOfMonth();
        String day = String.valueOf(dayOfMonth);
        System.out.println(day);
        int yearNow = ldn.getYear();
        String year = String.valueOf(yearNow);
        System.out.println(year);




//       ldn = LocalDate.parse(ldn.getYear()+ ldn.getMonthValue()+ldn.getDayOfMonth()+"");
//        System.out.println(ldn);

    }
}
