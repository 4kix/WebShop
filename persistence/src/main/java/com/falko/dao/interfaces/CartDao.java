package com.falko.dao.interfaces;


import com.falko.model.Sale;

import java.util.List;

public interface CartDao {

    void addSale(Sale sale);

    void removeSale(Sale sale);

    int getFinalPrice();

    int getAmountOfSales();

    List<Sale> getSales();

    void removeAllSales();

}
