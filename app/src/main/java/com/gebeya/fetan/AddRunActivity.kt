package com.gebeya.fetan

import android.os.Bundle
import androidx.room.Room
import com.gebeya.fetan.data.AppDatabase
import com.gebeya.fetan.data.model.Run
import com.gebeya.fetan.framework.base.BaseActivity
import com.gebeya.fetan.framework.util.DATABASE_NAME
import kotlinx.android.synthetic.main.activity_add_run.*
import java.util.*

class AddRunActivity : BaseActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_run)
        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            DATABASE_NAME
        ).allowMainThreadQueries()
            .build()

        val runs = db.runDao().getAll()
        for (run in runs) {
            d(run.toString())
        }

        val run = Run(distance = 3000.0, time = 60, createdAt = Date().toString())
        db.runDao().addRun(run)

        addRunSaveButton.setOnClickListener {
            finish()
        }
    }
}