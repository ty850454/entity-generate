package com.example.movedata.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author xy
 */
@Getter
@Setter
@ToString
public class TbPaymentDTO implements Serializable {

    private static final long serialVersionUID = 5930759560771790249L;

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

    private String payAmount;

    private String paySeq;

    private String toolCode;

    private String totalFee;

    private String attachUrl;

    private String attachUrl2;

    private String cardNum;

    private String bankName;

    private String contactName;

    private String contactPhone;

    private String interactId;

    private Long orderId;

    private String attachFiles;

    private Date payDate;

    private String accountName;

}