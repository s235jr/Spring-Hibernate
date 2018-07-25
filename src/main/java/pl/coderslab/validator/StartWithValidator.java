package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class StartWithValidator implements ConstraintValidator<StartWith, String> {

    private String start;

    @Override
    public void initialize(StartWith startWith) {
       this.start = startWith.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.startsWith(start);
    }
}
