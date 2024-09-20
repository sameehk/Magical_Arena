import java.util.Random;
public class Player{
    private int health;
    private int strength;
    private int attack;
    private String name;
    private Random random=new Random();//random object created in Random class


    public Player(String name,int health, int strength,int attack){
        this.name = name;
        this.health = health;//Assigns the value of the constructor parameter health to the instance variable health
        this.strength = strength;
        this.attack = attack;
        
    }
    // Method to roll a six-sided die
    public int rollDie(){
        return random.nextInt(6)+1;
    }
    // Method to apply damage to the player's health
    public void takeDamage(int damage){
        this.health=Math.max(0,this.health-damage);
    }
    // Method to check if the player is still alive
    public boolean isAlive(){
        return this.health>0; // Returns true if health is greater than 0
    }
    // Method to attack another player
    public void attackPlayer(Player opponent){
        // `opponent` is a parameter that refers to a Player object
    int attackRoll = this.rollDie(); // Attacker rolls the die
    int defendRoll = opponent.rollDie(); // Defender (opponent) rolls the die
    
    // Print the random values rolled
    System.out.println(this.name + " rolled " + attackRoll + " for attack.");
    System.out.println(opponent.name + " rolled " + defendRoll + " for defense.");
    int damageCreated = this.attack * attackRoll;// Calculate attack damage
    int damageDefended = opponent.strength * defendRoll;// Calculate defended damage
    
    int damageToOpponent =Math.max(0, damageCreated - damageDefended);// Calculate net damage
    opponent.takeDamage(damageToOpponent);// Apply net damage to the opponent
    
    }

    public int getHealth() {
        return this.health;

    }
    public String getName(){
        return this.name;
    }

    // Method to display the player's current status
    public void displayStatus(){
        System.out.println(name + " {health=" + health + ", strength=" + strength + ", attack=" + attack + "}");
    }
}