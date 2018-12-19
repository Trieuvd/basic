package com.mor.trieuvd.basic;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;

public class TermDialog extends Dialog {
    public TermDialog(@NonNull Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        setContentView(R.layout.dialog_term);
    }
}
