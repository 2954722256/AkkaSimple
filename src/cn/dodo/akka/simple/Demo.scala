package cn.dodo.akka.simple

import akka.actor.ActorSystem
import akka.actor.Props

class Demo {
  def main(args: Array[String]): Unit = {
    val sys = ActorSystem("mySys");
    val act1 = sys.actorOf(Props[Actor1]);
    act1 ! "哈哈哈哈"
  }
}