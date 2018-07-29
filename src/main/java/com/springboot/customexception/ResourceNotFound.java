package com.springboot.customexception;

public class ResourceNotFound extends RuntimeException{
	
    
	private static final long serialVersionUID = -8662826151649369553L;
	private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFound( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}


