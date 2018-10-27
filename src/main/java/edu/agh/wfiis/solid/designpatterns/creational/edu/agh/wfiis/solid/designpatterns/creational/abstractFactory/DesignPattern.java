package edu.agh.wfiis.solid.designpatterns.creational.edu.agh.wfiis.solid.designpatterns.creational.abstractFactory;

import java.util.Objects;

public class DesignPattern {

    private final String name;

    private final RunnableCode patternCode;

    public RunnableCode refactor(String badCode) {
        if (patternCode instanceof JavaCode) {
            return JavaEnvironment.run(patternCode.run(badCode));
        } else if (patternCode instanceof PythonCode) {
            return PythonEnvironment.run(patternCode.run(badCode));
        }
        return null;
    }

    public String showExample(){
        if (patternCode instanceof JavaCode) {
            return JavaCodeExamplesLibrary.getPatternExample(name);
        } else if (patternCode instanceof PythonCode) {
            return PythonCodeExamplesLibrary.getPatternExample(name);
        }
        return null;
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
            throw new UnsupportedOperationException("No fkng way!");
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

    static String getPatternExample(String patternName){
        //magic happens here
        return null;
    }
}
class PythonCodeExamplesLibrary {

    static String getPatternExample(String patternName){
        //magic happens here
        return null;
    }
}