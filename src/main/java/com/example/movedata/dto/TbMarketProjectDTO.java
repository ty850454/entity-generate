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
public class TbMarketProjectDTO implements Serializable {

    private static final long serialVersionUID = 1905968290828760733L;

    private Long id;

    /** 创建时间 */
    private Date createTime;

    /** 是否逻辑删除:1是0否 */
    private Boolean logicDelete;

    /** 更新时间 */
    private Date updateTime;

    /** 版本号 */
    private Long version;

    private String auditDate;

    private String buildCertType;

    private String contactName;

    private String contactPhone;

    private String coverUrl;

    private String memo;

    private Integer status;

    private String transferArea;

    private Long projectId;

}