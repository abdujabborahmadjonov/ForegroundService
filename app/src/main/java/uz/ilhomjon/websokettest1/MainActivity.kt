package uz.ilhomjon.websokettest1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import uz.ilhomjon.websokettest1.databinding.ActivityMainBinding
import uz.ilhomjon.websokettest1.service.MyForegroundService
import uz.ilhomjon.websokettest1.utils.MyData

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.apply {

            MyData.liveData.observe(this@MainActivity){
                tvInfo.text = it
            }

            btnStart.setOnClickListener {
                val serviceIntent = Intent(this@MainActivity, MyForegroundService::class.java)
                ContextCompat.startForegroundService(this@MainActivity, serviceIntent)
            }
            btnStop.setOnClickListener {
                val serviceIntent = Intent(this@MainActivity, MyForegroundService::class.java)
                stopService(serviceIntent)
            }
        }
    }


}