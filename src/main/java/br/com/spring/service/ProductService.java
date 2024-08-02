package br.com.spring.service;

import br.com.spring.domain.Products;

import java.util.List;

public interface ProductService {

    void toSave(Products products);
    List<Products> toRecover();
    Products recoverById(long id);
    void toUpdate(Products products);
    void toDelete(long id);

}
