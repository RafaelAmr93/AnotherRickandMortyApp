package rafaelamaro.anotherrickandmortyapp.ui.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import kotlinx.coroutines.launch
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData
import rafaelamaro.anotherrickandmortyapp.ui.character.CharacterCard
import rafaelamaro.anotherrickandmortyapp.ui.getCharacterListMock

@Composable
fun MainListScreen(charactersList: LazyPagingItems<CharacterData>) {
    val gridState = rememberLazyGridState()
    val scope = rememberCoroutineScope()
    val showButton by remember {
        derivedStateOf {
            gridState.firstVisibleItemIndex > 0
        }
    }

    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        LazyVerticalGrid(
            state = gridState,
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier
                .background(Color.White)

        ) {
            items(charactersList.itemCount) { index ->
                charactersList[index]?.let { character ->
                    CharacterCard(character = character)
                }
            }
        }

        AnimatedVisibility(visible = showButton, enter = fadeIn(), exit = fadeOut()) {
            BackToTopButton {
                scope.launch {
                    gridState.scrollToItem(0)
                }
            }
        }
    }
}

@Composable
@Preview
private fun MainListScreenPreview() {
    MainListScreen(getCharacterListMock().collectAsLazyPagingItems())
}
