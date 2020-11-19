package com.kami.mall.config;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.util.StringUtility;

import java.math.BigDecimal;
import java.util.*;

public class MyJavaTypeResolver implements JavaTypeResolver {

    protected List<String> warnings;
    protected Properties properties = new Properties();
    protected Context context;
    protected boolean forceBigDecimals;
    protected Map<Integer, JdbcTypeInformation> typeMap = new HashMap();

    public MyJavaTypeResolver() {
        this.typeMap.put(2003, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("ARRAY", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(-5, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("BIGINT", new FullyQualifiedJavaType(Long.class.getName())));
        this.typeMap.put(-2, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("BINARY", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(-7, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("BIT", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(2004, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("BLOB", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(16, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("BOOLEAN", new FullyQualifiedJavaType(Boolean.class.getName())));
        this.typeMap.put(1, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("CHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(2005, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("CLOB", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(70, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("DATALINK", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(91, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("DATE", new FullyQualifiedJavaType(Date.class.getName())));
        this.typeMap.put(2001, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("DISTINCT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(8, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("DOUBLE", new FullyQualifiedJavaType(Double.class.getName())));
        this.typeMap.put(6, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("FLOAT", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(4, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("INTEGER", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(2000, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("JAVA_OBJECT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(-16, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("LONGNVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(-4, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("LONGVARBINARY", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(-1, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("LONGVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(-15, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("NCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(2011, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("NCLOB", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(-9, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("NVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(0, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("NULL", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(1111, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("OTHER", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(7, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("REAL", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(2006, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("REF", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(5, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("SMALLINT", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(2002, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("STRUCT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(92, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("TIME", new FullyQualifiedJavaType(Date.class.getName())));
        this.typeMap.put(93, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("TIMESTAMP", new FullyQualifiedJavaType(Date.class.getName())));
        this.typeMap.put(-6, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(-3, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("VARBINARY", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(12, new com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation("VARCHAR", new FullyQualifiedJavaType(String.class.getName())));
    }

    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        this.forceBigDecimals = StringUtility.isTrue(properties.getProperty("forceBigDecimals"));
    }

    public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn) {
        com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation jdbcTypeInformation = (com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation)this.typeMap.get(introspectedColumn.getJdbcType());
        FullyQualifiedJavaType answer;
        if (jdbcTypeInformation == null) {
            switch(introspectedColumn.getJdbcType()) {
                case 2:
                case 3:
                    if (introspectedColumn.getScale() <= 0 && introspectedColumn.getLength() <= 18 && !this.forceBigDecimals) {
                        if (introspectedColumn.getLength() > 9) {
                            answer = new FullyQualifiedJavaType(Long.class.getName());
                        } else if (introspectedColumn.getLength() > 4) {
                            answer = new FullyQualifiedJavaType(Integer.class.getName());
                        } else {
                            answer = new FullyQualifiedJavaType(Short.class.getName());
                        }
                    } else {
                        answer = new FullyQualifiedJavaType(BigDecimal.class.getName());
                    }
                    break;
                default:
                    answer = null;
            }
        } else {
            answer = jdbcTypeInformation.getFullyQualifiedJavaType();
        }

        return answer;
    }

    public String calculateJdbcTypeName(IntrospectedColumn introspectedColumn) {
        com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation jdbcTypeInformation = (com.kami.mall.config.MyJavaTypeResolver.JdbcTypeInformation)this.typeMap.get(introspectedColumn.getJdbcType());
        String answer;
        if (jdbcTypeInformation == null) {
            switch(introspectedColumn.getJdbcType()) {
                case 2:
                    answer = "NUMERIC";
                    break;
                case 3:
                    answer = "DECIMAL";
                    break;
                default:
                    answer = null;
            }
        } else {
            answer = jdbcTypeInformation.getJdbcTypeName();
        }

        return answer;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static class JdbcTypeInformation {
        private String jdbcTypeName;
        private FullyQualifiedJavaType fullyQualifiedJavaType;

        public JdbcTypeInformation(String jdbcTypeName, FullyQualifiedJavaType fullyQualifiedJavaType) {
            this.jdbcTypeName = jdbcTypeName;
            this.fullyQualifiedJavaType = fullyQualifiedJavaType;
        }

        public String getJdbcTypeName() {
            return this.jdbcTypeName;
        }

        public FullyQualifiedJavaType getFullyQualifiedJavaType() {
            return this.fullyQualifiedJavaType;
        }
    }
}
