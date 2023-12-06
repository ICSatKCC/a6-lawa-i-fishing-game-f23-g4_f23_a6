import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

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
      ArrayList<FishableI_a> lokoIa = new ArrayList<>();
      boolean fish = true;
      
      //Filliing up pond with baby fish
      lokoIa = FishingFrenzyBash.fillPond();
      
      // if(fish) {
   //          System.out.println(lokoIa);
   //       }
      
      //Simulating two years for fish growth
      for (int m = 0; m < 24; m++) {
         FishingFrenzyBash.growFish(lokoIa);
      }
      //Open pond for fishing
      FishingFrenzyBash.lawaIa(lokoIa);
      //
      
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
   
   } //close growFish method

   
   /**
   * lawaI'a.
   * @param fishPond arrayList of fish to be caught
   */
   public static void lawaIa(ArrayList<FishableI_a> fishPond) {
      Random ranGen = new Random();
      Scanner scan = new Scanner(System.in);
      FishableI_a ia;
      ArrayList<FishableI_a> userSack1 = new ArrayList<>();
      ArrayList<FishableI_a> userSack2 = new ArrayList<>();
      int chosenFish = 0;
      boolean isCaught = false;
      boolean isLegal = false;
      boolean method = false;
      boolean player1 = false;
      boolean player2 = false;
      boolean choice = false;
      boolean fish = false;
      int gameCount = 0;
      double topLength1 = 0;
      double topLength2 = 0;
      String userIn;
      String iTemp;
      String month = "";
      String catchMethod = "";
      
      while (gameCount < GAME_LENGTH) {
         switch(gameCount) {
            case 0:
               month = "January";
               FishingFrenzyBash.growFish(fishPond);
               break;
            case 1:
               month = "February";
               FishingFrenzyBash.growFish(fishPond);
               break;
            case 2:
               month = "March";
               FishingFrenzyBash.growFish(fishPond);
               break;
            case 3:
               month = "April";
               FishingFrenzyBash.growFish(fishPond);
               break;
            case 4:
               month = "May";
               FishingFrenzyBash.growFish(fishPond);
               break;
            case 5:
               month = "June";
               FishingFrenzyBash.growFish(fishPond);
               break;
            case 6:
               month = "July";
               FishingFrenzyBash.growFish(fishPond);
               break;
            case 7:
               month = "August";
               FishingFrenzyBash.growFish(fishPond);
               break;
            case 8:
               month = "September";
               FishingFrenzyBash.growFish(fishPond);
               break;
            case 9:
               month = "October";
               FishingFrenzyBash.growFish(fishPond);
               break;
            case 10:
               month = "November";
               FishingFrenzyBash.growFish(fishPond);
               break;
            case 11:
               month = "December";
               FishingFrenzyBash.growFish(fishPond);
               break;
            default:
               System.out.println("Game Over!");
               break;
         }
         
         if (gameCount < GAME_LENGTH) {
            System.out.println(month);
         } else {
            System.out.println("GAME OVER!");
         }
         
         for (int j = 0; j < 3; j++) {
            while (!player1) {
               System.out.println("* Player 1 Choose:");
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
                           while (!choice) {
                              
                              System.out.println("Do you wish to keep your fish y/n?");
                              System.out.println("* if you would like view the rules again enter r *");
                              userIn = scan.nextLine();
                              userIn = userIn.trim().toUpperCase();
                              
                              switch(userIn) {
                                 case "Y":      
                                    System.out.println("You have kept your fish");
                                    if (ia.isLegalSize()) {
                                       if (ia.isInSeason(month)) {
                                          boolean methodLegal = false;
                                          String a = catchMethod;;
                                          for (String string : ia.getCatchMethods()) {
                                             if (a.equals(string)) {
                                                methodLegal = true;
                                                break;
                                             }
                                          }
                                          if (methodLegal) {
                                             System.out.println("Your fish is legal");
                                             userSack1.add(ia);
                                             //take fish out of the pond
                                             fishPond.remove(chosenFish); 
                                          } else {
                                             System.out.println("You used an illegal catch method!");
                                             System.out.println("You got a ticket and all of " 
                                                    + "your fish were confiscated!");
                                             userSack1.clear();
                                          }
                                       } else {
                                          System.out.println("This fish is not in season!");
                                          System.out.println("You got a ticket and all of " 
                                               + "your fish were confiscated!");
                                          userSack1.clear();
                                       }
                                    } else {
                                       System.out.println("This fish was not of length!");
                                       System.out.println("You got a ticket and all of " 
                                              + "your fish were confiscated!");
                                       userSack1.clear();
                                    }
                                    choice = true;
                                    break;
                                     
                                 case "N":
                                    System.out.println("You released your fish");
                                    choice = true;
                                    break;
                                 case "R":
                                    fishingRules();
                                    break;
                                 default:
                                    System.out.println("\n***INVALID INPUT***");
                                    System.out.println("Please enter a y, n, or r\n");
                                    break; 
                              
                              }  
                           }    
                        } else {
                           System.out.println("Your fish got away!");
                        }
                     } catch (IndexOutOfBoundsException ie) { //fish has been removed already
                        System.out.println("You didn't hook anything.");
                     
                     }
                     method = false;
                     player1 = true;
                     choice = false;
                  
                     break;
                  case "2":
                  //user chose to view the fishing rules
                     fishingRules();
                     break;
                  case "3":
                  //user chose to view their sack of fish
                     if (userSack1.size() > 0) {
                        for (int i = 0; i < userSack1.size(); i++) {
                           System.out.println((i + 1) + ": \n" + userSack1.get(i) + "\n");
                        }
                     } else {
                        System.out.println("You currently do not have any fish\n");
                     }
                     break;
                  case "4":
                     //user chose to release a fish
                     if (userSack1.size() > 0) {
                        while (!fish) {
                           System.out.println("Which fish would you like to release?");
                           for (int i = 0; i < userSack1.size(); i++) {
                              System.out.println((i + 1) + ": \n" + userSack1.get(i));
                           }
                           userIn = scan.nextLine();
                           userIn = userIn.trim();
                           try {
                              chosenFish = (Integer.parseInt(userIn) - 1);
                              if (userSack1.get(chosenFish) != null) {
                                 ia = userSack1.get(chosenFish);
                                 userSack1.remove(chosenFish);
                                 fishPond.add(ia);
                                 System.out.println("You have released: \n" + ia + "\n");
                                 fish = true;
                              } else {
                                 System.out.println("This fish does not exist in your sack");
                              }
                           
                           } catch (NumberFormatException nfe) {
                              System.out.println("Please enter an integer number!!");
                           } catch (IndexOutOfBoundsException iobe) {
                              System.out.println("Please a number in within your sack!");
                           }
                        }
                     
                     } else {
                        System.out.println("You currently do not have any fish\n");
                     }
                     break;
                  default:
                     System.out.println("***INVALID CHOICE***");
                     System.out.println("Please enter a valid number");
                     break;
                  
               } //end switch
            } //end while
           
            while (!player2) {
               System.out.println("* Player 2 Choose:");
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
                           while (!choice) {
                           
                              System.out.println("Do you wish to keep your fish y/n?");
                              System.out.println("* if you would like view the rules again enter r *");
                              userIn = scan.nextLine();
                              userIn = userIn.trim().toUpperCase();
                              
                              switch(userIn) {
                                 case "Y":      
                                    System.out.println("You have kept your fish");
                                    if (ia.isLegalSize()) {
                                       if (ia.isInSeason(month)) {
                                          boolean methodLegal = false;
                                          String a = catchMethod;;
                                          for (String string : ia.getCatchMethods()) {
                                             if (a.equals(string)) {
                                                methodLegal = true;
                                                break;
                                             }
                                          }
                                          if (methodLegal) {
                                             System.out.println("Your fish is legal");
                                             userSack2.add(ia);
                                             //take fish out of the pond
                                             fishPond.remove(chosenFish); 
                                          } else {
                                             System.out.println("You used an illegal catch method!");
                                             System.out.println("You got a ticket and all of " 
                                                    + "your fish were confiscated!");
                                             userSack2.clear();
                                          }
                                       } else {
                                          System.out.println("This fish is not in season!");
                                          System.out.println("You got a ticket and all of " 
                                               + "your fish were confiscated!");
                                          userSack2.clear();
                                       }
                                    } else {
                                       System.out.println("This fish was not of legal length!");
                                       System.out.println("You got a ticket and all of " 
                                              + "your fish were confiscated!");
                                       userSack2.clear();
                                    }
                                    choice = true;
                                    break;
                                     
                                 case "N":
                                    System.out.println("You released your fish");
                                    choice = true;
                                    break;
                                 case "R":
                                    fishingRules();
                                    break;
                                 default:
                                    System.out.println("\n***INVALID INPUT***");
                                    System.out.println("Please enter a y, n, or r\n");
                                    break;                                  
                              }
                           } 
                        } else {
                           System.out.println("Your fish got away!");
                        }
                     } catch (IndexOutOfBoundsException ie) { //fish has been removed already
                        System.out.println("You didn't hook anything.");
                     
                     }
                     method = false;
                     player2 = true;
                     choice = false;
                  
                     break;
                  case "2":
                  //user chose to view the fishing rules
                     fishingRules();
                     break;
                  case "3":
                  //user chose to view their sack of fish
                     if (userSack2.size() > 0) {
                        for (int i = 0; i < userSack2.size(); i++) {
                           System.out.println((i + 1) + ": \n" + userSack2.get(i) + "\n");
                        }
                     } else {
                        System.out.println("You currently do not have any fish\n");
                     }
                     break;
                  case "4":
                  //user chose to release a fish
                     if (userSack2.size() > 0) {
                        while (!fish) {
                           System.out.println("Which fish would you like to release?");
                           for (int i = 0; i < userSack2.size(); i++) {
                              System.out.println((i + 1) + ": \n" + userSack2.get(i));
                           }
                           userIn = scan.nextLine();
                           userIn = userIn.trim();
                           try {
                              chosenFish = (Integer.parseInt(userIn) - 1);
                              if (userSack2.get(chosenFish) != null) {
                                 ia = userSack2.get(chosenFish);
                                 userSack2.remove(chosenFish);
                                 fishPond.add(ia);
                                 System.out.println("You have released: \n" + ia + "\n");
                                 fish = true;
                              } else {
                                 System.out.println("This fish does not exist in you sack");
                              }
                           } catch (NumberFormatException nfe) {
                              System.out.println("Please enter a integer number!!");
                           } catch (IndexOutOfBoundsException iobe) {
                              System.out.println("Please a number in within your sack!");
                           }
                        }
                     } else {
                        System.out.println("You currently do not have any fish\n");
                     }
                     break;
                  default:
                     System.out.println("***INVALID CHOICE***");
                     System.out.println("Please enter a valid number");
                     break;
                  
               } //end switch
            
            } //end while loop player2
            player1 = false;
            player2 = false;
            fish = false;
         } //end players 3 turn loop
         gameCount++;
      } // end game loop
      System.out.println("GAME OVER!");
      Collections.sort(userSack1, Collections.reverseOrder());
      if (userSack1.size() > 0) {
         topLength1 = userSack1.get(0).getLength();
         if (userSack1.size() > 1) {
            topLength1 = topLength1 + userSack1.get(1).getLength();
            if (userSack1.size() > 2) {
               topLength1 = topLength1 + userSack1.get(2).getLength();
            }
         }
      } else {
         topLength1 = 0;
      }
      
      Collections.sort(userSack2, Collections.reverseOrder());
      if (userSack1.size() > 0) {
         topLength1 = userSack1.get(0).getLength();
         if (userSack1.size() > 1) {
            topLength1 = topLength1 + userSack1.get(1).getLength();
            if (userSack1.size() > 2) {
               topLength1 = topLength1 + userSack1.get(2).getLength();
            }
         }   
      } else {
         topLength1 = 0;
      }
      
      
      
      if (topLength1 > topLength2) {
         System.out.println("Player 1 won!");
         System.out.println("Winning Player's top 3 fish:");
         System.out.println("1. " + userSack1.get(0));
         System.out.println("2. " + userSack1.get(1));
         System.out.println("3. " + userSack1.get(2));
      } else if (topLength1 < topLength2) {
         System.out.println("Player 2 won!");
         System.out.println("Winning Player's top 3 fish:");
         System.out.println("1. " + userSack1.get(0));
         System.out.println("2. " + userSack1.get(1));
         System.out.println("3. " + userSack1.get(2));
      } else {
         System.out.println("It was a tie!");
      }
      
      
   } //close lawaI'a class
      
   /**
   * Fishing rules.
   */
   public static void fishingRules() {
      System.out.println("Anae' family: ");
      System.out.println("Legal size: 11 inches and above");
      System.out.println("Season: April - November");
      System.out.println("Valid catch methods: net or pole\n");
      
      System.out.println("Uhu family: ");
      System.out.println("Legal size: 12 inches and above");
      System.out.println("Season: year round");
      System.out.println("Valid catch methods: throw net, spear, or pole\n");
      
      System.out.println("Weke family: ");
      System.out.println("Legal size: no minimum legal size");
      System.out.println("Season: year round");
      System.out.println("Valid catch methods: net, trap, or pole\n");
      
      System.out.println("Moi family: ");
      System.out.println("Legal size: 11 inches and above");
      System.out.println("Season: January - May & September - December");
      System.out.println("Valid catch methods: net or pole\n");
   
   }
   
} //close class