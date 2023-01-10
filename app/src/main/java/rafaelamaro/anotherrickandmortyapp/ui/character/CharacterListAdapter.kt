package rafaelamaro.anotherrickandmortyapp.ui.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import rafaelamaro.anotherrickandmortyapp.R
import rafaelamaro.anotherrickandmortyapp.databinding.CardCharacterBinding
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterData

class CharacterListAdapter : PagingDataAdapter<CharacterData, CharacterListAdapter.MainViewHolder>(DiffCallback) {

    inner class MainViewHolder(private var binding: CardCharacterBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterData?) {
            binding.name.text = character?.name
            binding.image.load(character?.image) {
                transformations(RoundedCornersTransformation(15.0f))
                placeholder(R.drawable.ic_launcher_foreground)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(CardCharacterBinding
            .inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<CharacterData>(){
        override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
        }
    }
}
