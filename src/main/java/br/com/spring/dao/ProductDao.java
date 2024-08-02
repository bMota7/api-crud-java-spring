package br.com.spring.dao;

import br.com.spring.domain.Products;

import java.util.List;

public interface ProductDao {

    void toSave(Products products);
    List<Products> toRecover();
    Products recoverByProduct(long userlistId);
    Products recoverByUserlistIdAndProductId(long userlistId, long productlisttId);
    void toUpdate(Products products);
    void toDelete(long productId);

}
