package webmobileshop.RanDom;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class datatime {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Date date = new Date();
        // Cộng thêm một giờ
        LocalDateTime futureDateTime = currentDateTime.plus(Duration.ofHours(1));
        // Định dạng thời gian theo ý muốn
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        String formattedCurrentDateTime = currentDateTime.format(formatter);
        String formattedFutureDateTime = futureDateTime.format(formatter);

        // In ra màn hình
        System.out.println("Thời gian thực tế hiện tại: " + date);
        System.out.println("Thời gian thực tế hiện tại: " + formattedCurrentDateTime);
        System.out.println("Thời gian sau khi cộng thêm một giờ: " + formattedFutureDateTime);
    }
}
