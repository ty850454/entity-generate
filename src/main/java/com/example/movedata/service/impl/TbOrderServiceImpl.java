package com.example.movedata.service.impl;

import com.example.movedata.service.TbOrderService;
import com.example.movedata.repository.TbOrderRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author xy
 */
@Slf4j
@Service
public class TbOrderServiceImpl implements TbOrderService {

    private TbOrderRepository tbOrderRepository;

    @Autowired
    public TbOrderServiceImpl(TbOrderRepository tbOrderRepository) {
        this.tbOrderRepository = tbOrderRepository;
    }


}