package com.ayoub.framework.validation.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    // ANSI escape codes for colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public record ValidationError(String field, String message){

    }

    public static List<ValidationError> validate(Object obj) throws IllegalAccessException {

        List<ValidationError> errors = new ArrayList<>();
        // get object class
        Class<?> clazz = obj.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            // @NotNull Annotation
            if (field.isAnnotationPresent(NotNull.class)){
                NotNull annotation = field.getAnnotation(NotNull.class);
                Object value = field.get(obj);

                if (value == null) {
                    errors.add(new ValidationError(field.getName(), annotation.message()));
                }

             // @Range Annotation
            } else if (field.isAnnotationPresent(Range.class)) {
                Range range = field.getAnnotation(Range.class);
                Object value = field.get(obj);

                /*if (!((int)value >= annotation.min() && (int)value <= annotation.max())){  => not save */
                if (value instanceof Number num){
                    double doubleValue = num.doubleValue(); // this will support int, double, float ... => so it's better
                    if (doubleValue < range.min() || doubleValue > range.max()){
                        errors.add(new ValidationError(field.getName(), range.message()));
                    }
                } else if (value != null) {
                    errors.add(new ValidationError(field.getName(), "@Range can only be numeric field :)"));
                }
             // @Email Annotation
            } else if (field.isAnnotationPresent(Email.class)) {
                Email email = field.getAnnotation(Email.class);
                Object value = field.get(obj);
                final Pattern pattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

                if (value == null) {
                    errors.add(new ValidationError(field.getName(), email.message()));

                } else if (!(value instanceof String)) {
                    errors.add(new ValidationError(field.getName(), "Invalid Email => should be string :)"));
                } else if (value instanceof String str) {
                    String stringValue = str.toString();
                    if (!pattern.matcher(stringValue).matches()){
                        errors.add(new ValidationError(field.getName(), "Invalid Email :)"));
                    }
                }
            }
        }
        return errors;
    }

    public static void printErrors(List<ValidationError> errors) {
        if (errors.isEmpty()) {
            System.out.println(ANSI_GREEN + "✅ All validations passed!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "❌ Validation failed with " + errors.size() + " error(s):" + ANSI_RESET);
            errors.forEach(e -> System.err.println(ANSI_RED + "  - " + e.field() + ": " + e.message() + ANSI_RESET));
        }
    }
}