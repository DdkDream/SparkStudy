package com.nuc.bigdata.spark.core.acc

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_Acc {
    def main(args: Array[String]): Unit = {
        val sparConf = new SparkConf().setMaster("local").setAppName("WordCount")
        val sc = new SparkContext(sparConf)

        val rdd = sc.makeRDD(List(1, 2, 3, 4))

        // 获取系统累加器
        // Spark默认就提供了简单数据聚合的累加器
        var sumACC = sc.longAccumulator("sum")

        rdd.foreach(
            num => {
                // 使用累加器
                sumACC.add(num)
            }
        )

        // 获取累加器的值
        println(sumACC.value)



        sc.stop()


    }
}
