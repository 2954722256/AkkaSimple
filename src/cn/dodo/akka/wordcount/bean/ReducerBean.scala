package cn.dodo.akka.wordcount.bean

class ReducerBean(data: List[(String, Int)], reduceFunc: (List[(String, Int)]) => Map[String, Int]) extends Serializable {
  val datax = data;
  val reduceFuncx = reduceFunc
}