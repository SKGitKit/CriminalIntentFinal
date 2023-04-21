package com.khanappsnj.criminalintentfinal

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khanappsnj.criminalintentfinal.databinding.ListItemCrime2Binding
import com.khanappsnj.criminalintentfinal.databinding.ListItemCrimeBinding
import java.util.*
import javax.crypto.Cipher

private const val TAG = "CrimeListAdapter"
const val REGULAR_CRIME = 0
const val SEVERE_CRIME = 1


class CrimeListAdapter(
    private val crimes: List<Crime>,
    val onCrimeClicked: (UUID) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Need this class to create a holder that holds the views.
    class CrimeViewHolder(val binding: ListItemCrimeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            crime: Crime,
            onCrimeClicked: (UUID) -> Unit
        ) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()
            if (!crime.isSolved) binding.crimeSolved.visibility = View.INVISIBLE
            else binding.crimeSolved.visibility = View.VISIBLE
            binding.root.setOnClickListener {
                onCrimeClicked(crime.id)
            }
        }
    }

    class CrimeViewHolder2(
        val binding: ListItemCrime2Binding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(crime: Crime) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()
            if (!crime.isSolved) binding.crimeSolved.visibility = View.INVISIBLE
            else binding.crimeSolved.visibility = View.VISIBLE
        }
    }

    /*override fun getItemViewType(position: Int): Int {
        Log.d(TAG,"current type : ${crimes[position].requirePolice}")
        return when (crimes[position].requirePolice) {
            true -> SEVERE_CRIME
            else -> REGULAR_CRIME
        }
    } */

    //Create the holder, get instance of binding by getting inflater from parent
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        /*return when(viewType){
            REGULAR_CRIME -> {
                val binding = ListItemCrimeBinding.inflate(inflater,parent,false)
                CrimeViewHolder(binding)
            }
            SEVERE_CRIME ->  {
                val binding = ListItemCrime2Binding.inflate(inflater,parent,false)
                CrimeViewHolder2(binding)
            }
            else -> throw java.lang.IllegalArgumentException("Invalid item type")
        }*/
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeViewHolder(binding)

    }

    override fun getItemCount() = crimes.size

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val crime = crimes[position]
        when (holder.itemViewType) {
            REGULAR_CRIME -> {
                val viewHolder = holder as CrimeViewHolder
                viewHolder.bind(crime,onCrimeClicked)
            }
            SEVERE_CRIME -> {
                val viewHolder = holder as CrimeViewHolder2
                viewHolder.bind(crime)
            }
        }
    }
}