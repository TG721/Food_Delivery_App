package com.tengizmkcorp.food_delivery.ui.model

data class SettingsItem (
    val title: String
        )

val settingsList = listOf<SettingsItem>(
    SettingsItem("Contacts"),
    SettingsItem("Location")
)