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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EdgeInfoDiffblueTest {
  /**
   * Test {@link EdgeInfo#EdgeInfo(Edge, String, boolean)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfo#EdgeInfo(Edge, String, boolean)}
   */
  @Test
  @DisplayName("Test new EdgeInfo(Edge, String, boolean); when Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeInfo.<init>(Edge, String, boolean)"})
  void testNewEdgeInfo_whenEdge() {
    // Arrange and Act
    EdgeInfo actualEdgeInfo = new EdgeInfo(new Edge(), "Dr", true);

    // Assert
    assertTrue(actualEdgeInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualEdgeInfo.getCustomerTitle());
    assertNull(actualEdgeInfo.getVersion());
    assertNull(actualEdgeInfo.getLabel());
    assertNull(actualEdgeInfo.getName());
    assertNull(actualEdgeInfo.getRoutingKey());
    assertNull(actualEdgeInfo.getSecret());
    assertNull(actualEdgeInfo.getType());
    assertNull(actualEdgeInfo.getUuidId());
    assertNull(actualEdgeInfo.getCustomerId());
    assertNull(actualEdgeInfo.getId());
    assertNull(actualEdgeInfo.getRootRuleChainId());
    assertNull(actualEdgeInfo.getTenantId());
    assertEquals(0L, actualEdgeInfo.getCreatedTime());
    assertTrue(actualEdgeInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link EdgeInfo#EdgeInfo(Edge, String, boolean)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfo#EdgeInfo(Edge, String, boolean)}
   */
  @Test
  @DisplayName("Test new EdgeInfo(Edge, String, boolean); when Edge(Edge) with edge is Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeInfo.<init>(Edge, String, boolean)"})
  void testNewEdgeInfo_whenEdgeWithEdgeIsEdge() {
    // Arrange and Act
    EdgeInfo actualEdgeInfo = new EdgeInfo(new Edge(new Edge()), "Dr", true);

    // Assert
    assertTrue(actualEdgeInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualEdgeInfo.getCustomerTitle());
    assertNull(actualEdgeInfo.getVersion());
    assertNull(actualEdgeInfo.getLabel());
    assertNull(actualEdgeInfo.getName());
    assertNull(actualEdgeInfo.getRoutingKey());
    assertNull(actualEdgeInfo.getSecret());
    assertNull(actualEdgeInfo.getType());
    assertNull(actualEdgeInfo.getUuidId());
    assertNull(actualEdgeInfo.getCustomerId());
    assertNull(actualEdgeInfo.getId());
    assertNull(actualEdgeInfo.getRootRuleChainId());
    assertNull(actualEdgeInfo.getTenantId());
    assertEquals(0L, actualEdgeInfo.getCreatedTime());
    assertTrue(actualEdgeInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link EdgeInfo#EdgeInfo(Edge, String, boolean)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge(Edge)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfo#EdgeInfo(Edge, String, boolean)}
   */
  @Test
  @DisplayName("Test new EdgeInfo(Edge, String, boolean); when Edge(Edge) with edge is Edge(Edge)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeInfo.<init>(Edge, String, boolean)"})
  void testNewEdgeInfo_whenEdgeWithEdgeIsEdge2() {
    // Arrange
    Edge edge = new Edge(new Edge(new Edge()));

    // Act
    EdgeInfo actualEdgeInfo = new EdgeInfo(edge, "Dr", true);

    // Assert
    assertTrue(actualEdgeInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualEdgeInfo.getCustomerTitle());
    assertNull(actualEdgeInfo.getVersion());
    assertNull(actualEdgeInfo.getLabel());
    assertNull(actualEdgeInfo.getName());
    assertNull(actualEdgeInfo.getRoutingKey());
    assertNull(actualEdgeInfo.getSecret());
    assertNull(actualEdgeInfo.getType());
    assertNull(actualEdgeInfo.getUuidId());
    assertNull(actualEdgeInfo.getCustomerId());
    assertNull(actualEdgeInfo.getId());
    assertNull(actualEdgeInfo.getRootRuleChainId());
    assertNull(actualEdgeInfo.getTenantId());
    assertEquals(0L, actualEdgeInfo.getCreatedTime());
    assertTrue(actualEdgeInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link EdgeInfo#equals(Object)}, and {@link EdgeInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeInfo#equals(Object)}
   *   <li>{@link EdgeInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfo.equals(Object)", "int EdgeInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeInfo edgeInfo = new EdgeInfo();
    EdgeInfo edgeInfo2 = new EdgeInfo();

    // Act and Assert
    assertEquals(edgeInfo, edgeInfo2);
    assertEquals(edgeInfo.hashCode(), edgeInfo2.hashCode());
  }

  /**
   * Test {@link EdgeInfo#equals(Object)}, and {@link EdgeInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeInfo#equals(Object)}
   *   <li>{@link EdgeInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfo.equals(Object)", "int EdgeInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeInfo edgeInfo = new EdgeInfo(new Edge(), "Dr", true);
    EdgeInfo edgeInfo2 = new EdgeInfo(new Edge(), "Dr", true);

    // Act and Assert
    assertEquals(edgeInfo, edgeInfo2);
    assertEquals(edgeInfo.hashCode(), edgeInfo2.hashCode());
  }

  /**
   * Test {@link EdgeInfo#equals(Object)}, and {@link EdgeInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeInfo#equals(Object)}
   *   <li>{@link EdgeInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfo.equals(Object)", "int EdgeInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeInfo edgeInfo = new EdgeInfo();

    // Act and Assert
    assertEquals(edgeInfo, edgeInfo);
    int expectedHashCodeResult = edgeInfo.hashCode();
    assertEquals(expectedHashCodeResult, edgeInfo.hashCode());
  }

  /**
   * Test {@link EdgeInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfo.equals(Object)", "int EdgeInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeInfo edgeInfo = new EdgeInfo(new Edge(), "Dr", true);

    // Act and Assert
    assertNotEquals(edgeInfo, new EdgeInfo());
  }

  /**
   * Test {@link EdgeInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfo.equals(Object)", "int EdgeInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeInfo edgeInfo = new EdgeInfo();
    edgeInfo.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(edgeInfo, new EdgeInfo());
  }

  /**
   * Test {@link EdgeInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfo.equals(Object)", "int EdgeInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeInfo edgeInfo = new EdgeInfo();

    EdgeInfo edgeInfo2 = new EdgeInfo();
    edgeInfo2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(edgeInfo, edgeInfo2);
  }

  /**
   * Test {@link EdgeInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfo.equals(Object)", "int EdgeInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInfo(), null);
  }

  /**
   * Test {@link EdgeInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfo.equals(Object)", "int EdgeInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInfo(), "Different type to EdgeInfo");
  }
}
