package com.itlzh.service;

import com.itlzh.pojo.SysLog;

import java.util.List;

public interface ISysLogService {

    List<SysLog> findAll() throws Exception;

    int save(SysLog sysLog) throws Exception;

}
