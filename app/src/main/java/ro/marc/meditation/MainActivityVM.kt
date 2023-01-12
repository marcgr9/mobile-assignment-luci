package ro.marc.meditation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ro.marc.meditation.data.model.Session
import ro.marc.meditation.data.repo.SessionRepo

class MainActivityVM(
    private val sessionRepo: SessionRepo,
): ViewModel() {

    fun postSession(session: Session) {
        sessionRepo.postSession(session)
    }

    fun getSessions(): List<Session> = sessionRepo.getAll()

}
