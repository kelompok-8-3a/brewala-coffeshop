package com.example.brewalacoffe.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brewalacoffe.Menu
import com.example.brewalacoffe.Promo
import com.example.brewalacoffe.R
import com.example.brewalacoffe.TypePromo

class HomeFragment : Fragment() {

    private lateinit var getDataRecyclerView: GetDataRecyclerView

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

        val recylerviewProduct = view.findViewById<RecyclerView>(R.id.recyclerviewListMenu)
        recylerviewProduct.layoutManager = LinearLayoutManager(requireActivity())

        val recylerViewPromo = view.findViewById<RecyclerView>(R.id.recyclerPromo)
        recylerViewPromo.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false)

        val recylerViewCategory = view.findViewById<RecyclerView>(R.id.recyclerViewCategoryMenu)
        recylerViewCategory.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val listPromo:List<Promo> = getDataRecyclerView.getDataListPromo()
        val listMenu:List<Menu> = getDataRecyclerView.getDataListMenu()
        val listCategory:List<CategoryMenu> = getDataRecyclerView.get

        recylerviewProduct.adapter = MenuAdapter(
            listMenu,
            ::goToProduct
        )

        recylerViewPromo.adapter = PromoAdapter(listPromo)
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