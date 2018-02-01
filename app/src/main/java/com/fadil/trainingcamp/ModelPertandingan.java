package com.fadil.trainingcamp;

/**
 * Created by MUL23 on 2/1/2018.
 */

public class ModelPertandingan {
    private String timSatu;
    private String timDua;
    private int logoTimSatu;
    private int logoTimDua;

    public ModelPertandingan(String timSatu, String timDua, int logoTimSatu, int logoTimDua) {
        this.timSatu = timSatu;
        this.timDua = timDua;
        this.logoTimSatu = logoTimSatu;
        this.logoTimDua = logoTimDua;
    }

    public String getTimSatu() {
        return timSatu;
    }

    public String getTimDua() {
        return timDua;
    }

    public int getLogoTimSatu() {
        return logoTimSatu;
    }

    public int getLogoTimDua() {
        return logoTimDua;
    }
}
