package com.example.movedata.service.impl;

import com.example.movedata.service.TbProjectService;
import com.example.movedata.repository.TbProjectRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author xy
 */
@Slf4j
@Service
public class TbProjectServiceImpl implements TbProjectService {

    private TbProjectRepository tbProjectRepository;

    @Autowired
    public TbProjectServiceImpl(TbProjectRepository tbProjectRepository) {
        this.tbProjectRepository = tbProjectRepository;
    }


}