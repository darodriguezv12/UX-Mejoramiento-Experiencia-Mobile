package com.example.uxmejoramientomobile.screens

import android.app.DatePickerDialog
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreacionMagScreen(navController: NavController) {
    var dropdownExpanded by remember { mutableStateOf(false) }
    val medicines = listOf("Crema capsaicina 1 dosis", "Omeprazol 20 mg", "Citrato de magnesio 200 mg")
    var selectedMedicine by remember { mutableStateOf("Citrato de magnesio 200 mg") }
    var selectedInterval by remember { mutableStateOf("8hrs") }
    var otroIntervalo by remember { mutableStateOf("") }
    val times = listOf("06:00 AM", "08:00 AM", "10:00 AM", "12:00 PM", "02:00 PM", "04:00 PM", "06:00 PM", "08:00 PM")
    var selectedTime by remember { mutableStateOf("08:00 AM") }
    var timeDropdownExpanded by remember { mutableStateOf(false) }
    var startDate by remember { mutableStateOf("01/01/2026") }
    var endDate by remember { mutableStateOf("01/15/2026") }
    var showStartPicker by remember { mutableStateOf(false) }
    var showEndPicker by remember { mutableStateOf(false) }
    var phoneSelected by remember { mutableStateOf(false) }
    var emailSelected by remember { mutableStateOf(true) }
    var phoneNumber by remember { mutableStateOf("555-0123") }
    var emailAddress by remember { mutableStateOf("usuario@ejemplo.com") }
    val context = LocalContext.current

    if (showStartPicker) {
        DisposableEffect(Unit) {
            val cal = Calendar.getInstance()
            val dialog = DatePickerDialog(context, { _, year, month, day ->
                startDate = "${String.format("%02d", month + 1)}/${String.format("%02d", day)}/$year"
                showStartPicker = false
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
            dialog.setOnDismissListener { showStartPicker = false }
            dialog.show()
            onDispose { dialog.dismiss() }
        }
    }

    if (showEndPicker) {
        DisposableEffect(Unit) {
            val cal = Calendar.getInstance()
            val dialog = DatePickerDialog(context, { _, year, month, day ->
                endDate = "${String.format("%02d", month + 1)}/${String.format("%02d", day)}/$year"
                showEndPicker = false
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
            dialog.setOnDismissListener { showEndPicker = false }
            dialog.show()
            onDispose { dialog.dismiss() }
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(Background)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp)
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(painter = painterResource(id = R.drawable.ic_arrow_left), contentDescription = "Volver", tint = TextDark, modifier = Modifier.size(20.dp))
                }
                Text(text = "ALARMA", fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TextDark, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.size(48.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Configuración de medicamento", fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp, color = TextSecondary, modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))

            ExposedDropdownMenuBox(
                expanded = dropdownExpanded,
                onExpandedChange = { dropdownExpanded = it },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                        .border(1.dp, Color(0xFFD1D5DB), RoundedCornerShape(8.dp))
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = selectedMedicine, fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp, color = TextDark)
                    Icon(painter = painterResource(id = android.R.drawable.arrow_down_float), contentDescription = null, tint = TextSecondary, modifier = Modifier.size(16.dp))
                }
                ExposedDropdownMenu(
                    expanded = dropdownExpanded,
                    onDismissRequest = { dropdownExpanded = false },
                    modifier = Modifier.background(Color.White)
                ) {
                    medicines.forEach { med ->
                        DropdownMenuItem(
                            text = { Text(med, fontFamily = InterFontFamily, fontSize = 14.sp, color = TextDark) },
                            onClick = { selectedMedicine = med; dropdownExpanded = false },
                            modifier = Modifier.background(Color.White)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider(color = Color(0xFFE5E7EB))
            Spacer(modifier = Modifier.height(24.dp))

            CreacionSection(iconRes = R.drawable.ic_clock_circle, title = "Configurar intervalo") {
                IntervalToggle(selected = selectedInterval, onSelect = { selectedInterval = it })
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = otroIntervalo,
                    onValueChange = { otroIntervalo = it },
                    placeholder = { Text("Otro intervalo...", fontFamily = InterFontFamily, fontSize = 14.sp, color = Color(0xFF9CA3AF)) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFD1D5DB),
                        focusedBorderColor = PrimaryTeal,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                    textStyle = TextStyle(fontFamily = InterFontFamily, fontSize = 14.sp, color = TextDark)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            CreacionSection(iconRes = R.drawable.ic_clock_arrow, title = "Primera toma") {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, Color(0xFFD1D5DB), RoundedCornerShape(12.dp))
                            .background(Color.White, RoundedCornerShape(12.dp))
                            .clickable { timeDropdownExpanded = true }
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "HORA SUGERIDA", fontFamily = InterFontFamily, fontWeight = FontWeight.Normal, fontSize = 10.sp, color = TextSecondary, letterSpacing = 1.sp)
                            Text(text = selectedTime, fontFamily = InterFontFamily, fontWeight = FontWeight.Bold, fontSize = 28.sp, color = TextDark)
                        }
                        Icon(painter = painterResource(id = R.drawable.ic_edit_pencil), contentDescription = null, tint = Color.Unspecified, modifier = Modifier.size(40.dp))
                    }
                    DropdownMenu(
                        expanded = timeDropdownExpanded,
                        onDismissRequest = { timeDropdownExpanded = false },
                        modifier = Modifier.background(Color.White)
                    ) {
                        times.forEach { time ->
                            DropdownMenuItem(
                                text = { Text(time, fontFamily = InterFontFamily, fontSize = 14.sp, color = TextDark) },
                                onClick = { selectedTime = time; timeDropdownExpanded = false },
                                modifier = Modifier.background(Color.White)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            CreacionSection(iconRes = R.drawable.ic_calendar, title = "Duración") {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "INICIO", fontFamily = InterFontFamily, fontSize = 10.sp, color = TextSecondary, letterSpacing = 1.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, Color(0xFFD1D5DB), RoundedCornerShape(8.dp))
                                .background(Color.White, RoundedCornerShape(8.dp))
                                .clickable { showStartPicker = true }
                                .padding(horizontal = 12.dp, vertical = 14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = startDate, fontFamily = InterFontFamily, fontSize = 14.sp, color = TextDark)
                        }
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "FIN", fontFamily = InterFontFamily, fontSize = 10.sp, color = TextSecondary, letterSpacing = 1.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, Color(0xFFD1D5DB), RoundedCornerShape(8.dp))
                                .background(Color.White, RoundedCornerShape(8.dp))
                                .clickable { showEndPicker = true }
                                .padding(horizontal = 12.dp, vertical = 14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = endDate, fontFamily = InterFontFamily, fontSize = 14.sp, color = TextDark)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            CreacionSection(iconRes = R.drawable.ic_bell, title = "Recordatorios") {
                RecordatorioCardEditable(
                    iconRes = R.drawable.ic_phone, title = "Teléfono",
                    value = phoneNumber, onValueChange = { phoneNumber = it },
                    selected = phoneSelected, onClick = { phoneSelected = !phoneSelected }
                )
                Spacer(modifier = Modifier.height(12.dp))
                RecordatorioCardEditable(
                    iconRes = R.drawable.ic_email, title = "Correo Electrónico",
                    value = emailAddress, onValueChange = { emailAddress = it },
                    selected = emailSelected, onClick = { emailSelected = !emailSelected }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }

        Button(
            onClick = { navController.navigate("confirmacion") },
            modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp).height(52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF111827)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Confirmar configuración", fontFamily = InterFontFamily, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = Color.White)
        }
    }
}
