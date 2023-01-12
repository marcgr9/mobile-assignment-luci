package ro.marc.meditation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ro.marc.meditation.Utils
import ro.marc.meditation.data.model.Session
import ro.marc.meditation.databinding.CompSessionItemBinding

class SessionsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var _sessions: MutableList<Session> = mutableListOf()

    val sessions: List<Session>
        get() = _sessions

    @SuppressLint("NotifyDataSetChanged")
    fun addSessions(sessions: List<Session>) {
        this._sessions.addAll(sessions)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearSessions() {
        this._sessions.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val compTranItemBinding = CompSessionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RequestViewHolder(compTranItemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RequestViewHolder).bind(_sessions[position])
    }

    override fun getItemCount(): Int = _sessions.size

    class RequestViewHolder(private val sessionItem: CompSessionItemBinding) : RecyclerView.ViewHolder(sessionItem.root) {

        fun bind(session: Session) {
            Utils.fillSessionsCard(sessionItem, session)
        }
    }
    
}