package com.example.movedata.service.impl;

import com.example.movedata.service.TbTransactionService;
import com.example.movedata.repository.TbTransactionRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author xy
 */
@Slf4j
@Service
public class TbTransactionServiceImpl implements TbTransactionService {

    private TbTransactionRepository tbTransactionRepository;

    @Autowired
    public TbTransactionServiceImpl(TbTransactionRepository tbTransactionRepository) {
        this.tbTransactionRepository = tbTransactionRepository;
    }


}