package com.example.criptografiaaes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCriptografar.setOnClickListener {
            try {
                if(!edtTexto.text.isNullOrEmpty()){
                    var view = layoutInflater.inflate(R.layout.alert_dialog_layout, null)
                    AlertDialog.Builder(this).setView(view).setTitle("Senha").setMessage("Informe a senha: ")
                        .setPositiveButton("Ok"){dialog, which ->
                            var senha = view.findViewById<EditText>(R.id.edtSenha)
                            resultado.text = Criptografia.criptografar(edtTexto.text.toString(), senha.text.toString())
                        }.setNegativeButton("Cancel"){dialog, which ->
                            dialog.dismiss()
                        }.create().show()
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }

        btnDescriptografar.setOnClickListener {
            try {
                if(!resultado.text.isNullOrEmpty()){
                    var view = layoutInflater.inflate(R.layout.alert_dialog_layout, null)
                    AlertDialog.Builder(this).setView(view).setTitle("Senha").setMessage("Informe a senha: ")
                        .setPositiveButton("Ok"){dialog, which ->
                            var senha = view.findViewById<EditText>(R.id.edtSenha)
                            resultadoDes.text = Criptografia.descriptografar(resultado.text.toString(), senha.text.toString())
                        }.setNegativeButton("Cancel"){dialog, which ->
                            dialog.dismiss()
                        }.create().show()
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }

    }
}
