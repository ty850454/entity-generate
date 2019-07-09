package com.example.movedata.service.impl;

import com.example.movedata.service.TbPaymentService;
import com.example.movedata.repository.TbPaymentRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author xy
 */
@Slf4j
@Service
public class TbPaymentServiceImpl implements TbPaymentService {

    private TbPaymentRepository tbPaymentRepository;

    @Autowired
    public TbPaymentServiceImpl(TbPaymentRepository tbPaymentRepository) {
        this.tbPaymentRepository = tbPaymentRepository;
    }


}