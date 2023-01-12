package ro.marc.meditation

import android.content.Context
import android.widget.Toast
import ro.marc.meditation.data.model.Session
import ro.marc.meditation.databinding.CompSessionItemBinding

object Utils {

    fun toast(ctx: Context, stringResId: Int) {
        Toast.makeText(ctx, ctx.getString(stringResId), Toast.LENGTH_SHORT).show()
    }

    fun formatSeconds(seconds: Int) = String.format(
        "%02d:%02d",
        (seconds % 3600) / 60,
        seconds % 60,
    )

    fun fillSessionsCard(item: CompSessionItemBinding, session: Session) {
        item.time.text = formatSeconds(session.durationInSeconds)
        item.location.text = session.location
    }

}