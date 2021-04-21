package com.squad_gyan.dagger

import com.squad_gyan.MainActivity
import com.squad_gyan.common_helper.Application
import com.squad_gyan.ui.home.BasketballMatchListFragment
import com.squad_gyan.ui.home.CricketMatchListFragment
import com.squad_gyan.ui.home.FootballMatchListFragment
import com.squad_gyan.ui.home.HomeFragment
import com.squad_gyan.ui.home.MatchDetailFragment
import com.squad_gyan.ui.home.TeamDetailFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class])
interface AppComponent {

    fun inject(application: Application)

    fun inject(homeFragment: HomeFragment)

    fun inject(matchListFragment: CricketMatchListFragment)

    fun inject(footballMatchListFragment: FootballMatchListFragment)

    fun inject(basketballMatchListFragment: BasketballMatchListFragment)

    fun inject(matchDetailFragment: MatchDetailFragment)

    fun inject(teamDetailFragment: TeamDetailFragment)

    fun inject(mainActivity: MainActivity)

}