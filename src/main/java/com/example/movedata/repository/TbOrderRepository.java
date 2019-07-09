package com.example.movedata.repository;

import com.example.movedata.domian.TbOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author xy
 */
public interface TbOrderRepository extends JpaRepository<TbOrderEntity, Long> {

}