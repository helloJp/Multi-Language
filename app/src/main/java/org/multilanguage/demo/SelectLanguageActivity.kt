package org.multilanguage.demo

import android.app.Activity
import android.content.Intent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_select_language.*
import org.multilanguage.demo.utils.MultiLanguageManager

/**
 * @author jiangp
 * @date   2019-07-31.
 * @desc:
 */
class SelectLanguageActivity : BaseActivity() {

    companion object {
        fun start(context: Activity) = context.startActivityForResult(Intent(context, SelectLanguageActivity::class.java), MultiLanguageManager.CHANGE_LANGUAGE)
    }

    private var list: ArrayList<String> = ArrayList()

    private var adapter: ArrayAdapter<String>? = null

    override fun initLayout(): Int {
        return R.layout.activity_select_language
    }

    override fun initViewAndData() {
        resources.getStringArray(R.array.pref_language_titles).forEach {
            list.add(it)
        }

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            MultiLanguageManager.setPrefsLanguage(this, resources.getStringArray(R.array.pref_language_values)[position])
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}