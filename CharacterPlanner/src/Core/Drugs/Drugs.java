package Core.Drugs;
import Core.Character;

import java.util.*;

public class Drugs {
    private Map<String, Drug> drugsMap;

    public Drugs(){
        drugsMap = new LinkedHashMap<>();

        //Drug bakedFish = new Drug("Baked Fish");
        Drug beer = new Drug("Beer");
        Drug booze = new Drug("Booze");
        Drug buffout = new Drug("Buffout");
        Drug cigarettes = new Drug("Cigarettes");
        Drug cookie = new Drug("Cookie");
        Drug fruit = new Drug("Fruit");
        Drug gammaGulpBeer = new Drug("Gamma Gulp Beer");
        Drug jet = new Drug("Jet");
        Drug mentats = new Drug("Mentats");
        //Drug mutie = new Drug("Mutie");
        Drug nukaCola = new Drug("Nuka-Cola");
        Drug psycho = new Drug("Psycho");
        Drug radX = new Drug("Rad-X");
        Drug roentgenRum = new Drug("Roentgen Rum");
        Drug rotGut = new Drug("Rot Gut");

        //drugsMap.put(bakedFish.getName(), bakedFish);
        drugsMap.put(beer.getName(), beer);
        drugsMap.put(booze.getName(), booze);
        drugsMap.put(buffout.getName(), buffout);
        drugsMap.put(cigarettes.getName(), cigarettes);
        drugsMap.put(cookie.getName(), cookie);
        drugsMap.put(fruit.getName(), fruit);
        drugsMap.put(gammaGulpBeer.getName(), gammaGulpBeer);
        drugsMap.put(jet.getName(), jet);
        drugsMap.put(mentats.getName(), mentats);
        //drugsMap.put(mutie.getName(), mutie);
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
        drug.setTaken(!drug.isTaken());
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
}
