package com.rafaelguimas.acodemy;

import android.app.Application;
import android.content.Context;

import io.github.kbiakov.codeview.classifier.CodeProcessor;

/**
 * Created by Rafael on 05/10/2016.
 */

public class ApplicationMain extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        // Guarda o contexto para os enums
        mContext = this;

        // Inicializa a lib de codeview
        CodeProcessor.init(this);
    }

    public static Context getContext(){
        return mContext;
    }
}
