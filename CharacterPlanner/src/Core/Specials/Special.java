package Core.Specials;

import Core.Character;

public abstract class Special {
    private String name;
    private int base;
    private int minimum;
    private int maximum;
    private int withPerksAndImplants;
    private int finalValue;

    public Special(String name, int base){
        this.name = name;
        this.base = base;
        minimum = 1;
        maximum = 10;
        withPerksAndImplants = base;
        finalValue = base;
    }

    abstract void calculateFinalValue(Character character);
    abstract void calculateWithPerksAndImplantsValue(Character character);

    public String getName() {
        return name;
    }
    public int getBase() {
        return base;
    }
    public int getMinimum() {
        return minimum;
    }
    public int getMaximum() {
        return maximum;
    }
    public int getValueWithPerksAndImplants() {
        return withPerksAndImplants;
    }
    public int getFinalValue() {
        return finalValue;
    }
    public void changeBaseByPoints(int points) {
        base = base + points;
    }
    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }
    public void setWithPerksAndImplants(int withPerksAndImplants) {
        this.withPerksAndImplants = withPerksAndImplants;
    }
    public void setFinalValue(int finalValue) {
        this.finalValue = finalValue;
    }

    public int changeSpecialWithTrait(int value, boolean changeMinimum){
        if(changeMinimum) {
            setMinimum(minimum + value);
        }

        base += value;
        int pointsChange = 0;

        if(base > maximum){
            pointsChange = base - maximum;
            base = maximum;
        } else if (base < minimum){
            pointsChange = base - minimum;
            base = minimum;
        }

        return pointsChange;
    }
}
