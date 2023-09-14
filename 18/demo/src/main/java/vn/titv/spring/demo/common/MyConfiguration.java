package vn.titv.spring.demo.common;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.titv.spring.demo.dao.SinhVienDAO;
import vn.titv.spring.demo.dao.SinhVienDAOImpl;
import vn.titv.spring.demo.entity.SinhVien;

import java.util.Scanner;
import java.util.List;

@Configuration
public class MyConfiguration {
    public Scanner sc = new Scanner(System.in);
    @Bean
    @Autowired
    public CommandLineRunner getRunner(SinhVienDAOImpl sinhVienDAOImpl){
        return runner -> {
            Scanner scanner = new Scanner(System.in);
            while(true){
                inMenu();
                int luaChon = scanner.nextInt();
                scanner.nextLine();
                if(luaChon==1){
                    // Gọi phương thức thêm sinh viên
                    themSinhVien(sinhVienDAOImpl);
                }
                else if(luaChon == 2) {
                    timSinhVien(sinhVienDAOImpl);
                }
                else if(luaChon == 3) {
                    xoaSinhVien(sinhVienDAOImpl);
                }
                else if(luaChon == 4) {
                    timTatCa(sinhVienDAOImpl);
                }
                else if(luaChon == 5) {
                    timBoiTen(sinhVienDAOImpl);
                }
                else if(luaChon == 6) {
                    capNhatQuaId(sinhVienDAOImpl);
                }
                else if(luaChon == 7) {
                    capNhatTatCa(sinhVienDAOImpl);
                }
            }
        };
    }

    public void inMenu(){
        System.out.println("============================================\n");
        System.out.println("MENU:\n"+
                            "1. Thêm sinh viên\n"+
                            "2. Tìm sinh viên\n"+
                            "3. Xóa sinh viên\n"+
                            "4. Chọn tất cả\n"+
                            "5. Tìm bởi tên\n"+
                            "6. Cập nhật thông tin qua id\n"+
                            "7. Cập nhật tên của tất cả\n"+
                            "Lựa chọn: \n"
                );
    }


    public void themSinhVien(SinhVienDAOImpl sinhVienDAOImpl){
        // Lấy thông tin sinh viên
        System.out.println("Nhập họ đệm: ");
        String ho_dem = sc.nextLine();
        System.out.println("Nhập tên: ");
        String ten = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        SinhVien sinhVien = new SinhVien(ho_dem, ten, email);
        // Luu xuong CSDL
        sinhVienDAOImpl.save(sinhVien);
    }
    public void timSinhVien(SinhVienDAOImpl svDAO) {
        System.out.println("Nhập id: ");
        String s = sc.nextLine();
        SinhVien sv = svDAO.findById(Integer.parseInt(s));
        if(sv != null) {
            System.out.println(sv);
        }
        else {
            System.out.println("Không tìm thấy sinh viên");
        }
    }
    public void xoaSinhVien(SinhVienDAOImpl svDAO) {
        System.out.print("Nhập id cần xóa: ");
        String id = sc.nextLine();
        if(svDAO.findById(Integer.parseInt(id)) != null) svDAO.deleteById(Integer.parseInt(id));
        else System.out.println("Sinh viên này không tồn tại");
    }
    public void timTatCa(SinhVienDAOImpl svDAO) {
        List<SinhVien> list = svDAO.getAll();
        if(list.size() == 0 ) {
            System.out.println("Không có ai trong danh sách"); return;
        }
        System.out.println("Danh Sách Sinh Viên: ");
        for(SinhVien s : list) {
            System.out.println(s);
        }
    }
    public void timBoiTen(SinhVienDAOImpl svDAO) {
        System.out.print("Nhập tên cần tìm : ");
        String name = sc.nextLine();
        List<SinhVien> list = svDAO.selectByName(name);
        if(list.size() == 0 ) {
            System.out.println("Không có ai trong danh sách"); return;
        }
        System.out.println("Danh Sách Sinh Viên Có Tên " + name);
        for(SinhVien s : list) {
            System.out.println(s);
        }
    }
    public void capNhatQuaId(SinhVienDAOImpl svDAO) {
        System.out.println("Nhập id cần thay đổi ");
        String id = sc.nextLine();
        System.out.println("Nhập họ đệm: ");
        String ho_dem = sc.nextLine();
        System.out.println("Nhập tên: ");
        String ten = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        SinhVien sv = new SinhVien(Integer.parseInt(id),ho_dem,ten,email);
        svDAO.updateById(sv);
    }
    public void capNhatTatCa(SinhVienDAOImpl svDAO) {
        System.out.println("Nhập tên cần cập nhật");
        String name = sc.nextLine();
        svDAO.updateAll(name);
    }

}
