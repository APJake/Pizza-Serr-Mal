package com.compose.common.util

interface UniMapper<FROM, TO> {
    fun map(data: FROM): TO
}