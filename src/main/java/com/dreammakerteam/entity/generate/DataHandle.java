package com.dreammakerteam.entity.generate;


public interface DataHandle {

    TableInfo getTableInfo(String tableName);

    boolean canHandle(DbTypeEnum dbTypeEnum);

    String getDriverClass();

}
