package com.example.uxmejoramientomobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uxmejoramientomobile.R
import com.example.uxmejoramientomobile.ui.theme.Background
import com.example.uxmejoramientomobile.ui.theme.InterFontFamily
import com.example.uxmejoramientomobile.ui.theme.PrimaryTeal
import com.example.uxmejoramientomobile.ui.theme.TextDark

@Composable
fun PrincipalConRetraso1Screen(navController: NavController) {
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
                iconRes = R.drawable.ic_pill,
                onIngestaTardiaClick = { navController.navigate("confirmacion") },
                onEditClick = { navController.navigate("creacion_mag") },
                onTrashClick = { navController.navigate("principal_2prod") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            MedicineCard(
                name = "Omeprazol",
                time = "8:00 AM",
                subtitle = "Tomado 8:05 am",
                status = MedStatus.TOMADO,
                iconRes = R.drawable.ic_medicine_box_card,
                onEditClick = { navController.navigate("creacion_ome") },
                onTrashClick = { navController.navigate("principal_2prod") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            MedicineCard(
                name = "Crema Capsaicina",
                time = "2:00 PM",
                subtitle = "1 dosis",
                status = MedStatus.NORMAL,
                iconRes = R.drawable.ic_capsaicina,
                onEditClick = { navController.navigate("creacion_capsa") },
                onTrashClick = { navController.navigate("principal_2prod") }
            )
            Spacer(modifier = Modifier.height(100.dp))
        }

        TextButton(
            onClick = { navController.navigate("tomar") },
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 16.dp, bottom = 24.dp)
        ) {
            Text(
                text = "Simular alarma",
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp,
                color = PrimaryTeal
            )
        }

        FloatingActionButton(
            onClick = { navController.navigate("creacion_ome") },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 24.dp, bottom = 24.dp)
                .size(64.dp),
            containerColor = PrimaryTeal,
            shape = RoundedCornerShape(20.dp)
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_input_add),
                contentDescription = "Agregar",
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}
