/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.compose.ComposePreviewData
import com.example.androiddevchallenge.ui.compose.PREVIEW_DARK_THEME
import com.example.androiddevchallenge.ui.compose.PREVIEW_HEIGHT
import com.example.androiddevchallenge.ui.compose.PREVIEW_LIGHT_THEME
import com.example.androiddevchallenge.ui.compose.PREVIEW_WIDTH
import com.example.androiddevchallenge.ui.compose.ScreenConfiguration
import com.example.androiddevchallenge.ui.compose.overview.OverviewScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenConfiguration = ScreenConfiguration(
            orientation = resources.configuration.orientation,
            screenWidthDp = resources.configuration.screenWidthDp,
            screenHeightDp = resources.configuration.screenHeightDp, // excluding system ui.
            density = resources.displayMetrics.density,
            scaledDensity = resources.displayMetrics.scaledDensity
        )

        // val gridPuppyList = mutableListOf<GridRowPuppy>()
        // val rowPuppies = mutableListOf<Puppy>()
        //
        // ComposePreviewData.puppies.forEachIndexed { index, puppy ->
        //     if (index % 2 == 0) {
        //         rowPuppies.clear()
        //     }
        //     rowPuppies.add(puppy)
        //
        //     if (index % 2 == (2 - 1) || index == ComposePreviewData.puppies.size - 1) {
        //         gridPuppyList.add(GridRowPuppy(rowPuppies))
        //     }
        // }

        // val gridP = gridPuppyList

        val puppies = ComposePreviewData.puppies

        setContent {
            OverviewScreen(
                screenConfiguration = screenConfiguration,
                puppies = puppies
            )
        }
    }
}

@Preview(PREVIEW_DARK_THEME, widthDp = PREVIEW_WIDTH, heightDp = PREVIEW_HEIGHT)
@Composable
fun DarkThemeOverviewScreenPreview() {
    OverviewScreen(
        darkTheme = true,
        screenConfiguration = ComposePreviewData.screenConfiguration,
        puppies = ComposePreviewData.puppies
    )
}

@Preview(PREVIEW_LIGHT_THEME, widthDp = PREVIEW_WIDTH, heightDp = PREVIEW_HEIGHT)
@Composable
fun LightThemeOverviewScreenPreview() {
    OverviewScreen(
        darkTheme = false,
        screenConfiguration = ComposePreviewData.screenConfiguration,
        puppies = ComposePreviewData.puppies
    )
}
