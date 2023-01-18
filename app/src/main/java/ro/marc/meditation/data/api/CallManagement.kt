package ro.marc.meditation.data.api

import androidx.lifecycle.MutableLiveData
import retrofit2.Response


object CallManagement {
    
    fun <T> manageOnResponse(response: Response<GenericResponseDTO<T>>, callStatus: MutableLiveData<CallStatus<T>>) {
        if (!response.isSuccessful) {
            println("Invalid request for some reason: $response")
            return
        }

        callStatus.value = CallStatus.Success(response.body()!!)
    }
    
    fun <T> manageOnFailure(t: Throwable, callStatus: MutableLiveData<CallStatus<T>>) {
        println("Failed, see throwable below")
        t.printStackTrace()
        callStatus.value = CallStatus.Error()
    }
}