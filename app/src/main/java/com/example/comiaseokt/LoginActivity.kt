package com.example.comiaseokt


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.example.comiaseokt.UserApplication.Companion.prefs
import com.example.comiaseokt.api.ApiServicioLogin
import com.example.comiaseokt.databinding.ActivityLoginBinding
import com.example.comiaseokt.response.LoginResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class LoginActivity   :  AppCompatActivity (){
    // Declaring layout button, edit texts
    var UserNameStr: String? = null
    var PasswordStr: String? = null
    //var progressBar: ProgressBar? = null


    private  lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

      //  val btn_login:Button=binding.btnLogin
      //  val ET_Username:EditText=binding.ETUsername
      //  val ET_Password:EditText=binding.ETPassword
        val progressBar:ProgressBar=binding.progressBar


        progressBar.setVisibility(View.GONE)

            initUI()

    }

    private fun initUI() {
        binding.btnLogin.setOnClickListener {Login() }
    }

    private  fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://190.12.55.2:9092/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
private fun searchByName(usr:String, pwd:String){
CoroutineScope(Dispatchers.IO).launch {
       val call: Response<LoginResponse> = getRetrofit().create(ApiServicioLogin::class.java).getLogin("$usr","$pwd")
       val res: LoginResponse?=call.body()
        runOnUiThread {
           if(call.isSuccessful){
                //carga variables
                //val c_funcionario:String=ppupies?.cfuncionario.toString()
               prefs.saveC_Funcionario(res?.cfuncionario.toString())
               prefs.saveFuncionario(res?.funcionario.toString())
               prefs.saveC_Punto_Venta(res?.cpuntoventa.toString())
               prefs.savePunto(res?.punto.toString())
               prefs.saveC_BODEGA(res?.cbodega.toString())
               prefs.saveCod_Pedidos(res?.codpedidos.toString())

               val puntoventa:String=res?.cpuntoventa.toString()
               Log.d("C_Funcionairo",prefs.getCFuncionario())
               Log.d("Funcionairo", prefs.getFuncionario())
               Log.d("C_Punto_Venta", prefs.getCPuntoVenta())
               Log.d("Punto",prefs.getPunto())
               Log.d("C_Bodega",prefs.getCBodega())
               Log.d("Cod_Pedidos", prefs.getCodPedidos())

                if(puntoventa.isEmpty()){
                    goToPuntoActivity()
                }else {
                    goToMainActivity()
                }
            }else{
                //muestra error
               showError()
           }
        }

    }
}
    private fun showError(){
        Toast.makeText(this,"Revisar usuario o contraseña", Toast.LENGTH_LONG).show()
    }
    fun Login() {

        UserNameStr = binding.ETUsername.text.toString()
        PasswordStr= Hash.sha1(binding.ETPassword.text.toString())
    //PasswordStr=dc.Hash.sha1(binding.ETPassword.text.toString())
        //PasswordStr = MessageDigest.getInstance("SHA-1",binding.ETPassword.text.toString()).toString()
        searchByName(UserNameStr!!,PasswordStr!!)
    }
fun goToMainActivity(){
    startActivity(Intent(this, MainActivity::class.java))
}
    fun goToPuntoActivity(){
        startActivity(Intent(this, PuntoActivity::class.java))
    }
    fun salir() {
        finish()
    }

    object Hash {
        /* Retorna un hash a partir de un tipo y un texto */
        fun getHash(txt: String, hashType: String?): String? {
            try {
                val md = MessageDigest
                    .getInstance(hashType)
                val array = md.digest(txt.toByteArray())
                val sb = StringBuffer()
                for (i in array.indices) {
                    sb.append(Integer.toHexString((array[i].toInt() and  0xFF )or  0x100)
                            .substring(1, 3))
                }
                return sb.toString()
            } catch (e: NoSuchAlgorithmException) {
                println(e.message)
            }
            return null
        }

        /* Retorna un hash MD5 a partir de un texto */
        fun md5(txt: String): String? {
            return getHash(txt, "MD5")
        }

        /* Retorna un hash SHA1 a partir de un texto */
        fun sha1(txt: String): String? {
            return getHash(txt, "SHA1")
        }
    }

}