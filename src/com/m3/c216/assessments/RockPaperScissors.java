import java.util.*;

public class RockPaperScissors {
    public static void main(String [] args){

        // Getting input from the user
        Scanner playersInput = new Scanner(System.in);
        System.out.println("Hi, there! How many rounds would you like to play?");


        // Players Move
        System.out.println("Time to choose Rock, Paper or Scissors: ");
        String playersMove = playersInput.nextLine();
        System.out.println("Player: " + playersMove);
        if(!playersMove.equalsIgnoreCase("Rock") && !playersMove.equalsIgnoreCase("Paper") && !playersMove.equalsIgnoreCase("Scissors")){
            System.out.println("Error");
        }else{

            // Computers Move
            Random random = new Random();
            int max = 4;
            int min = 1;
            //This gives you a random number in between 1 (inclusive) and 4 (exclusive).
            int compMove = random.nextInt(max - min) + min;
            System.out.println(compMove);

            String compChoice = "";
            if(compMove == 1){
                compChoice = "Rock";
            }else if(compMove == 2){
                compChoice = "Paper";
            }else {
                compChoice = "Scissors";
            }
            System.out.println("Computer: " + compChoice);



            // winners and losers
            int compWins = 0;
            int playerWins = 0;
            int draws = 0;

            if(playersMove.equals(compChoice)){
                draws++;
                System.out.println("It's a TIE");
            }else if(playersMove.equals("Rock") && compChoice.equals("Scissors") || playersMove.equals("Paper") && compChoice.equals("Rock") || playersMove.equals("Scissors") && compChoice.equals("Paper")) {
                playerWins++;
                System.out.println("You WIN!");
            }else{
                compWins++;
                System.out.println("You LOST!");
            }

        }

    }
}