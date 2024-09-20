import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Get player A details
        System.out.println("Enter details for Player A:");
        System.out.print("Name: ");
        String nameA = scanner.nextLine();
        System.out.print("Health: ");
        int healthA = scanner.nextInt();
        System.out.print("Strength: ");
        int strengthA = scanner.nextInt();
        System.out.print("Attack: ");
        int attackA = scanner.nextInt();

        // Get player B details
        System.out.println("Enter the details for Player B:");
        scanner.nextLine();// Consume the leftover newline
        System.out.print("Name: ");
        String nameB = scanner.nextLine();
        System.out.print("Health: ");
        int healthB = scanner.nextInt();
        System.out.print("Strength: ");
        int strengthB = scanner.nextInt();
        System.out.print("Attack: ");
        int attackB = scanner.nextInt();
       
        



        // Create Player objects
        Player playerA = new Player(nameA, healthA, strengthA, attackA);
        Player playerB = new Player(nameB, healthB,strengthB, attackB);



        // Display initial status of both players
        System.out.println("Initial Status:");
        playerA.displayStatus();
        playerB.displayStatus();

        // Determine the initial attacker and defender based on health
        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;
     
         // Run the battle until one of the players is defeated
        while (playerA.isAlive() && playerB.isAlive()){
            // Attacker attacks defender
            attacker.attackPlayer(defender);

            // Swap roles for the next round
            Player temp = attacker;
            attacker =defender;
            defender = temp;

            // Display status after each attack
            System.out.println("\nStatus after attack:");
            playerA.displayStatus();
            playerB.displayStatus();


        }

        // Determine and display the winner
        if (playerA.isAlive()) {
            System.out.println("\n" + playerA.getName() + " wins!");

        } else {
            System.out.println("\n" + playerB.getName() + " wins!");

        }

        scanner.close();
    }
    
}
