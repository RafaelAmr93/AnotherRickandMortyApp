package rafaelamaro.anotherrickandmortyapp.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.*
import rafaelamaro.anotherrickandmortyapp.network.Repository
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData

class OverviewViewModel(private val repository: Repository) : ViewModel() {

    private val _characters: Flow<PagingData<CharacterData>> = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { repository.characterPagingSource() }
    ).flow
        .cachedIn(viewModelScope)

    val characters = _characters

    private val _characterDetail = MutableLiveData<CharacterData?>()
    val characterDetail: MutableLiveData<CharacterData?> = _characterDetail
    fun displayCharacterDetail(character: CharacterData) {
        _characterDetail.value = character
    }

    fun displayCharacterDetailComplete() {
        _characterDetail.value = null
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repository = Repository()
                return OverviewViewModel(repository) as T
            }
        }
    }
}
