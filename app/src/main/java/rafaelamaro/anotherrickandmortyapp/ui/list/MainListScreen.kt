package rafaelamaro.anotherrickandmortyapp.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData
import rafaelamaro.anotherrickandmortyapp.ui.character.CharacterCard
import rafaelamaro.anotherrickandmortyapp.ui.getCharacterListMock

@Composable
fun MainListScreen(charactersList: LazyPagingItems<CharacterData>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.White)
            .padding(8.dp),
    ) {
        items(charactersList.itemCount) { index ->
            charactersList[index]?.let { character ->
                CharacterCard(character = character)
            }
        }
    }
}

@Composable
@Preview
private fun MainListScreenPreview() {
    MainListScreen(getCharacterListMock().collectAsLazyPagingItems())
}
