package Core.Implants;


import Core.Character;
import Core.Requirements.ImplantRequirement;
import Core.Requirements.LevelRequirement;
import Core.Requirements.Requirement;
import Core.Requirements.SpecialRequirement;

import java.util.*;

public class Implants {
    private Map<String, Implant> implantsMap;

    public Implants(){
        implantsMap = new LinkedHashMap<>();

        LevelRequirement basicImplantLevelReq = new LevelRequirement(30, true);
        LevelRequirement advancedImplantLevelReq = new LevelRequirement(40, true);

        /*SPECIAL Implants*/
        SpecialRequirement specialSTReq = new SpecialRequirement("Strength", 9, false);
        SpecialRequirement specialPEReq = new SpecialRequirement("Perception", 9, false);
        SpecialRequirement specialENReq = new SpecialRequirement("Endurance", 9, false);
        SpecialRequirement specialCHReq = new SpecialRequirement("Charisma", 9, false);
        SpecialRequirement specialINReq = new SpecialRequirement("Intelligence", 9, false);
        SpecialRequirement specialAGReq = new SpecialRequirement("Agility", 9, false);
        SpecialRequirement specialLKReq = new SpecialRequirement("Luck", 9, false);

        List<Requirement> specialSTReqs = new ArrayList<>();
        specialSTReqs.add(basicImplantLevelReq);
        specialSTReqs.add(specialSTReq);
        Implant specialST = new Implant("SPECIAL +1 ST", specialSTReqs);

        List<Requirement> specialPEReqs = new ArrayList<>();
        specialPEReqs.add(basicImplantLevelReq);
        specialPEReqs.add(specialPEReq);
        Implant specialPE = new Implant("SPECIAL +1 PE", specialPEReqs);

        List<Requirement> specialENReqs = new ArrayList<>();
        specialENReqs.add(basicImplantLevelReq);
        specialENReqs.add(specialENReq);
        Implant specialEN = new Implant("SPECIAL +1 EN", specialENReqs);

        List<Requirement> specialCHReqs = new ArrayList<>();
        specialCHReqs.add(basicImplantLevelReq);
        specialCHReqs.add(specialCHReq);
        Implant specialCH = new Implant("SPECIAL +1 CH", specialCHReqs);

        List<Requirement> specialINReqs = new ArrayList<>();
        specialINReqs.add(basicImplantLevelReq);
        specialINReqs.add(specialINReq);
        Implant specialIN = new Implant("SPECIAL +1 IN", specialINReqs);

        List<Requirement> specialAGReqs = new ArrayList<>();
        specialAGReqs.add(basicImplantLevelReq);
        specialAGReqs.add(specialAGReq);
        Implant specialAG = new Implant("SPECIAL +1 AG", specialAGReqs);

        List<Requirement> specialLKReqs = new ArrayList<>();
        specialLKReqs.add(basicImplantLevelReq);
        specialLKReqs.add(specialLKReq);
        Implant specialLK = new Implant("SPECIAL +1 LK", specialLKReqs);

        Implant dermalImplant = new Implant("Dermal Impact Armor", basicImplantLevelReq);
        Implant phoenixImplant = new Implant("Phoenix Armor", basicImplantLevelReq);
        Implant nemeanImplant = new Implant("Nemean Armor(1)", basicImplantLevelReq);

        /*Combat Implants*/
        ImplantRequirement dermalIIReq = new ImplantRequirement("Dermal Impact Armor", true);
        ImplantRequirement phoenixIIReq = new ImplantRequirement("Phoenix Armor", true);
        ImplantRequirement nemeanIIReq = new ImplantRequirement("Nemean Armor(1)", true);

        /*Adv Combat Implants*/
        List<Requirement> dermalIIReqs = new ArrayList<>();
        dermalIIReqs.add(advancedImplantLevelReq);
        dermalIIReqs.add(dermalIIReq);
        Implant dermalImplantII = new Implant("Dermal Impact Assault", dermalIIReqs);

        List<Requirement> phoenixIIReqs = new ArrayList<>();
        phoenixIIReqs.add(advancedImplantLevelReq);
        phoenixIIReqs.add(phoenixIIReq);
        Implant phoenixImplantII = new Implant("Phoenix Assault", phoenixIIReqs);

        List<Requirement> nemeanIIReqs = new ArrayList<>();
        nemeanIIReqs.add(advancedImplantLevelReq);
        nemeanIIReqs.add(nemeanIIReq);
        Implant nemeanImplantII = new Implant("Nemean Armor(2)", nemeanIIReqs);

        /*Cybernetic Implants*/
        ImplantRequirement leftKneeReq = new ImplantRequirement("Right Knee", false);
        List<Requirement> leftKneeIIReqs = new ArrayList<>();
        leftKneeIIReqs.add(basicImplantLevelReq);
        leftKneeIIReqs.add(leftKneeReq);
        Implant leftKnee = new Implant("Left Knee", leftKneeIIReqs);

        ImplantRequirement rightKneeReq = new ImplantRequirement("Left Knee", false);
        List<Requirement> rightKneeIIReqs = new ArrayList<>();
        rightKneeIIReqs.add(basicImplantLevelReq);
        rightKneeIIReqs.add(rightKneeReq);
        Implant rightKnee = new Implant("Right Knee", rightKneeIIReqs);

        ImplantRequirement leftHandeReq = new ImplantRequirement("Right Hand", false);
        List<Requirement> leftHandIIReqs = new ArrayList<>();
        leftHandIIReqs.add(basicImplantLevelReq);
        leftHandIIReqs.add(leftHandeReq);
        Implant leftHand = new Implant("Left Hand", leftHandIIReqs);

        ImplantRequirement rightHandReq = new ImplantRequirement("Left Hand", false);
        List<Requirement> rightHandReqs = new ArrayList<>();
        rightHandReqs.add(basicImplantLevelReq);
        rightHandReqs.add(rightHandReq);
        Implant rightHand = new Implant("Right Hand", rightHandReqs);

        ImplantRequirement eyeReq = new ImplantRequirement("Nociception clamp", false);
        List<Requirement> eyeReqs = new ArrayList<>();
        eyeReqs.add(basicImplantLevelReq);
        eyeReqs.add(eyeReq);
        Implant eye = new Implant("Eye", eyeReqs);

        ImplantRequirement noiceptionClampReq = new ImplantRequirement("Eye", false);
        List<Requirement> noiceptionClampReqs = new ArrayList<>();
        noiceptionClampReqs.add(basicImplantLevelReq);
        noiceptionClampReqs.add(noiceptionClampReq);
        Implant noiceptionClamp = new Implant("Nociception clamp", noiceptionClampReqs);

        ImplantRequirement liverBoxReq = new ImplantRequirement("Adrenal Enhancer", false);
        List<Requirement> liverBoxReqs = new ArrayList<>();
        liverBoxReqs.add(basicImplantLevelReq);
        liverBoxReqs.add(liverBoxReq);
        Implant liverBox = new Implant("Liver Box", liverBoxReqs);

        ImplantRequirement adrenalEnhancerReq = new ImplantRequirement("Liver Box", false);
        List<Requirement> adrenalEnhancerReqs = new ArrayList<>();
        adrenalEnhancerReqs.add(basicImplantLevelReq);
        adrenalEnhancerReqs.add(adrenalEnhancerReq);
        Implant adrenalEnhancer = new Implant("Adrenal Enhancer", adrenalEnhancerReqs);

        Implant cerebralModem = new Implant("Cerebral Modem", advancedImplantLevelReq);

        implantsMap.put(specialST.getName(), specialST);
        implantsMap.put(specialPE.getName(), specialPE);
        implantsMap.put(specialEN.getName(), specialEN);
        implantsMap.put(specialCH.getName(), specialCH);
        implantsMap.put(specialIN.getName(), specialIN);
        implantsMap.put(specialAG.getName(), specialAG);
        implantsMap.put(specialLK.getName(), specialLK);
        implantsMap.put(dermalImplant.getName(), dermalImplant);
        implantsMap.put(dermalImplantII.getName(), dermalImplantII);
        implantsMap.put(phoenixImplant.getName(), phoenixImplant);
        implantsMap.put(phoenixImplantII.getName(), phoenixImplantII);
        implantsMap.put(nemeanImplant.getName(), nemeanImplant);
        implantsMap.put(nemeanImplantII.getName(), nemeanImplantII);
        implantsMap.put(leftKnee.getName(), leftKnee);
        implantsMap.put(rightKnee.getName(), rightKnee);
        implantsMap.put(leftHand.getName(), leftHand);
        implantsMap.put(rightHand.getName(), rightHand);
        implantsMap.put(eye.getName(), eye);
        implantsMap.put(noiceptionClamp.getName(), noiceptionClamp);
        implantsMap.put(liverBox.getName(), liverBox);
        implantsMap.put(adrenalEnhancer.getName(), adrenalEnhancer);
        implantsMap.put(cerebralModem.getName(), cerebralModem);

    }

