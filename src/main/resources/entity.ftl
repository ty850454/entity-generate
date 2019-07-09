package ${package};

import java.io.Serializable;
<#list imports as import>
import ${import};
</#list>

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ${table.comment!}
 * @author ${author!}
 */
@Entity
@Table(name = "${table.tableName}")
public class ${className} implements Serializable {

    private static final long serialVersionUID = ${serialVersionUID}L;

<#list columns as column>
    <#if column.comment??>
    /** ${column.comment} */
    </#if>
    <#if column.primaryKey>
    @Id
        <#if column.autoIncrement>
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        </#if>
    </#if>
    @Column(name = "${column.columnName}"<#if !column.nullable>, nullable = false</#if><#if column.length??>, length = ${column.length}</#if>)
    private ${column.javaType.className} ${column.fieldName};

</#list>

<#list columns as column>
    <#if column.comment??>
    /** 获取 ${column.comment} */
    </#if>
    public ${column.javaType.className} get${column.upperCamelCaseFieldName}() {
        return ${column.fieldName};
    }

    <#if column.comment??>
    /** 设置 ${column.comment} */
    </#if>
    public void set${column.upperCamelCaseFieldName}(${column.javaType.className} ${column.fieldName}) {
        this.${column.fieldName} = ${column.fieldName};
    }

</#list>
    @Override
    public String toString() {
        return "${table.targetName}{" +
            <#list columns as column>
            "<#if column_index != 0>, </#if>${column.fieldName}=" + ${column.fieldName} +
            </#list>
            '}';
    }

}