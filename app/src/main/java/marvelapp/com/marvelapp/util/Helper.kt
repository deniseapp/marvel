package marvelapp.com.marvelapp.util

import java.security.NoSuchAlgorithmException
import android.provider.SyncStateContract.Helpers.update



object Helper {
    const val BASE_URL = "https://gateway.marvel.com/"

    const val PUBLIC_KEY = "0bfaefcb4eab962dd68c01bc9c150625"
    const val PRIVATE_KEY = "6a8e4cf37fdd73c435429c6459cbc224a4515721"


    fun md5(s: String): String {
        val MD5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = java.security.MessageDigest
                    .getInstance(MD5)
            digest.update(s.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2)
                    h = "0$h"
                hexString.append(h)
            }
            return hexString.toString()

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return ""
    }
}
