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
package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InetAddressRateLimitStatsDiffblueTest {
  /**
   * Test {@link InetAddressRateLimitStats#equals(Object)}, and {@link InetAddressRateLimitStats#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InetAddressRateLimitStats#equals(Object)}
   *   <li>{@link InetAddressRateLimitStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean InetAddressRateLimitStats.equals(Object)", "int InetAddressRateLimitStats.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InetAddressRateLimitStats inetAddressRateLimitStats = new InetAddressRateLimitStats();
    inetAddressRateLimitStats.setBlocked(true);
    inetAddressRateLimitStats.setConnectionsCount(3);
    inetAddressRateLimitStats.setFailureCount(3);
    inetAddressRateLimitStats.setLastActivityTs(1L);

    // Act and Assert
    assertEquals(inetAddressRateLimitStats, inetAddressRateLimitStats);
    int expectedHashCodeResult = inetAddressRateLimitStats.hashCode();
    assertEquals(expectedHashCodeResult, inetAddressRateLimitStats.hashCode());
  }

  /**
   * Test {@link InetAddressRateLimitStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InetAddressRateLimitStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean InetAddressRateLimitStats.equals(Object)", "int InetAddressRateLimitStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    InetAddressRateLimitStats inetAddressRateLimitStats = new InetAddressRateLimitStats();
    inetAddressRateLimitStats.setBlocked(true);
    inetAddressRateLimitStats.setConnectionsCount(3);
    inetAddressRateLimitStats.setFailureCount(3);
    inetAddressRateLimitStats.setLastActivityTs(1L);

    InetAddressRateLimitStats inetAddressRateLimitStats2 = new InetAddressRateLimitStats();
    inetAddressRateLimitStats2.setBlocked(true);
    inetAddressRateLimitStats2.setConnectionsCount(3);
    inetAddressRateLimitStats2.setFailureCount(3);
    inetAddressRateLimitStats2.setLastActivityTs(1L);

    // Act and Assert
    assertNotEquals(inetAddressRateLimitStats, inetAddressRateLimitStats2);
  }

  /**
   * Test {@link InetAddressRateLimitStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InetAddressRateLimitStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean InetAddressRateLimitStats.equals(Object)", "int InetAddressRateLimitStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    InetAddressRateLimitStats inetAddressRateLimitStats = new InetAddressRateLimitStats();
    inetAddressRateLimitStats.setBlocked(false);
    inetAddressRateLimitStats.setConnectionsCount(3);
    inetAddressRateLimitStats.setFailureCount(3);
    inetAddressRateLimitStats.setLastActivityTs(1L);

    InetAddressRateLimitStats inetAddressRateLimitStats2 = new InetAddressRateLimitStats();
    inetAddressRateLimitStats2.setBlocked(true);
    inetAddressRateLimitStats2.setConnectionsCount(3);
    inetAddressRateLimitStats2.setFailureCount(3);
    inetAddressRateLimitStats2.setLastActivityTs(1L);

    // Act and Assert
    assertNotEquals(inetAddressRateLimitStats, inetAddressRateLimitStats2);
  }

  /**
   * Test {@link InetAddressRateLimitStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InetAddressRateLimitStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean InetAddressRateLimitStats.equals(Object)", "int InetAddressRateLimitStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    InetAddressRateLimitStats inetAddressRateLimitStats = new InetAddressRateLimitStats();
    inetAddressRateLimitStats.setBlocked(true);
    inetAddressRateLimitStats.setConnectionsCount(1);
    inetAddressRateLimitStats.setFailureCount(3);
    inetAddressRateLimitStats.setLastActivityTs(1L);

    InetAddressRateLimitStats inetAddressRateLimitStats2 = new InetAddressRateLimitStats();
    inetAddressRateLimitStats2.setBlocked(true);
    inetAddressRateLimitStats2.setConnectionsCount(3);
    inetAddressRateLimitStats2.setFailureCount(3);
    inetAddressRateLimitStats2.setLastActivityTs(1L);

    // Act and Assert
    assertNotEquals(inetAddressRateLimitStats, inetAddressRateLimitStats2);
  }

  /**
   * Test {@link InetAddressRateLimitStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InetAddressRateLimitStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean InetAddressRateLimitStats.equals(Object)", "int InetAddressRateLimitStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    InetAddressRateLimitStats inetAddressRateLimitStats = new InetAddressRateLimitStats();
    inetAddressRateLimitStats.setBlocked(true);
    inetAddressRateLimitStats.setConnectionsCount(3);
    inetAddressRateLimitStats.setFailureCount(1);
    inetAddressRateLimitStats.setLastActivityTs(1L);

    InetAddressRateLimitStats inetAddressRateLimitStats2 = new InetAddressRateLimitStats();
    inetAddressRateLimitStats2.setBlocked(true);
    inetAddressRateLimitStats2.setConnectionsCount(3);
    inetAddressRateLimitStats2.setFailureCount(3);
    inetAddressRateLimitStats2.setLastActivityTs(1L);

    // Act and Assert
    assertNotEquals(inetAddressRateLimitStats, inetAddressRateLimitStats2);
  }

  /**
   * Test {@link InetAddressRateLimitStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InetAddressRateLimitStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean InetAddressRateLimitStats.equals(Object)", "int InetAddressRateLimitStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    InetAddressRateLimitStats inetAddressRateLimitStats = new InetAddressRateLimitStats();
    inetAddressRateLimitStats.setBlocked(true);
    inetAddressRateLimitStats.setConnectionsCount(3);
    inetAddressRateLimitStats.setFailureCount(3);
    inetAddressRateLimitStats.setLastActivityTs(3L);

    InetAddressRateLimitStats inetAddressRateLimitStats2 = new InetAddressRateLimitStats();
    inetAddressRateLimitStats2.setBlocked(true);
    inetAddressRateLimitStats2.setConnectionsCount(3);
    inetAddressRateLimitStats2.setFailureCount(3);
    inetAddressRateLimitStats2.setLastActivityTs(1L);

    // Act and Assert
    assertNotEquals(inetAddressRateLimitStats, inetAddressRateLimitStats2);
  }

  /**
   * Test {@link InetAddressRateLimitStats#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InetAddressRateLimitStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean InetAddressRateLimitStats.equals(Object)", "int InetAddressRateLimitStats.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    InetAddressRateLimitStats inetAddressRateLimitStats = new InetAddressRateLimitStats();
    inetAddressRateLimitStats.setBlocked(true);
    inetAddressRateLimitStats.setConnectionsCount(3);
    inetAddressRateLimitStats.setFailureCount(3);
    inetAddressRateLimitStats.setLastActivityTs(1L);

    // Act and Assert
    assertNotEquals(inetAddressRateLimitStats, null);
  }

  /**
   * Test {@link InetAddressRateLimitStats#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InetAddressRateLimitStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean InetAddressRateLimitStats.equals(Object)", "int InetAddressRateLimitStats.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    InetAddressRateLimitStats inetAddressRateLimitStats = new InetAddressRateLimitStats();
    inetAddressRateLimitStats.setBlocked(true);
    inetAddressRateLimitStats.setConnectionsCount(3);
    inetAddressRateLimitStats.setFailureCount(3);
    inetAddressRateLimitStats.setLastActivityTs(1L);

    // Act and Assert
    assertNotEquals(inetAddressRateLimitStats, "Different type to InetAddressRateLimitStats");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link InetAddressRateLimitStats}
   *   <li>{@link InetAddressRateLimitStats#setBlocked(boolean)}
   *   <li>{@link InetAddressRateLimitStats#setConnectionsCount(int)}
   *   <li>{@link InetAddressRateLimitStats#setFailureCount(int)}
   *   <li>{@link InetAddressRateLimitStats#setLastActivityTs(long)}
   *   <li>{@link InetAddressRateLimitStats#toString()}
   *   <li>{@link InetAddressRateLimitStats#getConnectionsCount()}
   *   <li>{@link InetAddressRateLimitStats#getFailureCount()}
   *   <li>{@link InetAddressRateLimitStats#getLastActivityTs()}
   *   <li>{@link InetAddressRateLimitStats#getLock()}
   *   <li>{@link InetAddressRateLimitStats#isBlocked()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InetAddressRateLimitStats.<init>()", "int InetAddressRateLimitStats.getConnectionsCount()",
      "int InetAddressRateLimitStats.getFailureCount()", "long InetAddressRateLimitStats.getLastActivityTs()",
      "Lock InetAddressRateLimitStats.getLock()", "boolean InetAddressRateLimitStats.isBlocked()",
      "void InetAddressRateLimitStats.setBlocked(boolean)", "void InetAddressRateLimitStats.setConnectionsCount(int)",
      "void InetAddressRateLimitStats.setFailureCount(int)", "void InetAddressRateLimitStats.setLastActivityTs(long)",
      "java.lang.String InetAddressRateLimitStats.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    InetAddressRateLimitStats actualInetAddressRateLimitStats = new InetAddressRateLimitStats();
    actualInetAddressRateLimitStats.setBlocked(true);
    actualInetAddressRateLimitStats.setConnectionsCount(3);
    actualInetAddressRateLimitStats.setFailureCount(3);
    actualInetAddressRateLimitStats.setLastActivityTs(1L);
    actualInetAddressRateLimitStats.toString();
    int actualConnectionsCount = actualInetAddressRateLimitStats.getConnectionsCount();
    int actualFailureCount = actualInetAddressRateLimitStats.getFailureCount();
    long actualLastActivityTs = actualInetAddressRateLimitStats.getLastActivityTs();
    Lock actualLock = actualInetAddressRateLimitStats.getLock();

    // Assert
    assertTrue(actualLock instanceof ReentrantLock);
    assertEquals(1L, actualLastActivityTs);
    assertEquals(3, actualConnectionsCount);
    assertEquals(3, actualFailureCount);
    assertTrue(actualInetAddressRateLimitStats.isBlocked());
  }
}
