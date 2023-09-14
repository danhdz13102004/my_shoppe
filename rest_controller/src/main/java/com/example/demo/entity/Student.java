package com.example.demo.entity;

public class Student {
    private int id;
    private String hoVaTen;
    private int tuoi;
    private String nganhHoc;
    private double diemTb;

    public Student() {
    }

    public Student(int id, String hoVaTen, int tuoi, String nganhHoc, double diemTb) {
        this.id = id;
        this.hoVaTen = hoVaTen;
        this.tuoi = tuoi;
        this.nganhHoc = nganhHoc;
        this.diemTb = diemTb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public double getDiemTb() {
        return diemTb;
    }

    public void setDiemTb(double diemTb) {
        this.diemTb = diemTb;
    }
}
