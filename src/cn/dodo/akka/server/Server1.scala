package cn.dodo.akka.server

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props
import cn.dodo.akka.ConfigHelper

object Server1 {
  def main(args: Array[String]): Unit = {
    //服务， 简单配置对应， 端口 44444
    val conf = ConfigHelper.getConf("44444")
    //对应服务的名字，叫  myAkkaServerSys
    val sys = ActorSystem("myAkkaServerSys", ConfigFactory.parseMap(conf));
//    val actor = 
      sys.actorOf(Props[Actor00], "actServer")
//    actor ! "aaa"
  }
}