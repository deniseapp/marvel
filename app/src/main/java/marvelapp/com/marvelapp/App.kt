package marvelapp.com.marvelapp

import android.app.Activity
import android.app.Application
import android.app.Service
import android.support.v4.app.Fragment
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import dagger.android.support.HasSupportFragmentInjector
import marvelapp.com.marvelapp.injections.AppModule
import marvelapp.com.marvelapp.injections.DaggerAppComponent
import javax.inject.Inject


class App : Application(), HasActivityInjector , HasSupportFragmentInjector, HasServiceInjector {

    @Inject internal lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    @Inject internal lateinit var serviceInjector: DispatchingAndroidInjector<Service>
    @Inject internal lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this);
        DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)

    }
    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    override fun serviceInjector(): AndroidInjector<Service> {
        return serviceInjector
    }
}