package raven.webpos.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public class RequestValidationException extends RuntimeException {

    private final Set<String> violations;
    private final String violationSource;
}
