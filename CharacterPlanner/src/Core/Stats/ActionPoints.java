package Core.Stats;

import Core.Character;

public class ActionPoints extends Stat {
    private int bruiser;
    private int kamikaze;
    private int actionBoys;
    private int jet;
    private int nuka;
    private int cookie;

    public ActionPoints(String name) {
        super(name);
        bruiser = 0;
        kamikaze = 0;
        actionBoys = 0;
        jet = 0;
        nuka = 0;
        cookie = 0;
    }

    @Override
    void calculateValue(Character character) {
        int agDrugs = character.getSpecials().getSpecialByName("Agility").getFinalValue();
        bruiser = character.getTraits().getTraitByName("Bruiser").isTaken()? 1 : 0;
        kamikaze = character.getTraits().getTraitByName("Kamikaze").isTaken()? 1 : 0;

        actionBoys = 0;
        if (character.getPerks().getPerkByName("Action Boy(1)").isTaken()){
            actionBoys = 1;
            if (character.getPerks().getPerkByName("Action Boy(2)").isTaken()){
                actionBoys = 2;
            }
        }

        jet =  character.getDrugs().getDrugByName("Jet").isTaken()? 1 : 0;
        nuka =  character.getDrugs().getDrugByName("Nuka-Cola").isTaken()? 1 : 0;
        cookie =  character.getDrugs().getDrugByName("Cookie").isTaken()? 1 : 0;

        int finalValue = 5 + (int)(agDrugs/2) + actionBoys + 2 * jet - bruiser + kamikaze + nuka + cookie;
        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
