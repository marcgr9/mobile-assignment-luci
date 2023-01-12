package ro.marc.meditation.data.repo

import androidx.lifecycle.LiveData
import ro.marc.meditation.data.db.entity.SessionEntity
import ro.marc.meditation.data.model.Session

interface SessionRepo {

    fun postSession(session: Session)

    fun getAll(): LiveData<List<SessionEntity>>

    fun updateLocation(id: Long, location: String)

    fun delete(id: Long)

}
