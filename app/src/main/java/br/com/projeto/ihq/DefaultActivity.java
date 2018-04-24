package br.com.projeto.ihq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
}
