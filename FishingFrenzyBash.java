import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
* Fishing Frenzy Bash.
* @author Justin Kugiyama, Lewen Lin, & Yongjun Yu
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
   * Main method.
   * @param args not used
   */
   public static void main(String[] args) {
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
   
   /**
   * Fill pond method.
   * @return aList the fish pond
   */
   public static ArrayList<FishableI_a> fillPond() {
      ArrayList<FishableI_a> aList = new ArrayList<>();
      
      //make 50 baby fish in the pond
      
      for (int i = 0; i < 14; i++) {
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
   * lawaI'a.
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
      boolean method = false;
      int gameCount = 0;
      int playerTurn = 1;
      String userIn;
      String iTemp;
      String month = "";
      String catchMethod = "";
      
      while (gameCount < GAME_LENGTH) {
         switch(gameCount) {
            case 0:
               month = "January";
               break;
            case 1:
               month = "February";
               break;
            case 2:
               month = "March";
               break;
            case 3:
               month = "April";
               break;
            case 4:
               month = "May";
               break;
            case 5:
               month = "June";
               break;
            case 6:
               month = "July";
               break;
            case 7:
               month = "August";
               break;
            case 8:
               month = "September";
               break;
            case 9:
               month = "October";
               break;
            case 10:
               month = "November";
               break;
            case 11:
               month = "December";
               break;
            default:
               System.out.println("Game Over!");
               break;
         }
         System.out.println(month);
         
         for (int j = 0; j < 3; j++) {
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
                  while (!method) {
                     System.out.println("Pick your fishing method");
                     System.out.println("a) pole");
                     System.out.println("b) net");
                     System.out.println("c) spear");
                     System.out.println("d) trap");
                     System.out.println("e) throw net");
                  
                     userIn = scan.nextLine();
                     userIn = userIn.trim().toUpperCase();
                  
                     switch(userIn) {
                        case "A":
                           catchMethod = "pole";
                           method = true;
                           break;
                        case "B":
                           catchMethod = "net";
                           method = true;
                           break;
                        case "C":
                           catchMethod = "spear";
                           method = true;
                           break;
                        case "D":
                           catchMethod = "trap";
                           method = true;
                           break;
                        case "E":
                           catchMethod = "throw net";
                           method = true;
                           break;
                        default:
                           System.out.println("***INVALID INPUT***");
                           System.out.println("Please choose a valid letter");
                           break;
                     }
                  
                  } //end while loop
                  
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
                              System.out.println("You have kept your fish");
                              if (ia.isLegalSize()) {
                                 System.out.println("Your fish is legal");
                                 userSack.add(ia);
                                 fishPond.remove(chosenFish); //take fish out of the pond
                              } else {
                                 System.out.println("You kept an illegal fish!");
                                 System.out.println("You got a ticket and all of " 
                                     + "your fish were confiscated!");
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
                  fishingRules();
                  break;
               case "3":
                  //user chose to view their sack of fish
                  for (int i = 0; i < userSack.size(); i++) {
                     System.out.println((i + 1) + ": \n" + userSack.get(i));
                  }
                  break;
               case "4":
                  //user chose to release a fish
                  System.out.println("Which fish would you like to release?");
                  for (int i = 0; i < userSack.size(); i++) {
                     System.out.println((i + 1) + ": \n" + userSack.get(i));
                  }
                  userIn = scan.nextLine();
                  userIn = userIn.trim();
                  chosenFish = (Integer.parseInt(userIn) - 1);
                  ia = userSack.get(chosenFish);
                  userSack.remove(chosenFish);
                  fishPond.add(ia);
                  System.out.println("You have released: \n" + ia);
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
   
   /**
   * Fishing rules.
   */
   public static void fishingRules() {
      System.out.println("Anae' family: ");
      System.out.println("Legal size: 11 inches and above");
      System.out.println("Season: April - November");
      System.out.println("Valid catch methods: net or pole");
      
      System.out.println("Uhu family: ");
      System.out.println("Legal size: 12 inches and above");
      System.out.println("Season: year round");
      System.out.println("Valid catch methods: throw net, spear, or pole");
      
      System.out.println("Weke family: ");
      System.out.println("Legal size: no minimum legal size");
      System.out.println("Season: year round");
      System.out.println("Valid catch methods: net, trap, or pole");
      
      System.out.println("Moi family: ");
      System.out.println("Legal size: 11 inches and above");
      System.out.println("Season: January - May & September - December");
      System.out.println("Valid catch methods: net or pole");
   
   }
   
}
         
