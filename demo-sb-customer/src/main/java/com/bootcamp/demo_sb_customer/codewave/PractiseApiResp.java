package com.bootcamp.demo_sb_customer.codewave;

public class PractiseApiResp<T> {
    private String code;
    private String message;
    private T data; 

    private PractiseApiResp(Builder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }

    public static <T>Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private String code;
        private String message;
        private T data;

        public Builder<T> syscode(SysCode sysCode) {
            this.code = sysCode.getCode();
            this.message = sysCode.getMessage();
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public PractiseApiResp<T> build() {
            return new PractiseApiResp<>(this);
        }
    } 

}
