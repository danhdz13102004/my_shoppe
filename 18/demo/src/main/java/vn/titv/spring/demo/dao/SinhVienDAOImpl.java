package vn.titv.spring.demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.demo.entity.SinhVien;

import java.util.List;

@Repository
@Transactional
public class SinhVienDAOImpl implements SinhVienDAO{
    private EntityManager entityManager;

    @Autowired
    public SinhVienDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(SinhVien sinhVien) {
        this.entityManager.persist(sinhVien);
    }

    @Override
    public List<SinhVien> getAll() {
        String jpql = "SELECT s FROM SinhVien s";
        return this.entityManager.createQuery(jpql,SinhVien.class).getResultList();
    }

    @Override
    public List<SinhVien> selectByName(String name) {
        String jpql = "SELECT s FROM SinhVien s where s.ten=:t";
        TypedQuery<SinhVien> query = this.entityManager.createQuery(jpql,SinhVien.class);
        query.setParameter("t",name);
        return query.getResultList();
    }

    @Override
    public void deleteById(int id) {
        this.entityManager.remove(this.findById(id));
    }

    @Override
    public SinhVien findById(int id) {
        return  this.entityManager.find(SinhVien.class,id);
    }

    @Override
    public SinhVien updateById(SinhVien svUD){
        SinhVien sv = this.findById(svUD.getId());
        if(sv == null) return null;
        return  this.entityManager.merge(svUD);
    }

    @Override
    public void updateAll(String name) {
        String jpql = "UPDATE SinhVien s SET s.ten=:t";
        Query query  = this.entityManager.createQuery(jpql);
        query.setParameter("t",name);
        if(query.executeUpdate()  >0) System.out.println("Cập nhật thành công");
        else System.out.println("Cập nhật không thành công");
    }
}
