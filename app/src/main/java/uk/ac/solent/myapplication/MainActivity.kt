package uk.ac.solent.myapplication

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View.OnClickListener
import android.widget.EditText
import org.jetbrains.anko.editText
import uk.ac.solent.myapplication.R.id.btn
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        btn.setOnClickListener {



            val task = object : AsyncTask<String, Void, String>() {

                override fun doInBackground(vararg params: String): String {

                    val url = URL("http://www.free-map.org.uk/course/ws/hits.php?artist=${params[0]}")
                    return url.readText()
                }

                override fun onPostExecute(results: String) {
                   // new AlertDialog.Builder(MainActivity.this)
                    // set text of TextView to 'results'...
                    val resultsList = results
                    tvresults.setText(results)

                }
            }

            val artistText = artist.getText().toString()
            task.execute(artistText) // what the user entered in the text field, not Madonna



        }
    }

}




