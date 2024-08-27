package Core.Stats;

import Core.Character;

public class ElectroDTDR extends Stat {
    private int cerebralModem;
    private int bloodymess;
    private int tank;

    public ElectroDTDR(String name) {
        super(name);
        cerebralModem = 0;
        bloodymess = 0;
        tank = 0;
    }

    @Override
    void calculateValue(Character character) {
        cerebralModem = character.getImplants().getImplantByName("Cerebral Modem").isTaken()? 1 : 0;
        bloodymess = character.getTraits().getTraitByName("Bloody Mess").isTaken()? 1 : 0;
        tank = character.getMasteries().getMasteryByName("Tank").isTaken()? 1 : 0;

        int valueDR = 10 * cerebralModem - 5 * bloodymess + 5 * tank;
        int valueDT = 2 * tank;
        setValue(valueDT);
        setSecondValueValue(valueDR);
    }

    @Override
    public String toString() {
        return getValue() + "/" + getSecondValue();
    }
}
