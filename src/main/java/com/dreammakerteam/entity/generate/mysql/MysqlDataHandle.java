package com.dreammakerteam.entity.generate.mysql;

import com.dreammakerteam.entity.generate.AbstractDataHandle;
import com.dreammakerteam.entity.generate.CodeGeneratorConfig;
import com.dreammakerteam.entity.generate.ColumnInfo;
import com.dreammakerteam.entity.generate.ColumnTypeScope;
import com.dreammakerteam.entity.generate.DbTypeEnum;
import com.dreammakerteam.entity.generate.TableInfo;
import com.dreammakerteam.entity.generate.exception.CodeGenException;
import com.dreammakerteam.entity.generate.utils.CaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MysqlDataHandle extends AbstractDataHandle {

    public MysqlDataHandle(CodeGeneratorConfig config) {
        super(config);
    }

    @Override
    public TableInfo getTableInfo(String tableName) {
        TableInfo tableInfo = new TableInfo();
        setTableInfo(tableName, tableInfo);
        setColumnInfo(tableName, tableInfo);
        return tableInfo;
    }

    private void setColumnInfo(String tableName, TableInfo tableInfo) {
        List<String[]> resultSet = select("SHOW FULL COLUMNS FROM " + tableName);
        ArrayList<ColumnInfo> columnInfos = new ArrayList<>();

        for (String[] result : resultSet) {
            columnInfos.add(getColumnInfo(result));
        }

        tableInfo.setColumns(columnInfos);
    }

    private ColumnInfo getColumnInfo(String[] result) {
        ColumnInfo columnInfo = new ColumnInfo();
        StringBuilder columnDefinition = new StringBuilder();

        // 列名
        String name = result[0];
        columnInfo.setColumnName(name);

        // 字段名
        columnInfo.setFieldName(CaseUtil.toLowerCamelCase(name));
        columnInfo.setUpperCamelCaseFieldName(CaseUtil.toUpperCamelCase(name));

        // 字段类型
        String typeStr = result[1];
        int leftBracketIndex = typeStr.indexOf('(');
        if (leftBracketIndex != -1) {
            int rightBracketIndex = typeStr.indexOf(')', leftBracketIndex + 1);
            String scope = typeStr.substring(leftBracketIndex + 1, rightBracketIndex);
            String[] scopeArr = scope.split(",");
            if (scopeArr.length > 0 && scopeArr[0] != null) {
                Integer length = Integer.valueOf(scopeArr[0]);
                if (scopeArr.length == 2 && scopeArr[1] != null) {
                    columnInfo.setPrecision(length);
                    columnInfo.setScale(Integer.valueOf(scopeArr[1]));
                } else if (length != 255) {
                    columnInfo.setLength(length);
                }
            }
            typeStr = typeStr.substring(0, leftBracketIndex);
        }
        MysqlColumnTypeEnum columnTypeEnum = MysqlColumnTypeEnum.valueOfByType(typeStr);
        if (columnTypeEnum == null) {
            throw new IllegalArgumentException("不支持的字段类型[" + typeStr + "]");
        }
        columnInfo.setType(columnTypeEnum);
        columnInfo.setJavaType(columnTypeEnum.getBaseType());
        columnDefinition.append(result[1]);

        // 知否可空
        if (Objects.equals("NO", result[3])) {
            columnInfo.setNullable(false);
            columnDefinition.append(" NOT NULL");

            if (result[5] != null) {
                // 默认值

                if (result[5].contains("'") || result[5].equals("CURRENT_TIMESTAMP")) {
                    columnDefinition.append(" DEFAULT ").append(result[5]);
                } else {
                    columnDefinition.append(" DEFAULT \'").append(result[5]).append('\'');
                }
            }
        } else {
            columnInfo.setNullable(true);
            columnDefinition.append(" DEFAULT NULL");
        }




        // 注释
        String comment = result[8];
        if (comment != null && comment.length() > 0) {
            columnInfo.setComment(comment);
            columnDefinition.append(" COMMENT \'").append(result[8]).append('\'');
        }

        // 是否主键
        if (Objects.equals("PRI", result[4])) {
            columnInfo.setPrimaryKey(true);

            // 主键是否自增
            if (Objects.equals("auto_increment", result[6])) {
                columnInfo.setAutoIncrement(true);
                columnDefinition.append(" AUTO_INCREMENT");
            } else {
                columnInfo.setAutoIncrement(false);
            }
        } else {
            columnInfo.setPrimaryKey(false);
            columnInfo.setAutoIncrement(false);
            columnInfo.setColumnDefinition(columnDefinition.toString());
        }


        return columnInfo;
    }

    private void setTableInfo(String tableName, TableInfo tableInfo) {
        List<String[]> resultSet = select("SHOW TABLE STATUS WHERE name='" + tableName + "'");

        if (resultSet.isEmpty()) {
            throw new CodeGenException("表[" + tableName + "]不存在");
        }
        String[] result = resultSet.get(0);

        tableInfo.setTableName(tableName);
        tableInfo.setTargetName(CaseUtil.toUpperCamelCase(tableName));
        String comment = result[17];
        if (comment != null && comment.length() > 0) {
            tableInfo.setComment(comment);
        }
    }

    @Override
    public boolean canHandle(DbTypeEnum dbTypeEnum) {
        return DbTypeEnum.MYSQL.equals(dbTypeEnum);
    }

    @Override
    public String getDriverClass() {
        return "com.mysql.cj.jdbc.Driver";
    }
}
