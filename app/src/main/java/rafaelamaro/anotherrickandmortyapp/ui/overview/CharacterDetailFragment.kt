package rafaelamaro.anotherrickandmortyapp.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import rafaelamaro.anotherrickandmortyapp.R
import rafaelamaro.anotherrickandmortyapp.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailBinding
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindData()
    }

    private fun bindData() {
        with(binding) {
            characterName.text = args.characterDetail?.name
            characterStatus.text = args.characterDetail?.status
            characterSpecies.text = args.characterDetail?.species
            characterOrigin.text = args.characterDetail?.origin?.name
            characterFirstAppearance.text = args.characterDetail?.episodes?.first()
            characterImage.load(args.characterDetail?.image) {
                placeholder(R.drawable.ic_launcher_foreground)
            }
        }
    }
}
