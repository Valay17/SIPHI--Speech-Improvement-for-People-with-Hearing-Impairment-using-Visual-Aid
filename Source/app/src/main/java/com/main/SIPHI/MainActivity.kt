package com.main.SIPHI

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.IOException

import android.annotation.TargetApi as TargetApi1

class MainActivity : AppCompatActivity() {

    var titleName: String? = "Admin"

    lateinit var etDisplayText: EditText
    lateinit var btnLogout: Button
    lateinit var btnSend: Button



    lateinit var btnStart: Button
    lateinit var btnStop: Button
    lateinit var btnPause: Button


    lateinit var btnPlay: Button

    lateinit var sharedPreferences: SharedPreferences

    private var audiofilepath: String? = null
    private var mediaRecorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null
    private var state: Boolean = false
    private var recordingStopped: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_main)

        //Providing the title name as the respective user login

        titleName = sharedPreferences.getString("Title", "The Admin")
        title = titleName


        //getting the R id of the edits and buttons
        etDisplayText = findViewById(R.id.etDisplayText)
        btnSend = findViewById(R.id.btnSend)

        btnLogout = findViewById(R.id.btnLogout)

        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)
        btnPause = findViewById(R.id.btnPause)


        btnPlay = findViewById(R.id.btnPlay)

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            val permissions = arrayOf(
                android.Manifest.permission.RECORD_AUDIO,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
            ActivityCompat.requestPermissions(this, permissions, 0)
        }

        mediaRecorder = MediaRecorder()
        audiofilepath = Environment.getExternalStorageDirectory().absolutePath + "/myrec.aac"



        btnStart.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.RECORD_AUDIO
                ) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                val permissions = arrayOf(
                    android.Manifest.permission.RECORD_AUDIO,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                )
                ActivityCompat.requestPermissions(this, permissions, 0)
            } else {
                startRecording()
            }
        }

        btnStop.setOnClickListener {
            stopRecording()
        }

        btnPause.setOnClickListener {
            pauseRecording()
        }

        btnPlay.setOnClickListener {
            playAudio()
        }


        btnSend.setOnClickListener {

            val displayText = etDisplayText.text.toString()
            val intent = Intent(this@MainActivity, AnalysisActivity::class.java)
            intent.putExtra("Display", displayText)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }

        val gifText = findViewById<EditText>(R.id.gifEditText)

//        val gifImage = findViewById<ImageView>(R.id.gifImageView)  //Not working


        val gifImage = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.gifImageView)


        gifText.setOnEditorActionListener { _, _, _ ->
            val gifName = gifText.text.toString().lowercase()
            val imageResourceId = when (gifName) {
                "family" -> R.drawable.gif_family
                "deaf" -> R.drawable.gif_deaf
                "help" -> R.drawable.gif_help
                "hospital" -> R.drawable.gif_hospital
                "injured" -> R.drawable.gif_injured
                "relax" -> R.drawable.gif_relax
                "sleep" -> R.drawable.gif_sleep
                "taxi" -> R.drawable.gif_taxi
                "thank you" -> R.drawable.gif_thankyou
                "toilet" -> R.drawable.gif_toilet
                "water" -> R.drawable.gif_water

                else -> R.drawable.gif_hello // fallback image
            }
            gifImage.setImageResource(imageResourceId)
            true
        }

    }

    fun startRecording() {
        btnPlay.isEnabled = true
        try {
            mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.DEFAULT)
            mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS)
            mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            mediaRecorder?.setOutputFile(audiofilepath)

            mediaRecorder?.prepare()
            mediaRecorder?.start()
            state = true
            btnStart.isEnabled = false
            btnStop.isEnabled = true
            Toast.makeText(this, "Recording started!", Toast.LENGTH_SHORT).show()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    @SuppressLint("RestrictedApi", "SetTextI18n")
    @TargetApi1(Build.VERSION_CODES.N)
    fun pauseRecording() {
        if (state) {
            if (!recordingStopped) {
                Toast.makeText(this, "Stopped!", Toast.LENGTH_LONG).show()
                mediaRecorder?.pause()
                recordingStopped = true
                btnPause.text = "Resume"
            } else {
                resumeRecording()
            }
        }
    }

    @SuppressLint("RestrictedApi", "SetTextI18n")
    @TargetApi1(Build.VERSION_CODES.N)
    fun resumeRecording() {
        Toast.makeText(this, "Resume!", Toast.LENGTH_LONG).show()
        mediaRecorder?.resume()
        btnPause.text = "Pause"
        recordingStopped = false
    }

    fun stopRecording() {

        if (state) {
            mediaRecorder?.stop()
            mediaRecorder?.release()
            mediaRecorder = null
            state = false
            btnStart.isEnabled = true
        } else {
            btnStart.isEnabled = true
            Toast.makeText(this, "You are not recording right now!", Toast.LENGTH_LONG).show()
        }

    }

    fun playAudio() {
        btnPlay.isEnabled = false


        mediaPlayer = MediaPlayer()
        mediaPlayer?.setDataSource(audiofilepath)
        mediaPlayer?.prepare()
        mediaPlayer?.start()

        Toast.makeText(this, "Playing Audio!", Toast.LENGTH_LONG).show()
    }



}

//We can add the logout --> Done --> cleared the cache SP and it will log out the user --> Done
