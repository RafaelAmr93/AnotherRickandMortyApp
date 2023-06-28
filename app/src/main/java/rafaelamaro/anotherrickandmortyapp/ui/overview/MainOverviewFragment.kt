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
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import rafaelamaro.anotherrickandmortyapp.databinding.FragmentMainOverviewBinding
import rafaelamaro.anotherrickandmortyapp.ui.character.CharacterListAdapter

class MainOverviewFragment : Fragment() {

    private lateinit var binding: FragmentMainOverviewBinding
    private val viewModel: OverviewViewModel by viewModels { OverviewViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCharacters()
        observeCharacterClick()
    }

    private fun getCharacters() {
        val pagingDataCharacter = CharacterListAdapter(CharacterListAdapter.OnClickListener {
            viewModel.displayCharacterDetail(it)
        })
        val characters = viewModel.characters
        binding.overviewList.adapter = pagingDataCharacter
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                characters.collectLatest {
                    pagingDataCharacter.submitData(it)
                }
            }
        }
    }

    private fun observeCharacterClick() {
        viewModel.characterDetail.observe(viewLifecycleOwner) {
            if (it != null) {
                this.findNavController().navigate(
                    MainOverviewFragmentDirections.actionFirstFragmentToSecondFragment(it)
                )
                viewModel.displayCharacterDetailComplete()
            }
        }
    }
}
