package rafaelamaro.anotherrickandmortyapp.ui.list

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData
import rafaelamaro.anotherrickandmortyapp.ui.character.CharacterCard

@Composable
fun MainListScreen(charactersList: LazyPagingItems<CharacterData>) {

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        itemsIndexed(charactersList.itemSnapshotList) { _, item ->
            item?.let {
                CharacterCard(character = item)
            }
        }
    }
}
