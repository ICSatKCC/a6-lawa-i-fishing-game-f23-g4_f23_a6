/** 
* Kahaha object class.
* Third form of Ama_ama family
* can be male or female
* The size is between 8" and 12"
* @author Justin Kugiyama
* @since 10/1/2023
*/
public class Ama_ama extends Kahaha {
   /** Constant reproductive mode for this fish. */
   private static final String REPRODUCTIVE_MODE = "serial";

   /** Constant max length for this Ia.
   * Not inherited
   */
   private static final double AMAAMA_MAX_LENGTH = 12.0;
   
   /** Constant min length for this Ia.
   * Not inherited
   */
   private static final double AMAAMA_MIN_LENGTH = 8.0;
   
   
   /**
   * Constructor for making Anae with a random length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass.
   * Can either be male or female.
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Ama_ama() {
      super("'Ama'ama", AMAAMA_MAX_LENGTH, AMAAMA_MIN_LENGTH, AMAAMA_MIN_LENGTH, 
         (AMAAMA_MIN_LENGTH * 2), DIET_ITEMS, "silver", "silver", "male or female");
      this.inLength();
      this.inSex();
   }
   
   /**
   * Constructor for making Anae with a given length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass.
   * Can either be male or female.
   * @param sex the fish's sex
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Ama_ama(String sex) {
      super("'Ama'ama", AMAAMA_MAX_LENGTH, AMAAMA_MIN_LENGTH, AMAAMA_MIN_LENGTH, 
         (AMAAMA_MIN_LENGTH * 2), DIET_ITEMS, "silver", "silver", sex);
      this.inLength();
   }
   
   /**
   * Constructor for making Ama_ama with a given length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass.
   * Can either be male or female.
   * @param length the fish's length
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Ama_ama(double length) {
      super("'Ama'ama", AMAAMA_MAX_LENGTH, AMAAMA_MIN_LENGTH, length, (length * 2), 
         DIET_ITEMS, "silver", "silver", "male or female");
      this.inSex();
   }
   
 /**
   * Constructor for making Ama_ama with a given length and sex
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass.
   * Can either be male or female.
   * @param length the fish's length
   * @param sex the fish's sex
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Ama_ama(double length, String sex) {
      super("'Ama'ama", AMAAMA_MAX_LENGTH, AMAAMA_MIN_LENGTH, length, (length * 2), 
         DIET_ITEMS, "silver", "silver", sex);
   }
  

   
   /**
   * Protected constructor for subclasses.
   * Passes subclass specific variables to 
   * I_a superclass constructor.
   *
   * english and scientific names remain the same throughout the family
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
   protected Ama_ama(String name, double maxLength, double minLength, double length, 
         double weight, String[] diet, String bodyColor, String finColor, String sex) {
      
      super(name, maxLength, minLength, length, weight, diet, bodyColor, finColor, sex);
   }
   
   
   /** returns new Anae version of this fish.
   * When Ama_ama reaches maxLength, it levels up to Anae
   * min size of next fish is always the max length of this one
   * @return Anae
   */
   public Anae levelUp() {
      return new Anae(this.maxLength, this.sex);
   }
      
}