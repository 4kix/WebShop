package com.falko.dao.implementations;

import com.falko.dao.AbstractDao;
import com.falko.dao.interfaces.ProductDao;
import com.falko.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

    public Product getById(int id) {
        return getByKey(id);
    }

    public List<Product> getAll(int numberOfPage, int amountOnPage) {
        Criteria criteria = createEntityCriteria();
        criteria.setFirstResult(numberOfPage * amountOnPage - amountOnPage);
        criteria.setMaxResults(amountOnPage);
        return (List<Product>) criteria.list();
    }

    public List<Product> getAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Product>) criteria.list();
    }

    public List<Product> getByCriterion(Criterion criterion, int numberOfPage, int amountOnPage) {
        Criteria criteria = createEntityCriteria();
        criteria.setFirstResult(numberOfPage * amountOnPage - amountOnPage);
        criteria.setMaxResults(amountOnPage);
        return (List<Product>) criteria.add(criterion).list();
    }

    public List<Product> getByCriterion(Criterion criterion) {
        Criteria criteria = createEntityCriteria();
        return (List<Product>) criteria.add(criterion).list();
    }
}
