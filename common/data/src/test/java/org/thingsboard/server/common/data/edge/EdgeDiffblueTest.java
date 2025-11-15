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
package org.thingsboard.server.common.data.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeDiffblueTest {
  /**
   * Test {@link Edge#Edge(Edge)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(Edge)}
   */
  @Test
  @DisplayName("Test new Edge(Edge); when Edge()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(Edge)"})
  void testNewEdge_whenEdge() {
    // Arrange and Act
    Edge actualEdge = new Edge(new Edge());

    // Assert
    assertTrue(actualEdge.getAdditionalInfo() instanceof NullNode);
    assertNull(actualEdge.getVersion());
    assertNull(actualEdge.getLabel());
    assertNull(actualEdge.getName());
    assertNull(actualEdge.getRoutingKey());
    assertNull(actualEdge.getSecret());
    assertNull(actualEdge.getType());
    assertNull(actualEdge.getUuidId());
    assertNull(actualEdge.getCustomerId());
    assertNull(actualEdge.getId());
    assertNull(actualEdge.getRootRuleChainId());
    assertNull(actualEdge.getTenantId());
    assertEquals(0L, actualEdge.getCreatedTime());
  }

  /**
   * Test {@link Edge#Edge(Edge)}.
   * <ul>
   *   <li>When {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(Edge)}
   */
  @Test
  @DisplayName("Test new Edge(Edge); when Edge(Edge) with edge is Edge()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(Edge)"})
  void testNewEdge_whenEdgeWithEdgeIsEdge() {
    // Arrange and Act
    Edge actualEdge = new Edge(new Edge(new Edge()));

    // Assert
    assertTrue(actualEdge.getAdditionalInfo() instanceof NullNode);
    assertNull(actualEdge.getVersion());
    assertNull(actualEdge.getLabel());
    assertNull(actualEdge.getName());
    assertNull(actualEdge.getRoutingKey());
    assertNull(actualEdge.getSecret());
    assertNull(actualEdge.getType());
    assertNull(actualEdge.getUuidId());
    assertNull(actualEdge.getCustomerId());
    assertNull(actualEdge.getId());
    assertNull(actualEdge.getRootRuleChainId());
    assertNull(actualEdge.getTenantId());
    assertEquals(0L, actualEdge.getCreatedTime());
  }

  /**
   * Test {@link Edge#Edge(Edge)}.
   * <ul>
   *   <li>When {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge(Edge)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#Edge(Edge)}
   */
  @Test
  @DisplayName("Test new Edge(Edge); when Edge(Edge) with edge is Edge(Edge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.<init>(Edge)"})
  void testNewEdge_whenEdgeWithEdgeIsEdge2() {
    // Arrange and Act
    Edge actualEdge = new Edge(new Edge(new Edge(new Edge())));

    // Assert
    assertTrue(actualEdge.getAdditionalInfo() instanceof NullNode);
    assertNull(actualEdge.getVersion());
    assertNull(actualEdge.getLabel());
    assertNull(actualEdge.getName());
    assertNull(actualEdge.getRoutingKey());
    assertNull(actualEdge.getSecret());
    assertNull(actualEdge.getType());
    assertNull(actualEdge.getUuidId());
    assertNull(actualEdge.getCustomerId());
    assertNull(actualEdge.getId());
    assertNull(actualEdge.getRootRuleChainId());
    assertNull(actualEdge.getTenantId());
    assertEquals(0L, actualEdge.getCreatedTime());
  }

  /**
   * Test {@link Edge#update(Edge)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link EdgeInfo} {@link Edge#getVersion()} return one.</li>
   *   <li>Then {@link Edge#Edge()} Label is {@code Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#update(Edge)}
   */
  @Test
  @DisplayName("Test update(Edge); given one; when EdgeInfo getVersion() return one; then Edge() Label is 'Label'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Edge.update(Edge)"})
  void testUpdate_givenOne_whenEdgeInfoGetVersionReturnOne_thenEdgeLabelIsLabel() {
    // Arrange
    Edge edge = new Edge();
    EdgeInfo edge2 = mock(EdgeInfo.class);
    when(edge2.getVersion()).thenReturn(1L);
    when(edge2.getLabel()).thenReturn("Label");
    when(edge2.getName()).thenReturn("Name");
    when(edge2.getRoutingKey()).thenReturn("Routing Key");
    when(edge2.getSecret()).thenReturn("Secret");
    when(edge2.getType()).thenReturn("Type");
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    when(edge2.getCustomerId()).thenReturn(customerId);
    RuleChainId ruleChainId = new RuleChainId(EntityId.NULL_UUID);
    when(edge2.getRootRuleChainId()).thenReturn(ruleChainId);
    when(edge2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);

    // Act
    edge.update(edge2);

    // Assert
    verify(edge2).getCustomerId();
    verify(edge2).getLabel();
    verify(edge2).getName();
    verify(edge2).getRootRuleChainId();
    verify(edge2).getRoutingKey();
    verify(edge2).getSecret();
    verify(edge2).getTenantId();
    verify(edge2).getType();
    verify(edge2).getVersion();
    assertEquals("Label", edge.getLabel());
    assertEquals("Name", edge.getName());
    assertEquals("Routing Key", edge.getRoutingKey());
    assertEquals("Secret", edge.getSecret());
    assertEquals("Type", edge.getType());
    assertEquals(1L, edge.getVersion().longValue());
    assertSame(customerId, edge.getCustomerId());
    assertSame(ruleChainId, edge.getRootRuleChainId());
  }

  /**
   * Test {@link Edge#getId()}.
   * <p>
   * Method under test: {@link Edge#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.EdgeId Edge.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getId());
  }

  /**
   * Test {@link Edge#getCreatedTime()}.
   * <p>
   * Method under test: {@link Edge#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Edge.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Edge()).getCreatedTime());
  }

  /**
   * Test {@link Edge#equals(Object)}, and {@link Edge#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Edge#equals(Object)}
   *   <li>{@link Edge#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Edge edge = new Edge();
    Edge edge2 = new Edge();

    // Act and Assert
    assertEquals(edge, edge2);
    int expectedHashCodeResult = edge.hashCode();
    assertEquals(expectedHashCodeResult, edge2.hashCode());
  }

  /**
   * Test {@link Edge#equals(Object)}, and {@link Edge#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Edge#equals(Object)}
   *   <li>{@link Edge#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertEquals(edge, edge);
    int expectedHashCodeResult = edge.hashCode();
    assertEquals(expectedHashCodeResult, edge.hashCode());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeInfo edgeInfo = new EdgeInfo();

    // Act and Assert
    assertNotEquals(edgeInfo, new Edge());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Edge edge = new Edge(new Edge());

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertNotEquals(edge, new EdgeInfo());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Edge edge = new Edge();
    edge.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Edge edge = new Edge();
    edge.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Edge edge = new Edge();
    edge.setRootRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Edge edge = new Edge();
    edge.setName("Name");

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Edge edge = new Edge();
    edge.setType("Type");

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Edge edge = new Edge();
    edge.setLabel("Label");

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Edge edge = new Edge();
    edge.setRoutingKey("Routing Key");

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Edge edge = new Edge();
    edge.setSecret("Secret");

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Edge edge = new Edge();
    edge.setVersion(1L);

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Edge edge = new Edge();

    Edge edge2 = new Edge();
    edge2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(edge, edge2);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    Edge edge = new Edge();

    Edge edge2 = new Edge();
    edge2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(edge, edge2);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    Edge edge = new Edge();

    Edge edge2 = new Edge();
    edge2.setRootRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(edge, edge2);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    Edge edge = new Edge();

    Edge edge2 = new Edge();
    edge2.setName("Name");

    // Act and Assert
    assertNotEquals(edge, edge2);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    Edge edge = new Edge();

    Edge edge2 = new Edge();
    edge2.setType("Type");

    // Act and Assert
    assertNotEquals(edge, edge2);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    Edge edge = new Edge();

    Edge edge2 = new Edge();
    edge2.setLabel("Label");

    // Act and Assert
    assertNotEquals(edge, edge2);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    Edge edge = new Edge();

    Edge edge2 = new Edge();
    edge2.setRoutingKey("Routing Key");

    // Act and Assert
    assertNotEquals(edge, edge2);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    Edge edge = new Edge();

    Edge edge2 = new Edge();
    edge2.setSecret("Secret");

    // Act and Assert
    assertNotEquals(edge, edge2);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    Edge edge = new Edge();

    Edge edge2 = new Edge();
    edge2.setVersion(1L);

    // Act and Assert
    assertNotEquals(edge, edge2);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Edge(), null);
  }

  /**
   * Test {@link Edge#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Edge.equals(Object)", "int Edge.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Edge(), "Different type to Edge");
  }
}
