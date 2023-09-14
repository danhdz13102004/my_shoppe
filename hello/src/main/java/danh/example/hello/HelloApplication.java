package danh.example.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloApplication {
	@Value("${khoahoc.ten}")
	private String tenKhoaHoc;
	@Value("${khoahoc.huongdan}")
	private String nguoiHuongDan;
	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
	@GetMapping("/")
	public String index() {
		return "ok kk	khong hhi";
	}
	@GetMapping("/h2")
	public String index2() {
		return "Giang vien";
	}
	@GetMapping("/h4")
	public String index3() {
		return "Tên class: " +  tenKhoaHoc + "<br>"
				+ "Người hướng dẫn: " + nguoiHuongDan;
	}
}
