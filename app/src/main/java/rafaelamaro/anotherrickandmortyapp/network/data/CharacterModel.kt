package rafaelamaro.anotherrickandmortyapp.network.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterData(
    @Json(name = "name")
    val name: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "species")
    val species: String,
    @Json(name = "origin")
    val origin: CharacterOriginModel,
    @Json(name = "episode")
    val episodes: List<String>
) : Parcelable

@Parcelize
data class CharacterOriginModel(
    val name: String,
    val url: String
): Parcelable

data class CharacterPagedResponse(
    @Json(name = "info")
    val pageInfo: PageInfo,
    @Json(name = "results")
    val result: List<CharacterData>
)

data class PageInfo(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?
)
