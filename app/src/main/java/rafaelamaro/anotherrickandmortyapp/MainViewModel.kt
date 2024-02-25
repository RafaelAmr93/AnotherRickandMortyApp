package rafaelamaro.anotherrickandmortyapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData
import rafaelamaro.anotherrickandmortyapp.network.paging.CharacterPagingSource

class MainViewModel : ViewModel() {

    fun getCharactersList(): Flow<PagingData<CharacterData>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = {
                CharacterPagingSource()
            }
        ).flow.cachedIn(viewModelScope)
    }
}
