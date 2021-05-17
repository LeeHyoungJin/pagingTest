package com.helrin.pagingtest.model

import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("total_count") val total: Int = 0,
    @SerializedName("items") val items: List<Item> = emptyList(),
    val nextPage: Int? = null
)
