import java.util.Random;

/**
* Weke family.
* Smallest version fish of Weke
* @author Justin Kugiyama
* @since 9/21/23
*/
public class Oama extends I_a implements ColorChangeable {
   // Constants for 'Oama
   /** Constant reproductive mode for this fish. */
   static final String REPRODUCTIVE_MODE = "serial";
   
   /** Food that Oamas eat. */
   protected static final String [] DIET_ITEMS = {"worms", "mollusks", "invertebrates"};
   
   /** Max length for 'Oama.
   * not inherited
   */
   private static final double OAMA_MAX_LENGTH = 7.0;
   
   /** Min length for 'Oama.
   * not inherited
   */
   private static final double OAMA_MIN_LENGTH = 0.01;
   
   /**
   * Constructor for making 'Oama
   * extends I_a superclass
   * randomly sets length within the parameters.
   * No sex determination.
   */
   public Oama() {
      super("'Oama", "Goatfish", "Mulloidichthys", OAMA_MAX_LENGTH,
         OAMA_MIN_LENGTH, 0.01, 2.0, DIET_ITEMS, "white with yellow stripe",
         "yellow or white", "none");
      // randomly set length
      this.inLength();
      this.inFinColor();
   }
   
   /**
   * Constructor for making 'Oama with set length.
   * extends I_a superclass
   * @param length the 'Oama's set length
   * @throws FishSizeException if length is outside of the parameters.
   * No sex determination.
   */
   public Oama(double length) {
      super("'Oama", "Goatfish", "Mulloidichthys", OAMA_MAX_LENGTH,
         OAMA_MIN_LENGTH, length, (length * 2), DIET_ITEMS, "white with yellow stripe",
         "yellow or white", "none");
      this.inFinColor();
   }
   
   /**
   * Protected constructor for subclasses.
   * Passes subclass specific variables to 
   * I_a superclass constructor.
   * 
   * @param name The fish's Hawaiian name.
   * @param englishName The fish's english name.
   * @param scientificName The fish's scientific name.
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
   protected Oama(String name, String englishName, String scientificName, 
         double maxLength, double minLength, double length, double weight, 
         String[] diet, String bodyColor, String finColor, String sex) {
      
      super(name, englishName, scientificName, maxLength, minLength, length,
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
   * Randomly sets fin color for Oama.
   */
   public void inFinColor() {
      Random ran = new Random();
      int ranGen = ran.nextInt(2);
      if (ranGen == 1) {
         this.finColor = "white";
      } else {
         this.finColor = "yellow";
      }
   }
   
   /**
   * Randomly sets the sex of a fish if applicable.
   */
   public void inSex() {
      Random ran = new Random();
      int ranGen = ran.nextInt(2);
      if (ranGen == 1) {
         this.sex = "male";
      } else {
         this.sex = "female";
      }
   }
   
   /**
   * Randomly sets the body color and fin color of Weke_ula.
   */
   public void inColor() {
      Random ran = new Random();
      int ranGen = ran.nextInt(2);
      if (ranGen == 1) {
         this.bodyColor = "white with yellow stripe";
         this.finColor = "yellow";
      } else {
         this.bodyColor = "red";
         this.finColor = "red";
      }
   }
         
   
   /** returns new Weke_a (depending on color) version of this fish.
   * when Oama reaches maxLength, it levels up to Weke_a or Weke_ula
   * min size of next fish is always the max length of this one
   * @return Weke_a
   */
   public Oama levelUp() {
      switch(finColor) {
         case "white":
            return new Weke_a(this.maxLength);
         case "yellow":
            return new Weke_ula(this.maxLength);
         default:
            System.out.println("Fish could not be identified");
      }
      return new Oama(this.maxLength);
   }
   
   

   //******* required by the ColorChangeable interface ******
   
   
   /**
   * changes the Oama's color.
   * Oama cannot change color. Can only change at levelUp
   * @param bodyColor the fish's new body color
   * @param finColor the fish's new fin color
   * @throws UnsupportedOperationExchange always
   */
   public void setColor(String bodyColor, String finColor) {
      this.bodyColor = bodyColor;
      this.finColor = finColor;
   }
}  