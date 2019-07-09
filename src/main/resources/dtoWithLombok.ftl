package ${package};


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
<#list imports as import>
import ${import};
</#list>

/**
 * ${table.comment!}
 * @author ${author!}
 */
@Getter
@Setter
@ToString
public class ${className} implements Serializable {

    private static final long serialVersionUID = ${serialVersionUID}L;

<#list columns as column>
    <#if column.comment??>
    /** ${column.comment} */
    </#if>
    private ${column.javaType.className} ${column.fieldName};

</#list>
}