package com.divinando.tfg.adivinando.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.divinando.tfg.adivinando.R
import com.divinando.tfg.adivinando.databinding.ActivityMainBinding
import com.divinando.tfg.adivinando.model.entity.GameObjeto
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    //region Declaramos variables
        private lateinit var appBarConfiguration: AppBarConfiguration
        private lateinit var binding: ActivityMainBinding
        private  lateinit var  navView : NavigationView
        private  lateinit var  headerView : View
        private  lateinit var  drawerLayout : DrawerLayout
        private  lateinit var  navController : NavController
        private  lateinit var  mFirebaseAuth: FirebaseAuth
        companion object {
             var games = ArrayList<GameObjeto>()
        }
        //region Lista de Paises en el idioma español,ingles y sus respectivas urls
            var listaDePaisesEnEspañol = ArrayList<String>()
            var listaDePaisesEnIngles = ArrayList<String>()
            var listaDiccionarioEspañol= ArrayList<String>()
            var listaDiccionarioEnIngles = ArrayList<String>()
            var urls = ArrayList<String>()
        //endregion
        //region Cogiendo la instancia de la bd de Firestore
         private val db = FirebaseFirestore.getInstance()
        //endregion
    //endregion
    /**
     * Metodo onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //region AUTORIZAMOS A FIREBASE
            mFirebaseAuth = Firebase.auth
        //endregion
        //region Config Layout and Fragments
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            setSupportActionBar(binding.appBarMain.toolbar)
            drawerLayout = binding.drawerLayout
            navView= binding.navView
            navController = findNavController(R.id.nav_host_fragment_content_main)
            headerView =    navView.getHeaderView(0)

            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.nav_home, R.id.login, R.id.game, R.id.nav_gallery, R.id.nav_slideshow
                ), drawerLayout
            )
            drawerLayout.addDrawerListener(object : DrawerListener {
                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}
                override fun onDrawerOpened(drawerView: View) {}
                override fun onDrawerClosed(drawerView: View) {}
                override fun onDrawerStateChanged(newState: Int) {
                    val currentUser: FirebaseUser? = mFirebaseAuth.currentUser
                    if (currentUser == null) {
                        updateNavHeaderIfItsntLooged()
                        navView.menu.findItem(R.id.nav_logout).isVisible = false
                        navView.menu.findItem(R.id.nav_gallery).isVisible = false
                        navView.menu.findItem(R.id.nav_slideshow).isVisible = false
                        navView.menu.findItem(R.id.game).isVisible = false
                        navView.menu.findItem(R.id.login).isVisible = true

                    }else{
                        updateNavHeaderIfItsLooged(currentUser)
                        // User logged in
                        navView.menu.findItem(R.id.nav_logout).isVisible = true
                        navView.menu.findItem(R.id.nav_gallery).isVisible = true
                        navView.menu.findItem(R.id.nav_slideshow).isVisible = true
                        navView.menu.findItem(R.id.game).isVisible = true
                        navView.menu.findItem(R.id.login).isVisible = false


                    }
                }
            })
        //endregion
        //region Logout dandole al item del menu
            navView.menu.findItem(R.id.nav_logout).setOnMenuItemClickListener {
                logoutDialog()
                true
            }
        //endregion
        //region
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        //endregion
        loadGamesFromFirebase()



    }
    /**
     * Metodo logoutDialog
     */
    //region Funcion que realiza el logout de una persona
        private fun logoutDialog() {
            //region Realizamos un logout con FirebaseAuth
                mFirebaseAuth.signOut()
            //endregion
            //region En el caso que se desloguee se van todos los items del menu
                navView.menu.findItem(R.id.nav_logout).isVisible = false
                navView.menu.findItem(R.id.nav_gallery).isVisible = false
                navView.menu.findItem(R.id.nav_slideshow).isVisible = false
                navView.menu.findItem(R.id.game).isVisible = false
                navView.menu.findItem(R.id.login).isVisible = true
            //endregion
            //region Metodo que actualiza en header en caso de que no este logueado
                updateNavHeaderIfItsntLooged()
            //endregion

        }
    //endregion
    /**
     * Metodo onSupportNavigateUp
     */
    //region Dando soporte al navigation Drawer
        override fun onSupportNavigateUp(): Boolean {
            val navController = findNavController(R.id.nav_host_fragment_content_main)
            return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
        }
    //endregion
    /**
     * Metodo updateNavHeaderIfItsLooged
     */
    //region Metodo que actualiza el nav header en caso de que este logueado el usuario
        fun updateNavHeaderIfItsLooged(currentUser : FirebaseUser){
           var image =  headerView.findViewById<ImageView>(R.id.ivProfileIcon)
           var user =  headerView.findViewById<TextView>(R.id.tvProfileName)
           var correo =  headerView.findViewById<TextView>(R.id.tvProfileEmail)

            user.text = currentUser.displayName
            correo.text = currentUser.email
            Glide.with(this).load(currentUser.photoUrl).into(image)



        }
    //endregion
    /**
     * Metodo updateNavHeaderIfItsntLooged
     */
    //region Metodo que actualiza el nav header en caso de que no esté logueado el usuario
        fun updateNavHeaderIfItsntLooged(){


           var image =  headerView.findViewById<ImageView>(R.id.ivProfileIcon)
           var user =  headerView.findViewById<TextView>(R.id.tvProfileName)
           var correo =  headerView.findViewById<TextView>(R.id.tvProfileEmail)

            user.text = "PACO"
            correo.text = "usuario@example.com"
            Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/c/c1/Lionel_Messi_20180626.jpg").into(image)



        }
    //endregion

    /**
     * Metodo loadGamesFromFirebase
     */
    fun loadGamesFromFirebase () {
        //region Sacando Paises
            db.collection("Paises").document("ListaPaises").get().addOnSuccessListener { document ->

                /**
                 * El dato que devuelve el documento es de tipo HashMap
                 *  clave => valor
                 *   Ejemplo:
                 *   Paises => España
                 */

                //region Esto te devuelve la lista de paises en español y lo parseo arrayList ya que arriba he inicializado un ArrayList
                    listaDePaisesEnEspañol = document.data?.get("Paises") as ArrayList<String>
                //endregion
                //region Esto te devuelve la lista de paises en ingles y lo parseo arrayList ya que arriba he inicializado un ArrayList
                    listaDePaisesEnIngles = document.data?.get("EnglishCountries") as ArrayList<String>
                //endregion
                //region URLS DE LAS IMAGENES
                     urls = document.data?.get("urls") as ArrayList<String>
                //endregion
            }
        //endregion
        //region Sacando palabras diccionario
        db.collection("Diccionario").document("palabras").get().addOnSuccessListener { document ->

            /**
             * El dato que devuelve el documento es de tipo HashMap
             *  clave => valor
             *   Ejemplo:
             *   palabras => bobo
             */

            //region Esto te devuelve la lista de paises en español y lo parseo arrayList ya que arriba he inicializado un ArrayList
            listaDiccionarioEspañol = document.data?.get("palabrasEspañola") as ArrayList<String>
            //endregion
            //region Esto te devuelve la lista de paises en ingles y lo parseo arrayList ya que arriba he inicializado un ArrayList
            listaDiccionarioEnIngles = document.data?.get("palabrasBritanicas") as ArrayList<String>
            //endregion

        }
        //endregion
        //region Cargando el ArrayList
            var game1 = GameObjeto("Divinando","Normal","Español","https://www.astucesmobiles.com/wp-content/uploads/2022/02/Install-and-Play-Wordle-on-iPhone-.png",null,listaDiccionarioEspañol,"Pon a prueba al diccionario de la RAE",5)
            games.add(game1)
            var game2= GameObjeto("Divinando","Con Tildes","Español","https://www.astucesmobiles.com/wp-content/uploads/2022/02/Install-and-Play-Wordle-on-iPhone-.png",null,listaDiccionarioEspañol,"Pon a prueba al diccionario de la RAE con tildes",5)
            games.add(game2)
            var game3= GameObjeto("Divinando","Encadenados","Español","https://www.astucesmobiles.com/wp-content/uploads/2022/02/Install-and-Play-Wordle-on-iPhone-.png",null,listaDiccionarioEspañol,"Pon a prueba a tu mapa mental",5)
            games.add(game3)
            var game4= GameObjeto("Guesser","CountryGuesser","Español","https://www.astucesmobiles.com/wp-content/uploads/2022/02/Install-and-Play-Wordle-on-iPhone-.png",null,listaDePaisesEnEspañol,"Pon a prueba a tu mapa geográfico",5)
            games.add(game4)
            var game5= GameObjeto("Guesser","Inserta Palabras","Español","https://www.astucesmobiles.com/wp-content/uploads/2022/02/Install-and-Play-Wordle-on-iPhone-.png",null,null,"para ayudarnos",5)
            games.add(game5)

        //endregion


    }



}