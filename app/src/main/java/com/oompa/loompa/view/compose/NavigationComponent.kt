package com.oompa.loompa.view.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.presentation.viewModel.OompaViewModel

@Composable
fun NavigationComponent(navController: NavHostController, oompaList: List<OompaDetail>, viewModel: OompaViewModel) {
    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable("list") {
           DisplayOompaList(navController =  navController, oompaList)
        }
        composable("details/{id}", arguments = listOf(navArgument("id"){type = NavType.IntType})) {
            backStackEntry ->
            backStackEntry.arguments?.getInt("id")?.let { OompaDetailView( viewModel, it) }
        }
    }
}