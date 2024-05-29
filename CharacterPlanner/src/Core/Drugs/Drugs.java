package Core.Drugs;

import Core.Character;
import Core.Requirements.MasteryRequirement;
import Core.Requirements.PerkRequirement;
import Core.Requirements.Requirement;

import java.util.*;

public class Drugs {
    private Map<String, Drug> drugsMap;

    public Drugs(){
        drugsMap = new LinkedHashMap<>();

        /* REQUIREMENTS */
        PerkRequirement wayOfTheFruitReq = new PerkRequirement("Way of the Fruit", true);

        List<String> mutantMasteries = new ArrayList<>();
        mutantMasteries.add("Mutant");
        mutantMasteries.add("Nightkin");
        MasteryRequirement mutantReq = new MasteryRequirement(mutantMasteries, true);

        PerkRequirement hasCannibal = new PerkRequirement("Cannibal", true);
        PerkRequirement noCannibal = new PerkRequirement("Cannibal", false);

        List<Requirement> mutieReqs = new ArrayList<>();
        mutieReqs.add(mutantReq);
        mutieReqs.add(noCannibal);

        Drug bakedFish = new Drug("Baked Fish");
        Drug beer = new Drug("Beer", noCannibal);
        Drug booze = new Drug("Booze");
        Drug buffout = new Drug("Buffout", noCannibal);
        Drug cigarettes = new Drug("Cigarettes", noCannibal);
        Drug cookie = new Drug("Cookie");
        Drug fruit = new Drug("Fruit", wayOfTheFruitReq);
        Drug gammaGulpBeer = new Drug("Gamma Gulp Beer");
        Drug jet = new Drug("Jet", noCannibal);
        Drug mentats = new Drug("Mentats", noCannibal);
        Drug mutie = new Drug("Mutie", mutieReqs);
        Drug nukaCola = new Drug("Nuka-Cola", noCannibal);
        Drug psycho = new Drug("Psycho", noCannibal);
        Drug radX = new Drug("Rad-X", noCannibal);
        Drug roentgenRum = new Drug("Roentgen Rum");
        Drug rotGut = new Drug("Rot Gut");

        Drug heart = new Drug("Heart", hasCannibal);
        Drug liver = new Drug("Liver", hasCannibal);
        Drug brain = new Drug("Brain", hasCannibal);
        Drug ear = new Drug("Ear", hasCannibal);
        Drug eye = new Drug("Eye", hasCannibal);

        drugsMap.put(bakedFish.getName(), bakedFish);
        drugsMap.put(beer.getName(), beer);
        drugsMap.put(booze.getName(), booze);
        drugsMap.put(brain.getName(), brain);
        drugsMap.put(buffout.getName(), buffout);
        drugsMap.put(cigarettes.getName(), cigarettes);
        drugsMap.put(cookie.getName(), cookie);
        drugsMap.put(ear.getName(), ear);
        drugsMap.put(eye.getName(), eye);
        drugsMap.put(fruit.getName(), fruit);
        drugsMap.put(gammaGulpBeer.getName(), gammaGulpBeer);
        drugsMap.put(heart.getName(), heart);
        drugsMap.put(jet.getName(), jet);
        drugsMap.put(liver.getName(), liver);
        drugsMap.put(mentats.getName(), mentats);
        drugsMap.put(mutie.getName(), mutie);
        drugsMap.put(nukaCola.getName(), nukaCola);
        drugsMap.put(psycho.getName(), psycho);
        drugsMap.put(radX.getName(), radX);
        drugsMap.put(roentgenRum.getName(), roentgenRum);
        drugsMap.put(rotGut.getName(), rotGut);
    }

    public Drug getDrugByName(String name){
        return drugsMap.get(name);
    }

    public List<String> getDrugsNames() {
        List<String> drugsNames = new ArrayList<String>();

        drugsMap.forEach((name, stat) -> {
            drugsNames.add(name);
        });

        return drugsNames;
    }

    public void takeDrug(String drugName) {
        Drug drug = getDrugByName(drugName);
        drug.takeDrug(!drug.isTaken());
    }

    public List<Requirement> getRequirements(){
        List<Requirement> requirementList = new ArrayList<>();

        drugsMap.forEach((name, drug) -> {
            requirementList.addAll(drug.getRequirements());
        });

        return  requirementList;
    }

    public void validateDrugs(Character character){
        drugsMap.forEach((name, drug) -> {
            drug.getRequirements().forEach(requirement -> {
                requirement.unChecked();
                requirement.check(character);
            });

            if(drug.isTaken() && !drug.meetsRequirements()){
                drug.takeDrug(false);
            }
        });
    }


    public List<String> getTakenDrugsNames(){
        List<String> takenDrugs = new ArrayList<>();
        drugsMap.forEach((name, drug) -> {
            if(drug.isTaken()){
                takenDrugs.add(drug.getName());
            }
        });

        return takenDrugs;
    }

    public List<String> getAvailableDrugsNames(Boolean isCreated) {
        List<String> availableDrugs = new ArrayList<>();

        if(!isCreated){
            return availableDrugs;
        }

        drugsMap.forEach((name, drug) -> {
            if(!drug.isTaken() && drug.meetsRequirements()){
                availableDrugs.add(drug.getName());
            }
        });

        return availableDrugs;
    }

    public List<String> getUnAvailableDrugsNames(Boolean isCreated) {
        List<String> unAvailableDrugs = new ArrayList<>();

        if(!isCreated){
            return getDrugsNames();
        }

        drugsMap.forEach((name, drug) -> {
            if(!drug.isTaken() && !drug.meetsRequirements()){
                unAvailableDrugs.add(drug.getName());
            }
        });

        return unAvailableDrugs;
    }
}
