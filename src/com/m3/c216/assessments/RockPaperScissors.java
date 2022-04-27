import java.util.*;

public class RockPaperScissors {
    public static void main(String [] args){



        Scanner playersInput = new Scanner(System.in);
        System.out.print("How many rounds do you want to play? ");
        int totalRounds = playersInput.nextInt();
        int currentRounds = 0;
        boolean playAgain = true;
        if(totalRounds>10 || totalRounds<1){
            System.out.println("Error: out of bounds");
        }

        while(playAgain){
            game();
            currentRounds++;
            if(currentRounds == totalRounds){
                break;
            }
        }

    }





    private static void game(){

        Scanner Input = new Scanner(System.in);
        System.out.println(" ");
        System.out.printf("Time to choose Rock, Paper or Scissors: ");
        String playersMove = Input.nextLine();
        System.out.println("Player: " + playersMove);
        if(!playersMove.equalsIgnoreCase("Rock") && !playersMove.equalsIgnoreCase("Paper") && !playersMove.equalsIgnoreCase("Scissors")){
            System.out.println("Error");
        }else{

            // computers Move
            Random random = new Random();
            int max = 4;
            int min = 1;
            //This gives you a random number in between 1 (inclusive) and 4 (exclusive).
            int compMove = random.nextInt(max - min) + min;


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
        return;
    }
}