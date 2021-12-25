package com.example.rsswithretrofit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class MainActivity : AppCompatActivity() {
    lateinit var mainRV: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainRV = findViewById(R.id.rvMain)
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        apiInterface!!.getArchFeed().enqueue(object : Callback<Feed> {
            override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
                updateRV(response.body()!!.entries)
            }

            override fun onFailure(call: Call<Feed>, t: Throwable) {
                call.cancel()
            }
        })
    }

    private fun updateRV(entries: List<Entry>?) {
        mainRV.adapter = RVAdapter(entries)
        mainRV.layoutManager = LinearLayoutManager(applicationContext)
    }
}