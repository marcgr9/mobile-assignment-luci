package ro.marc.meditation.data.repo.impl

import ro.marc.meditation.data.db.dao.SessionDAO
import ro.marc.meditation.data.db.entity.SessionEntity
import ro.marc.meditation.data.model.Session
import ro.marc.meditation.data.repo.LocalSessionRepo


class LocalSessionRepoImpl(
    private val sessionDAO: SessionDAO
): LocalSessionRepo {

    override fun postSession(session: Session) {
        sessionDAO.save(SessionEntity.from(session))
    }

    override fun getAll(): List<Session> = sessionDAO.fetch().map(Session::from)

    override fun updateLocation(id: Long, location: String) {
        sessionDAO.updateLocation(id, location)
    }

    override fun delete(id: Long) {
        sessionDAO.delete(id)
    }

}