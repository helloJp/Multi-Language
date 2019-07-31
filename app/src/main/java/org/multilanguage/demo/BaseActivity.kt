package org.multilanguage.demo

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import org.multilanguage.demo.utils.MultiLanguageManager

/**
 * @author jiangp
 * @date   2019-07-31.
 * @desc:
 */
abstract class BaseActivity : FragmentActivity() {

    var mContext: Activity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayout())
        mContext = this
        initViewAndData()
    }

    protected abstract fun initLayout(): Int

    open fun initViewAndData() {}

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(MultiLanguageManager.attachBaseContext(context))
    }

}