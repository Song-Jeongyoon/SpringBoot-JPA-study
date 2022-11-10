package com.springboot.valid_exception.common;

public class Constants {

    public enum ExceptionClass{

        PRODUCT("Product");

        private String exceptionClass;

        ExceptionClass(String exceptionClass) {
            this.exceptionClass = this.exceptionClass;
        }

        public String getExceptionClass() {
            return exceptionClass;
        }

        @Override
        public String toString() {
            return getExceptionClass() + "Exception. ";
        }

    }

}
