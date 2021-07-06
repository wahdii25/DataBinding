package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingSource : ActivityMainBinding
    private var aPerson : Person = Person("ali", "980525123456", "ali@gmail.com","21,Taman Ali")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindingSource = DataBindingUtil.setContentView(this,R.layout.activity_main)
        bindingSource.personData = aPerson

//        bindingSource.tvName.text = aPerson.name
//        bindingSource.tvIC.text = aPerson.ic
//        bindingSource.tvEmail.text = aPerson.email
//        bindingSource.tvAddress.text = aPerson.address

        bindingSource.btnUpdate.setOnClickListener(){
            aPerson.email = "aliNewEmail@gmail.com"
            bindingSource.apply { invalidateAll() }
        }

    }
}