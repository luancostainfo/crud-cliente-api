package br.com.gs3.desafio.api.exception;

import br.com.gs3.desafio.domain.service.exception.RecursoNaoEncontradoException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Object> handleRecursoNaoEncontrado(RecursoNaoEncontradoException ex, WebRequest request) {

        var status = HttpStatus.NOT_FOUND;
        var body = ProblemDetail.builder()
                .status(status.value())
                .title("Recurso não encontrado.")
                .detail(ex.getMessage())
                .build();

        return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var invalidParams = getFieldErrors(ex);

        var body = ProblemDetail.builder()
                .status(status.value())
                .detail("Existem problemas de validação na requisição.")
                .params(invalidParams)
                .build();

        return handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ProblemDetail body;

        if (ex.getCause() instanceof UnrecognizedPropertyException) {

            body = ProblemDetail.builder()
                    .status(status.value())
                    .title("Propriedade desconhecida.")
                    .detail("Você está tentando enviar uma propriedade desconhecida na requisição.")
                    .build();
        } else {
            body = ProblemDetail.builder()
                    .status(status.value())
                    .title("Mensagem não legível.")
                    .detail("Verifique a requisição e tente novamente.")
                    .build();
        }
        return handleExceptionInternal(ex, body, headers, status, request);
    }

    private List<InvalidParam> getFieldErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError ->
                        InvalidParam.builder()
                                .param(fieldError.getField())
                                .message(messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()))
                                .build()
                )
                .collect(Collectors.toList());
    }
}
