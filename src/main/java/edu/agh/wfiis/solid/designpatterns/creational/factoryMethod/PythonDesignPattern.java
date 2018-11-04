package edu.agh.wfiis.solid.designpatterns.creational.factoryMethod;

public class PythonDesignPattern extends DesignPattern {

    private final RunnableCode patternCode;

    @Override
    RunnableCode getPatternCode() {
        return patternCode;
    }

    public PythonDesignPattern(String name, String patternCode) {
        super(name);

        PythonEnvironment.setUp();
        this.patternCode = PythonEnvironment.compile(patternCode);
    }
}
