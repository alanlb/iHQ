package br.com.projeto.ihq;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.projeto.ihq.dao.DaoGeneric;
import br.com.projeto.ihq.model.Usuario;
import br.com.projeto.ihq.util.Util;
import br.com.projeto.ihq.util.WebServiceUtil;

public class CadastrarUsuarioActivity extends DefaultActivity {

    private EditText etNome;
    private EditText etLogin;
    private EditText etSenha;
    private TextView tvErro;
    LinearLayout layout;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
        carregarComponentes();


    }

    private void carregarComponentes() {
        this.etNome = findViewById(R.id.ed_cadastro_nome);
        this.etLogin = findViewById(R.id.ed_cadastro_login);
        this.etSenha = findViewById(R.id.ed_cadastro_senha);
        this.tvErro = findViewById(R.id.tv_erro);
        layout = findViewById(R.id.ll_cadastro_usuario);
    }


    public void cadastrar(View view) {
        String nome = etNome.getText().toString();
        String login = etLogin.getText().toString();
        String senha = etSenha.getText().toString();

        final Usuario usuario = new Usuario();
        usuario.setNomeComplete(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);

        //define a mensagem

        progressDialog = ProgressDialog.show(getContext(), "", "Verificando Internet", true);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                boolean internet = Util.verificarConexaoInternet();
                if (internet) {

                    progressDialog.setMessage("Validando Informações...");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            WebServiceUtil.salvarUsuarioWebService(usuario, progressDialog);
                            System.out.println("ID: " + usuario.getId());
                            if (usuario.getId() != null) {
                                DaoGeneric.salvarUsuario(usuario);
                                //setToast("Usuario Cadastrado com Sucesso");
                                setSnackbar(layout, "Usuario Cadastrado com Sucesso");
                                Intent i = new Intent(getContext(), DashBoardActivity.class);
                                startActivity(i);
                                finish();
                            }
                            progressDialog.dismiss();
                        }
                    }, 2000);
                } else {
                    setSnackbar(layout, "Sem conexão com Internet");
                    tvErro.setText("Sem conexão com Internet");
                }
            }
        }, 1500);

    }
}
