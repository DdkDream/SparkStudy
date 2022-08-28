package com.nuc.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_operator_Transform {
    def main(args: Array[String]): Unit = {

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
        val sc = new SparkContext(sparkConf)

        // TODO 算子 - map

        val rdd = sc.makeRDD(List(1, 2, 3, 4))
        // 1,2,3,4
        // 2,4,6,8

        // 转换算子
        def mapFunctions(num: Int): Int = {
            num * 2
        }

//        val mapRDD: RDD[Int] = rdd.map(mapFunctions)
//        val mapRDD: RDD[Int] = rdd.map((num: Int)=>{num * 2})
        val mapRDD: RDD[Int] = rdd.map(_ * 2)

        mapRDD.collect().foreach(println)


        sc.stop()
    }
}
