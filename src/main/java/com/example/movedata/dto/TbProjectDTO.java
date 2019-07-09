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
public class TbProjectDTO implements Serializable {

    private static final long serialVersionUID = -4471042899692999190L;

    private Long id;

    /** 创建时间 */
    private Date createTime;

    /** 是否逻辑删除:1是0否 */
    private Boolean logicDelete;

    /** 更新时间 */
    private Date updateTime;

    /** 版本号 */
    private Long version;

    private String areaCode;

    private Long basicProjectId;

    private Long bizProjectId;

    private String businessType;

    private String cityCode;

    private String address;

    private String geoPoint;

    private Long memberId;

    private Long merchantId;

    private String name;

    private String phone;

    private Long assetProjectId;

    private Long marketProjectId;

    private Long orderId;

    private Long packageId;

}