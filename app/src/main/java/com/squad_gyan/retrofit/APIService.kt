package com.squad_gyan.retrofit


import com.squad_gyan.UpdateApplicationModel
import com.squad_gyan.common_helper.InputParams
import com.squad_gyan.ui.home.model.MatchDetailsModel
import com.squad_gyan.ui.home.model.MatchListModel
import com.squad_gyan.ui.home.model.TeamDetailsModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface APIService {

    @POST("get_cricket_match_lists")
    fun getCricketMatchList(@Body inputParams: InputParams): Call<MatchListModel>

    @POST("get_football_match_lists")
    fun getFootballMatchList(@Body inputParams: InputParams): Call<MatchListModel>

    @POST("get_basketball_match_lists")
    fun getBasketballMatchList(@Body inputParams: InputParams): Call<MatchListModel>

    //@POST("get_match_details")
    @POST("get_cricket_match_details")
    fun getMatchDetails(@Body inputParams: InputParams): Call<MatchDetailsModel>

    @POST("check_version")
    fun checkVersion(@Body inputParams: InputParams): Call<UpdateApplicationModel>

    @POST("get_cricket_fantasy_teams")
    fun getTeamDetails(@Body inputParams: InputParams): Call<TeamDetailsModel>

}