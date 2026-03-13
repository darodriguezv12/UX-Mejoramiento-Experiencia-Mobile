package com.example.uxmejoramientomobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uxmejoramientomobile.R
import com.example.uxmejoramientomobile.ui.theme.Background
import com.example.uxmejoramientomobile.ui.theme.InterFontFamily
import com.example.uxmejoramientomobile.ui.theme.PrimaryTeal
import com.example.uxmejoramientomobile.ui.theme.TextDark
import com.example.uxmejoramientomobile.ui.theme.TextSecondary

@Composable
fun ConfirmacionScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(painter = painterResource(id = R.drawable.ic_arrow_left), contentDescription = "Volver", tint = TextDark, modifier = Modifier.size(20.dp))
            }
            Text(text = "RECORDATORIO", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = TextDark, modifier = Modifier.weight(1f), textAlign = TextAlign.Center, letterSpacing = 1.sp)
            Spacer(modifier = Modifier.size(48.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier.size(140.dp).clip(CircleShape).background(PrimaryTeal.copy(alpha = 0.12f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_medicine_hero), contentDescription = null, tint = PrimaryTeal, modifier = Modifier.size(100.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Crema Capsaicina", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 22.sp, color = TextDark, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "1 Dosis", fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 15.sp, color = TextSecondary)

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier.fillMaxWidth().border(1.dp, Color(0xFFD1D5DB), RoundedCornerShape(16.dp)).padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "PROGRAMADA PARA LAS", fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 11.sp, color = TextSecondary, letterSpacing = 1.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.Bottom) {
                Text(text = "2:00", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 48.sp, color = TextDark, modifier = Modifier.alignByBaseline())
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "PM", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = TextDark, modifier = Modifier.alignByBaseline())
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_hint_info), contentDescription = null, tint = Color(0xFFF97316), modifier = Modifier.size(18.dp).padding(top = 2.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Es importante mantener el intervalo de 12 horas para asegurar la efectividad del tratamiento.",
                fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 13.sp,
                color = TextSecondary, lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.widthIn(max = 240.dp)
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = { navController.navigate("principal_retraso_2") },
            modifier = Modifier.fillMaxWidth().height(52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryTeal),
            shape = RoundedCornerShape(12.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_check_white_circle), contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Confirmar Alarma", fontFamily = InterFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "EDITAR CONFIGURACIÓN",
            fontFamily = InterFontFamily, fontWeight = FontWeight.Medium, fontSize = 13.sp,
            color = TextSecondary, letterSpacing = 1.sp,
            modifier = Modifier.clickable { navController.popBackStack() }
        )
    }
}
