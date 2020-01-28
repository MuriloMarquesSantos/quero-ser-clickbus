package com.clickbus.placesmanager.exception;

public class ResourceNotFoundException extends RuntimeException{

        private static final long serialVersionUID = 1L;

        public ResourceNotFoundException() {
            this(null);
        }

        public ResourceNotFoundException(String message){
            super(message);
        }
}
