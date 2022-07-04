package com.ssin.instagram

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView
import com.ssin.instagram.databinding.ActivityMainBinding
import com.ssin.instagram.fragment.AccountFragment
import com.ssin.instagram.fragment.AddFragment
import com.ssin.instagram.fragment.HomeFragment
import com.ssin.instagram.fragment.SearchFragment

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item_home ->{
                var homeFragment = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout_main_contents, homeFragment).commit()
                return true
            }

            R.id.item_search ->{
                var searchFragment = SearchFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout_main_contents, searchFragment).commit()
                return true
            }

            R.id.item_add ->{
                var addFragment = AddFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout_main_contents, addFragment).commit()
                return true
            }

            R.id.item_account ->{
                var accountFragment = AccountFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout_main_contents, accountFragment).commit()
                return true
            }
        }
        return false
    }
}