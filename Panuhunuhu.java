import java.util.Random;
/**
* Panuhunuhu object class.
* This is the second phase of Ohua life
* @author Yongjun Yu
* @since 9/23/23
*/
public class Panuhunuhu extends Ohua {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia. */
   private static final double PANUHUNUHUMAXLENGTH = 12.0;
   /** constant minimum length for this Ia. */
   private static final double PANUHUNUHUMINLENGTH = 4.0;
   

   /**
   * Constructor for making Panuhunuhu with random length 
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the second phase of the species and is always male.
   * @throws FishSizeException if length is > maxLength or < minLength
   * Must send minLength  through as a temp length or throws exception
   */
   public Panuhunuhu() {
      super("Panuhunuhu", "Parrotfish", "Scaridae", PANUHUNUHUMAXLENGTH, PANUHUNUHUMINLENGTH, 
         PANUHUNUHUMINLENGTH, (PANUHUNUHUMINLENGTH * 2), DIET_ITEMS, "gray", 
         "reddish gray", "s"); 
      //set random length and sex
      this.initLength(); 
      this.initSex();
   }
 /**
   * Constructor for making Panuhunuhu with a given length 
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the second phase of the species and is always male.
   * @param length the length for this fish
   * @throws FishSizeException if length > maxLength or < minLength
   */
   public Panuhunuhu(double length) {
      super("Panuhunuhu", "Parrotfish", "Scaridae", PANUHUNUHUMAXLENGTH, PANUHUNUHUMINLENGTH, 
         length, (length * 2), DIET_ITEMS, "gray", 
         "reddish gray", "s"); 
      this.initSex(); 
   }

  /** 
   * Protected constructor for subclasses.
   * This allows subclass specific variables  
   * to pass through to I'a superclass constructor.
   * In this species, the English and scientific names
   * remain the same throughout so not needed to pass from subclasses.
   *@param name This fish type's Hawaiian name.
   *@param englishName This fish type's English name.
   *@param scientificName This fish type's scientific name.
   *@param maxLength The maximum length this name applies.
   *@param minLength The minimum length this name applies.
   *@param length This fish's size.
   *@param weight This fish's weight.
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color of this fish.
   *@param sex The sex of this fish.
   *@throws FishSizeException if length > maxLength or < minLength
   */
   protected Panuhunuhu(String name, String englishName, String scientificName, 
         double maxLength, double minLength, 
         double length, double weight, String[] diet, String bodyColor, 
         String finColor, String sex) {
       
      super(name, englishName, scientificName, maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, sex);
   }
   /**.
   * Sets the fish's sex 
   */

   public void initSex() {
      Random ran = new Random();
      int filp = ran.nextInt(2);
      
      if (filp == 0) {
         this.sex = "male";  
      } else {
         this.sex = "female";
      }
   
   }
 /** returns new Uhu version of this fish.
   * When Panuhunuhu reaches maxLength, it should levelUp to Uhu min size
   * min size of next size is always max size of this one
   * @return a new Uhu
   */
   public Uhu levelUp() {
   
      return new Uhu(this.maxLength);
   
   }
}
   
