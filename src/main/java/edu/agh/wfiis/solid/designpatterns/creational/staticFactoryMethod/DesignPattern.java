package edu.agh.wfiis.solid.designpatterns.creational.staticFactoryMethod;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class DesignPattern {

    private final String name;

    private final String patternCode;

    private DesignPattern(String name, String patternCode, String patternCodeFilePath, String className)
            throws IOException, ClassNotFoundException {
        this.name = name;

        if(patternCode != null) {
            this.patternCode = patternCode;
        } else if(patternCodeFilePath != null) {
            this.patternCode = Files.lines(FileSystems.getDefault().getPath(patternCodeFilePath)).collect(Collectors.joining("\n"));;
        } else if(className!=null){
            this.patternCode = ClassLoader.getSystemClassLoader().loadClass(className).toGenericString();
        } else {
            throw new IllegalArgumentException("lack of required pattern code");
        }
    }

    public static DesignPattern withPatternCode(String name, String patternCode)
            throws IOException, ClassNotFoundException {
        return new DesignPattern(name, patternCode, null, null);
    }

    public static DesignPattern withPatternCodeFilePath(String name, String patternCodeFilePath)
            throws IOException, ClassNotFoundException {
        return new DesignPattern(name, null, patternCodeFilePath, null);
    }

    public static DesignPattern withClassName(String name, String className)
            throws IOException, ClassNotFoundException {
        return new DesignPattern(name, null, null, className);
    }

    public static void main(String args[]){
        try {
            DesignPattern designPattern = DesignPattern.withPatternCode("builder"," public Builder {....");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}