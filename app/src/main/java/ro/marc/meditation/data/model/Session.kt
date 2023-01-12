package ro.marc.meditation.data.model

import ro.marc.meditation.data.db.entity.SessionEntity

data class Session(

    val id: Long? = null,

    val location: String = "",

    val durationInSeconds: Int = 0,

) {

    companion object {

        fun from(sessionEntity: SessionEntity) = Session(
            sessionEntity.id,
            sessionEntity.location,
            sessionEntity.durationInSeconds,
        )

    }

}
