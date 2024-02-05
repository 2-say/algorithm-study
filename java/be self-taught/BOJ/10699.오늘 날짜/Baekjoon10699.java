import java.time.*;
import java.time.format.DateTimeFormatter;

public class Baekjoon10699 {
    public static void main(String[] args) {
        LocalDateTime d = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String formatda  = d.format(formatter);
        System.out.println(formatda);
    }
}
