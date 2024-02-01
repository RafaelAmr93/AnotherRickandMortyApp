package rafaelamaro.anotherrickandmortyapp.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import rafaelamaro.anotherrickandmortyapp.network.api.ApiClient.apiService
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData

class CharacterPagingSource : PagingSource<Int, CharacterData>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterData>): Int? {
        return state.anchorPosition?.let {
            val page = state.closestPageToPosition(it)
            page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterData> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getCharacters(page = page)

            LoadResult.Page(
                data = response.result,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.result.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
        TODO("checar se os personagens da ultima pagina estao sendo chamados")
    }
}