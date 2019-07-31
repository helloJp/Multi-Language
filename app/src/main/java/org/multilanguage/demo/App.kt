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

    override fun onCreate() {
        super.onCreate()
        MultiLanguageManager.updateAppLanguage(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(MultiLanguageManager.attachBaseContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        MultiLanguageManager.updateAppLanguage(this)
    }

}