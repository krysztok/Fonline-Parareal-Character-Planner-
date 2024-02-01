package Core.Perks;

import Core.Requirements.*;

import java.util.*;

public class Perks {
    private int levelsNewPerk;
    private boolean hasAvailablePerk;
    private int perksLimit;
    private int perksTaken;

    private Map<String, Perk> perksMap;

    public Perks(){
        levelsNewPerk = 3;
        hasAvailablePerk = false;
        perksLimit = 8;
        perksTaken = 0;

        perksMap = new LinkedHashMap<>();

        /* REQUIREMENTS */
        /* Level Requirements */
        LevelRequirement level3Req = new LevelRequirement(3, true);
        LevelRequirement level6Req = new LevelRequirement(6, true);
        LevelRequirement level9Req = new LevelRequirement(9, true);
        LevelRequirement level12Req = new LevelRequirement(12, true);
        LevelRequirement level15Req = new LevelRequirement(15, true);
        LevelRequirement level18Req = new LevelRequirement(18, true);

        /* SPECIAL Requirements*/
        SpecialRequirement st5Req = new SpecialRequirement( "Strength", 5, true);
        SpecialRequirement st6Req = new SpecialRequirement( "Strength", 6, true);
        SpecialRequirement st9orLessReq = new SpecialRequirement( "Strength", 9, false);
        SpecialRequirement pe5Req = new SpecialRequirement( "Perception", 5, true);
        SpecialRequirement pe9orLessReq = new SpecialRequirement( "Perception", 9, false);
        SpecialRequirement en4Req = new SpecialRequirement( "Endurance", 4, true);
        SpecialRequirement en5Req = new SpecialRequirement( "Endurance", 5, true);
        SpecialRequirement en6Req = new SpecialRequirement( "Endurance", 6, true);
        SpecialRequirement en7Req = new SpecialRequirement( "Endurance", 7, true);
        SpecialRequirement en8Req = new SpecialRequirement( "Endurance", 8, true);
        SpecialRequirement en9orLessReq = new SpecialRequirement( "Endurance", 9, false);
        SpecialRequirement ch6Req = new SpecialRequirement( "Charisma", 6, true);
        SpecialRequirement ch9orLessReq = new SpecialRequirement( "Charisma", 9, false);
        SpecialRequirement in9orLessReq = new SpecialRequirement( "Intelligence", 9, false);
        SpecialRequirement ag5Req = new SpecialRequirement( "Agility", 5, true);
        SpecialRequirement ag6Req = new SpecialRequirement( "Agility", 6, true);
        SpecialRequirement ag8Req = new SpecialRequirement( "Agility", 8, true);
        SpecialRequirement ag10Req = new SpecialRequirement( "Agility", 10, true);
        SpecialRequirement ag9orLessReq = new SpecialRequirement( "Agility", 9, false);
        SpecialRequirement lk9orLessReq = new SpecialRequirement( "Luck", 9, false);

        /* Skills Requirements*/
        String sg = "Small Guns";
        String bg = "Big Guns";
        String ew = "Energy Weapons";
        String cc = "Close Combat";
        String th = "Throwing";
        String fa = "First Aid";
        String sn = "Sneak";

        List<String> combatSkills = new ArrayList<>();
        combatSkills.add(sg);
        combatSkills.add(bg);
        combatSkills.add(ew);
        combatSkills.add(cc);
        combatSkills.add(th);

        List<String> gunsSkills = new ArrayList<>();
        gunsSkills.add(sg);
        gunsSkills.add(bg);
        gunsSkills.add(ew);

        List<String> normalGunsSkills = new ArrayList<>();
        normalGunsSkills.add(sg);
        normalGunsSkills.add(bg);

        List<String> distanceCombatSkills = new ArrayList<>();
        distanceCombatSkills.add(sg);
        distanceCombatSkills.add(bg);
        distanceCombatSkills.add(ew);
        distanceCombatSkills.add(th);

        List<String> critCombatSkills = new ArrayList<>();
        critCombatSkills.add(sg);
        critCombatSkills.add(bg);
        critCombatSkills.add(ew);
        critCombatSkills.add(cc);

        SkillRequirement cc150Req = new SkillRequirement(cc, 150, true);
        SkillRequirement fa150Req = new SkillRequirement(fa, 150, true);
        SkillRequirement fa175Req = new SkillRequirement(fa, 175, true);
        SkillRequirement sn100Req = new SkillRequirement(sn, 100, true);
        SkillRequirement sn150Req = new SkillRequirement(sn, 150, true);
        SkillRequirement sn175Req = new SkillRequirement(sn, 175, true);
        SkillRequirement th100Req = new SkillRequirement(th, 100, true);
        SkillRequirement th150Req = new SkillRequirement(th, 150, true);

        SkillRequirement gunsSkills100Req = new SkillRequirement(gunsSkills, 100, true);
        SkillRequirement gunsSkills150Req = new SkillRequirement(gunsSkills, 150, true);
        SkillRequirement gunsSkills175Req = new SkillRequirement(gunsSkills, 175, true);
        SkillRequirement normalGunsSkills100Req = new SkillRequirement(normalGunsSkills, 100, true);
        SkillRequirement distanceCombatSkills125Req = new SkillRequirement(distanceCombatSkills, 125, true);
        SkillRequirement distanceCombatSkills150Req = new SkillRequirement(distanceCombatSkills, 150, true);
        SkillRequirement distanceCombatSkills200Req = new SkillRequirement(distanceCombatSkills, 200, true);
        SkillRequirement combatSkills100Req = new SkillRequirement(combatSkills, 100, true);
        SkillRequirement combatSkills125Req = new SkillRequirement(combatSkills, 125, true);
        SkillRequirement combatSkills175Req = new SkillRequirement(combatSkills, 175, true);
        SkillRequirement combatSkills180Req = new SkillRequirement(combatSkills, 180, true);
        SkillRequirement critCombatSkills150Req = new SkillRequirement(critCombatSkills, 150, true);
        SkillRequirement critCombatSkills200Req = new SkillRequirement(critCombatSkills, 200, true);

        /* Perks Requirements*/
        PerkRequirement actionBoyReq = new PerkRequirement("Action Boy(1)", true);
        PerkRequirement brdReq = new PerkRequirement("Bonus Ranged Damage(1)", true);
        PerkRequirement dodgerReq = new PerkRequirement("Dodger(1)", true);
        PerkRequirement lg1Req = new PerkRequirement("Lifegiver(1)", true);
        PerkRequirement lg2Req = new PerkRequirement("Lifegiver(2)", true);
        PerkRequirement pyroReq = new PerkRequirement("Pyromaniac(1)", true);

        /* Requirements Lists*/
        List<Requirement> actionBoy2Reqs = new ArrayList<>();
        actionBoy2Reqs.add(level15Req);
        actionBoy2Reqs.add(ag6Req);
        actionBoy2Reqs.add(actionBoyReq);

        List<Requirement> bonusRangedDamage2Reqs = new ArrayList<>();
        bonusRangedDamage2Reqs.add(level12Req);
        bonusRangedDamage2Reqs.add(gunsSkills175Req);
        bonusRangedDamage2Reqs.add(brdReq);

        List<Requirement> dodger1Reqs = new ArrayList<>();
        dodger1Reqs.add(level15Req);
        dodger1Reqs.add(ag8Req);
        dodger1Reqs.add(cc150Req);

        List<Requirement> dodger2Reqs = new ArrayList<>();
        dodger2Reqs.add(level18Req);
        dodger2Reqs.add(ag10Req);
        dodger2Reqs.add(cc150Req);
        dodger2Reqs.add(dodgerReq);

        List<Requirement> lifegiver2Reqs = new ArrayList<>();
        lifegiver2Reqs.add(level15Req);
        lifegiver2Reqs.add(en6Req);
        lifegiver2Reqs.add(lg1Req);

        List<Requirement> lifegiver3Reqs = new ArrayList<>();
        lifegiver3Reqs.add(level18Req);
        lifegiver3Reqs.add(en7Req);
        lifegiver3Reqs.add(lg2Req);

        List<Requirement> pyromaniac2Reqs = new ArrayList<>();
        pyromaniac2Reqs.add(level15Req);
        pyromaniac2Reqs.add(gunsSkills150Req);
        pyromaniac2Reqs.add(pyroReq);

        /* PERKS */
        Perk actionBoy1 = new Perk("Action Boy(1)", level12Req, ag6Req);
        Perk actionBoy2 = new Perk("Action Boy(2)", actionBoy2Reqs);
        Perk adrenalineRush = new Perk("Adrenaline Rush", level3Req, st5Req);
        Perk betterCriticals = new Perk("Better Criticals", level12Req, combatSkills175Req);
        Perk bonusMove = new Perk("Bonus Move", level3Req, ag6Req);
        Perk bonusRangedDamage1 = new Perk("Bonus Ranged Damage(1)", level9Req, gunsSkills150Req);
        Perk bonusRangedDamage2 = new Perk("Bonus Ranged Damage(2)", bonusRangedDamage2Reqs);
        Perk bonusRateOfAttack = new Perk("Bonus Rate of Attack", level18Req, combatSkills180Req);
        Perk closeCombatMaster = new Perk("Close Combat Master", level9Req, cc150Req);
        Perk dodger1 = new Perk("Dodger(1)", dodger1Reqs);
        Perk dodger2 = new Perk("Dodger(2)", dodger2Reqs);
        Perk earlierSequence = new Perk("Earlier Sequence", level3Req, pe5Req);
        Perk evenMoreCriticals = new Perk("Even More Criticals", level6Req, distanceCombatSkills125Req);
        Perk gainAgility = new Perk("Gain Agility", level12Req, ag9orLessReq);
        Perk gainCharisma = new Perk("Gain Charisma", level12Req, ch9orLessReq);
        Perk gainEndurance = new Perk("Gain Endurance", level12Req, en9orLessReq);
        Perk gainIntelligence = new Perk("Gain Intelligence", level12Req, in9orLessReq);
        Perk gainLuck = new Perk("Gain Luck", level12Req, lk9orLessReq);
        Perk gainPerception = new Perk("Gain Perception", level12Req, pe9orLessReq);
        Perk gainStrength = new Perk("Gain Strength", level12Req, st9orLessReq);
        Perk ghost = new Perk("Ghost", level12Req, sn150Req);
        Perk heaveHo1 = new Perk("Heave Ho!", level6Req, th100Req);
        Perk heaveHo2 = new Perk("Heave Ho!!", level9Req, th150Req);
        Perk hitTheGaps = new Perk("Hit the Gaps", level12Req, critCombatSkills150Req);
        Perk inYourFace = new Perk("In Your Face!", level9Req, combatSkills125Req);
        Perk lifegiver1 = new Perk("Lifegiver(1)", level12Req, en5Req);
        Perk lifegiver2 = new Perk("Lifegiver(2)", lifegiver2Reqs);
        Perk lifegiver3 = new Perk("Lifegiver(3)", lifegiver3Reqs);
        Perk lifewire = new Perk("Livewire", level3Req, ag6Req);
        Perk livingAnatomy = new Perk("Living Anatomy", level12Req, fa150Req);
        Perk manOfSteel = new Perk("Man of Steel", level15Req, en8Req);
        Perk medic = new Perk("Medic", level15Req, fa175Req);
        Perk moreCritical = new Perk("More Critical", level3Req, combatSkills100Req);
        Perk moreRangedDamage = new Perk("More Ranged Damage", level15Req, distanceCombatSkills200Req);
        Perk pyromaniac1 = new Perk("Pyromaniac(1)", level9Req, gunsSkills100Req);
        Perk pyromaniac2 = new Perk("Pyromaniac(2)", pyromaniac2Reqs);
        Perk quickPockets = new Perk("Quick Pockets", level3Req, ag5Req);
        Perk quickRecovery = new Perk("Quick Recovery", level3Req, ag6Req);
        Perk rightBetweenTheEyes = new Perk ("Right Between the Eyes", level15Req, critCombatSkills200Req);
        Perk sharpshooter = new Perk("Sharpshooter", level9Req, distanceCombatSkills150Req);
        Perk silentDeath = new Perk("Silent Death", level15Req, sn175Req);
        Perk silentRunning = new Perk("Silent Running", level6Req, sn100Req);
        Perk sprayAndPray = new Perk("Spray and Pray", level9Req, distanceCombatSkills125Req);
        Perk stonewall = new Perk("Stonewall", level9Req, st6Req);
        Perk toughness = new Perk("Toughness", level6Req, en4Req);
        Perk evenTougher = new Perk("Even Tougher", level9Req, en6Req);
        Perk wayOfTheFruit = new Perk("Way of the Fruit", level6Req, ch6Req);
        Perk weaponHandling = new Perk("Weapon Handling", level3Req, normalGunsSkills100Req);

        perksMap.put(actionBoy1.getName(), actionBoy1);
        perksMap.put(actionBoy2.getName(), actionBoy2);
        perksMap.put(adrenalineRush.getName(), adrenalineRush);
        perksMap.put(betterCriticals.getName(), betterCriticals);
        perksMap.put(bonusMove.getName(), bonusMove);
        perksMap.put(bonusRangedDamage1.getName(), bonusRangedDamage1);
        perksMap.put(bonusRangedDamage2.getName(), bonusRangedDamage2);
        perksMap.put(bonusRateOfAttack.getName(), bonusRateOfAttack);
        perksMap.put(closeCombatMaster.getName(), closeCombatMaster);
        perksMap.put(dodger1.getName(), dodger1);
        perksMap.put(dodger2.getName(), dodger2);
        perksMap.put(earlierSequence.getName(), earlierSequence);
        perksMap.put(evenMoreCriticals.getName(), evenMoreCriticals);
        perksMap.put(gainAgility.getName(), gainAgility);
        perksMap.put(gainCharisma.getName(), gainCharisma);
        perksMap.put(gainEndurance.getName(), gainEndurance);
        perksMap.put(gainIntelligence.getName(), gainIntelligence);
        perksMap.put(gainLuck.getName(), gainLuck);
        perksMap.put(gainPerception.getName(), gainPerception);
        perksMap.put(gainStrength.getName(), gainStrength);
        perksMap.put(ghost.getName(), ghost);
        perksMap.put(heaveHo1.getName(), heaveHo1);
        perksMap.put(heaveHo2.getName(), heaveHo2);
        perksMap.put(hitTheGaps.getName(), hitTheGaps);
        perksMap.put(inYourFace.getName(), inYourFace);
        perksMap.put(lifegiver1.getName(), lifegiver1);
        perksMap.put(lifegiver2.getName(), lifegiver2);
        perksMap.put(lifegiver3.getName(), lifegiver3);
        perksMap.put(lifewire.getName(), lifewire);
        perksMap.put(livingAnatomy.getName(), livingAnatomy);
        perksMap.put(manOfSteel.getName(), manOfSteel);
        perksMap.put(medic.getName(), medic);
        perksMap.put(moreCritical.getName(), moreCritical);
        perksMap.put(moreRangedDamage.getName(), moreRangedDamage);
        perksMap.put(pyromaniac1.getName(), pyromaniac1);
        perksMap.put(pyromaniac2.getName(), pyromaniac2);
        perksMap.put(quickPockets.getName(), quickPockets);
        perksMap.put(quickRecovery.getName(), quickRecovery);
        perksMap.put(rightBetweenTheEyes.getName(), rightBetweenTheEyes);
        perksMap.put(sharpshooter.getName(), sharpshooter);
        perksMap.put(silentDeath.getName(), silentDeath);
        perksMap.put(silentRunning.getName(), silentRunning);
        perksMap.put(sprayAndPray.getName(), sprayAndPray);
        perksMap.put(stonewall.getName(), stonewall);
        perksMap.put(toughness.getName(), toughness);
        perksMap.put(evenTougher.getName(), evenTougher);
        perksMap.put(wayOfTheFruit.getName(), wayOfTheFruit);
        perksMap.put(weaponHandling.getName(), weaponHandling);
    }

