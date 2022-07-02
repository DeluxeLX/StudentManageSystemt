package com.itlzh.service.impl;

import com.itlzh.mapper.ISysLogDAO;
import com.itlzh.pojo.SysLog;
import com.itlzh.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceimpl implements ISysLogService {

    @Autowired
    ISysLogDAO sysLogDAO;

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDAO.findAll();
    }

    @Override
    public int save(SysLog sysLog) throws Exception {
        return sysLogDAO.save(sysLog);
    }
}
