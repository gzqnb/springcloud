package com.atguigu.common.valid;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: gzq
 * @Date: 2021/3/20 - 03 - 20 - 12:54
 * @Description: com.atguigu.common.valid
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {
    private Set<Integer> set = new HashSet<>();

    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        for (int val : vals) {
            set.add(val);
        }

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {

        return set.contains(value);
    }
}
