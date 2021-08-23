package com.hornedheck.clients.data.utils

import com.google.protobuf.Timestamp
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

fun Timestamp.toLocalDate() =
    Instant.ofEpochSecond(seconds, nanos.toLong())
        .atZone(ZoneId.systemDefault())
        .toLocalDate()

fun LocalDate.toTimestamp(): Timestamp {
    val instant = Instant.from(this)
    return Timestamp.newBuilder()
        .setSeconds(instant.epochSecond)
        .setNanos(instant.nano)
        .build()
}
