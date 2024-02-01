package Core.Requirements;

import Core.Character;

public abstract class Requirement {
    public boolean isAvailable;
    public boolean wasChecked;

    public String getInfo(){
        return null;
    }

    public Requirement(){
        isAvailable = false;
        wasChecked = false;
    }

    public void check(Character character) {
        isAvailable = false;
    }

    public void unChecked() {
        wasChecked = false;
    }
}
