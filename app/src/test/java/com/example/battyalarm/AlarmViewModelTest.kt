package com.example.battyalarm

import androidx.lifecycle.ViewModel
import org.junit.Assert.*
import org.junit.Test

class AlarmViewModelTest() {
    @Test
    fun isAViewModel() {
        val alarmViewModel = AlarmViewModel() as? ViewModel
        assertNotNull(alarmViewModel)
    }

    @Test
    fun hasTitle() {
        val alarmViewModel = AlarmViewModel()
        assertEquals("Batty Alarm", alarmViewModel.title)
    }
}