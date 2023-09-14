package com.example.demo.rest;

import com.example.demo.entity.ErrorRespond;
import com.example.demo.entity.Student;
import com.example.demo.exception.SinhVienException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sinhvien")
public class StudentController {
    public List<Student> danhSach;

    @PostConstruct
    public void createDanhSach() {
        danhSach = new ArrayList<Student>();
        danhSach.add(new Student(1,"ngo van danh",18,"IT",4));
        danhSach.add(new Student(2,"ngo van cong",23,"Tho May",4));
        danhSach.add(new Student(3,"ngo van thanh",27,"Duoc Si",4));
    }
    @GetMapping("/")
    public List<Student> getList() {
        return danhSach;
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = null;
        for(Student sv : danhSach) {
            if(sv.getId() == id) return sv;
        }
        throw     new SinhVienException("Không tìm thấy sinh viên với id = " + id);
    }
    @GetMapping("/index/{index}")
    public Student getByIndex(@PathVariable int index) {
           try {
               return danhSach.get(index);
           }catch (Exception ex) {
               throw  new SinhVienException("Không tìm thấy sinh viên với chỉ số index = " + index);
           }

    }

    @ExceptionHandler
    public ResponseEntity<ErrorRespond> batLoi(SinhVienException ex) {
        ErrorRespond er = new ErrorRespond(HttpStatus.NOT_FOUND.value(),ex.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorRespond> batLoiAll(Exception ex) {
        ErrorRespond er = new ErrorRespond(HttpStatus.NOT_FOUND.value(),"Yêu cầu truy cập không hợp lệ");
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }


}
