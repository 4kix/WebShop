package com.falko.service.implementations;

import com.falko.dao.interfaces.SaleDao;
import com.falko.model.Sale;
import com.falko.service.interfaces.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("saleService")
@Transactional
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDao dao;

    public void saveSale(Sale sale) {
        dao.saveSale(sale);
    }

}
