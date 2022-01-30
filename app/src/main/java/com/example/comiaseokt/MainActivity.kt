package com.example.comiaseokt

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.comiaseokt.UserApplication.Companion.prefs
import com.example.comiaseokt.databinding.ActivityMainBinding
import com.example.comiaseokt.databinding.AppBarMainBinding
import com.example.comiaseokt.databinding.NavHeaderMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer:DrawerLayout
    private lateinit var toggle:ActionBarDrawerToggle

    private  lateinit var binding:ActivityMainBinding
   // private  lateinit var bindingN: AppBarMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer=binding.drawerLayout //findViewById(R.id.drawer_layout)
        toggle= ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)//Muestra Flecha
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView:NavigationView =binding.navView //findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        //codigo nuevo
        val hView = navigationView.getHeaderView(0)
        val funcionario: TextView = hView.findViewById<TextView>(R.id.nav_header_textView_Usr)
        funcionario.setText(prefs.getFuncionario())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_cConsulta-> {
                Toast.makeText(this,"Item1",Toast.LENGTH_LONG).show()
            }
            R.id.nav_item_pNuevo->{
                goToPedidoActivity()
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
    fun goToPedidoActivity(){
        startActivity(Intent(this,PedidoActivity::class.java))
    }
    override fun onPostCreate(savedInstanceState: Bundle?){
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}