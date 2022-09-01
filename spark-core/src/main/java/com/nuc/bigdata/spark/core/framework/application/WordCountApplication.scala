package com.nuc.bigdata.spark.core.framework.application

import com.nuc.bigdata.spark.core.framework.controller.WordCountController
import org.apache.spark.SparkConf

object WordCountApplication extends App {

    val sparConf = new SparkConf().setMaster()


    val controller = new WordCountController()
}
