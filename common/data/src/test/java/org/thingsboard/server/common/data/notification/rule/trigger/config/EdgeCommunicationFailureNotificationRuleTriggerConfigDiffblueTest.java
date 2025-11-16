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
import org.thingsboard.server.common.data.notification.rule.trigger.config.EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder;

@ContextConfiguration(
    classes = {EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class EdgeCommunicationFailureNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder
      edgeCommunicationFailureNotificationRuleTriggerConfigBuilder;

  /**
   * Test EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder {@link
   * EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder#build()}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder#edges(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.<init>()",
    "EdgeCommunicationFailureNotificationRuleTriggerConfig EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.build()",
    "EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.edges(Set)",
    "String EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.toString()"
  })
  void testEdgeCommunicationFailureNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange and Act
    EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder actualBuilderResult =
        EdgeCommunicationFailureNotificationRuleTriggerConfig.builder();
    HashSet<UUID> edges = new HashSet<>();
    EdgeCommunicationFailureNotificationRuleTriggerConfig
        actualEdgeCommunicationFailureNotificationRuleTriggerConfig =
            actualBuilderResult.edges(edges).build();

    // Assert
    assertEquals(
        "#", actualEdgeCommunicationFailureNotificationRuleTriggerConfig.getDeduplicationKey());
    assertEquals(
        NotificationRuleTriggerType.EDGE_COMMUNICATION_FAILURE,
        actualEdgeCommunicationFailureNotificationRuleTriggerConfig.getTriggerType());
    Set<UUID> edges2 = actualEdgeCommunicationFailureNotificationRuleTriggerConfig.getEdges();
    assertTrue(edges2.isEmpty());
    assertSame(edges, edges2);
  }

  /**
   * Test {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EdgeCommunicationFailureNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCommunicationFailureNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeCommunicationFailureNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult =
        EdgeCommunicationFailureNotificationRuleTriggerConfig.builder();
    EdgeCommunicationFailureNotificationRuleTriggerConfig
        edgeCommunicationFailureNotificationRuleTriggerConfig =
            builderResult.edges(new HashSet<>()).build();

    EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult2 =
        EdgeCommunicationFailureNotificationRuleTriggerConfig.builder();
    EdgeCommunicationFailureNotificationRuleTriggerConfig
        edgeCommunicationFailureNotificationRuleTriggerConfig2 =
            builderResult2.edges(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        edgeCommunicationFailureNotificationRuleTriggerConfig,
        edgeCommunicationFailureNotificationRuleTriggerConfig2);
    assertEquals(
        edgeCommunicationFailureNotificationRuleTriggerConfig.hashCode(),
        edgeCommunicationFailureNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EdgeCommunicationFailureNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCommunicationFailureNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeCommunicationFailureNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder
        edgeCommunicationFailureNotificationRuleTriggerConfigBuilder =
            mock(EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.class);
    when(edgeCommunicationFailureNotificationRuleTriggerConfigBuilder.edges(
            Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeCommunicationFailureNotificationRuleTriggerConfig.builder());
    EdgeCommunicationFailureNotificationRuleTriggerConfig
        edgeCommunicationFailureNotificationRuleTriggerConfig =
            edgeCommunicationFailureNotificationRuleTriggerConfigBuilder
                .edges(new HashSet<>())
                .build();

    EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder
        edgeCommunicationFailureNotificationRuleTriggerConfigBuilder2 =
            mock(EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.class);
    when(edgeCommunicationFailureNotificationRuleTriggerConfigBuilder2.edges(
            Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeCommunicationFailureNotificationRuleTriggerConfig.builder());
    EdgeCommunicationFailureNotificationRuleTriggerConfig
        edgeCommunicationFailureNotificationRuleTriggerConfig2 =
            edgeCommunicationFailureNotificationRuleTriggerConfigBuilder2
                .edges(new HashSet<>())
                .build();

    // Act and Assert
    assertEquals(
        edgeCommunicationFailureNotificationRuleTriggerConfig,
        edgeCommunicationFailureNotificationRuleTriggerConfig2);
    assertEquals(
        edgeCommunicationFailureNotificationRuleTriggerConfig.hashCode(),
        edgeCommunicationFailureNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EdgeCommunicationFailureNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCommunicationFailureNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeCommunicationFailureNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult =
        EdgeCommunicationFailureNotificationRuleTriggerConfig.builder();
    EdgeCommunicationFailureNotificationRuleTriggerConfig
        edgeCommunicationFailureNotificationRuleTriggerConfig =
            builderResult.edges(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        edgeCommunicationFailureNotificationRuleTriggerConfig,
        edgeCommunicationFailureNotificationRuleTriggerConfig);
    int expectedHashCodeResult = edgeCommunicationFailureNotificationRuleTriggerConfig.hashCode();
    assertEquals(
        expectedHashCodeResult, edgeCommunicationFailureNotificationRuleTriggerConfig.hashCode());
  }

  /**
   * Test {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCommunicationFailureNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeCommunicationFailureNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<UUID> edges = new HashSet<>();
    edges.add(EntityId.NULL_UUID);
    EdgeCommunicationFailureNotificationRuleTriggerConfig
        edgeCommunicationFailureNotificationRuleTriggerConfig =
            EdgeCommunicationFailureNotificationRuleTriggerConfig.builder().edges(edges).build();

    EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult =
        EdgeCommunicationFailureNotificationRuleTriggerConfig.builder();

    // Act and Assert
    assertNotEquals(
        edgeCommunicationFailureNotificationRuleTriggerConfig,
        builderResult.edges(new HashSet<>()).build());
  }

  /**
   * Test {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCommunicationFailureNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeCommunicationFailureNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder
        edgeCommunicationFailureNotificationRuleTriggerConfigBuilder =
            mock(EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder.class);
    when(edgeCommunicationFailureNotificationRuleTriggerConfigBuilder.edges(
            Mockito.<Set<UUID>>any()))
        .thenReturn(EdgeCommunicationFailureNotificationRuleTriggerConfig.builder());
    EdgeCommunicationFailureNotificationRuleTriggerConfig
        edgeCommunicationFailureNotificationRuleTriggerConfig =
            edgeCommunicationFailureNotificationRuleTriggerConfigBuilder
                .edges(new HashSet<>())
                .build();

    EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult =
        EdgeCommunicationFailureNotificationRuleTriggerConfig.builder();

    // Act and Assert
    assertNotEquals(
        edgeCommunicationFailureNotificationRuleTriggerConfig,
        builderResult.edges(new HashSet<>()).build());
  }

  /**
   * Test {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCommunicationFailureNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeCommunicationFailureNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult =
        EdgeCommunicationFailureNotificationRuleTriggerConfig.builder();

    // Act and Assert
    assertNotEquals(builderResult.edges(new HashSet<>()).build(), null);
  }

  /**
   * Test {@link EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * EdgeCommunicationFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCommunicationFailureNotificationRuleTriggerConfig.equals(Object)",
    "int EdgeCommunicationFailureNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult =
        EdgeCommunicationFailureNotificationRuleTriggerConfig.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.edges(new HashSet<>()).build(),
        "Different type to EdgeCommunicationFailureNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       EdgeCommunicationFailureNotificationRuleTriggerConfig#EdgeCommunicationFailureNotificationRuleTriggerConfig()}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#setEdges(Set)}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#getEdges()}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeCommunicationFailureNotificationRuleTriggerConfig.<init>()",
    "void EdgeCommunicationFailureNotificationRuleTriggerConfig.<init>(Set)",
    "Set EdgeCommunicationFailureNotificationRuleTriggerConfig.getEdges()",
    "NotificationRuleTriggerType EdgeCommunicationFailureNotificationRuleTriggerConfig.getTriggerType()",
    "void EdgeCommunicationFailureNotificationRuleTriggerConfig.setEdges(Set)",
    "String EdgeCommunicationFailureNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeCommunicationFailureNotificationRuleTriggerConfig
        actualEdgeCommunicationFailureNotificationRuleTriggerConfig =
            new EdgeCommunicationFailureNotificationRuleTriggerConfig();
    HashSet<UUID> edges = new HashSet<>();
    actualEdgeCommunicationFailureNotificationRuleTriggerConfig.setEdges(edges);
    String actualToStringResult =
        actualEdgeCommunicationFailureNotificationRuleTriggerConfig.toString();
    Set<UUID> actualEdges = actualEdgeCommunicationFailureNotificationRuleTriggerConfig.getEdges();

    // Assert
    assertEquals(
        "EdgeCommunicationFailureNotificationRuleTriggerConfig(edges=[])", actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.EDGE_COMMUNICATION_FAILURE,
        actualEdgeCommunicationFailureNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEdges.isEmpty());
    assertSame(edges, actualEdges);
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
   *       EdgeCommunicationFailureNotificationRuleTriggerConfig#EdgeCommunicationFailureNotificationRuleTriggerConfig(Set)}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#setEdges(Set)}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#getEdges()}
   *   <li>{@link EdgeCommunicationFailureNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeCommunicationFailureNotificationRuleTriggerConfig.<init>()",
    "void EdgeCommunicationFailureNotificationRuleTriggerConfig.<init>(Set)",
    "Set EdgeCommunicationFailureNotificationRuleTriggerConfig.getEdges()",
    "NotificationRuleTriggerType EdgeCommunicationFailureNotificationRuleTriggerConfig.getTriggerType()",
    "void EdgeCommunicationFailureNotificationRuleTriggerConfig.setEdges(Set)",
    "String EdgeCommunicationFailureNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters_whenHashSet() {
    // Arrange and Act
    EdgeCommunicationFailureNotificationRuleTriggerConfig
        actualEdgeCommunicationFailureNotificationRuleTriggerConfig =
            new EdgeCommunicationFailureNotificationRuleTriggerConfig(new HashSet<>());
    HashSet<UUID> edges = new HashSet<>();
    actualEdgeCommunicationFailureNotificationRuleTriggerConfig.setEdges(edges);
    String actualToStringResult =
        actualEdgeCommunicationFailureNotificationRuleTriggerConfig.toString();
    Set<UUID> actualEdges = actualEdgeCommunicationFailureNotificationRuleTriggerConfig.getEdges();

    // Assert
    assertEquals(
        "EdgeCommunicationFailureNotificationRuleTriggerConfig(edges=[])", actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.EDGE_COMMUNICATION_FAILURE,
        actualEdgeCommunicationFailureNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEdges.isEmpty());
    assertSame(edges, actualEdges);
  }
}
