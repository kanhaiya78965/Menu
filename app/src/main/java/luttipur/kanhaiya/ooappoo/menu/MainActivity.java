package luttipur.kanhaiya.ooappoo.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txt,popupTxt,contextTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
        popupTxt = findViewById(R.id.txt2);

        contextTxt = findViewById(R.id.contextTxt);
        registerForContextMenu(contextTxt);


        //popup menu start
        popupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,popupTxt);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int itemId = item.getItemId();

                        if (itemId == R.id.home)
                            Toast.makeText(MainActivity.this, "Home is clicked", Toast.LENGTH_SHORT).show();
                        else if(itemId == R.id.call)
                            Toast.makeText(MainActivity.this,"CAll is clicked",Toast.LENGTH_SHORT).show();
                        else if (itemId == R.id.camera)
                            Toast.makeText(MainActivity.this, "Camera is clicked", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        //popup menu end



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu,menu);

       // return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.hom)
            txt.setText("Home item is clicked");
        else if (itemId == R.id.cal)
            txt.setText("Call item is clicked");
        else if (itemId == R.id.cam)
            txt.setText("Camera item is clicked");
        /*
        //or
        switch (item.getItemId())
        {
            case R.id.hom:
                txt.setText("Home item is clicked");
                return true;
                break;
            case R.id.cal:
                txt.setText("CAll item is clicked");
                return true;
                break;
            case R.id.cam:
                txt.setText("Camera item is clicked");
                return true;
                break;
        }
        */
        //return super.onOptionsItemSelected(item);
        return true;
    }

    //context Menu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.home)
            Toast.makeText(MainActivity.this, "Home is clicked", Toast.LENGTH_SHORT).show();
        else if (itemId == R.id.call)
            Toast.makeText(MainActivity.this, "Call is  clicked", Toast.LENGTH_SHORT).show();
        else if (itemId == R.id.camera)
            Toast.makeText(MainActivity.this, "Camera is clicked", Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);

    }


    public void optionMenuHome(MenuItem item) {
        Toast.makeText(this, "optionMenuHome", Toast.LENGTH_SHORT).show();
    }
}