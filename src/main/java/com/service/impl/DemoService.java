package com.service.impl;

import java.util.*;
import com.entity.*;
import com.dao.*;
import com.service.IDemoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service("demoService")
public class DemoService implements IDemoService{

    @Autowired
    private IDemoDao dao ;

    @Override
    public List<Demo> selectAll() {
        return dao.selectAll();
    }
}
