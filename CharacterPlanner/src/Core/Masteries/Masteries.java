package Core.Masteries;


import Core.Character;
import Core.Requirements.LevelRequirement;
import Core.Requirements.Requirement;
import Core.Requirements.SpecialRequirement;

import java.util.*;

public class Masteries {
    private Map<String, Mastery> masteriesMap;
    private Boolean hasMastery;

    public Masteries(){
        hasMastery = false;
        masteriesMap = new LinkedHashMap<>();

        LevelRequirement levelReq = new LevelRequirement(30, true);

        //Mastery mutant = new Mastery("Mutant", levelReq);
        //Mastery nightkin = new Mastery("Nightkin", levelReq);
        Mastery rambo = new Mastery("Rambo", levelReq);

        List<Requirement> sniperReqs = new ArrayList<>();
        sniperReqs.add(levelReq);
        SpecialRequirement int5Req = new SpecialRequirement("Intelligence",5, true);
        sniperReqs.add(int5Req);
        Mastery sniper = new Mastery("Sniper", sniperReqs);

        Mastery sweetScience = new Mastery("Sweet Science", levelReq);
        Mastery tank = new Mastery("Tank", levelReq);
        Mastery dragoon = new Mastery("Dragoon", levelReq);

        masteriesMap.put(dragoon.getName(), dragoon);
        //masteriesMap.put(mutant.getName(), mutant);
        //masteriesMap.put(nightkin.getName(), nightkin);
        masteriesMap.put(rambo.getName(), rambo);
        masteriesMap.put(sniper.getName(), sniper);
        masteriesMap.put(sweetScience.getName(), sweetScience);
        masteriesMap.put(tank.getName(), tank);
    }

    public Mastery getMasteryByName(String name) {
        return masteriesMap.get(name);
    }

    public List<String> getMasteriesNames() {
        List<String> masteriesNames = new ArrayList<String>();

        masteriesMap.forEach((name, stat) -> {
            masteriesNames.add(name);
        });

        return masteriesNames;
    }

    public List<Requirement> getRequirements(){
        List<Requirement> requirementList = new ArrayList<>();

        masteriesMap.forEach((name, mastery) -> {
            requirementList.addAll(mastery.getRequirements());
        });

        return  requirementList;
    }

    public List<String> getTakenMasteriesNames(){
        List<String> takenMasteries = new ArrayList<>();
        masteriesMap.forEach((name, implant) -> {
            if(implant.isTaken()){
                takenMasteries.add(implant.getName());
            }
        });

        return takenMasteries;
    }

    public List<String> getAvailableMasteriesNames(){
        List<String> availableMasteries = new ArrayList<>();

        if(hasMastery){
            return availableMasteries;
        }

        masteriesMap.forEach((name, mastery) -> {
            if(!mastery.isTaken() && mastery.meetsRequirements()){
                availableMasteries.add(mastery.getName());
            }
        });

        return availableMasteries;
    }

    public List<String> getUnAvailableMasteriesNames(){
        List<String> unAvailableMasteries = new ArrayList<>();

        if(hasMastery){
            masteriesMap.forEach((name, mastery) -> {
                if(!mastery.isTaken()){
                    unAvailableMasteries.add(mastery.getName());
                }
            });
        }

        masteriesMap.forEach((name, mastery) -> {
            if(!mastery.isTaken() && !mastery.meetsRequirements()){
                unAvailableMasteries.add(mastery.getName());
            }
        });

        return unAvailableMasteries;
    }

    public void takeMastery(String masteryName) {
        if(hasMastery) {
            return;
        }

        Mastery mastery = getMasteryByName(masteryName);
        if(mastery.takeMastery()){
            hasMastery = true;
        }

    }

}
