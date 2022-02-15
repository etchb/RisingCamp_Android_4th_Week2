package com.bhongj.rc_weeks2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bhongj.rc_weeks2.databinding.FragmentTalkFriendBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TalkFriendFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TalkFriendFragment : Fragment() {
    private lateinit var _binding: FragmentTalkFriendBinding
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTalkFriendBinding.inflate(layoutInflater, container, false)


//        setHasOptionsMenu(true)

        return binding.root
    }
}