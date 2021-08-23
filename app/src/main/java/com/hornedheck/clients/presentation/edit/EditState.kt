package com.hornedheck.clients.presentation.edit

import androidx.annotation.StringRes
import com.hornedheck.clients.R
import com.hornedheck.clients.presentation.core.BaseState
import com.hornedheck.clients.presentation.core.StateModel
import com.hornedheck.clients.presentation.main.UserItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EditState(
    val step: EditStep,
    val userItem: UserItem
) : BaseState

@Parcelize
enum class EditStep(
    @StringRes val hint: Int
) : StateModel {

    NAME(R.string.edit_name_hint),
    WEIGHT(R.string.edit_wieght_hint)

}