    public Implant getImplantByName(String name){
        return implantsMap.get(name);
    }

    public List<String> getImplantsNames() {
        List<String> implantsNames = new ArrayList<String>();

        implantsMap.forEach((name, stat) -> {
            implantsNames.add(name);
        });

        return implantsNames;
    }

    public List<Requirement> getRequirements(){
        List<Requirement> requirementList = new ArrayList<>();

        implantsMap.forEach((name, implant) -> {
            requirementList.addAll(implant.getRequirements());
        });

        return  requirementList;
    }

    public List<String> getTakenImplantsNames(){
        List<String> takenImplants = new ArrayList<>();
        implantsMap.forEach((name, implant) -> {
            if(implant.isTaken()){
                takenImplants.add(implant.getName());
            }
        });

        return takenImplants;
    }

    public List<String> getAvailableImplantsNames(){
        List<String> availableImplants = new ArrayList<>();
        implantsMap.forEach((name, implant) -> {
            if(!implant.isTaken() && implant.meetsRequirements()){
                availableImplants.add(implant.getName());
            }
        });

        return availableImplants;
    }

    public List<String> getUnAvailableImplantsNames(){
        List<String> unAvailableImplants = new ArrayList<>();
        implantsMap.forEach((name, implant) -> {
            if(!implant.isTaken() && !implant.meetsRequirements()){
                unAvailableImplants.add(implant.getName());
            }
        });

        return unAvailableImplants;
    }

    public void takeImplant(String name){
        getImplantByName(name).takeImplant();
    }

}
