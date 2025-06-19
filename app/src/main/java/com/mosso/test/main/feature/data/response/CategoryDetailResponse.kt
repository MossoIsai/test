package com.mosso.test.main.feature.data.response

import com.google.gson.annotations.SerializedName

data class CategoryDetailResponse(
    @SerializedName("categories") val categoriesList: List<String>? = null,
    @SerializedName("created_at") val created: String? = null,
    @SerializedName("icon_url") val icon: String? = null,
    @SerializedName("id") val id: String? = null,
    @SerializedName("updated_at") val updated: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("value") val value: String? = null,
)