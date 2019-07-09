package com.example.movedata.service.impl;

import com.example.movedata.service.TbAssetProjectService;
import com.example.movedata.repository.TbAssetProjectRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author xy
 */
@Slf4j
@Service
public class TbAssetProjectServiceImpl implements TbAssetProjectService {

    private TbAssetProjectRepository tbAssetProjectRepository;

    @Autowired
    public TbAssetProjectServiceImpl(TbAssetProjectRepository tbAssetProjectRepository) {
        this.tbAssetProjectRepository = tbAssetProjectRepository;
    }


}