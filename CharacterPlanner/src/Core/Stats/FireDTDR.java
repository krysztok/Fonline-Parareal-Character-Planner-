package Core.Stats;

import Core.Character;

public class FireDTDR extends Stat {
    private int phoenix;
    private int bloodymess;
    private int rotgut;
    private int tank;

    public FireDTDR(String name) {
        super(name);
        phoenix = 0;
        bloodymess = 0;
        rotgut = 0;
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
        rotgut = character.getDrugs().getDrugByName("Rot Gut").isTaken()? 1 : 0;
        tank = character.getMasteries().getMasteryByName("Tank").isTaken()? 1 : 0;

        int phoenixDt = phoenix == 2 ? 1 : 0;

        int valueDR = 4 * phoenix - 5 * bloodymess + 10 * rotgut + 5 * tank;
        int valueDT = phoenixDt + 2 * tank;

        setValue(valueDT);
        setSecondValueValue(valueDR);
    }

    @Override
    public String toString() {
        return getValue() + "/" + getSecondValue();
    }
}
