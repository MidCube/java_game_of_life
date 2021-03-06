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

public class CompositeWorld implements World {

  private final TinyWorld[][] worlds;
  private final int width;
  private final int height;

  /**
   * Creates a new instance of the world.
   *
   * <p>Note that the width and height parameters here correspond to the number of TinyWorld objects
   * to use rather than the number of cells.
   *
   * @param width the number of columns of TinyWorld objects to use
   * @param height the number of rows of TinyWorld objects to use
   */
  CompositeWorld(int width, int height) {
    worlds = new TinyWorld[height][width];
    for(int i=0; i<height;i++){
      for(int j=0;j<width;j++) {
        worlds[i][j] = new TinyWorld();
      }
    }
    this.width = width;
    this.height = height;
  }

  CompositeWorld(TinyWorld[][] world) {
    worlds = world;
    this.width = world[0].length;
    this.height = world.length;

  }

  @Override
  public int width() {
    return width * 8;
  }

  @Override
  public int height() {
    return height * 8;
  }

  @Override
  public boolean cellAlive(int col, int row) {
    if (col<0 || row<0 || col>=this.width() || row >=this.height()) {
      return false;
    }
    int newcol = col%8;
    int newrow = row%8;
    int widthcoord = (col-newcol)/8;
    int heightcoord = (row-newrow)/8;
    TinyWorld specificWorld = worlds[heightcoord][widthcoord];
    return specificWorld.cellAlive(newcol,newrow);
  }

  @Override
  public CompositeWorld withCellAliveness(int col, int row, boolean b) {
    int newcol = col%8;

    int newrow = row%8;
    int widthcoord = (col-newcol)/8;
    int heightcoord = (row-newrow)/8;

    TinyWorld[][] newWorld = new TinyWorld[height][width];
    for(int i=0; i<height;i++){
      newWorld[i] = worlds[i].clone();
    }


    TinyWorld specificWorld = newWorld[heightcoord][widthcoord];

    newWorld[heightcoord][widthcoord] = specificWorld.withCellAliveness(newcol,newrow,b);
    return new CompositeWorld(newWorld);
  }
}
