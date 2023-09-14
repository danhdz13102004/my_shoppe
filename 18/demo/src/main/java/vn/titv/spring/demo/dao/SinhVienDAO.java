package vn.titv.spring.demo.dao;

import vn.titv.spring.demo.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    public void save(SinhVien sinhVien);
    public SinhVien findById(int id);

    public void deleteById(int id);
    public List<SinhVien> getAll();

    public List<SinhVien> selectByName(String name);

    public SinhVien updateById(SinhVien svUD);
    public void updateAll(String name);
}
