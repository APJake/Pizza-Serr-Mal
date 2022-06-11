package com.apjake.pizzaserrmal.common.util

interface UniMapper<FROM, TO> {
    fun map(data: FROM): TO
}