package com.example.uxmejoramientomobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uxmejoramientomobile.R
import com.example.uxmejoramientomobile.ui.theme.Background
import com.example.uxmejoramientomobile.ui.theme.InterFontFamily
import com.example.uxmejoramientomobile.ui.theme.TextDark
import kotlinx.coroutines.delay

@Composable
fun PrincipalConRetrasoEsperaScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("alarma")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "Recordamed",
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = TextDark
            )
            Spacer(modifier = Modifier.height(24.dp))
            MedicineCard(
                name = "Citrato de Magnesio",
                time = "6:00 AM",
                subtitle = "200 mg",
                status = MedStatus.INGESTA_TARDIA,
                iconRes = R.drawable.ic_pill
            )
            Spacer(modifier = Modifier.height(16.dp))
            MedicineCard(
                name = "Omeprazol",
                time = "8:00 AM",
                subtitle = "Tomado 8:05 am",
                status = MedStatus.TOMADO,
                iconRes = R.drawable.ic_medicine_box_card
            )
            Spacer(modifier = Modifier.height(16.dp))
            MedicineCard(
                name = "Crema Capsaicina",
                time = "2:00 PM",
                subtitle = "1 dosis",
                status = MedStatus.NORMAL,
                iconRes = R.drawable.ic_capsaicina
            )
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}
