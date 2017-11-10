package cn.dodo.akka.wordcount.actor

import cn.dodo.akka.wordcount.bean.ReducerBean
import akka.actor.Actor
import cn.dodo.akka.wordcount.bean.MapperBean

class WcMapperActor extends Actor {
    def receive: Actor.Receive = {
      case msg:MapperBean =>{
        val data = msg.datax
        val mapFunc = msg.mapFuncx
        val reduceFunc = msg.reduceFuncx
        val data2 = mapFunc(data);
        val rif = new ReducerBean(data2,reduceFunc)
        val wcReducerActor = context.actorSelection("akka.tcp://wcReducerSys@127.0.0.1:44442/user/wcReducerActor")
        wcReducerActor ! rif;
      }
    }
  }