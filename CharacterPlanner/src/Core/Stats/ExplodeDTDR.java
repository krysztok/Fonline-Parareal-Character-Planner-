package Core.Stats;

import Core.Character;

public class ExplodeDTDR extends Stat {
    private int dermals;
    private int bloodymess;
    private int mutie;
    private int mutant;
    private int nightkin;

    public ExplodeDTDR(String name) {
        super(name);
        dermals = 0;
        bloodymess = 0;
        mutie = 0;
        mutant = 0;
        nightkin = 0;
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
        mutie = character.getDrugs().getDrugByName("Mutie").isTaken()? 1 : 0;

        mutant = character.getMasteries().getMasteryByName("Mutant").isTaken()? 1 : 0;
        nightkin = character.getMasteries().getMasteryByName("Nightkin").isTaken()? 1 : 0;


        int valueDR = 4 * dermals - 5 * bloodymess;
        int valueDT = dermalDt;

        if(mutant == 1 || nightkin == 1){
            valueDT += 4 * mutie;
        }

        setValue(valueDT);
        setSecondValueValue(valueDR);
    }

    @Override
    public String toString() {
        return getValue() + "/" + getSecondValue();
    }
}
