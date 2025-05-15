package com.loan_app.ui.view.student

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AttendanceScreen(navController: NavController) {
    val students = remember {
        mutableStateListOf(
            StudentAttendance("Abigail Mensah"),
            StudentAttendance("James Owusu"),
            StudentAttendance("Lydia Boateng"),
            StudentAttendance("Angela Addo"),
            StudentAttendance("Grace Oteng"),
            StudentAttendance("Benjamin Bekoe"),
            StudentAttendance("Daniel Asante")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Present", fontWeight = FontWeight.Bold)
            Text("Absent", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Student Attendance List
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // fills 2/3 of the screen
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            LazyColumn (modifier = Modifier.padding(vertical = 8.dp)) {
                items(students.size) { index ->
                    StudentAttendanceRow(
                        student = students[index],
                        onStatusChange = { newStatus ->
                            students[index] = students[index].copy(status = newStatus)
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bottom Button
        Button(
            onClick = { /* handle add exam action */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Add Exam", fontSize = 16.sp)
        }
    }
}


@Composable
fun StudentAttendanceRow(
    student: StudentAttendance,
    onStatusChange: (AttendanceStatus) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(student.name, modifier = Modifier.weight(1f))

        Row {
            AttendanceOption(
                text = "Present",
                selected = student.status == AttendanceStatus.PRESENT,
                onClick = { onStatusChange(AttendanceStatus.PRESENT) }
            )
            Spacer(modifier = Modifier.width(16.dp))
            AttendanceOption(
                text = "Absent",
                selected = student.status == AttendanceStatus.ABSENT,
                onClick = { onStatusChange(AttendanceStatus.ABSENT) }
            )
        }
    }
}


@Composable
fun AttendanceOption(text: String, selected: Boolean, onClick: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = if (selected) Color(0xFF388E3C) else Color.Gray,
            modifier = Modifier
                .size(20.dp)
                .clickable(enabled = true, onClick = { onClick() })
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = if (selected) Color(0xFF388E3C) else Color.Gray,
            fontSize = 14.sp
        )
    }
}

data class StudentAttendance(
    val name: String,
    val status: AttendanceStatus = AttendanceStatus.PRESENT
)

enum class AttendanceStatus {
    PRESENT,
    ABSENT
}
