package cn.itcast.aop;

import java.lang.annotation.*;

/**
 * 声明日志的注解
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Log {
}
