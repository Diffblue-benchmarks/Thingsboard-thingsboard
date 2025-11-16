/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.aspect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MethodCallStatsDiffblueTest {
  /**
   * Test {@link MethodCallStats#snapshot()}.
   *
   * <p>Method under test: {@link MethodCallStats#snapshot()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MethodCallStatsSnapshot MethodCallStats.snapshot()"})
  public void testSnapshot() {
    // Arrange and Act
    MethodCallStatsSnapshot actualSnapshotResult = new MethodCallStats().snapshot();

    // Assert
    assertEquals(0, actualSnapshotResult.getExecutions());
    assertEquals(0, actualSnapshotResult.getFailures());
    assertEquals(0L, actualSnapshotResult.getTiming());
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}, and {@link MethodCallStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodCallStats#equals(Object)}
   *   <li>{@link MethodCallStats#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodCallStats.equals(Object)", "int MethodCallStats.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodCallStats methodCallStats = new MethodCallStats();

    // Act and Assert
    assertEquals(methodCallStats, methodCallStats);
    int expectedHashCodeResult = methodCallStats.hashCode();
    assertEquals(expectedHashCodeResult, methodCallStats.hashCode());
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodCallStats#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodCallStats.equals(Object)", "int MethodCallStats.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodCallStats methodCallStats = new MethodCallStats();

    // Act and Assert
    assertNotEquals(methodCallStats, new MethodCallStats());
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodCallStats#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodCallStats.equals(Object)", "int MethodCallStats.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodCallStats(), null);
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodCallStats#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodCallStats.equals(Object)", "int MethodCallStats.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodCallStats(), "Different type to MethodCallStats");
  }
}
