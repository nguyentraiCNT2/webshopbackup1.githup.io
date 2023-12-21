package webmobileshop.RanDom;

public class MainApp {

    public static void main(String[] args) {
        // Thay thế "your_username" bằng tên người dùng thực tế
        String username = "jinhyk21";
        String password = "k211412@";
        // Thời gian hết hạn token, 1 giờ trong ví dụ này
        long expirationMillis = 3600000;

        String token = TokenUtil.generateToken(username,password, expirationMillis);

        // Hiển thị token ra màn hình console
        System.out.println("Generated Token: " + token);

        // Nếu bạn sử dụng một logging framework, bạn có thể ghi token vào log
        // Ví dụ với SLF4J:
        // Logger logger = LoggerFactory.getLogger(MainApp.class);
        // logger.info("Generated Token: {}", token);
    }
}
