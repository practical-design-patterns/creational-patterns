package edu.agh.wfiis.solid.designpatterns.creational.edu.agh.wfiis.solid.designpatterns.creational.abstractFactory;

import java.util.Objects;

public class JavaDesignPatternProvider implements DesignPatternProvider {

    private final String name;
    private final RunnableCode patternCode;

    public JavaDesignPatternProvider(String name, String patternCode) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(patternCode);

        this.name = name;

        JavaEnvironment.setUp();
        this.patternCode = JavaEnvironment.compile(patternCode);
    }

    @Override
    public RunnableCode refactor(String badCode) {
        return JavaEnvironment.run(patternCode.run(badCode));
    }

    @Override
    public String showExample() {
        return JavaCodeExamplesLibrary.getPatternExample(name);
    }
}
