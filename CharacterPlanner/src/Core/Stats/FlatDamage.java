package Core.Stats;

import Core.Character;

public class FlatDamage extends Stat{
    private int fastShot;
    private int weaponHandling;

    public FlatDamage(String name) {
        super(name);
        fastShot = 0;
        weaponHandling = 0;
    }

    @Override
    void calculateValue(Character character) {
        fastShot = character.getTraits().getTraitByName("Fast Shot").isTaken()? 1 : 0;
        weaponHandling = character.getPerks().getPerkByName("Weapon Handling").isTaken()? 1 : 0;

        int finalValue = 5 * fastShot;
        int finalSecondValue = finalValue;

        if(weaponHandling == 1){
            finalSecondValue += 10;
        }

        setValue(finalValue);
        setSecondValueValue(finalSecondValue);
    }

    @Override
    public String toString() {
        String valueStr = Integer.toString(getValue());
        if(weaponHandling > 0){
            valueStr += "(";
            valueStr += (Integer.toString(getSecondValue()));
            valueStr += ")";
        }
        return valueStr;
    }
}
