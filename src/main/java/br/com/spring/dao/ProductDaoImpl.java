package br.com.spring.dao;

import br.com.spring.domain.Products;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void toSave(Products products) {
        em.persist(products);
    }

    public List<Products> toRecover() {
        return em.createQuery("select p from Products p", Products.class).getResultList();
    }

    @Override
    public Products recoverByProduct(long userlistId) {
        return em.find(Products.class, userlistId);
    }

    @Override
    public Products recoverByUserlistIdAndProductId(long userlistId, long productlisttId) {
        return em.createQuery("select p from Product p where p.users.id = :userlistId and m.id = :productlistId", Products.class)
                .setParameter("userlistId", userlistId)
                .setParameter("productlisttId", productlisttId)
                .getSingleResult();
    }

    @Override
    public void toUpdate(Products products) {
        em.merge(products);
    }

    @Override
    public void toDelete(long productId) {
        em.remove(em.getReference(Products.class, productId));
    }

}
