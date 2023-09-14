package com.example.demo.dao;

import com.example.demo.entity.SinhVien;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
@Transactional
public class SvDAO implements SinhVienDAO{
    private EntityManager entityManager;
    @Autowired
    public SvDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    };
    @Override
    public void save(SinhVien sinhVien) {
        try {
//            this.entityManager.merge(sinhVien);
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public SinhVien  findById(int id) {
        return this.entityManager.find(SinhVien.class, id);
    }
}
