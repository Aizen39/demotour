package fr.pageup.demoapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import fr.pageup.demoapp.R

/**
 * Simplement un splashscreen avec le logo de l'entreprise
 */
class SplashActivity() : AppCompatActivity() {

    //temps de chargement du splash avant d'ouvrir le MainActivity
    private val delay= 3000

    //Création de la vue
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        //Lancement du MainActivity tardif
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, delay.toLong())
    }
}
