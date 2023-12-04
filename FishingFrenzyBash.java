import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
* Fishing Frenzy Bash.
* @authors Justin Kugiyama, Lewen Lin, & Yongjun Yu
* @since 12/3/23
*/
public class FishingFrenzyBash {
   /** Max size capacity for pond. */
   static final int POND_SIZE = 56;
   /** Game duration in months. */
   static final int GAME_LENGTH = 12;
   /** Number of turns for player per month. */
   static final int PLAY = 3;
   /** 
   * Fill pond method.
   * @param args not used
   */
   public static void main (String[] args) {
      // ArrayList for fish pond
      ArrayList<FishableI_a> lokoI_a = new ArrayList<>();
      boolean fish = true;
      
      //Filliing up pond with baby fish
      lokoI_a = FishingFrenzyBash.fillPond();
      
      // if(fish) {
   //          System.out.println(lokoI_a);
   //       }
      
      //Simulating two years for fish growth
      FishingFrenzyBash.growFish(lokoI_a);
      //Open pond for fishing
      FishingFrenzyBash.lawaI_a(lokoI_a);
      
   } //close main
   
   public static ArrayList<FishableI_a> fillPond() {
      ArrayList<FishableI_a> aList = new ArrayList<>();
      
      //make 50 baby fish in the pond
      
      for(int i = 0; i < 14; i++) {
         aList.add(new MoiLi_i());
         aList.add(new Oama());
         aList.add(new Pua_ama());
         aList.add(new Ohua());
      }
      return aList;
   
   } //close fillPond
   
   /**
   * Runs arraylist of I_a through 24 eating/growing cycles.
   * @param aList the list of fish.
   */
   public static void growFish(ArrayList<FishableI_a> aList) {
      FishableI_a ia;
      boolean debug = false; //turn printing on and off
      for (int m = 0; m < 24; m++) {
      //all fish in the pond
         for (int i = 0; i < aList.size(); i++) {
         //loop over array 
            if (debug) {
               System.out.println("==========================");
               System.out.println("Feeding  the fish" + i);
               System.out.println("==========================\n");
            }
            ia = aList.get(i);
            if (debug) {
               System.out.println(ia);
            }
            try { //must check for need to levelUp
            //use EnglishName because doesn't change with size
               if (ia.getEnglishName().equals("Striped Mullet")) {
                  ia.eat("algae");
               } else if (ia.getEnglishName().equals("Goatfish") 
                     || ia.getEnglishName().equals("Yellowfin Goatfish") 
                     || ia.getEnglishName().equals("Square-spot Goatfish"))  {
                  ia.eat("worms");
               } else if (ia.getEnglishName().equals("Parrotfish")) {
                  ia.eat("algae");
                  
               } else if (ia.getEnglishName().equals("Six-fingered threadfin")) {
                  ia.eat("crustaceans");
                  
               }
               if (debug) {
                  System.out.println("****After eat and grow: " + ia.getName() 
                        + ": " + ia.getLength() + "\n");
               }
            } catch (FishSizeException fe) {
               //need to level up
               
               ia = ia.levelUp();
               if (debug) {
                  System.out.println(fe.getMessage());
                  System.out.println("**** After levelUp: " + ia + "\n");
               }
            }
            aList.set(i, ia);
         }
      } // close m loop
      
   
   
   } //close growFish method

   
   /**
   * lawaI'a
   * @param fishPond arrayList of fish to be caught
   */
   public static void lawaI_a(ArrayList<FishableI_a> fishPond) {
      Random ranGen = new Random();
      Scanner scan = new Scanner(System.in);
      FishableI_a ia;
      ArrayList<FishableI_a> userSack = new ArrayList<>();
      int chosenFish = 0;
      boolean isCaught = false;
      boolean isLegal = false;
      int gameCount = 0;
      int playerTurn = 0;
      String userIn;
      
      while (gameCount < GAME_LENGTH) {
         
         while (playerTurn < PLAY) {
            System.out.println("* Choose:");
            System.out.println("1. Cast out for a fish");
            System.out.println("2. View fishing rules");
            System.out.println("3. View sack of fish");
            System.out.println("4. Throw back a fish in the sack");
         
            userIn = scan.nextLine();
            userIn = userIn.trim();
         
            switch(userIn) {
               //user chose to cast out for a fish
               case "1":
                  chosenFish = ranGen.nextInt(POND_SIZE);
                  try {
                     ia = fishPond.get(chosenFish);
                  
                     System.out.println("You have hooked a fish!");
                     //randomly caught or not
                     isCaught = ranGen.nextBoolean();
                     if (isCaught) {
                        System.out.println("You have caught a fish!");
                        System.out.println(ia);
                        System.out.println("Do you wish to keep your fish y/n");
                        userIn = scan.nextLine();
                        userIn = userIn.trim().toUpperCase();
                        switch(userIn) {
                           case "Y":      
                              userSack.add(ia);
                              System.out.println("You have kept your fish");
                              fishPond.remove(chosenFish); //take fish out of the pond
                              if (ia.isLegalSize()) {
                                 System.out.println("Your fish is legal");
                              } else {
                                 System.out.println("You kept an illegal fish!");
                                 System.out.println("You got a ticket and all of your fish were confiscated!");
                              }
                              break;
                           case "N":
                              System.out.println("You released your fish");
                              break;
                           default:
                              System.out.println("***INVALID INPUT***");
                              System.out.println("Please enter a y or n");
                              break;
                        }
                     } else {
                        System.out.println("Your fish got away!");
                     }
                  } catch (IndexOutOfBoundsException ie) { //fish has been removed already
                     System.out.println("You didn't hook anything.");
                  
                  }
                  playerTurn++;
                              
                  break;
               case "2":
                  //user chose to view the fishing rules
                  System.out.println("rules");
                  playerTurn++;
                  break;
               case "3":
                  //user chose to view their sack of fish
                  System.out.println(userSack);
                  break;
               case "4":
                  //user chose to release a fish
                  System.out.println("remove fish");
                  break;
               default:
                  System.out.println("***INVALID CHOICE***");
                  System.out.println("Please enter a valid number");
                  break;
                  
                 
            } //end switch
         
         } //end player turn loop
         gameCount++;  
      } //end game loop
      
   } //close lawai_a method
   
}
         
