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
public class TbOrderDTO implements Serializable {

    private static final long serialVersionUID = -3611846235373222181L;

    private Long id;

    /** 创建时间 */
    private Date createTime;

    /** 是否逻辑删除:1是0否 */
    private Boolean logicDelete;

    /** 更新时间 */
    private Date updateTime;

    /** 版本号 */
    private Long version;

    private BigDecimal amount;

    private String createBy;

    private Long memberId;

    private String memo;

    private Long merchantId;

    private String merchantName;

    private String name;

    private String phone;

    private Date beginDate;

    private Date endDate;

    private Integer totalCount;

    private Integer unUsedCount;

    private Integer usedCount;

    private String source;

    private String status;

    private String traceNo;

    private String contractId;

    private Long paymentId;

    private Long packageId;

    private Long bookingId;

}