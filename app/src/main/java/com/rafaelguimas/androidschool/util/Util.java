package com.rafaelguimas.androidschool.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.rafaelguimas.androidschool.R;

import java.util.List;

import io.github.kbiakov.codeview.highlight.ColorTheme;

/**
 * Created by Rafael on 20/09/2016.
 */
public class Util {
    private static String DEFAULT_LANGUAGE = "java";

    public static ColorTheme getDefaultCodeTheme() {
        return ColorTheme.MONOKAI;
    }

    public static int getDefaultCodeBg(Context context) {
        return ContextCompat.getColor(context, R.color.bgPrimaryColor);
    }

    public static String getDefaultCodeLanguage() {
        return DEFAULT_LANGUAGE;
    }

    public static String getStringFromCodeList(List<String> codeList) {
        String code = "";

        for (int i = 0; i < codeList.size(); i++) {
            String line = codeList.get(i);
            code += i != codeList.size()-1 ? line + "\n" : line;
        }

        return code;
    }

    public static int[] getColorsArray(Context context) {
        int[] colors = new int[8];

        colors[0] = ContextCompat.getColor(context, R.color.materialRed);
        colors[1] = ContextCompat.getColor(context, R.color.materialPink);
        colors[2] = ContextCompat.getColor(context, R.color.materialPurple);
        colors[3] = ContextCompat.getColor(context, R.color.materialBlue);
        colors[4] = ContextCompat.getColor(context, R.color.materialGreen);
        colors[5] = ContextCompat.getColor(context, R.color.materialYellow);
        colors[6] = ContextCompat.getColor(context, R.color.materialOrange);
        colors[7] = ContextCompat.getColor(context, R.color.materialBrown);

        return colors;
    }

    public static String getHexFromIntColor(int color) {
        return String.format("#%06X", (0xFFFFFF & color));
    }

    public static void showEvaluateDialog(final Context context) {
        // Declara as preferencias
        final SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.title_shared_preferences), -1);

        // Declara a view interna
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_classification, null);
        final RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        final EditText etxtObs = (EditText) view.findViewById(R.id.etxtObs);

        // Exibe os dados ja salvos
        int stars = sharedPreferences.getInt(context.getString(R.string.pref_stars), -1);
        String obs = sharedPreferences.getString(context.getString(R.string.pref_obs), "---");
        if (stars != -1) {
            ratingBar.setProgress(stars);
        }
        if (obs != "---") {
            etxtObs.setText(obs);
        }

        new AlertDialog.Builder(context)
                .setTitle(R.string.title_evaluate)
                .setView(view)
                .setPositiveButton(R.string.text_send, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Recupera os valores
                        int stars = ratingBar.getProgress();
                        String obs = etxtObs.getText().toString();

                        // Salva o resultado no Firebase
                        String key = FirebaseUtil.saveClassification(stars, obs, context);

                        // Atualiza as preferencias
                        sharedPreferences.edit()
                                .putBoolean(context.getString(R.string.pref_evaluate), true)
                                .putInt(context.getString(R.string.pref_stars), stars)
                                .putString(context.getString(R.string.pref_obs), obs)
                                .putString(context.getString(R.string.pref_firebase_key), key)
                                .apply();

                        // Exibe mensagem de gratidao
                        Toast.makeText(context, context.getString(R.string.text_thanks), Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton(R.string.text_cancel, null)
                .show();
    }

}
