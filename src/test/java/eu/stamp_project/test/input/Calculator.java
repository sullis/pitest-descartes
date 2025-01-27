package eu.stamp_project.test.input;

import org.pitest.mutationtest.build.InterceptorParameters;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Meaningless target class for mutation
 */
public class Calculator {


    private double registry;
    private char lastOperatorSymbol;

    public Calculator() {clear();}

    //void method

    public void clear() {
        registry = 2;
        lastOperatorSymbol = '\0';
    }



    //Integral types

    public byte getByte() {
        return (byte)Math.min(Math.abs(registry), 127);
    }

    public short getShort() {
        return (short) Math.min(getCeiling(), 32000);
    }

    public int getCeiling() {
        return (int)Math.ceil(registry + 18000);
    }

    public Integer getWrapper() {
        return Integer.valueOf(2 + 3);
    }

    public long getSquare() {
        int value = getCeiling();
        return value * value;
    }

    public int conditionalReturn(boolean cond) {
        return cond?1:2;
    }


    public char getRandomOperatorSymbol() {
        //Non sense code to avoid creating a getter
        char[] symbols = {'+', '-', '*', '/'};
        return symbols[getCeiling()%symbols.length];
    }

    //Floating point types

    public double add(double input) {
        registry += input;
        lastOperatorSymbol = '+';
        return registry;
    }

    public float getSomething() {
        float value = getCeiling();
        float root = (float)Math.sqrt(2);
        return value * value * root;
    }

    //Boolean

    public boolean isOdd() {
        return getCeiling() % 2 == 0;
    }

    //String

    public String getScreen() {
        return Double.toString(registry);
    }

    // Other reference type

    public Calculator getClone() {
        Calculator result = new Calculator();
        result.registry = registry;
        return result;
    }

    public Calculator getConditionalClone(boolean cond) {
       if(cond){
           return this;
       }
       return null;
    }

    public Calculator[] getSomeCalculators(int number) {
        Calculator[] result = new Calculator[number];
        for(int i=0; i< number; i++) {
            result[i] = getClone();
        }
        return result;
    }

    public Calculator[][] getSomeMore(int number) {
        Calculator [][] result = new Calculator[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                result[i][j] = getClone();
            }
        }
        return result;
    }

    public List<Calculator> getMultipleCalculators(int size) {
        return Arrays.asList(getSomeCalculators(size));
    }

    public int[] getRange(int top) {
        int[] result = new int[top];
        for(int i=0; i< top; i++) {
            result[i] = i;
        }
        return result;
    }

    public Optional<Calculator> getOptionalCalculator() {
        return Optional.of(this);
    }

    public void setDoubleRegistry(double value) {
        this.registry = 2*value;
    }

    public int hashCode(int seed) {
        return seed * seed + 2;
    }

    public String toString(String base) { return base + toString(); }

}