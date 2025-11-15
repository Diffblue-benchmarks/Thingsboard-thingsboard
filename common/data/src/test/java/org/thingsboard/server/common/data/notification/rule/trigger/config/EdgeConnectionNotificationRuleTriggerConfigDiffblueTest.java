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

class EdgeConnectionNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder#edges(Set)}
   *   <li>
   * {@link EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder#notifyOn(Set)}
   * </ul>
   */
  @Test
  void testEdgeConnectionNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult = EdgeConnectionNotificationRuleTriggerConfig
        .builder();
    HashSet<UUID> edges = new HashSet<>();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult = builderResult
        .edges(edges);
    HashSet<EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectivityEvent> notifyOn = new HashSet<>();

    // Act
    EdgeConnectionNotificationRuleTriggerConfig actualBuildResult = edgesResult.notifyOn(notifyOn).build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.EDGE_CONNECTION, actualBuildResult.getTriggerType());
    Set<UUID> edges2 = actualBuildResult.getEdges();
    assertTrue(edges2.isEmpty());
    Set<EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectivityEvent> notifyOn2 = actualBuildResult.getNotifyOn();
    assertTrue(notifyOn2.isEmpty());
    assertSame(edges, edges2);
    assertSame(notifyOn, notifyOn2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult = EdgeConnectionNotificationRuleTriggerConfig
        .builder();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult = builderResult
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult = edgesResult.notifyOn(new HashSet<>()).build();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult2 = EdgeConnectionNotificationRuleTriggerConfig
        .builder();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult2 = builderResult2
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult2 = edgesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgeConnectionNotificationRuleTriggerConfigBuilder = mock(
        EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult = edgeConnectionNotificationRuleTriggerConfigBuilder
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult = edgesResult.notifyOn(new HashSet<>()).build();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgeConnectionNotificationRuleTriggerConfigBuilder2 = mock(
        EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder2.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult2 = edgeConnectionNotificationRuleTriggerConfigBuilder2
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult2 = edgesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult = EdgeConnectionNotificationRuleTriggerConfig
        .builder();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult = builderResult
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult = edgesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgeConnectionNotificationRuleTriggerConfigBuilder = mock(
        EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult = edgeConnectionNotificationRuleTriggerConfigBuilder
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult = edgesResult.notifyOn(new HashSet<>()).build();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult = EdgeConnectionNotificationRuleTriggerConfig
        .builder();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult2 = builderResult
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult2 = edgesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgeConnectionNotificationRuleTriggerConfigBuilder = mock(
        EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder
        .notifyOn(Mockito.<Set<EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectivityEvent>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgeConnectionNotificationRuleTriggerConfigBuilder2 = mock(
        EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder2.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(edgeConnectionNotificationRuleTriggerConfigBuilder);
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult = edgeConnectionNotificationRuleTriggerConfigBuilder2
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult = edgesResult.notifyOn(new HashSet<>()).build();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgeConnectionNotificationRuleTriggerConfigBuilder3 = mock(
        EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder3.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult2 = edgeConnectionNotificationRuleTriggerConfigBuilder3
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult2 = edgesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgeConnectionNotificationRuleTriggerConfigBuilder = mock(
        EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult = EdgeConnectionNotificationRuleTriggerConfig
        .builder();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult = builderResult
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult = edgesResult.notifyOn(new HashSet<>()).build();
    when(edgeConnectionNotificationRuleTriggerConfigBuilder.build()).thenReturn(buildResult);
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgeConnectionNotificationRuleTriggerConfigBuilder2 = mock(
        EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder2
        .notifyOn(Mockito.<Set<EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectivityEvent>>any()))
        .thenReturn(edgeConnectionNotificationRuleTriggerConfigBuilder);
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgeConnectionNotificationRuleTriggerConfigBuilder3 = mock(
        EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder3.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(edgeConnectionNotificationRuleTriggerConfigBuilder2);
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult2 = edgeConnectionNotificationRuleTriggerConfigBuilder3
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult2 = edgesResult2.notifyOn(new HashSet<>()).build();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgeConnectionNotificationRuleTriggerConfigBuilder4 = mock(
        EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder4.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult3 = edgeConnectionNotificationRuleTriggerConfigBuilder4
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult3 = edgesResult3.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Method under test:
   * {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult = EdgeConnectionNotificationRuleTriggerConfig
        .builder();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult = builderResult
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult = edgesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult = EdgeConnectionNotificationRuleTriggerConfig
        .builder();
    EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult = builderResult
        .edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig buildResult = edgesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EdgeConnectionNotificationRuleTriggerConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EdgeConnectionNotificationRuleTriggerConfig#EdgeConnectionNotificationRuleTriggerConfig()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#setEdges(Set)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getEdges()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeConnectionNotificationRuleTriggerConfig actualEdgeConnectionNotificationRuleTriggerConfig = new EdgeConnectionNotificationRuleTriggerConfig();
    HashSet<UUID> edges = new HashSet<>();
    actualEdgeConnectionNotificationRuleTriggerConfig.setEdges(edges);
    HashSet<EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectivityEvent> notifyOn = new HashSet<>();
    actualEdgeConnectionNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualEdgeConnectionNotificationRuleTriggerConfig.toString();
    Set<UUID> actualEdges = actualEdgeConnectionNotificationRuleTriggerConfig.getEdges();
    Set<EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectivityEvent> actualNotifyOn = actualEdgeConnectionNotificationRuleTriggerConfig
        .getNotifyOn();

    // Assert that nothing has changed
    assertEquals("EdgeConnectionNotificationRuleTriggerConfig(edges=[], notifyOn=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.EDGE_CONNECTION,
        actualEdgeConnectionNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(edges, actualEdges);
    assertSame(notifyOn, actualNotifyOn);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EdgeConnectionNotificationRuleTriggerConfig#EdgeConnectionNotificationRuleTriggerConfig(Set, Set)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#setEdges(Set)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getEdges()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    HashSet<UUID> edges = new HashSet<>();

    // Act
    EdgeConnectionNotificationRuleTriggerConfig actualEdgeConnectionNotificationRuleTriggerConfig = new EdgeConnectionNotificationRuleTriggerConfig(
        edges, new HashSet<>());
    HashSet<UUID> edges2 = new HashSet<>();
    actualEdgeConnectionNotificationRuleTriggerConfig.setEdges(edges2);
    HashSet<EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectivityEvent> notifyOn = new HashSet<>();
    actualEdgeConnectionNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualEdgeConnectionNotificationRuleTriggerConfig.toString();
    Set<UUID> actualEdges = actualEdgeConnectionNotificationRuleTriggerConfig.getEdges();
    Set<EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectivityEvent> actualNotifyOn = actualEdgeConnectionNotificationRuleTriggerConfig
        .getNotifyOn();

    // Assert that nothing has changed
    assertEquals("EdgeConnectionNotificationRuleTriggerConfig(edges=[], notifyOn=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.EDGE_CONNECTION,
        actualEdgeConnectionNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(edges2, actualEdges);
    assertSame(notifyOn, actualNotifyOn);
  }
}
