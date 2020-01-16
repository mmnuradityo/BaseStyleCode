package com.nuradityo.basestylecode.repositoies

import com.nuradityo.basestylecode.model.DataModel

class DataDefault {

    companion object {

        private var data: ArrayList<DataModel> = ArrayList()

        fun getAll(): ArrayList<DataModel> {

            data.add(DataModel("title 1", "detail 1"))
            data.add(DataModel("title 2", "detail 2"))
            data.add(DataModel("title 3", "detail 3"))
            data.add(DataModel("title 4", "detail 4"))
            data.add(DataModel("title 5", "detail 5"))

            return data
        }

        fun addDataList(): ArrayList<DataModel> {
            data.add(DataModel("title 1", "detail 1"))
            data.add(DataModel("title 2", "detail 2"))
            data.add(DataModel("title 6", "detail 6"))
            data.add(DataModel("title 7", "detail 7"))

            return data
        }

        fun addDataItem(position: Int): DataModel {
            val num = position + 1
            return DataModel("title " + num, "detail " + num)
        }

    }

}