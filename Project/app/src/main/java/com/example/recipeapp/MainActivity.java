package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    //추후에 메인에 있는 변수 접근을 위해 선언한 변수
    public static Context context_main;
    //japanese는 간식류 페이지
    Dialog settingDialog;
    Dialog custompopup_k;
    Dialog custompopup_c;
    Dialog custompopup_w;
    Dialog custompopup_j;
    Dialog infoDialog;

    //음식 팝업
    Dialog jokbal_pop;
    Dialog ddeokbokki_pop;
    Dialog jjimdak_pop;
    Dialog gobchang_pop;
    Dialog gamjatang_pop;
    Dialog soondae_pop;
    Dialog jjajangmyeon_pop;
    Dialog tangsuyook_pop;
    Dialog jjambbong_pop;
    Dialog maratang_pop;
    Dialog chicken_pop;
    Dialog pizza_pop;
    Dialog dongas_pop;
    Dialog gamjathuigim_pop;
    Dialog icecream_pop;
    Dialog snack_pop;
    Dialog yogurt_pop;

    //레시피 프레임레이아웃
    Dialog recipe_popup;

    //이미지 자동 슬라이드
    ViewFlipper v_fllipper;

    //레시피 등록
    ImageView main_detailRecipeImage;
    TextView main_detailRecipeName;
    TextView main_detailRecipeHowToCook;

    //텍스트 변경용 변수
    public boolean checking=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context_main = this;

        //커스텀 팝업 기능 구현
        settingDialog=new Dialog(MainActivity.this);
        settingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        settingDialog.setContentView(R.layout.setting_custompopup);
        settingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        custompopup_k=new Dialog(MainActivity.this);
        custompopup_k.requestWindowFeature(Window.FEATURE_NO_TITLE);
        custompopup_k.setContentView(R.layout.main_custompopup);
        custompopup_k.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        custompopup_c=new Dialog(MainActivity.this);
        custompopup_c.requestWindowFeature(Window.FEATURE_NO_TITLE);
        custompopup_c.setContentView(R.layout.main_custompopup_chinese);
        custompopup_c.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        custompopup_w=new Dialog(MainActivity.this);
        custompopup_w.requestWindowFeature(Window.FEATURE_NO_TITLE);
        custompopup_w.setContentView(R.layout.main_custompopup_western);
        custompopup_w.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        custompopup_j=new Dialog(MainActivity.this);
        custompopup_j.requestWindowFeature(Window.FEATURE_NO_TITLE);
        custompopup_j.setContentView(R.layout.main_custompopup_japanese);
        custompopup_j.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        infoDialog=new Dialog(MainActivity.this);
        infoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        infoDialog.setContentView(R.layout.info_custompopup);
        infoDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //음식 팝업 등록
        jokbal_pop=new Dialog(MainActivity.this);
        jokbal_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        jokbal_pop.setContentView(R.layout.main_food_jokbal);
        jokbal_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ddeokbokki_pop=new Dialog(MainActivity.this);
        ddeokbokki_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ddeokbokki_pop.setContentView(R.layout.main_food_ddeokbokki);
        ddeokbokki_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        jjimdak_pop=new Dialog(MainActivity.this);
        jjimdak_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        jjimdak_pop.setContentView(R.layout.main_food_jjimdak);
        jjimdak_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        gobchang_pop=new Dialog(MainActivity.this);
        gobchang_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        gobchang_pop.setContentView(R.layout.main_food_gobchang);
        gobchang_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        gamjatang_pop=new Dialog(MainActivity.this);
        gamjatang_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        gamjatang_pop.setContentView(R.layout.main_food_gamjatang);
        gamjatang_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        soondae_pop=new Dialog(MainActivity.this);
        soondae_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        soondae_pop.setContentView(R.layout.main_food_soondae);
        soondae_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        jjajangmyeon_pop=new Dialog(MainActivity.this);
        jjajangmyeon_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        jjajangmyeon_pop.setContentView(R.layout.main_foodc_jjajangmyeon);
        jjajangmyeon_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        tangsuyook_pop=new Dialog(MainActivity.this);
        tangsuyook_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        tangsuyook_pop.setContentView(R.layout.main_foodc_tangsuyook);
        tangsuyook_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        jjambbong_pop=new Dialog(MainActivity.this);
        jjambbong_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        jjambbong_pop.setContentView(R.layout.main_foodc_jjambbong);
        jjambbong_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        maratang_pop=new Dialog(MainActivity.this);
        maratang_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        maratang_pop.setContentView(R.layout.main_foodc_maratang);
        maratang_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        chicken_pop=new Dialog(MainActivity.this);
        chicken_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        chicken_pop.setContentView(R.layout.main_foodw_chicken);
        chicken_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        pizza_pop=new Dialog(MainActivity.this);
        pizza_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pizza_pop.setContentView(R.layout.main_foodw_pizza);
        pizza_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dongas_pop=new Dialog(MainActivity.this);
        dongas_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dongas_pop.setContentView(R.layout.main_foodw_dongas);
        dongas_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        gamjathuigim_pop=new Dialog(MainActivity.this);
        gamjathuigim_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        gamjathuigim_pop.setContentView(R.layout.main_foodw_gamjathuigim);
        gamjathuigim_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        icecream_pop=new Dialog(MainActivity.this);
        icecream_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        icecream_pop.setContentView(R.layout.main_foodj_icecream);
        icecream_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        snack_pop=new Dialog(MainActivity.this);
        snack_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        snack_pop.setContentView(R.layout.main_foodj_snack);
        snack_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        yogurt_pop=new Dialog(MainActivity.this);
        yogurt_pop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        yogurt_pop.setContentView(R.layout.main_foodj_yogurt);
        yogurt_pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //레시피 프레임레이아웃 등록
        recipe_popup=new Dialog(MainActivity.this);
        recipe_popup.requestWindowFeature(Window.FEATURE_NO_TITLE);
        recipe_popup.setContentView(R.layout.main_recipe_layout);
        recipe_popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //이미지 슬라이드 배열
        int images[] = {
                R.drawable.img_1,
                R.drawable.img_2,
                R.drawable.slideimage,
                R.drawable.img_3,
                R.drawable.img_9,
                R.drawable.img_12,
                R.drawable.img_13,
                R.drawable.img_14,
                R.drawable.img_16,
                R.drawable.img_24,
                R.drawable.img_29,
                R.drawable.img_40,
                R.drawable.img_62,
                R.drawable.img_42,
                R.drawable.img_57,
                R.drawable.img_51,
                R.drawable.img_65
        };

        //이미지 자동추천 배열
        int images_2[]={
                R.drawable.img_4,
                R.drawable.img_5,
                R.drawable.img_6,
                R.drawable.img_7,
                R.drawable.img_8,
                R.drawable.img_10,
                R.drawable.img_11,
                R.drawable.img_15,
                R.drawable.img_17,
                R.drawable.img_18,
                R.drawable.img_19,
                R.drawable.img_20,
                R.drawable.img_21,
                R.drawable.img_22,
                R.drawable.img_23,
                R.drawable.img_25,
                R.drawable.img_26,
                R.drawable.img_27,
                R.drawable.img_28,
                R.drawable.img_30,
                R.drawable.img_31,
                R.drawable.img_32,
                R.drawable.img_33,
                R.drawable.img_34,
                R.drawable.img_35,
                R.drawable.img_36,
                R.drawable.img_37,
                R.drawable.img_38,
                R.drawable.img_39,
                R.drawable.img_41,
                R.drawable.img_43,
                R.drawable.img_44,
                R.drawable.img_45,
                R.drawable.img_46,
                R.drawable.img_47,
                R.drawable.img_48,
                R.drawable.img_49,
                R.drawable.img_50,
                R.drawable.img_52,
                R.drawable.img_53,
                R.drawable.img_54,
                R.drawable.img_55,
                R.drawable.img_56,
                R.drawable.img_58,
                R.drawable.img_59,
                R.drawable.img_60,
        };

        //이미지 자동 전환 기능
        v_fllipper = findViewById(R.id.image_slide);
        for(int image : images) {
            fllipperImages(image);
        }

        //이미지 추천 기능
        ImageView mImageView = (ImageView)findViewById(R.id.imageView2);
        int imageId = (int)(Math.random() * images.length);
        mImageView.setBackgroundResource(images_2[imageId]);

        //버튼 연결부
        Button settingButton = findViewById(R.id.Setting_Button);
        settingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showSettingDialog();
            }
        });

        Button customButton_k = findViewById(R.id.button5);
        customButton_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomKpopup();
            }
        });

        Button customButton_c=findViewById(R.id.button6);
        customButton_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomCpopup();
            }
        });

        Button customButton_w=findViewById(R.id.button7);
        customButton_w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomWpopup();
            }
        });

        Button customButtom_j=findViewById(R.id.button8);
        customButtom_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomJpopup();
            }
        });

        Button infoButton=findViewById(R.id.info_Button);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfopopup();
            }
        });

        //cart 페이지 이동을 위한 버튼 변수와 리스너 추가
        Button button_cart = findViewById(R.id.cart_Button);
        button_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MyRecipe.class);
                startActivity(myIntent);
            }
        });
        Button button_recipe = findViewById(R.id.recipeBook_Button);
        button_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, recipe.class);
                startActivity(myIntent);
            }
        });
    }

    //이미지 자동 전환 함수
    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this); imageView.setBackgroundResource(image); v_fllipper.addView(imageView);      // 이미지 추가
        v_fllipper.setFlipInterval(4000); // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper.setAutoStart(true);// 자동 시작 유무 설정
        // animation
        v_fllipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_fllipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    //커스텀 팝업 함수
    public void showInfopopup() {
        infoDialog.show();
    }

    //setting 기능 함수_구현 미완성
    public void showSettingDialog() {
        settingDialog.show();

        //기능 구현
        //언어 변경 기능
        TextView title= findViewById(R.id.textView);
        TextView rbook= findViewById(R.id.textView16);
        TextView cart= findViewById(R.id.textView15);
        TextView info= findViewById(R.id.textView18);
        TextView recommend = findViewById(R.id.textView19);
        TextView select = findViewById(R.id.textView3);
        TextView infotext = infoDialog.findViewById(R.id.textView5);
        TextView setting = settingDialog.findViewById(R.id.textView5);

        Typeface raleway = ResourcesCompat.getFont(this, R.font.ralewaymedium);
        Typeface ralewayBold = ResourcesCompat.getFont(this, R.font.ralewayextrabold);
        Typeface nanu = ResourcesCompat.getFont(this, R.font.nanumbarungothicyethangul);

        Switch transSwitch = settingDialog.findViewById(R.id.switch2);
        transSwitch.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    title.setText("요리조리");
                    rbook.setText("     레시피북");
                    cart.setText(" 내 레시피");
                    info.setText("정보");
                    recommend.setText("오늘의 추천요리");
                    select.setText("선택");
                    infotext.setText("정보");
                    setting.setText("설정");
                    //변수 변경
                    checking = true;
                    //폰트변경
                    title.setTypeface(nanu);
                    rbook.setTypeface(nanu);
                    cart.setTypeface(nanu);
                    info.setTypeface(nanu);
                    recommend.setTypeface(nanu);
                    select.setTypeface(nanu);
                    infotext.setTypeface(nanu);
                    setting.setTypeface(nanu);

                } else {
                    title.setText("YoriJori");
                    rbook.setText("Recipe Book");
                    cart.setText("My Recipe");
                    info.setText("Info");
                    recommend.setText("Today's Recommend");
                    select.setText("Select");
                    infotext.setText("Information");
                    setting.setText("Setting");
                    //변수 변경
                    checking = false;
                    //폰트 변경
                    title.setTypeface(ralewayBold);
                    rbook.setTypeface(raleway);
                    cart.setTypeface(raleway);
                    info.setTypeface(raleway);
                    recommend.setTypeface(raleway);
                    select.setTypeface(raleway);
                    infotext.setTypeface(raleway);
                    setting.setTypeface(raleway);
                }
            }
        });
    }

    //음식 팝업 함수
    public void showCustomJpopup() {
        custompopup_j.show();

        //기능 구현
        Button icecream_btn= custompopup_j.findViewById(R.id.button_japanese1);
        icecream_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showicecreampopup();
            }
        });

        Button snack_btn= custompopup_j.findViewById(R.id.button_japanese2);
        snack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showsnackpopup();
            }
        });

        Button yogurt_btn= custompopup_j.findViewById(R.id.button_japanese3);
        yogurt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showyogurtpopup();
            }
        });
    }

    public void showCustomKpopup() {
        custompopup_k.show();

        //기능 구현
        Button jokbal_btn= custompopup_k.findViewById(R.id.button_korean1);
        jokbal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showjokbalpopup();
            }
        });

        Button ddeokbokki_btn = custompopup_k.findViewById(R.id.button_korean2);
        ddeokbokki_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showddeokbokkipopup();
            }
        });

        Button jjimdak_btn = custompopup_k.findViewById(R.id.button_korean3);
        jjimdak_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showjjimdakpopup();
            }
        });

        Button gobchang_btn = custompopup_k.findViewById(R.id.button_korean4);
        gobchang_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showgobchangpopup();
            }
        });

        Button gamjatang_btn = custompopup_k.findViewById(R.id.button_korean5);
        gamjatang_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showgamjatangpopup();
            }
        });

        Button soondae_btn = custompopup_k.findViewById(R.id.button_korean6);
        soondae_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showsoondaepopup();
            }
        });

    }

    public void showCustomWpopup() {
        custompopup_w.show();

        //기능 구현
        Button chicken_btn= custompopup_w.findViewById(R.id.button_western1);
        chicken_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showchickenpopup();
            }
        });

        Button pizza_btn= custompopup_w.findViewById(R.id.button_western2);
        pizza_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showpizzapopup();
            }
        });

        Button dongas_btn= custompopup_w.findViewById(R.id.button_western3);
        dongas_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdongaspopup();
            }
        });

        Button gamjathuigim_btn= custompopup_w.findViewById(R.id.button_western4);
        gamjathuigim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showgamhathuigimpopup();
            }
        });
    }

    public void showCustomCpopup() {
        custompopup_c.show();

        //기능 구현
        Button jjajangmyeon_btn= custompopup_c.findViewById(R.id.button_chinese1);
        jjajangmyeon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showjjajangmyeon();
            }
        });

        Button tangsuyook_btn=custompopup_c.findViewById(R.id.button_chinese2);
        tangsuyook_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtangsuyookpopup();
            }
        });

        Button jjambbong_btn=custompopup_c.findViewById(R.id.button_chinese3);
        jjambbong_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showjjambbongpopup();
            }
        });

        Button maratang_btn=custompopup_c.findViewById(R.id.button_chinese4);
        maratang_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showmaratangpopup();
            }
        });
    }

    //음식 종류 팝업 함수
    public void showddeokbokkipopup() {
        ddeokbokki_pop.show();

        //팝업 기능 구현
        Button egginhell_btn = ddeokbokki_pop.findViewById(R.id.ddeok1);
        egginhell_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_9);
                main_detailRecipeName.setText("  떡볶이에그인헬");
                main_detailRecipeHowToCook.setText("1.팬에 다진마늘 1T를 넣고 볶다가 떡볶이와 물을 넣고 끓여준다\n" +
                        "2.떡볶이가 익으면 토마토소스 2.5T를 넣고 끓여준다\n" +
                        "3.끓기 시작하면 모짜렐라치즈와 계란을 넣고 뚜껑을 덮어 익혀준다\n");
            }
        });

        Button roseramyeon_btn = ddeokbokki_pop.findViewById(R.id.ddeok2);
        roseramyeon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_22);
                main_detailRecipeName.setText("  로제라면");
                main_detailRecipeHowToCook.setText("1.라면 사리를 삶아서 건져낸다\n" +
                        "2.로제 떡볶이 국물과 라면 사리를 2~3분 정도 같이 볶아서 완성 시켜준다\n" +
                        "+)추가하고 싶은 재료가 있으면 추가해서 볶아도 된다\n");
            }
        });

        Button ddeokbokki_bokumbap_btn = ddeokbokki_pop.findViewById(R.id.ddeok3);
        ddeokbokki_bokumbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_23);
                main_detailRecipeName.setText("  떡볶이 볶음밥");
                main_detailRecipeHowToCook.setText("1.남은 떡볶이 국물을 적당량 챙긴다\n" +
                        "2.적당량의 김치를 잘게 잘라준다\n" +
                        "3.떡볶이 국물과 밥, 김치를 후라이펜에 넣고 볶아준다\n" +
                        "4.적당히 볶아졌다면 참기름 한 스푼 넣고 다시 볶아준다\n" +
                        "5.볶다가 김가루를 넣고 1분 정도 더 볶아준다\n");
            }
        });

        Button maekomdakddeokjorim_btn = ddeokbokki_pop.findViewById(R.id.ddeok4);
        maekomdakddeokjorim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_33);
                main_detailRecipeName.setText("  매콤 닭떡조림");
                main_detailRecipeHowToCook.setText("1.껍질을 제거한 닭 다리 살을 먹기 좋은 크기로 썬다\n" +
                        "2.양파와 대파를 큼직하게 썬다\n" +
                        "3.고춧가루와 고추장, 간장, 다진 마늘, 설탕, 후추를 약간씩 섞어 양념을 만들어준다\n" +
                        "4.냄비에 먹다 남은 떡볶이와 닭 다릿살, 야채를 넣고 양념을 넣은후 재료들이 자작하게 잠길 정도로 물을 부어 끓인다\n" +
                        "5.닭 다릿살에 양념이 잘 배어들면 먹는다.\n");
            }
        });

        Button ddeokbokkipizza_btn = ddeokbokki_pop.findViewById(R.id.ddeok5);
        ddeokbokkipizza_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_26);
                main_detailRecipeName.setText("  떡볶이 피자");
                main_detailRecipeHowToCook.setText("1.전자레인지 사용 용기에 떡볶이를 자른다\n" +
                        "2.그 위에 식빵 조각을 올린다\n" +
                        "3.토마토 소스를 바른다\n" +
                        "4.치즈 등 기호에 맞는 재료를 올린다\n" +
                        "5.전자레인지에 넣고 기호에 맞게 돌려준다\n");
            }
        });

        Button ddeokbokkijjapageti_btn = ddeokbokki_pop.findViewById(R.id.ddeok6);
        ddeokbokkijjapageti_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_25);
                main_detailRecipeName.setText("  떡볶이 짜파게티");
                main_detailRecipeHowToCook.setText("1.떡볶이를 후라이팬에 볶는다\n" +
                        "2.조리한 짜파게티를 넣는다\n" +
                        "3.함께 볶고 치즈 및 기호에 맞는 재료를 올린다 \n");
            }
        });
    }

    public void showjokbalpopup() {
        jokbal_pop.show();

        //팝업 기능 구현
        Button buljokmyeon_btn = jokbal_pop.findViewById(R.id.jok1);
        buljokmyeon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_1);
                main_detailRecipeName.setText("  불족면");
                main_detailRecipeHowToCook.setText("1.불닭볶음면을 삶아 찬물에 헹궈 준비한다. \n" +
                        "2.족발 고기, 상추, 깻잎, 양배추와 볶음면 소스를 함께 넣고 비빈다\n");
            }
        });

        Button baekjongwonjokbaldupbap_btn = jokbal_pop.findViewById(R.id.jok2);
        baekjongwonjokbaldupbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_11);
                main_detailRecipeName.setText("  백종원족발덮밥");
                main_detailRecipeHowToCook.setText("1.냄비에 간장1 : 설탕 1 : 물 1.5 비율로 끓여준다\n" +
                        "2.끓기 시작하면 양파와 남은 족발을 다져 넣어 함께 끓여준다 \n" +
                        "3.1시간정도 졸인 후 삶은 계란 2개, 물을 넣고 1시간 더 졸여준다\n" +
                        "4.물이 1/3정도 남으면 완성된 것을 밥 위에 올려 먹는다\n");
            }
        });

        Button orientaljokbalsalad_btn = jokbal_pop.findViewById(R.id.jok3);
        orientaljokbalsalad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_15);
                main_detailRecipeName.setText("  오리엔탈족발샐러드");
                main_detailRecipeHowToCook.setText("1.족발은 그대로 사용하거나 먹기 좋게 채썬다\n" +
                        "2.샐러드용 채소는 한입크기로 썰고 찬물에 5분간 담갔다 건져 물기를 제거한다\n" +
                        "3.숙주나물은 깨끗이 씻어 준비한다\n" +
                        "4.볼에 분량의 재료를 넣고 잘 섞어 소스를 만든다\n" +
                        "5.그릇에 채소와 족발은 담고 소스를 뿌려낸다\n" +
                        "<소스만들기>\n" +
                        "간장·물엿·다진 양파 2큰술씩, 올리브유·다진 파·설탕 1큰술씩, 다진 마늘 2작은술, 다진 청양고추 1작은술, 통깨·후춧가루 약간씩 넣고 섞는다\n");
            }
        });

        Button jokbalgimbap_btn = jokbal_pop.findViewById(R.id.jok4);
        jokbalgimbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_19);
                main_detailRecipeName.setText("  족발 김밥");
                main_detailRecipeHowToCook.setText("1.마늘을 다져 기름에 볶아 색을 낸다\n" +
                        "2.밥에 참기름과 소금으로 간을 해서 준비한다\n" +
                        "3.깻잎이나 상추는 채 썰어 준비한다\n" +
                        "4.김 위에 밥을 넓게 깔고 튀긴 마늘을 고루 뿌린 후 족발의 살과 지방 부분을 겹쳐서 얹는다. 무말랭이와 채 썬 야채들을 넣고 돌돌 만다(냉장고에 묵혀둔 야채가 있으면 함께 채 썰어 넣어도 좋다.)\n" +
                        "5.볼에 쌈장, 다진 청양고추, 다진 마늘, 고추냉이를 넣고 섞어 소스를 만든다\n" +
                        "6.김밥을 자른 후 특제 소스를 얹으면 완성! \n");
            }
        });

        Button jokbalbokkum_btn = jokbal_pop.findViewById(R.id.jok5);
        jokbalbokkum_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_35);
                main_detailRecipeName.setText("  족발 김밥");
                main_detailRecipeHowToCook.setText("1.먼저 먹다 남은 족발을 후라이팬에 기름 살짝 둘러서 맛있게 볶아준다\n" +
                        "2.고추장 1T, 설탕 1T, 간장 1/2T, 후추 약간 넣어서 양념장을 만들어준다\n" +
                        "3.만들어진 양념장을 볶은 족발에 넣고 볶아준다\n" +
                        "4.양념장이 족발에 잘 배일때 쯤 양파를 넣어준다\n" +
                        "5.족발볶음을 다 한뒤에 깨소금이랑 참기름1T를 넣어준다\n" +
                        "6.파 넣어주고 끝! \n");
            }
        });

        Button maeunjokbal_btn = jokbal_pop.findViewById(R.id.jok6);
        maeunjokbal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_36);
                main_detailRecipeName.setText("  매운족발");
                main_detailRecipeHowToCook.setText("1.식용유에 남은 족발을 볶아준다\n" +
                        "2.어느정도 볶아졌다 싶으면 간장 두스푼,마늘 한스푼,설탕 한스푼 넣어서 볶다\t\n" +
                        "3.고춧가루 두스푼,양파 넣고 볶아준다\n" +
                        "4.땡초넣고 볶다가 마지막에 올리고당을 넣어주면 끝\n");
            }
        });
    }

    public void showjjimdakpopup() {
        jjimdak_pop.show();

        //팝업 기능 구현
        Button jjimdakgyeranmandoo_btn = jjimdak_pop.findViewById(R.id.jjim1);
        jjimdakgyeranmandoo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_12);
                main_detailRecipeName.setText("  찜닭계란만두");
                main_detailRecipeHowToCook.setText("1.쪽파와 당근, 양파와 남은 찜닭을 잘게 다져준다\n" +
                        "2.계란 3개를 풀어 야채와 찜닭을 섞어주고 참기름 1T를 넣는다\n" +
                        "3.팬에 동그랗게 부쳐주다가 한면이 다 익으면 반으로 접어준다\n" +
                        "4.노릇노릇해질 때 까지 구워준다\n");
            }
        });

        Button jjimdakbokumbap_btn = jjimdak_pop.findViewById(R.id.jjim2);
        jjimdakbokumbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_41);
                main_detailRecipeName.setText("  찜닭 볶음밥");
                main_detailRecipeHowToCook.setText("1.남은 고기들을 잘게 찢어준다\n" +
                        "2.후라이팬에 먹고 남은 찜닭의 건더기들을 올려준다\n" +
                        "3.밥 1~2공기를 후라이팬에 넣고 볶아준다\n" +
                        "4.계란 후라이를 해서 볶음밥 위에 얹어 먹으면 된다\n");
            }
        });

        Button jjimdakmayo_btn = jjimdak_pop.findViewById(R.id.jjim3);
        jjimdakmayo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_49);
                main_detailRecipeName.setText("  찜닭마요");
                main_detailRecipeHowToCook.setText("1. 들기름을 두르고 밥을 볶는다.\n" +
                        "2.청양고추를 다진 후 함께 볶는다.\n" +
                        "3.남은 찜닭의 고기를 잘게 잘라 팬에 넣고 함께 볶아준다.\n" +
                        "4. 밥이 충분히 풀어지면 찜닭 국물을 넣어준다.\n" +
                        "5.볶아준 밥을 그릇에 옮겨담고 김을 잘게 잘라 얹는다.\n" +
                        "6.마요네즈를 뿌려준다.\n");
            }
        });

        Button jjimdakddeokbokki_btn = jjimdak_pop.findViewById(R.id.jjim4);
        jjimdakddeokbokki_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_50);
                main_detailRecipeName.setText("  찜닭 떡볶이");
                main_detailRecipeHowToCook.setText("1.떡을 찬물에 담가둔다.\n" +
                        "2.남은 찜닭의 고기를 잘게 잘라준 후 팬에 남은 찜닭을 넣어 끓인다.\n" +
                        "3.떡볶이 떡을 팬에 넣는다.\n" +
                        "4.브로콜리를 한입크기로 손질해 넣고 끓여서 완성한다.\n");
            }
        });
    }

    public void showgobchangpopup() {
        gobchang_pop.show();

        //팝업 기능 구현
        Button gobchangpasta_btn = gobchang_pop.findViewById(R.id.button_gob1);
        gobchangpasta_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_13);
                main_detailRecipeName.setText("  곱창파스타");
                main_detailRecipeHowToCook.setText("1.끓는 물에 소금 1T를 넣고 스파게티면을 삶아준다\n" +
                        "2.팬에 다진 마늘을 볶다가 고추, 파, 양파를 넣고 볶아준다\n" +
                        "3.익으면 남은 곱창을 넣고 볶다가 스파게티면을 넣고 볶아준다\n" +
                        "4.면수를 1국자 넣고 볶다가 치즈를 조금 넣는다\n");
            }
        });

        Button gobchangbokumbap_btn = gobchang_pop.findViewById(R.id.button_gob2);
        gobchangbokumbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_69);
                main_detailRecipeName.setText("  곱창볶음밥");
                main_detailRecipeHowToCook.setText("1. 곱창과 김치, 깍두기를 먹기 좋은 크기로 썰어준다.\n" +
                        "2.달궈진 팬에 기름을 두르고 파를 다져 넣어 파기름을 낸다.\n" +
                        "3.파기름에 곱창과 다진마늘을 넣어 볶는다.\n" +
                        "4.썰어둔 김치와 깍두기와 밥을 넣고 함께 볶아준다.\n" +
                        "5.다 볶은 후 참기름을 넣고 계란 후라이를 얹은 후 김가루를 뿌린다.\n");
            }
        });

        Button chiagobta_btn = gobchang_pop.findViewById(R.id.button_gob3);
        chiagobta_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_70);
                main_detailRecipeName.setText("  치아곱타");
                main_detailRecipeHowToCook.setText("1. 팬에 곱창을 넣고 쌈장, 고추, 토마토소스를 넣는다.\n" +
                        "2.파채나 부추를 넣고 달걀, 슬라이스 치즈를 올려준다.\n" +
                        "3.뚜껑을 덮고 중불에서 치즈가 녹을 때까지 기다린다.\n" +
                        "4.치아바타 빵 사이에 볶은 재료를 올려주면 완성\n");
            }
        });
    }

    public void showgamjatangpopup() {
        gamjatang_pop.show();

        //팝업 기능 구현
        Button gamjatangramyeon_btn = gamjatang_pop.findViewById(R.id.button_gamja1);
        gamjatangramyeon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_24);
                main_detailRecipeName.setText("  감자탕 라면");
                main_detailRecipeHowToCook.setText("1.돼지 고기 적당량, 양파 ½, 표고 버섯1~2개, 고추 1~2개를 썰어준다\n" +
                        "2.냄비에 돼지고기를 넣고 볶아주다 적당히 익으면 양파를 넣고 볶아두고, 양파가 적당히 익으면 표고 버섯을 넣어 볶아준다\n" +
                        "3.버섯까지 적당히 익었다면 감자탕 육수를 넣고 냄비 뚜껑을 닫고 끓여준다\n" +
                        "4.육수가 끓기 시작하면 라면 스프를 1/2정도 넣어주고 라면 사리를 넣어준다(간을 봐가면서 취향에 따라 스프를 추가해준다)\n" +
                        "5.면이 익어갈 때 쯤 계란과 고추를 넣고 끓여주면 완성\n");
            }
        });

        Button ugeojihajangguk_btn = gamjatang_pop.findViewById(R.id.button_gamja2);
        ugeojihajangguk_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_39);
                main_detailRecipeName.setText("  우거지 해장국");
                main_detailRecipeHowToCook.setText("1.대파를 다져주고 청양고추와 홍고추는 씨를 빼고 다져준다 \n" +
                        "2.남은 감자탕 국물과 우거지에 물을 약간 추가하고 냄비넣고 국물이 졸 때까지 팔팔 끓인다.\n" +
                        "3.우거지를 적당한 크기로 잘라준다 \n" +
                        "4.불을 약불로 줄인 후 먹기 좋은 양이 될 때 까지 졸여준다\n");
            }
        });

        Button gamjatangbokumbap_btn = gamjatang_pop.findViewById(R.id.button_gamja3);
        gamjatangbokumbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_84);
                main_detailRecipeName.setText("  감자탕 볶음밥");
                main_detailRecipeHowToCook.setText("1.시래기와 뼈에 붙은 살을 발라내고 궁중팬에 담아준다.\t\n" +
                        "2.깍두기 듬성 듬성 다져 넣는다.\n" +
                        "3.후추톡톡,참기름을 두르고 볶아준다.\n" +
                        "4.적당히 볶아지면 밥을 넣는다.\n" +
                        "5.계란 2개를 깨넣고 슥슥 볶아준다.\t\n" +
                        "6.마지막으로 김가루 취향껏 넣고 볶아 내면 완성\n");
            }
        });
    }

    public void showsoondaepopup() {
        soondae_pop.show();

        //팝업 기능 구현
        Button soondaebokum_btn = soondae_pop.findViewById(R.id.soon1);
        soondaebokum_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_40);
                main_detailRecipeName.setText("  순대 볶음");
                main_detailRecipeHowToCook.setText("1.팬에 식용유를 두르고 파를 먼저 넣어 볶는다 \n" +
                        "2.파기름 냄새가 향긋하게 올라오면 냉장고에 있던 순대를 넣고 같이 볶는다 \n" +
                        " 3.순대 살때 준 양념을 뿌려서 같이 볶는다 \n" +
                        " +) 들깨가루를 조금 넣어주면 엄청 고소하다\n");
            }
        });

        Button soondaegook_btn = soondae_pop.findViewById(R.id.soon2);
        soondaegook_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_55);
                main_detailRecipeName.setText("  순대국");
                main_detailRecipeHowToCook.setText("1. 파와 고추를 잘게 썬다.\n" +
                        "2. 순대를 넣고 사골 곰탕 라면을 끓인다.\n" +
                        "3. 잘게썬 파와 고추를 고명으로 올린다\n" +
                        "4. 기호에 따라 새우젓 추가한다\n");
            }
        });

        Button soondaetuigim_btn = soondae_pop.findViewById(R.id.soon3);
        soondaetuigim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_64);
                main_detailRecipeName.setText("  순대 튀김");
                main_detailRecipeHowToCook.setText("1. 계란을 풀어준다\n" +
                        "2. 봉투에 순대, 부침가루, 카레가루를 넣고 섞는다\n" +
                        "3. 계란물을 함께 넣고 섞는다\n" +
                        "4. 달군 팬에 기름을 두르고 굽는다.\n");
            }
        });

        Button ddemuknuncheesesoondae_btn = soondae_pop.findViewById(R.id.soon4);
        ddemuknuncheesesoondae_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_88);
                main_detailRecipeName.setText("  떠먹는 치즈 순대");
                main_detailRecipeHowToCook.setText("1.고춧가루, 케찹, 진간장, 식초, 다진 마늘, 설탕을 섞어 양념장을 만든다.\n" +
                        "2.남은 순대와 양념을 잘 섞어준 후 위에 치즈를 올린다.\n" +
                        "3.청양고추와 쪽파를 다진 후 함께 얹어 전자렌지에 4분 데워준다.\n");
            }
        });
    }

    public void showjjajangmyeon() {
        jjajangmyeon_pop.show();

        //팝업 기능 구현
        Button jjajangdeopbap_btn = jjajangmyeon_pop.findViewById(R.id.jjajang1);
        jjajangdeopbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_3);
                main_detailRecipeName.setText("  짜장 덮밥");
                main_detailRecipeHowToCook.setText("1.남은 짜장 소스를 데운 후 밥 위에 얹는다.\n" +
                        "2.계란 후라이를 만든 후 덮밥 위에 얹어서 먹는다.\n");
            }
        });

        Button bokumjjajang_btn = jjajangmyeon_pop.findViewById(R.id.jjajang2);
        bokumjjajang_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_27);
                main_detailRecipeName.setText("  볶음 짜장");
                main_detailRecipeHowToCook.setText("1.면 사리를 삶아서 준비해둔다\n" +
                        "2.후라이팬에 기름을 살짝 두른 후 남은 짜장 소스를 넣고 살살 볶아준다\n" +
                        "3.삶아놓은 면을 넣고 같이 볶는다\n" +
                        "4.그릇에 담은 후 채썰은 오이와 삶은 계란으로 꾸며주면 완성\n");
            }
        });

        Button jjajangmyeonbuchimgae_btn = jjajangmyeon_pop.findViewById(R.id.jjajang3);
        jjajangmyeonbuchimgae_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_37);
                main_detailRecipeName.setText("  짜장면 부침개");
                main_detailRecipeHowToCook.setText("1.짜장소스가 다 발려져있는 짜장면이 남았을 경우, 비닐봉지에 넣어서 넓게 펴준 후, 냉장고에 넣어준다\n" +
                        "2.굳은 면을 먹기 좋게 썰어준다\n" +
                        "3.팬에 기름을 튀기듯이 넉넉히 뿌리고 거기에 자른 건더기를 제거한 짜장면 조각을 올려준다\n" +
                        "4.잘 익히면 완성\n");
            }
        });

        Button jjajangpasta_btn = jjajangmyeon_pop.findViewById(R.id.jjajang4);
        jjajangpasta_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_38);
                main_detailRecipeName.setText("  짜장 파스타");
                main_detailRecipeHowToCook.setText("1.올리브유 두른 팬에 마늘을 황금색이 나도록 볶는다\n" +
                        "2.파스타면은 포장에 적힌 시간에서 2 ~ 3분을 추가해서 삶은 후 건져 1번에 넣고 달달 볶아준다\n" +
                        "3.짜장 소스와 면수를 넣는다 \n" +
                        "4.짜장 소스가 면에 충분히 배어 들도록 1 ~ 2분가량 빠르게 볶아준다 \n" +
                        "+)부족하다면 소금, 후추 솔솔 뿌린다\n");
            }
        });

        Button joonguksikbokumbap_btn = jjajangmyeon_pop.findViewById(R.id.jjajang5);
        joonguksikbokumbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_46);
                main_detailRecipeName.setText("  중국식 볶음밥");
                main_detailRecipeHowToCook.setText("1. 팬에 파기름을 충분히 낸 후 당근과 계란을 넣어 볶아준다.\n" +
                        "2.찬 밥을 넣어 같이 볶는다.\n" +
                        "3.완성된 볶음밥을 그릇에 담은 후 따뜻하게 데운 남은 짜장을 얹어준다.\n");
            }
        });

        Button eggjjajangbap_btn = jjajangmyeon_pop.findViewById(R.id.jjajang6);
        eggjjajangbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_47);
                main_detailRecipeName.setText("  계란짜장밥");
                main_detailRecipeHowToCook.setText("1. 프라이팬에 기름을 넉넉히 두른다.\n" +
                        "2.기름이 어느정도 달궈지면 계란을 넣고 스크럼블처럼 휘저으며 익혀준다.\n" +
                        "3.계란이 어느정도 익으면 남은 짜장을 넣고 같이 볶아준다.\n" +
                        "4.그릇에 짜장과 밥을 담아 완성한다.\n");
            }
        });
    }

    public void showmaratangpopup() {
        maratang_pop.show();

        //팝업 기능 구현
        Button mararamyeon_btn = maratang_pop.findViewById(R.id.button_mara1);
        mararamyeon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_62);
                main_detailRecipeName.setText("  마라 라면");
                main_detailRecipeHowToCook.setText( "1.마라 국물과 건더기 또는 본인이 넣고싶은 재료를 끓인다.\n" +
                        "2.국물이 어느정도 끓으면 면을 넣어 끓여서 완성한다.\n");
            }
        });

        Button marabokumbap_btn = maratang_pop.findViewById(R.id.button_mara2);
        marabokumbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_63);
                main_detailRecipeName.setText("  마라 볶음밥");
                main_detailRecipeHowToCook.setText("1.마라탕 국물을 끓여주며 남은 야채나 떡도 함께 넣어서 잘게 잘라준다.\n" +
                        "2.아삭한 식감을 위해 오이지를 잘게 썰어 넣어준다.\n" +
                        "3.밥 한 공기를 넣어준다.\n" +
                        "4.재료를 모두 볶아준다.\n");
            }
        });
    }

    public void showjjambbongpopup() {
        jjambbong_pop.show();

        //팝업 기능 구현
        Button jjampongbap_btn = jjambbong_pop.findViewById(R.id.jjam1);
        jjampongbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_29);
                main_detailRecipeName.setText("  짬뽕밥");
                main_detailRecipeHowToCook.setText("1.냄비에 짬뽕 국물을 옮겨 담은 후, 밥 1공기를 넣고 끓인다\n" +
                        "2.죽처럼 묵직하게 변하면 계란 한 개를 풀어주고 참기름을 넣어주고 1분정도 더 끓여준다\n" +
                        "3.조리가 끝나면 김가루를 뿌려 마무리한다\n");
            }
        });

        Button mandooguk_btn = jjambbong_pop.findViewById(R.id.jjam2);
        mandooguk_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_30);
                main_detailRecipeName.setText("  짬뽕 만두국");
                main_detailRecipeHowToCook.setText("1.버섯을 먹기 좋은 크기로 손질한다\n" +
                        "2.고사리는 살짝 데친 후 먹기 좋은 크기로 썰어서 준비한다\n" +
                        "3.냄비에 짬뽕 국물을 옮겨 담은 후, 준비해둔 버섯과 고사리를 넣고 끓인다\n" +
                        "4.적당히 끓으면 만두를 넣어준 후 끓여서 만두를 익힌다\n" +
                        "5.만두가 다 익으면 그릇에 옮겨 식사\n");
            }
        });

        Button jjampongbokumbap_btn = jjambbong_pop.findViewById(R.id.jjam3);
        jjampongbokumbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_31);
                main_detailRecipeName.setText("  짬뽕 볶음밥");
                main_detailRecipeHowToCook.setText("1.양파와 감자를 작게 썰어준다\n" +
                        "2.후라이팬에 기름을 적당히 두른 후, 양파와 감자를 넣어 3.노릇하게 익을 때까지 볶아준다\n" +
                        "4.노릇하게 익었다면 밥 1공기를 넣고 잘 섞어준다\n" +
                        "5.잘 섞은 밥에 짬뽕 국물을 적당량 넣고 약불로 어느 정도 수분을 날려주면 볶음밥 완성\n");
            }
        });

        Button jjampongramyeon_btn = jjambbong_pop.findViewById(R.id.jjam4);
        jjampongramyeon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_32);
                main_detailRecipeName.setText("  짬뽕 라면");
                main_detailRecipeHowToCook.setText("1.대파와 애호박, 표고버섯, 양파를 먹기 좋은 크기로 손질한다\n" +
                        "2.냄비에 기름을 살짝 두르고 파를 넣어 파기름을 낸다\n" +
                        "3.파기름 냄새가 올라온다면 손질해둔 야채를 넣고 볶아준다\n" +
                        "4.물 한컵 반을 넣어주고 짬뽕국물을 넣어서 끓여준다\n" +
                        "5.다른 냄비에는 라면 사리를 삶아서 라면 사리를 준비한다\n" +
                        "6.삶은 라면 사리를 국물에 넣고 1~2분 끓인다\n" +
                        "7.그릇에 옮겨 마무리한다\n");
            }
        });

        Button tomatojjampongpasta_btn = jjambbong_pop.findViewById(R.id.jjam5);
        tomatojjampongpasta_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_85);
                main_detailRecipeName.setText("  토마토짬뽕파스타");
                main_detailRecipeHowToCook.setText("1. 올리브유 그냥 코팅하듯이 팬에 조금 둘러주고 마늘이랑 파 기름에 슦슦 볶아준다.\n" +
                        "2. 물을 파스타가 잠길 정도 넣고 면 넣고 익혀준다.\n" +
                        "3. 면이 익으면 팬에 토마토소스 1인분을 넣고 면이랑 같이 뭉근하게 끓여준다.\n" +
                        "4. 남은 짬뽕국물 부어주고 잘 끓인 다음 후추를 적당량 뿌려 마무리한다\n");
            }
        });

        Button jjampongdubujorim_btn = jjambbong_pop.findViewById(R.id.jjam6);
        jjampongdubujorim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_87);
                main_detailRecipeName.setText("  짬뽕 두부 조림");
                main_detailRecipeHowToCook.setText("1.팬에 두부를 올리고 짬뽕 국물을 붓는다.\n" +
                        "2.그대로 졸여준다.\n");
            }
        });
    }

    public void showtangsuyookpopup() {
        tangsuyook_pop.show();

        //팝업 기능 구현
        Button tangsuyookjabchaedupbap_btn = tangsuyook_pop.findViewById(R.id.tang1);
        tangsuyookjabchaedupbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_16);
                main_detailRecipeName.setText("  탕수육 잡채덮밥");
                main_detailRecipeHowToCook.setText("1.탕수육은 소스에 버무려진 상태로 준비한다\n" +
                        "2.당면은 미지근한 물에 담가 불린 뒤 끓는 물에 살짝 데친다 \n" +
                        "3.영양부추는 6cm 길이로 썰고, 당근과 오이는 6cm 길이로 토막 낸 뒤 돌려 깎아 채썬다\n" +
                        "4.볼에 분량의 재료를 넣고 잘 섞어 소스를 만든다\n" +
                        "5.달군 팬에 올리브유를 두르고 당근, 오이를 넣어 볶다가 숨이 죽으면 당면과 소스를 넣는다\n" +
                        "6.잘 볶아지면 탕수육을 넣고 살짝 버무린 다음 불을 끈다\n" +
                        "그릇에 밥을 담고 볶은 것을 올려낸다.\n" +
                        "<소스 만들기>\n" +
                        "간장 2큰술, 꿀 1큰술, 다진 마늘·참기름·통깨 1작은술씩, 검은깨·후춧가루 약간씩 넣고 섞는다.\n");
            }
        });

        Button gganpoonggi_btn = tangsuyook_pop.findViewById(R.id.tang2);
        gganpoonggi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_28);
                main_detailRecipeName.setText("  깐풍기");
                main_detailRecipeHowToCook.setText("1.파는 채썰기로, 양파는 깍둑썰기로 준비해둔다\n" +
                        "2.후라이팬 바닥이 잠길정도만 기름을 둘러주고 기름 온도가 올라갈 수 있도록 중간 불로 달궈준다\n" +
                        "3.기름이 달궈지는 동안 다진 마늘 2스푼, 간장 3스푼, 설탕 1스푼, 올리고당 1스푼, 식초 1스푼, 참기름 1스푼, 후춧가루 약간을 섞어서 양념을 준비한다\n" +
                        "4.기름이 달궈졌으면 탕수육 고기를 올려 뒤집어가며 튀겨준다\n" +
                        "5.다른 후라이팬에 기름을 두르고 파기름이 나오도록 파를 볶아준다\n" +
                        "6.파기름향이 올라오면 파는 한쪽으로 치워두고 만들어둔 양념을 모두 부어 끓여준다\n" +
                        "7.양념이 끓으면 양파를 넣고 끓인다\n" +
                        "8.양파향이 베이는 동안 고기를 건져내어 기름을 빼준다\n" +
                        "9.끓고 있는 양념에 고기를 넣고 윤기가 나도록 볶아준다\n");
            }
        });

        Button tangsuyookgangjung_btn = tangsuyook_pop.findViewById(R.id.tang3);
        tangsuyookgangjung_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_77);
                main_detailRecipeName.setText("  탕수육 강정");
                main_detailRecipeHowToCook.setText("1.분량의 양념재료(고추장 1T, 간장 1T, 케첩 2T, 요리당 2T, 다진마늘 1T)를 모두 넣어 준비한다.\t\n" +
                        "2.넓은팬에서 탕수육 익혀서 데운다.\t\n" +
                        "3.노릇하게 구워지면 준비한 양념을 넣고 섞어준다.\t\n" +
                        "4.통깨 솔솔 뿌려 마무리 한다.\n");
            }
        });

        Button tangsuyooksalad_btn = tangsuyook_pop.findViewById(R.id.tang4);
        tangsuyooksalad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_78);
                main_detailRecipeName.setText("  탕수육 샐러드");
                main_detailRecipeHowToCook.setText("1.청양고추는 씨를 제거하고 다진 후 그릇에 소스(간장 3T, 식초 3T, 물 3T, 올리고당 3T, 다진 마늘 ½)와 함께 섞어준다.\n" +
                                "2.양상추는 한입크기로 찢어주고 대파는 반으로 갈라 채썰어준다.\n" +
                                "3.달구어진 팬에 탕수육을 데워준다.\n" +
                                "4.접시에 양상추와 대파를 담고 소스를 뿌린다.\n" +
                                "5.데운 탕수육을 접시에 함께 담고 다시 소스를 뿌려준다\n");
            }
        });

        Button gimpitang_btn = tangsuyook_pop.findViewById(R.id.tang5);
        gimpitang_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_80);
                main_detailRecipeName.setText("  김피탕");
                main_detailRecipeHowToCook.setText("1.김치를 적당한 크기로 썰어준다.\n" +
                        "2.달구어진 팬에 남은 탕수육을 올려 데워준다.\n" +
                        "3.다른 팬에 김치와 물 100ml를 넣고 볶아준다.\n" +
                        "4.탕수육 소스와 옥수수를 함께 넣어 5분정도 끓여준다.\n" +
                        "5.끓인 소스에 데운 탕수육을 넣어 골고루 섞는다.\n" +
                        "6.바로 피자 치즈를 올리고 뚜껑을 닫고 끓이다 치즈가 다 녹으면 불을 끈다\n");
            }
        });

        Button tangsuyookchigae_btn = tangsuyook_pop.findViewById(R.id.tang6);
        tangsuyookchigae_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_82);
                main_detailRecipeName.setText("  탕수육 찌개");
                main_detailRecipeHowToCook.setText("1. 냄비에 물을 올려 끓여주며 양파와 파를 손질한다.\n" +
                        "2.청양고추를 적당히 썰어주고 끓는 물에 손질한 재료를 넣는다.\n" +
                        "3.새우젓 1스푼을 넣고 간이 맞지 않으면 국간장을 1~2스푼 넣는다.\n" +
                        "4.고춧가루를 1~1스푼 반 정도 넣어준다.\n" +
                        "5.끓는 찌개에 탕수육을 넣는다.\n" +
                        "6.다진 마늘을 1스푼 넣어 끓여 완성한다.\n");
            }
        });
    }

    public void showgamhathuigimpopup() {
        gamjathuigim_pop.show();

        //팝업 기능 구현
        Button ojicheesefried_btn = gamjathuigim_pop.findViewById(R.id.gamjathui1);
        ojicheesefried_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_51);
                main_detailRecipeName.setText("  오지치즈후라이");
                main_detailRecipeHowToCook.setText("1.종이호일에 남은 감자튀김을 깔고 칠리소스와 양파, 버섯 등을 넣어준다.\n" +
                        "2.모차렐라, 체다치즈를 뿌리고 치즈가 녹을 때까지 돌리면 완성\n");
            }
        });

        Button goroke_btn = gamjathuigim_pop.findViewById(R.id.gamjathui2);
        goroke_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_52);
                main_detailRecipeName.setText("  고로케");
                main_detailRecipeHowToCook.setText("1.햄, 양파, 감자튀김(약간의 물과 함께 전자레인지에 살짝 돌린 후 으깨주시면 더 좋음) 등을 모두 잘게 다져준다.\n" +
                        "2.다진 재료와 으깬 감자튀김을 잘 섞어주고 먹기 좋은 크기로 둥글게 만들어준다.\n" +
                        "3.일반 고로케를 만드는 것처럼 계란물과 빵가루를 준비한다.\n" +
                        "4.뭉친 재료를 계란물 > 빵가루 순으로 무쳐준 후 넉넉한 기름에 튀긴다.\n");
            }
        });

        Button gamjathuigimcheesejun_btn = gamjathuigim_pop.findViewById(R.id.gamjathui3);
        gamjathuigimcheesejun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_53);
                main_detailRecipeName.setText("  감자튀김치즈전");
                main_detailRecipeHowToCook.setText("1.에어프라이어에 종이호일을 깔아주고 남은 감자튀김을 붓는다.\n" +
                        "2.슬라이스 치즈를 올리고 모짜렐라 치즈도 올린다.\t3.170도에 10분 돌리면 완성");
            }
        });

        Button gamjapizza_btn = gamjathuigim_pop.findViewById(R.id.gamjathui4);
        gamjapizza_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_54);
                main_detailRecipeName.setText("  떠먹는 감자 피자");
                main_detailRecipeHowToCook.setText("1.감자튀김을 손가락 한 마디 크기로 잘라준다.\n" +
                        "2.스위트콘은 체에 걸러 물기를 빼고 양파와 마늘햄을 잘게 잘라준다.\n" +
                        "3.팬을 약불로 달궈준 후 식용유를 둘러준다.\n" +
                        "4.마늘햄을 넣고 볶다가 적당히 익으면 감자튀김을 같이 넣고 볶아준다.\n" +
                        "5.익은 감자튀김과 마늘햄을 그릇에 옮긴 후 팬에 기름을 둘러 양파를 볶아준다.\n" +
                        "6.양파가 익으면 그릇에 옮긴 후 케첩 2숟가락 반과 마요네즈 1숟가락 반, 설탕 1/2숟가락을 넣는다.\n" +
                        "7.양념과 재료를 잘 섞은 후 스위트콘을 넣어 섞는다.\n" +
                        "8.모짜렐라 치즈를 얹은 후 전자렌지에 1분 30초 정도 돌려준다.\n");
            }
        });

        Button buttergalricgamja_btn = gamjathuigim_pop.findViewById(R.id.gamjathui5);
        buttergalricgamja_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_58);
                main_detailRecipeName.setText("  버터갈릭감자튀김");
                main_detailRecipeHowToCook.setText("1.에어프라이기에 감자를 넣고 180도 온도에서 10분간 돌린다.\n" +
                        "2.뒤적여준 후 10분간 더 돌린다.\n" +
                        "3.볼에 소스재료(마요네즈 5숟가락, 허니머스타드 1/2숟가락, 우유 5숟가락, 설탕 2숟가락, 버터 1숟가락, 다진마늘 1/2숟가락)를 넣고 랩을 씌운다.\t\n" +
                        "4.전자레인지에 1분간 돌린다.(치즈가 잘 안녹으면 전자레인지에 더 돌려준다)\n" +
                        "5.소스를 잘 섞어 갈릭디핑소스를 만든다.\n" +
                        "6.만들어진 소스는 한김 식혀주세요.\n" +
                        "7.감자튀김은 접시에 담는다.\t\n" +
                        "8.갈릭디핑소스를 뿌린 후 파슬리가루를 뿌려 완성한다.\n");
            }
        });

        Button makomgamjatui_btn = gamjathuigim_pop.findViewById(R.id.gamjathui6);
        makomgamjatui_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_60);
                main_detailRecipeName.setText("  매콤감자튀김");
                main_detailRecipeHowToCook.setText("1.감자튀김을 데운다.\n" +
                        "2.볼에 양념재료(고춧가루 1숟가락, 카레가루 1/2숟가락, 파마산치즈가루 1숟가락, 후추 1/4숟가락, 파슬리가루 1/4숟가락)을 넣고 섞는다.\n" +
                        "3.섞어놓은 양념 재료에 튀긴 감자를 넣어 버무려 완성한다.\n");
            }
        });
    }

    public void showdongaspopup() {
        dongas_pop.show();

        //팝업 기능 구현
        Button dongaskimchinabe_btn = dongas_pop.findViewById(R.id.don1);
        dongaskimchinabe_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_14);
                main_detailRecipeName.setText("  돈까스김치나베");
                main_detailRecipeHowToCook.setText("1.양파를 살짝 볶은 후 물을 넣고 끓여준다\n" +
                        "2.설탕 1T, 간장 3T를 넣고 김치를 먹기 좋은 크기로 잘라 넣어준다\n" +
                        "3.어느정도 끓으면 파와 남은 돈까스를 넣고 끓여준다\n" +
                        "4.고춧가루를 뿌리고 계란을 올려 뚜껑을 덮고 익혀준다\n");
            }
        });

        Button gatsdondupbap_btn = dongas_pop.findViewById(R.id.don2);
        gatsdondupbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_59);
                main_detailRecipeName.setText("  가츠동 덮밥");
                main_detailRecipeHowToCook.setText("1. 준비한 채소를 썬다\n" +
                        "2. 계란물을 만든다\n" +
                        "3. 프라이팬에 간장 8스푼 넣고 물 150ml를 넣고 끓인다\n" +
                        "4. 끓어오르면 불을 낮추고 준비한 채소(파제외)와 돈까스 넣는다. \n" +
                        "5. 계란물을 넣는다\n" +
                        "6. 마지막으로 파를 넣는다.\n");
            }
        });

        Button katsusand_btn = dongas_pop.findViewById(R.id.don3);
        katsusand_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_61);
                main_detailRecipeName.setText("  카츠 샌드");
                main_detailRecipeHowToCook.setText("1. 식빵 한쪽면에 마요네즈 1큰술, 머스타드 1큰술을 바른다\n" +
                        "2. 그 위에 치즈를 올린다\n" +
                        "3. 만들어둔 소스를 돈까스 한쪽면에 바른다\n" +
                        "4. 치즈위에 돈까스를 올린다\n" +
                        "5. 새 식빵으로 덮는다.\n" +
                        "\n" +
                        "<소스만들기>\n" +
                        "돈까스소스 4큰술, 굴소스 2큰술, 케첩 2큰술를 섞는다.\n" +
                        "\n");
            }
        });

        Button dongasudupbap_btn = dongas_pop.findViewById(R.id.don4);
        dongasudupbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_71);
                main_detailRecipeName.setText("  돈까스덮밥");
                main_detailRecipeHowToCook.setText("1.먼저 남은 돈까스를 가위로 잘라 준다.\n" +
                        "2. 팬에 기름을 두르지 않고 약한불에 살짝 볶아준다.\n" +
                        "3.타지 않을 정도로 따뜻해졌을때 밥을 넣고 같이 볶아준다.\n" +
                        "4.골루 볶은후 그릇에담고\n" +
                        "소스(마요네즈+돈가스소스)를 뿌려준다.\n");
            }
        });

        Button dongasramyeon_btn = dongas_pop.findViewById(R.id.don5);
        dongasramyeon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_72);
                main_detailRecipeName.setText("  돈까스 라면");
                main_detailRecipeHowToCook.setText("1.라면을 끓여준다.\n" +
                        "2.대파를 썰어주고 남은 돈까스를 적당한 크기로 자른다.\n" +
                        "3.면을 70%정도만 익혀 따로 건져준 후 국물에 파와 계란을 넣어 저어준다.\n" +
                        "4.돈까스를 넣고 30초정도 더 끓여준다.\n" +
                        "5.면을 건져준 그릇에 끓여준 국물을 넣어 완성한다.\n");
            }
        });

        Button dongaskaredupbap_btn = dongas_pop.findViewById(R.id.don6);
        dongaskaredupbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_74);
                main_detailRecipeName.setText("  돈까스 카레덮밥");
                main_detailRecipeHowToCook.setText("1.남은 돈까스를 데워둔다.\n" +
                        "2.밥을 그릇에 모양을 잡아 얹어준다.\n" +
                        "3.밥 옆으로 돈까스를 잘라 올린다.\n" +
                        "4.그릇에 카레를 올려 완성한다.\n");
            }
        });
    }

    public void showpizzapopup() {
        pizza_pop.show();

        //팝업 기능 구현
        Button pizzamalato_btn = pizza_pop.findViewById(R.id.piz1);
        pizzamalato_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_7);
                main_detailRecipeName.setText("  피자 말아또");
                main_detailRecipeHowToCook.setText("1.다진파, 다진 마늘, 진간장, 설탕, 참기름을 섞어 양념을 만든다\n" +
                        "2.피자 조각의 끝부분을 잘라내고 반을 자른 뒤, 네모난 모양을 합친다\n" +
                        "3.달걀 지단을 만들고 그 위에 피자를 올린다\n" +
                        "4.야채나 불고기 등을 볶아 피자 위에 올린 뒤, 달걀 지단으로 돌돌 말아준다\n");
            }
        });

        Button pizzagratang_btn = pizza_pop.findViewById(R.id.piz2);
        pizzagratang_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_10);
                main_detailRecipeName.setText("  피자그라탕");
                main_detailRecipeHowToCook.setText("1.용기에 버터를 바른 후 감자를 잘게 으깨어 넣는다\n" +
                        "2.감자 위에 남은 피자를 먹기 좋은 크기로 잘라 올린다\n" +
                        "3.피자치즈를 듬뿍 얹은 후 전자레인지에 2분 30초를 돌려준다\n");
            }
        });

        Button nodepizzajun_btn = pizza_pop.findViewById(R.id.piz3);
        nodepizzajun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_21);
                main_detailRecipeName.setText("  누드피자전");
                main_detailRecipeHowToCook.setText("1.피자를 잘게 다진다\n" +
                        "2.뜨거운 물을 준비해 라이스페이퍼를 적신 후 접시에 펼쳐 놓는다\n" +
                        "3.정가운데 조미김을 깐 후 다진 피자를 얹는다. 그 위에 모차렐라 치즈를 얹고 조미김으로 덮은 후 라이스페이퍼로 감싼다\n" +
                        "4.팬에 기름을 두르고 노릇하게 구워 접시에 담는다\n" +
                        "5.한 번 더 팬에 기름을 둘러 마늘을 넣고 향을 낸 후 케첩 2, 설탕 2, 두반장 0.5, 굴소스 1 비율로 넣고 끓인다. ‘부먹’이든 ‘찍먹’이든 취향대로 맛있게 먹는다.  \n");
            }
        });

        Button pizzalabokki_btn = pizza_pop.findViewById(R.id.piz4);
        pizzalabokki_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_43);
                main_detailRecipeName.setText("  피자라볶이");
                main_detailRecipeHowToCook.setText("1.물에 양념(물 500ml, 고추장 1T, 고춧가루 1T, 설탕 2T, 간장 1T, 라면스프 1/2T)을 풀어준 뒤 불을 강불로 맞춘다.\n" +
                        "2.물이 끓으면 라면과 후레이크를 넣어준다. \n" +
                        "3.라면이 끓는동안 피자를 잘라준다.\n" +
                        "4.물엿을 넣은 후 면발이 익으면 중불로 바꿔줍니다.\n" +
                        "5.피자와 모짜렐라치즈를 넣어줍니다.\n" +
                        "6.약불에서 뚜껑을 덮고 1분간 기다려줍니다.\n" +
                        "6.그릇에 잘 담아주면 완성\n");
            }
        });

        Button spoonpizza_btn = pizza_pop.findViewById(R.id.piz5);
        spoonpizza_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_44);
                main_detailRecipeName.setText("  떠먹는 피자");
                main_detailRecipeHowToCook.setText("1.적당한 크기의 전자렌지 용기를 준비한다.\n" +
                        "2.피자를 먹기 좋은 크기로 잘라서 용기에 넣는다.\n" +
                        "3.잘라둔 피자 위에 핫소스를 뿌려준다.\n" +
                        "4.잘라둔 피자를 모두 덮을 수 있도록 모짜렐라 치즈를 뿌려준다.\n" +
                        "5.곳곳에 체다치즈를 올려준다.\n" +
                        "6.뚜껑을 덮어 전자렌지에 2분 돌려준다. \n");
            }
        });

        Button pizzafreetata_btn = pizza_pop.findViewById(R.id.piz6);
        pizzafreetata_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_45);
                main_detailRecipeName.setText("  피자 프리타타");
                main_detailRecipeHowToCook.setText("1.달걀 2개를 깨서 볼에 담은 후 소금 1T를 넣어 간을 맞춘다.\n" +
                        "2.우유 1/5컵을 넣어준다.\n" +
                        "3.남은 피자를 잘라 볼에 넣은 후 잘 섞어준다.\n" +
                        "4.반죽을 그릇에 담은 후 피자 치즈를 올려준다.\n" +
                        "5.전자렌지에 1분 40초 돌려준다.\n");
            }
        });
    }

    public void showchickenpopup() {
        chicken_pop.show();

        //팝업 기능 구현
        Button chickenmayodupbap_btn = chicken_pop.findViewById(R.id.chic1);
        chickenmayodupbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_2);
                main_detailRecipeName.setText("  치킨마요 덮밥");
                main_detailRecipeHowToCook.setText("1.남은 치킨과 대파를 함께 구워낸다. \n" +
                        "2.밥 위에 치킨과 대파, 마요네즈, 데리야끼 소스를 뿌린 뒤 김을 얹어 마무리 한다\n");
            }
        });

        Button carecheeseramyeond_btn = chicken_pop.findViewById(R.id.chic2);
        carecheeseramyeond_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_4);
                main_detailRecipeName.setText("  카레 치즈 라면");
                main_detailRecipeHowToCook.setText("1.남은 치킨 살을 발라낸다.\n" +
                        " 2.라면을 평소 끓이던 물의 양 절반 정도만 넣고 끓인다.\n" +
                        "3.면이 익으면 치킨과 카레를 넣고 졸이듯이 끓인 후 기호에 따라 치즈를 추가한다.\n");
            }
        });

        Button yangnyumchickenbonumbap_btn = chicken_pop.findViewById(R.id.chic3);
        yangnyumchickenbonumbap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_5);
                main_detailRecipeName.setText("  양념 치킨 볶음밥");
                main_detailRecipeHowToCook.setText("1.양념치킨을 잘게 찢는다(두 조각 정도는 찢지 말고 볶음밥과 곁들여 먹게 남겨둔다) \n" +
                        "2.양념과 밥을 함께 볶다가 마지막으로 치즈를 넣는다\n");
            }
        });

        Button chickenjun_btn = chicken_pop.findViewById(R.id.chic4);
        chickenjun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_6);
                main_detailRecipeName.setText("  치킨전");
                main_detailRecipeHowToCook.setText("1.먹다 남은 치킨 살을 프라이팬에 올린다\n" +
                        "2.달걀을 잘 풀고 청양고추를 넣어 치킨 살 위에 붓는다\n" +
                        "3.파채를 곁들여 먹는다\n");
            }
        });

        Button kjoonsalad_btn = chicken_pop.findViewById(R.id.chic5);
        kjoonsalad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_18);
                main_detailRecipeName.setText("  케이준 크루통샐러드");
                main_detailRecipeHowToCook.setText("1.치킨은 뼈를 제거하고 살 부분만 준비한다\n" +
                        "2.샐러드용 채소는 한입 크기로 썬 뒤 찬물에 담갔다가 건져 물기를 뺀다\n" +
                        "3.방울토마토는 꼭지를 떼고 2등분한다\n" +
                        "4.식빵은 모서리부분을 잘라내고 1×1cm로 썬다. 팬에 버터와 올리브유를 두르고 식빵을 넣어 볶다가 노릇해지면 허브를 넣고 불을 줄여 수분이 없어질 때까지 볶아낸다\n" +
                        "5.베이컨을 마른 팬에 바삭하게 구운 뒤 잘게 다진다\n" +
                        "6.볼에 베이컨과 나머지 재료를 넣고 잘 섞어 소스를 만든다\n" +
                        "7.샐러드 볼에 채소와 치킨, 크루통을 담고 소스와 파슬리를 뿌려낸다.\n" +
                        "<소스 만들기>\n" +
                        "베이컨 2장, 다진 양파 4큰술, 설탕 3큰술, 레몬즙 4큰술, 마요네즈 4큰술, 머스터드 3과1/2큰술 넣고 섞는다.\n");
            }
        });

        Button chickensnacklab_btn = chicken_pop.findViewById(R.id.chic6);
        chickensnacklab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_34);
                main_detailRecipeName.setText("  치킨 스낵랩");
                main_detailRecipeHowToCook.setText("1.남은 치킨을 살짝 데워서 따뜻하게 데운다\n" +
                        "2.치킨을 먹기 좋은 크기로 잘게 썰어준다\n" +
                        "3.마요네즈 4큰술, 허니머스타드 2큰술, 후추 작은 1큰술을 넣고 섞어 소스를 준비한다\n" +
                        "4.살짝 데운 또띠아 위에 양상추, 토마토 등 원하는 야채를 올려준다\n" +
                        "5.데운 치킨을 고르게 펴서 올려준다\n" +
                        "6.만든 소스를 뿌리고 돌돌 말아주면 스낵랩 완성!\n" +
                        "\n");
            }
        });
    }

    public void showyogurtpopup() {
        yogurt_pop.show();

        //팝업 기능 구현
        Button greekmomo_btn = yogurt_pop.findViewById(R.id.yog1);
        greekmomo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_65);
                main_detailRecipeName.setText("  그릭모모");
                main_detailRecipeHowToCook.setText("1. 복숭아 씨앗을 파낸다\n" +
                        "2. 그릭요거트로 복숭아의 빈 공간을 채운다.\n" +
                        "3. 접시에 꿀과 그래놀라를 뿌리고 그 위에 복숭아를 올린다\n");
            }
        });

        Button greekhobak_btn = yogurt_pop.findViewById(R.id.yog2);
        greekhobak_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_66);
                main_detailRecipeName.setText("  그릭 단호박");
                main_detailRecipeHowToCook.setText("1. 삶은 단호박의 속을 파낸다\n" +
                        "2. 파낸 속에 요거트와 꿀로 채운다\n" +
                        "3. 냉동실에 얼린다.\n");
            }
        });

        Button yogurtbagle_btn = yogurt_pop.findViewById(R.id.yog3);
        yogurtbagle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_67);
                main_detailRecipeName.setText("  요거트 베이글");
                main_detailRecipeHowToCook.setText("1. 베이글을 굽는다\n" +
                        "2. 과일과 그릭요거트를 섞는다\n" +
                        "3. 베이글 위에 과일 요거트를 바른다\n");
            }
        });

        Button yogurteggmayosandwichi_btn = yogurt_pop.findViewById(R.id.yog4);
        yogurteggmayosandwichi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_68);
                main_detailRecipeName.setText("  요거트 에그마요 샌드위치");
                main_detailRecipeHowToCook.setText("1. 삶은 계란을 으깨고 요거트 두스푼 그리고 소금과 설탕 약간 넣고 섞는다.\n" +
                        "2.식빵에 요거트를 바르고 요거트를 바른 식빵과 식빵사이에 으깬 삶은 계란을 올려준다\n");
            }
        });
    }

    public void showsnackpopup() {
        snack_pop.show();

        //팝업 기능 구현
        Button mashedpotato_btn = snack_pop.findViewById(R.id.snac1);
        mashedpotato_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_57);
                main_detailRecipeName.setText("  매쉬드 포테이토");
                main_detailRecipeHowToCook.setText("1. 감자과자에 뜨거운 물울 붓고 기다린다.\n" +
                        "2. 과자가 감자를 흡수하면 으깨서 저어준다\n");
            }
        });

        Button oreodisertcup_btn = snack_pop.findViewById(R.id.snac2);
        oreodisertcup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_81);
                main_detailRecipeName.setText("  오레오 디저트 컵");
                main_detailRecipeHowToCook.setText("1.오레오를 봉지에 넣고 막대기로 때려 잘게 부서준다\n" +
                        "2.초콜릿을 전자레인지에 넣어 녹여준다(4분)\n" +
                        "3.휘핑크림과 녹인 초콜릿을 섞어준다\n" +
                        "4.오레오 가루와 휘핑크림을 원하는 순서대로 쌓아준다\n" +
                        "5.오레오 쿠키로 장식해주면 완성\n");
            }
        });

        Button oreotiramisu_btn = snack_pop.findViewById(R.id.snac3);
        oreotiramisu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_83);
                main_detailRecipeName.setText("  오레오 티라미수");
                main_detailRecipeHowToCook.setText("1.생크림은 거품을 내서 준비해주고, 크림치즈는 부드럽게 풀어준 후 설탕과 플레인 요거트를 섞어 어느정도 섞이게 되면 생크림을 넣어서 섞어준다\n" +
                        "2.물과 에스프레소를 섞어 준비한다\n" +
                        "3.오레오는 크림과 분리 시킨 후, 통밀쿠키와 자레 부셔주고 앞에서 준비했던 커피에 섞어 반죽처럼 변할 때까지 저어준다\n" +
                        "4.적당한 용기에 반은 쿠키반죽을 채우고, 판은 크림으로 채워준다\n" +
                        "5.오레오 가루나 코코아 가루로 데코해주면 완성\n");
            }
        });

        Button cornmurfin_btn = snack_pop.findViewById(R.id.snac4);
        cornmurfin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_86);
                main_detailRecipeName.setText("  옥수수 머핀");
                main_detailRecipeHowToCook.setText("1.과자부스러기를 곱게 갈아서 우유, 계란 2개와 섞어 반죽해준다. 반죽이 부서지지 않고 뭉치도록 우유와 과자의 양을 조절한다\n" +
                        "2.옥수수캔이 물기를 빼준 루 계란 2개, 녹말가루, 버터, 치즈 1/2컵을 넣고 잘 섞어준다\n" +
                        "3.오븐(혹은 에어프라이기) 예열은 약 380F(190C)로 준비해둔다\n" +
                        "4. 머핀 종이컵에 반죽을 1/4 담아준 후 아까 섞어둔 옥수수를 2TBS씩 올리고 치즈를 약간 뿌려준 후 예열한 오븐에 20분 구워준다. 위가 노릇하게 구었으면 완성\n");
            }
        });

        Button ogamjafried_btn = snack_pop.findViewById(R.id.snac5);
        ogamjafried_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_89);
                main_detailRecipeName.setText("  오감자 후라이");
                main_detailRecipeHowToCook.setText("1.슬라이스치즈는 4등분하고, 스트링치즈는 찢어서 준비해준다\n" +
                        "2.접시에 오감자 과자를 넣어준다\n" +
                        "3.아까 준비해둔 치즈들을 올려준다\n" +
                        "4.전자레인지에 40초 돌려주면 완성\n");
            }
        });

        Button ganpongsayookang_btn = snack_pop.findViewById(R.id.snac6);
        ganpongsayookang_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_90);
                main_detailRecipeName.setText("  깐풍소스 새우깡");
                main_detailRecipeHowToCook.setText("1.고추와 대파, 양파를 잘게 다져서 준비한다\n" +
                        "2.식용유를 두른 후라이팬에 새우깡 2줌을 굴려가면서 바삭하게 구워서 준비한다\n" +
                        "3.고추기름과 식용유를 두른 후라이팬에 다진 채소를 넣고 볶아준다\n");
            }
        });
    }

    public void showicecreampopup() {
        icecream_pop.show();

        //팝업 기능 구현
        Button meronaddeok_btn = icecream_pop.findViewById(R.id.ice1);
        meronaddeok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_42);
                main_detailRecipeName.setText("  메로나 떡");
                main_detailRecipeHowToCook.setText("1.메로나3개를 미리 녹여준다\n" +
                        "2.찹쌀가루에 녹인 메로나를 넣어 잘 섞어준다\n" +
                        "3.반죽을 담은 그릇에 랩을 씌워 포크로 구멍을 내준 후 전자레인지에 2분 돌려준다\n" +
                        "4.그릇을 꺼내 반죽을 잘 저어준 후 다시 전자레인지에 2분 돌려준다\n" +
                        "5.다시 그릇을 꺼내 떡을 식혀주면서 치대주면서 섞어준다\n" +
                        "6.적당히 식고 적당한 찰기가 생겼다면 먹기 좋은 크기로 잘라 먹으면 된다\n");
            }
        });

        Button apogato_btn = icecream_pop.findViewById(R.id.ice2);
        apogato_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_56);
                main_detailRecipeName.setText("  아포가토");
                main_detailRecipeHowToCook.setText("1. 인스턴트 커피를 뜨거운 물에 녹인다.\n" +
                        "2. 아이스크림을 한 스쿱 떠서 그릇에 올린다\n" +
                        "3. 녹인 인스턴트 커피를 아이스크림 위에 뿌린다.\n");
            }
        });

        Button icecramsandwichi_btn = icecream_pop.findViewById(R.id.ice3);
        icecramsandwichi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_73);
                main_detailRecipeName.setText("  아이스크림 샌드위치");
                main_detailRecipeHowToCook.setText("(굳이 투게더 아이스크림이 아니라도 좋다! 원하는 맛의 아이스크림이 있으면 오케이!)\n" +
                        "1.아이스크림을 스쿱이나 큰 숟가락으로 크게 떠서 쿠키나 와플 과자 위에 올린다\n" +
                        "2.또 다른 쿠키나 와플 과자를 뚜껑처럼 얹고 힘을 살살 주면서 누른 후 과자 사이로 튀어나온 아이스크림을 숟가락 뒷면이나 버터 나이프 등으로 둥글게 다듬는다\n" +
                        "3.아이스크림이 노출된 부분은 취향에 따라 스프링클이나 견과류 등으로 장식한다\n");
            }
        });

        Button togetherpudding_btn = icecream_pop.findViewById(R.id.ice4);
        togetherpudding_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_75);
                main_detailRecipeName.setText("  백종원표 투게더 빵 푸딩");
                main_detailRecipeHowToCook.setText("1.달걀 2개에 설탕 2숟가락을 넣어 계란을 풀어준다\n" +
                        "2.푼 계란을 아이스크림에 넣고 섞어준다\n" +
                        "3.아이스크림과 잘게 뜯은 빵을 충분히 섞어준 후 전자레인지에 5분 돌려주면 완성\n" +
                        "\n");
            }
        });

        Button icecreamthigim_btn = icecream_pop.findViewById(R.id.ice5);
        icecreamthigim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_76);
                main_detailRecipeName.setText("  아이스크림 튀김");
                main_detailRecipeHowToCook.setText("1.남은 아이스크림을 동그랗게 퍼준 후 컵이나 그릇에 올려 30분동안 냉동실에 넣어준다\n" +
                        "2.아이스크림이 냉동실에서 얼리는 동안 밀가루 1/2컵, 물 1/2컵, 계란 1개를 섞어 반죽을 준비해준다\n" +
                        "3.얼린 아이스크림을 꺼내 빵가루를 묻혀준다\n" +
                        "4.미리 만들어둔 반죽을 빵가루 묻은 아이스크림에 꼼꼼히 발라준다\n" +
                        "5.다시 한번 더 빵가루를 묻혀준다\n" +
                        "6.기름을 올려둔 후라이팬의 기름이 적당한 온도(기름에 넣은 튀김가루가 3초 후 떠오르면 ok)가 되면 아이스크림을 10초간 튀겨준다\n" +
                        "7.취향에 맞는 시럽을 튀김에 뿌려 마무리\n");
            }
        });

        Button icecramflot_btn = icecream_pop.findViewById(R.id.ice6);
        icecramflot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe_popup.show();

                main_detailRecipeImage = recipe_popup.findViewById(R.id.cookImage);
                main_detailRecipeName = recipe_popup.findViewById(R.id.recipe_name);
                main_detailRecipeHowToCook = recipe_popup.findViewById(R.id.recipeText);

                main_detailRecipeImage.setImageResource(R.drawable.img_79);
                main_detailRecipeName.setText("  아이스크림 플로트");
                main_detailRecipeHowToCook.setText("1.살구를 깨끗이 씻은 후 1 개는 4등분해서 남겨두고, 나머지는 껍질을 벗겨 씨를 빼내고 즙을 내린다\n" +
                        "2.잔에 얼음을 가득 채운 후 살구 즙과 오렌지 주스를 부어 잘 섞어준다\n" +
                        "3.음료 위에 아이스크림을 한 스쿱 올린 후 4등분 했던 살구로 장식하면 완성\n");
            }
        });
    }
}
