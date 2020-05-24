package com.ikhwankoto.layout.uI.material.bottomNavigation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

/**
 * https://github.com/material-components/material-components-android/blob/master/docs/components/BottomNavigation.md
 * Can do it with theme
 */

class BottomNavigationActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener(this)
        loadFragment(SearchFragment.newInstance())
        setUpBadge()
    }

    private fun setUpBadge() {
        ///From Doc but error
        ///https://github.com/material-components/material-components-android/blob/master/docs/components/BadgeDrawable.md

//        var badge: BadgeDrawable = BadgeDrawable.create(this)
//        badge.backgroundColor = ContextCompat.getColor(this, R.color.colorAccent)
//        badge.number = 12
//        badge.badgeGravity = BadgeDrawable.TOP_END
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
//            BadgeUtils.attachBadgeDrawable(badge, bottom_navigation.getChildAt(0), frame_layout)
//        } else {
//            // Implement this feature without material design
//        }

        ///From StackOverflow
        val menuItemId: Int = bottom_navigation.menu.getItem(0).itemId //0 menu item index.
        val badgeDrawable: BadgeDrawable = bottom_navigation.getOrCreateBadge(menuItemId)
        badgeDrawable.isVisible = true
        badgeDrawable.number = 8
        badgeDrawable.badgeGravity = BadgeDrawable.TOP_END

        //Hide badge
        //badgeDrawable.isVisible = false
        //badgeDrawable.clearNumber()
        //Remove any badge
        //bottom_navigation.removeBadge(menuItemId)
    }

    private fun loadFragment(fragment: Fragment) { // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.page_1 -> {
                loadFragment(SearchFragment.newInstance())
                true
            }
            R.id.page_2 -> {
                loadFragment(DeleteFragment.newInstance())
                true
            }
            else -> {
                true
            }
        }
    }

}
