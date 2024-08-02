package br.com.spring.service;

import br.com.spring.dao.ProductDao;
import br.com.spring.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public void toSave(Products products) {
        productDao.toSave(products);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Products> toRecover() {
        return productDao.toRecover();
    }

    @Override
    @Transactional(readOnly = true)
    public Products recoverById(long id) {
        return productDao.recoverByProduct(id);
    }

    @Override
    public void toUpdate(Products products) {
        productDao.toUpdate(products);
    }

    @Override
    public void toDelete(long id) {
        productDao.toDelete(id);
    }
}
