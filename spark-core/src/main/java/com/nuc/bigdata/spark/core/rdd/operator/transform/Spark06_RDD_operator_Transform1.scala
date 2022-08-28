package com.nuc.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark06_RDD_operator_Transform1 {
    def main(args: Array[String]): Unit = {

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
        val sc = new SparkContext(sparkConf)

        // TODO 算子 - groupBy
        val rdd = sc.makeRDD(List("Hello", "Spark", "Scala", "Hadoop"), 2)

        // 分组和分区没有必然的关系
        val groupRDD: RDD[(Char, Iterable[String])] = rdd.groupBy(_.charAt(0))

        groupRDD.collect().foreach(println)

        sc.stop()
    }
}
