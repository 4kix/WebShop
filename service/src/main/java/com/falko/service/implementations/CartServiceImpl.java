package com.falko.service.implementations;

import com.falko.dao.interfaces.CartDao;
import com.falko.model.Sale;
import com.falko.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {

    CartDao cartDao;

    @Autowired
    public CartServiceImpl(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public void addSale(Sale sale) {
        cartDao.addSale(sale);
    }

    public void removeSale(Sale sale) {
        cartDao.removeSale(sale);
    }

    public int getFinalPrice() {
        return cartDao.getFinalPrice();
    }

    public int getAmountOfSales() {
        return cartDao.getAmountOfSales();
    }

    public List<Sale> getSales() {
        return cartDao.getSales();
    }

    public void removeAllSales() {
        cartDao.removeAllSales();
    }
}
