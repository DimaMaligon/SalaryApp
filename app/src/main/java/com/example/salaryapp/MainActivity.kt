package com.example.salaryapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.salaryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSalary.setOnClickListener {
            var passwordInput: String? = binding.inputPassword.text.toString()
            var surname: String? = binding.inputSurname.text.toString()
            if (surname != "" && passwordInput != "") {
                when (surname) {
                    Constance.DIRECTOR -> {
                        if (checkPassword(passwordInput?.toInt(), Constance.DIRECTOR_PASSWORD)) {
                            showSubscriptions("${Constance.DIRECTOR_SALARY}")
                            showImagePerson(R.drawable.childface)
                        } else showSubscriptions("Неверный пароль")
                    }
                    Constance.MANAGER -> {
                        if (checkPassword(passwordInput?.toInt(), Constance.MANAGER_PASSWORD)) {
                            showSubscriptions("${Constance.MANAGER_SALARY}")
                        } else showSubscriptions("Неверный пароль")
                    }
                    Constance.ENGINEER -> {
                        if (checkPassword(passwordInput?.toInt(), Constance.ENGINEER_PASSWORD)) {
                            showSubscriptions("${Constance.ENGINEER_SALARY}")
                        } else showSubscriptions("Неверный пароль")
                    }
                }
            } else {
                showSubscriptions("Неверная фамилия или пароль")
            }
        }
    }

    fun showSubscriptions(text: String) {
        binding.textMessage.visibility = View.VISIBLE
        binding.textMessage.text = text
    }

    fun showImagePerson(path : Int) {
        binding.imageView.visibility = View.VISIBLE
        binding.imageView.setImageResource(path)
    }

    fun checkPassword(passwordInput: Int?, passwordCorrected: Int): Boolean {
        return passwordInput == passwordCorrected
    }

    object Constance {
        const val DIRECTOR_SALARY = 100000
        const val ENGINEER_SALARY = 20000
        const val MANAGER_SALARY = 30000

        const val DIRECTOR = "Ivanov"
        const val ENGINEER = "Petrov"
        const val MANAGER = "Sidorov"

        const val DIRECTOR_PASSWORD = 4568
        const val ENGINEER_PASSWORD = 4569
        const val MANAGER_PASSWORD = 4567
    }
}
