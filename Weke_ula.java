/**
* Weke_ula object class.
* One of two second forms of Oama
* Can be male or female
* The size is 7" to 30"
* @author Justin Kugiyama
* @since 9/22/23
*/
public class Weke_ula extends Oama {
   /** Constant reproductive mode for this fish. */
   static final String REPRODUCTIVE_MODE = "serial";
   
   /** constant maximum length for this Ia.
   * Not inherited
   */
   private static final double WEKEULA_MAX_LENGTH = 30.0;
   
   /** constant minimum length for this Ia.
   * Not inherited
   */
   private static final double WEKEULA_MIN_LENGTH = 7.0;
   
   /**
   * Constructor for making Weke_ula with random length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass
   * randomly sets length within min and max range after calling constructor.
   * Can either be male of female.
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Weke_ula() {
      super("Weke'ula", "Yellowfin Goatfish", "Mulloidichthys vanicolensis",
         WEKEULA_MAX_LENGTH, WEKEULA_MIN_LENGTH, WEKEULA_MIN_LENGTH, (WEKEULA_MIN_LENGTH * 2),
         DIET_ITEMS, "white with yellow stripe", "yellow", "male or female");
      this.inLength();
      this.inSex();
   }
   
   /**
   * Constructor for making Weke_ula with random length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass
   * randomly sets length within min and max range after calling constructor.
   * Can either be male of female.
   * @param bodyColor the fish's body color
   * @param finColor the fish's body color
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Weke_ula(String bodyColor, String finColor) {
      super("Weke'ula", "Yellowfin Goatfish", "Mulloidichthys vanicolensis",
         WEKEULA_MAX_LENGTH, WEKEULA_MIN_LENGTH, WEKEULA_MIN_LENGTH, (WEKEULA_MIN_LENGTH * 2),
         DIET_ITEMS, bodyColor, finColor, "male or female");
      this.inLength();
      this.inSex();
      this.inColor();
   }
   
   
   /**
   * Constructor for making Weke_ula with a given length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass.
   * Can either be male of female.
   * @param length the fish's length
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Weke_ula(double length) {
      super("Weke'ula", "Yellowfin Goatfish", "Mulloidichthys vanicolensis",
         WEKEULA_MAX_LENGTH, WEKEULA_MIN_LENGTH, length, (length * 2), DIET_ITEMS, 
         "white with yellow stripe", "yellow", "male or female");
      this.inSex();
   }
   
   /**
   * Constructor for making Weke_ula with a given length
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from superclass.
   * Can either be male of female.
   * @param length the fish's length
   * @param bodyColor the fish's body color
   * @param finColor the fish's body color
   * @throws FishSizeException if length > maxLength or length < minLength
   */
   public Weke_ula(double length, String bodyColor, String finColor) {
      super("Weke'ula", "Yellowfin Goatfish", "Mulloidichthys vanicolensis",
         WEKEULA_MAX_LENGTH, WEKEULA_MIN_LENGTH, length, (length * 2), DIET_ITEMS, 
         bodyColor, finColor, "male or female");
      this.inSex();
      this.inColor();
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
   protected Weke_ula(String name, String englishName, String scientificName, 
         double maxLength, double minLength, double length, double weight, 
         String[] diet, String bodyColor, String finColor, String sex) {
      
      super(name, englishName, scientificName, maxLength, minLength, length,
         weight, diet, bodyColor, finColor, sex);
   }
      
   
   /** 
   * This fish doesn't level up.
   * @return this, this fish
   */
   public Weke_ula levelUp() {
      return this;
   }

}