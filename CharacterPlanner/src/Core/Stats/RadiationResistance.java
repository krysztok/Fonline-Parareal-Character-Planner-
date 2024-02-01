package Core.Stats;

import Core.Character;

public class RadiationResistance extends Stat {
    private int radResistance;
    private int snakeater;
    private int bruiser;
    private int liverBox;
    private int radX;

    public RadiationResistance(String name) {
        super(name);
        radResistance = 0;
        snakeater = 0;
        bruiser = 0;
        liverBox = 0;
        radX = 0;
    }

    @Override
    void calculateValue(Character character) {
        int enImpsAndPerks = character.getSpecials().getSpecialByName("Endurance").getValueWithPerksAndImplants();
        bruiser = character.getTraits().getTraitByName("Bruiser").isTaken()? 1 : 0;
        radResistance = character.getSupportPerks().getPerkByName("Rad Resistance").isTaken()? 1 : 0;
        snakeater = character.getSupportPerks().getPerkByName("Snakeater").isTaken()? 1 : 0;
        liverBox = character.getImplants().getImplantByName("Liver Box").isTaken()? 1 : 0;
        radX = character.getDrugs().getDrugByName("Rad-X").isTaken()? 1 : 0;

        int finalValue = 2 * enImpsAndPerks + 20 * snakeater + 10 * radResistance - 10 * bruiser + 15 * liverBox + 20 * radX;

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
