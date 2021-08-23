package com.hornedheck.clients.data.user

import androidx.datastore.core.Serializer
import com.hornedheck.clients.proto.User
import java.io.InputStream
import java.io.OutputStream

class UserSerializer : Serializer<User> {

    override val defaultValue: User = User.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): User {
        return User.parseFrom(input)
    }

    override suspend fun writeTo(t: User, output: OutputStream) {
        t.writeTo(output)
    }
}