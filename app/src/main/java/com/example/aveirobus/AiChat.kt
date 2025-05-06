package com.example.aveirobus

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

data class Message(val text: String, val isUser: Boolean)

@Composable
fun AiChat(paddingValues: PaddingValues) { // Added this parameter
    var questionText by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<Message>() }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues) // Apply the padding here
    ) {
        // Conversation history
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp), // You can still add internal padding if needed
            reverseLayout = true // Show latest messages at the bottom
        ) {
            items(messages.reversed()) { message ->
                MessageBubble(message)
            }
        }

        // Input area
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), // You can still add internal padding
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = questionText,
                onValueChange = { questionText = it },
                label = { Text("Ask me anything...") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (questionText.isNotBlank()) {
                    messages.add(Message(questionText, isUser = true))
                    // TODO: Send question to API and add assistant response
                    questionText = "" // Clear input field
                }
            }) {
                Text("Send")
            }
        }
    }
}

@Composable
fun MessageBubble(message: Message) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Text(
            text = message.text,
            modifier = Modifier.padding(12.dp)
        )
    }
}