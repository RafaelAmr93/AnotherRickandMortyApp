package rafaelamaro.anotherrickandmortyapp.ui

import androidx.paging.PagingData
import kotlinx.coroutines.flow.flowOf
import rafaelamaro.anotherrickandmortyapp.R
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterOriginModel

private val characterOriginModelMock = CharacterOriginModel(
    name = "Earth",
    url = ""
)

private val characterDataMock = CharacterData(
    name = "Morty",
    image = R.drawable.logo.toString(),
    status = "Alive",
    species = "Human",
    origin = characterOriginModelMock,
    episodes = listOf()
)

private val characterListMock = flowOf(
    PagingData.from(
        List(size = 6) {
            CharacterData(
                name = "Morty",
                image = "",
                status = "Alive",
                species = "Human",
                origin = CharacterOriginModel(
                    name = "",
                    url = ""
                ),
                episodes = listOf()
            )
        }
    )
)

fun getCharacterDataMock() = characterDataMock

fun getCharacterListMock() = characterListMock