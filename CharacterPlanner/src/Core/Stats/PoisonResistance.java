package Core.Stats;

import Core.Character;

public class PoisonResistance extends Stat {
    private int radResistance;
    private int snakeater;
    private int bruiser;
    private int liverBox;

    public PoisonResistance(String name) {
        super(name);
        radResistance = 0;
        snakeater = 0;
        bruiser = 0;
        liverBox = 0;
    }

    @Override
    void calculateValue(Character character) {
        int enImpsAndPerks = character.getSpecials().getSpecialByName("Endurance").getValueWithPerksAndImplants();
        bruiser = character.getTraits().getTraitByName("Bruiser").isTaken()? 1 : 0;
        radResistance = character.getSupportPerks().getPerkByName("Rad Resistance").isTaken()? 1 : 0;
        snakeater = character.getSupportPerks().getPerkByName("Snakeater").isTaken()? 1 : 0;
        liverBox = character.getImplants().getImplantByName("Liver Box").isTaken()? 1 : 0;

        //int finalValue = 5 * enImpsAndPerks + 30 * snakeater + 10 * radResistance - 10 * bruiser + 15 * liverBox;
        //int finalValue = 10 + 4 * enImpsAndPerks + 30 * snakeater + 10 * radResistance - 10 * bruiser + 15 * liverBox;
        int finalValue = 3 * enImpsAndPerks + 30 * snakeater + 10 * radResistance - 10 * bruiser + 15 * liverBox;

        /*cap*/
        if (finalValue > 95 ){
            finalValue = 95;
        }

        if (finalValue < 0){
            finalValue = 0;
        }
        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
