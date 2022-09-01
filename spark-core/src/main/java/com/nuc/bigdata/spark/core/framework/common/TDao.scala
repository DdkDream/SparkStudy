package com.nuc.bigdata.spark.core.framework.common

import com.nuc.bigdata.spark.core.framework.util.EnvUtil

trait TDao {

    def readFile(path: String) = {
        EnvUtil.take().textFile(path)
    }
}
