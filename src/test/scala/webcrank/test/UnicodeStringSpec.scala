package webcrank.test

import scalaz.scalacheck.ScalazProperties._
import org.scalacheck.Prop.forAll

object UnicodeStringSpec extends Spec {
  "UnicodeArbitrary" should {
    "satisfy equals laws" ! equal.laws[UnicodeString]

    "satisfy order laws" ! order.laws[UnicodeString]

    "symmetric getBytes/new String" ! prop((u: UnicodeString) =>
      UnicodeString(new String(u.value.getBytes("UTF-8"), "UTF-8")) == u)

    "Character.isDefined" ! prop((u: UnicodeString) =>
      u.value.toList.forall(Character.isDefined))
  }
}
