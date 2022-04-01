package com.example.battyalarm

import androidx.compose.runtime.Composable
import com.example.battyalarm.AlarmViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel

class AlarmView() {

    @Composable
    fun Render(model: AlarmViewModel = viewModel()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = model.title, fontSize = 40.sp, color = Color.Blue)
            Spacer(modifier = Modifier.size(20.dp))
            TextClock()
        }
    }

    @Composable
    private fun TextClock(
        modifier: Modifier = Modifier,
        format12Hour: String? = null,
        format24Hour: String? = null,
        timeZone: String? = null
    ) {
        AndroidView(factory = {context -> android.widget.TextClock(context).apply {
            format12Hour?.let { this.format12Hour = it }
            format24Hour?.let { this.format24Hour = it }
            timeZone?.let { this.timeZone = it }
            textSize = 70.3F
        }
        },
            modifier = modifier)

    }
}