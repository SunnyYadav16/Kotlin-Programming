package com.example.androidnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidnavigation.ui.theme.AndroidNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidNavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "thirdscreen") {
        composable("firstscreen") {
            FirstScreen { name, age ->
                navController.navigate("secondscreen/$name/$age")
            }
        }

        composable(route = "secondscreen/{name}/{age}") {
            val name = it.arguments?.getString("name")
            val age = it.arguments?.getString("age")?.toIntOrNull()
            if (name != null) {
                SecondScreen(name = name, age = age,
                    navigateToFirstScreen = { navController.navigate("firstscreen") },
                    navigationToThirdScreen = { navController.navigate("thirdscreen") }
                )
            }
        }

        composable(route = "thirdscreen") {
            ThirdScreen {
                navController.navigate("firstscreen")
            }
        }
    }
}



//1. Start by creating a new Kotlin file named "ThirdScreen.kt".
//2. Now, create a **`@Composable`** function named **`ThirdScreen`** which takes a lambda function **`navigateToFirstScreen`** as a parameter.
//3. Inside this composable, define a **`Button`** that, when clicked, will call **`navigateToFirstScreen()`**.
//4. Also, add a **`Text`** Composable inside the button to display the text "This is the Third Screen. Go to First Screen".
//5. Create a **`@Preview`** Composable function to preview the ThirdScreen.
//6. Head back to your "MainActivity.kt" or wherever you have defined your NavHost
//7. Inside your NavHost, add a new composable function for the Third Screen.
//8. The root should be "third_screen" and it should call ThirdScreen() function.
//9. Pass a lambda function to navigate back to the first screen. You can use navcontroller.navigate('first_screen')
//10. Go to your "SecondScreen.kt" file.
//11. Add a parameter to your **`@Composable`** function for **`navigateToThirdScreen`** similar to what you have done for navigating to the first screen.
//12. Inside the **`Button`** in **`SecondScreen`**, add another **`Button`** to navigate to the third screen using **`navigateToThirdScreen()`**.
//13. Make sure to also add a **`Text`** Composable inside the button to display the text "Go to Third Screen".
//14. In "MainActivity.kt", inside the **`NavHost`**, update the **`SecondScreen`** **`composable`** function to pass the lambda function to navigate to the third screen.


//Adding Age Input to the First Screen:**
//1. Navigate to the composable function that represents your first screen.
//2. Add another `OutlinedTextField`**below the existing one for the user to input their age.
//3. Create a **`remember`** state variable of type `Int` to store the age value. Make sure to handle
//    the conversion from text to integer appropriately.
//4. Update the UI to include a label for the age input field.
//5. **Updating the Navigation to Pass Age:**
//6. Update the function that handles navigation to the second screen to also take an **`age`** parameter of type **`Int`**.
//7. Modify the **`onClick`** event of the button (or the navigation trigger) to pass the age value along with the name to the second screen.
//8. Ensure that the navigation route string in the **`NavController`** includes a placeholder for the age parameter.
//9. **Receiving Age in the Second Screen:**
//10. In the composable function for the second screen, add a parameter for age of type **`Int`**.
//11. Retrieve the age value from the navigation arguments, similar to how you retrieved the name.
//12. Set a default value for age in case it is not passed.
//13. **Displaying Age and Name:**
//14. Update the UI of the second screen to display a greeting that includes both the name and age. For example, "Hello 25 year old Alex!"
//15. Make sure the UI adjusts correctly if age is not provided.


// first screen
// text, user input, button
// second screen

// first screen data -> pass to the second screen


// DATABASE - ROOM DB (SQLITE)

// NAVIGATION -
// FORM -> WITHOUT ANY DATA LOSS, THE SAME DATA IS AVAILABLE ON THE NEXT PAGE.
// PROPER STRUCTURE - 1,2,3, BACKFORWARD - 3,1,2,3. CORRECT FORMAT - 3,2,1




