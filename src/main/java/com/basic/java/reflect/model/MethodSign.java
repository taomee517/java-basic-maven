package com.basic.java.reflect.model;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodSign {
    String name() default "undefine";
}
