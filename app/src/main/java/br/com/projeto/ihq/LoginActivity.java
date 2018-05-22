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
import br.com.projeto.ihq.exception.SqliteException;
import br.com.projeto.ihq.exception.ValidationException;
import br.com.projeto.ihq.model.Usuario;
import br.com.projeto.ihq.util.Util;

public class LoginActivity extends DefaultActivity {

    private Button bt;
    private EditText edLogin;
    private EditText edSenha;
    private TextView tvErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregarComponentes();
    }

    private void carregarComponentes() {
        this.edLogin = findViewById(R.id.ed_login_usuario);
        this.edSenha = findViewById(R.id.ed_senha_usuario);
        this.tvErro = findViewById(R.id.tv_erro);
    }

    public void telaCadastrar(View view) {
        Intent i = new Intent(getContext(), CadastrarUsuarioActivity.class);
        startActivity(i);

    }

    public void login(View view) {
        try {
            String login = edLogin.getText().toString();
            String senha = edSenha.getText().toString();

            Util.validarLoginCadastroLogin(null, login, senha);

            Usuario u = DaoGeneric.buscarUsuarioPorLogin(getContext(), login, senha);


            Intent i = new Intent(getContext(), DashBoardActivity.class);
            startActivity(i);
            finish();
        } catch (ValidationException e) {
            e.printStackTrace();
            tvErro.setText(e.getMessage());
        } catch (SqliteException e) {
            e.printStackTrace();
            tvErro.setText(e.getMessage());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


        try {
            if (DaoGeneric.isUsuarioLogado(getContext())) {

                Intent i = new Intent(getContext(), DashBoardActivity.class);
                startActivity(i);
                finish();
            }

        } catch (SqliteException e) {
            e.printStackTrace();
        }
    }
}
