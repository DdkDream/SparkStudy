package com.nuc.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import java.text.SimpleDateFormat
import java.util.Date

object Spark07_RDD_operator_Transform {
    def main(args: Array[String]): Unit = {

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
        val sc = new SparkContext(sparkConf)

        // TODO 算子 - groupBy
        val rdd = sc.makeRDD(List(1, 2, 3, 4))

        val filterRDD: RDD[Int] = rdd.filter(num => num % 2 != 0)

        filterRDD.collect().foreach(println)



        sc.stop()
    }
}
