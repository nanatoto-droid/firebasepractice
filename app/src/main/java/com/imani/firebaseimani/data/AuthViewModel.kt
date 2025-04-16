package com.imani.firebaseimani.data

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.imani.firebaseimani.model.User
import com.imani.firebaseimani.navigation.ROUTE_LOGIN

class AuthViewModel (var navController: NavController,
    var context:Context){

    var mAuth: FirebaseAuth

    init {
        mAuth= FirebaseAuth.getInstance()
    }
    fun signup(email: String,pass: String,confpass: String){
        if (email.isBlank()||pass.isBlank()||confpass.isBlank()){
            Toast.makeText(context,"Please email and password can't be blank",
                Toast.LENGTH_LONG).show()
            return
        }
        else if (pass!=confpass) {
            Toast.makeText(context, "Password do not match", Toast.LENGTH_LONG).show()
            return
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                if(it.isSuccessful){
                    val userData= User(email,pass,mAuth.currentUser!!.uid)
                    val regRef= FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userData).addOnCompleteListener {
                        if(it.isSuccessful){
                            Toast.makeText(context,"register successfully", Toast.LENGTH_LONG).show()
                                navController.navigate(ROUTE_LOGIN)
                        }
                        else{
                            Toast.makeText(context ,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)}
                        }
                    }


                }
            }
        }



    }
}