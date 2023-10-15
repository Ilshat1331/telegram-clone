package com.example.telegram

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.telegram.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.nameRes
import com.mikepenz.materialdrawer.util.addItems
import com.mikepenz.materialdrawer.widget.AccountHeaderView
import com.mikepenz.materialdrawer.widget.MaterialDrawerSliderView

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawer: MaterialDrawerSliderView
    private lateinit var mHeader: AccountHeaderView
    private lateinit var mToolbar: Toolbar
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onResume() {
        super.onResume()
        actionBarDrawerToggle.syncState()
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        createActionBar()
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer.apply {
            addItems(
                PrimaryDrawerItem().apply {
                    nameRes = R.string.drawer_item_action_create_group
                    isSelectable = false
                    identifier = 100
                },
            )
        }
    }

    private fun createActionBar() {
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            mBinding.root,
            mToolbar,
            com.mikepenz.materialdrawer.R.string.material_drawer_open,
            com.mikepenz.materialdrawer.R.string.material_drawer_close
        )
        mBinding.root.addDrawerListener(actionBarDrawerToggle)
    }

    private fun createHeader() {
        mHeader = AccountHeaderView(this).apply {
            attachToSliderView(mBinding.drawer)
            setBackgroundResource(R.drawable.header)
            addProfiles(
                ProfileDrawerItem().apply {
                    name = StringHolder("Yura")
                    description = StringHolder("+79111111111")
                    identifier = 100
                }
            )
        }
    }
    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mDrawer = mBinding.drawer
    }

}