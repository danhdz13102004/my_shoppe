package com.example.demo.entity;

import com.example.demo.DAO.*;
import jakarta.persistence.*;
import com.example.demo.*;
@Entity
@Table(name = "sinhvien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;
    @Column(name = "ho_dem", nullable = false)
    private  String hoDem;
    @Column(name = "ten", nullable = false )
    private String ten;
    @Column(name = "email")
    private String email;

    public SinhVien() {
    }

    public SinhVien(String hoDem, String ten, String email) {
        this.hoDem = hoDem;
        this.ten = ten;
        this.email = email;
    }
    public SinhVien(int id,String hoDem, String ten, String email) {
        this.id = id;
        this.hoDem = hoDem;
        this.ten = ten;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoDem() {
        return hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", hoDem='" + hoDem + '\'' +
                ", ten='" + ten + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
