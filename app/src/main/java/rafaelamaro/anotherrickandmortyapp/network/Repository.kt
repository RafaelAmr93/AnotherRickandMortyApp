package rafaelamaro.anotherrickandmortyapp.network

import rafaelamaro.anotherrickandmortyapp.network.paging.CharacterPagingSource

class Repository {
    fun characterPagingSource() = CharacterPagingSource()
}