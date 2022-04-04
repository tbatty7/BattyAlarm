package com.example.battyalarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.battyalarm.ui.theme.BattyAlarmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BattyAlarmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    color = MaterialTheme.colors.background
                ) {
//                    AlarmView().Render()
                    AlarmScreen()
                }
            }
        }
    }


    @Composable
    fun AlarmScreen() {
        val context = LocalContext.current
        Scaffold(topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Batty Alarm",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Set Alarm Time: 5 Seconds",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 16.sp
                )
                Button(
                    onClick = {
                        setAlarm(context, 5000)
                    }
                ) {
                    Text(text = "Set Alarm")
                }
            }
        }
    }

    private fun setAlarm(context: Context, millisecondsUntilAlarm: Int) {
        val alarmTimeInMilliSeconds = System.currentTimeMillis() + millisecondsUntilAlarm
        val alarmManager = context.getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, BattyAlarm::class.java)
        intent.putExtra("any_data", 123)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            generateRequestNumber(),
            intent,
            getFlag()
        )
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTimeInMilliSeconds, pendingIntent)
    }

    private fun getFlag() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.FLAG_UPDATE_CURRENT
        } else {
            0
        }

    private fun generateRequestNumber() = 0

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        BattyAlarmTheme {
            AlarmView().Render()
        }
    }
}