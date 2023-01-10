package rafaelamaro.anotherrickandmortyapp.network.data

import com.squareup.moshi.Json

data class CharacterData(
    val id: Int,
    val name: String,
    val image: String
)

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

data class EpisodeData(
    val id: Int,
    val name: String,
    @Json(name = "air_date")
    val airDate: String,
    @Json(name = "episode")
    val episodeCode: String
)

data class EpisodePagedResponse(
    @Json(name = "info")
    val pageInfo: PageInfo,
    @Json(name = "results")
    val result: List<EpisodeData>
)
