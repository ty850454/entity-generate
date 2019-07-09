package com.example.movedata.domian;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author xy
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_market_project")
@DynamicInsert
@DynamicUpdate
public class TbMarketProjectEntity implements Serializable {

    private static final long serialVersionUID = 7364614221477061552L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** 创建时间 */
    @Column(name = "create_time", columnDefinition = "datetime NOT NULL COMMENT '创建时间'")
    private Date createTime;

    /** 是否逻辑删除:1是0否 */
    @Column(name = "logic_delete", columnDefinition = "bit(1) NOT NULL DEFAULT b'0' COMMENT '是否逻辑删除:1是0否'")
    private Boolean logicDelete;

    /** 更新时间 */
    @Column(name = "update_time", columnDefinition = "datetime NOT NULL COMMENT '更新时间'")
    private Date updateTime;

    /** 版本号 */
    @Column(name = "version", columnDefinition = "bigint(20) NOT NULL DEFAULT '0' COMMENT '版本号'")
    private Long version;

    @Column(name = "audit_date", columnDefinition = "varchar(255) DEFAULT NULL")
    private String auditDate;

    @Column(name = "build_cert_type", columnDefinition = "varchar(255) DEFAULT NULL")
    private String buildCertType;

    @Column(name = "contact_name", columnDefinition = "varchar(255) DEFAULT NULL")
    private String contactName;

    @Column(name = "contact_phone", columnDefinition = "varchar(255) DEFAULT NULL")
    private String contactPhone;

    @Column(name = "cover_url", columnDefinition = "varchar(255) DEFAULT NULL")
    private String coverUrl;

    @Column(name = "memo", columnDefinition = "varchar(255) DEFAULT NULL")
    private String memo;

    @Column(name = "status", columnDefinition = "int(11) DEFAULT NULL")
    private Integer status;

    @Column(name = "transfer_area", columnDefinition = "varchar(255) DEFAULT NULL")
    private String transferArea;

    @Column(name = "project_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long projectId;


}