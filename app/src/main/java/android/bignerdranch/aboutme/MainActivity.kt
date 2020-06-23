package android.bignerdranch.aboutme

import android.bignerdranch.aboutme.databinding.ActivityMainBinding
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val myName: MyName = MyName("Alexandr Sozonov")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
        binding.myName = myName

    }
    private fun addNickname(view: View){
        binding.apply { //nicknameText.text = binding.nickName.text
                        myName?.nickName = nickName.text.toString()
                        invalidateAll()
                        nickName.visibility  = View.GONE
                        doneButton.visibility = View.GONE
                        nicknameText.visibility = View.VISIBLE



        }
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


}