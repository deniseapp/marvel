package marvelapp.com.marvelapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
        @field:[Expose SerializedName("offset")] val offset: Int?,
        @field:[Expose SerializedName("limit")] val limit: Int?,
        @field:[Expose SerializedName("total")] val total: Int?,
        @field:[Expose SerializedName("count")] val count: Int?,
        @field:[Expose SerializedName("results")] val results: List<Result>?
)