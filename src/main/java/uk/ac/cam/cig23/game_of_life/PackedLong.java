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

import java.util.AbstractList;

class PackedLong extends AbstractList<Boolean> {
  private long packed;
  /**
   * Unpack the nth bit from the packed number and return it
   *
   *
   * @param position the position of the bit we are interested in from 0 to 63 inclusive
   * @return the value of the position'th bit
   */
  public Boolean get(int position) {
    return ((this.packed >>> position) & 1) == 1;
  }
  /**
   * Set the nth bit in the packed number to the value given and return the new packed number
   *
   *
   * @param position the position of the bit of interest
   * @param value the value to set the bit to
   * @return the new packed number
   */
  public Boolean set(int position, boolean value) {
    if (value) {
      packed |= 1L << position;
    } else {
      packed &= ~(1L << position);
    }
    return value;
  }
    /*I currently and stuck because the checker wants set to return Boolean but I am not sure how to return boolean
    while still making everything work with keeping the immutability of packed long. It might not need to be immutable but
    the code treats it like it is.

  public PackedLong set(int position, boolean value) {
      long newPacked = packed;
      if (value) {
            newPacked |= 1L << position;
        } else {
            newPacked &= ~(1L << position);
        }
        return new PackedLong(newPacked);
    }
    */


  public int size() {
    return 64;
  }

  public long read() {
    return this.packed;
  }

  public PackedLong(long num) {
    this.packed = num;
  }

  public PackedLong() {
    this.packed = 0L;
  }
}
