package rafaelamaro.anotherrickandmortyapp.ui.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import rafaelamaro.anotherrickandmortyapp.network.RickAndMortyRepository
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData
import rafaelamaro.anotherrickandmortyapp.network.data.EpisodeData

class OverviewViewModel(private val repository: RickAndMortyRepository) : ViewModel() {

    val characters: Flow<PagingData<CharacterData>> = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { repository.characterPagingSource() }
    ).flow
        .cachedIn(viewModelScope)

    val episodes: Flow<PagingData<EpisodeData>> = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { repository.episodePagingSource() }
    ).flow
        .cachedIn(viewModelScope)

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repository = RickAndMortyRepository()
                return OverviewViewModel(repository) as T
            }
        }
    }
}
