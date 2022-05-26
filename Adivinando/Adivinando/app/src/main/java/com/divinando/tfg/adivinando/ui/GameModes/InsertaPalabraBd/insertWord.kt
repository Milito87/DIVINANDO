package com.divinando.tfg.adivinando.ui.GameModes.InsertaPalabraBd

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.divinando.tfg.adivinando.databinding.FragmentInsertWordBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore

class insertWord : Fragment() {

    private var _binding: FragmentInsertWordBinding? = null
    private val binding get() = _binding!!
    private val db = FirebaseFirestore.getInstance()
    var size = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentInsertWordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btAddWord.setOnClickListener {
            init(view)
        }

    }

    private fun init(view: View){
        if(binding.tvAddWord.text.length == 5) {
            db.collection("Palabras").get().addOnSuccessListener {
                size = it.documents.size

                db.collection("Palabras").document(size.toString()).set(
                    hashMapOf("nombre" to binding.tvAddWord.text.toString().uppercase())
                )
            }
        }
        else{
            Snackbar.make(view, "Please write a 5 length word", Snackbar.LENGTH_SHORT)
        }

    }

}