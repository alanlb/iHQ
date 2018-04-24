package br.com.projeto.ihq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashBoardActivity extends DefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        String nome = getIntent().getStringExtra("nome");
        TextView t = findViewById(R.id.tvTexto);
        t.setText("BEM VINDO = " + nome);

    }

    public void click(View view) {
        finish();
    }
}
