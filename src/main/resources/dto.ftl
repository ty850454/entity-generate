package ${package};

import java.io.Serializable;
<#list imports as import>
import ${import};
</#list>

/**
 * ${table.comment!}
 * @author ${author!}
 */
public class ${className} implements Serializable {

    private static final long serialVersionUID = ${serialVersionUID}L;

<#list columns as column>
    <#if column.comment??>
    /** ${column.comment} */
    </#if>
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