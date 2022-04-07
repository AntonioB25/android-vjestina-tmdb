package com.e.tmdb.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.e.tmdb.R
import com.e.tmdb.models.CastMember
import com.e.tmdb.models.MovieItem

@Composable
fun MovieDetails(
    id: Int?
) {
    LazyColumn() {
        item {
            ImageAndInfo()
            Spacer(Modifier.padding(10.dp))
            Overview(Modifier.padding(start = 10.dp))
            Spacer(Modifier.padding(10.dp))
            Cast(Modifier.padding(start = 10.dp))
            Spacer(Modifier.padding(10.dp))
            Social(Modifier.padding(start = 10.dp))
            Spacer(Modifier.padding(10.dp))
            Recommendations()
        }
    }
}


@Composable
fun ImageAndInfo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.ironman),
            contentDescription = "Movie cover",
            modifier = Modifier
                .fillMaxSize()
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = size.height / 3,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient, blendMode = BlendMode.Multiply)
                    }
                },
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop
        )

        Column(
            Modifier
                .align(BottomStart)
                .fillMaxWidth()
                .padding(start = 30.dp)

        ) {
            Row(verticalAlignment = CenterVertically) {
                CircularProgressIndicator(color = Color.Green, progress = 0.74f)
                Text(
                    text = "User Score",
                    modifier = Modifier
                        .align(CenterVertically)
                        .padding(start = 10.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Iron man (2008)",
                fontSize = 20.sp,
                color = Color.White
            )

            Text(
                text = "05/02/2008 (US)",
                color = Color.White
            )
            Text(
                buildAnnotatedString {
                    append("Action, Science Fiction  ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("2h 6m")
                    }
                },
                color = Color.White
            )

            StarButton(modifier = Modifier.padding(top = 20.dp, bottom = 10.dp))
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Overview(
    modifier: Modifier
) {
    Text(
        modifier = modifier,
        text = "Overview",
        style = MaterialTheme.typography.h1,
    )

    Spacer(Modifier.padding(10.dp))
    Text(
        modifier = modifier,
        text = "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil."
    )

    Spacer(Modifier.padding(10.dp))
    /**
     * Trenutno imam samo listu stringova, nisam htio raditi posebnu klasu za osobe
     * Ne znam kako će kasnije ti objekti izgledati pa mi je ovako jednostavnije za trenutni prikaz
     */
    var crew = listOf("Don Heck", "Jack Kirby", "Jack Marcum", "Matt Holloway")

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(crew) { member ->
            StaffCard(
                name = member,
                job = member
            ) //trenutno predajem isto jer mi je jednostavnije dok nema podataka
        }
    }

    /**PROBLEM JER IMAM 2 SCROLLABLE-a**/
//    LazyVerticalGrid(
//        modifier = modifier,
//        cells = GridCells.Fixed(3),
//    ) {
//        items(crew) { person ->
//            Column {
//                Text(
//                    text = person,                              // bilo bi person.name + person.lastName
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 10.dp)
//                )
//                Text(text = person)                             // bilo bi person.role
//            }
//        }
//    }
}

@Composable
fun StaffCard(name: String, job: String) {
    Column {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(text = job)
    }
}


var cast = mutableListOf(
    CastMember("Robert Downey Jr.", "Tony Stark/Iron man", R.drawable.rdj),
    CastMember("Terrence Howard", "James Rhodes", R.drawable.terrence),
    CastMember("Robert Downey Jr.", "Tony Stark/Iron man", R.drawable.rdj),
    CastMember("Terrence Howard", "James Rhodes", R.drawable.terrence),
)

@Composable
fun Cast(
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = CenterVertically) {
            Text(
                text = "Top Billed Cast",
                style = MaterialTheme.typography.h1,
            )

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = null,
                onClick = {
                    //TODO: show full cast & crew
                },
            ) {
                Text(text = "Full Cast & Crew", style = MaterialTheme.typography.h2)
            }
        }

        CastList(list = cast)
    }
}


@Composable
fun Social(modifier: Modifier) {
    Column(modifier) {
        Text(
            text = "Social",
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.padding(10.dp))

        Row {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = null,
                onClick = {
                    //TODO: show reviews
                },
            ) {
                Text(text = "Reviews", style = MaterialTheme.typography.h6)
            }

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = null,
                onClick = {
                    //TODO: show discussions
                },
            ) {
                Text(text = "Discussions", style = MaterialTheme.typography.h6)
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))
        ReviewCard()
    }
}


@Composable
fun Recommendations() {
    var reccoms = listOf(
        MovieItem(1, "Ironman", R.drawable.ironman),
        MovieItem(2, "Godzzila", R.drawable.godzzila),
        MovieItem(3, "Puppy Love", R.drawable.puppy_love),
    )


    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            text = "Recommendations",
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.padding(10.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(reccoms) { movie ->
                RecommendationCard(movie = movie)
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CastList(list: MutableList<CastMember>) {
    LazyRow(
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(list) { member ->
            CastMemberCard(modifier = Modifier, member = member)
        }
    }
}

@Composable
fun StarButton(
    modifier: Modifier,
    color: Color = Color.White
) {
    var isStar by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isStar,
        onCheckedChange = { isStar = !isStar },
        modifier = modifier
            .clip(CircleShape)
            .background(Color(0xFF757575))

    ) {
        Icon(
            tint = color,
            imageVector = if (isStar) {
                Icons.Outlined.Star
            } else {
                Icons.Outlined.Star
            },
            contentDescription = "Star button"
        )
    }
}

@Composable
@Preview
fun movdetPreviews() {
    MovieDetails(id = 2)
}