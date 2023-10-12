package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyRecipe extends AppCompatActivity {
    public static Context context_my_recipe;

    FrameLayout[] recipe;
    TextView[] recipeName;
    String[] recipeContent = new String[30];
    int[] recipeImage = new int[30];

    //변수 가져옴 + 텍스트 설정
    public TextView recipeText;
    private boolean checkbool;

    int count;

    int chkImg;
    String chkContent;
    String chkName;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    //추가
    static boolean setLayout=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipe);

        context_my_recipe = this;

        Typeface ralewayBold = ResourcesCompat.getFont(this, R.font.ralewayextrabold);
        Typeface nanu = ResourcesCompat.getFont(this, R.font.nanumbarungothicyethangul);
        //텍스트 변경
        checkbool = ((MainActivity)MainActivity.context_main).checking;
        recipeText = findViewById(R.id.cart_name);
        if(checkbool == true){
            recipeText.setText("나의 레시피");
            recipeText.setTypeface(nanu);
        } else{
            recipeText.setText("My Recipe");
            recipeText.setTypeface(ralewayBold);
        }

        /*
        if(checkbool2 == true){
            recipeText.setText("My Recipe");
        }

         */

        pref = getPreferences(Activity.MODE_PRIVATE);
        editor=pref.edit();
        count = pref.getInt("count", 0);

        TextView noRecipe = findViewById(R.id.textView6);
        TextView recipeContentName = findViewById(R.id.recipe_name);
        TextView recipeContentText = findViewById(R.id.recipeText);
        ImageView cookingImage = findViewById(R.id.cookImage);

        FrameLayout reicpe1 = findViewById(R.id.recipe_1);
        FrameLayout reicpe2 = findViewById(R.id.recipe_2);
        FrameLayout reicpe3 = findViewById(R.id.recipe_3);
        FrameLayout reicpe4 = findViewById(R.id.recipe_4);
        FrameLayout reicpe5 = findViewById(R.id.recipe_5);
        FrameLayout reicpe6 = findViewById(R.id.recipe_6);
        FrameLayout reicpe7 = findViewById(R.id.recipe_7);
        FrameLayout reicpe8 = findViewById(R.id.recipe_8);
        FrameLayout reicpe9 = findViewById(R.id.recipe_9);
        FrameLayout reicpe10 = findViewById(R.id.recipe_10);
        FrameLayout reicpe11 = findViewById(R.id.recipe_11);
        FrameLayout reicpe12 = findViewById(R.id.recipe_12);
        FrameLayout reicpe13 = findViewById(R.id.recipe_13);
        FrameLayout reicpe14 = findViewById(R.id.recipe_14);
        FrameLayout reicpe15 = findViewById(R.id.recipe_15);
        FrameLayout reicpe16 = findViewById(R.id.recipe_16);
        FrameLayout reicpe17 = findViewById(R.id.recipe_17);
        FrameLayout reicpe18 = findViewById(R.id.recipe_18);
        FrameLayout reicpe19 = findViewById(R.id.recipe_19);
        FrameLayout reicpe20 = findViewById(R.id.recipe_20);
        FrameLayout reicpe21 = findViewById(R.id.recipe_21);
        FrameLayout reicpe22 = findViewById(R.id.recipe_22);
        FrameLayout reicpe23 = findViewById(R.id.recipe_23);
        FrameLayout reicpe24 = findViewById(R.id.recipe_24);
        FrameLayout reicpe25 = findViewById(R.id.recipe_25);
        FrameLayout reicpe26 = findViewById(R.id.recipe_26);
        FrameLayout reicpe27 = findViewById(R.id.recipe_27);
        FrameLayout reicpe28 = findViewById(R.id.recipe_28);
        FrameLayout reicpe29 = findViewById(R.id.recipe_29);
        FrameLayout reicpe30 = findViewById(R.id.recipe_30);

        recipe = new FrameLayout[] { reicpe1, reicpe2, reicpe3, reicpe4, reicpe5, reicpe6,
                reicpe7, reicpe8, reicpe9, reicpe10, reicpe11, reicpe12,
                reicpe13, reicpe14, reicpe15, reicpe16, reicpe17, reicpe18, reicpe19, reicpe20,
                reicpe21, reicpe22, reicpe23, reicpe24, reicpe25, reicpe26,
                reicpe27, reicpe28, reicpe29, reicpe30 };

        TextView name1 = findViewById(R.id.name1);
        TextView name2 = findViewById(R.id.name2);
        TextView name3 = findViewById(R.id.name3);
        TextView name4 = findViewById(R.id.name4);
        TextView name5 = findViewById(R.id.name5);
        TextView name6 = findViewById(R.id.name6);
        TextView name7 = findViewById(R.id.name7);
        TextView name8 = findViewById(R.id.name8);
        TextView name9 = findViewById(R.id.name9);
        TextView name10 = findViewById(R.id.name10);
        TextView name11 = findViewById(R.id.name11);
        TextView name12 = findViewById(R.id.name12);
        TextView name13 = findViewById(R.id.name13);
        TextView name14 = findViewById(R.id.name14);
        TextView name15 = findViewById(R.id.name15);
        TextView name16 = findViewById(R.id.name16);
        TextView name17 = findViewById(R.id.name17);
        TextView name18 = findViewById(R.id.name18);
        TextView name19 = findViewById(R.id.name19);
        TextView name20 = findViewById(R.id.name20);
        TextView name21 = findViewById(R.id.name21);
        TextView name22 = findViewById(R.id.name22);
        TextView name23 = findViewById(R.id.name23);
        TextView name24 = findViewById(R.id.name24);
        TextView name25 = findViewById(R.id.name25);
        TextView name26 = findViewById(R.id.name26);
        TextView name27 = findViewById(R.id.name27);
        TextView name28 = findViewById(R.id.name28);
        TextView name29 = findViewById(R.id.name29);
        TextView name30 = findViewById(R.id.name30);

        recipeName = new TextView[] { name1, name2, name3, name4, name5, name6, name7, name8,
                name9, name10, name11, name12, name13, name14, name15, name16, name17, name18,
                name19, name20,  name21, name22, name23, name24, name25, name26, name27, name28,
                name29, name30};

        for(int i=0; i < count; i++){
            chkImg = pref.getInt("img"+i , 0);
            chkContent = pref.getString("content"+i, "내용");
            chkName = pref.getString("name"+i, "요리 이름");

            recipeImage[i] = chkImg;
            recipeContent[i] = chkContent;
            recipeName[i].setText(chkName);

            if(chkName != ""){
                recipe[i].setVisibility(View.VISIBLE);
            }
        }

        if(count<30){
            KeepRecipe();
        } else{
            Toast.makeText(this.getApplicationContext(),"즐겨찾기가 가득 찼습니다.",
                    Toast.LENGTH_SHORT).show();
        }

        DeleteRecipe();


        if(count == 0){
            noRecipe.setVisibility(View.VISIBLE);
        }else{
            noRecipe.setVisibility(View.INVISIBLE);
        }


        FrameLayout recipeFrame = findViewById(R.id.recipeFrame);
        Button recipeDown = findViewById(R.id.button11);
        recipeDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText("음식 이름");
                recipeFrame.setVisibility(View.INVISIBLE);
            }
        });

        //리스트 온클릭(노동...)

        reicpe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[0].getText());
                recipeContentText.setText(recipeContent[0]);
                cookingImage.setImageResource(recipeImage[0]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[1].getText());
                recipeContentText.setText(recipeContent[1]);
                cookingImage.setImageResource(recipeImage[1]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[2].getText());
                recipeContentText.setText(recipeContent[2]);
                cookingImage.setImageResource(recipeImage[2]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[3].getText());
                recipeContentText.setText(recipeContent[3]);
                cookingImage.setImageResource(recipeImage[3]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[4].getText());
                recipeContentText.setText(recipeContent[4]);
                cookingImage.setImageResource(recipeImage[4]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[5].getText());
                recipeContentText.setText(recipeContent[5]);
                cookingImage.setImageResource(recipeImage[5]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[6].getText());
                recipeContentText.setText(recipeContent[6]);
                cookingImage.setImageResource(recipeImage[6]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[7].getText());
                recipeContentText.setText(recipeContent[7]);
                cookingImage.setImageResource(recipeImage[7]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[8].getText());
                recipeContentText.setText(recipeContent[8]);
                cookingImage.setImageResource(recipeImage[8]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[9].getText());
                recipeContentText.setText(recipeContent[9]);
                cookingImage.setImageResource(recipeImage[9]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[10].getText());
                recipeContentText.setText(recipeContent[10]);
                cookingImage.setImageResource(recipeImage[10]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[11].getText());
                recipeContentText.setText(recipeContent[11]);
                cookingImage.setImageResource(recipeImage[11]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[12].getText());
                recipeContentText.setText(recipeContent[12]);
                cookingImage.setImageResource(recipeImage[12]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[13].getText());
                recipeContentText.setText(recipeContent[13]);
                cookingImage.setImageResource(recipeImage[13]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[14].getText());
                recipeContentText.setText(recipeContent[14]);
                cookingImage.setImageResource(recipeImage[14]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[15].getText());
                recipeContentText.setText(recipeContent[15]);
                cookingImage.setImageResource(recipeImage[15]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[16].getText());
                recipeContentText.setText(recipeContent[16]);
                cookingImage.setImageResource(recipeImage[16]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[17].getText());
                recipeContentText.setText(recipeContent[17]);
                cookingImage.setImageResource(recipeImage[17]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });
        reicpe19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[18].getText());
                recipeContentText.setText(recipeContent[18]);
                cookingImage.setImageResource(recipeImage[18]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[19].getText());
                recipeContentText.setText(recipeContent[19]);
                cookingImage.setImageResource(recipeImage[19]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[20].getText());
                recipeContentText.setText(recipeContent[20]);
                cookingImage.setImageResource(recipeImage[20]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[21].getText());
                recipeContentText.setText(recipeContent[21]);
                cookingImage.setImageResource(recipeImage[21]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[22].getText());
                recipeContentText.setText(recipeContent[22]);
                cookingImage.setImageResource(recipeImage[22]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[23].getText());
                recipeContentText.setText(recipeContent[23]);
                cookingImage.setImageResource(recipeImage[23]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[24].getText());
                recipeContentText.setText(recipeContent[24]);
                cookingImage.setImageResource(recipeImage[24]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[25].getText());
                recipeContentText.setText(recipeContent[25]);
                cookingImage.setImageResource(recipeImage[25]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[26].getText());
                recipeContentText.setText(recipeContent[26]);
                cookingImage.setImageResource(recipeImage[26]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[27].getText());
                recipeContentText.setText(recipeContent[27]);
                cookingImage.setImageResource(recipeImage[27]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[28].getText());
                recipeContentText.setText(recipeContent[28]);
                cookingImage.setImageResource(recipeImage[28]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

        reicpe30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeContentName.setText(recipeName[29].getText());
                recipeContentText.setText(recipeContent[29]);
                cookingImage.setImageResource(recipeImage[29]);

                recipeFrame.setVisibility(View.VISIBLE);
            }
        });

    }

    public void KeepRecipe(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("제목");
        String content = intent.getStringExtra("내용");
        int img = intent.getIntExtra("이미지",0);
        boolean chkPlus = intent.getBooleanExtra("확인",false);

        if(chkPlus == true && count < 30){
            recipeImage[count] = img;
            editor.putInt("img"+count,img);

            recipeContent[count] = content;
            editor.putString("content"+count, content);

            recipeName[count].setText(name);
            editor.putString("name"+count, name);

            recipe[count].setVisibility(View.VISIBLE);

            count += 1;
            editor.putInt("count", count);
            editor.apply();

            Toast.makeText(this.getApplicationContext(),name+ "가 즐겨찾기에 추가 됐습니다",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void DeleteRecipe(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("삭제제목"); //이름 받아오기
        boolean chkClear = intent.getBooleanExtra("삭제확인",false);
        String checking;

        if(chkClear == true){
            for(int i=0; i <=count; i++){
                checking = (String) recipeName[i].getText();
                if(name.equals(checking)){

                    int num = i;
                    for(int k = num; k<count;k++) {
                        recipeImage[k] = recipeImage[k + 1];
                        editor.putInt("img" + k, recipeImage[k]);

                        recipeContent[k] = recipeContent[k + 1];
                        editor.putString("content" + k, recipeContent[k]);

                        recipeName[k].setText(recipeName[k + 1].getText());
                        editor.putString("name" + k, (String)recipeName[k].getText());
                    }

                    recipe[count-1].setVisibility(View.INVISIBLE);
                    count -= 1;
                    editor.putInt("count", count);
                    editor.apply();

                    Toast.makeText(this.getApplicationContext(),name+ "(이)가 즐겨찾기에서 제외 됐습니다",
                            Toast.LENGTH_SHORT).show();

                    break;
                }
            }
        }

    }
//추가
    @Override
    public void onBackPressed() {
        if(setLayout!=true){
            super.onBackPressed();
        }else{
            Intent intent=new Intent(MyRecipe.this, recipe.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();;
        }

    }
}