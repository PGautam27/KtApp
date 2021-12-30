package com.example.ktapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktapp.ui.theme.KtAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)
            ) {
               Image(painter = painterResource(id = R.drawable.happy_meal_small), contentDescription = null,
                   modifier = Modifier
                       .height(300.dp)
                       .fillMaxWidth(), contentScale = ContentScale.Crop)
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Happy Meals",
                            style = TextStyle(fontSize = 26.sp)
                        )
                        Text(text = "$5.99", color = Color.Red,
                            style = TextStyle(fontSize = 17.sp),
                            modifier = Modifier.align(Alignment.CenterVertically)
                            )
                    }
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(
                        text = "800 Calories",
                        style = TextStyle(fontSize = 17.sp)
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = { /*TODO*/ }, 
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "ORDER NOW")  
                    }
                }
            }
        }
        }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
@Composable
public fun ImageFromResource(
    resId: Int
){
    Image(
        painter = painterResource(resId),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
    )
}
@Composable
fun ScrollableColumn(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(0),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    reverseScrollDirection: Boolean = false,
    isScrollEnabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .verticalScroll(
                scrollState,
                isScrollEnabled,
                reverseScrolling = reverseScrollDirection
            )
            .padding(contentPadding),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KtAppTheme {
        Greeting("Android")
    }
}