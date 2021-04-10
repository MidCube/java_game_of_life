/*
 * Copyright 2019 David Berry <dgb37@cam.ac.uk>, Joe Isaacs <josi2@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, C.I. Griffiths
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

import static com.google.common.truth.Truth.assertThat;
import static uk.ac.cam.cig23.game_of_life.WorldStringUtils.stringToWorld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WorldAliveNeighbourCountTest {

  @Test
  public void aliveNeighbourCount_excludesCentre() {
    // ARRANGE
    boolean[][] cells =
        new boolean[][] {
          {false, false, false},
          {false, true, false},
          {false, false, false},
        };
    World w =
        new StubWorld() {
          @Override
          public boolean cellAlive(int col, int row) {
            return cells[row][col];
          }
        };

    // ACT
    int neighbourCount = w.aliveNeighbourCount(1, 1);

    // ASSERT
    assertThat(neighbourCount).isEqualTo(0);
  }

    @Test
    public void aliveNeighbourCount_doesntCountOutOfRange() {
        // ARRANGE
        boolean[][] cells =
                new boolean[][] {
                        {false, true, false},
                        {true, true, false},
                        {false, false, false},
                };
        World w =
                new StubWorld() {
                    @Override
                    public boolean cellAlive(int col, int row) {
                        if (!(row <0 || row >2 || col <0 || col>2)) {return cells[row][col];}
                        else {return false;}
                    }
                };

        // ACT
        int neighbourCount = w.aliveNeighbourCount(0, 0);

        // ASSERT
        assertThat(neighbourCount).isEqualTo(3);
    }

    @Test
    public void specificCase() {
        // ARRANGE
        World w =
                stringToWorld(
                        new TinyWorld(),
                        "________",
                        "________",
                        "____#___",
                        "_____#__",
                        "___###__",
                        "________",
                        "________",
                        "________");

        // ACT
        int neighbourCount = w.aliveNeighbourCount(6, 3);

        // ASSERT
        assertThat(neighbourCount).isEqualTo(2);
    }
}
