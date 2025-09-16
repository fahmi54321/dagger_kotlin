package com.techyourchance.dagger2course.screens.common.viewsmvc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import java.util.HashSet

open class BaseViewMvc<LISTENER_TYPE>(
    private val layoutInflater: LayoutInflater,
    private val viewGroup: ViewGroup?,
    @LayoutRes private val layoudId: Int) {

    protected val listeners = HashSet<LISTENER_TYPE>()
    protected val context: Context get() = rootView.context

    val rootView:View = layoutInflater.inflate(layoudId,viewGroup,false)

    fun registerListener(Listener: LISTENER_TYPE){
        listeners.add(Listener)
    }

    fun unregisterListener(Listener: LISTENER_TYPE){
        listeners.remove(Listener)
    }

    fun <T: View?> findViewById(@IdRes id: Int) : T{
        return rootView.findViewById<T>(id)
    }
}