package Main

/**
  * Created by Torridon on 11/5/2015 for Dungeon Generator
  */
object Implicits {
  import scala.Predef.{tuple2ToZippedOps => _}
  def Π[A](f:A=>A,start:A,end:A)(implicit numa:Numeric[A]): A ={
    if(numa.lteq(numa.minus(end,start), numa.zero)){
      numa.one
    }else{
      numa.times(f(start), Π(f,numa.plus(start, numa.one),end))
    }
  }
  def Σ[A](f:A=>A,start:A,end:A)(implicit numa:Numeric[A]): A ={
    if(numa.lteq(numa.minus(end,start), numa.zero)){
      numa.zero
    }else{
      numa.plus(f(start), Σ(f,numa.plus(start, numa.one),end))
    }
  }
  def Π[A](l:List[A])(implicit num:Numeric[A]):A = if(l == null){num.one}else{num.times(l.head, Π(l.tail))}
  def Σ[A](l:List[A])(implicit num:Numeric[A]):A = if(l == null){num.zero}else{num.times(l.head, Σ(l.tail))}

  def ¬(b:Boolean) = !b

  implicit class Super3Tuple[A, B, C](t: (A, B, C)) {
    def +(that: (A, B, C))(implicit numa: Numeric[A], numb: Numeric[B], numc: Numeric[C]) = {
      (numa.plus(t._1, that._1), numb.plus(t.y, that.y), numc.plus(t.z, that.z))
    }

    def y:B = t._2

    def z:C = t._3

    def -(that: (A, B, C))(implicit numa: Numeric[A], numb: Numeric[B], numc: Numeric[C]) = {
      (numa.minus(t._1, that._1), numb.minus(t.y, that.y), numc.minus(t.z, that.z))
    }
    def *(that: (A,B,C))(implicit numa: Numeric[A], numb: Numeric[B], numc: Numeric[C]) = {
      (numa.times(t._1, that._1), numb.times(t.y, that.y), numc.times(t.z, that.z))
    }
  }
  implicit class Super2Tuple[A, B](t:(A,B)){
    def +(that: (A, B))(implicit numa: Numeric[A], numb: Numeric[B]) = {
      (numa.plus(t._1, that._1), numb.plus(t.y, that.y))
    }

    def -(that: (A, B))(implicit numa: Numeric[A], numb: Numeric[B]) = {
      (numa.minus(t._1, that._1), numb.minus(t.y, that.y))
    }

    def y: B = t._2

    def *(that: (A,B))(implicit numa: Numeric[A], numb: Numeric[B]) = {
      (numa.times(t._1, that._1), numb.times(t.y, that.y))
    }
  }
  implicit class SuperList[A](t:List[A]){
    def --(that:List[A]):List[A] ={
      def remove(dis:List[A], dat:List[A]):List[A] = {
        if(dis == null){null}else if(dis.head ∈ dat){
          remove(dis.tail,dat)
        }else{
          List(dis.head) ∪ remove(dis.tail,dat)
        }
      }
      remove(t,that)
    }

    def ∩(that: List[A]): List[A] = {
      def intersect(dis: List[A], dat: List[A]): List[A] = {
        if (dis == null) {
          null
        } else if (¬(dis.head ∈ dat)) {
          intersect(dis.tail, dat)
        } else {
          List(dis.head) ∪ intersect(dis.tail, dat)
        }
      }
      intersect(t, that)
    }

    def ∪(that:List[A]):List[A] = {
      t.filter(a=> a ∉ that) ++ that
    }

    def ⊆(that: List[A]) = (t ⊂ that) ∨ (t == that)

    def ⊂(that:List[A]):Boolean = {
      var truth = 0
      t.foreach(a => if(!that.contains(a)){
        truth += 1
      })
      (truth == 0) ∧ (t != that)
    }
  }
  implicit class SuperAny[A](a:A){
    def ∉(that:List[A]) = !(a ∈ that)

    def ∈(that: List[A]) = that.contains(a)
  }
  implicit class SuperBool(a:Boolean){
    def ∧(b:Boolean) = a && b
    def ∨(b:Boolean) = a || b
  }
}
