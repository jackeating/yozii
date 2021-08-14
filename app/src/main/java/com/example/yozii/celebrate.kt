package com.example.yozii

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.yozii.databinding.ActivityCelebrateBinding
import com.google.android.material.snackbar.Snackbar
import nl.dionsegijn.konfetti.models.Shape

class celebrate : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCelebrateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCelebrateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val drawable = ContextCompat.getDrawable(applicationContext, R.drawable.ic_heart)
        val drawableShape = drawable?.let { Shape.DrawableShape(it, true) }
        val konfettiView = findViewById<nl.dionsegijn.konfetti.KonfettiView>(R.id.viewKonfetti)
        konfettiView.build()
            .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(2000L)
            .addShapes(nl.dionsegijn.konfetti.models.Shape.Square, nl.dionsegijn.konfetti.models.Shape.Circle, drawableShape!!)
            .addSizes(nl.dionsegijn.konfetti.models.Size(12, 5f))
            .setPosition(-50f, konfettiView.width + 50f, -50f, -50f)
            .streamFor(300, 5000L)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_celebrate)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}