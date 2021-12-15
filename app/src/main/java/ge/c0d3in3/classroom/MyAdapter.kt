package ge.c0d3in3.classroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalStateException

class MyAdapter(private val items: List<Item>) : RecyclerView.Adapter<MyAdapter.BaseViewHolder>() {


    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun onBind(item: Item)
    }

    class HeaderViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun onBind(item: Item) {
            val textView = itemView.findViewById<TextView>(R.id.headerTv)
            textView.text = item.text
        }
    }

    class TextViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun onBind(item: Item) {
            val textView = itemView.findViewById<TextView>(R.id.textTv)
            textView.text = item.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            HEADER -> HeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.header_item, parent, false)
            )
            TEXT -> TextViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.text_item, parent, false)
            )
            else -> throw IllegalStateException("wrong type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].type == Type.HEADER) HEADER
        else TEXT
    }

    companion object {
        private const val HEADER = 0
        private const val TEXT = 1
    }

    override fun getItemCount() = items.size
}