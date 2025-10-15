package com.techyourchance.dagger2course.networking

import com.example.daggertwo.Constants

class UrlProvider {
    fun getBaseUrl1(): String{
        return Constants.BASE_URL
    }

    fun getBaseUrl2(): String{
        return "base url"
    }
}