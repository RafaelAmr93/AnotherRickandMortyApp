package rafaelamaro.anotherrickandmortyapp.ui.character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import rafaelamaro.anotherrickandmortyapp.R
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterOriginModel

@Composable
fun CharacterCard(character: CharacterData) {
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        CharacterImage(character.image)
        CharacterText(character.name, character.status)
    }
}

@Composable
private fun CharacterImage(uri: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(uri)
            .build(),
        placeholder = painterResource(id = R.drawable.logo),
        contentDescription = "Character image",
        modifier = Modifier.clip(CircleShape)
    )
}

@Composable
private fun CharacterText(name: String, status: String) {
    Text(
        text = name
    )
    Text(
        text = status
    )
}



@Preview
@Composable
private fun CharacterCardPreview() {
    CharacterCard(characterDataMock)
}

private val characterOriginModelMock = CharacterOriginModel(
    name = "Earth",
    url = ""
)

private val characterDataMock = CharacterData(
    name = "Morty",
    image = R.drawable.logo.toString(),
    status = "Alive",
    species = "Human",
    origin = characterOriginModelMock,
    episodes = listOf()
)

