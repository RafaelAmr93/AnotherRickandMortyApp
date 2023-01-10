package rafaelamaro.anotherrickandmortyapp.ui.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import rafaelamaro.anotherrickandmortyapp.databinding.CardEpisodeBinding
import rafaelamaro.anotherrickandmortyapp.network.data.EpisodeData

class EpisodeListAdapter : PagingDataAdapter<EpisodeData, EpisodeListAdapter.MainViewHolder>(DiffCallback) {

    inner class MainViewHolder(private var binding: CardEpisodeBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeData?) {
            binding.episodeName.text = episode?.name
            binding.airDate.text = episode?.airDate
            binding.episodeCode.text = episode?.episodeCode
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(CardEpisodeBinding
                .inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val episode = getItem(position)
        holder.bind(episode)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<EpisodeData>(){
        override fun areItemsTheSame(oldItem: EpisodeData, newItem: EpisodeData): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: EpisodeData, newItem: EpisodeData): Boolean {
            return oldItem.name == newItem.name
        }
    }
}
