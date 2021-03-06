/*
 * Copyright 2020 David Berry <dgb37@cam.ac.uk>, Joe Isaacs <josi2@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, C.I. Griffiths
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.cig23.game_of_life;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class RuleTest {

    @Test
    public void seeds_have_rightNumberOfBornAndSurvive() {
        // ARRANGE
        Rule seedling = Rule.seeds();

        // ACT

        // ASSERT
        assertThat(seedling.born.contains(2)).isTrue();
        assertThat(seedling.survives.isEmpty()).isTrue();
        //ACT
        seedling.born.remove(2);
        //ASSERT
        assertThat(seedling.born.isEmpty()).isTrue();
    }

    @Test
    public void HigherLife_have_rightNumberOfBornAndSurvive() {
        // ARRANGE
        Rule seedling = Rule.highLife();

        // ACT

        // ASSERT
        assertThat(seedling.born.contains(3)).isTrue();
        assertThat(seedling.born.contains(6)).isTrue();
        assertThat(seedling.survives.contains(2)).isTrue();
        assertThat(seedling.survives.contains(3)).isTrue();

        seedling.born.remove(3);
        seedling.born.remove(6);
        seedling.survives.remove(2);
        seedling.survives.remove(3);

        assertThat(seedling.survives.isEmpty()).isTrue();
        assertThat(seedling.born.isEmpty()).isTrue();
    }
}
