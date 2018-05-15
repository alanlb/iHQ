package br.com.projeto.ihq;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.projeto.ihq.dao.DaoGeneric;

public class LoginActivity extends DefaultActivity {

    private Button bt;
    private EditText et;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregarComponentes();
    }

    private void carregarComponentes() {
    }


    public void click(View view) {
        String valor = et.getText().toString();
        tv.setText(valor);
    }

    public void clickTextView(View view) {
        String nome = this.tv.getText().toString();
        Toast.makeText(this,
                nome,
                Toast.LENGTH_SHORT).show();
    }

    public void clickNovaActivity(View view) {


    }

    public void telaCadastrar(View view) {
        Intent i = new Intent(getContext(), CadastrarUsuarioActivity.class);
        startActivity(i);


    }

    public void login(View view) {
        //validar
        Intent i = new Intent(getContext(), DashBoardActivity.class);
        startActivity(i);
        finish();

    }
}
