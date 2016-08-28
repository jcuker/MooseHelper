package com.cukes.moosehelper;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //There has to be a better way to keep track of these 'X's
    //Making all these buttons and whatnot doesn't seem right
    public static final String x = "X";
    public static final String xx = "XX";
    public static final String xxx= "XXX";
    public static int return_val = 0;
    public static int triple_return_val = 0;

    public static boolean ADD = true;

    TextView player1;
    TextView player2;


    Button done;


    TextView player1_score;
    TextView player2_score;
    public Integer player1_numeric_val = 0;
    public Integer player2_numeric_val = 0;
    Dialog d_t_score_picker;

    TextView player1_score_20;
    TextView player1_score_19;
    TextView player1_score_18;
    TextView player1_score_17;
    TextView player1_score_16;
    TextView player1_score_15;
    TextView player1_score_14;
    TextView player1_score_13;
    TextView player1_score_12;
    TextView player1_score_11;
    TextView player1_score_10;
    TextView player1_score_B;
    TextView player1_score_D;
    TextView player1_score_T;

    TextView player2_score_20;
    TextView player2_score_19;
    TextView player2_score_18;
    TextView player2_score_17;
    TextView player2_score_16;
    TextView player2_score_15;
    TextView player2_score_14;
    TextView player2_score_13;
    TextView player2_score_12;
    TextView player2_score_11;
    TextView player2_score_10;
    TextView player2_score_B;
    TextView player2_score_D;
    TextView player2_score_T;

    RadioButton Add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //again how can i get rid of all these buttons and replace them with an easier
        //or better solution??



        //setTitle("");
        //android.support.v7.app.ActionBar bar = getSupportActionBar();
        //bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#37474F")));

        //my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(my_toolbar);

        Add_button = (RadioButton) findViewById(R.id.add_radio);
        d_t_score_picker = new Dialog(this);
        d_t_score_picker.setContentView(R.layout.d_t_score_picker);
        d_t_score_picker.getWindow().setLayout(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        player1 = (TextView) findViewById(R.id.player1_name);
        player1_score = (TextView) findViewById(R.id.player1_score);
        player1_score.setText("0");
        player1_score_20 = (TextView) findViewById(R.id.player1_20);
        player1_score_19 = (TextView) findViewById(R.id.player1_19);
        player1_score_18 = (TextView) findViewById(R.id.player1_18);
        player1_score_17 = (TextView) findViewById(R.id.player1_17);
        player1_score_16 = (TextView) findViewById(R.id.player1_16);
        player1_score_15 = (TextView) findViewById(R.id.player1_15);
        player1_score_14 = (TextView) findViewById(R.id.player1_14);
        player1_score_13 = (TextView) findViewById(R.id.player1_13);
        player1_score_12 = (TextView) findViewById(R.id.player1_12);
        player1_score_11 = (TextView) findViewById(R.id.player1_11);
        player1_score_10 = (TextView) findViewById(R.id.player1_10);
        player1_score_B = (TextView) findViewById(R.id.player1_B);
        player1_score_D = (TextView) findViewById(R.id.player1_D);
        player1_score_T = (TextView) findViewById(R.id.player1_T);


        player2 = (TextView) findViewById(R.id.player2_name);
        player2_score = (TextView) findViewById(R.id.player2_score);
        player2_score.setText("0");
        player2_score_20 = (TextView) findViewById(R.id.player2_20);
        player2_score_19 = (TextView) findViewById(R.id.player2_19);
        player2_score_18 = (TextView) findViewById(R.id.player2_18);
        player2_score_17 = (TextView) findViewById(R.id.player2_17);
        player2_score_16 = (TextView) findViewById(R.id.player2_16);
        player2_score_15 = (TextView) findViewById(R.id.player2_15);
        player2_score_14 = (TextView) findViewById(R.id.player2_14);
        player2_score_13 = (TextView) findViewById(R.id.player2_13);
        player2_score_12 = (TextView) findViewById(R.id.player2_12);
        player2_score_11 = (TextView) findViewById(R.id.player2_11);
        player2_score_10 = (TextView) findViewById(R.id.player2_10);
        player2_score_B = (TextView) findViewById(R.id.player2_B);
        player2_score_D = (TextView) findViewById(R.id.player2_D);
        player2_score_T = (TextView) findViewById(R.id.player2_T);

        showDialogInput();

    }

    void showDialogInput(){
        final Dialog names_dialog = new Dialog(this);
        names_dialog.setContentView(R.layout.dailog_names);
        names_dialog.getWindow().setLayout(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        final EditText name1 = (EditText) names_dialog.findViewById(R.id.name1);
        final EditText name2 = (EditText) names_dialog.findViewById(R.id.name2);

        Button dialogButton = (Button) names_dialog.findViewById(R.id.ok);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //player1
                player1.setText(name1.getText().toString());


                //player2
                player2.setText(name2.getText().toString());



                names_dialog.dismiss();
            }
        });
        names_dialog.show();
    }


    public boolean isClosed(TextView player_score_box){
        return player_score_box.getText().toString().equals("XXX");
    }

    public int doubleScoreCalc (final int player){
        return_val = 0;

        //return double the number of the score
        final Button _20 = (Button) d_t_score_picker.findViewById(R.id.button_20);
        _20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(40, player);
                d_t_score_picker.dismiss();
            }
            });
        final Button _19 = (Button) d_t_score_picker.findViewById(R.id.button_19);
        _19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(38, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _18 = (Button) d_t_score_picker.findViewById(R.id.button_18);
        _18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(36, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _17 = (Button) d_t_score_picker.findViewById(R.id.button_17);
        _17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(34, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _16 = (Button) d_t_score_picker.findViewById(R.id.button_16);
        _16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(32, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _15 = (Button) d_t_score_picker.findViewById(R.id.button_15);
        _15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(30, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _14 = (Button) d_t_score_picker.findViewById(R.id.button_14);
        _14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(28, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _13 = (Button) d_t_score_picker.findViewById(R.id.button_13);
        _13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(26, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _12 = (Button) d_t_score_picker.findViewById(R.id.button_12);
        _12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(24, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _11 = (Button) d_t_score_picker.findViewById(R.id.button_11);
        _11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(22, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _10 = (Button) d_t_score_picker.findViewById(R.id.button_10);
        _10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(20, player);
                d_t_score_picker.dismiss();
            }
        });


        d_t_score_picker.show();

        return return_val;
    }

    public int tripleScoreCalc(final int player){
        //return triple the number
        final Button _20 = (Button) d_t_score_picker.findViewById(R.id.button_20);
        triple_return_val = 0;
        _20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(60, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _19 = (Button) d_t_score_picker.findViewById(R.id.button_19);
        _19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(57, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _18 = (Button) d_t_score_picker.findViewById(R.id.button_18);
        _18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(54, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _17 = (Button) d_t_score_picker.findViewById(R.id.button_17);
        _17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(51, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _16 = (Button) d_t_score_picker.findViewById(R.id.button_16);
        _16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(48, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _15 = (Button) d_t_score_picker.findViewById(R.id.button_15);
        _15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(45, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _14 = (Button) d_t_score_picker.findViewById(R.id.button_14);
        _14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(42, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _13 = (Button) d_t_score_picker.findViewById(R.id.button_13);
        _13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(39, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _12 = (Button) d_t_score_picker.findViewById(R.id.button_12);
        _12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(36, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _11 = (Button) d_t_score_picker.findViewById(R.id.button_11);
        _11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(33, player);
                d_t_score_picker.dismiss();
            }
        });
        final Button _10 = (Button) d_t_score_picker.findViewById(R.id.button_10);
        _10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(30, player);
                d_t_score_picker.dismiss();
            }
        });


        d_t_score_picker.show();
        return return_val;
    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.add_radio:
                if (checked)
                    ADD = true;
                    break;
            case R.id.remove_radio:
                if (checked)
                    ADD = false;
                    break;
        }
    }

    public void onScoreClick (View view){
        final Dialog score_updater = new Dialog(this);
        score_updater.setContentView(R.layout.score_updater);
        final TextView new_score_view = (TextView) score_updater.findViewById(R.id.new_score);
        score_updater.show();
        Button done = (Button) score_updater.findViewById(R.id.ok_score);
        switch(view.getId()){
            case R.id.player1_scorebox:
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String temp;
                        Integer new_score;
                        temp = new_score_view.getText().toString();
                        new_score = Integer.valueOf(temp);
                        player1_numeric_val = 0;
                        updateScore(new_score, 1);
                        score_updater.dismiss();
                    }
                });

                break;

            case R.id.player2_scorebox:
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String temp;
                        Integer new_score;
                        temp = new_score_view.getText().toString();
                        new_score = Integer.valueOf(temp);
                        player2_numeric_val = 0;
                        updateScore(new_score, 2);
                        score_updater.dismiss();
                    }
                });
                break;
        }
    }


    public void master_switch(View view){

        final Dialog score_dialog = new Dialog(this);
        Add_button = (RadioButton) findViewById(R.id.add_radio);
        done = (Button) findViewById(R.id.done);
        score_dialog.setContentView(R.layout.dialog_score_picker);
        score_dialog.getWindow().setLayout(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        String name = ((TextView) view).getText().toString();
        ADD = true;


        if(name.equals(player1.getText().toString())){

            score_dialog.setContentView(R.layout.dialog_score_picker);
            final Button _20 = (Button) score_dialog.findViewById(R.id.button_20);
            _20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_20.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_20.setText(x);
                                break;

                            case 1:
                                player1_score_20.setText(xx);
                                break;

                            case 2:
                                player1_score_20.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_20)){
                                    updateScore(20, 1);
                                }
                                break;
                        }
                    }
                    else{
                        String temp = player1_score_20.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_20.setText(xx);
                                break;

                            case 2:
                                player1_score_20.setText(xx);
                                break;

                            case 1:
                                player1_score_20.setText("");
                                break;
                        }
                    }
                }
            });
          final Button _19 = (Button) score_dialog.findViewById(R.id.button_19);
            _19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_19.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_19.setText(x);
                                break;

                            case 1:
                                player1_score_19.setText(xx);
                                break;

                            case 2:
                                player1_score_19.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_19)) updateScore(19, 1);
                                break;
                        }

                    }
                    else{
                        String temp = player1_score_19.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_19.setText(xx);
                                break;

                            case 2:
                                player1_score_19.setText(xx);
                                break;

                            case 1:
                                player1_score_19.setText("");
                                break;
                        }

                    }
                }
            });
          final Button _18 = (Button) score_dialog.findViewById(R.id.button_18);
            _18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_18.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_18.setText(x);
                                break;

                            case 1:
                                player1_score_18.setText(xx);
                                break;

                            case 2:
                                player1_score_18.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_18)) updateScore(18, 1);
                                break;
                        }

                    }
                    else{
                        String temp = player1_score_18.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_18.setText(xx);
                                break;

                            case 2:
                                player1_score_18.setText(xx);
                                break;

                            case 1:
                                player1_score_18.setText("");
                                break;
                        }
                    }
                }
            });
          final Button _17 = (Button) score_dialog.findViewById(R.id.button_17);
            _17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_17.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_17.setText(x);
                                break;

                            case 1:
                                player1_score_17.setText(xx);
                                break;

                            case 2:
                                player1_score_17.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_17)) updateScore(17, 1);
                                break;
                        }
                    }
                    else{
                        String temp = player1_score_17.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_17.setText(xx);
                                break;

                            case 2:
                                player1_score_17.setText(x);
                                break;

                            case 1:
                                player1_score_17.setText("");
                                break;
                        }
                    }
                }
            });
          final Button _16 = (Button) score_dialog.findViewById(R.id.button_16);
            _16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_16.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_16.setText(x);
                                break;

                            case 1:
                                player1_score_16.setText(xx);
                                break;

                            case 2:
                                player1_score_16.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_16)) updateScore(16, 1);
                                break;
                        }
                    }
                    else{
                        String temp = player1_score_16.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_16.setText(xx);
                                break;

                            case 2:
                                player1_score_16.setText(xx);
                                break;

                            case 1:
                                player1_score_16.setText("");
                                break;
                        }
                    }
                }
            });
          final Button _15 = (Button) score_dialog.findViewById(R.id.button_15);
            _15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_15.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_15.setText(x);
                                break;

                            case 1:
                                player1_score_15.setText(xx);
                                break;

                            case 2:
                                player1_score_15.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_15)) updateScore(15, 1);
                                break;
                        }
                    }
                    else{
                        String temp = player1_score_15.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_15.setText(xx);
                                break;

                            case 2:
                                player1_score_15.setText(xx);
                                break;

                            case 1:
                                player1_score_15.setText("");
                                break;
                        }
                    }
                }
            });
          final Button _14 = (Button) score_dialog.findViewById(R.id.button_14);
            _14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_14.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_14.setText(x);
                                break;

                            case 1:
                                player1_score_14.setText(xx);
                                break;

                            case 2:
                                player1_score_14.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_14)) updateScore(14, 1);
                                break;
                        }
                    }
                    else{
                        String temp = player1_score_14.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_14.setText(xx);
                                break;

                            case 2:
                                player1_score_14.setText(xx);
                                break;

                            case 1:
                                player1_score_14.setText("");
                                break;
                        }
                    }
                }
            });
          final Button _13 = (Button) score_dialog.findViewById(R.id.button_13);
            _13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_13.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_13.setText(x);
                                break;

                            case 1:
                                player1_score_13.setText(xx);
                                break;

                            case 2:
                                player1_score_13.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_13)) updateScore(13, 1);
                                break;
                        }
                    }
                    else{
                        String temp = player1_score_13.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_13.setText(xx);
                                break;

                            case 2:
                                player1_score_13.setText(xx);
                                break;

                            case 1:
                                player1_score_13.setText("");
                                break;
                        }
                    }
                }
            });
          final Button _12 = (Button) score_dialog.findViewById(R.id.button_12);
            _12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_12.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_12.setText(x);
                                break;

                            case 1:
                                player1_score_12.setText(xx);
                                break;

                            case 2:
                                player1_score_12.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_12))updateScore(12, 1);
                                break;
                        }
                    }
                    else{
                        String temp = player1_score_12.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_12.setText(xx);
                                break;

                            case 2:
                                player1_score_12.setText(xx);
                                break;

                            case 1:
                                player1_score_12.setText("");
                                break;


                        }
                    }
                }
            });
          final Button _11 = (Button) score_dialog.findViewById(R.id.button_11);
            _11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_11.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_11.setText(x);
                                break;

                            case 1:
                                player1_score_11.setText(xx);
                                break;

                            case 2:
                                player1_score_11.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_11)) updateScore(11, 1);
                                break;
                        }
                    }
                    else{
                        String temp = player1_score_11.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_11.setText(xx);
                                break;

                            case 2:
                                player1_score_11.setText(xx);
                                break;

                            case 1:
                                player1_score_11.setText("");
                                break;
                        }
                    }
                }
            });
          final Button _10 = (Button) score_dialog.findViewById(R.id.button_10);
            _10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_10.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_10.setText(x);
                                break;

                            case 1:
                                player1_score_10.setText(xx);
                                break;

                            case 2:
                                player1_score_10.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_10)) updateScore(10, 1);
                                break;
                        }
                    }
                    else{
                        String temp = player1_score_10.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_10.setText(xx);
                                break;

                            case 2:
                                player1_score_10.setText(xx);
                                break;

                            case 1:
                                player1_score_10.setText("");
                                break;
                        }
                    }
                }
            });
          final Button B = (Button) score_dialog.findViewById(R.id.button_B);
            B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_B.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_B.setText(x);
                                break;

                            case 1:
                                player1_score_B.setText(xx);
                                break;

                            case 2:
                                player1_score_B.setText(xxx);
                                break;


                        }
                    }
                    else{
                        String temp = player1_score_B.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_B.setText(xx);
                                break;

                            case 2:
                                player1_score_B.setText(xx);
                                break;

                            case 1:
                                player1_score_B.setText("");
                                break;
                        }
                    }
                }
            });
          final Button D = (Button) score_dialog.findViewById(R.id.button_D);
            D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_D.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_D.setText(x);
                                break;

                            case 1:
                                player1_score_D.setText(xx);
                                break;

                            case 2:
                                player1_score_D.setText(xxx);
                                break;

                            case 3:
                                if(!isClosed(player2_score_D)) player1_numeric_val += doubleScoreCalc(1);
                                break;
                        }
                        String set_score = player1_numeric_val.toString();
                        player1_score.setText(set_score);

                    }
                    else{
                        String temp = player1_score_D.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_D.setText(xx);
                                break;

                            case 2:
                                player1_score_D.setText(xx);
                                break;

                            case 1:
                                player1_score_D.setText("");
                                break;
                        }
                    }
                }
            });
          final Button T = (Button) score_dialog.findViewById(R.id.button_T);
            T.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ADD){
                        String temp = player1_score_T.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player1_score_T.setText(x);
                                break;

                            case 1:
                                player1_score_T.setText(xx);
                                break;

                            case 2:
                                player1_score_T.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player2_score_T)) player1_numeric_val += tripleScoreCalc(1);
                                break;
                        }
                    }
                    else{
                        String temp = player1_score_T.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player1_score_T.setText(xx);
                                break;

                            case 2:
                                player1_score_T.setText(xx);
                                break;

                            case 1:
                                player1_score_T.setText("");
                                break;
                        }
                    }
                }
            });


            final Button done = (Button) score_dialog.findViewById(R.id.done);
            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    score_dialog.dismiss();
                }

            });
        }


        else if(name.equals(player2.getText().toString())) {
            score_dialog.setContentView(R.layout.dialog_score_picker);
            final Button _20 = (Button) score_dialog.findViewById(R.id.button_20);
            _20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_20.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_20.setText(x);
                                break;

                            case 1:
                                player2_score_20.setText(xx);
                                break;

                            case 2:
                                player2_score_20.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_20)) updateScore(20, 2);
                                break;

                        }
                    } else {
                        String temp = player2_score_20.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_20.setText(xx);
                                break;

                            case 2:
                                player2_score_20.setText(xx);
                                break;

                            case 1:
                                player2_score_20.setText("");
                                break;
                        }
                    }
                }
            });
            final Button _19 = (Button) score_dialog.findViewById(R.id.button_19);
            _19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_19.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_19.setText(x);
                                break;

                            case 1:
                                player2_score_19.setText(xx);
                                break;

                            case 2:
                                player2_score_19.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_19)) updateScore(19, 2);
                                break;
                        }
                    } else {
                        String temp = player2_score_19.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_19.setText(xx);
                                break;

                            case 2:
                                player2_score_19.setText(xx);
                                break;

                            case 1:
                                player2_score_19.setText("");
                                break;
                        }
                    }
                }
            });
            final Button _18 = (Button) score_dialog.findViewById(R.id.button_18);
            _18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_18.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_18.setText(x);
                                break;

                            case 1:
                                player2_score_18.setText(xx);
                                break;

                            case 2:
                                player2_score_18.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_18)) updateScore(18, 2);
                                break;
                        }
                    } else {
                        String temp = player2_score_18.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_18.setText(xx);
                                break;

                            case 2:
                                player2_score_18.setText(xx);
                                break;

                            case 1:
                                player2_score_18.setText("");
                                break;
                        }

                    }
                }
            });
            final Button _17 = (Button) score_dialog.findViewById(R.id.button_17);
            _17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_17.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_17.setText(x);
                                break;

                            case 1:
                                player2_score_17.setText(xx);
                                break;

                            case 2:
                                player2_score_17.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_17)) updateScore(17, 2);
                                break;
                        }

                    } else {
                        String temp = player2_score_17.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_17.setText(xx);
                                break;

                            case 2:
                                player2_score_17.setText(xx);
                                break;

                            case 1:
                                player2_score_17.setText("");
                                break;
                        }

                    }
                }
            });
            final Button _16 = (Button) score_dialog.findViewById(R.id.button_16);
            _16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_16.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_16.setText(x);
                                break;

                            case 1:
                                player2_score_16.setText(xx);
                                break;

                            case 2:
                                player2_score_16.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_16)) updateScore(16, 2);
                                break;
                        }

                    } else {
                        String temp = player2_score_16.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_16.setText(xx);
                                break;

                            case 2:
                                player2_score_16.setText(xx);
                                break;

                            case 1:
                                player2_score_16.setText("");
                                break;
                        }

                    }
                }
            });
            final Button _15 = (Button) score_dialog.findViewById(R.id.button_15);
            _15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_15.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_15.setText(x);
                                break;

                            case 1:
                                player2_score_15.setText(xx);
                                break;

                            case 2:
                                player2_score_15.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_15)) updateScore(15, 2);
                                break;
                        }

                    } else {
                        String temp = player2_score_15.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_15.setText(xx);
                                break;

                            case 2:
                                player2_score_15.setText(xx);
                                break;

                            case 1:
                                player2_score_15.setText("");
                                break;
                        }

                    }
                }
            });
            final Button _14 = (Button) score_dialog.findViewById(R.id.button_14);
            _14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_14.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_14.setText(x);
                                break;

                            case 1:
                                player2_score_14.setText(xx);
                                break;

                            case 2:
                                player2_score_14.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_14)) updateScore(14, 2);
                                break;
                        }

                    } else {
                        String temp = player2_score_14.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_14.setText(xx);
                                break;

                            case 2:
                                player2_score_14.setText(xx);
                                break;

                            case 1:
                                player2_score_14.setText("");
                                break;
                        }

                    }
                }
            });
            final Button _13 = (Button) score_dialog.findViewById(R.id.button_13);
            _13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_13.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_13.setText(x);
                                break;

                            case 1:
                                player2_score_13.setText(xx);
                                break;

                            case 2:
                                player2_score_13.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_13)) updateScore(13, 2);
                                break;
                        }

                    } else {
                        String temp = player2_score_13.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_13.setText(xx);
                                break;

                            case 2:
                                player2_score_13.setText(xx);
                                break;

                            case 1:
                                player2_score_13.setText("");
                                break;
                        }

                    }
                }
            });
            final Button _12 = (Button) score_dialog.findViewById(R.id.button_12);
            _12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_12.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_12.setText(x);
                                break;

                            case 1:
                                player2_score_12.setText(xx);
                                break;

                            case 2:
                                player2_score_12.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_12)) updateScore(12, 2);
                                break;
                        }

                    } else {
                        String temp = player2_score_12.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_12.setText(xx);
                                break;

                            case 2:
                                player2_score_12.setText(xx);
                                break;

                            case 1:
                                player2_score_12.setText("");
                                break;
                        }

                    }
                }
            });
            final Button _11 = (Button) score_dialog.findViewById(R.id.button_11);
            _11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_11.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_11.setText(x);
                                break;

                            case 1:
                                player2_score_11.setText(xx);
                                break;

                            case 2:
                                player2_score_11.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_11)) updateScore(11, 2);
                                break;
                        }

                    } else {
                        String temp = player2_score_11.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_11.setText(xx);
                                break;

                            case 2:
                                player2_score_11.setText(xx);
                                break;

                            case 1:
                                player2_score_11.setText("");
                                break;
                        }

                    }
                }
            });
            final Button _10 = (Button) score_dialog.findViewById(R.id.button_10);
            _10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_10.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_10.setText(x);
                                break;

                            case 1:
                                player2_score_10.setText(xx);
                                break;

                            case 2:
                                player2_score_10.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_10)) updateScore(10, 2);
                                break;
                        }

                    } else {
                        String temp = player2_score_10.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_10.setText(xx);
                                break;

                            case 2:
                                player2_score_10.setText(xx);
                                break;

                            case 1:
                                player2_score_10.setText("");
                                break;
                        }

                    }
                }
            });
            final Button B = (Button) score_dialog.findViewById(R.id.button_B);
            B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_B.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_B.setText(x);
                                break;

                            case 1:
                                player2_score_B.setText(xx);
                                break;

                            case 2:
                                player2_score_B.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_B)) updateScore(25, 2);
                                break;
                        }

                    } else {
                        String temp = player2_score_B.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_B.setText(xx);
                                break;

                            case 2:
                                player2_score_B.setText(xx);
                                break;

                            case 1:
                                player2_score_B.setText("");
                                break;
                        }

                    }
                }
            });
            final Button D = (Button) score_dialog.findViewById(R.id.button_D);
            D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_D.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_D.setText(x);
                                break;

                            case 1:
                                player2_score_D.setText(xx);
                                break;

                            case 2:
                                player2_score_D.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_T))
                                    player2_numeric_val += doubleScoreCalc(2);
                                break;
                        }

                    } else {
                        String temp = player2_score_D.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_D.setText(xx);
                                break;

                            case 2:
                                player2_score_D.setText(xx);
                                break;

                            case 1:
                                player2_score_D.setText("");
                                break;
                        }

                    }
                }
            });
            final Button T = (Button) score_dialog.findViewById(R.id.button_T);
            T.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ADD) {
                        String temp = player2_score_T.getText().toString();
                        switch (temp.length()) {
                            case 0:
                                player2_score_T.setText(x);
                                break;

                            case 1:
                                player2_score_T.setText(xx);
                                break;

                            case 2:
                                player2_score_T.setText(xxx);
                                break;

                            case 3:
                                if (!isClosed(player1_score_T))
                                    player2_numeric_val += tripleScoreCalc(2);
                                break;
                        }

                    } else {
                        String temp = player2_score_T.getText().toString();
                        switch (temp.length()) {
                            case 3:
                                player2_score_T.setText(xx);
                                break;

                            case 2:
                                player2_score_T.setText(xx);
                                break;

                            case 1:
                                player2_score_T.setText("");
                                break;
                        }

                    }
                }
            });
            final Button done = (Button) score_dialog.findViewById(R.id.done);
            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    score_dialog.dismiss();
                }

            });
        }

        score_dialog.show();
    }


    public void onLongclickNewGame (View view){
        //doesn't quite work yet
        final Button new_game = (Button) findViewById(R.id.new_game);
        final Context context = getApplicationContext();
        new_game.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Title")
                        .setMessage("Do you really want to start a new game?")
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }})
                        .setNegativeButton("No", null).show();
                Toast.makeText(context, "l", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


    void updateScore(Integer score, int player){
        player1_score = (TextView) findViewById(R.id.player1_score);
        player2_score = (TextView) findViewById(R.id.player2_score);
        final Context context = getApplicationContext();
        final String confirm = " added to score.";
        final String num = score.toString();

        if(player == 1){
            player1_numeric_val += score;
            String set_score = player1_numeric_val.toString();
            player1_score.setText(set_score);
            Toast.makeText(context, num + confirm, Toast.LENGTH_SHORT).show();
        }

        else{
            player2_numeric_val += score;
            String set_score = player2_numeric_val.toString();
            player2_score.setText(set_score);
            Toast.makeText(context, num + confirm, Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void onStart() {
        super.onStart();


    }
}
