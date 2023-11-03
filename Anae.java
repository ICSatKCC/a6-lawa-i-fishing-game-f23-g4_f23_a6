/** 
* Anae object class.
* Fourth and final form of Ama_ama family
* can be male or female
* The size is between 12" and 27"
* @author Justin Kugiyama
* @since 10/1/2023
*/
public class Anae extends Ama_ama {
   /** Constant reproductive mode for this fish. */
   private static final String REPRODUCTIVE_MODE = "serial";
   
   /** Constant max length for this Ia.
   * Not inherited
   */
   private static final double ANAE_MAX_LENGTH = 27.0;
   
   /** Constant min length for this Ia.
   * Not inherited
   */
   private static final double ANAE_MIN_LENGTH = 12.0;
   
   /**
   * Constructor for making Anae with a given length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass.
   * Can either be male or female.
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Anae() {
      super("'Anae", ANAE_MAX_LENGTH, ANAE_MIN_LENGTH, ANAE_MIN_LENGTH, (ANAE_MIN_LENGTH * 2), 
         DIET_ITEMS, "silver", "silver", "male or female");
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
   public Anae(String sex) {
      super("'Anae", ANAE_MAX_LENGTH, ANAE_MIN_LENGTH, ANAE_MIN_LENGTH, (ANAE_MIN_LENGTH * 2), 
         DIET_ITEMS, "silver", "silver", sex);
      this.inLength();
   }
   
   /**
   * Constructor for making Anae with a given length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass.
   * Can either be male or female.
   * @param length the fish's length
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Anae(double length) {
      super("'Anae", ANAE_MAX_LENGTH, ANAE_MIN_LENGTH, length, (length * 2), 
         DIET_ITEMS, "silver", "silver", "male or female");
      this.inSex();
   }
   
   /**
   * Constructor for making Anae with a given length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass.
   * Can either be male or female.
   * @param length the fish's length
   * @param sex the fish's sex
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Anae(double length, String sex) {
      super("'Anae", ANAE_MAX_LENGTH, ANAE_MIN_LENGTH, length, (length * 2), 
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
   protected Anae(String name, double maxLength, double minLength, double length, 
         double weight, String[] diet, String bodyColor, String finColor, String sex) {
      
      super(name, maxLength, minLength, length, weight, diet, bodyColor, finColor, sex);
   }
   
   
   /** returns new Anae again.
   * This fish doesn't level up
   * @return Anae
   */
   public Anae levelUp() {
      return this;
   }
      
}