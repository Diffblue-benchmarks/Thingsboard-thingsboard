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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectivityEvent;

@ContextConfiguration(classes = {EdgeConnectionNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class EdgeConnectionNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private EdgeConnectionNotificationRuleTriggerConfigBuilder
      edgeConnectionNotificationRuleTriggerConfigBuilder;

  /**
   * Test EdgeConnectionNotificationRuleTriggerConfigBuilder {@link
   * EdgeConnectionNotificationRuleTriggerConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfigBuilder#build()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfigBuilder#edges(Set)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfigBuilder#notifyOn(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test EdgeConnectionNotificationRuleTriggerConfigBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeConnectionNotificationRuleTriggerConfigBuilder.<init>()",
    "EdgeConnectionNotificationRuleTriggerConfig EdgeConnectionNotificationRuleTriggerConfigBuilder.build()",
    "EdgeConnectionNotificationRuleTriggerConfigBuilder EdgeConnectionNotificationRuleTriggerConfigBuilder.edges(Set)",
    "EdgeConnectionNotificationRuleTriggerConfigBuilder EdgeConnectionNotificationRuleTriggerConfigBuilder.notifyOn(Set)",
    "String EdgeConnectionNotificationRuleTriggerConfigBuilder.toString()"
  })
  void testEdgeConnectionNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange and Act
    EdgeConnectionNotificationRuleTriggerConfigBuilder actualBuilderResult =
        EdgeConnectionNotificationRuleTriggerConfig.builder();
    HashSet<UUID> edges = new HashSet<>();
    EdgeConnectionNotificationRuleTriggerConfigBuilder actualEdgesResult =
        actualBuilderResult.edges(edges);
    HashSet<EdgeConnectivityEvent> notifyOn = new HashSet<>();
    EdgeConnectionNotificationRuleTriggerConfig actualEdgeConnectionNotificationRuleTriggerConfig =
        actualEdgesResult.notifyOn(notifyOn).build();

    // Assert
    assertEquals("#", actualEdgeConnectionNotificationRuleTriggerConfig.getDeduplicationKey());
    assertEquals(
        NotificationRuleTriggerType.EDGE_CONNECTION,
        actualEdgeConnectionNotificationRuleTriggerConfig.getTriggerType());
    Set<UUID> edges2 = actualEdgeConnectionNotificationRuleTriggerConfig.getEdges();
    assertTrue(edges2.isEmpty());
    Set<EdgeConnectivityEvent> notifyOn2 =
        actualEdgeConnectionNotificationRuleTriggerConfig.getNotifyOn();
    assertTrue(notifyOn2.isEmpty());
    assertSame(edges, edges2);
    assertSame(notifyOn, notifyOn2);
  }

  /**
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EdgeConnectionNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeConnectionNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeConnectionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult =
        EdgeConnectionNotificationRuleTriggerConfig.builder();

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult =
        builderResult.edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig edgeConnectionNotificationRuleTriggerConfig =
        edgesResult.notifyOn(new HashSet<>()).build();

    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult2 =
        EdgeConnectionNotificationRuleTriggerConfig.builder();

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult2 =
        builderResult2.edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig edgeConnectionNotificationRuleTriggerConfig2 =
        edgesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        edgeConnectionNotificationRuleTriggerConfig, edgeConnectionNotificationRuleTriggerConfig2);
    assertEquals(
        edgeConnectionNotificationRuleTriggerConfig.hashCode(),
        edgeConnectionNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EdgeConnectionNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeConnectionNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeConnectionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfigBuilder
        edgeConnectionNotificationRuleTriggerConfigBuilder =
            mock(EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult =
        edgeConnectionNotificationRuleTriggerConfigBuilder.edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig edgeConnectionNotificationRuleTriggerConfig =
        edgesResult.notifyOn(new HashSet<>()).build();

    EdgeConnectionNotificationRuleTriggerConfigBuilder
        edgeConnectionNotificationRuleTriggerConfigBuilder2 =
            mock(EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder2.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult2 =
        edgeConnectionNotificationRuleTriggerConfigBuilder2.edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig edgeConnectionNotificationRuleTriggerConfig2 =
        edgesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        edgeConnectionNotificationRuleTriggerConfig, edgeConnectionNotificationRuleTriggerConfig2);
    assertEquals(
        edgeConnectionNotificationRuleTriggerConfig.hashCode(),
        edgeConnectionNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EdgeConnectionNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeConnectionNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeConnectionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfigBuilder
        edgeConnectionNotificationRuleTriggerConfigBuilder =
            mock(EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder.notifyOn(
            Mockito.<Set<EdgeConnectivityEvent>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());

    EdgeConnectionNotificationRuleTriggerConfigBuilder
        edgeConnectionNotificationRuleTriggerConfigBuilder2 =
            mock(EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder2.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(edgeConnectionNotificationRuleTriggerConfigBuilder);

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult =
        edgeConnectionNotificationRuleTriggerConfigBuilder2.edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig edgeConnectionNotificationRuleTriggerConfig =
        edgesResult.notifyOn(new HashSet<>()).build();

    EdgeConnectionNotificationRuleTriggerConfigBuilder
        edgeConnectionNotificationRuleTriggerConfigBuilder3 =
            mock(EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder3.notifyOn(
            Mockito.<Set<EdgeConnectivityEvent>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());

    EdgeConnectionNotificationRuleTriggerConfigBuilder
        edgeConnectionNotificationRuleTriggerConfigBuilder4 =
            mock(EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder4.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(edgeConnectionNotificationRuleTriggerConfigBuilder3);

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult2 =
        edgeConnectionNotificationRuleTriggerConfigBuilder4.edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig edgeConnectionNotificationRuleTriggerConfig2 =
        edgesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        edgeConnectionNotificationRuleTriggerConfig, edgeConnectionNotificationRuleTriggerConfig2);
    assertEquals(
        edgeConnectionNotificationRuleTriggerConfig.hashCode(),
        edgeConnectionNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EdgeConnectionNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeConnectionNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeConnectionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult =
        EdgeConnectionNotificationRuleTriggerConfig.builder();

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult =
        builderResult.edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig edgeConnectionNotificationRuleTriggerConfig =
        edgesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        edgeConnectionNotificationRuleTriggerConfig, edgeConnectionNotificationRuleTriggerConfig);
    int expectedHashCodeResult = edgeConnectionNotificationRuleTriggerConfig.hashCode();
    assertEquals(expectedHashCodeResult, edgeConnectionNotificationRuleTriggerConfig.hashCode());
  }

  /**
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeConnectionNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeConnectionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<UUID> edges = new HashSet<>();
    edges.add(EntityId.NULL_UUID);

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult =
        EdgeConnectionNotificationRuleTriggerConfig.builder().edges(edges);
    EdgeConnectionNotificationRuleTriggerConfig edgeConnectionNotificationRuleTriggerConfig =
        edgesResult.notifyOn(new HashSet<>()).build();

    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult =
        EdgeConnectionNotificationRuleTriggerConfig.builder();

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult2 =
        builderResult.edges(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        edgeConnectionNotificationRuleTriggerConfig,
        edgesResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeConnectionNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeConnectionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<EdgeConnectivityEvent> notifyOn = new HashSet<>();
    notifyOn.add(EdgeConnectivityEvent.CONNECTED);

    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult =
        EdgeConnectionNotificationRuleTriggerConfig.builder();
    EdgeConnectionNotificationRuleTriggerConfig edgeConnectionNotificationRuleTriggerConfig =
        builderResult.edges(new HashSet<>()).notifyOn(notifyOn).build();

    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult2 =
        EdgeConnectionNotificationRuleTriggerConfig.builder();

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult =
        builderResult2.edges(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        edgeConnectionNotificationRuleTriggerConfig, edgesResult.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeConnectionNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeConnectionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfigBuilder
        edgeConnectionNotificationRuleTriggerConfigBuilder =
            mock(EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult =
        edgeConnectionNotificationRuleTriggerConfigBuilder.edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig edgeConnectionNotificationRuleTriggerConfig =
        edgesResult.notifyOn(new HashSet<>()).build();

    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult =
        EdgeConnectionNotificationRuleTriggerConfig.builder();

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult2 =
        builderResult.edges(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        edgeConnectionNotificationRuleTriggerConfig,
        edgesResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeConnectionNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeConnectionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfigBuilder
        edgeConnectionNotificationRuleTriggerConfigBuilder =
            mock(EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder.notifyOn(
            Mockito.<Set<EdgeConnectivityEvent>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());

    EdgeConnectionNotificationRuleTriggerConfigBuilder
        edgeConnectionNotificationRuleTriggerConfigBuilder2 =
            mock(EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder2.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(edgeConnectionNotificationRuleTriggerConfigBuilder);

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult =
        edgeConnectionNotificationRuleTriggerConfigBuilder2.edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig edgeConnectionNotificationRuleTriggerConfig =
        edgesResult.notifyOn(new HashSet<>()).build();

    EdgeConnectionNotificationRuleTriggerConfigBuilder
        edgeConnectionNotificationRuleTriggerConfigBuilder3 =
            mock(EdgeConnectionNotificationRuleTriggerConfigBuilder.class);
    when(edgeConnectionNotificationRuleTriggerConfigBuilder3.edges(Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeConnectionNotificationRuleTriggerConfig.builder());

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult2 =
        edgeConnectionNotificationRuleTriggerConfigBuilder3.edges(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        edgeConnectionNotificationRuleTriggerConfig,
        edgesResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeConnectionNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeConnectionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult =
        EdgeConnectionNotificationRuleTriggerConfig.builder();

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult =
        builderResult.edges(new HashSet<>());

    // Act and Assert
    assertNotEquals(edgesResult.notifyOn(new HashSet<>()).build(), null);
  }

  /**
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeConnectionNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeConnectionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult =
        EdgeConnectionNotificationRuleTriggerConfig.builder();

    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult =
        builderResult.edges(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        edgesResult.notifyOn(new HashSet<>()).build(),
        "Different type to EdgeConnectionNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       EdgeConnectionNotificationRuleTriggerConfig#EdgeConnectionNotificationRuleTriggerConfig()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#setEdges(Set)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getEdges()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeConnectionNotificationRuleTriggerConfig.<init>()",
    "void EdgeConnectionNotificationRuleTriggerConfig.<init>(Set, Set)",
    "Set EdgeConnectionNotificationRuleTriggerConfig.getEdges()",
    "Set EdgeConnectionNotificationRuleTriggerConfig.getNotifyOn()",
    "NotificationRuleTriggerType EdgeConnectionNotificationRuleTriggerConfig.getTriggerType()",
    "void EdgeConnectionNotificationRuleTriggerConfig.setEdges(Set)",
    "void EdgeConnectionNotificationRuleTriggerConfig.setNotifyOn(Set)",
    "String EdgeConnectionNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeConnectionNotificationRuleTriggerConfig actualEdgeConnectionNotificationRuleTriggerConfig =
        new EdgeConnectionNotificationRuleTriggerConfig();
    HashSet<UUID> edges = new HashSet<>();
    actualEdgeConnectionNotificationRuleTriggerConfig.setEdges(edges);
    HashSet<EdgeConnectivityEvent> notifyOn = new HashSet<>();
    actualEdgeConnectionNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualEdgeConnectionNotificationRuleTriggerConfig.toString();
    Set<UUID> actualEdges = actualEdgeConnectionNotificationRuleTriggerConfig.getEdges();
    Set<EdgeConnectivityEvent> actualNotifyOn =
        actualEdgeConnectionNotificationRuleTriggerConfig.getNotifyOn();

    // Assert
    assertEquals(
        "EdgeConnectionNotificationRuleTriggerConfig(edges=[], notifyOn=[])", actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.EDGE_CONNECTION,
        actualEdgeConnectionNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(edges, actualEdges);
    assertSame(notifyOn, actualNotifyOn);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       EdgeConnectionNotificationRuleTriggerConfig#EdgeConnectionNotificationRuleTriggerConfig(Set,
   *       Set)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#setEdges(Set)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getEdges()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeConnectionNotificationRuleTriggerConfig.<init>()",
    "void EdgeConnectionNotificationRuleTriggerConfig.<init>(Set, Set)",
    "Set EdgeConnectionNotificationRuleTriggerConfig.getEdges()",
    "Set EdgeConnectionNotificationRuleTriggerConfig.getNotifyOn()",
    "NotificationRuleTriggerType EdgeConnectionNotificationRuleTriggerConfig.getTriggerType()",
    "void EdgeConnectionNotificationRuleTriggerConfig.setEdges(Set)",
    "void EdgeConnectionNotificationRuleTriggerConfig.setNotifyOn(Set)",
    "String EdgeConnectionNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters_whenHashSet() {
    // Arrange
    HashSet<UUID> edges = new HashSet<>();

    // Act
    EdgeConnectionNotificationRuleTriggerConfig actualEdgeConnectionNotificationRuleTriggerConfig =
        new EdgeConnectionNotificationRuleTriggerConfig(edges, new HashSet<>());
    HashSet<UUID> edges2 = new HashSet<>();
    actualEdgeConnectionNotificationRuleTriggerConfig.setEdges(edges2);
    HashSet<EdgeConnectivityEvent> notifyOn = new HashSet<>();
    actualEdgeConnectionNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualEdgeConnectionNotificationRuleTriggerConfig.toString();
    Set<UUID> actualEdges = actualEdgeConnectionNotificationRuleTriggerConfig.getEdges();
    Set<EdgeConnectivityEvent> actualNotifyOn =
        actualEdgeConnectionNotificationRuleTriggerConfig.getNotifyOn();

    // Assert
    assertEquals(
        "EdgeConnectionNotificationRuleTriggerConfig(edges=[], notifyOn=[])", actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.EDGE_CONNECTION,
        actualEdgeConnectionNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(edges2, actualEdges);
    assertSame(notifyOn, actualNotifyOn);
  }
}
