package game.character;

public abstract class Character {

    private final String name;

    Character(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
