abstract class Character {

    protected String name;
    protected int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public abstract void attack();
}


class Warrior extends Character {

    public Warrior(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with a sword!");
    }
}


class Mage extends Character {

    public Mage(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack() {
        System.out.println(name + " casts a basic magic attack!");
    }

    public void attack(String spell) {
        System.out.println(name + " casts " + spell + "!");
    }
}


public class Main {

    public static void main(String[] args) {

        System.out.println("=== VIDEO GAME BATTLE SYSTEM ===");

        Warrior warrior = new Warrior("Thor", 150);
        Mage mage = new Mage("Merlin", 100);

        Character[] characters = {warrior, mage};

        System.out.println("Character Attacks:");

        for (Character character : characters) {
            character.attack();
        }

        System.out.println("Special Mage Attack:");

        mage.attack("Fireball");

        System.out.println("All requirements demonstrated!");
    }
}