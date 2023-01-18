package ro.marc.meditation.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ro.marc.meditation.data.api.CallManagement
import ro.marc.meditation.data.api.CallStatus
import ro.marc.meditation.data.api.GenericResponseDTO
import ro.marc.meditation.data.dto.ChangeLocationDTO
import ro.marc.meditation.data.dto.SessionDTO
import ro.marc.meditation.data.service.SessionsService

class SessionsRepo(
    private val sessionsService: SessionsService,
) {

    fun getAll(): LiveData<CallStatus<List<SessionDTO>>> {
        val callStatus = MutableLiveData<CallStatus<List<SessionDTO>>>()
        callStatus.value = CallStatus.Loading()

        sessionsService.getAll().enqueue(object :
            Callback<GenericResponseDTO<List<SessionDTO>>> {
            override fun onResponse(
                call: Call<GenericResponseDTO<List<SessionDTO>>>,
                response: Response<GenericResponseDTO<List<SessionDTO>>>
            ) {
                CallManagement.manageOnResponse(response, callStatus)
            }

            override fun onFailure(
                call: Call<GenericResponseDTO<List<SessionDTO>>>,
                t: Throwable
            ) {
                CallManagement.manageOnFailure(t, callStatus)
            }

        })

        return callStatus
    }


    fun postSession(session: SessionDTO): LiveData<CallStatus<SessionDTO>> {
        val callStatus = MutableLiveData<CallStatus<SessionDTO>>()
        callStatus.value = CallStatus.Loading()

        sessionsService.postSession(session).enqueue(object : Callback<GenericResponseDTO<SessionDTO>> {
            override fun onResponse(
                call: Call<GenericResponseDTO<SessionDTO>>,
                response: Response<GenericResponseDTO<SessionDTO>>
            ) {
                CallManagement.manageOnResponse(response, callStatus)
            }

            override fun onFailure(
                call: Call<GenericResponseDTO<SessionDTO>>,
                t: Throwable
            ) {
                CallManagement.manageOnFailure(t, callStatus)
            }

        })

        return callStatus
    }

    fun changeLocation(id: Long, dto: ChangeLocationDTO): LiveData<CallStatus<SessionDTO>> {
        val callStatus = MutableLiveData<CallStatus<SessionDTO>>()
        callStatus.value = CallStatus.Loading()

        sessionsService.changeLocation(id, dto).enqueue(object : Callback<GenericResponseDTO<SessionDTO>> {
            override fun onResponse(
                call: Call<GenericResponseDTO<SessionDTO>>,
                response: Response<GenericResponseDTO<SessionDTO>>
            ) {
                CallManagement.manageOnResponse(response, callStatus)
            }

            override fun onFailure(
                call: Call<GenericResponseDTO<SessionDTO>>,
                t: Throwable
            ) {
                CallManagement.manageOnFailure(t, callStatus)
            }

        })

        return callStatus
    }

    fun remove(id: Long): LiveData<CallStatus<Void>> {
        val callStatus = MutableLiveData<CallStatus<Void>>()
        callStatus.value = CallStatus.Loading()

        sessionsService.delete(id).enqueue(object : Callback<GenericResponseDTO<Void>> {
            override fun onResponse(
                call: Call<GenericResponseDTO<Void>>,
                response: Response<GenericResponseDTO<Void>>
            ) {
                CallManagement.manageOnResponse(response, callStatus)
            }

            override fun onFailure(
                call: Call<GenericResponseDTO<Void>>,
                t: Throwable
            ) {
                CallManagement.manageOnFailure(t, callStatus)
            }

        })

        return callStatus
    }

}