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
@Table(name = "tb_payment")
@DynamicInsert
@DynamicUpdate
public class TbPaymentEntity implements Serializable {

    private static final long serialVersionUID = 8159955509134985812L;

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

    @Column(name = "pay_amount", columnDefinition = "varchar(255) DEFAULT NULL")
    private String payAmount;

    @Column(name = "pay_seq", columnDefinition = "varchar(255) DEFAULT NULL")
    private String paySeq;

    @Column(name = "tool_code", columnDefinition = "varchar(255) DEFAULT NULL")
    private String toolCode;

    @Column(name = "total_fee", columnDefinition = "varchar(255) DEFAULT NULL")
    private String totalFee;

    @Column(name = "attach_url", columnDefinition = "varchar(255) DEFAULT NULL")
    private String attachUrl;

    @Column(name = "attach_url2", columnDefinition = "varchar(255) DEFAULT NULL")
    private String attachUrl2;

    @Column(name = "card_num", columnDefinition = "varchar(255) DEFAULT NULL")
    private String cardNum;

    @Column(name = "bank_name", columnDefinition = "varchar(255) DEFAULT NULL")
    private String bankName;

    @Column(name = "contact_name", columnDefinition = "varchar(255) DEFAULT NULL")
    private String contactName;

    @Column(name = "contact_phone", columnDefinition = "varchar(255) DEFAULT NULL")
    private String contactPhone;

    @Column(name = "interact_id", columnDefinition = "varchar(255) DEFAULT NULL")
    private String interactId;

    @Column(name = "order_id", columnDefinition = "bigint(20) DEFAULT NULL")
    private Long orderId;

    @Column(name = "attach_files", columnDefinition = "text DEFAULT NULL")
    private String attachFiles;

    @Column(name = "pay_date", columnDefinition = "datetime DEFAULT NULL")
    private Date payDate;

    @Column(name = "account_name", columnDefinition = "varchar(255) DEFAULT NULL")
    private String accountName;


}