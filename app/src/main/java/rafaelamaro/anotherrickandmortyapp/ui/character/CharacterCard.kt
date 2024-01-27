package rafaelamaro.anotherrickandmortyapp.ui.character

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import rafaelamaro.anotherrickandmortyapp.R

@Composable
fun CharacterCard() {
    CharacterImage()
}

@Composable
private fun CharacterImage() {
    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Character image")
}



@Preview
@Composable
private fun CharacterCardPreview() {
    CharacterCard()
}