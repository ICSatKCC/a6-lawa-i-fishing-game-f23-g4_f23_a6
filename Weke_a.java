/**
* Weke_a object class.
* One of two second forms of Oama
* Can be male or female
* The size is 7" to 30"
* @author Justin Kugiyama
* @since 9/22/23
*/
public class Weke_a extends Oama {
   /** Constant reproductive mode for this fish. */
   static final String REPRODUCTIVE_MODE = "serial";
   
   /** constant maximum length for this Ia.
   * Not inherited
   */
   private static final double WEKEA_MAX_LENGTH = 30.0;
   
   /** constant minimum length for this Ia.
   * Not inherited
   */
   private static final double WEKEA_MIN_LENGTH = 7.0;
   
   /**
   * Constructor for making Weke_a with random length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass
   * randomly sets length within min and max range after calling constructor.
   * Can either be male of female.
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Weke_a() {
      super("Weke'a", "Square-spot Goatfish", "Mulloidichthys flavolineatus",
         WEKEA_MAX_LENGTH, WEKEA_MIN_LENGTH, WEKEA_MIN_LENGTH, (WEKEA_MIN_LENGTH * 2),
         DIET_ITEMS, "white with yellow stripe and black spot", "white", "male or female");
      this.inLength();
      this.inSex();
   }   

   
   /**
   * Constructor for making Weke_a with a given length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass.
   * Can either be male or female.
   * @param length the fish's length
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Weke_a(double length) {
      super("Weke'a", "Square-spot Goatfish", "Mulloidichthys flavolineatus",
         WEKEA_MAX_LENGTH, WEKEA_MIN_LENGTH, length, (length * 2), DIET_ITEMS, 
         "white with yellow stripe and black spot", "white", "male or female");
      this.inSex();
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
   protected Weke_a(String name, String englishName, String scientificName, 
         double maxLength, double minLength, double length, double weight, 
         String[] diet, String bodyColor, String finColor, String sex) {
      
      super(name, englishName, scientificName, maxLength, minLength, length,
         weight, diet, bodyColor, finColor, sex);
   }
   
   /**
   * This fish doesn't level up.
   * @return this, this fish.
   */
   public Weke_a levelUp() {
      return this;
   }
     public void setColor(String bodyColor, String finColor) {
      this.bodyColor = bodyColor;
      this.finColor = finColor;

   }
}