package tech.ahub.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
// Provide an ease of writing commands
public @interface Command {
    String subcommand();
    String description() default "Another command";
}
