package com.falko.dao.implementations;

import com.falko.dao.AbstractDao;
import com.falko.dao.interfaces.SaleDao;
import com.falko.model.Sale;
import org.springframework.stereotype.Repository;

@Repository("saleDao")
public class SaleDaoImpl extends AbstractDao<Integer, Sale> implements SaleDao {

    public void saveSale(Sale sale) {
        save(sale);
    }
}
