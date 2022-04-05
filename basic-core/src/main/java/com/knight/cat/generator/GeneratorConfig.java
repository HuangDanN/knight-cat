package com.knight.cat.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.knight.cat.core.model.BaseModelParent;

import java.util.Collections;

/**
 * @author : xn-h
 * @date: 2022/4/4  16:07
 * @description: 代码生成器
 */
public class GeneratorConfig {

    private final static String DATASOURCE_URL = "jdbc:mysql://localhost:3306/basic-system";

    private final static String DATASOURCE_USER_NAME = "root";

    private final static String DATASOURCE_PASSWORD = "huang";

    private final static String AUTHOR = "xn-h";

    private final static String JAVA_PATH = "/Users/huang/Desktop/java-code/knight-cat/basic-core/src/main/java";

    private final static String XML_PATH = "/Users/huang/Desktop/java-code/knight-cat/basic-core/src/main/resources/mapper";

    public static void main(String[] args) {
        FastAutoGenerator.create(DATASOURCE_URL, DATASOURCE_USER_NAME, DATASOURCE_PASSWORD)
                .globalConfig(builder -> {
                    builder.author(AUTHOR) // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(JAVA_PATH); // 指定输出目录

                })
                .packageConfig(builder -> {
                    builder.parent("com.knight.cat") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .entity("model.po")
                            .service("service")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, XML_PATH)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder
                            .addInclude("t_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_")
                            .entityBuilder().superClass(BaseModelParent.class); // 设置过滤表前缀

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
