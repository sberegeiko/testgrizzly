package by.beregeiko.testgrizzly.validator;

import by.beregeiko.testgrizzly.model.ReportSearchForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link ReportSearchForm} class,
 * implements {@link Validator} interface.
 *
 * @author Think
 */

@Component
public class ReportValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ReportSearchForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "startDate", "Required");
        ValidationUtils.rejectIfEmpty(errors, "endDate", "Required");
        ValidationUtils.rejectIfEmpty(errors, "performer", "Required");
    }
}
