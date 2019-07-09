package com.dreammakerteam.entity.generate;

import com.dreammakerteam.entity.generate.exception.CodeGenException;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public abstract class AbstractDataHandle implements DataHandle {

    private CodeGeneratorConfig config;

    public AbstractDataHandle(CodeGeneratorConfig config) {
        try {
            Class.forName(getDriverClass());
        } catch (ClassNotFoundException e) {
            log.error("驱动类{}不存在", getDriverClass(), e);
        }
        this.config = config;
    }

    protected List<String[]> select(String sql) {
        try(Connection con = DriverManager.getConnection(config.getDbUrl(),config.getDbUser(),config.getDbPassword())) {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ArrayList<String[]> result = new ArrayList<>();
                try (ResultSet resultSet = ps.executeQuery()) {
                    int columnCount = resultSet.getMetaData().getColumnCount();
                    while (resultSet.next()) {
                        String[] row = new String[columnCount];
                        for (int i = 0; i < columnCount; ++i) {
                            row[i] = resultSet.getString(i + 1);
                        }
                        result.add(row);
                    }
                }
                return result;
            }
        } catch (SQLException e) {
            log.info("数据库连接发生异常", e);
            throw new CodeGenException("连接数据库失败");
        }
    }


}
