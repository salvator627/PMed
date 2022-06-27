package com.example.pmed.UIFragment


import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import com.example.pmed.databinding.FragmentCameraBinding


class fragment_camera : Fragment() {

    private var imageCapture: ImageCapture? = null
    private var cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

     private var _binding: FragmentCameraBinding? = null
     private val binding get() =_binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCameraBinding.inflate(inflater,container,false)
        return binding.root

    }

}