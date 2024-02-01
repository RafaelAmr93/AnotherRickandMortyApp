package rafaelamaro.anotherrickandmortyapp.ui.list

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData
import rafaelamaro.anotherrickandmortyapp.ui.character.CharacterCard

@Composable
fun MainListScreen(charactersList: LazyPagingItems<CharacterData>) {

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(charactersList.itemCount) { index ->
            charactersList[index]?.let { character ->
                CharacterCard(character = character)
            }
        }
    }
}
