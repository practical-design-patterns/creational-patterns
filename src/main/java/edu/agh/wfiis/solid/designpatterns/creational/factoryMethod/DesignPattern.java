package edu.agh.wfiis.solid.designpatterns.creational.factoryMethod;

abstract public class DesignPattern {

    protected final String name;

    protected DesignPattern(String name) {
        this.name = name;
    }

    public RunnableCode refactor(String badCode) {
        return getPatternCode().run(badCode);
    }

    abstract RunnableCode getPatternCode();

    public static void main(String args[]) {
        DesignPattern designPattern = new JavaBuilder();
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