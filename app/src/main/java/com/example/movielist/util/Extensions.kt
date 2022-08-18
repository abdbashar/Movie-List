package com.example.movielist.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.movielist.R


fun FragmentActivity.navigateTo(fragment: Fragment, bundle: Bundle? = null) {
    fragment.arguments = bundle
    changeNavigation(this, NavigationType.Add, fragment)
}

fun FragmentActivity.replaceFragment(toFragment: Fragment, bundle: Bundle? = null) {
    toFragment.arguments = bundle
    changeNavigation(this, NavigationType.Replace, toFragment)
}

fun FragmentActivity.back(fragment: Fragment) {
    changeNavigation(this, NavigationType.Remove, fragment)
}

private fun changeNavigation(
    activity: FragmentActivity,
    state: NavigationType,
    fragment: Fragment
) {
    val transaction = activity.supportFragmentManager.beginTransaction()
    when (state) {
        NavigationType.Add -> transaction.add(R.id.fragmentContainerView, fragment)
        NavigationType.Remove -> transaction.remove(fragment)
        NavigationType.Replace -> transaction.replace(R.id.fragmentContainerView, fragment)
    }
    transaction.addToBackStack(null).commit()
}