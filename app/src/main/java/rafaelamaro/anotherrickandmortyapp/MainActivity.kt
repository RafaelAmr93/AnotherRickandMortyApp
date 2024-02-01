package rafaelamaro.anotherrickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.paging.compose.collectAsLazyPagingItems
import rafaelamaro.anotherrickandmortyapp.ui.list.MainListScreen
import rafaelamaro.anotherrickandmortyapp.ui.list.MainListViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val charactersList = viewModel.getCharactersList().collectAsLazyPagingItems()
            MainListScreen(charactersList = charactersList)
        }
    }
}
