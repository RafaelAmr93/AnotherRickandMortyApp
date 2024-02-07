package rafaelamaro.anotherrickandmortyapp.ui.character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import rafaelamaro.anotherrickandmortyapp.R
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData
import rafaelamaro.anotherrickandmortyapp.ui.getCharacterDataMock

@Composable
fun CharacterCard(character: CharacterData) {
    ElevatedCard(
        modifier = Modifier.padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFeaeaea)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CharacterImage(character.image)
            CharacterText(character.name, character.status)
        }
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
        modifier = Modifier
            .size(140.dp)
            .padding(4.dp)
            .clip(CircleShape)
    )
}

@Composable
private fun CharacterText(name: String, status: String) {
    Text(
        text = name
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 4.dp)
    ) {
        Text(
            text = status,
            fontSize = 12.sp,
            modifier = Modifier.padding(end = 4.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.status_dot),
            contentDescription = "Icon indicating character status",
            tint = statusIconColor(status = status),
            modifier = Modifier.size(6.dp)
        )
    }
}

private fun statusIconColor(status: String): Color {
    return when (status) {
        "Alive" -> Color.Green
        "Dead" -> Color.Red
        else -> Color.Black
    }
}


@Preview
@Composable
private fun CharacterCardPreview() {
    CharacterCard(getCharacterDataMock())
}
