# Multi-Language

easy config multi-language, 
save selected language in sharedPreference

### 1. Application<br>

* override attachBaseContext() & onConfigurationChanged() 
>  
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(MultiLanguageManager.attachBaseContext(base))
    }

>
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        MultiLanguageManager.updateAppLanguage(mContext!!)
    }



* call updateAppLanguage() in onCreate()
>
    override fun onCreate() {
        super.onCreate()
        MultiLanguageManager.updateAppLanguage(mContext!!)
    }

### 2. BaseActivity<br>

* override attachBaseContext() 
>  
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(MultiLanguageManager.attachBaseContext(base))
    }


    
