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

public class MainActivity extends DefaultActivity {

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
        bt = findViewById(R.id.btClick);
        et = findViewById(R.id.etNome);
        tv = findViewById(R.id.tvNome);
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

        String nome = this.et.getText().toString();
        System.out.println((nome == ""));
        System.out.println(nome.isEmpty());
        System.out.println(nome);

        if (nome == "" || nome.isEmpty()) {
            Toast.makeText(this,
                    "DIGITE ALGUMA INFORMAÇÃO",
                    Toast.LENGTH_SHORT).show();
        return;
        }

        Intent intent = new Intent(this, DashBoardActivity.class);
        intent.putExtra("nome", nome);
        startActivity(intent);
    }
}
