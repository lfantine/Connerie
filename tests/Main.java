package tests;

public class Main {
    public static void main(String[] args) {
      
        Player player1 = new Player("link", 20.0,1500.0);
        System.out.println("nom :" +player1.getName());
        System.out.println("vie :"+player1.getHealth());
    
        System.out.println("vie :"+player1.getHealth());

        Player player2 = new Player("Zelda", 30.0,150.0);
        player2.setName("Test");
        player1.damage(player1.getAttack());
        System.out.println("nom :" +player2.getName());

    }
}
