package com.example.userinput

import android.renderscript.Sampler.Value
import android.renderscript.ScriptGroup.Input
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.userinput.ui.theme.UserInputTheme


@Preview(showBackground = true)
@Composable
fun Input(
    modifier: Modifier = Modifier)
{
    var nama by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var alamat by remember { mutableStateOf("")}
    var noTelepon by remember { mutableStateOf("")}
    var selectedGender by remember { mutableStateOf("")}

    val jenisKelamin = listOf("Laki-laki","Wanita")

    var confirmnama by remember { mutableStateOf("")}
    var confirmemail by remember { mutableStateOf("")}
    var confirmalamat by remember { mutableStateOf("")}
    var confirmnoTelepon by remember { mutableStateOf("")}
    var confirmselectedGender by remember { mutableStateOf("")}

    Column (
        Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan Nama") },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
            )

        Row (){
            jenisKelamin.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = selectedGender == item,
                        onClick = {
                            selectedGender = item
                        })
                    Text(item)
                }
            }
        }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan Email") },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat") },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = noTelepon,
            onValueChange = {noTelepon = it},
            placeholder = { Text("Masukkan Nomor Telepon") },
            label = { Text("No Telepon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Button(onClick = {
            confirmnama = nama
            confirmselectedGender = selectedGender
            confirmemail = email
            confirmalamat = alamat
            confirmnoTelepon = noTelepon
        })
        {
            Text("Simpan")
        }

        Card(
            modifier.size(
                height = 200.dp,
                width = 450.dp)) {
            CardSection(judulParam = "Nama", isiParam = confirmnama)
            CardSection(judulParam = "Jenis Kelamin", isiParam = confirmselectedGender)
            CardSection(judulParam = "Email", isiParam = confirmemail)
            CardSection(judulParam = "Alamat", isiParam = confirmalamat)
            CardSection(judulParam = "No Telepon", isiParam = confirmnoTelepon)
        }
    }
}

@Composable
fun CardSection(judulParam:String, isiParam: String) {
    Column() {
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(
                text = judulParam,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = "$isiParam",
                modifier = Modifier.weight(2f)
            )
        }
    }
}
