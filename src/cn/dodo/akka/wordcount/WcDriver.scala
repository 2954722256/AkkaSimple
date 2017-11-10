package cn.dodo.akka.wordcount

import scala.io.Source
import java.util.HashMap
import java.util.ArrayList
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import cn.dodo.akka.wordcount.bean.MapperBean
import cn.dodo.akka.ConfigHelper

object WcDriver {
  def main(args: Array[String]): Unit = {
    //1.读取数据
    val data = Source.fromFile("words2.txt").getLines().toList
    
    //2.准备算法
    val mapFunc = (data:List[String])=>{data.flatMap(_.split(" ")).map((_,1))};
    val reducFunc = (data:List[(String,Int)])=>{data.groupBy(_._1).mapValues(_.map(_._2)).mapValues(_.reduce(_+_))};
    
    //3.将数据和算法封装到bean
    val mif = new MapperBean(data,mapFunc,reducFunc);
    
    //4.将bean发送给WcMapper
    val conf = ConfigHelper.getConf("44444")

		val driverSys = ActorSystem("WcDriverSys",ConfigFactory.parseMap(conf));
    val wcMapperActor = driverSys.actorSelection("akka.tcp://wcMapperSys@127.0.0.1:44443/user/wcMapperActor")
    wcMapperActor ! mif
  }
}