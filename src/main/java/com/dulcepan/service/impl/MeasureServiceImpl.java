package com.dulcepan.service.impl;

import com.dulcepan.entity.Measure;
import com.dulcepan.dao.MeasureDao;
import com.dulcepan.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("measureService")
public class MeasureServiceImpl implements MeasureService {

    private MeasureDao measureDao;

    @Autowired
    public MeasureServiceImpl(MeasureDao measureDao) {
        this.measureDao = measureDao;
    }

    @Transactional
    @Override
    public List<Measure> findAll() {
        return measureDao.findAll();
    }
}
