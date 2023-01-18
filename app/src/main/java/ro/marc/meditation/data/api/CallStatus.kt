package ro.marc.meditation.data.api

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity


sealed class CallStatus<T>(val genericResponseDTO: GenericResponseDTO<T>?) {
    
    class Success<T>(genericResponseDTO: GenericResponseDTO<T>) : CallStatus<T>(genericResponseDTO)

    class Loading<T> : CallStatus<T>(null)

    class Error<T> : CallStatus<T>(null)

    companion object {

        data class LayoutAffectedByApiCall(
            val activity: AppCompatActivity,
            var progressBar: ProgressBar? = null,
            var disappearingViewsWhileLoading: List<View>? = null,
        )

        fun manageCallStatus(
            callStatus: CallStatus<*>,
            layout: LayoutAffectedByApiCall,
        ): Boolean {
            when (callStatus) {
                is Loading -> {
                    layout.disappearingViewsWhileLoading?.forEach {
                        it.visibility = View.INVISIBLE
                    }
                    layout.progressBar?.visibility = View.VISIBLE
                }
                is Success, is Error -> {
                    layout.disappearingViewsWhileLoading?.forEach {
                        it.visibility = View.VISIBLE
                    }
                    layout.progressBar?.visibility = View.INVISIBLE
                }
            }

            return true
        }
    }
}
