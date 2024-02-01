package rafaelamaro.anotherrickandmortyapp.network.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import rafaelamaro.anotherrickandmortyapp.network.api.ApiClient.apiService
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData

private const val STARTING_KEY = 1

class CharacterPagingSource : PagingSource<Int, CharacterData>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterData>): Int? {
        return state.anchorPosition?.let {
            val page = state.closestPageToPosition(it)
            page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterData> {
        val pageNumber = params.key ?: STARTING_KEY

        return try {
            val response = apiService.getCharacters(pageNumber)
            val pagedResponse = response.body()
            val data = pagedResponse?.result
            var nextPageNumber: Int? = null

            if (pagedResponse?.pageInfo?.next != null) {
                val uri = Uri.parse(pagedResponse.pageInfo.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            return LoadResult.Page(
                data = data.orEmpty(),
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(throwable = Throwable("Error creating page $e"))
        }
        TODO("checar se os personagens da ultima pagina estao sendo chamados")
    }
}