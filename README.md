# Multi-Language

easy config multi-language, 
save selected language in sharedPreference.<br>

if need to change language ,just set 
>MultiLanguageManager.setPrefsLanguage(this,languageValue)

### 1. Application<br>

* override attachBaseContext() & onConfigurationChanged() 
>  
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(MultiLanguageManager.attachBaseContext(base))
    }

>
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        MultiLanguageManager.updateAppLanguage(this)
    }



* call updateAppLanguage() in onCreate()
>
    override fun onCreate() {
        super.onCreate()
        MultiLanguageManager.updateAppLanguage(this)
    }

### 2. BaseActivity<br>

* override attachBaseContext() 
>  
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(MultiLanguageManager.attachBaseContext(base))
    }


    
