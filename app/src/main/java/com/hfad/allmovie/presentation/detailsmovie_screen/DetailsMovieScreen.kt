package com.hfad.allmovie.presentation.detailsmovie_screen

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.hfad.allmovie.presentation.detailsmovie_screen.components.Details
import com.hfad.allmovie.presentation.detailsmovie_screen.components.TopDetailBar
import com.hfad.allmovie.ui.theme.PrimaryGray
import com.hfad.allmovie.ui.theme.PurplyBlue

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsMovieScreen(
    viewModel: DetailsMovieViewModel = hiltViewModel(),
    navController: NavHostController

) {
    val movieId = navController.currentBackStackEntry?.arguments?.getString("movieId")

    LaunchedEffect(movieId) {
        viewModel.getMovieDetails(movieId ?: "")
    }
    val details = viewModel.state.value


    Scaffold(
        topBar = {
            details.movieDetails?.let { TopDetailBar(navController, it) }
        },
        backgroundColor = PurplyBlue

    ) {

        details.movieDetails?.let { it1 -> Details(details = it1) }

    }

}





