package com.example.brewalacoffe.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brewalacoffe.FilterCategoryMenu
import com.example.brewalacoffe.Menu
import com.example.brewalacoffe.Promo
import com.example.brewalacoffe.R

class HomeFragment : Fragment() {

    private lateinit var getDataRecyclerView: GetDataRecyclerView
    private lateinit var filterCategoryMenu: FilterCategoryMenu
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDataRecyclerView = GetDataRecyclerView()
        filterCategoryMenu = FilterCategoryMenu(getDataRecyclerView)

        // ambil data
        val listPromo:List<Promo> = getDataRecyclerView.getDataListPromo()
        val listMenu: MutableList<Menu> = getDataRecyclerView.getDataListMenu()
        val masterListMenu: List<Menu> = getDataRecyclerView.getDataListMenu()
        val listCategory:List<CategoryMenu> = getDataRecyclerView.getDataListCategory()

        // tampilkan data ke recycler view product
        val recylerviewProduct = view.findViewById<RecyclerView>(R.id.recyclerviewListMenu)
        menuAdapter = MenuAdapter(listMenu.toMutableList(), ::goToProduct)
        recylerviewProduct.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.VERTICAL,
            false)
        recylerviewProduct.adapter = menuAdapter

        val recylerViewPromo = view.findViewById<RecyclerView>(R.id.recyclerPromo)
        recylerViewPromo.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false)
        recylerViewPromo.adapter = PromoAdapter(listPromo)

        val recylerViewCategory = view.findViewById<RecyclerView>(R.id.recyclerViewCategoryMenu)
        recylerViewCategory.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        recylerViewCategory.adapter = CategoryAdapter(
            listCategory
            ){ selectedCategory ->
                val filteredList = if(selectedCategory.name == "ALL"){
                    masterListMenu
                } else {
                    filterCategoryMenu.filterCategoryMenu { menu: Menu ->
                        menu.categoryMenu == selectedCategory
                    }
                }
            menuAdapter.updateData(filteredList)
        }
    }

    fun goToProduct(menu:Menu): Unit{
        val detailProductIntent = Intent(
            requireActivity(),
            DetailProductActivity::class.java,
        )

        detailProductIntent.putExtra(IMAGE_PRODUCT, menu.imageMenu)
        detailProductIntent.putExtra(PRICE_PRODUCT, menu.priceMenu)
        detailProductIntent.putExtra(NAME_PRODUCT, menu.nameMenu)
        detailProductIntent.putExtra(CATEGORY_PRODUCT, menu.categoryMenu)
        detailProductIntent.putExtra(DESCRIBE_PRODUCT, menu.describeMenu)

        startActivity(detailProductIntent)

    }

    companion object {
        const val NAME_PRODUCT = "name_product"
        const val PRICE_PRODUCT = "price_product"
        const val IMAGE_PRODUCT = "image_product"
        const val CATEGORY_PRODUCT = "category_prodcut"
        const val  DESCRIBE_PRODUCT = "describe_product"
    }
}