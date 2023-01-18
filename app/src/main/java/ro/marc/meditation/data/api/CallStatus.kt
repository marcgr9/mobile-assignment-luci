package ro.marc.meditation.data.api

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity


sealed class CallStatus<T>(val genericResponseDTO: GenericResponseDTO<T>?) {
    
    class Success<T>(genericResponseDTO: GenericResponseDTO<T>) : CallStatus<T>(genericResponseDTO)

    class Loading<T> : CallStatus<T>(null)

    class Error<T> : CallStatus<T>(null)

}
