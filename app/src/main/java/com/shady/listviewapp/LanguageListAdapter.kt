package com.shady.listviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView




    class LanguageListAdapter : ListAdapter<language, LanguageViewHolder>(LGUAGESANS_COMPARATOR) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
            return languageViewHolder.create(parent)
        }

        override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
            val current = getItem(position)
            holder.bind(current.language)
        }

        class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val languageItemView: TextView = itemView.findViewById(R.id.textView)

            fun bind(text: String?) {
                languageItemView.text = text
            }

            companion object {
                fun create(parent: ViewGroup): LanguageViewHolder  {
                    val view: View = LayoutInflater.from(parent.context)
                        .inflate(R.layout.recyclerview_item, parent, false)
                    return LanguageViewHolder (view)
                }
            }
        }

        companion object {
            private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Language>() {
                override fun areItemsTheSame(oldItem: Language , newItem: Language): Boolean {
                    return oldItem === newItem
                }

                override fun areContentsTheSame(oldItem: Language, newItem:Language): Boolean {
                    return Language == Language
                }
            }
        }
    }
















