import org.scalacheck.{Gen, Arbitrary, Properties}
import org.scalacheck.Prop.forAll

object StringSpecification extends Properties("String") {
  //val evenInteger = Gen.containerOf[List,Int](Gen.oneOf(1, 3, 5)) suchThat(_.foldLeft(_ != _))
  //property("startsWith") = forAll {

}