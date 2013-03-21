// No semicolons
import scala.beans.BeanProperty
// Wild card include
import java.util._

// Class definition is a constructor
class Airplane(title:String) {
  // Variable that can change
  var seats = null
  // Value is final and cannot change
  val wingspan = 42
  // Type safety
  val length:Int = 50 
  // Generics are [] instead of <>
  var foodChoices:List[String] = new ArrayList[String]
  // Provides getter and setter	
  @BeanProperty
  var description = title.toUpperCase()
  
  // Public method
  def destination = {
    try {
    	// Call method without () when no parameters
    	land
    }
    catch {
      // Exceptions are case statements
      case npe:NullPointerException => "oh well"
    }
  }
  // Private method with parameter and return type
  private def fly(direction:String) :Boolean = {
	// No need for 'return' keyword
    true
  }
  // Protected method without parameters and return type
  protected def land :String = {
    "Baltimore"
  }
}

// Traits are like an interface
trait AirplaneInterface {
  def canFly :Boolean
  def canLand :Boolean
} 

// Objects are a singleton with all static methods
object AirplaneInstance {
    def main(args: Array[String]) {
        var airplane = new Airplane("Boeing 747")
        // Multiline strings use triple quotes
        var description = """This is a
          a long paragraph
          of text."""
        airplane.setDescription(description)
        val propJet = new PropJet
        propJet.show(null)
    }
}

// Case allows pattern matching on classes in switch statements i.e. :Seat =>
case class Seat(tray: TrayTable, belt: SeatBelt)
abstract class SeatAttribute
case class TrayTable(cupholder: Boolean) extends SeatAttribute
case class SeatBelt(length: Integer) extends SeatAttribute

// Extending a class with parameter and with Trait
class PropJet extends Airplane("Private") with AirplaneInterface {
    def canFly = { true }
    def canLand = { true }
    def show(args: Array[String]) {
      // Case classes do not require 'new' keyword
      val propSeat = Seat(TrayTable(true), SeatBelt(42))
      // No need for System.println
      println("Running...")
      val what = "life"
      // Embedded string interpolation if prefix with 's'
      println(s"The secret to $what is ${propSeat.belt.length}")
    }
}