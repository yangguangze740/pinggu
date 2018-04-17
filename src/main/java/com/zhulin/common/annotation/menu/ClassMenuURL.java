package com.zhulin.common.annotation.menu;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassMenuURL {
    String value() default "";
    String group() default "";
    String name() default "";
    String groupName() default "";
}
