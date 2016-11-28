package com.operativus.app.portfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.operativus.app.portofolio.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = this.getClass().getSimpleName();
    private final static String TOAST_MSG_TMPL = "This button will launch: %s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Button> btnList = new ArrayList<>();
        // grep "btn_" app/src/main/res/values/strings.xml | sed -e 's/.*\"\(.*\)\".*/\1/g' | while read ID; do NAME=$(echo ${ID} | sed -e "s/_\(.\)/\U\1/g"); echo "Button ${NAME} = (Button) findViewById(R.id.${ID});"; echo "btnList.add(${NAME});"; done
        Button btnPopMovies = (Button) findViewById(R.id.btn_pop_movies);
        btnList.add(btnPopMovies);
        Button btnStockHawk = (Button) findViewById(R.id.btn_stock_hawk);
        btnList.add(btnStockHawk);
        Button btnBuildIt = (Button) findViewById(R.id.btn_build_it);
        btnList.add(btnBuildIt);
        Button btnMakeYourApp = (Button) findViewById(R.id.btn_make_your_app);
        btnList.add(btnMakeYourApp);
        Button btnGoUbiquitos = (Button) findViewById(R.id.btn_go_ubiquitos);
        btnList.add(btnGoUbiquitos);
        Button btnCapstone = (Button) findViewById(R.id.btn_capstone);
        btnList.add(btnCapstone);

        addSimpleToast(btnList);
    }

    private void addSimpleToast(List<Button>btnList) {
        for (Button btn : btnList) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button btn = (Button) view;
                    String message = String.format(TOAST_MSG_TMPL, btn.getText().toString());
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
