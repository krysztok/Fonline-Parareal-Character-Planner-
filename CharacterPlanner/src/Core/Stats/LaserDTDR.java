package Core.Stats;

import Core.Character;

public class LaserDTDR extends Stat {
    private int phoenix;
    private int bloodymess;
    private int wayOfTheFruit;
    private int tank;

    public LaserDTDR(String name) {
        super(name);
        phoenix = 0;
        bloodymess = 0;
        wayOfTheFruit = 0;
        tank = 0;
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
        wayOfTheFruit = character.getDrugs().getDrugByName("Fruit").isTaken()? 1 : 0;
        tank = character.getMasteries().getMasteryByName("Tank").isTaken()? 1 : 0;

        int phoenixDt = phoenix == 2 ? 1 : 0;

        int valueDR = 4 * phoenix - 5 * bloodymess + 10 * wayOfTheFruit + 5 * tank;
        int valueDT = phoenixDt + 2 * tank;
        setValue(valueDT);
        setSecondValueValue(valueDR);
    }

    @Override
    public String toString() {
        return getValue() + "/" + getSecondValue();
    }
}
