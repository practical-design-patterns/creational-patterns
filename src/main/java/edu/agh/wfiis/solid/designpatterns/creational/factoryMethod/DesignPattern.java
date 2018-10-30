package edu.agh.wfiis.solid.designpatterns.creational.factoryMethod;

import java.util.Objects;

public class DesignPattern {

    private final String name;

    private final RunnableCode patternCode;

    public RunnableCode refactor(String badCode) {
        return patternCode.run(badCode);
    }

    public DesignPattern(String name, String patternCode, String language) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(patternCode);
        Objects.requireNonNull(language);

        this.name = name;

        if (language.equalsIgnoreCase("java")) {
            JavaEnvironment.setUp();
            this.patternCode = JavaEnvironment.compile(patternCode);
        } else if (language.equalsIgnoreCase("python")) {
            PythonEnvironment.setUp();
            this.patternCode = PythonEnvironment.compile(patternCode);
        } else if (language.equalsIgnoreCase("c#")) {
            throw new UnsupportedOperationException("really?");
        } else {
            throw new IllegalArgumentException("Unknown language");
        }
    }


    public static void main(String args[]) {
        DesignPattern designPattern = new DesignPattern("builder", " public Builder {....", "java");
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
}

class JavaEnvironment {
    static void setUp() {
        //magic happens here
    }

    static RunnableCode compile(String code) {
        //magic happens here
        return new JavaCode();
    }
}