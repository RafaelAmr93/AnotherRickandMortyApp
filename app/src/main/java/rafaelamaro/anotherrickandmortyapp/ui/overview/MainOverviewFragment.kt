package rafaelamaro.anotherrickandmortyapp.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import rafaelamaro.anotherrickandmortyapp.databinding.FragmentMainOverviewBinding
import rafaelamaro.anotherrickandmortyapp.ui.character.CharacterListAdapter
import rafaelamaro.anotherrickandmortyapp.ui.episode.EpisodeListAdapter

class MainOverviewFragment : Fragment() {

    private lateinit var binding: FragmentMainOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainOverviewBinding.inflate(inflater, container, false)

        val viewModel: OverviewViewModel by viewModels { OverviewViewModel.Factory }

        // Characters
        val pagingDataCharacter = CharacterListAdapter()
        val characters = viewModel.characters
        binding.character.setOnClickListener {
            binding.overviewList.adapter = pagingDataCharacter
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    characters.collectLatest {
                        pagingDataCharacter.submitData(it)
                    }
                }
            }
        }

        // Episodes
        val pagingDataEpisode = EpisodeListAdapter()
        val episodes = viewModel.episodes
        binding.episodes.setOnClickListener {
            binding.overviewList.adapter = pagingDataEpisode
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.CREATED) {
                    episodes.collectLatest {
                        pagingDataEpisode.submitData(it)
                    }
                }
            }
        }

        return binding.root
    }
}