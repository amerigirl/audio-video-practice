package com.example.audiovideoexample

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_video)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //create buttons
        val videoView = findViewById<VideoView>(R.id.videoView)

        val btnPlayVideo = findViewById<Button>(R.id.btnPlayVideo)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        //show file path
        val uri = Uri.parse("android.resource://$packageName/${R.raw.sample_video}")
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)

        btnPlayVideo.setOnClickListener {
            videoView.start()
        }
    }
}