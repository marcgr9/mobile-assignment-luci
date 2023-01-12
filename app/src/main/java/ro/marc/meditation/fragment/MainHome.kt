package ro.marc.meditation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import ro.marc.meditation.MainActivity
import ro.marc.meditation.MainActivityVM
import ro.marc.meditation.databinding.FragMainHomeBinding


class MainHome: Fragment() {

    private lateinit var activity: MainActivity
    private lateinit var vm: MainActivityVM
    private var _binding: FragMainHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity = requireActivity() as MainActivity
        val injectedViewModel by sharedViewModel<MainActivityVM>()
        vm = injectedViewModel
        _binding = FragMainHomeBinding.inflate(inflater, container, false)

        binding.meditate.setOnClickListener {
            activity.navigateFromHomeToTimer()
        }
        
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}
