import java.util.Random;
/**
* Ohua fish object class.
* Smallest type version of Ohua fish
* Parent class to Panuhunuhu
* @author Yongjun Yu
* @since 9/22/2023
*/
public class Ohua extends FishableI_a implements ColorChangeable, SexChangeable {
   
   // Constants for this fish.
   /** constant reproductive mode for this Ia. */
   protected static final String REPRODUCTIVE_MODE = "protogynous";// if p it will false
   /** constant array of what the fish eats. */
   protected static final String[] DIET_ITEMS = {"algae"};// if A it will false
   
   /** constant maximum length for this Ia. */
   private static final double OHUA_MAX_LENGTH = 4.0;
   /** constant minimum length for this Ia. */
   private static final double OHUA_MIN_LENGTH = 0.0;
   
   /**
   * Constructor for making Ohua
   * uses I_a superclass constructor
   * randomly sets length within allowed values after calling constructor.
   * This is the juvenile of the species and has no sex determination.
   */
   public Ohua() {
      super("'Ohua", "Parrotfish", "Scaridae", 
         OHUA_MAX_LENGTH, OHUA_MIN_LENGTH, 0.1, 2.0, DIET_ITEMS, "gray", 
         "reddish gray", "none");    // if "gray' it will false
         //set random allowed length 
      this.initLength();
     
   }

   /**
   * Constructor for making Ohua with a specific length.
   * uses I_a superclass constructor
   * @param length The length of this fish
   * @throws FishSizeException if length > maxLength or < minLength.
   * This is the juvenile of the species and has no sex determination.
   */
   public Ohua(double length) {
      
      super("'Ohua", "Parrotfish", "Scaridae", 
         OHUA_MAX_LENGTH, OHUA_MIN_LENGTH, length, (length * 2), 
         DIET_ITEMS, "gray", "reddish gray", "none");  // if "gray" it will false     
   
   }
    /** 
   * Protected constructor for subclasses.
   *@param name This fish type's Hawaiian name.
   *@param englishName This fish type's English name.
   *@param scientificName This fish type's scientific name.
   *@param maxLength The maximum length this name applies.
   *@param minLength The minimum length this name applies.
   *@param length This fish's length.
   *@param weight This fish's weight
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color of this fish.
   *@param sex The sex of this fish.
   *@throws FishSizeException if length > maxLength or < minLength
   */
   protected Ohua(String name, String englishName, String scientificName, 
         double maxLength, double minLength, 
         double length, double weight, String[] diet, String bodyColor, 
         String finColor, String sex) {
       
      super(name, englishName, scientificName, 
         maxLength, minLength, length, weight, diet, bodyColor, finColor, sex);
   }

   /**
   * Sets the fish's initial length to between its max and min allowed values.
   */
   protected void initLength() {
      Random ran = new Random();
      this.length = this.minLength 
         + (this.maxLength - this.minLength) * ran.nextDouble();
      this.weight = this.length * 2;
   }
   
   /**
   * Sets the fish's length to newLength.
   * @param newLength the new fish length
   * @throws FishSizeException if new length not within min-max length
   */
   public void setLength(double newLength) throws FishSizeException {  
      if (newLength >= this.minLength && newLength < this.maxLength) {
         this.length = newLength;
      } else {
         throw new FishSizeException(this.name + " must be within " 
            + this.minLength + " and " + this.maxLength 
            + " inches long.");
      }   
   
   }
   /**
   * Sets the fish's weight to newWeight.
   * @param newWeight The fish's new weight.
   */
   public void setWeight(double newWeight) {  
      
      this.weight = newWeight;
   
   }

   /**
   * Models eating, should call grow to cause length increases.
   * @param food A String with a potential food name
   * @throws FishFoodException if the food is not the fish's diet
   */
   public void eat(String food) {
     
      boolean isEdible = false;
      //loop through what fish eats and determine if edible
      for (int i = 0; i < DIET_ITEMS.length; i++) {
         if (food.equals(DIET_ITEMS[i])) {
            isEdible = true;
         }
      }
      if (isEdible) {
         this.grow();
      } else {
         throw new FishFoodException(this.name + " does not eat " + food);
      }
   }
 /**
   * Should be used by eat method to increase length of fish. 
   * Should determine a new length and internally call setLength
   * @throws FishSizeException if new length not within min-max length
   *  indicates levelUp needs to be called.
   */
   protected void grow() {
      Random ran = new Random();
      double lengthIncrease = ran.nextDouble() * growthRate;
   
      //calculate a new length by adding a random value between 0 and growthRate
      double newLen = this.length + lengthIncrease;
   
      //check to see if this fish needs to level up
      if (newLen > this.maxLength) {
         throw new FishSizeException("This fish has outgrown its name," 
            + " it must level up!");
      } else {
         this.length = newLen;
         this.weight = 2 * newLen; //rudimentary weight calc
      }
   }
/** returns new Panuhunuhu version of this fish.
   * When Ohua reaches maxLength, it levelUps to Panuhunuhu of minLength
   * min size of next size is always max length of this one
   * @return a new Panuhunuhu
   */
   public Panuhunuhu levelUp() {
   
      return new Panuhunuhu(this.maxLength);
   
   }
   
   /** 
   * changes this Ohua's sex.
   * Ohua cannot change sex. Can only change at levelUp
   * @throws UnsupportedOperationException always
   */
   public void changeSex() {
      throw new UnsupportedOperationException("Ohua does not have sex.");
   
   }
   
   /** 
   * changes this Ohua's color.
   *@param bodyColor This fish body color.
   *@param finColor This fish fin color.
   * Ohua cannot change color. Can only change at levelUp
   * @throws UnsupportedOperationException always
   */
   public void setColor(String bodyColor, String finColor) {
      throw new UnsupportedOperationException("Ohua cannot change color.");   
   }
    /**
   * returns the reproductive mode of this sex changing fish.
   * @return The fish's reproductive mode.
   */
   public String getReproductiveMode() {
      return REPRODUCTIVE_MODE;
   
   
   }
   
//}
 //============= Required by Fishable ==================
 /** 
 * determines if the fish is legal to keep due to length.
 * Baby size handles this for all Moi sizes.
 * Ohua must be 12 inches or more to take. 
 * @return true If this fish is legal size to keep.
 */
   public boolean isLegalSize() {
      if (this.length >= 12) {
         return true;
      } 
      return false;
   }
	       
    /**
    * determines if Ohua can be used as a baitfish.
    * @return false this fish type is not used for bait for other fishing.
    */
   public boolean isBait() {
      return false;
   }
	       
    /**
    * determines if Ohua can be used to eat.
    * @return true if is legal size, false otherwise.
    */
   public boolean isGamefish() {
      if (this.isLegalSize()) {
         return true;
      }
      return false;
   }
   
   /**
   * Ohua season is always open
   * @param month the current month of the year.
   * @return true if fish is okay to take, false otherwise.
   */
   public boolean isInSeason(String month) {
           return true;
   }
	       
    /**
    * Returns the methods of catching this fish.
    * @return an array of fishing methods.
    */
   public String[] getCatchMethods() {
       if (sex != "none") {
         String [] catchMethods = {"throw net", "pole", "spear"};
         return catchMethods;
      } else {
         return null;
      
      }
   }
   
   /**
   * Returns the limit on number of Ohua you're allowed to catch.
   * @return int representing the maximum number of Ohua you are allowed.
   */
   public int getBagLimit() {
      return Integer.MAX_VALUE;
   }   

}
   
  