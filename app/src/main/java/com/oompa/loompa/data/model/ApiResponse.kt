package com.oompa.loompa.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("current")
    val current: Int,
    @SerializedName("results")
    val results: List<OompaDetail>,
    @SerializedName("total")
    val total: Int
)