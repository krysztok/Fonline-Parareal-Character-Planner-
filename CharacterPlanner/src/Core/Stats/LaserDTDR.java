package Core.Stats;

import Core.Character;

public class LaserDTDR extends Stat {
    private int phoenix;
    private int bloodymess;
    private int wayOfTheFruit;

    public LaserDTDR(String name) {
        super(name);
        phoenix = 0;
        bloodymess = 0;
        wayOfTheFruit = 0;
    }

    @Override
    void calculateValue(Character character) {
        phoenix = 0;
        if(character.getImplants().getImplantByName("Phoenix Armor").isTaken()){
            phoenix = 1;
            if(character.getImplants().getImplantByName("Phoenix Assault").isTaken()){
                phoenix = 2;
            }
        }

        bloodymess = character.getTraits().getTraitByName("Bloody Mess").isTaken()? 1 : 0;

        if(character.getPerks().getPerkByName("Way of the Fruit").isTaken()){
            wayOfTheFruit = character.getDrugs().getDrugByName("Fruit").isTaken()? 1 : 0;
        }

        int phoenixDt = phoenix == 2 ? 1 : 0;

        int valueDR = 4 * phoenix - 5 * bloodymess + 10 * wayOfTheFruit;
        int valueDT = phoenixDt;
        setValue(valueDT);
        setSecondValueValue(valueDR);
    }

    @Override
    public String toString() {
        return getValue() + "/" + getSecondValue();
    }
}
