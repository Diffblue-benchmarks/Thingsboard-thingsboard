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
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.queue.discovery.HashPartitionService.QueueConfig;

class HashPartitionServiceDiffblueTest {
  /**
   * Test {@link HashPartitionService#forName(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"com.google.common.hash.HashFunction HashPartitionService.forName(String)"})
  void testForName_whenName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> HashPartitionService.forName("Name"));
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}, and {@link QueueConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueConfig#equals(Object)}
   *   <li>{@link QueueConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueConfig.equals(Object)", "int QueueConfig.hashCode()"})
  void testQueueConfigEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueConfig queueConfig = new QueueConfig(new QueueRoutingInfo(new Queue()));
    QueueConfig queueConfig2 = new QueueConfig(new QueueRoutingInfo(new Queue()));

    // Act and Assert
    assertEquals(queueConfig, queueConfig2);
    int expectedHashCodeResult = queueConfig.hashCode();
    assertEquals(expectedHashCodeResult, queueConfig2.hashCode());
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}, and {@link QueueConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueConfig#equals(Object)}
   *   <li>{@link QueueConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueConfig.equals(Object)", "int QueueConfig.hashCode()"})
  void testQueueConfigEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueConfig queueConfig = new QueueConfig(new QueueRoutingInfo(new Queue()));

    // Act and Assert
    assertEquals(queueConfig, queueConfig);
    int expectedHashCodeResult = queueConfig.hashCode();
    assertEquals(expectedHashCodeResult, queueConfig.hashCode());
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueConfig.equals(Object)", "int QueueConfig.hashCode()"})
  void testQueueConfigEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = mock(QueueRoutingInfo.class);
    when(queueRoutingInfo.isDuplicateMsgToAllPartitions()).thenReturn(true);
    QueueConfig queueConfig = new QueueConfig(queueRoutingInfo);

    // Act and Assert
    assertNotEquals(queueConfig, new QueueConfig(new QueueRoutingInfo(new Queue())));
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueConfig.equals(Object)", "int QueueConfig.hashCode()"})
  void testQueueConfigEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueConfig(new QueueRoutingInfo(new Queue())), null);
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueConfig.equals(Object)", "int QueueConfig.hashCode()"})
  void testQueueConfigEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueConfig(new QueueRoutingInfo(new Queue())), "Different type to QueueConfig");
  }

  /**
   * Test QueueConfig getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueConfig#setDuplicateMsgToAllPartitions(boolean)}
   *   <li>{@link QueueConfig#toString()}
   *   <li>{@link QueueConfig#isDuplicateMsgToAllPartitions()}
   * </ul>
   */
  @Test
  @DisplayName("Test QueueConfig getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueConfig.isDuplicateMsgToAllPartitions()",
      "void QueueConfig.setDuplicateMsgToAllPartitions(boolean)", "String QueueConfig.toString()"})
  void testQueueConfigGettersAndSetters() {
    // Arrange
    QueueConfig queueConfig = new QueueConfig(new QueueRoutingInfo(new Queue()));

    // Act
    queueConfig.setDuplicateMsgToAllPartitions(true);
    String actualToStringResult = queueConfig.toString();

    // Assert
    assertEquals("HashPartitionService.QueueConfig(duplicateMsgToAllPartitions=true)", actualToStringResult);
    assertTrue(queueConfig.isDuplicateMsgToAllPartitions());
  }

  /**
   * Test QueueConfig {@link QueueConfig#QueueConfig(QueueRoutingInfo)}.
   * <ul>
   *   <li>Then return not DuplicateMsgToAllPartitions.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueConfig#QueueConfig(QueueRoutingInfo)}
   */
  @Test
  @DisplayName("Test QueueConfig new QueueConfig(QueueRoutingInfo); then return not DuplicateMsgToAllPartitions")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueConfig.<init>(QueueRoutingInfo)"})
  void testQueueConfigNewQueueConfig_thenReturnNotDuplicateMsgToAllPartitions() {
    // Arrange, Act and Assert
    assertFalse((new QueueConfig(new QueueRoutingInfo(new Queue()))).isDuplicateMsgToAllPartitions());
  }
}
