package ${package};

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@Getter
@Setter
@ToString
@Entity
@Table(name = "${table.tableName}")
@DynamicInsert
@DynamicUpdate
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
    @Column(name = "${column.columnName}"<#--<#if !column.nullable>, nullable = false</#if><#if column.length??>, length = ${column.length}</#if><#if column.precision??>, precision = ${column.precision}</#if><#if column.scale??>, scale = ${column.scale}</#if>--><#if column.columnDefinition??>, columnDefinition = "${column.columnDefinition}"</#if>)
    private ${column.javaType.className} ${column.fieldName};

</#list>

}