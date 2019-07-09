package com.example.movedata.service.impl;

import com.example.movedata.service.TbMarketProjectService;
import com.example.movedata.repository.TbMarketProjectRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author xy
 */
@Slf4j
@Service
public class TbMarketProjectServiceImpl implements TbMarketProjectService {

    private TbMarketProjectRepository tbMarketProjectRepository;

    @Autowired
    public TbMarketProjectServiceImpl(TbMarketProjectRepository tbMarketProjectRepository) {
        this.tbMarketProjectRepository = tbMarketProjectRepository;
    }


}