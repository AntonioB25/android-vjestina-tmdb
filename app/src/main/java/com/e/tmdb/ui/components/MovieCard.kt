import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.e.tmdb.models.MovieItem
import com.e.tmdb.R


@ExperimentalMaterialApi
@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    item: MovieItem,
    navigateToDetails: (Int?) -> Unit
) {
    Box(
        modifier
            .height(180.dp)
            .width(120.dp)
            .padding(bottom = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {  navigateToDetails(item.id)}
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = item.imageUrl),
            contentDescription = item.title + " cover",
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
        )

        FavouriteButton(modifier = Modifier)
    }
}

@Composable
fun FavouriteButton(
    modifier: Modifier,
    color: Color = Color.White
) {
    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = { isFavorite = !isFavorite },
        modifier = modifier
            .clip(CircleShape)
            .background(Color(R.color.dark_blue).copy(0.6f))

    ) {
        Icon(
            tint = color,
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = "Favourite button"
        )
    }
}

//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//@Preview
//fun MovieCardPreview() {
//    MovieCard(
//        item = MovieItem(1, "Ironman", R.drawable.ironman),
//        navigateToDetails = navigateToDetails
//    )
//}