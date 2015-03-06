package examples

import org.scalacheck.{Arbitrary, Gen}
import org.specs2._
import scalaz.syntax.bind._

class HelloSpecs2Spec extends Specification with ScalaCheck {
  //Example from page http://etorreborre.github.io/specs2/guide/SPECS2-3.0/org.specs2.guide.UseScalaCheck.html#arbitrary-instances
  def is = s2"""
  a simple property       $ex1
  a more complex property $ex2
"""

  def abStringGen = (Gen.oneOf("a", "b") |@| Gen.oneOf("a", "b"))(_ + _)

  implicit def abStrings: Arbitrary[String] =
    Arbitrary(abStringGen)

  def ex1 = prop((s: String) => s must contain("a") or contain("b")).setArbitrary(abStrings)

  // use the setArbitrary<n> method for the nth argument
  def ex2 = prop((s1: String, s2: String) => (s1 + s2) must contain("a") or contain("b")).
    setArbitrary1(abStrings).setArbitrary2(abStrings)

}