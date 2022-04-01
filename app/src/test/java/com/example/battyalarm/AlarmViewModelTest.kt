package com.example.battyalarm

import org.junit.Assert.*
import org.junit.Test

class AlarmViewModelTest() {
    @Test
    fun name() {
        val alarmViewModel = AlarmViewModel()
        assertNotNull(alarmViewModel)
    }
}