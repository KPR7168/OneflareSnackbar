package com.oneflare.ofsnackbarexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import au.com.oneflare.businessapp.ui.views.snackbar.servicearea.OneflareSnackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            OneflareSnackbar.make(this.window.decorView.rootView, "This new sample").show()
        }
    }
}
