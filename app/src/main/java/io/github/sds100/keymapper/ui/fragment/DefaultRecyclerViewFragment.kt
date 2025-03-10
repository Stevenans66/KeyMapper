package io.github.sds100.keymapper.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.bottomappbar.BottomAppBar
import io.github.sds100.keymapper.databinding.FragmentRecyclerviewBinding

/**
 * Created by sds100 on 22/02/2020.
 */
abstract class DefaultRecyclerViewFragment : RecyclerViewFragment<FragmentRecyclerviewBinding>() {

    override val appBar: BottomAppBar
        get() = binding.appBar

    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentRecyclerviewBinding.inflate(inflater, container, false).apply {
            progressCallback = this.progressCallback
            lifecycleOwner = viewLifecycleOwner
        }
}