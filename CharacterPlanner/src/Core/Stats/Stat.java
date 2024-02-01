package Core.Stats;

import Core.Character;

public abstract class Stat {
    private String name;
    private int value;
    private int secondValue; // for DT / DR

    public Stat(String name){
        value = 0;
        secondValue = 0;
        this.name = name;
    }

    abstract void calculateValue(Character character);
    public abstract String toString();

    public void setValue(int value) {
        this.value = value;
    }
    public void setSecondValueValue(int value) {
        this.secondValue = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public int getSecondValue() {
        return secondValue;
    }
}
