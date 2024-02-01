package Core.Stats;

import Core.Character;

public class ArmorClass extends Stat {
    private int lifewire;
    private int dodger;
    private int dodger2;
    private int hthEvade;
    private int hthEvade2;

    public ArmorClass(String name) {
        super(name);
        lifewire = 0;
        dodger = 0;
        dodger2 = 0;
        hthEvade = 0;
        hthEvade2 = 0;
    }

    @Override
    void calculateValue(Character character) {
        int agDrugs = character.getSpecials().getSpecialByName("Agility").getFinalValue();
        int base = 3 * agDrugs;

        lifewire = character.getPerks().getPerkByName("Livewire").isTaken()? 1 : 0;
        dodger = character.getPerks().getPerkByName("Dodger").isTaken()? 1 : 0;
        dodger2 = character.getPerks().getPerkByName("Dodger+").isTaken()? 1 : 0;
        hthEvade = character.getPerks().getPerkByName("HtH Evade").isTaken()? 1 : 0;
        hthEvade2 = character.getPerks().getPerkByName("HtH Evade+").isTaken()? 1 : 0;


        if(lifewire > 0){
            base*=2;
        }

        int finalValue = base + 20 * dodger + 40 * dodger2 + 20 * hthEvade + 40 * hthEvade2;

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
