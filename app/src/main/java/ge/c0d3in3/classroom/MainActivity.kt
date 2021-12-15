package ge.c0d3in3.classroom

import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private val parser = HtmlParser()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = parser.parse(HTML)
        val adapter = MyAdapter(items)
        val rv = findViewById<RecyclerView>(R.id.recyclerViewStatus)
        rv.layoutManager = LinearLayoutManager(baseContext)
        rv.adapter = adapter
    }
}