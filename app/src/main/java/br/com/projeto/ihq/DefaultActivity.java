package br.com.projeto.ihq;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class DefaultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate - " + this.getClass().getSimpleName());
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart  - " + this.getClass().getSimpleName());
    }
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume  - " + this.getClass().getSimpleName());
    }
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause  - " +this.getClass().getSimpleName());
    }
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop  - " + this.getClass().getSimpleName());
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart  - " + this.getClass().getSimpleName());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy  - " + this.getClass().getSimpleName());
    }

    public Context getContext(){return this;}


    public void setToast(String mensagem){
       Toast.makeText(getContext(), mensagem, Toast.LENGTH_SHORT ).show();

    }
     public void setSnackbar(View v, String mensagem){
         Snackbar.make(v, mensagem, Snackbar.LENGTH_SHORT).show();

     }




}
