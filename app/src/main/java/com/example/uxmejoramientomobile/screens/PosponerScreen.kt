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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uxmejoramientomobile.R
import com.example.uxmejoramientomobile.ui.theme.Background
import com.example.uxmejoramientomobile.ui.theme.InterFontFamily
import com.example.uxmejoramientomobile.ui.theme.TextDark
import com.example.uxmejoramientomobile.ui.theme.TextSecondary

@Composable
fun PosponerScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(48.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { navController.popBackStack() }
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_chevron_left), contentDescription = "Volver", tint = TextDark, modifier = Modifier.size(16.dp))
            Text(text = " Volver", fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 15.sp, color = TextDark)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
            Text(text = "Citrato de\nMagnesio 20mg", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = TextDark)
            Column(horizontalAlignment = Alignment.End) {
                Text(text = "RETRASO", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 10.sp, color = TextSecondary, letterSpacing = 1.sp)
                Text(text = "15 min", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TextDark)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Posponer por", fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 15.sp, color = TextSecondary)
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            PosponerRow(label = "15 minutos", onClick = { navController.navigate("principal_retraso_espera") })
            PosponerRow(label = "30 minutos", onClick = { navController.navigate("principal_retraso_espera") })
            PosponerRow(label = "1 hora", onClick = { navController.navigate("principal_retraso_espera") })
        }
    }
}

@Composable
fun PosponerRow(label: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFFE5E7EB), RoundedCornerShape(12.dp))
            .background(Color.White)
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 15.sp, color = TextDark)
        Box(modifier = Modifier.size(28.dp).clip(RoundedCornerShape(50.dp)).background(Color(0xFFF3F4F6)), contentAlignment = Alignment.Center) {
            Text(text = ">", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = TextSecondary)
        }
    }
}
