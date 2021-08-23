package com.hornedheck.clients.data.user

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.hornedheck.clients.data.utils.toLocalDate
import com.hornedheck.clients.data.utils.toTimestamp
import com.hornedheck.clients.domain.user.User
import com.hornedheck.clients.domain.user.UsersRepo
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import com.hornedheck.clients.proto.User as UserProto

class UserDataStorage(
    private val context: Context
) : UsersRepo {

    private val Context.userDS: DataStore<UserProto> by dataStore(
        fileName = "user.pb",
        serializer = UserSerializer()
    )

    override suspend fun getUsers(): List<User> {
        return context.userDS.data.map {
            User(it.id, it.name, it.birth.toLocalDate(), it.weight, it.photo)
        }.toList()
    }

    override suspend fun saveUser(user: User) {
        context.userDS.updateData {
            it.toBuilder()
                .setBirth(user.birthday.toTimestamp())
                .setName(user.name)
                .setPhoto(user.photo)
                .let { builder ->
                    if (user.id != 0) {
                        builder.setId(user.id)
                    } else {
                        builder
                    }
                }.build()
        }
    }
}