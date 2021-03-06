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

public final class TinyWorld implements World {
  private PackedLong worldState;

  TinyWorld() {
    worldState = new PackedLong();

  }

  TinyWorld(PackedLong world) {
    worldState = world;

  }

  @Override
  public int width() {
    return 8;
  }

  @Override
  public int height() {
    return 8;
  }

  @Override
  public boolean cellAlive(int col, int row) {
    int position = 8*row+col;
    if((col<0||col>=this.width())||(row<0||row>=this.height())) {
     return false;
    } else {
      return this.worldState.get(position);
    }


  }

  @Override
  public TinyWorld withCellAliveness(int col, int row, boolean b) {
    int position = 8*row+col;
    long newWorldState = worldState.read();
    PackedLong copyState = new PackedLong(newWorldState);
    if(!((col<0||col>=this.width())||(row<0||row>=this.height()))) {
      copyState.set(position, b);
    }
    return new TinyWorld(copyState);
  }
}
