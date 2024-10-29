package com.cls0110.restapi;

public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;

    private String objectName;

    private Object objectValue;

    public ResourceNotFoundException(String resourceName, String objectName, Object objectValue) {
        super(String.format("%s:%s Does Not Exist : %s", resourceName, objectName, objectValue));
        this.resourceName = resourceName;
        this.objectName = objectName;
        this.objectValue = objectValue;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setObjectValue(Object objectValue) {
        this.objectValue = objectValue;
    }
}
