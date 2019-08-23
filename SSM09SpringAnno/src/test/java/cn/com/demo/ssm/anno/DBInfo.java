package cn.com.demo.ssm.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DBInfo {
    String driverClassName();

    String url();

    String username() default "root";

    String password();

    int age();
}
