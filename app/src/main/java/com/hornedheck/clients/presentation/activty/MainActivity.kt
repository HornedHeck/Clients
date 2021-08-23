package com.hornedheck.clients.presentation.activty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.hornedheck.clients.R
import com.hornedheck.clients.data.dataModule
import com.hornedheck.clients.domain.interactorModule
import com.hornedheck.clients.presentation.navigationModule
import com.hornedheck.clients.presentation.viewModule
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<ActivityViewModel>()

    private val navigatorHolder by inject<NavigatorHolder>()

    private val navigator by lazy { AppNavigator(this, R.id.root, supportFragmentManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            modules(
                navigationModule,
                dataModule,
                interactorModule,
                viewModule
            )
            androidContext(applicationContext)
        }

        lifecycleScope.launchWhenStarted { viewModel.stateFlow.collect { updateState(it) } }

        setTheme(R.style.Theme_Clients)

        setContentView(R.layout.activity_main)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }


    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    private fun updateState(state: ActivityState) {

    }


}