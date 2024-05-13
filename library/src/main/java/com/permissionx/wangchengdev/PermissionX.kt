package com.permissionx.wangchengdev

import androidx.fragment.app.FragmentActivity

object PermissionX {

    private const val TAG = "InvisibleFragment"

    fun request(
        activity: FragmentActivity,
        vararg permissions: String,
        callback: PermissionCallback
    ) {
        val supportFragmentManager = activity.supportFragmentManager
        val exitedFragment = supportFragmentManager.findFragmentByTag(TAG)
        val invisibleFragment = if (exitedFragment != null) {
            exitedFragment as InvisibleFragment
        } else {
            val fragment = InvisibleFragment()
            supportFragmentManager
                .beginTransaction()
                .add(fragment, TAG)
                .commitNow()
            fragment
        }

        invisibleFragment.requestNow(callback, *permissions)
    }
}