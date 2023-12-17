import java.util.Random;

public class Die {

     Random gen = new Random();
     aiHp ai = new aiHp();
    
   //user
   private int diceRoll;
   
   public int userRollDice(int roll)
   {
        roll = gen.nextInt(6-1 + 1) + 1;

        diceRoll = roll;

        return roll;
   }

  

   public String userDieToString()
   {
        return "You have rolled a " + diceRoll;
   }

   public String userDiceDmgToString()
   {
     return "Since you rolled a " + diceRoll + " you will now do ";
   }


   //ai
   private int aiDiceRoll;
   
   public int aiRollDice(int aiRoll)
   {
        aiRoll = gen.nextInt((6 - 1 + 1) + 1);

        aiDiceRoll = aiRoll;
        
        return aiRoll;
   }

   

   public String aiDieToString()
   {
        return "The ai rolled a " + aiDiceRoll;
   }

   public void resetDie() {
     diceRoll = 0;
     aiDiceRoll = 0;
 } 
    
}
