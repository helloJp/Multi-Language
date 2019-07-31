package org.multilanguage.demo

import android.content.Intent
import android.os.Build
import android.view.View
import org.multilanguage.demo.utils.MultiLanguageManager

/**
 * @author jiangp
 * @date   2019-07-31.
 * @desc:
 */
class MainActivity : BaseActivity() {

    override fun initLayout(): Int = R.layout.activity_main

    fun onSettingClick(v: View) {
        SelectLanguageActivity.start(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == MultiLanguageManager.CHANGE_LANGUAGE && resultCode == RESULT_OK) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                MultiLanguageManager.changeAppLanguage(this)
            }
            recreate()
        }
    }
}
