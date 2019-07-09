package com.dreammakerteam.entity.generate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class CodeGeneratorConfig {
    /** 作者 */
    private String author;
    /** entity包名 */
    private String entityPackage;
    /** repository包名 */
    private String repositoryPackage;
    /** dto包名 */
    private String dtoPackage;
    /** service包名 */
    private String servicePackage;
    /** serviceImpl包名 */
    private String serviceImplPackage;
    /** 表名列表 */
    private List<String> tableNames;
    /** 生成toString方法 */
    private Boolean genToStringMethod;
    /** 生成get方法 */
    private Boolean genGetMethod;
    /** 生成set方法 */
    private Boolean genSetMethod;
    /** 使用lombok */
    private Boolean userLombok;
    /** 数据库-url */
    private String dbUrl;
    /** 数据库-user */
    private String dbUser;
    /** 数据库-password */
    private String dbPassword;
    /** 输出路径 */
    private String outPath;
    /** 模板路径 */
    private String templatePath;
    /**
     * 数据库-type
     * @see com.dreammakerteam.entity.generate.DbTypeEnum
     */
    private DbTypeEnum dbType;



    public void configCheck() {
        ifNullThenThrow(dbUrl, "请先调用CodeGenerator的setDbUrl方法");
        ifNullThenThrow(dbUser, "请先调用CodeGenerator的setDbUser方法");
        ifNullThenThrow(dbPassword, "请先调用CodeGenerator的setDbPassword方法");
        ifNullThenThrow(dbType, "请先调用CodeGenerator的setDbType方法");
        ifNullThenThrow(tableNames, "请先调用CodeGenerator的setTableNames方法");
        ifNullThenThrow(templatePath, "请先调用CodeGenerator的setTemplatePath方法");
        if (tableNames.isEmpty()) {
            throw new IllegalArgumentException("tableNames至少需要一个元素");
        }
    }

    public void configInit() {
        if (genToStringMethod == null) {
            genToStringMethod = true;
        }
        if (genGetMethod == null) {
            genGetMethod = true;
        }
        if (genSetMethod == null) {
            genSetMethod = true;
        }
        if (userLombok == null) {
            userLombok = false;
        }
        if (outPath == null) {
            outPath = this.getClass().getClassLoader().getResource("").getPath() + "/out";
        }
        if (repositoryPackage == null) {
            repositoryPackage = "repository";
        }
        if (entityPackage == null) {
            entityPackage = "entity";
        }
        if (dtoPackage == null) {
            dtoPackage = "dto";
        }
        if (servicePackage == null) {
            servicePackage = "service";
        }
        if (serviceImplPackage == null) {
            serviceImplPackage = "service.impl";
        }
    }
    private void ifNullThenThrow(Object config, String msg) {
        if (config == null) {
            throw new IllegalArgumentException(msg);
        }
    }
}
