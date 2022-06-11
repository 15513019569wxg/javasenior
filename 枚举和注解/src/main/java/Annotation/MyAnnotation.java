package Annotation;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

/**
 * 注解的声明需要使用@interface
 * @author shkstart
 * @create 2019 上午 11:56
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME) // 说明注解被保留在哪一个阶段
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
    String value() default "hello";
}
