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
package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EdgeCommunicationFailureNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder#edges(Set)}
   * </ul>
   */
  @Test
  void testEdgeCommunicationFailureNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult = EdgeCommunicationFailureNotificationRuleTriggerConfig
        .builder();
    HashSet<UUID> edges = new HashSet<>();

    // Act
    EdgeCommunicationFailureNotificationRuleTriggerConfig actualBuildResult = builderResult.edges(edges).build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.EDGE_COMMUNICATION_FAILURE, actualBuildResult.getTriggerType());
    Set<UUID> edges2 = actualBuildResult.getEdges();
    assertTrue(edges2.isEmpty());
    assertSame(edges, edges2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult = EdgeCommunicationFailureNotificationRuleTriggerConfig
        .builder();
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult = builderResult.edges(new HashSet<>()).build();
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult2 = EdgeCommunicationFailureNotificationRuleTriggerConfig
        .builder();
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult2 = builderResult2.edges(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder edgeCommunicationFailureNotificationRuleTriggerConfigBuilder = mock(
        EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.class);
    when(edgeCommunicationFailureNotificationRuleTriggerConfigBuilder.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeCommunicationFailureNotificationRuleTriggerConfig.builder());
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult = edgeCommunicationFailureNotificationRuleTriggerConfigBuilder
        .edges(new HashSet<>())
        .build();
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder edgeCommunicationFailureNotificationRuleTriggerConfigBuilder2 = mock(
        EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.class);
    when(edgeCommunicationFailureNotificationRuleTriggerConfigBuilder2.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeCommunicationFailureNotificationRuleTriggerConfig.builder());
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult2 = edgeCommunicationFailureNotificationRuleTriggerConfigBuilder2
        .edges(new HashSet<>())
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult = EdgeCommunicationFailureNotificationRuleTriggerConfig
        .builder();
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult = builderResult.edges(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder edgeCommunicationFailureNotificationRuleTriggerConfigBuilder = mock(
        EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.class);
    when(edgeCommunicationFailureNotificationRuleTriggerConfigBuilder.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeCommunicationFailureNotificationRuleTriggerConfig.builder());
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult = edgeCommunicationFailureNotificationRuleTriggerConfigBuilder
        .edges(new HashSet<>())
        .build();
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult = EdgeCommunicationFailureNotificationRuleTriggerConfig
        .builder();
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult2 = builderResult.edges(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder edgeCommunicationFailureNotificationRuleTriggerConfigBuilder = mock(
        EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.class);
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult = EdgeCommunicationFailureNotificationRuleTriggerConfig
        .builder();
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult = builderResult.edges(new HashSet<>()).build();
    when(edgeCommunicationFailureNotificationRuleTriggerConfigBuilder.build()).thenReturn(buildResult);
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder edgeCommunicationFailureNotificationRuleTriggerConfigBuilder2 = mock(
        EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.class);
    when(edgeCommunicationFailureNotificationRuleTriggerConfigBuilder2.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(edgeCommunicationFailureNotificationRuleTriggerConfigBuilder);
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult2 = edgeCommunicationFailureNotificationRuleTriggerConfigBuilder2
        .edges(new HashSet<>())
        .build();
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder edgeCommunicationFailureNotificationRuleTriggerConfigBuilder3 = mock(
        EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.class);
    when(edgeCommunicationFailureNotificationRuleTriggerConfigBuilder3.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeCommunicationFailureNotificationRuleTriggerConfig.builder());
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult3 = edgeCommunicationFailureNotificationRuleTriggerConfigBuilder3
        .edges(new HashSet<>())
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Method under test:
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult = EdgeCommunicationFailureNotificationRuleTriggerConfig
        .builder();
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult = builderResult.edges(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult = EdgeCommunicationFailureNotificationRuleTriggerConfig
        .builder();
    EdgeCommunicationFailureNotificationRuleTriggerConfig buildResult = builderResult.edges(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EdgeCommunicationFailureNotificationRuleTriggerConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#EdgeCommunicationFailureNotificationRuleTriggerConfig()}
   *   <li>
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#setEdges(Set)}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#getEdges()}
   *   <li>
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeCommunicationFailureNotificationRuleTriggerConfig actualEdgeCommunicationFailureNotificationRuleTriggerConfig = new EdgeCommunicationFailureNotificationRuleTriggerConfig();
    HashSet<UUID> edges = new HashSet<>();
    actualEdgeCommunicationFailureNotificationRuleTriggerConfig.setEdges(edges);
    String actualToStringResult = actualEdgeCommunicationFailureNotificationRuleTriggerConfig.toString();
    Set<UUID> actualEdges = actualEdgeCommunicationFailureNotificationRuleTriggerConfig.getEdges();

    // Assert that nothing has changed
    assertEquals("EdgeCommunicationFailureNotificationRuleTriggerConfig(edges=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.EDGE_COMMUNICATION_FAILURE,
        actualEdgeCommunicationFailureNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEdges.isEmpty());
    assertSame(edges, actualEdges);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#EdgeCommunicationFailureNotificationRuleTriggerConfig(Set)}
   *   <li>
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#setEdges(Set)}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#getEdges()}
   *   <li>
   * {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    EdgeCommunicationFailureNotificationRuleTriggerConfig actualEdgeCommunicationFailureNotificationRuleTriggerConfig = new EdgeCommunicationFailureNotificationRuleTriggerConfig(
        new HashSet<>());
    HashSet<UUID> edges = new HashSet<>();
    actualEdgeCommunicationFailureNotificationRuleTriggerConfig.setEdges(edges);
    String actualToStringResult = actualEdgeCommunicationFailureNotificationRuleTriggerConfig.toString();
    Set<UUID> actualEdges = actualEdgeCommunicationFailureNotificationRuleTriggerConfig.getEdges();

    // Assert that nothing has changed
    assertEquals("EdgeCommunicationFailureNotificationRuleTriggerConfig(edges=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.EDGE_COMMUNICATION_FAILURE,
        actualEdgeCommunicationFailureNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEdges.isEmpty());
    assertSame(edges, actualEdges);
  }
}
