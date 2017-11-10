package cn.dodo.akka.server

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import cn.dodo.akka.server.bean.Person
import cn.dodo.akka.ConfigHelper

object Server2 {
  def main(args: Array[String]): Unit = {
    val conf = ConfigHelper.getConf("44443")

		val clientSys = ActorSystem("myAkkaClientSys",ConfigFactory.parseMap(conf));
    val actServer = clientSys.actorSelection("akka.tcp://myAkkaServerSys@127.0.0.1:44444/user/actServer")
    //actServer ! "呵呵呵呵"
    actServer ! new Person("张三",18)
  }
}