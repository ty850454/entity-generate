package com.dreammakerteam.entity.generate;

public enum JavaTypeEnum {
    /** */
    LONG("Long"),
    DATE("Date", "java.util.Date"),
    STRING("String"),
    INTEGER("Integer"),
    BIG_DECIMAL("BigDecimal", "java.math.BigDecimal"),
    BOOLEAN("Boolean"),
    DOUBLE("Double"),
    ;


    JavaTypeEnum(String className, String importStr) {
        this.className = className;
        this.importStr = importStr;
    }

    JavaTypeEnum(String className) {
        this.className = className;
    }

    private String className;
    private String importStr;

    public String getClassName() {
        return className;
    }

    public String getImportStr() {
        return importStr;
    }
}
