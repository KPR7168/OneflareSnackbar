package au.com.oneflare.businessapp.ui.views.snackbar.extension

import androidx.coordinatorlayout.widget.CoordinatorLayout
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

internal fun View?.findSuitableParent(): ViewGroup? {

    var view = this
    var suitableParent: ViewGroup? = null

    do {
        if (view is androidx.coordinatorlayout.widget.CoordinatorLayout) {
            return view
        } else if (view is FrameLayout) {
            if (view.id == android.R.id.content) {
                return view
            } else {
                suitableParent = view
            }
        }

        if (view != null) {
            val parent = view.parent
            view = if (parent is View) parent else null
        }
    } while (view != null)

    return suitableParent
}