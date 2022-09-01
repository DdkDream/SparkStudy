package com.nuc.bigdata.spark.core.framework.application

import com.nuc.bigdata.spark.core.framework.common.TApplication
import com.nuc.bigdata.spark.core.framework.controller.WordCountController
import org.apache.spark.{SparkConf, SparkContext}


object WordCountApplication extends App with TApplication{

    // 启动应用程序
    start(){
        val controller = new WordCountController()
        controller.dispatch()
    }

}
