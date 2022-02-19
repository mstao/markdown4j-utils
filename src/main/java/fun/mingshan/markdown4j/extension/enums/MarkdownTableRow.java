package fun.mingshan.markdown4j.extension.enums;

import java.lang.annotation.*;

/**
 * @author hanjuntao
 * @date 2022/2/19
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MarkdownTableRow {
    String name() default "";
}
