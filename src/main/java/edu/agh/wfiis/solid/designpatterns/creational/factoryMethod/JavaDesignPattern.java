package edu.agh.wfiis.solid.designpatterns.creational.factoryMethod;

public class JavaDesignPattern extends DesignPattern {

    private final RunnableCode patternCode;

    @Override
    RunnableCode getPatternCode() {
        return patternCode;
    }

    public JavaDesignPattern(String name, String patternCode) {
        super(name);

        JavaEnvironment.setUp();
        this.patternCode = JavaEnvironment.compile(patternCode);

    }
}
