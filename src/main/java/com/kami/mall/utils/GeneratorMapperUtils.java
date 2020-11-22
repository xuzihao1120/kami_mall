package com.kami.mall.utils;


import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuzihao on 2020-11-19.
 */
public class GeneratorMapperUtils {


    @Test
   public  void test( ) throws Exception {
       List<String> warnings = new ArrayList<String>();
       boolean overwrite = true;
       ConfigurationParser cp = new ConfigurationParser(warnings);
       Configuration config = cp.parseConfiguration(
               GeneratorMapperUtils.class.getResourceAsStream("/generatorConfig.xml"));
       Context context=config.getContext("Mysql");
       List<TableConfiguration> configs= context.getTableConfigurations();
       for(TableConfiguration c:configs){
           c.setCountByExampleStatementEnabled(false);
           c.setUpdateByExampleStatementEnabled(false);
           c.setUpdateByPrimaryKeyStatementEnabled(false);
           c.setDeleteByExampleStatementEnabled(false);
           c.setSelectByExampleStatementEnabled(false);
           c.setInsertStatementEnabled(false);
       }
       DefaultShellCallback callback = new DefaultShellCallback(overwrite);
       MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
       myBatisGenerator.generate(null);

   }

}
