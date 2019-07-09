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
@Table(name = "tb_transaction")
@DynamicInsert
@DynamicUpdate
public class TbTransactionEntity implements Serializable {

    private static final long serialVersionUID = -153787551110798079L;

    @Column(name = "type", columnDefinition = "int(11) NOT NULL")
    private Integer type;

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

    @Column(name = "market_project_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long marketProjectId;

    @Column(name = "rental_single_price_begin", columnDefinition = "decimal(12,2) DEFAULT NULL")
    private BigDecimal rentalSinglePriceBegin;

    @Column(name = "rental_single_price_end", columnDefinition = "decimal(12,2) DEFAULT NULL")
    private BigDecimal rentalSinglePriceEnd;

    @Column(name = "financing_cost", columnDefinition = "decimal(12,2) DEFAULT NULL")
    private BigDecimal financingCost;

    @Column(name = "total_transfer_price", columnDefinition = "decimal(12,2) DEFAULT NULL")
    private BigDecimal totalTransferPrice;


}