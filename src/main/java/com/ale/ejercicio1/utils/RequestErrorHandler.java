package com.ale.ejercicio1.utils;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

@Component
public class RequestErrorHandler {
	public Map<String, List<String>> mapErrors(List<FieldError> fieldErrors){
		Map<String, List<String>> mappedErrors = new HashMap<>();
		fieldErrors.stream().forEach(e -> {
			String key = e.getField() + "_errors";
			List<String> errors = mappedErrors.get(key);
			
			if (errors == null) errors = new ArrayList<>();
			errors.add(e.getDefaultMessage());
			mappedErrors.put(key, errors);
		});
		return mappedErrors;
		
	}
}
