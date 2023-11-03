import java.util.Random;

/**
* 'Ama'ama family.
* Smallest fish of 'Ama'ama family
* @author Justin Kugiyama
* @since 10/1/2023
*/
public class Pua_ama extends I_a {
   // Constants for 'Ama'ama family.
   /** Constant reproductive mode for this fish. */
   static final String REPRODUCTIVE_MODE = "protoandrous";
   
   /** Food 'Ama'ama family eats. */
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
