package raven.webpos.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;
import raven.webpos.exception.RequestValidationException;
import raven.webpos.infrastructure.model.request.BaseRequest;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RequestValidator<T extends BaseRequest> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validation = factory.getValidator();

    public void validate(T request) {
        Set<ConstraintViolation<T>> violations = validation.validate(request);
        if (!violations.isEmpty()) {
            Set<String> error = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
            throw new RequestValidationException(error, request.getClass().getSimpleName());
        }
    }
}
