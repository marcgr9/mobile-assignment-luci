package ro.marc.meditation.data.repo

import ro.marc.meditation.data.model.Session


interface SessionRepo {

    fun postSession(session: Session)

    fun getAll(): List<Session>

    fun updateLocation(id: Long, location: String)

    fun delete(id: Long)

}
