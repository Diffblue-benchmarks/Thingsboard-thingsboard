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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder;

class EdgeConnectionNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Test EdgeConnectionNotificationRuleTriggerConfigBuilder
   * {@link EdgeConnectionNotificationRuleTriggerConfigBuilder#build()}.
   * <p>
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
  @DisplayName("Test EdgeConnectionNotificationRuleTriggerConfigBuilder build()")
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
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EdgeConnectionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * Test {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeConnectionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when HashSet()")
  void testGettersAndSetters_whenHashSet() {
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
