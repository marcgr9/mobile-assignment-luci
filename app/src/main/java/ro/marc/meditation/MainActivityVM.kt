package ro.marc.meditation

import androidx.lifecycle.ViewModel
import ro.marc.meditation.data.model.Session
import ro.marc.meditation.data.repo.LocalSessionRepo
import ro.marc.meditation.data.repo.SessionsRepo


class MainActivityVM(
    private val localSessionRepo: LocalSessionRepo,
    private val sessionsRepo: SessionsRepo,
): ViewModel() {

    fun postSession(session: Session) {
        localSessionRepo.postSession(session)
    }

    fun getSessions(): List<Session> = localSessionRepo.getAll()

    fun removeSession(id: Long) {
        localSessionRepo.delete(id)
    }

    fun updateLocation(id: Long, location: String) {
        localSessionRepo.updateLocation(id, location)
    }

}
