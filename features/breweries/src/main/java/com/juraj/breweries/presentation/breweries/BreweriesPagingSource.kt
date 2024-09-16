package com.juraj.breweries.presentation.breweries

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.juraj.domain.breweries.GetBreweriesUseCase
import com.juraj.model.model.Brewery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BreweriesPagingSource(
    private val getBreweriesUseCase: GetBreweriesUseCase,
) : PagingSource<Int, Brewery>() {
    override fun getRefreshKey(state: PagingState<Int, Brewery>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Brewery> {
        val currentPage = params.key ?: 0

        return withContext(Dispatchers.IO) {
            try {
                val result = getBreweriesUseCase.getBreweries(currentPage, params.loadSize)

                val prevKey = currentPage - params.loadSize
                val nextKey = currentPage + params.loadSize

                LoadResult.Page(
                    data = result,
                    prevKey = if (currentPage == 0) null else prevKey,
                    nextKey = if (result.isEmpty()) null else nextKey
                )
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }
}
