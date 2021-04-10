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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Rule {
  static Set<Integer> born;
  static Set<Integer> survives;

  static Rule gameOfLife() {
    Rule rules= new Rule();
    Integer[] bornlist = new Integer[]{3};
    Integer[] surviveslist = new Integer[]{2,3};

    born = new HashSet<Integer>(Arrays.asList(bornlist));
    survives = new HashSet<Integer>(Arrays.asList(surviveslist));

    return rules;
  }

  static Rule highLife() {

    Rule rules= new Rule();
    Integer[] bornlist = new Integer[]{3,6};
    Integer[] surviveslist = new Integer[]{2,3};

    born = new HashSet<Integer>(Arrays.asList(bornlist));
    survives = new HashSet<Integer>(Arrays.asList(surviveslist));
    return rules;
  }

  static Rule seeds() {

    Rule rules= new Rule();
    Integer[] bornlist = new Integer[]{2};
    Integer[] surviveslist = new Integer[]{};

    born = new HashSet<Integer>(Arrays.asList(bornlist));
    survives = new HashSet<Integer>(Arrays.asList(surviveslist));

    return rules;
  }
}
