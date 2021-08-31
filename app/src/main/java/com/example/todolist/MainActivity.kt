package com.example.todolist

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatingActionButton.setOnClickListener {
            showAddNoteDialog()
        }
    }

    private fun showAddNoteDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_add_new_note)
        dialog.setCancelable(true)

        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog.window!!.attributes)
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT

        val etNoteTitle: EditText = dialog.findViewById(R.id.etNoteTitle)
        val etNoteDescription:EditText = dialog.findViewById(R.id.etNoteDescription)

        dialog.findViewById<Button>(R.id.btnCancel).setOnClickListener {
            dialog.dismiss()
        }

        dialog.findViewById<Button>(R.id.btAddNote).setOnClickListener {
            if (inputCheck(etNoteTitle.text.toString(), etNoteDescription.text.toString())) {
         Toast.makeText(this, etNoteTitle.text.toString()+"\n"+etNoteDescription.text.toString(),Toast.LENGTH_SHORT).show()
            }
        }

        dialog.show()
        dialog.window!!.attributes = layoutParams


    }

    private fun inputCheck(noteTitle: String, noteDescription: String): Boolean {
return !(TextUtils.isEmpty(noteTitle) && TextUtils.isEmpty(noteDescription))
    }
}