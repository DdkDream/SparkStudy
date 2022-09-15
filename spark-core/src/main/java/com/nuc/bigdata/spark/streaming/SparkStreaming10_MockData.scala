package com.nuc.bigdata.spark.streaming

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

import java.util.Properties
import scala.collection.mutable.ListBuffer
import scala.util.Random

object SparkStreaming10_MockData {
    def main(args: Array[String]): Unit = {

        // 生成模拟数据
        // 格式：timestamp area city userid adid
        // 含义：时间戳     区域  城市 用户    广告


        // Application => Kafka => SparkStreaming => Analysis

        val prop = new Properties()
        // 添加配置


        new KafkaProducer[String, String](prop)

        while(true){

            mockdata.foreach(
                data => {
                    // 向Kafka中生成数据

                }
            )

            Thread.sleep(2000)
        }


    }

    def mockdata() = {
        val list = ListBuffer[String]()
        val areaList = ListBuffer[String]("华北", "东北", "华南")
        val cityList = ListBuffer[String]("北京", "上海", "深圳")
        for (i <- 1 to 30 ) {

            val area = areaList(new Random().nextInt(3))
            val city = cityList(new Random().nextInt(3))
            var userid = new Random().nextInt(6)
            var adid = new Random().nextInt(6)

            list.append(s"${System.currentTimeMillis()} ${area} ${city} ${userid} ${adid}")
        }
        list
    }

}
