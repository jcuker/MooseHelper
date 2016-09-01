package com.cukes.moosehelper;

import android.widget.TextView;

/**
 * Created by Jordan on 8/30/2016.
 */
public class scoreBox {
    private TextView score_number;
    private Integer player;
    private boolean closed;

    public scoreBox(){
        score_number = null;
        player = null;
        closed = false;
    }
    public void setScoreBox(TextView view){
        score_number = view;
    }
    public void setPlayer(Integer p){
        player = p;
    }
    public void setClosed(Boolean b){
        closed = b;
    }
    public boolean isClosed(){
        return closed;
    }
    public Integer getPlayer(){
        return player;
    }
    public TextView getScore_number() {
        return score_number;
    }

}
