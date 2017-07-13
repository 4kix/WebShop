package com.falko.service.implementations;

import com.falko.dao.interfaces.ProductDao;
import com.falko.model.Product;
import com.falko.service.interfaces.ProductService;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao dao;

    public Product getProductById(int id) {
        return dao.getById(id);
    }

    public List<Product> getAllProduct(int numberOfPage, int amountOnPage) {
        return dao.getAll(numberOfPage, amountOnPage);
    }

    public List<Product> getAllProduct() {
        return dao.getAll();
    }

    public List<Product> getProductsByType(int idOfType) {
        Criterion criterion = Restrictions.eq("type.idOfType", idOfType);
        return dao.getByCriterion(criterion);
    }

    public List<Product> getProductsByType(int idOfType, int numberOfPage, int amountOnPage) {
        Criterion criterion = Restrictions.eq("type.idOfType", idOfType);
        return dao.getByCriterion(criterion, numberOfPage, amountOnPage);
    }

    public List<Product> getProductsByCountry(int idOfCountry) {
        Criterion criterion = Restrictions.eq("country.idOfCountry", idOfCountry);
        return dao.getByCriterion(criterion);
    }

    public List<Product> getProductsByCountry(int idOfCountry, int numberOfPage, int amountOnPage) {
        Criterion criterion = Restrictions.eq("country.idOfCountry", idOfCountry);
        return dao.getByCriterion(criterion, numberOfPage, amountOnPage);
    }

    public List<Product> getProductsBySearch(String searchString) {
        Criterion criterion = Restrictions.ilike("nameOfProduct", searchString, MatchMode.ANYWHERE);
        return dao.getByCriterion(criterion);
    }

    public List<Product> getProductsBySearch(String searchString, int numberOfPage, int amountOnPage) {
        Criterion criterion = Restrictions.ilike("nameOfProduct", searchString, MatchMode.ANYWHERE);
        return dao.getByCriterion(criterion, numberOfPage, amountOnPage);
    }
}
