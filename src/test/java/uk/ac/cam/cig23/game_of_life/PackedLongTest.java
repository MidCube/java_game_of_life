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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PackedLongTest {

  @Test
  public void set_onlyChangesAffectedPosition() {
    // ARRANGE
    PackedLong initial = new PackedLong(0xF00000000000000FL);

    // ACT
    initial.set(4, true);

    // ASSERT
    assertThat(initial.read()).isEqualTo(0xF00000000000001FL);
  }

  @Test
  public void clear_onlyChangesAffectedPosition() {
    // ARRANGE
    PackedLong initial = new PackedLong(0xF00000000000001FL);

    // ACT
    initial.set(4, false);

    // ASSERT
    assertThat(initial.read()).isEqualTo(0xF00000000000000FL);
  }

  @Test
  public void set_setsHighestBit_atPosition63() {
    // ARRANGE
    PackedLong initial = new PackedLong(0x0000000000000000L);

    // ACT
    initial.set(63, true);

    // ASSERT
    assertThat(initial.read()).isEqualTo(0x8000000000000000L);
  }

  @Test
  public void get_getsHighestBit_whenPosition63IsSet() {
    // ARRANGE
    PackedLong initial = new PackedLong(0x8000000000000000L);

    // ACT
    boolean value = initial.get(63);

    // ASSERT
    assertThat(value).isTrue();
  }

  @Test
  public void get_getsHighestBit_whenPosition63IsClear() {
    // ARRANGE
    PackedLong initial = new PackedLong(0x7000000000000000L);

    // ACT
    boolean value = initial.get(63);

    // ASSERT
    assertThat(value).isFalse();
  }

  @Test
  public void check_empty_PackedLong_is_0() {
    // ARRANGE
    PackedLong initial = new PackedLong();

    // ACT
    long value = initial.read();

    // ASSERT
    assertThat(value).isEqualTo(0L);
  }

  @Test
  public void check_empty_PackedLong_has_size_64() {
    // ARRANGE
    PackedLong initial = new PackedLong();

    // ACT
    int value = initial.size();

    // ASSERT
    assertThat(value).isEqualTo(64);
  }

  @Test
  public void check_read_returns_the_long_value() {
    // ARRANGE
    PackedLong initial = new PackedLong(0x7000000000000000L);

    // ACT
    long value = initial.read();

    // ASSERT
    assertThat(value).isEqualTo(0x7000000000000000L);
  }
}
