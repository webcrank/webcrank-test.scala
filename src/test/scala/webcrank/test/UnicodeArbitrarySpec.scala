package webcrank.test

import org.scalacheck.Prop.forAll

object UnicodeArbitrarySpec extends Spec {
  import UnicodeArbitrary._

  "UnicodeArbitrary" should {
    "symmetric getBytes/new String" ! forAll(genUnicodeString)(s =>
      new String(s.getBytes("UTF-8"), "UTF-8") == s)

    "Character.isDefined" ! forAll(genUnicodeString)(s =>
      s.toList.forall(Character.isDefined))
  }
}
