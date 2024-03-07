package com.arkan.layoutingexample

import android.os.Bundle
import android.widget.ActionMenuView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.arkan.layoutingexample.databinding.ActivityMainBinding
import com.arkan.layoutingexample.model.Category

//class MainActivity : AppCompatActivity() {
//    private var ivProfileMenu : ImageView? = null
//    private val tvName : TextView by lazy {
//        findViewById(R.id.tv_name)
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        bind()
//        setAction()
//        changeProfileIcon()
//    }
//
//    private fun changeProfileIcon() {
//        ivProfileMenu?.setImageResource(R.drawable.ic_profile_marie)
//    }
//
//    private fun setAction() {
//        ivProfileMenu?.setOnClickListener {
//            Toast.makeText(this@MainActivity, "Hai Arkan Mahardika", Toast.LENGTH_SHORT).show()
//        }
//        tvName.text = "Hai Arkan Mahardika!"
//    }
//
//    private fun bind() {
//        ivProfileMenu = findViewById(R.id.iv_profile_menu)
//    }
//}
//// find view by id method

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter = CategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAction()
        changeProfileIcon()
        setListCategory()
    }

    private fun changeProfileIcon() {
        binding.layoutHeader.ivProfileMenu.setImageResource(R.drawable.ic_profile_marie)
//        ivProfileMenu?.setImageResource(R.drawable.ic_profile_marie)
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.ic_profile_marie, name = "Minuman 1"),
            Category(image = R.drawable.ic_profile_marie, name = "Minuman 2"),
            Category(image = R.drawable.ic_profile_marie, name = "Minuman 3"),
            Category(image = R.drawable.ic_profile_marie, name = "Minuman 4"),
            Category(image = R.drawable.ic_profile_marie, name = "Minuman 5")
        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.adapter
        }
        adapter.submitData(data)
    }

    private fun setAction() {
        binding.layoutHeader.ivProfileMenu.setOnClickListener {
            Toast.makeText(this@MainActivity, "Hai Arkan Mahardika", Toast.LENGTH_SHORT).show()
        }
        binding.layoutHeader.tvName.text = "Hai Arkan Mahardika!"
    }
}
// view binding method