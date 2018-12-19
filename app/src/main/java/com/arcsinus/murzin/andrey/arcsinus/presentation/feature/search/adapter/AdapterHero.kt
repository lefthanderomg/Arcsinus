package com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.arcsinus.murzin.andrey.arcsinus.R
import com.arcsinus.murzin.andrey.arcsinus.presentation.model.HeroViewModel
import com.arcsinus.murzin.andrey.arcsinus.utils.ext.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_hero.view.*
import javax.inject.Inject

class AdapterHero @Inject constructor(
) : RecyclerView.Adapter<AdapterHero.ViewHolder>() {

    private val heroList: MutableList<HeroViewModel> = mutableListOf()

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(container.inflate(R.layout.item_hero))

    override fun getItemCount(): Int = heroList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(heroList[position])
    }


    inner class ViewHolder(
            override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: HeroViewModel) {
            with(containerView) {
                tvName.text = item.name
                tvBirthyYear.text = item.birthYear
                tvEyeColor.text = item.eyeColor
                tvGender.text = item.gender
                tvHeight.text = item.height
                tvHairColor.text = item.hairColor
                tvSkinColor.text = item.skinColor
            }
        }
    }

    fun setData(data: List<HeroViewModel>) {
        heroList.clear()
        heroList.addAll(data)
        notifyDataSetChanged()
    }

}