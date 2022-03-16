package com.example.comiaseokt.activity.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.comiaseokt.R
import com.example.comiaseokt.databinding.ActivityInicioBinding
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.GsonBuilder
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import java.sql.Date
import java.sql.Time


class InicioActivity : AppCompatActivity() {
    private var mAppBarConfiguration: AppBarConfiguration? = null
    private var binding: ActivityInicioBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
        setSupportActionBar(binding.appBarInicio.toolbar)

        val drawer: DrawerLayout = binding.drawerLayout
        val navigationView: NavigationView = binding.navView
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = Builder(
            R.id.nav_inicio, R.id.nav_mis_compras, R.id.nav_configuracion
        )
            .setDrawerLayout(drawer)
            .build()
        val navController = findNavController(this, R.id.nav_host_fragment_content_inicio)
        setupActionBarWithNavController(this, navController, mAppBarConfiguration!!)
        setupWithNavController(navigationView, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.inicio, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.cerrarSesion -> logout()
            R.id.bolsaCompras -> mostrarBolsa()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun mostrarBolsa() {
        val i = Intent(this, PlatillosCarritoActivity::class.java)
        startActivity(i)
        overridePendingTransition(R.anim.left_in, R.anim.left_out)
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    @SuppressLint("UnsafeExperimentalUsageError")
    private fun loadData() {
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val g = GsonBuilder()
            .registerTypeAdapter(Date::class.java, DateSerializer())
            .registerTypeAdapter(Time::class.java, TimeSerializer())
            .create()
        val usuarioJson = sp.getString("UsuarioJson", null)
        if (usuarioJson != null) {
            val u: Usuario = g.fromJson(usuarioJson, Usuario::class.java)
            val vistaHeader: View = binding.navView.getHeaderView(0)
            val tvNombre = vistaHeader.findViewById<TextView>(R.id.tvNombre)
            val tvCorreo = vistaHeader.findViewById<TextView>(R.id.tvCorreo)
            val imgFoto: CircleImageView = vistaHeader.findViewById(R.id.imgFotoPerfil)
            tvNombre.setText(u.getCliente().getNombreCompleto())
            tvCorreo.setText(u.getEmail())
            val url: String =
                ConfigApi.baseUrlE.toString() + "/api/documento-almacenado/download/" + u.getCliente()
                    .getFoto().getFileName()
            val picasso = Picasso.Builder(this)
                .downloader(OkHttp3Downloader(ConfigApi.getClient()))
                .build()
            picasso.load(url)
                .error(R.drawable.image_not_found)
                .into(imgFoto)
        }
        val badgeDrawable = BadgeDrawable.create(this)
        badgeDrawable.number = Carrito.getDetallePedidos().size()
        BadgeUtils.attachBadgeDrawable(badgeDrawable, findViewById(R.id.toolbar), R.id.bolsaCompras)
    }

    //Método para cerrar sesión
    private fun logout() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = preferences.edit()
        editor.remove("UsuarioJson")
        editor.apply()
        finish()
        overridePendingTransition(R.anim.left_in, R.anim.left_out)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(this, R.id.nav_host_fragment_content_inicio)
        return (navigateUp(navController, mAppBarConfiguration!!)
                || super.onSupportNavigateUp())
    }

    override fun onBackPressed() {}
}