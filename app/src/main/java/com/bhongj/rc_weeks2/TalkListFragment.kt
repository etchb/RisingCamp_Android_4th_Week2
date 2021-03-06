package com.bhongj.rc_weeks2

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhongj.rc_weeks2.databinding.FragmentTalkListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TalkListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TalkListFragment : Fragment() {
    private lateinit var _binding: FragmentTalkListBinding
    private val binding get() = _binding!!
    private lateinit var adapter: TalkListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTalkListBinding.inflate(layoutInflater, container, false)

        setHasOptionsMenu(true)

        val talkListRcyView = binding.rcyTalkList
        talkListRcyView.layoutManager = LinearLayoutManager(context)
        adapter = TalkListAdapter(TalkListItemList)
        talkListRcyView.adapter = adapter

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(context, "onStart_Fragment", Toast.LENGTH_SHORT).show()

        binding.talkListImgTalkBanner.setImageResource(BannerListItemList[bannerIdx].imgRsc)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
    }
}