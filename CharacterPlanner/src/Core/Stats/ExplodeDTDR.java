package Core.Stats;

import Core.Character;

public class ExplodeDTDR extends Stat {
    private int dermals;
    private int bloodymess;
    private int tank;


    public ExplodeDTDR(String name) {
        super(name);
        dermals = 0;
        bloodymess = 0;
        tank = 0;
    }

    @Override
    void calculateValue(Character character) {
        dermals = 0;
        if(character.getImplants().getImplantByName("Dermal Impact Armor").isTaken()){
            dermals = 1;
            if(character.getImplants().getImplantByName("Dermal Impact Assault").isTaken()){
                dermals = 2;
            }
        }

        int dermalDt = dermals == 2 ? 1 : 0;

        bloodymess = character.getTraits().getTraitByName("Bloody Mess").isTaken()? 1 : 0;
        tank = character.getMasteries().getMasteryByName("Tank").isTaken()? 1 : 0;

        int valueDR = 4 * dermals - 5 * bloodymess + 5 * tank;
        int valueDT = dermalDt + 2 * tank;

        setValue(valueDT);
        setSecondValueValue(valueDR);
    }

    @Override
    public String toString() {
        return getValue() + "/" + getSecondValue();
    }
}
