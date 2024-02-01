package rafaelamaro.anotherrickandmortyapp.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import rafaelamaro.anotherrickandmortyapp.network.paging.CharacterPagingSource

class Repository {
    fun characterPagingSource() = CharacterPagingSource()
}
