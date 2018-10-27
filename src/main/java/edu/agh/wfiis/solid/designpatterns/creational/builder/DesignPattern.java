package edu.agh.wfiis.solid.designpatterns.creational.builder;

import java.util.Objects;

public class DesignPattern {

    private final String name;

    private final String type;

    private final String code;

    private final String description;

    private final String example;

    public DesignPattern(String name, String type, String code, String description, String example) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(type);
        Objects.requireNonNull(code);

        this.name = name;
        this.type = type;
        this.code = code;
        this.description = description;
        this.example = example;
    }

    public static Builder builder(){
        return new Builder();
    }

    private static class Builder {

        private String name;

        private String type;

        private String code;

        private String description;

        private String example;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withExample(String example) {
            this.example = example;
            return this;
        }

        public DesignPattern build() {
            DesignPattern designPattern = new DesignPattern(name, type, code, description, example);
            return designPattern;
        }
    }

    public static void main(String args[]){
        DesignPattern designPattern = DesignPattern.builder().withName("Builder").withType("creational").build();
    }
}
