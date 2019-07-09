package com.dreammakerteam.entity.generate;


import com.dreammakerteam.entity.generate.exception.CodeGenException;
import com.dreammakerteam.entity.generate.utils.CaseUtil;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 代码生成器
 * @author xy
 */
@Slf4j
public class CodeGenerator {

    private static final Random RANDOM = new Random();
    private CodeGeneratorConfig config = new CodeGeneratorConfig();
    private Configuration cfg;
    private File repositoryDir;
    private File entityDir;
    private File dtoDir;
    private File serviceDir;
    private File serviceImplDir;

    public void gen() throws TemplateException, IOException {
        log.info("开始生成");
        config.configCheck();
        config.configInit();
        repositoryDir = createDir(config.getRepositoryPackage());
        entityDir = createDir(config.getEntityPackage());
        dtoDir = createDir(config.getDtoPackage());
        serviceDir = createDir(config.getServicePackage());
        serviceImplDir = createDir(config.getServiceImplPackage());

        log.info("选择数据库{}", config.getDbType());

        DataHandle dataHandle = DataHandleFactory.getDataHandle(config);
        initConfiguration();

        for (String tableName : config.getTableNames()) {
            log.info("处理表-{}", tableName);
            TableInfo tableInfo = dataHandle.getTableInfo(tableName);
            genEntity(tableInfo);
            genRepository(tableInfo);
            genService(tableInfo);
            genServiceImpl(tableInfo);
        }

    }

    private void genService(TableInfo tableInfo) throws IOException, TemplateException {
        Map<String, Object> root = new HashMap<>(8);
        root.put("package", config.getServicePackage());
        root.put("comment", tableInfo.getComment());
        root.put("className", tableInfo.getTargetName() + "Service");
        root.put("author", config.getAuthor());

        outfile(root, serviceDir.getAbsolutePath() + "/" + tableInfo.getTargetName() + "Service.java", "service.ftl");
    }

    private void genServiceImpl(TableInfo tableInfo) throws IOException, TemplateException {
        Map<String, Object> root = new HashMap<>(32);
        root.put("author", config.getAuthor());
        root.put("comment", tableInfo.getComment());
        root.put("package", config.getServiceImplPackage());
        root.put("className", tableInfo.getTargetName() + "ServiceImpl");
        root.put("interfacePackage", config.getServicePackage());
        root.put("interfaceClassName", tableInfo.getTargetName() + "Service");
        root.put("entityPackage", config.getEntityPackage());
        root.put("entityClassName", tableInfo.getTargetName() + "Entity");
        root.put("dtoPackage", config.getDtoPackage());
        root.put("dtoClassName", tableInfo.getTargetName() + "DTO");
        root.put("columns", tableInfo.getColumns());
        root.put("repositoryClassName", tableInfo.getTargetName() + "Repository");
        root.put("repositoryName", CaseUtil.firstLowerCase(tableInfo.getTargetName()) + "Repository");
        root.put("repositoryPackage", config.getRepositoryPackage());
        outfile(root, serviceImplDir.getAbsolutePath() + "/" + tableInfo.getTargetName() + "ServiceImpl.java", "serviceImplWithLombok.ftl");
    }

