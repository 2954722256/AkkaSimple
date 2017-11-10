package cn.dodo.akka.wordcount.bean

class MapperBean (data:List[String],mapFunc:(List[String])=>List[(String,Int)],reduceFunc:(List[(String,Int)])=>Map[String,Int]) extends Serializable {
  val datax = data;
  val mapFuncx = mapFunc;
  val reduceFuncx = reduceFunc;
}