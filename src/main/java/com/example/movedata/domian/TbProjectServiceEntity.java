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
@Table(name = "tb_project_service")
@DynamicInsert
@DynamicUpdate
public class TbProjectServiceEntity implements Serializable {

    private static final long serialVersionUID = -8922520314376826772L;

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

    @Column(name = "project_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long projectId;

    @Column(name = "service_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long serviceId;

    @Column(name = "name", columnDefinition = "varchar(255) DEFAULT NULL")
    private String name;

    @Column(name = "memo", columnDefinition = "varchar(255) DEFAULT NULL")
    private String memo;

    @Column(name = "code", columnDefinition = "varchar(255) DEFAULT NULL")
    private String code;

    @Column(name = "is_used", columnDefinition = "bit(1) DEFAULT NULL")
    private Boolean isUsed;


}