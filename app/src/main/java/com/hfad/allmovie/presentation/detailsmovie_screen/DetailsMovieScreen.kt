package com.hfad.allmovie.presentation.detailsmovie_screen

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hfad.allmovie.ui.theme.PrimaryGray

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsMovieScreen(
    viewModel: DetailsMovieViewModel = hiltViewModel(),
    navController: NavHostController

) {
    val movieId = navController.currentBackStackEntry?.arguments?.getString("movieId")
    Log.d("MovieId",movieId.toString())

    LaunchedEffect(movieId) {
        viewModel.getMovieDetails(movieId ?: "")
    }
    val details = viewModel.state.value

    Scaffold(topBar = {
        details.movieDetails?.extraInfo?.get(0)?.let {
            it.para.let { it1 ->
                TopDetailBar(title = it1 )
            }
        }
    }
    ) {

    }


}

@Composable
fun TopDetailBar(title: String) {
    val act = LocalContext.current as Activity
    TopAppBar(
        title = { Text(title, style = MaterialTheme.typography.h2) },
        navigationIcon = {
            IconButton(onClick = {
                act.finish()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = PrimaryGray
                )
            }
        }
    )

}