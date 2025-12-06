package com.example.brewalacoffe

import com.example.brewalacoffe.home.GetDataRecyclerView

class FilterCategoryMenu(val getDataRecyclerView: GetDataRecyclerView) {
        fun filterCategoryMenu(menu:(Menu)-> Boolean): List<Menu>{
        return getDataRecyclerView.getDataListMenu().filter(menu)

    }
}
