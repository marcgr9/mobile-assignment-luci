package ro.marc.meditation.data.repo.impl

import androidx.lifecycle.LiveData
import ro.marc.meditation.data.db.dao.SessionDAO
import ro.marc.meditation.data.db.entity.SessionEntity
import ro.marc.meditation.data.model.Session
import ro.marc.meditation.data.repo.SessionRepo

class SessionRepoImpl(
    private val sessionDAO: SessionDAO
): SessionRepo {

    override fun postSession(session: Session) {
        sessionDAO.save(SessionEntity.from(session))
    }

    override fun getAll(): LiveData<List<SessionEntity>> = sessionDAO.fetch()

    override fun updateLocation(id: Long, location: String) {
        sessionDAO.updateLocation(id, location)
    }

    override fun delete(id: Long) {
        sessionDAO.delete(id)
    }

}