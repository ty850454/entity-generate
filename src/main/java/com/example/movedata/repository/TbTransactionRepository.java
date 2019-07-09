package com.example.movedata.repository;

import com.example.movedata.domian.TbTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author xy
 */
public interface TbTransactionRepository extends JpaRepository<TbTransactionEntity, Long> {

}