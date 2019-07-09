package com.example.movedata.domian;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
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
@Table(name = "tb_order")
@DynamicInsert
@DynamicUpdate
public class TbOrderEntity implements Serializable {

    private static final long serialVersionUID = -6361115131947416804L;

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

    @Column(name = "amount", columnDefinition = "decimal(19,2) DEFAULT NULL")
    private BigDecimal amount;

    @Column(name = "create_by", columnDefinition = "varchar(255) DEFAULT NULL")
    private String createBy;

    @Column(name = "member_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long memberId;

    @Column(name = "memo", columnDefinition = "varchar(255) DEFAULT NULL")
    private String memo;

    @Column(name = "merchant_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long merchantId;

    @Column(name = "merchant_name", columnDefinition = "varchar(255) DEFAULT NULL")
    private String merchantName;

    @Column(name = "name", columnDefinition = "varchar(255) DEFAULT NULL")
    private String name;

    @Column(name = "phone", columnDefinition = "varchar(255) DEFAULT NULL")
    private String phone;

    @Column(name = "begin_date", columnDefinition = "date DEFAULT NULL")
    private Date beginDate;

    @Column(name = "end_date", columnDefinition = "date DEFAULT NULL")
    private Date endDate;

    @Column(name = "total_count", columnDefinition = "int(11) DEFAULT NULL")
    private Integer totalCount;

    @Column(name = "un_used_count", columnDefinition = "int(11) DEFAULT NULL")
    private Integer unUsedCount;

    @Column(name = "used_count", columnDefinition = "int(11) DEFAULT NULL")
    private Integer usedCount;

    @Column(name = "source", columnDefinition = "varchar(255) DEFAULT NULL")
    private String source;

    @Column(name = "status", columnDefinition = "varchar(255) DEFAULT NULL")
    private String status;

    @Column(name = "trace_no", columnDefinition = "varchar(255) DEFAULT NULL")
    private String traceNo;

    @Column(name = "contract_id", columnDefinition = "varchar(255) DEFAULT NULL")
    private String contractId;

    @Column(name = "payment_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long paymentId;

    @Column(name = "package_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long packageId;

    @Column(name = "booking_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long bookingId;


}