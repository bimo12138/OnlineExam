package com.bimo.OnlineExam;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

/**
 * @ClassName: MybatisPlusGenerate
 * @Author: 13716
 * @Date: 2020/7/25 19:43
 * @Version: 1.0
 **/


public class MybatisPlusGenerate {
    @Test
    public void generate() {
        // 获取全局配置，功能位置
        GlobalConfig globalConfig = new GlobalConfig();
        // 获取项目文件夹路径 例如 D:\java\OnlineExam
        String projectPath = System.getProperty("user.dir");
        /**
         * 全局配置
         */
        globalConfig
                .setActiveRecord(true)                          // 开启 AR 模式, 一个非常强大的功能, 目测比django 的 orm 还强大
                .setAuthor("bimo")                              // 设置 作者
                .setOutputDir(projectPath + "/src/main/java")   // 配置生成器之后的生成路径
                .setFileOverride(true)                          // 启动文本覆盖
                .setIdType(IdType.AUTO)                         // 主键策略
                .setServiceName("%sService")                    // 配置生成的 service 接口 的开始是否为 I 例如 IUserService
                .setBaseResultMap(true)                         // 生成基本的结果映射文件
                .setBaseColumnList(true);                       // 生成基本的 SQL 片段
        /**
         * 数据源配置
         */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig
                .setDbType(DbType.MYSQL)                        // 配置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://192.168.245.129:3306/onlineExam")
                .setUsername("bimo")
                .setPassword("qwe123");

        /**
         * 策略配置
         */
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)                               // 配置 大写命名 模式
                .setColumnNaming(NamingStrategy.underline_to_camel) // 配置 数据库的是下划线，实体类是驼峰命名的方法
                .setNaming(NamingStrategy.underline_to_camel)       // 数据库映射到实体类的命名
                .setEntityLombokModel(true)                         // 生成的实体类允许使用 lombok
                .setRestControllerStyle(true);                      // 生成的 controller 使用RestController

        /**
         * 包名配置
         */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig
                .setParent("com.bimo.OnlineExam")                   // 设置父级菜单
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("pojo")
                .setXml("mapper");

        /**
         * 整合配置
         */
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator
                .setGlobalConfig(globalConfig)
                .setStrategy(strategyConfig)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig);

        /**
         * 执行代码生成器
         */
        autoGenerator.execute();
    }
}
