package com.nuc.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming07_State_Output1 {
    def main(args: Array[String]): Unit = {


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))
        ssc.checkpoint("cp")



        val lines = ssc.socketTextStream("localhost", 9999)
        val wordToOne = lines.map((_, 1))


        val windowDS: DStream[(String, Int)] =
            wordToOne.reduceByKeyAndWindow(
                (x: Int, y: Int) => {x + y},
                (x: Int, y: Int) => {x - y},
                Seconds(9), Seconds(3))

        // SparkStreaming如果没有输出操作，那么会提示错误
        // windowDS.print()

        ssc.start()
        ssc.awaitTermination()
    }

}
