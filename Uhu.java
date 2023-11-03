import java.util.Random;
/**
* Uhu object class.
* @author Yongjun Yu
* @version 1.0
* @since 9/23/23
*/
public class Uhu extends Panuhunuhu {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia.
   * This is the state record */
   private static final double UHU_MAX_LENGTH = 30.0;
   /** constant minimum length for this Ia.  */
   private static final double UHU_MIN_LENGTH = 12.0;
  
 
   /**
   * Constructor for making Uhu with random length 
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the fourth phase of the species and always female
   * @throws FishSizeException if length is less than minLength
   * Must send minLength through as a temp length or throws exception
   */
   public Uhu() {
      super("Uhu", "Parrotfish", "Scarus psittacus", UHU_MAX_LENGTH, UHU_MIN_LENGTH, 
         UHU_MIN_LENGTH, (UHU_MIN_LENGTH * 2), DIET_ITEMS, "gray or blue-green",
          "reddish gray or blue", "MorF"); 
      //set random length and sex
      this.initLength(); 
      this.initSex(); 
   
   }
   
   /**
   * Constructor for making Uhu with a given length 
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the fourth phase of the species and always female.
   * @param length The length of this fish.
   * @throws FishSizeException if length is less than minLength
   */
   public Uhu(double length) {
      super("Uhu", "Parrotfish", "Scarus psittacus", UHU_MAX_LENGTH, UHU_MIN_LENGTH, 
         length, (length * 2), DIET_ITEMS, "bodyColor", 
         "finColor", "sex"); 
      this.initSex();
   }

   //Uhu do not change to another type
   //overwrite the grow method from the base class.
   /**
   * Should be used by eat method to increase length of fish. 
   * Should determine a new length and internally call setLength
   * Does not throw FishSizeException because this is the final type
   */
   protected void grow() {
      Random ran = new Random();
      double lengthIncrease = ran.nextDouble() * growthRate;
   
      //calculate a new length by adding a random value between 0 and growthRate
      this.length = this.length + lengthIncrease;
      this.weight = this.length * 2;
   }
   
    /**.
   * Sets the fish's sex, body color and fin color.
   */ 
   public void initSex() {
   
      Random ran = new Random();
      int filp = ran.nextInt(2);  
      if (filp == 0) {
         this.sex = "male";  
      } else {
         this.sex = "female";
      }
       
      if (this.sex == "male") {
         this.bodyColor = "blue-green"; 
         this.finColor = "blue"; 
      } else {
         this.bodyColor = "gray";
         this.finColor = "reddish gray";
      }
    
   }
  /**.
   * Change fish's sex.
   */
   public void changeSex() {
      this.sex = "supermale";
   }
   /** 
   * changes this Uhu's color.
   *@param bodyColor This fish body color.
   *@param finColor This fish fin color.
   */
   public void setColor(String bodyColor, String finColor) {
      this.bodyColor = bodyColor;
      this.finColor = finColor;
   }


   /** returns the same fish
   * Uhu don't level up, this is the terminal type.
   * method is required but shouldn't do anything
   * @return the same fish
   */
   public Uhu levelUp() {
   
      return this;
   
   }
}
   
