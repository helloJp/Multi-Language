package org.multilanguage.demo.utils

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.LocaleList
import android.text.TextUtils
import org.multilanguage.demo.App
import pyxis.uzuki.live.richutilskt.utils.RPreference
import java.util.*

/**
 * @author jiangp
 * @date   2019-07-31.
 * @desc:
 */
object MultiLanguageManager {

    //语言类型
    const val LANGUAGE_DEFAULT = "en"
    const val LANGUAGE_EN = "en"
    const val LANGUAGE_ZH_CN = "zh-CN"
    const val LANGUAGE_ZH_TW = "zh-TW"
    const val LANGUAGE_KO = "ko"


    const val KEY_LANGUAGE_TYPE = "languageType" //语言类型
    const val CHANGE_LANGUAGE = 2004

    val mAllLanguages = object : LinkedHashMap<String, Locale>(4) {
        init {
            put(LANGUAGE_EN, Locale.ENGLISH)
            put(LANGUAGE_ZH_CN, Locale.SIMPLIFIED_CHINESE)
            put(LANGUAGE_ZH_TW, Locale.TAIWAN)
            put(LANGUAGE_KO, Locale.KOREAN)
        }
    }


    open fun getPrefsLanguage(context: Context): String = RPreference.getInstance(context).getString(KEY_LANGUAGE_TYPE, "");

    open fun setPrefsLanguage(language: String) {
        RPreference.getInstance(App.mContext!!).put(KEY_LANGUAGE_TYPE, language)
    }


    fun attachBaseContext(context: Context): Context {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(context, getPrefsLanguage(context))
        } else {
            context
        }
    }

    fun changeAppLanguage(context: Context) {
        val resources = context.resources
        val configuration = resources.configuration

        // app locale
        val locale = getLocaleByLanguage(getPrefsLanguage(context))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale)
        } else {
            configuration.locale = locale
        }

        // updateConfiguration
        val dm = resources.displayMetrics
        resources.updateConfiguration(configuration, dm)
    }


    private fun isSupportLanguage(language: String): Boolean {
        return mAllLanguages.containsKey(language)
    }


    /**
     * 获取指定语言的locale信息，如果指定语言不存在[.mAllLanguages]，返回本机语言，如果本机语言不是语言集合中的一种[.mAllLanguages]，返回英语
     *
     * @param language language
     * @return
     */
    private fun getLocaleByLanguage(language: String): Locale? {
        if (isSupportLanguage(language)) {
            return mAllLanguages[language]
        } else {
            val locale = Locale.getDefault()
            for (key in mAllLanguages.keys) {
                if (TextUtils.equals(mAllLanguages[key]?.language, locale.language)) {
                    return locale
                }
            }
        }
        return Locale.ENGLISH
    }

    fun getLocaleByLanguage(): String? {
        val locale = Locale.getDefault()
        for (key in mAllLanguages.keys) {
            if (TextUtils.equals(mAllLanguages[key]?.language, locale.language)) {
                return key
            }
        }
        return LANGUAGE_EN
    }


    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResources(context: Context, language: String): Context {
        val resources = context.resources
        val locale = getLocaleByLanguage(language)

        val configuration = resources.configuration
        configuration.setLocale(locale)
        configuration.locales = LocaleList(locale)
        return context.createConfigurationContext(configuration)
    }



}
