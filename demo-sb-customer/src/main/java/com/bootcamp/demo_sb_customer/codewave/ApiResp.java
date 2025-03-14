package com.bootcamp.demo_sb_customer.codewave;

// compile time is generic, but runtime is decided
// 如果 share 唔用 lombok, 因為受

public class ApiResp<T> {

    private String code;
    private String message;
    private T data;

    // can call by outside
    public static <T>Builder<T> builder() {
        return new Builder<>();
    }

    // constructor
    public ApiResp(Builder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    // class for Builder<T>
    public static class Builder<T> {
        private String code;
        private String message;
        private T data;

        public Builder<T> syscode(SysCode sysCode) {
            this.code = sysCode.getCode(); // "this" refers to the current Builder<T>
            this.message = sysCode.getMessage();
            return this;
        }

        // There is a naming conflict between a parameter and an instance 
        // variable.
        // You want to make it clear that you are referring to the
        //  instance variable



        public Builder<T> code(String code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiResp<T> build() {
            return new ApiResp<>(this);
        }
    }
}
