package com.example.retrofit_practice

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_practice.databinding.ActivityMainBinding
import com.example.retrofit_practice.model.*
import retrofit2.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var requestItem: Item? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        doRadioButtonsSetting()

        binding.sendBtn.setOnClickListener{
            val apiService = AppClientManager.client.create(ApiService::class.java)

            when (requestItem) {
                Item.Posts -> {
                    apiService.getPosts().enqueue(object: Callback<List<Posts>> {
                        override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                            val stringBuffer = StringBuffer()
                            val list = response.body()
                            for (post in list!!) {
                                Log.d("ApiService", "Post: userid-${post.userId}, id-${post.id}")
                                stringBuffer.append("Title: " + post.title)
                                stringBuffer.append("\n\n")
                                stringBuffer.append("Body:" + post.body)
                                stringBuffer.append("\n\n")
                            }
                            binding.responseTv.text = stringBuffer.toString()
                        }

                        override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                            Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_LONG).show()
                        }
                    })
                }
                Item.Comments -> {
                    apiService.getComments().enqueue(object: Callback<List<Comments>> {
                        override fun onResponse(call: Call<List<Comments>>, response: Response<List<Comments>>) {
                            val stringBuffer = StringBuffer()
                            val list = response.body()
                            for (comment in list!!) {
                                Log.d("ApiService", "Comment: postId-${comment.postId}, id-${comment.id}")
                                stringBuffer.append("Name: " + comment.name + " Email: " + comment.email)
                                stringBuffer.append("\n\n")
                                stringBuffer.append("Body: " + comment.body)
                                stringBuffer.append("\n\n")
                            }
                            binding.responseTv.text = stringBuffer.toString()
                        }

                        override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                            Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_LONG).show()
                        }

                    })
                }
                Item.Albums -> {
                    apiService.getAlbums().enqueue(object: Callback<List<Albums>> {
                        override fun onResponse(call: Call<List<Albums>>, response: Response<List<Albums>>) {
                            val stringBuffer = StringBuffer()
                            val list = response.body()
                            for (album in list!!) {
                                Log.d("ApiService", "Album: userId-${album.userId}, id-${album.id}")
                                stringBuffer.append("Title: " + album.title)
                                stringBuffer.append("\n\n")
                            }
                            binding.responseTv.text = stringBuffer.toString()
                        }

                        override fun onFailure(call: Call<List<Albums>>, t: Throwable) {
                            Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_LONG).show()
                        }
                    })
                }
                Item.Photos -> {
                    apiService.getPhotos().enqueue(object: Callback<List<Photos>> {
                        override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                            val stringBuffer = StringBuffer()
                            val list = response.body()
                            for (photo in list!!) {
                                Log.d("ApiService", "Photo: userId-${photo.albumId}, id-${photo.id}")
                                stringBuffer.append("Title: " + photo.title)
                                stringBuffer.append("\n\n")
                                stringBuffer.append("Url: " + photo.url)
                                stringBuffer.append("\n\n")
                                stringBuffer.append("ThumbnailUrl: " + photo.thumbnailUrl)
                                stringBuffer.append("\n\n")
                            }
                            binding.responseTv.text = stringBuffer.toString()
                        }

                        override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
                            Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_LONG).show()
                        }
                    })
                }
                Item.Todos -> {
                    apiService.getTodos().enqueue(object: Callback<List<Todos>> {
                        override fun onResponse(call: Call<List<Todos>>, response: Response<List<Todos>>) {
                            apiService.getTodos().enqueue(object: Callback<List<Todos>> {
                                override fun onResponse(call: Call<List<Todos>>, response: Response<List<Todos>>) {
                                    val stringBuffer = StringBuffer()
                                    val list = response.body()
                                    for (todo in list!!) {
                                        Log.d("ApiService", "Todo: userId-${todo.userId}, id-${todo.id}")
                                        stringBuffer.append("Title: " + todo.title)
                                        stringBuffer.append("\n\n")
                                        stringBuffer.append("Complete: " + todo.completed)
                                        stringBuffer.append("\n\n")
                                    }
                                    binding.responseTv.text = stringBuffer.toString()
                                }

                                override fun onFailure(call: Call<List<Todos>>, t: Throwable) {
                                    Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_LONG).show()
                                }
                            })
                        }

                        override fun onFailure(call: Call<List<Todos>>, t: Throwable) {
                            Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_LONG).show()
                        }
                    })
                }
                Item.Users -> {
                    apiService.getUsers().enqueue(object: Callback<List<Users>> {
                        override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                            val stringBuffer = StringBuffer()
                            val list = response.body()
                            for (user in list!!) {
                                Log.d("ApiService", "id-${user.id}, name-${user.name}")
                                stringBuffer.append("Username: " + user.username)
                                stringBuffer.append("\n\n")
                                stringBuffer.append("Email: " + user.email)
                                stringBuffer.append("\n\n")
                                stringBuffer.append("Address: " + user.address.toString())
                                stringBuffer.append("\n\n")
                                stringBuffer.append("Phone: " + user.phone)
                                stringBuffer.append("\n\n")
                                stringBuffer.append("Website: " + user.website)
                                stringBuffer.append("\n\n")
                                stringBuffer.append("Company: " + user.company.toString())
                                stringBuffer.append("\n\n")
                            }
                            binding.responseTv.text = stringBuffer.toString()
                        }

                        override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                            Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_LONG).show()
                        }
                    })
                }
                null -> {
                    Toast.makeText(this@MainActivity, "Please select an item!", Toast.LENGTH_LONG).show()
                }
            }

        }
    }

    private fun doRadioButtonsSetting() {
        binding.postRadioBtn.setOnClickListener {
            requestItem = Item.Posts

            binding.albumRadioBtn.isChecked = false
            binding.todoRadioBtn.isChecked = false
            binding.commentsRadioBtn.isChecked = false
            binding.photoRadioBtn.isChecked = false
            binding.userRadioBtn.isChecked = false
        }

        binding.albumRadioBtn.setOnClickListener {
            requestItem = Item.Albums

            binding.postRadioBtn.isChecked = false
            binding.todoRadioBtn.isChecked = false
            binding.commentsRadioBtn.isChecked = false
            binding.photoRadioBtn.isChecked = false
            binding.userRadioBtn.isChecked = false
        }

        binding.todoRadioBtn.setOnClickListener {
            requestItem = Item.Todos

            binding.postRadioBtn.isChecked = false
            binding.albumRadioBtn.isChecked = false
            binding.commentsRadioBtn.isChecked = false
            binding.photoRadioBtn.isChecked = false
            binding.userRadioBtn.isChecked = false
        }

        binding.commentsRadioBtn.setOnClickListener {
            requestItem = Item.Comments

            binding.postRadioBtn.isChecked = false
            binding.albumRadioBtn.isChecked = false
            binding.todoRadioBtn.isChecked = false
            binding.photoRadioBtn.isChecked = false
            binding.userRadioBtn.isChecked = false
        }

        binding.photoRadioBtn.setOnClickListener {
            requestItem = Item.Photos

            binding.postRadioBtn.isChecked = false
            binding.albumRadioBtn.isChecked = false
            binding.todoRadioBtn.isChecked = false
            binding.commentsRadioBtn.isChecked = false
            binding.userRadioBtn.isChecked = false
        }

        binding.userRadioBtn.setOnClickListener {
            requestItem = Item.Users

            binding.postRadioBtn.isChecked = false
            binding.albumRadioBtn.isChecked = false
            binding.todoRadioBtn.isChecked = false
            binding.commentsRadioBtn.isChecked = false
            binding.photoRadioBtn.isChecked = false
        }
    }
}

enum class Item {
    Posts, Albums, Todos, Comments, Photos, Users
}