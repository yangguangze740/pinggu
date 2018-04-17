package com.zhulin.common.annotation.permission;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassRolePermission {
    String value() default "";
    String group() default "";
    String name() default "";
}
