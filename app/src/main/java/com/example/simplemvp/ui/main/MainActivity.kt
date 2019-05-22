package com.example.simplemvp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.bumptech.glide.Glide
import com.example.simplemvp.R
import com.example.simplemvp.data.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private val user = User(DEFAULT_USER_NAME, DEFAULT_USER_EMAIL, null)
    private val presenter = MainPresenter(this, user)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }

    private fun initView() {
        textUserName.text = presenter.user.name
        textUserEmail.text = presenter.user.email
        imageUserAvatar.setImageResource(R.mipmap.ic_launcher_round)
        editUserName.setText(presenter.user.name)
        editUserEmail.setText(presenter.user.email)
        editUserAvatarUrl.setText(DEFAULT_AVATAR_URL)
    }

    private fun initListener() {
        editUserName.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) =
                presenter.updateUserName(charSequence.toString())
        })
        editUserEmail.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) =
                presenter.updateUserEmail(charSequence.toString())
        })
        buttonLoadAvatar.setOnClickListener {
            presenter.updateUserAvatarUrl(editUserAvatarUrl.text.toString())
        }
    }

    override fun updateTextUserName(name: String) {
        textUserName.text = name
    }

    override fun updateTextUserEmail(email: String) {
        textUserEmail.text = email
    }

    override fun updateImageUserAvatar(url: String) {
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.ic_loading_spinner)
            .error(R.drawable.ic_unknown_avatar)
            .into(imageUserAvatar)
    }

    companion object {
        private const val DEFAULT_AVATAR_URL =
            "http://dangcongsan.vn/DATA/0/2019/04/nguyen_xuan_phuc1_1735-21_05_04_226.jpg"
        private const val DEFAULT_USER_NAME = "Nguyen Xuan Phuc"
        private const val DEFAULT_USER_EMAIL = "nxphuc@gmail.com"
    }
}
