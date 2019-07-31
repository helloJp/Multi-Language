package org.multilanguage.demo

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import org.multilanguage.demo.utils.MultiLanguageManager

/**
 * @author jiangp
 * @date   2019-07-31.
 * @desc:
 */
class App : Application() {

    companion object {
        var mInstance: App? = null

        var mContext: Context? = null

        fun getInstance(): App? {
            return mInstance
        }

    }

    override fun onCreate() {
        super.onCreate()
        if (mInstance == null) {
            mInstance = this
        }
        mContext = applicationContext

        MultiLanguageManager.updateAppLanguage(mContext!!)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(MultiLanguageManager.attachBaseContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        MultiLanguageManager.updateAppLanguage(mContext!!)
    }

}