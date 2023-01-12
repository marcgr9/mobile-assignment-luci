package ro.marc.meditation

import android.content.Context
import android.widget.Toast

object Utils {

    fun toast(ctx: Context, stringResId: Int) {
        Toast.makeText(ctx, ctx.getString(stringResId), Toast.LENGTH_SHORT).show()
    }

}