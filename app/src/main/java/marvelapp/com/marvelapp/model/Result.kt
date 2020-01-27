package marvelapp.com.marvelapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
        @field:[Expose SerializedName("id")] val id: Int?,
        @field:[Expose SerializedName("name")] val name: String?,
        @field:[Expose SerializedName("description")] val description: String?,
        @field:[Expose SerializedName("modified")] val modified: String?,
        @field:[Expose SerializedName("thumbnail")] val thumbnail: Thumbnail?,
        @field:[Expose SerializedName("resourceURI")] val resourceURI: String?
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            source.readString(),
            source.readParcelable<Thumbnail>(Thumbnail::class.java.classLoader),
            source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(id)
        writeString(name)
        writeString(description)
        writeString(modified)
        writeParcelable(thumbnail, 0)
        writeString(resourceURI)
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Result> = object : Parcelable.Creator<Result> {
            override fun createFromParcel(source: Parcel): Result = Result(source)
            override fun newArray(size: Int): Array<Result?> = arrayOfNulls(size)
        }
    }
}