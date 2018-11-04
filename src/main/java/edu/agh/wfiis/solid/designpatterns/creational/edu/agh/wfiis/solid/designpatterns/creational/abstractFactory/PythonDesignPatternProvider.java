package edu.agh.wfiis.solid.designpatterns.creational.edu.agh.wfiis.solid.designpatterns.creational.abstractFactory;

import java.util.Objects;

public class PythonDesignPatternProvider implements DesignPatternProvider {

    private final String name;
    private final RunnableCode patternCode;

    public PythonDesignPatternProvider(String name, String patternCode) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(patternCode);

        this.name = name;

        PythonEnvironment.setUp();
        this.patternCode = PythonEnvironment.compile(patternCode);
    }

    @Override
    public RunnableCode refactor(String badCode) {
        return PythonEnvironment.run(patternCode.run(badCode));
    }

    @Override
    public String showExample() {
        return PythonCodeExamplesLibrary.getPatternExample(name);
    }
}
