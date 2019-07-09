package com.dreammakerteam.entity.generate.mysql;


import com.dreammakerteam.entity.generate.JavaTypeEnum;

import java.util.HashMap;
import java.util.Map;

public enum MysqlColumnTypeEnum {
    /** */
    BIGINT("bigint", JavaTypeEnum.LONG),
    BIT("bit", JavaTypeEnum.BOOLEAN),
    DATETIME("datetime", JavaTypeEnum.DATE),
    DATE("date", JavaTypeEnum.DATE),
    TIMESTAMP("timestamp", JavaTypeEnum.DATE),
    VARCHAR("varchar", JavaTypeEnum.STRING),
    INT("int", JavaTypeEnum.INTEGER),
    TEXT("text", JavaTypeEnum.STRING),
    DECIMAL("decimal", JavaTypeEnum.BIG_DECIMAL),
    TINYINT("tinyint", JavaTypeEnum.INTEGER),
    FLOAT("float", JavaTypeEnum.DOUBLE),
    LONGTEXT("longtext", JavaTypeEnum.STRING),
    ;

    private String columnTypeStr;
    private JavaTypeEnum baseType;

    MysqlColumnTypeEnum(String columnTypeStr, JavaTypeEnum baseType) {
        this.columnTypeStr = columnTypeStr;
        this.baseType = baseType;
    }

    public String getColumnTypeStr() {
        return columnTypeStr;
    }

    public JavaTypeEnum getBaseType() {
        return baseType;
    }

    private static final Map<String, MysqlColumnTypeEnum> ALL_ENUM_MAP = new HashMap<>();

    static {
        for (MysqlColumnTypeEnum typeEnum : MysqlColumnTypeEnum.values()) {
            ALL_ENUM_MAP.put(typeEnum.getColumnTypeStr(), typeEnum);
        }
    }

    public static MysqlColumnTypeEnum valueOfByType(String str) {
        if (str == null) {
            return null;
        }
        return ALL_ENUM_MAP.get(str);
    }
}