    private void initConfiguration() throws IOException {
        cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File(config.getTemplatePath()));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
    }

    private File createDir(String packageName) {
        File dir = new File(config.getOutPath() + '/' + packageToDir(packageName));
        if (!dir.exists() && !dir.mkdirs()) {
            throw new CodeGenException("无法创建文件夹" + dir.getPath());
        }
        return dir;
    }

    private void genRepository(TableInfo tableInfo) throws IOException, TemplateException {
        Map<String, Object> root = new HashMap<>(16);
        root.put("package", config.getRepositoryPackage());
        root.put("className", tableInfo.getTargetName() + "Repository");
        root.put("entityName", tableInfo.getTargetName() + "Entity");
        root.put("entityPackage", config.getEntityPackage());
        root.put("comment", tableInfo.getComment());
        root.put("author", config.getAuthor());

        String keyType = null;
        for (ColumnInfo column : tableInfo.getColumns()) {
            if (column.getPrimaryKey()) {
                keyType = column.getJavaType().getClassName();
                root.put("keyType", keyType);
                break;
            }
        }
        if (keyType == null) {
            log.warn("表[{}]无主键，无法生成repository", tableInfo.getTableName());
            return;
        }

        outfile(root, repositoryDir.getAbsolutePath() + "/" + tableInfo.getTargetName() + "Repository.java", "repository.ftl");
    }

    private void outfile(Map<String, Object> params, String filePath, String template) throws IOException, TemplateException {
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8)) {
            cfg.getTemplate(template).process(params, outputStreamWriter);
        }
    }

    private void genEntity(TableInfo tableInfo) throws IOException, TemplateException {
        Map<String, Object> root = new HashMap<>(8);
        root.put("table", tableInfo);
        root.put("package", config.getEntityPackage());
        root.put("author", config.getAuthor());
        root.put("serialVersionUID", String.valueOf(RANDOM.nextLong()));
        root.put("className", tableInfo.getTargetName() + "Entity");

        // 导入包信息
        ArrayList<String> importInfo = new ArrayList<>(tableInfo.getColumns().size());
        for (ColumnInfo column : tableInfo.getColumns()) {
            String importStr = column.getType().getBaseType().getImportStr();
            if (importStr != null && !importInfo.contains(importStr)) {
                importInfo.add(importStr);
            }
        }
        root.put("imports", importInfo);

        // 字段信息
        root.put("columns", tableInfo.getColumns());

        outfile(root, entityDir.getAbsolutePath() + "/" + tableInfo.getTargetName() + "Entity.java", "entityWithLombok.ftl");

        root.put("package", config.getDtoPackage());
        root.put("serialVersionUID", String.valueOf(RANDOM.nextLong()));
        root.put("className", tableInfo.getTargetName() + "DTO");
        outfile(root, dtoDir.getAbsolutePath() + "/" + tableInfo.getTargetName() + "DTO.java", "dtoWithLombok.ftl");
    }

    private String packageToDir(String packageName) {
        return packageName.replace('.', '/');
    }

    public CodeGenerator setAuthor(String author) {
        config.setAuthor(author);
        return this;
    }

    public CodeGenerator setEntityPackage(String entityPackage) {
        config.setEntityPackage(entityPackage);
        return this;
    }

    public CodeGenerator setGenToStringMethod(Boolean genToStringMethod) {
        config.setGenToStringMethod(genToStringMethod);
        return this;
    }

    public CodeGenerator setGenGetMethod(Boolean genGetMethod) {
        config.setGenGetMethod(genGetMethod);
        return this;
    }

    public CodeGenerator setGenSetMethod(Boolean genSetMethod) {
        config.setGenSetMethod(genSetMethod);
        return this;
    }

    public CodeGenerator setUserLombok(Boolean userLombok) {
        config.setUserLombok(userLombok);
        return this;
    }

    public CodeGenerator setDbUrl(String dbUrl) {
        config.setDbUrl(dbUrl);
        return this;
    }

    public CodeGenerator setDbUser(String dbUser) {
        config.setDbUser(dbUser);
        return this;
    }

    public CodeGenerator setDbPassword(String dbPassword) {
        config.setDbPassword(dbPassword);
        return this;
    }

    public CodeGenerator setDbType(DbTypeEnum dbType) {
        config.setDbType(dbType);
        return this;
    }

    public CodeGenerator setTableNames(List<String> tableNames) {
        config.setTableNames(tableNames);
        return this;
    }
    public CodeGenerator setTemplatePath(String templatePath) {
        config.setTemplatePath(templatePath);
        return this;
    }
    public CodeGenerator setOutPath(String outPath) {
        config.setOutPath(outPath);
        return this;
    }
    public CodeGenerator setDtoPackage(String dtoPackage) {
        config.setDtoPackage(dtoPackage);
        return this;
    }
    public CodeGenerator setServicePackage(String servicePackage) {
        config.setServicePackage(servicePackage);
        return this;
    }
    public CodeGenerator setServiceImplPackage(String serviceImplPackage) {
        config.setServiceImplPackage(serviceImplPackage);
        return this;
    }
    public CodeGenerator setRepositoryPackage(String repositoryPackage) {
        config.setRepositoryPackage(repositoryPackage);
        return this;
    }
    public CodeGeneratorConfig getConfig() {
        return config;
    }

    public CodeGenerator setConfig(CodeGeneratorConfig config) {
        this.config = config;
        return this;
    }
}
