package com.nuc.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark16_RDD_operator_Transform {
    def main(args: Array[String]): Unit = {

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
        val sc = new SparkContext(sparkConf)

        // TODO 算子 - key-Value类型

        val rdd = sc.makeRDD(List(
            ("a", 1), ("a", 2), ("a", 3), ("b", 4)
        ))

        // groupByKey：将数据源中的谁，相同key的数据分在一个组中，形成一个对偶元组
        //              元组中的第一个元素就是key，
        //              元组中的第二个元素就是相同key的value集合
        val groupRDD: RDD[(String, Iterable[Int])] = rdd.groupByKey()

        groupRDD.collect().foreach(println)

        val groupRDD1: RDD[(String, Iterable[(String, Int)])] = rdd.groupBy(_._1)


        sc.stop()
    }
}