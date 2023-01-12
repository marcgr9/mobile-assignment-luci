package ro.marc.meditation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import ro.marc.meditation.MainActivity
import ro.marc.meditation.MainActivityVM
import ro.marc.meditation.adapters.SessionsAdapter
import ro.marc.meditation.databinding.FragMainProgressBinding

class MainProgress: Fragment() {

    private lateinit var activity: MainActivity
    private lateinit var vm: MainActivityVM
    private var _binding: FragMainProgressBinding? = null
    private val binding get() = _binding!!

    private val sessionsAdapter = SessionsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity = requireActivity() as MainActivity
        val injectedViewModel by sharedViewModel<MainActivityVM>()
        vm = injectedViewModel
        _binding = FragMainProgressBinding.inflate(inflater, container, false)

        binding.sessionsList.apply {
            adapter = sessionsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        sessionsAdapter.addSessions(vm.getSessions())

        return binding.root
    }

}