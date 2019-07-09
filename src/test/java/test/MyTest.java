package test;

import com.dreammakerteam.entity.generate.CodeGenerator;
import com.dreammakerteam.entity.generate.DbTypeEnum;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

@Slf4j
public class MyTest {

    @Test
    public void test1() throws ClassNotFoundException, SQLException, IOException, TemplateException {

        new CodeGenerator()
                .setDbType(DbTypeEnum.MYSQL)
//                .setDbUrl("jdbc:mysql://120.27.215.26:3306/testdb")
//                .setDbUser("testdb")
//                .setDbPassword("ijBNDxmwPBywdDbi")
                .setDbUrl("jdbc:mysql://m3306.tst.qiushibc.eju.local/test_signed?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8")
                .setDbUser("test_user")
                .setDbPassword("L^1NNbsKSeGjXJ3K")
                .setTableNames(Arrays.asList(
                        "tb_asset_project",
                        "tb_market_project",
                        "tb_order",
                        "tb_order_service",
                        "tb_payment",
                        "tb_project",
                        "tb_project_service",
                        "tb_transaction"
                ))
                .setTemplatePath("/Users/xuyang/workspase/repository/entitygenerate/src/main/resources")
                .setEntityPackage("com.example.movedata.domian")
                .setRepositoryPackage("com.example.movedata.repository")
                .setDtoPackage("com.example.movedata.dto")
                .setServicePackage("com.example.movedata.service")
                .setServiceImplPackage("com.example.movedata.service.impl")
                .setOutPath("/Users/xuyang/workspase/repository/entitygenerate/src/main/java")
                .setAuthor("xy")
                .gen();


    }

}
