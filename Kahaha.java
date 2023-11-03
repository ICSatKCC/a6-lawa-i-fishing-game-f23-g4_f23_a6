/** 
* Kahaha object class.
* Second form of Ama_ama family
* can be male or female
* The size is between 4" and 8"
* @author Justin Kugiyama
* @since 10/1/2023
*/
public class Kahaha extends Pua_ama {
   /** Constant reproductive mode for this fish. */
   private static final String REPRODUCTIVE_MODE = "serial";
   
   /** Constant max length for this Ia.
   * Not inherited
   */
   private static final double KAHAHA_MAX_LENGTH = 8.0;
   
   /** Constant min length for this Ia.
   * Not inherited
   */
   private static final double KAHAHA_MIN_LENGTH = 4.0;
   
   /**
   * Constructor for making Kahaha with random length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass
   * randomly sets length within min and max range after calling constructor.
   * Can either be male of female.
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Kahaha() {
      super("Kahaha", KAHAHA_MAX_LENGTH, KAHAHA_MIN_LENGTH, KAHAHA_MIN_LENGTH, 
         (KAHAHA_MIN_LENGTH * 2), DIET_ITEMS, "silver", "silver", "male or female");
      this.inLength();
      this.inSex();
   }   

   
   /**
   * Constructor for making Kahaha with a given length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass.
   * Can either be male or female.
   * @param length the fish's length
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Kahaha(double length) {
      super("Kahaha", KAHAHA_MAX_LENGTH, KAHAHA_MIN_LENGTH, length, (length * 2), 
         DIET_ITEMS, "silver", "silver", "male or female");
      this.inSex();
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
   protected Kahaha(String name, double maxLength, double minLength, double length, 
         double weight, String[] diet, String bodyColor, String finColor, String sex) {
      
      super(name, maxLength, minLength, length, weight, diet, bodyColor, finColor, sex);
   }
   
   
   /** returns new Ama_ama version of this fish.
   * When Kahaha reaches maxLength, it levels up to Ama_ama
   * min size of next fish is always the max length of this one
   * @return Ama_ama
   */
   public Ama_ama levelUp() {
      return new Ama_ama(this.maxLength, this.sex);
   }
      
}