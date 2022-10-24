import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

       boolean done = false;
       String play = "";

       do {
           Random rnd = new Random();
           int die1 = rnd.nextInt(6) + 1;
           int die2 = rnd.nextInt(6) + 1;
           int crapsRoll = die1 + die2;

           System.out.println("Initial roll: " + crapsRoll);
           if(crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
               System.out.println("You rolled a " + crapsRoll + ": You crapped out and lost");
           } else if(crapsRoll == 7 || crapsRoll == 11) {
               System.out.println("You rolled a " + crapsRoll + ": You got a natural and won!");
           } else {
               boolean done2 = false;
               System.out.println(crapsRoll + " is now the point");
               do {
                   Random rnd2 = new Random();
                   int die3 = rnd2.nextInt(6) + 1;
                   int die4 = rnd2.nextInt(6) + 1;
                   int crapsRollNext = die3 + die4;
                   String again = "";

                   System.out.print("Press enter to roll again ");
                   again = in.nextLine();

                   System.out.println("Next roll: " + crapsRollNext);
                   if (crapsRollNext == 7) {
                       System.out.println("You rolled a 7: You lose");
                       done2 = true;
                   } else if (crapsRollNext == crapsRoll) {
                       System.out.println("You rolled a " + crapsRollNext + ": You made the point sum and won!");
                       done2 = true;
                   } else {
                       System.out.print("");
                   }

               }while(!done2);
           }

           boolean more = false;

           do {
               System.out.print("Play again? [Y/N]: ");
               play = in.nextLine();

               if (play.equalsIgnoreCase("Y")) {
                   done = false;
                   more = true;
               } else if (play.equalsIgnoreCase("N")) {
                   done = true;
                   more = true;
               } else {
                   System.out.println(play + " is not a valid input");
               }
           }while(!more);

       }while(!done);
    }
}