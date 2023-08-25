package bbc.y2021a;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class TimeDisplay {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long t = scan.nextLong(); // 系统中不要做变化
        // 21 - 13 = 8
        Date date = new Date(t);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(format.format(date));
    }
}