    public Perk getPerkByName(String name) {
        return perksMap.get(name);
    }

    public List<String> getPerksNames() {
        List<String> perksNames = new ArrayList<String>();

        perksMap.forEach((name, perk) -> {
            perksNames.add(name);
        });

        return perksNames;
    }

    public List<Requirement> getRequirements(){
        List<Requirement> requirementList = new ArrayList<>();

        perksMap.forEach((name, perk) -> {
            requirementList.addAll(perk.getRequirements());
        });

        return  requirementList;
    }

    public List<String> getTakenPerksNames(){

        List<String> takenPerks = new ArrayList<>();
        perksMap.forEach((name, perk) -> {
            if(perk.isTaken()){
                takenPerks.add(perk.getName());
            }
        });

        return takenPerks;
    }

    public List<String> getAvailablePerksNames(){
        List<String> availablePerks = new ArrayList<>();

        if(!hasAvailablePerk){
            return availablePerks;
        }

        perksMap.forEach((name, perk) -> {
            if(!perk.isTaken() && perk.meetsRequirements()){
                availablePerks.add(perk.getName());
            }
        });

        return availablePerks;
    }

    public List<String> getUnAvailablePerksNames(){
        List<String> unAvailablePerks = new ArrayList<>();

        if(!hasAvailablePerk){
            perksMap.forEach((name, perk) -> {
                if(!perk.isTaken()){
                    unAvailablePerks.add(perk.getName());
                }
            });

            return  unAvailablePerks;
        }

        perksMap.forEach((name, perk) -> {
            if(!perk.isTaken() && !perk.meetsRequirements()){
                unAvailablePerks.add(perk.getName());
            }
        });

        return unAvailablePerks;
    }

    public void takePerk(String name) {
        if(hasAvailablePerk){
            Perk perk = getPerkByName(name);
            if(perk.takePerk()){
                hasAvailablePerk = false;
                perksTaken++;
            }
        }
    }

    public void checkIfHasAvailablePerk(int level){
        if(level < 30 && perksTaken < perksLimit) {
            if(level%levelsNewPerk == 0 && level <= 24){
                hasAvailablePerk = true;
            }

            return;
        }

        hasAvailablePerk = false;
    }

    public boolean hasAvailablePerk() {
        return hasAvailablePerk;
    }

    public boolean perkAlert(int level){
        if(!hasAvailablePerk){
            return false;
        }

        if(((level+1)%levelsNewPerk == 0 && level < 24)|| level == 29){
            return true;
        }

        return false;
    }
}
