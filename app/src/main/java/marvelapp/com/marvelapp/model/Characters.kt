package marvelapp.com.marvelapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Characters(
        @field:[Expose SerializedName("code")] val code: Int?,
        @field:[Expose SerializedName("status")] val status: String?,
        @field:[Expose SerializedName("copyright")] val copyright: String?,
        @field:[Expose SerializedName("attributionText")] val attributionText: String?,
        @field:[Expose SerializedName("attributionHTML")] val attributionHTML: String?,
        @field:[Expose SerializedName("etag")] val etag: String?,
        @field:[Expose SerializedName("data")] val data: Data?
)