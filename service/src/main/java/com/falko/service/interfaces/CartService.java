package com.falko.service.interfaces;


import com.falko.model.Sale;

import java.util.List;

public interface CartService {

    void addSale(Sale sale);

    void removeSale(Sale sale);

    int getFinalPrice();

    int getAmountOfSales();

    List<Sale> getSales();

    void removeAllSales();

}
