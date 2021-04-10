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

import static uk.ac.cam.cig23.game_of_life.WorldStringUtils.stringToWorld;
import static uk.ac.cam.cig23.game_of_life.WorldStringUtils.worldToString;

public class MainCompositeWorld {

  public static void main(String[] args) {

    World w =
        stringToWorld(
            new CompositeWorld(3, 1),
            "________________________",
            "________________________",
            "____________#___________",
            "_____________#__________",
            "___________###__________",
            "________________________",
            "________________________",
            "________________________");

    for (int i = 0; i < 5; i++) {
      System.out.println(worldToString(w));
      w = w.nextGeneration(Rule.gameOfLife());
    }
  }
}