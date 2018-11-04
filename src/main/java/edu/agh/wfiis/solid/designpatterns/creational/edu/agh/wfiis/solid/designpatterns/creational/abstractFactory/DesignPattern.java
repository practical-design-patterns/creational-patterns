package edu.agh.wfiis.solid.designpatterns.creational.edu.agh.wfiis.solid.designpatterns.creational.abstractFactory;

import java.util.Objects;

public class DesignPattern {

    private final DesignPatternProvider designPatternProvider;

    public RunnableCode refactor(String badCode) {
        return designPatternProvider.refactor(badCode);
    }

    public String showExample() {
        return designPatternProvider.showExample();
    }

    public DesignPattern(DesignPatternProvider designPatternProvider) {
        Objects.requireNonNull(designPatternProvider);

        this.designPatternProvider = designPatternProvider;
    }


    public static void main(String args[]) {
        JavaDesignPatternProvider builder = new JavaBuilderProvider();
        DesignPattern designPattern = new DesignPattern(builder);
        designPattern.refactor("public class ClassWithManyConstructors...");
    }
}


//required dependencies, put here only to compile project
interface RunnableCode {
    RunnableCode run(String code);
}

class PythonCode implements RunnableCode {
    @Override
    public RunnableCode run(String code) {
        //magic happens here
        return null;
    }
}

class JavaCode implements RunnableCode {
    @Override
    public RunnableCode run(String code) {
        //magic happens here
        return null;
    }
}

class PythonEnvironment {
    static void setUp() {
        //magic happens here
    }

    static RunnableCode compile(String code) {
        //magic happens here
        return new PythonCode();
    }

    static RunnableCode run(RunnableCode code) {
        //magic happens here
        return new PythonCode();
    }
}

class JavaEnvironment {
    static void setUp() {
        //magic happens here
    }

    static RunnableCode compile(String code) {
        //magic happens here
        return new JavaCode();
    }

    static RunnableCode run(RunnableCode code) {
        //magic happens here
        return new JavaCode();
    }
}

class JavaCodeExamplesLibrary {

    static String getPatternExample(String patternName) {
        //magic happens here
        return null;
    }
}

class PythonCodeExamplesLibrary {

    static String getPatternExample(String patternName) {
        //magic happens here
        return null;
    }
}