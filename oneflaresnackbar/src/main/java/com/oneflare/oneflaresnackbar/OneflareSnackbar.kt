package au.com.oneflare.businessapp.ui.views.snackbar.servicearea

import com.google.android.material.snackbar.BaseTransientBottomBar
import androidx.core.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import au.com.oneflare.businessapp.ui.views.snackbar.extension.findSuitableParent
import com.oneflare.oneflaresnackbar.R
import kotlinx.android.synthetic.main.layout_oneflare_snackbar_view.view.*

public class OneflareSnackbar(
        parent: ViewGroup,
        content: OneflareSnackbarView
) : BaseTransientBottomBar<OneflareSnackbar>(parent, content, content) {

    init {
        getView().setBackgroundColor(ContextCompat.getColor(view.context, android.R.color.transparent))
        getView().setPadding(0, 0, 0, 0)
    }

    companion object {

        fun make(view: View, message: String): OneflareSnackbar {

            val parent = view.findSuitableParent() ?: throw IllegalArgumentException(
                    "No suitable parent found from the given view. Please provide a valid view."
            )

            val customView = LayoutInflater.from(view.context).inflate(
                    R.layout.layout_oneflare_snackbar,
                    parent,
                    false
            ) as OneflareSnackbarView

            val textView = customView.message
            textView.text = message

            return OneflareSnackbar(
                    parent,
                    customView
            )
        }

    }

}