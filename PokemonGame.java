
public class PokemonGame {

    public static void main(String[] args) {

        System.out.println("POKEMON BATTLE:");

        Pikachu pikachu = new Pikachu("Pikachu", 25, 100, 80);

        System.out.println();

        Charizard charizard = new Charizard("Charizard", 36, 150, 100);

        System.out.println("POKEMON STATS:");

        pikachu.displayStats();
        pikachu.displayElectricity();

        System.out.println();

        charizard.displayStats();
        charizard.displayFlamePower();

        System.out.println("INHERITED METHODS: ");

        pikachu.takeDamage(20);
        charizard.takeDamage(35);

        System.out.println("POLYMORPHISM: ");

        pikachu.attack();
        charizard.attack();

        System.out.println("SPECIAL ABILITIES: ");

        pikachu.thunderbolt();
        charizard.flamethrower();

        System.out.println("BATTLE COMPLETE!");
    }
}

class Pokemon {

    private String name;
    private int level;

    protected int health;

    public Pokemon(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;

        System.out.println(name + " has been created!");
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void attack() {
        System.out.println(name + " uses a basic attack!");
    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }

        System.out.println(name + " has " + health + " HP remaining.");
    }

    public void displayStats() {
        System.out.println("Pokemon: " + name);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
    }
}


class Pikachu extends Pokemon {

    private int electricity;

    public Pikachu(String name, int level, int health, int electricity) {
        super(name, level, health);

        this.electricity = electricity;

        System.out.println("Pikachu is ready for battle!");
    }

    public void thunderbolt() {
        if (electricity >= 20) {
            System.out.println(getName() + " uses THUNDERBOLT!");
            electricity -= 20;
        } else {
            System.out.println("Not enough electricity!");
        }
    }

    public void attack() {
        System.out.println(getName() + " uses QUICK ATTACK!");
    }

    public void displayElectricity() {
        System.out.println("Electricity: " + electricity);
    }
}


class Charizard extends Pokemon {

    private int flamePower;

    public Charizard(String name, int level, int health, int flamePower) {
        super(name, level, health);

        this.flamePower = flamePower;

        System.out.println("Charizard is ready for battle!");
    }

    public void flamethrower() {
        if (flamePower >= 30) {
            System.out.println(getName() + " uses FLAMETHROWER!");
            flamePower -= 30;
        } else {
            System.out.println("Not enough flame power!");
        }
    }

    public void attack() {
        System.out.println(getName() + " uses WING ATTACK!");
    }

    public void displayFlamePower() {
        System.out.println("Flame Power: " + flamePower);
    }
}

/* This is the code output.
POKEMON BATTLE:
Pikachu has been created!
Pikachu is ready for battle!

Charizard has been created!
Charizard is ready for battle!
 POKEMON STATS:
Pokemon: Pikachu
Level: 25
Health: 100
Electricity: 80

Pokemon: Charizard
Level: 36
Health: 150
Flame Power: 100
INHERITED METHODS: 
Pikachu has 80 HP remaining.
Charizard has 115 HP remaining.
POLYMORPHISM: 
Pikachu uses QUICK ATTACK!
Charizard uses WING ATTACK!
SPECIAL ABILITIES: 
Pikachu uses THUNDERBOLT!
Charizard uses FLAMETHROWER!
BATTLE COMPLETE: 
 */