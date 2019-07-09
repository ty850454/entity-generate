package com.dreammakerteam.entity.generate;

import com.dreammakerteam.entity.generate.exception.CodeGenException;
import com.dreammakerteam.entity.generate.mysql.MysqlDataHandle;

public class DataHandleFactory {

    private DataHandleFactory() {}


    public static DataHandle getDataHandle(CodeGeneratorConfig config) {
        DataHandle dataHandle;
        switch (config.getDbType()) {
            case MYSQL:
                dataHandle = new MysqlDataHandle(config);
                break;
            case ORACLE:
                throw new CodeGenException("该类型尚未实现");
            default:
                throw new CodeGenException("该类型尚未实现");
        }
        return dataHandle;
    }

}
