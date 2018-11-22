package edu.agh.wfiis.solid.designpatterns.creational.builder;

public class DesignPattern {
    private final String name;

    private final String type;

    private final String code;

    private final String description;

    private final String example;

    public static NeedName builder(){
        return new Builder();
    }

    private DesignPattern(
            String name,
            String type,
            String code,
            String description,
            String example
    ) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.description = description;
        this.example = example;
    }

    private static class Builder implements BuildingDesignPattern {
        private String name;
        private String type;
        private String code;
        private String description;
        private String example;

        @Override
        public NeedType name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public NeedCode type(String type) {
            this.type = type;
            return this;
        }

        @Override
        public BuildOrExpand code(String code) {
            this.code = code;
            return this;
        }

        @Override
        public NeedOptional with() {
            return this;
        }

        @Override
        public BuildOrExpand description(String description) {
            this.description = description;
            return this;
        }

        @Override
        public BuildOrExpand example(String example) {
            this.example = example;
            return this;
        }

        @Override
        public DesignPattern build() {
            return new DesignPattern(name, type, code, description, example);
        }
    }

    interface BuildingDesignPattern extends NeedName, NeedType, NeedCode, NeedOptional, BuildOrExpand {}

    interface NeedName {
        NeedType name(String name);
    }

    interface NeedType {
        NeedCode type(String type);
    }

    interface NeedCode {
        BuildOrExpand code(String code);
    }

    interface BuildOrExpand {
        NeedOptional with();
        DesignPattern build();
    }

    interface NeedOptional {
        BuildOrExpand description(String description);
        BuildOrExpand example(String example);
    }

    public static void main(String args[]){
        DesignPattern builder = DesignPattern.builder()
                                             .name("Builder")
                                             .type("creational")
                                             .code("Some builder code")
                                             .build();

        DesignPattern strategy = DesignPattern.builder()
                                              .name("Strategy")
                                              .type("behavioral")
                                              .code("Some strategy code")
                                              .with().description("This is a strategy pattern")
                                              .with().example("Some strategy example")
                                              .build();
    }
}
