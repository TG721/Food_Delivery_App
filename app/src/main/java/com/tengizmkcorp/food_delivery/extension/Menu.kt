package com.tengizmkcorp.food_delivery.extension

import com.google.android.material.bottomnavigation.BottomNavigationView

fun BottomNavigationView.uncheckAllItems() {
    menu.setGroupCheckable(0, true, false)
    for (i in 0 until menu.size()) {
        menu.getItem(i).isChecked = false
    }
}