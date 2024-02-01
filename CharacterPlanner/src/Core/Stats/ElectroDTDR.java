package Core.Stats;

import Core.Character;

public class ElectroDTDR extends Stat {
    private int cerebralModem;
    private int bloodymess;

    public ElectroDTDR(String name) {
        super(name);
        cerebralModem = 0;
        bloodymess = 0;
    }

    @Override
    void calculateValue(Character character) {
        cerebralModem = character.getImplants().getImplantByName("Cerebral Modem").isTaken()? 1 : 0;
        bloodymess = character.getTraits().getTraitByName("Bloody Mess").isTaken()? 1 : 0;

        int valueDR = 10 * cerebralModem - 5 * bloodymess;
        int valueDT = 0;
        setValue(valueDT);
        setSecondValueValue(valueDR);
    }

    @Override
    public String toString() {
        return getValue() + "/" + getSecondValue();
    }
}
