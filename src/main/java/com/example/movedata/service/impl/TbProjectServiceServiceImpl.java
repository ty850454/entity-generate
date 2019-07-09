package com.example.movedata.service.impl;

import com.example.movedata.service.TbProjectServiceService;
import com.example.movedata.repository.TbProjectServiceRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author xy
 */
@Slf4j
@Service
public class TbProjectServiceServiceImpl implements TbProjectServiceService {

    private TbProjectServiceRepository tbProjectServiceRepository;

    @Autowired
    public TbProjectServiceServiceImpl(TbProjectServiceRepository tbProjectServiceRepository) {
        this.tbProjectServiceRepository = tbProjectServiceRepository;
    }


}