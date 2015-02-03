package br.ufc.quixada.spa.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.ufc.quixada.npi.model.ResponseStatusMessage;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = Exception.class)
	public @ResponseBody ResponseStatusMessage defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		System.out.println("*** GlobalControllerExceptionHandler ***");
		// If the exception is annotated with @ResponseStatus rethrow it and let
		// the framework handle it - like the OrderNotFoundException example
		// at the start of this post.
		// AnnotationUtils is a Spring Framework utility class.
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
			throw e;

		return new ResponseStatusMessage(br.ufc.quixada.npi.enumeration.ResponseStatus.ERROR, e.getMessage());
	}

}
