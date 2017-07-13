package com.falko.dao.interfaces;


    import com.falko.model.Product;
    import org.hibernate.criterion.Criterion;

    import java.util.List;

    public interface ProductDao {

        Product getById(int id);
        List<Product> getAll(int numberOfPage, int amountOnPage);
        List<Product> getAll();
        List<Product> getByCriterion(Criterion criterion);
        List<Product> getByCriterion(Criterion criterion, int numberOfPage, int amountOnPage);
    }
