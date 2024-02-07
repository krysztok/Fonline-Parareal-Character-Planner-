package Core.Stats;

import Core.Character;

public class CriticalChance extends Stat {
    private int finesse;
    private int moreCritical;
    private int evenMoreCriticals;
    //private int bloodyMess;
    private int eye;
    private int wonderlandCC;
    private int rambo;
    private int dragoon;

    public CriticalChance(String name) {
        super(name);
        finesse = 0;
        moreCritical = 0;
        evenMoreCriticals = 0;
        //bloodyMess = 0;
        eye = 0;
        wonderlandCC = 0;
        rambo = 0;
        dragoon = 0;
    }

    @Override
    void calculateValue(Character character) {
        int lkDrugs = character.getSpecials().getSpecialByName("Luck").getFinalValue();
        finesse = character.getTraits().getTraitByName("Finesse").isTaken()? 1 : 0;
        moreCritical = character.getPerks().getPerkByName("More Critical").isTaken()? 1 : 0;
        evenMoreCriticals = character.getPerks().getPerkByName("Even More Criticals").isTaken()? 1 : 0;
       // bloodyMess = character.getTraits().getTraitByName("Bloody Mess").isTaken()? 1 : 0;
        eye = character.getImplants().getImplantByName("Eye").isTaken()? 1 : 0;
        wonderlandCC = character.getSupportPerks().getPerkByName("The art of the hunt").isTaken()? 1 : 0;
        rambo = character.getMasteries().getMasteryByName("Rambo").isTaken()? 1 : 0;
        dragoon = character.getMasteries().getMasteryByName("Dragoon").isTaken()? 1 : 0;

        int finalValue = lkDrugs + 10 * finesse + 5 * moreCritical + 10 * evenMoreCriticals /*+ 5 * bloodyMess*/ + 10 * eye + 3 * wonderlandCC + 5 * rambo + 5 * dragoon;
        setValue(finalValue);
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
