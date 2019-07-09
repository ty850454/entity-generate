package com.dreammakerteam.entity.generate;

import com.dreammakerteam.entity.generate.mysql.MysqlColumnTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class ColumnInfo implements Serializable {
    private static final long serialVersionUID = 8071521352745757123L;

    private String columnName;
    private String fieldName;
    private String upperCamelCaseFieldName;
    private MysqlColumnTypeEnum type;
    private JavaTypeEnum javaType;
    private ColumnTypeScope typeScope;
    private Boolean nullable;
    private Integer length;
    private Integer precision;
    private Integer scale;
    private Boolean primaryKey;
    private Boolean autoIncrement;
    private String comment;
    private String columnDefinition;
    private String defaultValue;
}
