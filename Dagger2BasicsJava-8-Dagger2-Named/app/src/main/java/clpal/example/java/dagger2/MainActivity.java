package clpal.example.java.dagger2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import clpal.example.java.dagger2.basics.Constants;
import clpal.example.java.dagger2.basics.MainViewModel;
import clpal.example.java.dagger2.di.DaggerMainViewModelInjector;

import static clpal.example.java.dagger2.basics.Constants.TAG;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=findViewById(R.id.textView);
        Button button=findViewById(R.id.connect);

        DaggerMainViewModelInjector.builder()
                .setEndPoint(Constants.PROD_ENDPOINT)
                .setUsername("admin")
                .setPassword("adminpassword")
                .build()
                .injectFields(this);

        button.setOnClickListener(view -> {
            textView.setText(mMainViewModel.fetchData());
            Log.d(Constants.TAG, "onCreate: Data fetched");
        });

    }

    @Inject
    public void testMethod() {
        Log.d(Constants.TAG, "testMethod: this is test method from main activity");
    }

}
