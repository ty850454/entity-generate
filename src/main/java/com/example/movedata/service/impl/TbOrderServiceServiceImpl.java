package com.example.movedata.service.impl;

import com.example.movedata.service.TbOrderServiceService;
import com.example.movedata.repository.TbOrderServiceRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author xy
 */
@Slf4j
@Service
public class TbOrderServiceServiceImpl implements TbOrderServiceService {

    private TbOrderServiceRepository tbOrderServiceRepository;

    @Autowired
    public TbOrderServiceServiceImpl(TbOrderServiceRepository tbOrderServiceRepository) {
        this.tbOrderServiceRepository = tbOrderServiceRepository;
    }


}