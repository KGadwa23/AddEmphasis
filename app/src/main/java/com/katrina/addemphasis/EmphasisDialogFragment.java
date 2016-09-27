package com.katrina.addemphasis;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.CheckBox;

/**
 * Created by jm7463pn on 9/27/16.
 */
public class EmphasisDialogFragment extends DialogFragment {

    private CheckBox mCapitalize;


    final CharSequence[] EMPHASIS_CHOICES = {"Capitalize", "Exclamation Point", "Smiley Face"};
    final int[] EMPHASIS_VALUES = {  }; //TODO- add check boxes-maybe part of .xml file?

    //TODO Interface for the listener??

    public void capitalize() {
        //TODO - separate dialog fragments for each emphasis choice? address multiple choices made
    }   //TODO http://stackoverflow.com/questions/4434588/is-there-a-way-to-style-a-textview-to-uppercase-all-of-its-letters

    interface EmphasisDialogFragmentListener {
        void userClickedOk();
        void userClickedCancel();
    }

    EmphasisDialogFragmentListener mDialogListener;

    public static EmphasisDialogFragment newInstance() {
        EmphasisDialogFragment fragment = new EmphasisDialogFragment();
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof EmphasisDialogFragmentListener) {
            mDialogListener = (EmphasisDialogFragmentListener) activity;
        } else {
            throw new RuntimeException(activity.toString() +
            " must implement EmphasisDialogFragmentListener");
        }
    }

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        AlertDialog dialog = builder.setTitle("Emphasis Choices")
                .setMessage("What emphasis would you like?")
                //.setMultiChoiceItems(boolean[] )    //TODO- how to finish out ...
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDialogListener.userClickedOk();
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDialogListener.userClickedCancel();
                    }
                })
                .create();

        return dialog;
    }
}
