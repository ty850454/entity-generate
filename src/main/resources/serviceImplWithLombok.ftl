package ${package};

<#if package != interfacePackage>
import ${interfacePackage}.${interfaceClassName};
</#if>
<#if package != repositoryPackage>
import ${repositoryPackage}.${repositoryClassName};
</#if>
<#--<#if package != entityPackage>
import ${entityPackage}.${entityClassName};
</#if>
<#if package != dtoPackage>
import ${dtoPackage}.${dtoClassName};
</#if>-->

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${comment!}
 * @author ${author!}
 */
@Slf4j
@Service
public class ${className} implements ${interfaceClassName} {

    private ${repositoryClassName} ${repositoryName};

    @Autowired
    public ${className}(${repositoryClassName} ${repositoryName}) {
        this.${repositoryName} = ${repositoryName};
    }


<#--    private ${dtoClassName} entityToDto(${entityClassName} entity) {
        ${dtoClassName} result =  new ${dtoClassName}();
        <#list columns as column>
        result.set${column.upperCamelCaseFieldName}(entity.get${column.upperCamelCaseFieldName}());
        </#list>
        return result;
    }
    private ${entityClassName} dtoToEntity(${dtoClassName} dto) {
        ${entityClassName} result =  new ${entityClassName}();
        <#list columns as column>
        result.set${column.upperCamelCaseFieldName}(dto.get${column.upperCamelCaseFieldName}());
        </#list>
        return result;
    }-->
}