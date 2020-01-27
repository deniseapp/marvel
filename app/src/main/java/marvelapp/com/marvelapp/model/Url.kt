package marvelapp.com.marvelapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Url(
        @field:[Expose SerializedName("type")] val type: String?,
        @field:[Expose SerializedName("url")] val url: String?
)