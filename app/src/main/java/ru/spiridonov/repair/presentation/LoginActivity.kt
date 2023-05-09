package ru.spiridonov.repair.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.spiridonov.repair.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private lateinit var viewModel: AccountViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[AccountViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        buttonListener()
        addTextChangeListeners()
        observeViewModel()
    }

    private fun buttonListener() = with(binding) {
        login.setOnClickListener {
            loading.visibility = View.VISIBLE
            viewModel!!.login(
                viewModel!!.parseStroke(etEmail.text.toString()),
                viewModel!!.parseStroke(etPassword.text.toString())
            )
        }
    }

    private fun observeViewModel() {
        viewModel.user.observe(this) {
            binding.loading.visibility = View.GONE
            if (it != null) {
                Toast.makeText(this, "Успешно, ${it.username}", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        viewModel.error.observe(this) {
            binding.loading.visibility = View.GONE
            if (it != null) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.errorInputEmail.observe(this) {
            if (it != null)
                binding.loading.visibility = View.GONE
        }
        viewModel.errorInputPassword.observe(this) {
            if (it != null)
                binding.loading.visibility = View.GONE
        }
        viewModel.errorInputUsername.observe(this) {
            if (it != null)
                binding.loading.visibility = View.GONE
        }
    }

    private fun addTextChangeListeners() =
        with(binding) {
            etEmail.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    viewModel?.resetErrorInputEmail()
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            })
            etPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    viewModel?.resetErrorInputPassword()
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            })
            etUsername.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    viewModel?.resetErrorInputUsername()
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            })
        }

    companion object {
        fun newIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }
}