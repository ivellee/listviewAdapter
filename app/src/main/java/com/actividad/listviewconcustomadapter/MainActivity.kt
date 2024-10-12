package com.actividad.listviewconcustomadapter

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.actividad.listviewconcustomadapter.R


class MainActivity : AppCompatActivity() {

    // Modelo de datos para Contacto
    data class ContactoModel(
        val nombre: String,
        val telefono: String,
        val email: String,
        val imagenId: Int
    )

    // Adaptador personalizado para la lista de contactos
    class ContactAdapter(private val context: MainActivity, private val contactos: List<ContactoModel>) : BaseAdapter() {

        override fun getCount(): Int {
            return contactos.size
        }

        override fun getItem(position: Int): Any {
            return contactos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = convertView ?: context.layoutInflater.inflate(R.layout.list_items_contact, parent, false)

            // Obtener el contacto actual
            val contacto = contactos[position]

            // Obtener referencias de los elementos del layout y asignar los datos
            val nameView = view.findViewById<TextView>(R.id.contactName)
            val phoneView = view.findViewById<TextView>(R.id.contactPhone)
            val emailView = view.findViewById<TextView>(R.id.contactEmail)
            val imageView = view.findViewById<ImageView>(R.id.contactImage)

            nameView.text = contacto.nombre
            phoneView.text = contacto.telefono
            emailView.text = contacto.email
            imageView.setImageResource(contacto.imagenId)

            return view
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Crear la lista de contactos usando recursos de strings.xml
        val contactos = listOf(
            ContactoModel(getString(R.string.contact_name_miguel), getString(R.string.contact_phone_miguel), getString(R.string.contact_email_miguel), R.drawable.perfil1),
            ContactoModel(getString(R.string.contact_name_valentina), getString(R.string.contact_phone_valentina), getString(R.string.contact_email_valentina), R.drawable.perfil2),
            ContactoModel(getString(R.string.contact_name_andres), getString(R.string.contact_phone_andres), getString(R.string.contact_email_andres), R.drawable.perfil3),
            ContactoModel(getString(R.string.contact_name_camila), getString(R.string.contact_phone_camila), getString(R.string.contact_email_camila), R.drawable.perfil4),
            ContactoModel(getString(R.string.contact_name_luis), getString(R.string.contact_phone_luis), getString(R.string.contact_email_luis), R.drawable.perfil5),
            ContactoModel(getString(R.string.contact_name_ines), getString(R.string.contact_phone_ines), getString(R.string.contact_email_ines), R.drawable.perfil6),
            ContactoModel(getString(R.string.contact_name_nicolas), getString(R.string.contact_phone_nicolas), getString(R.string.contact_email_nicolas), R.drawable.perfil7),
            ContactoModel(getString(R.string.contact_name_isabella), getString(R.string.contact_phone_isabella), getString(R.string.contact_email_isabella), R.drawable.perfil8),
            ContactoModel(getString(R.string.contact_name_fernando), getString(R.string.contact_phone_fernando), getString(R.string.contact_email_fernando), R.drawable.perfil9),
            ContactoModel(getString(R.string.contact_name_paula), getString(R.string.contact_phone_paula), getString(R.string.contact_email_paula), R.drawable.perfil10)
        )



        // Obtener el ListView y configurar el adaptador
        val contactListView = findViewById<ListView>(R.id.contactListView)
        contactListView.adapter = ContactAdapter(this, contactos)  // Pasa el contexto aquí
    }
}