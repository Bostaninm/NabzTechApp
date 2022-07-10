//package com.example.marathonapp.selection
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//
//class SelectionViewModel(repository: ISelectionRepository) : ViewModel() {
//    init {
//        viewModelScope.launch {
//            _current = MutableLiveData(repository.getRoot())
//            _childs = MutableLiveData(repository.getChildes(current.value))
//
//        }
//
//    }
//
//    val <T> options: Array<T>
//    lateinit var _current : MutableLiveData<Category>
//    val current: LiveData<Category> = _current
//    lateinit var _childs : MutableLiveData<List<Category>>
//    val childs: LiveData<List<Category>> = _childs
//
//
//
//
//
//
//    fun onSelect(index: Int) {
//        _current.value = _childs[index].value
//        if(_current.value.isSubject) {
//            TODO("")
//        } else {
//            _childs = repository.getChilds(_current.value)
//        }
//    }
//
//    fun onDialogDismiss() {
//        showDialog = false
//    }
//
//    val dialogState: SelectionSecreenDialogState = SelectionSecreenDialogState.Confirmation
//    var showDialog: Boolean = false
//    val navCats: List<String> = (current.path as String).split('/') // Transform liveData
//}
//
//
//enum class SelectionSecreenDialogState {
//    Confirmation,
//    Loading,
//    Fail,
//    Success
//}