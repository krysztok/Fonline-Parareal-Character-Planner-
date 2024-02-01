package Core.Stats;

import Core.Character;

public class NormalDTDR extends Stat {
    private int toughness;
    private int evenTougher;
    private int jet;
    private int psycho;
    private int dermals;
    private int bloodymess;
    private int mutant;
    private int nightkin;
    private int tank;
    private int sweetScience;

    public NormalDTDR(String name) {
        super(name);
        toughness = 0;
        evenTougher = 0;
        jet = 0;
        psycho = 0;
        dermals = 0;
        bloodymess = 0;
        mutant = 0;
        nightkin = 0;
        tank = 0;
        sweetScience = 0;
    }

    @Override
    void calculateValue(Character character) {
        toughness = character.getPerks().getPerkByName("Toughness").isTaken()? 1 : 0;
        evenTougher = character.getPerks().getPerkByName("Even Tougher").isTaken()? 1 : 0;
        jet = character.getDrugs().getDrugByName("Jet").isTaken()? 1 : 0;
        psycho = character.getDrugs().getDrugByName("Psycho").isTaken()? 1 : 0;

        dermals = 0;
        if(character.getImplants().getImplantByName("Dermal Impact Armor").isTaken()){
            dermals = 1;
            if(character.getImplants().getImplantByName("Dermal Impact Assault").isTaken()){
                dermals = 2;
            }
        }

        bloodymess = character.getTraits().getTraitByName("Bloody Mess").isTaken()? 1 : 0;
        mutant = character.getMasteries().getMasteryByName("Mutant").isTaken()? 1 : 0;
        nightkin = character.getMasteries().getMasteryByName("Nightkin").isTaken()? 1 : 0;
        tank = character.getMasteries().getMasteryByName("Tank").isTaken()? 1 : 0;
        sweetScience = character.getMasteries().getMasteryByName("Sweet Science").isTaken()? 1 : 0;

        int dermalDt = dermals == 2 ? 1 : 0;

        int valueDT = 2 * toughness + 3 * evenTougher + dermalDt + 3 * mutant + 3 * nightkin + 2 * tank;
        int valueDR = 5 * toughness + 10 * evenTougher - 15 * jet + 15 * psycho + 4 * dermals - 5 * bloodymess + 10 * mutant
                + 5 * nightkin + 5 * tank + 10 * sweetScience;
        setValue(valueDT);
        setSecondValueValue(valueDR);
    }

    @Override
    public String toString() {
        return getValue() + "/" + getSecondValue();
    }
}
