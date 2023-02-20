package com.example.firstapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import java.io.File

class ActivityTp3Compose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(LocalContext.current)
        }
    }
}

@Composable
private fun App(context: Context) {
    var message by remember { mutableStateOf("") }
    var file by remember { mutableStateOf(File(context.filesDir, "adamallain.txt")) }
    var fileList by remember { mutableStateOf(context.filesDir.listFiles() ?: arrayOf()) }

    if (!file.exists()) {
        file.createNewFile()
        file.writeText("Bonjour MOUNIER Romain")
        fileList = context.filesDir.listFiles() ?: arrayOf()
    }

    fun onSave() {
        if (message.isNotEmpty()) {
            file = File(context.filesDir, "adamallain.txt")
            file.writeText(message)
            fileList = context.filesDir.listFiles() ?: arrayOf()
            message = ""
        } else {
            Toast.makeText(
                context, "Can't save because the message is empty", Toast.LENGTH_LONG
            ).show()
        }
    }

    fun onCancel() {
        message = ""
    }

    fun onRemove(f: File) {
        f.delete()
        fileList = context.filesDir.listFiles() ?: arrayOf()
    }



    MaterialTheme {
        Column(
            Modifier.padding(20.dp)
        ) {
            MessageInput(message, { message = it }, { onSave() }, { onCancel() })
            Spacer(Modifier.height(30.dp))
            FileContentDisplay(file, "adamallain.txt")
            Spacer(Modifier.height(30.dp))
            StorageDirectory(fileList, context.filesDir.absolutePath) { onRemove(it) }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun MessageInput(
    message: String,
    onChange: (String) -> Unit,
    onSave: () -> Unit,
    onCancel: () -> Unit,
) {
    TextField(
        value = message,
        onValueChange = { onChange(it) },
        label = { Text("Message to save") },
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(10.dp))
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Button(onClick = { onCancel() }) { Text("Cancel") }
        Spacer(modifier = Modifier.width(10.dp))
        Button(onClick = { onSave() }) { Text("Ok") }
    }
}

@Composable
fun FileContentDisplay(file: File, path: String) {
    var text = "File not found"
    if (file.exists()) {
        text = file.readText()
    }
    Column {
        Text("File content of $path", style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = text, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun StorageDirectory(fileList: Array<File>, path: String, onRemove: (File) -> Unit) {
    val fileCount = fileList.size
    Column {
        Text("Local Storage ", style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Path : $path", style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "Files : $fileCount", style = MaterialTheme.typography.bodySmall
        )
        for (file in fileList) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = file.name,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Icon(imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .height(20.dp)
                        .width(20.dp)
                        .clickable {
                            onRemove(file)
                        })
            }
        }
    }
}

