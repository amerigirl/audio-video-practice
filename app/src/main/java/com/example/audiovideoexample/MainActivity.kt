package com.example.audiovideoexample

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.audiovideoexample.R.*
import com.example.audiovideoexample.R.id.btnPlayVideo

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnPlayAudio = findViewById<Button>(id.btnPlayAudio)
        val btnStopAudio = findViewById<Button>(id.btnStopAudio)
        val btnPlayVideo = findViewById<Button>(id.btnPlayVideo)

        mediaPlayer = MediaPlayer.create(this, raw.sample_audio)

        btnPlayAudio.setOnClickListener {
            if(!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }

        btnStopAudio.setOnClickListener {
            if(mediaPlayer.isPlaying) {
            mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
        }

        btnPlayVideo.setOnClickListener {
            startActivity(Intent(this, VideoActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}