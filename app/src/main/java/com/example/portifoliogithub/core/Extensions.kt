package com.example.portifoliogithub.core

import android.app.Activity
import android.content.Context
import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

var TextInputLayout.text : String
    get() = editText?.text?.toString() ?: ""
    set(value){
        editText?.setText(value)
    }

fun View.hideSoftKeyboard(){
    val imn = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imn.hideSoftInputFromWindow(windowToken, 0)
}

fun Context.createDialog(block : MaterialAlertDialogBuilder.() -> Unit = {}) : AlertDialog {
    val builder = MaterialAlertDialogBuilder(this)
    builder.setPositiveButton(android.R.string.ok, null)
    block(builder)
    return builder.create()
}

fun Context.createProgressDialog() : AlertDialog {
    return createDialog{
        val padding = 16
        val progressbar = ProgressBar(this@createProgressDialog)
        progressbar.setPadding(padding, padding, padding, padding)
        setView(progressbar)

        setPositiveButton(null, null)
        setCancelable(false)
    }
}