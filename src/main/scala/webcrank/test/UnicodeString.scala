package webcrank.test

import scalaz._, Scalaz._
import org.scalacheck.Arbitrary

/** New type wrapper and corresponding arbitrary for UnicodeArbitrary.genUnicodeString */
case class UnicodeString(value: String)

object UnicodeString {
  import UnicodeArbitrary._

  implicit val UnicodeStringShow  =
    Show.showFromToString[UnicodeString]

  implicit val UnicodeStringEqual =
    Equal.equalA[UnicodeString]

  implicit val UnicodeStringOrder =
    Order.orderBy[UnicodeString, String](_.value)

  implicit def UnicodeStringArbitrary: Arbitrary[UnicodeString] =
    Arbitrary(genUnicodeString map UnicodeString.apply)
}
