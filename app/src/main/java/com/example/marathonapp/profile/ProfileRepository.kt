package com.example.marathonapp.profile

import com.example.marathonapp.common.ISharedPreferenceApi
import com.example.marathonapp.common.Response
import com.example.marathonapp.net.api.ProfileAPI
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ProfileRepository @Inject constructor (private val sharedPreferenceApi: ISharedPreferenceApi, val profileApi: ProfileAPI): IProfileRepository {

    override suspend fun getUserProfile() = flow<Response<UserProfile>>{
        emit(Response.Loading())
        try {
            val up = sharedPreferenceApi.getUserProfile()
            if (up != null) {
                emit(Response.Success(up))

            } else {
                val upWeb = profileApi.getUserProfile().toUserProfile()
                sharedPreferenceApi.setUserProfile(upWeb)
                emit(Response.Success(upWeb))
            }
        } catch (e:HttpException) {
            emit(Response.Error(e.message()))
        } catch (e:IOException) {
            emit(Response.Error(e.localizedMessage?: ""))
        }

    }

}