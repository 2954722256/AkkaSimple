package cn.dodo.akka.wordcount.actor

import akka.actor.Actor
import cn.dodo.akka.wordcount.bean.ReducerBean

class WcReducerActor extends Actor {
  def receive: Actor.Receive = {
    case msg: ReducerBean => {
      val data = msg.datax
      val reduceFunc = msg.reduceFuncx
      val result = reduceFunc(data);
      println(result)
    }
  }
}