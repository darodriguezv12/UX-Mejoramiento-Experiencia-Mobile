package com.example.uxmejoramientomobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import com.example.uxmejoramientomobile.R
import com.example.uxmejoramientomobile.ui.theme.AlarmBg
import com.example.uxmejoramientomobile.ui.theme.AlarmText
import com.example.uxmejoramientomobile.ui.theme.InterFontFamily
import com.example.uxmejoramientomobile.ui.theme.TextDark
import com.example.uxmejoramientomobile.ui.theme.TextSecondary

@Composable
fun AlarmaScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().background(AlarmBg).padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(64.dp))

        Icon(painter = painterResource(id = R.drawable.ic_medicine_cross), contentDescription = null, tint = AlarmText, modifier = Modifier.size(72.dp))

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Recordamed", fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp, color = AlarmText.copy(alpha = 0.7f))

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "SIMULACIÓN\nLLAMADA", fontFamily = InterFontFamily, fontWeight = FontWeight.ExtraBold, fontSize = 30.sp, color = AlarmText, textAlign = TextAlign.Center, lineHeight = 36.sp)

        Spacer(modifier = Modifier.height(28.dp))

        Column(
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(Color.White).padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Citrato de\nmagnesio 200 mg", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = TextDark, textAlign = TextAlign.Center, lineHeight = 26.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(18.dp).clip(CircleShape).border(2.dp, Color(0xFFD1D5DB), CircleShape))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Dosis 200mg", fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp, color = TextSecondary)
            }
            Spacer(modifier = Modifier.height(14.dp))
            Row(
                modifier = Modifier.fillMaxWidth(0.92f).border(1.dp, Color(0xFFD1D5DB), RoundedCornerShape(8.dp)).padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_warning_triangle), contentDescription = null, tint = AlarmText, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "RETRASO CRÍTICO", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = AlarmText, letterSpacing = 0.5.sp)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Esta es una simulación de una llamada por un retraso en\nla dosis. Por favor, tome su medicación de inmediato.",
            fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 13.sp,
            color = AlarmText.copy(alpha = 0.95f), textAlign = TextAlign.Center, lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(36.dp))

        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier.size(80.dp).clip(CircleShape).background(Color(0xFF9CA3AF)).clickable { navController.navigate("principal_retraso_1") },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "−", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 32.sp, color = Color.White)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "IGNORAR", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = AlarmText, letterSpacing = 1.sp)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier.size(80.dp).clip(CircleShape).background(Color(0xFF111827)).clickable { navController.navigate("principal_tomada") },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_check_white), contentDescription = "Tomada", tint = Color.White, modifier = Modifier.size(32.dp))
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "TOMADA", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = AlarmText, letterSpacing = 1.sp)
            }
        }
    }
}
