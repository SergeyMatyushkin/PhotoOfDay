package com.example.photoofday.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.photoofday.PictureViewModel
import com.example.photoofday.databinding.FragmentPictureOfTheDayBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class PictureOfTheDayFragment : Fragment() {
    private var _binding: FragmentPictureOfTheDayBinding? = null
    private val binding: FragmentPictureOfTheDayBinding get() = _binding!!

    private lateinit var pictureViewModel: PictureViewModel



    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        pictureViewModel = ViewModelProvider(this).get(PictureViewModel::class.java)
        _binding = FragmentPictureOfTheDayBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pictureViewModel.requestPicture()

        binding.apply {
            //объяснение (описание галактики) будет загружаться в bottomSheet
            pictureViewModel.pictureLiveDataDto.observe(viewLifecycleOwner)
            { picture ->
                bottomSheetTextView.text = picture.explanation

                if (picture.isImage) {
                    Glide.with(root)
                        .load(picture.url)
                        .centerCrop()
                        .into(imageView)
                }
                imageView.isVisible = picture.isImage
            }

            chipGroup.setOnCheckedChangeListener { _, _ ->
                pictureViewModel.requestPicture(
                    when {
                        todayChip.isChecked -> 0
                        yesterdayChip.isChecked -> -1
                        beforeYesterdayChip.isChecked -> -2
                        else -> 0
                    }
                )
            }


            inputLayout.setEndIconOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW).apply {
                    data =
                        Uri.parse(WIKIPEDIA+"${inputEditText.text.toString()}")
                })
            }


            bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetFrameLayout)

            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

            bottomSheetFrameLayout.setOnClickListener {
                bottomSheetBehavior.state = when (bottomSheetBehavior.state) {
                    BottomSheetBehavior.STATE_COLLAPSED -> BottomSheetBehavior.STATE_EXPANDED
                    BottomSheetBehavior.STATE_EXPANDED -> BottomSheetBehavior.STATE_COLLAPSED
                    else -> BottomSheetBehavior.STATE_EXPANDED
                }
            }
        }
    }

    companion object {
        const val TAG = "@@PictureOfTheDayFragment"
        const val WIKIPEDIA = "https://en.wikipedia.org/wiki/"

    }
}