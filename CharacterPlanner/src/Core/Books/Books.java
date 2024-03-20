package Core.Books;

import Core.Character;
import Core.Skills.Skills;
import Core.Specials.Special;

import java.util.*;

public class Books {
    private int booksLimit;
    private Map<String, Book> booksMap;
    private int booksSkillPoints;

    public Books(Skills skills){
        booksLimit = 10;
        booksSkillPoints = 6;
        booksMap = new LinkedHashMap<>();

        Book smallGunsBook = new Book("Guns and Bullets", skills.getSkillByName("Small Guns"));
        Book bigGunsBook = new Book("Big Guns Magazine", skills.getSkillByName("Big Guns"));
        Book energyWeaponsBook = new Book("Guns and Cells", skills.getSkillByName("Energy Weapons"));
        Book closeCombatBook = new Book("Way of the Fist", skills.getSkillByName("Close Combat"));
        Book scavengingBook = new Book("Not Used", skills.getSkillByName("Scavenging"));
        Book throwingBook = new Book("Throwing Magazine", skills.getSkillByName("Throwing"));
        Book firstAidBook = new Book("First Aid Book", skills.getSkillByName("First Aid"));
        Book doctorBook = new Book("Advanced Medicine", skills.getSkillByName("Doctor"));
        Book sneakBook = new Book("Sneak Magazine", skills.getSkillByName("Sneak"));
        Book lockpickBook = new Book("Secrets of lockpicker", skills.getSkillByName("Lockpick"));
        Book stealBook = new Book("Steal Magazine", skills.getSkillByName("Steal"));
        Book trapsBook = new Book("Maddock's Tricks & Traps'", skills.getSkillByName("Traps"));
        Book scienceBook = new Book("Big Book of Science", skills.getSkillByName("Science"));
        Book repairBook = new Book("Deans Electronics", skills.getSkillByName("Repair"));
        Book speechBook = new Book("Art of Public Speaking", skills.getSkillByName("Speech"));
        Book barterBook = new Book("Tales of Junktown Jerky Vendor", skills.getSkillByName("Barter"));
        Book gamblingBook = new Book("Not Used", skills.getSkillByName("Gambling"));
        Book outdoorsmanBook = new Book("Scout Handbook", skills.getSkillByName("Outdoorsman"));


        booksMap.put(smallGunsBook.getSkill().getName(), smallGunsBook);
        booksMap.put(bigGunsBook.getSkill().getName(), bigGunsBook);
        booksMap.put(energyWeaponsBook.getSkill().getName(), energyWeaponsBook);
        booksMap.put(closeCombatBook.getSkill().getName(), closeCombatBook);
        booksMap.put(scavengingBook.getSkill().getName(), scavengingBook);
        booksMap.put(throwingBook.getSkill().getName(), throwingBook);
        booksMap.put(firstAidBook.getSkill().getName(), firstAidBook);
        booksMap.put(doctorBook.getSkill().getName(), doctorBook);
        booksMap.put(sneakBook.getSkill().getName(), sneakBook);
        booksMap.put(lockpickBook.getSkill().getName(), lockpickBook);
        booksMap.put(stealBook.getSkill().getName(), stealBook);
        booksMap.put(trapsBook.getSkill().getName(), trapsBook);
        booksMap.put(scienceBook.getSkill().getName(), scienceBook);
        booksMap.put(repairBook.getSkill().getName(), repairBook);
        booksMap.put(speechBook.getSkill().getName(), speechBook);
        booksMap.put(barterBook.getSkill().getName(), barterBook);
        booksMap.put(gamblingBook.getSkill().getName(), gamblingBook);
        booksMap.put(outdoorsmanBook.getSkill().getName(), outdoorsmanBook);

    }

    public void readBook(String name){
        Book book = getBookBySkillName(name);

        book.readBook(this, booksSkillPoints);
    }

    public void readAllBooks(){
        booksMap.forEach((name, book) -> {
            if(!book.getSkill().getName().equals("Scavenging") && !book.getSkill().getName().equals("Gambling")) {
                for(int i = book.getRead(); i < booksLimit; i++){
                    book.readBook(this, booksSkillPoints);
                }
            }
        });
    }

    public int getBooksLimit() {
        return booksLimit;
    }

    public Book getBookBySkillName(String name){
        return  booksMap.get(name);
    }

    public List<Integer> getBooksAmountValues(){
        List<Integer> values = new ArrayList<>();
        booksMap.forEach((name, book) -> {
            values.add(book.getRead());
        });

        return  values;
    }
}
