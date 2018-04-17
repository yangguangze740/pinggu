package com.zhulin.common.annotation.permission;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodRolePermission {
    String value() default "";
    String group() default "";
    String name() default "";
    String groupName() default "";
}
