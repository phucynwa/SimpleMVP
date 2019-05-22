package com.example.simplemvp.ui.main

import com.example.simplemvp.data.User

class MainPresenter(var view: View, var user: User) {

    fun updateUserName(name: String) {
        user.name = name
        view.updateTextUserName(name)
    }

    fun updateUserEmail(email: String) {
        user.email = email
        view.updateTextUserEmail(email)
    }

    fun updateUserAvatarUrl(url: String) {
        user.avatarUrl = url
        view.updateImageUserAvatar(url)
    }

    interface View {
        fun updateTextUserName(name: String)
        fun updateTextUserEmail(email: String)
        fun updateImageUserAvatar(url: String)
    }
}
