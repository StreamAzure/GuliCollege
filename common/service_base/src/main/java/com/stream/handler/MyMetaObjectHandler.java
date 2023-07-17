package com.stream.handler;


import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler{
    // 实现数据库表项中的gmtCreate和gmtModified字段的自动填充
    // 具体使用方法为在对应的实体类中的字段上加上注解@TableField(fill = FieldFill.INSERT)和@TableField(fill = FieldFill.INSERT_UPDATE)
    @Override
    public void insertFill(MetaObject metaObject){
        // 注意，第一个参数为对应类中的属性名称，而不是数据库中对应的字段名称
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
    @Override
    public void updateFill(MetaObject metaObject){
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
