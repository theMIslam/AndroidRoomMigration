package com.example.androidroommigration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "users.db"
        ).addMigrations(UserDatabase.migration3To4).build()

        lifecycleScope.launch {
            db.dao.getSchools().forEach(::println)
        }

//        (1..10).forEach {
//            lifecycleScope.launch {
//                db.dao.insertSchool(
//                    School(
//                        name = "test$it"
//                    )
//                )
//            }
//        }
    }
}