package com.falko.service.implementations;

import com.falko.dao.interfaces.StatusDao;
import com.falko.model.Status;
import com.falko.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("statusService")
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusDao statusDao;

    public List<Status> getStatuses() {
        return statusDao.getStatuses();
    }
}
