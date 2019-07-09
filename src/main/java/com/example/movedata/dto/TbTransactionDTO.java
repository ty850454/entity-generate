package com.example.movedata.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 
 * @author xy
 */
@Getter
@Setter
@ToString
public class TbTransactionDTO implements Serializable {

    private static final long serialVersionUID = 6244791259988104484L;

    private Integer type;

    private Long id;

    /** 创建时间 */
    private Date createTime;

    /** 是否逻辑删除:1是0否 */
    private Boolean logicDelete;

    /** 更新时间 */
    private Date updateTime;

    /** 版本号 */
    private Long version;

    private Long marketProjectId;

    private BigDecimal rentalSinglePriceBegin;

    private BigDecimal rentalSinglePriceEnd;

    private BigDecimal financingCost;

    private BigDecimal totalTransferPrice;

}