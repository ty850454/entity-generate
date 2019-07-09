package com.dreammakerteam.entity.generate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class TableInfo {
    private String tableName;
    private String targetName;
    private List<ColumnInfo> columns;
    private String comment;


}
