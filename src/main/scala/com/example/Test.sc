object Test {
  val seq = Seq(Seq(1,2,3),Seq(1,2,3))
  seq.tail.foldLeft((seq.head,true))((a,b)=>(b,a._1!=b && a._2))._2
  def get[A](list: List[A], idx: Int): A =
    list.tail.foldLeft((list.head,0)) {
      (r,c) => if (r._2 == idx) r else (c,r._2+1)
    } match {
      case (result, index) if (idx == index) => result
      case _ => throw new Exception("Bad index")
    }
  //get(seq.toList,2)
seq.flatten
}