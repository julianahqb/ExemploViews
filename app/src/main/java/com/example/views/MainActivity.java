package com.example.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;


import com.example.views.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLimpar.setOnClickListener(this);
        binding.btnExibir.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLimpar){
            //Toast.makeText(this,"Limpar",Toast.LENGTH_SHORT).show();
            binding.edtNome.setText("");
            binding.edtEmail.setText("");
            binding.edtTelefone.setText("");
            binding.swtWhats.setChecked(false);
            binding.rdgPeriodo.clearCheck();
            binding.chkInternet.setChecked(false);
            binding.chkStreaming.setChecked(false);
            binding.chkTelefone.setChecked(false);
            binding.chkTv.setChecked(false);
        }
        else if (view.getId() == R.id.btnExibir){
            //Toast.makeText(this,"Exibir",Toast.LENGTH_LONG).show();
            binding.lblDados.setVisibility(View.VISIBLE);
            binding.txtNome.setText("Nome: "
                    + binding.edtNome.getText().toString());
            binding.txtEmail.setText("E-mail: "
                    + binding.edtEmail.getText().toString());
            binding.txtTelefone.setText("Telefone: "
                    + binding.edtTelefone.getText().toString());
            if(binding.swtWhats.isChecked()){
                binding.txtWhats.setText("WhatsApp: "
                +binding.swtWhats.getTextOn());
            }else{
                binding.txtWhats.setText("WhatsApp: "
                        +binding.swtWhats.getTextOff());
            }

            int idrdbSelecionado = binding.rdgPeriodo.getCheckedRadioButtonId();
            if(idrdbSelecionado > 0){
                RadioButton rdbSelecionado = findViewById(idrdbSelecionado);
                binding.txtPeriodo.setText("Período: "
                        + rdbSelecionado.getText().toString());
            }

            String pref="";
            if(binding.chkInternet.isChecked())
                pref = binding.chkInternet.getText().toString();
            if(binding.chkTelefone.isChecked()){
                pref += " ";
                pref += binding.chkTelefone.getText().toString();
            }
            if(binding.chkTv.isChecked()){
                pref += " ";
                pref += binding.chkTv.getText().toString();
            }
            if(binding.chkStreaming.isChecked()){
                pref += " ";
                pref += binding.chkStreaming.getText().toString();
            }
            binding.txtPref.setText("Preferências: " + pref);
        }
    }
}