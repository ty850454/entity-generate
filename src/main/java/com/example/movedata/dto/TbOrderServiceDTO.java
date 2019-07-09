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
public class TbOrderServiceDTO implements Serializable {

    private static final long serialVersionUID = -3679429058785567619L;

    private Long id;

    /** 创建时间 */
    private Date createTime;

    /** 是否逻辑删除:1是0否 */
    private Boolean logicDelete;

    /** 更新时间 */
    private Date updateTime;

    /** 版本号 */
    private Long version;

    private Long orderId;

    private Long pkgServiceId;

    private String pkgName;

    private String name;

    private String memo;

    private Integer quantity;

    private Integer indexNo;

}