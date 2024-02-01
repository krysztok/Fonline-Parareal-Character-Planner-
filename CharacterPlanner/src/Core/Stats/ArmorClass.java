package Core.Stats;

import Core.Character;

public class ArmorClass extends Stat {
    private int lifewire;

    public ArmorClass(String name) {
        super(name);
        lifewire = 0;
    }

    @Override
    void calculateValue(Character character) {
        int agDrugs = character.getSpecials().getSpecialByName("Agility").getFinalValue();
        int base = 3 * agDrugs;


        if(lifewire > 0){
            base*=2;
        }

        int finalValue = base;

        /*ac cap*/
        if (finalValue > 140 ){
            finalValue = 140;
        }

        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
