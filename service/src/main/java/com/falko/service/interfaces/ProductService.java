package com.falko.service.interfaces;


import com.falko.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(int id);
    List<Product> getAllProduct(int numberOfPage, int amountOnPage);
    List<Product> getAllProduct();
    List<Product> getProductsByType(int idOfType);
    List<Product> getProductsByType(int idOfType, int numberOfPage, int amountOnPage);
    List<Product> getProductsByCountry(int idOfCountry);
    List<Product> getProductsByCountry(int idOfCountry, int numberOfPage, int amountOnPage);
    List<Product> getProductsBySearch(String searchString);
    List<Product> getProductsBySearch(String searchString, int numberOfPage, int amountOnPage);

}
