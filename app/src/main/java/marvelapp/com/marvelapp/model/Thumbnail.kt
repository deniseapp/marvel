package marvelapp.com.marvelapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Thumbnail(
        @field:[Expose SerializedName("path")] val path: String?,
        @field:[Expose SerializedName("extension")] val extension: String?
) : Parcelable {
    fun getImagePath(): String = "$path.$extension"

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(path)
        writeString(extension)
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Thumbnail> = object : Parcelable.Creator<Thumbnail> {
            override fun createFromParcel(source: Parcel): Thumbnail = Thumbnail(source)
            override fun newArray(size: Int): Array<Thumbnail?> = arrayOfNulls(size)
        }
    }
}