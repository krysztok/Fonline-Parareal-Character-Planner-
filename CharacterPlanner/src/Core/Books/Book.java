package Core.Books;

import Core.Character;
import Core.Skills.Skill;

public class Book {
    private String name;
    private Skill skill;
    private int read;

    public Book(String name, Skill skill){
        this.name = name;
        this.skill = skill;
        read = 0;
    }

    public String getName() {
        return name;
    }

    public int getRead() {
        return read;
    }

    public Skill getSkill() {
        return skill;
    }

    public void readBook(Books books, int booksSkillPoints){
        if(read < books.getBooksLimit()){
            read++;
            skill.putSkillPoints(booksSkillPoints);
        }
    }

}
