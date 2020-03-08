package com.src.assignapplication.ui.model


import com.google.gson.annotations.SerializedName

data class IntObj(@SerializedName("val")
                  val value: Int = 0,
                  @SerializedName("iscChecked")
                  var iscChecked: Boolean = false)


