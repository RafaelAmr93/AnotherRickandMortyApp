package rafaelamaro.anotherrickandmortyapp.network

import rafaelamaro.anotherrickandmortyapp.network.paging.CharacterPagingSource
import rafaelamaro.anotherrickandmortyapp.network.paging.EpisodePagingSource

class RickAndMortyRepository {
    fun characterPagingSource() = CharacterPagingSource()
}