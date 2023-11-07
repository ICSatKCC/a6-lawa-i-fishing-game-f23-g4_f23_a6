import java.util.Random;

/**
* 'Pua'ama family.
* Smallest fish of 'Pua'ama family
* @author Justin Kugiyama
* @since 10/1/2023
*/
public class Pua_ama extends FishableI_a {
   // Constants for 'Pua'ama family.
   /** Constant reproductive mode for this fish. */
   static final String REPRODUCTIVE_MODE = "protoandrous";
   
   /** Food 'Pua'ama family eats. */
   protected static final String [] DIET_ITEMS = {"zooplankton", "algae",
      "detritus", "invertebrates"};
   
   /** Max length for Pua'ama.
   * not inherited
   */
   private static final double PUAAMA_MAX_LENGTH = 4.0;
   
   /** Min length for Pua'ama.
   * not inherited
   */
   private static final double PUAAMA_MIN_LENGTH = 0.01;
   
   /**
   * Constructor for making Pua'ama
   * extends I_a superclass
   * randomly sets length within the parameters.
   * No sex determination.
   */
   public Pua_ama() {
      super("Pua'ama", "Striped Mullet", "Mugil Cephalus", PUAAMA_MAX_LENGTH, PUAAMA_MIN_LENGTH,
         0.01, 2.0, DIET_ITEMS, "silver", "silver", "none");
      //randomly sets length
      this.inLength();
   }
   
   /**
   * Constructor for making Pua'ama with a set length.
   * extends I_a superclass
   * @param length the Pua'ama'slength.
   * No sex determination.
   */
   public Pua_ama(double length) {
      super("Pua'ama", "Striped Mullet", "Mugil Cephalus", PUAAMA_MAX_LENGTH, PUAAMA_MIN_LENGTH,
         length, (length * 2), DIET_ITEMS, "silver", "silver", "none");
      //randomly sets length
      this.inLength();
   }
   
   /**
   * Protected constructor for subclasses.
   * Passes subclass specific variables to 
   * I_a superclass constructor.
   *
   * english and scientific name remain the same throughout the family
   * 
   * @param name The fish's Hawaiian name.
   * @param maxLength The max length the fish can be.
   * @param minLength min length the fish can be.
   * @param length The fish's length.
   * @param weight The fish's weight.
   * @param diet The fish's diet.
   * @param bodyColor The fish's body color.
   * @param finColor The fish's fin color.
   * @param sex The fish's sex.
   * @throws FishSizeException if length > maxLength or length < minLength.
   */
   protected Pua_ama(String name, double maxLength, double minLength, double length, 
         double weight, String[] diet, String bodyColor, String finColor, String sex) {
      
      super(name, "Striped Mullet", "Mugil Cephalus", maxLength, minLength, length,
         weight, diet, bodyColor, finColor, sex);
   }
   
   /**
   * Randomly sets the fish's length between it's min and max parameters.
   */
   protected void inLength() {
      Random ranGen = new Random();
      this.length = this.minLength 
         + (this.maxLength - this.minLength) * ranGen.nextDouble();
      this.weight = this.length * 2;
   }
   
   /**
   * Randomly sets the sex of Kahaha.
   */
   protected void inSex() {
      Random ran = new Random();
      int ranGen = ran.nextInt(2);
      if (ranGen == 1) {
         this.sex = "male";
      } else {
         this.sex = "female";
      }
   }
   
   /**
   * Sets fish's length to newLength.
   * @param newLength the fish's new length
   * @throws FishSizeException if new length is not within the min and max range
   */
   public void setLength(double newLength) throws FishSizeException {
      if (newLength >= minLength && newLength < maxLength) {
         this.length = newLength;
      } else {
         throw new FishSizeException(this.name + " must be within "
               + this.minLength + " and " + this.maxLength
               + " inches long.");
      }
   }
   
   /**
   * Sets fish's weight to newWeight.
   * @param newWeight the fish's new weight.
   */
   public void setWeight(double newWeight) {
      this.weight = newWeight;
   }  
   
   /**
   * Models eating, cause the fish to grow in length.
   * @param food A string with a potential food name
   * @throws FishFoodException if the food isn't in the fish's diet
   */
   public void eat(String food) {
      boolean isEdible = false;
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
   * Should be used by eat method to increase the fish's length.
   * Should determine new length and internally call setLength
   * @throws FishSizeException if length is not within the min and max range
   * indicates levelUp to be called.
   */
   protected void grow() {
      Random ranGen = new Random();
      double lengthIncrease = ranGen.nextDouble() * growthRate;
      
      double newLen = this.length + lengthIncrease;
      
      if (newLen > this.maxLength) {
         throw new FishSizeException("This fish has outgrown it's name,"
            + " it must level up!");
      } else {
         this.length = newLen;
         this.weight = newLen * 2;
      }
   }
   
   
   //============= Required by Fishable ==================
 /** 
 * determines if the fish is legal to keep due to length.
 * Baby size handles this for all Pua'ama sizes.
 * Pua'ama must be 11 inches or more to take. 
 * @return true If this fish is legal size to keep.
 */
   public boolean isLegalSize() {
      if (this.length >= 11) {
         return true;
      } 
      return false;
   }
	       
    /**
    * determines if Pua'ama can be used as a baitfish.
    * @return false this fish type is not used for bait for other fishing.
    */
   public boolean isBait() {
      return false;
   }
	       
    /**
    * determines if Pua'ama can be used to eat.
    * @return true if is legal size, false otherwise.
    */
   public boolean isGamefish() {
      if (this.isLegalSize()) {
         return true;
      }
      return false;
   }
   
   /**
   * Pua'ama season is April - November. No catching December - March
   * @param month the current month of the year.
   * @return true if fish is okay to take, false otherwise.
   */
   public boolean isInSeason(String month) {
      month = month.toLowerCase();
      boolean isOk = true;
      
      switch(month) {
         case "december":
         case "january":
         case "february":
         case "march":
            isOk = false;
            break;
         default:
            isOk = true;
            break;
      }
      return isOk;
   }
	       
    /**
    * Returns the methods of catching this fish.
    * @return an array of fishing methods.
    */
   public String[] getCatchMethods() {
      if (sex != "none") {
         String [] catchMethods = {"net", "pole"};
         return catchMethods;
      } else {
         return null;
      
      }
         
   }
   
   /**
   * Returns the limit on number of Pua'ama you're allowed to catch.
   * @return int representing the maximum number of Pua'ama you are allowed.
   */
   public int getBagLimit() {
      return Integer.MAX_VALUE;
   }
   
   /**
   * Returns new Kahaha version of this fish.
   * When Pua_ama reaches maxLength, it levels up to Kahaha
   * min size of next fish is always the max size of this fish
   * @return Kahaha
   */
   public Kahaha levelUp() {
      return new Kahaha(this.maxLength);
   }

}
