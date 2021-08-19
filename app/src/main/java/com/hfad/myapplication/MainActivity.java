package com.hfad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView leftIcon = (ImageView) findViewById(R.id.left_icon);
        ImageView rightIcon = (ImageView) findViewById(R.id.right_icon);
        TextView tittle = (TextView) findViewById(R.id.toolbar_tittle);

        leftIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this, "Left icon", Toast.LENGTH_SHORT).show();
            }
        });

        rightIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Toast.makeText(MainActivity.this, "Right icon", Toast.LENGTH_SHORT).show();
                showMenu(view);
            }
        });
    }
    private void showMenu(View view)
    {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, view );
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                if (item.getItemId() == R.id.one)
                {
                    Intent intent = new Intent(MainActivity.this, OneActivity.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.two)
                {
                    Intent two = new Intent(MainActivity.this, TwoActivity.class);
                    startActivity(two);
                }
                if (item.getItemId() == R.id.three)
                {
                    Intent three = new Intent(MainActivity.this, ThreeActivity.class);
                    startActivity(three);
                }
                return true;
            }
        });
        popupMenu.show();
    }
}