package com.katrina.addemphasis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements EmphasisDialogFragment.EmphasisDialogFragmentListener {

    private TextView mDialogResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDialogResult = (TextView) findViewById(R.id.dialog_result_text);

        Button showDialog = (Button) findViewById(R.id.emphasis_button);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmphasisDialogFragment dialog = new EmphasisDialogFragment();
                dialog.show(getFragmentManager(), "Simple Dialog");
            }
        });


    }

    //TODO- need these if adding another dialog box??
    public void userClickedOk() {
        mDialogResult.setText("You clicked ok");
    }

    public void userClickedCancel() {
        mDialogResult.setText("You clicked cancel");
    }
}
