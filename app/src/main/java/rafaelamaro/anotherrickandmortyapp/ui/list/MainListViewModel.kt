package rafaelamaro.anotherrickandmortyapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData
import rafaelamaro.anotherrickandmortyapp.network.paging.CharacterPagingSource

class MainListViewModel : ViewModel() {

    fun getCharactersList(): Flow<PagingData<CharacterData>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = {
                CharacterPagingSource()
            }
        ).flow
    }
}
