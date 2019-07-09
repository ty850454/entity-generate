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
@Table(name = "tb_project")
@DynamicInsert
@DynamicUpdate
public class TbProjectEntity implements Serializable {

    private static final long serialVersionUID = 4918102856880580815L;

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

    @Column(name = "area_code", columnDefinition = "varchar(255) DEFAULT NULL")
    private String areaCode;

    @Column(name = "basic_project_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long basicProjectId;

    @Column(name = "biz_project_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long bizProjectId;

    @Column(name = "business_type", columnDefinition = "varchar(255) DEFAULT NULL")
    private String businessType;

    @Column(name = "city_code", columnDefinition = "varchar(255) DEFAULT NULL")
    private String cityCode;

    @Column(name = "address", columnDefinition = "varchar(255) DEFAULT NULL")
    private String address;

    @Column(name = "geo_point", columnDefinition = "varchar(255) DEFAULT NULL")
    private String geoPoint;

    @Column(name = "member_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long memberId;

    @Column(name = "merchant_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long merchantId;

    @Column(name = "name", columnDefinition = "varchar(255) DEFAULT NULL")
    private String name;

    @Column(name = "phone", columnDefinition = "varchar(255) DEFAULT NULL")
    private String phone;

    @Column(name = "asset_project_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long assetProjectId;

    @Column(name = "market_project_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long marketProjectId;

    @Column(name = "order_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long orderId;

    @Column(name = "package_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long packageId;


}