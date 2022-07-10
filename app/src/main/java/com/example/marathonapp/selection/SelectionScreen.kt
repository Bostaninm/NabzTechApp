//package com.example.marathonapp.selection
//
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material.Button
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.window.Dialog
//
//@Composable
//fun SelectionScreen(viewModel: SelectionViewModel, navigateToMain : () -> Unit) {
//
//    LazyColumn {
//        item {
//            NavHistory(viewModel.navCats)
//        }
//        itemsIndexed(viewModel.options) { index, option ->
//            Button(onClick = {viewModel.onSelect(index)}) {
//                Text(option.name)
//            }
//        }
//    }
//    if(viewModel.showDialog) {
//        Dialog(onDismissRequest = { viewModel.onDialogDismiss() }) {
//            when(viewModel.dialogState) {
//                SelectionSecreenDialogState.Confirmation -> TODO()
//                SelectionSecreenDialogState.Loading -> TODO()
//                SelectionSecreenDialogState.Fail -> TODO()
//                SelectionSecreenDialogState.Success -> TODO()
//            }
//        }
//    }
//}
//
//
//@Composable
//fun NavHistory(navCats : List<String>) {
//    Row {
//        for (cat in navCats) {
//            Text(cat)
//        }
//    }
//}