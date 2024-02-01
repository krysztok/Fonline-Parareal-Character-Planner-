package Core.Perks;

import Core.Requirements.*;

import java.util.*;

public class SupportPerks {
    private Map<String, Perk> perksMap;


    public SupportPerks (){
        perksMap = new LinkedHashMap<>();

        /* REQUIREMENTS */
        /* Level Requirements */
        LevelRequirement level6Req = new LevelRequirement(6, true);
        LevelRequirement level18Req = new LevelRequirement(18, true);
        LevelRequirement level30Req = new LevelRequirement(30, true);

        /* SPECIAL Requirements*/
        SpecialRequirement pe6Req = new SpecialRequirement( "Perception", 6, true);
        SpecialRequirement en6Req = new SpecialRequirement( "Endurance", 6, true);
        SpecialRequirement ch6Req = new SpecialRequirement( "Charisma", 6, true);
        SpecialRequirement ch7Req = new SpecialRequirement( "Charisma", 7, true);
        SpecialRequirement in5Req = new SpecialRequirement( "Intelligence", 5, true);
        SpecialRequirement in6Req = new SpecialRequirement( "Intelligence", 6, true);
        SpecialRequirement in8Req = new SpecialRequirement( "Intelligence", 8, true);

        /* Skills Requirements*/
        String sg = "Small Guns";
        String bg = "Big Guns";
        String ew = "Energy Weapons";
        String cc = "Close Combat";
        String th = "Throwing";
        String br = "Barter";
        String st = "Steal";
        String sn = "Sneak";
        String doc = "Doctor";
        String fa = "First Aid";
        String sc = "Science";
        String lp = "Lockpick";
        String out = "Outdoorsman";
        String rp = "Repair";
        String sp = "Speech";
        String tr = "Traps";

        List<String> combatSkills = new ArrayList<>();
        combatSkills.add(sg);
        combatSkills.add(bg);
        combatSkills.add(ew);
        combatSkills.add(cc);
        combatSkills.add(th);

        SkillRequirement br125Req = new SkillRequirement(br, 125, true);
        SkillRequirement st100Req = new SkillRequirement(st, 100, true);
        SkillRequirement st125Req = new SkillRequirement(st, 125, true);
        SkillRequirement doc50Req = new SkillRequirement(doc, 50, true);
        SkillRequirement doc150Req = new SkillRequirement(doc, 150, true);
        SkillRequirement doc200Req = new SkillRequirement(doc, 200, true);
        SkillRequirement fa200Req = new SkillRequirement(fa, 200, true);
        SkillRequirement sc50Req = new SkillRequirement(sc, 50, true);
        SkillRequirement sc100Req = new SkillRequirement(sc, 100, true);
        SkillRequirement sc120Req = new SkillRequirement(sc, 120, true);
        SkillRequirement lp125Req = new SkillRequirement(lp, 125, true);
        SkillRequirement lp150Req = new SkillRequirement(lp, 150, true);
        SkillRequirement out50Req = new SkillRequirement(out, 50, true);
        SkillRequirement out100Req = new SkillRequirement(out, 100, true);
        SkillRequirement out150Req = new SkillRequirement(out, 150, true);
        SkillRequirement rp100Req = new SkillRequirement(rp, 100, true);
        SkillRequirement rp120Req = new SkillRequirement(rp, 120, true);
        SkillRequirement sn100Req = new SkillRequirement(sn, 100, true);
        SkillRequirement sp75Req = new SkillRequirement(sp, 75, true);
        SkillRequirement sp100Req = new SkillRequirement(sp, 100, true);
        SkillRequirement sp125Req = new SkillRequirement(sp, 125, true);
        SkillRequirement tr50Req = new SkillRequirement(tr, 50, true);
        SkillRequirement tr125Req = new SkillRequirement(tr, 125, true);

        SkillRequirement combatSkills65MaxReq = new SkillRequirement(combatSkills, 65, false);

        /* Perks Requirements*/

        String boneyardGuardSgName = "Boneyard Guard sg";
        String boneyardGuardBgName= "Boneyard Guard bg";
        String boneyardGuardEwName = "Boneyard Guard ew";
        String boneyardGuardMeleeName = "Boneyard Guard cc";
        String boneyardGuardThName = "Boneyard Guard th";

        List<String> boneyardGuardPerks = new ArrayList<>();
        boneyardGuardPerks.add(boneyardGuardSgName);
        boneyardGuardPerks.add(boneyardGuardBgName);
        boneyardGuardPerks.add(boneyardGuardEwName);
        boneyardGuardPerks.add(boneyardGuardMeleeName);
        boneyardGuardPerks.add(boneyardGuardThName);

        PerkRequirement boneyardGuardPerksReq = new PerkRequirement(boneyardGuardPerks, false);

        String wonderlandCcName = "Surviving in the wild";
        String wonderlandHpName = "The art of the hunt";
        String wonderlandHrName = "Basic Field Medicine";

        List<String> wonderlandPerks = new ArrayList<>();
        wonderlandPerks.add(wonderlandCcName);
        wonderlandPerks.add(wonderlandHpName);
        wonderlandPerks.add(wonderlandHrName);

        PerkRequirement wonderlandPerksReq = new PerkRequirement(wonderlandPerks, false);

        /* Requirements Lists*/
        List<Requirement> harmlessReqs = new ArrayList<>();
        harmlessReqs.add(ch6Req);
        harmlessReqs.add(st125Req);

        List<Requirement> straightShooterReqs = new ArrayList<>();
        straightShooterReqs.add(level18Req);
        straightShooterReqs.add(ch7Req);

        List<Requirement> strongBackReqs = new ArrayList<>();
        strongBackReqs.add(level6Req);
        strongBackReqs.add(en6Req);

        List<Requirement> fasterHealingReqs = new ArrayList<>();
        fasterHealingReqs.add(fa200Req);
        fasterHealingReqs.add(doc200Req);

        List<Requirement> deadManWalkingReqs = new ArrayList<>();
        deadManWalkingReqs.add(in5Req);
        deadManWalkingReqs.add(doc50Req);

        List<Requirement> swiftLearnerReqs = new ArrayList<>();
        swiftLearnerReqs.add(in6Req);
        swiftLearnerReqs.add(sc50Req);

        List<Requirement> nerdRageReqs = new ArrayList<>();
        nerdRageReqs.add(level30Req);
        nerdRageReqs.add(in8Req);

        List<Requirement> educatedReqs = new ArrayList<>();
        educatedReqs.add(in8Req);
        educatedReqs.add(sc100Req);

        List<Requirement> cautiousNatureReqs = new ArrayList<>();
        cautiousNatureReqs.add(pe6Req);
        cautiousNatureReqs.add(out100Req);

        List<Requirement> stealthGirlReqs = new ArrayList<>();
        stealthGirlReqs.add(sn100Req);
        stealthGirlReqs.add(rp100Req);

        List<Requirement> boneyardGuardReqs = new ArrayList<>();
        boneyardGuardReqs.add(combatSkills65MaxReq);
        boneyardGuardReqs.add(boneyardGuardPerksReq);



        /* PERKS */
        Perk boneyardGuardSg = new Perk(boneyardGuardSgName, boneyardGuardReqs);
        Perk boneyardGuardBg = new Perk(boneyardGuardBgName, boneyardGuardReqs);
        Perk boneyardGuardEw = new Perk(boneyardGuardEwName, boneyardGuardReqs);
        Perk boneyardGuardMelee = new Perk(boneyardGuardMeleeName, boneyardGuardReqs);
        Perk boneyardGuardTh = new Perk(boneyardGuardThName, boneyardGuardReqs);
        Perk cautiousNature = new Perk("Cautious Nature", cautiousNatureReqs);
        Perk deadManWalking = new Perk("Dead Man Walking", deadManWalkingReqs);
        Perk demolitionExpert = new Perk("Demolition Expert", tr125Req);
        Perk dismantler = new Perk("Dismantler", sc120Req);
        Perk educated = new Perk("Educated", educatedReqs);
        Perk explorer = new Perk("Explorer", out150Req);
        Perk fasterHealing = new Perk("Faster Healing", fasterHealingReqs);
        Perk fortuneFinder = new Perk("Fortune Finder", rp100Req);
        Perk harmless = new Perk("Harmless", harmlessReqs);
        Perk lightStep = new Perk("Light Step", tr50Req);
        Perk locksmith = new Perk("Locksmith", lp150Req);
        Perk lumberjack = new Perk("Lumberjack", out100Req);
        Perk magneticPersonality = new Perk("Magnetic Personality", sp100Req);
        Perk masterThief = new Perk("Master Thief", st125Req);
        Perk monsterSkinning = new Perk("Monster Skinning", out50Req);
        Perk mrFixit = new Perk("Mr. Fixit", rp120Req);
        Perk negotiator = new Perk("Negotiator", br125Req);
        Perk nerdRage = new Perk("Nerd Rage", nerdRageReqs);
        Perk packRat = new Perk("Pack Rat", level6Req);
        Perk pathfinder = new Perk("Pathfinder", out150Req);
        Perk pickPocket = new Perk("Pickpocket", st125Req);
        Perk radResistance = new Perk("Rad Resistance", doc150Req);
        Perk ranger = new Perk("Ranger", out100Req);
        Perk scout = new Perk("Scout", out150Req);
        Perk scrounger = new Perk("Scrounger");
        Perk sexAppeal = new Perk("Sex Appeal", sp75Req);
        Perk smittysMeal = new Perk("Smitty's Meal", ch6Req);
        Perk snakeater = new Perk("Snakeater", en6Req);
        Perk speaker = new Perk("Speaker", sp125Req);
        Perk stealthGirl = new Perk("Stealth Girl", stealthGirlReqs);
        Perk straightShooter = new Perk("Straight Shooter", straightShooterReqs);
        Perk strongBack = new Perk("Strong Back", strongBackReqs);
        Perk swiftLearner = new Perk("Swift Learner", swiftLearnerReqs);
        Perk theGoodDoctor = new Perk("The Good Doctor");
        Perk thief = new Perk("Thief", st100Req);
        Perk treasureHunter = new Perk("Treasure Hunter", lp125Req);
        Perk wonderlandCc = new Perk(wonderlandCcName, wonderlandPerksReq);
        Perk wonderlandHp = new Perk(wonderlandHpName, wonderlandPerksReq);
        Perk wonderlandHr = new Perk(wonderlandHrName, wonderlandPerksReq);

        perksMap.put(boneyardGuardSg.getName(), boneyardGuardSg);
        perksMap.put(boneyardGuardBg.getName(), boneyardGuardBg);
        perksMap.put(boneyardGuardEw.getName(), boneyardGuardEw);
        perksMap.put(boneyardGuardMelee.getName(), boneyardGuardMelee);
        perksMap.put(boneyardGuardTh.getName(), boneyardGuardTh);
        perksMap.put(cautiousNature.getName(), cautiousNature);
        perksMap.put(deadManWalking.getName(), deadManWalking);
        perksMap.put(demolitionExpert.getName(), demolitionExpert);
        perksMap.put(dismantler.getName(), dismantler);
        perksMap.put(educated.getName(), educated);
        perksMap.put(explorer.getName(), explorer);
        perksMap.put(fasterHealing.getName(), fasterHealing);
        perksMap.put(fortuneFinder.getName(), fortuneFinder);
        perksMap.put(harmless.getName(), harmless);
        perksMap.put(lightStep.getName(), lightStep);
        perksMap.put(locksmith.getName(), locksmith);
        perksMap.put(lumberjack.getName(), lumberjack);
        perksMap.put(magneticPersonality.getName(), magneticPersonality);
        perksMap.put(masterThief.getName(), masterThief);
        perksMap.put(monsterSkinning.getName(), monsterSkinning);
        perksMap.put(mrFixit.getName(), mrFixit);
        perksMap.put(negotiator.getName(), negotiator);
        perksMap.put(nerdRage.getName(), nerdRage);
        perksMap.put(packRat.getName(), packRat);
        perksMap.put(pathfinder.getName(), pathfinder);
        perksMap.put(pickPocket.getName(), pickPocket);
        perksMap.put(radResistance.getName(), radResistance);
        perksMap.put(ranger.getName(), ranger);
        perksMap.put(scout.getName(), scout);
        perksMap.put(scrounger.getName(), scrounger);
        perksMap.put(sexAppeal.getName(), sexAppeal);
        perksMap.put(smittysMeal.getName(), smittysMeal);
        perksMap.put(snakeater.getName(), snakeater);
        perksMap.put(speaker.getName(), speaker);
        perksMap.put(stealthGirl.getName(), stealthGirl);
        perksMap.put(straightShooter.getName(), straightShooter);
        perksMap.put(strongBack.getName(), strongBack);
        perksMap.put(swiftLearner.getName(), swiftLearner);
        perksMap.put(theGoodDoctor.getName(), theGoodDoctor);
        perksMap.put(thief.getName(), thief);
        perksMap.put(treasureHunter.getName(), treasureHunter);
        perksMap.put(wonderlandCc.getName(), wonderlandCc);
        perksMap.put(wonderlandHp.getName(), wonderlandHp);
        perksMap.put(wonderlandHr.getName(), wonderlandHr);
    }

    public Perk getPerkByName(String name) {
        return perksMap.get(name);
    }

    public List<String> getSupportPerksNames() {
        List<String> perksNames = new ArrayList<String>();

        perksMap.forEach((name, stat) -> {
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

    public List<String> getAvailablePerksNames(boolean isCreated){
        List<String> availablePerks = new ArrayList<>();

        if(!isCreated){
            return availablePerks;
        }

        perksMap.forEach((name, perk) -> {
            if(!perk.isTaken() && perk.meetsRequirements()){
                availablePerks.add(perk.getName());
            }
        });

        return availablePerks;
    }

    public List<String> getUnAvailablePerksNames(boolean isCreated){
        List<String> unAvailablePerks = new ArrayList<>();

        if(!isCreated){
            return getSupportPerksNames();
        }

        perksMap.forEach((name, perk) -> {
            if(!perk.isTaken() && !perk.meetsRequirements()){
                unAvailablePerks.add(perk.getName());
            }
        });

        return unAvailablePerks;
    }

    public void takeSupportPerk(String name) {
        getPerkByName(name).takePerk();
    }


}
