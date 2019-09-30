package temple.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class ColorActivity extends AppCompatActivity {

    private ArrayList<CustomColor> list = new ArrayList<>();
    private ColorAdapter adapter;
    private LinearLayout llRoot;
    private String selectColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        llRoot = findViewById(R.id.ll_root);
        addColor();
         adapter = new ColorAdapter(this, list,selectColor);
        Spinner spinner= findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CustomColor data = list.get(i);
                selectColor = data.getName();
                adapter.changeSelect(selectColor);
                llRoot.setBackgroundColor(Color.parseColor(data.getColor()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addColor() {
        selectColor = "BLUE";
        list.add(new CustomColor("BLUE","#0000ff"));
        list.add(new CustomColor("RED","#ff0000"));
        list.add(new CustomColor("YELLOW","#ffff00"));
        list.add(new CustomColor("MAGENTA","#ff00ff"));
        list.add(new CustomColor("LTGRAY","#cccccc"));
        list.add(new CustomColor("GREEN","#00ff00"));
        list.add(new CustomColor("NavajoWhite","#FFDEAD"));
        list.add(new CustomColor("GreenYellow","#ADFF2F"));
        list.add(new CustomColor("LightSalmon","#FFA07A"));
        list.add(new CustomColor("Tomato","#FF6347"));
        list.add(new CustomColor("Turquoise","#40E0D0"));
        list.add(new CustomColor("Maroon","#800000"));
    }
}
