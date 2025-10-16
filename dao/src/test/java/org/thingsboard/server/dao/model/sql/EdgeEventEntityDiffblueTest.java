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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.EdgeEventId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class EdgeEventEntityDiffblueTest {
  /**
   * Test {@link EdgeEventEntity#equals(Object)}, and {@link EdgeEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEventEntity#equals(Object)}
   *   <li>{@link EdgeEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(edgeEventEntity, edgeEventEntity2);
    assertEquals(edgeEventEntity.hashCode(), edgeEventEntity2.hashCode());
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}, and {@link EdgeEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEventEntity#equals(Object)}
   *   <li>{@link EdgeEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(null);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(null);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(edgeEventEntity, edgeEventEntity2);
    assertEquals(edgeEventEntity.hashCode(), edgeEventEntity2.hashCode());
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}, and {@link EdgeEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEventEntity#equals(Object)}
   *   <li>{@link EdgeEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(null);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(null);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(edgeEventEntity, edgeEventEntity2);
    assertEquals(edgeEventEntity.hashCode(), edgeEventEntity2.hashCode());
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}, and {@link EdgeEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEventEntity#equals(Object)}
   *   <li>{@link EdgeEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid(null);
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid(null);
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(edgeEventEntity, edgeEventEntity2);
    assertEquals(edgeEventEntity.hashCode(), edgeEventEntity2.hashCode());
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}, and {@link EdgeEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEventEntity#equals(Object)}
   *   <li>{@link EdgeEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(edgeEventEntity, edgeEventEntity);
    int expectedHashCodeResult = edgeEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEventEntity.hashCode());
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(3L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(null);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.UPDATED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(null);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.ASSET);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("Edge Event Uid");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid(null);
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(UUID.randomUUID());
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(null);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(DoubleNode.valueOf(10.0d));
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(null);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(UUID.randomUUID());
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(null);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(2L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(UUID.randomUUID());
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(null);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(3L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(1L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity2.setEdgeEventUid("1234");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(1L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(1L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, edgeEventEntity2);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, null);
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEventEntity.equals(Object)", "int EdgeEventEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEventEntity, "Different type to EdgeEventEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEventEntity#EdgeEventEntity()}
   *   <li>{@link EdgeEventEntity#setEdgeEventAction(EdgeEventActionType)}
   *   <li>{@link EdgeEventEntity#setEdgeEventType(EdgeEventType)}
   *   <li>{@link EdgeEventEntity#setEdgeEventUid(String)}
   *   <li>{@link EdgeEventEntity#setEdgeId(UUID)}
   *   <li>{@link EdgeEventEntity#setEntityBody(JsonNode)}
   *   <li>{@link EdgeEventEntity#setEntityId(UUID)}
   *   <li>{@link EdgeEventEntity#setSeqId(long)}
   *   <li>{@link EdgeEventEntity#setTenantId(UUID)}
   *   <li>{@link EdgeEventEntity#setTs(long)}
   *   <li>{@link EdgeEventEntity#toString()}
   *   <li>{@link EdgeEventEntity#getEdgeEventAction()}
   *   <li>{@link EdgeEventEntity#getEdgeEventType()}
   *   <li>{@link EdgeEventEntity#getEdgeEventUid()}
   *   <li>{@link EdgeEventEntity#getEdgeId()}
   *   <li>{@link EdgeEventEntity#getEntityBody()}
   *   <li>{@link EdgeEventEntity#getEntityId()}
   *   <li>{@link EdgeEventEntity#getSeqId()}
   *   <li>{@link EdgeEventEntity#getTenantId()}
   *   <li>{@link EdgeEventEntity#getTs()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeEventEntity.<init>()",
    "EdgeEventActionType EdgeEventEntity.getEdgeEventAction()",
    "EdgeEventType EdgeEventEntity.getEdgeEventType()",
    "String EdgeEventEntity.getEdgeEventUid()",
    "UUID EdgeEventEntity.getEdgeId()",
    "JsonNode EdgeEventEntity.getEntityBody()",
    "UUID EdgeEventEntity.getEntityId()",
    "long EdgeEventEntity.getSeqId()",
    "UUID EdgeEventEntity.getTenantId()",
    "long EdgeEventEntity.getTs()",
    "void EdgeEventEntity.setEdgeEventAction(EdgeEventActionType)",
    "void EdgeEventEntity.setEdgeEventType(EdgeEventType)",
    "void EdgeEventEntity.setEdgeEventUid(String)",
    "void EdgeEventEntity.setEdgeId(UUID)",
    "void EdgeEventEntity.setEntityBody(JsonNode)",
    "void EdgeEventEntity.setEntityId(UUID)",
    "void EdgeEventEntity.setSeqId(long)",
    "void EdgeEventEntity.setTenantId(UUID)",
    "void EdgeEventEntity.setTs(long)",
    "String EdgeEventEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EdgeEventEntity actualEdgeEventEntity = new EdgeEventEntity();
    actualEdgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    actualEdgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    actualEdgeEventEntity.setEdgeEventUid("1234");
    actualEdgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    JsonNode entityBody = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualEdgeEventEntity.setEntityBody(entityBody);
    actualEdgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    actualEdgeEventEntity.setSeqId(1L);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualEdgeEventEntity.setTenantId(tenantId);
    actualEdgeEventEntity.setTs(1L);
    String actualToStringResult = actualEdgeEventEntity.toString();
    EdgeEventActionType actualEdgeEventAction = actualEdgeEventEntity.getEdgeEventAction();
    EdgeEventType actualEdgeEventType = actualEdgeEventEntity.getEdgeEventType();
    String actualEdgeEventUid = actualEdgeEventEntity.getEdgeEventUid();
    UUID actualEdgeId = actualEdgeEventEntity.getEdgeId();
    JsonNode actualEntityBody = actualEdgeEventEntity.getEntityBody();
    UUID actualEntityId = actualEdgeEventEntity.getEntityId();
    long actualSeqId = actualEdgeEventEntity.getSeqId();
    UUID actualTenantId = actualEdgeEventEntity.getTenantId();
    long actualTs = actualEdgeEventEntity.getTs();

    // Assert
    assertEquals("1234", actualEdgeEventUid);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEdgeId.toString());
    assertEquals(
        "EdgeEventEntity(seqId=1, tenantId=13814000-1dd2-11b2-8080-808080808080, edgeId=13814000-1dd2-11b2-8080"
            + "-808080808080, entityId=13814000-1dd2-11b2-8080-808080808080, edgeEventType=DASHBOARD, edgeEventAction=ADDED,"
            + " entityBody={\"isPublic\":true}, edgeEventUid=1234, ts=1)",
        actualToStringResult);
    assertNull(actualEdgeEventEntity.getId());
    assertNull(actualEdgeEventEntity.getUuid());
    assertEquals(0L, actualEdgeEventEntity.getCreatedTime());
    assertEquals(1L, actualSeqId);
    assertEquals(1L, actualTs);
    assertEquals(EdgeEventActionType.ADDED, actualEdgeEventAction);
    assertEquals(EdgeEventType.DASHBOARD, actualEdgeEventType);
    assertSame(entityBody, actualEntityBody);
    assertSame(tenantId, actualEdgeId);
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}.
   *
   * <p>Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventEntity.<init>(EdgeEvent)"})
  public void testNewEdgeEventEntity() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent(null);
    edgeEvent.setTenantId(null);
    edgeEvent.setEdgeId(null);
    edgeEvent.setEntityId(ModelConstants.NULL_UUID);

    // Act
    EdgeEventEntity actualEdgeEventEntity = new EdgeEventEntity(edgeEvent);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualEdgeEventEntity.getEntityId().toString());
    assertNull(actualEdgeEventEntity.getId());
    assertNull(actualEdgeEventEntity.getUuid());
    assertNull(actualEdgeEventEntity.getEdgeId());
    assertNull(actualEdgeEventEntity.getTenantId());
    assertEquals(0L, actualEdgeEventEntity.getCreatedTime());
  }

  /**
   * Test {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}.
   *
   * <p>Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventEntity.<init>(EdgeEvent)"})
  public void testNewEdgeEventEntity2() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent(null);
    edgeEvent.setTenantId(ModelConstants.SYSTEM_TENANT);
    edgeEvent.setEdgeId(null);
    edgeEvent.setEntityId(null);

    // Act
    EdgeEventEntity actualEdgeEventEntity = new EdgeEventEntity(edgeEvent);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualEdgeEventEntity.getTenantId().toString());
    assertNull(actualEdgeEventEntity.getId());
    assertNull(actualEdgeEventEntity.getUuid());
    assertNull(actualEdgeEventEntity.getEdgeId());
    assertNull(actualEdgeEventEntity.getEntityId());
    assertEquals(0L, actualEdgeEventEntity.getCreatedTime());
  }

  /**
   * Test {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}.
   *
   * <p>Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventEntity.<init>(EdgeEvent)"})
  public void testNewEdgeEventEntity3() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent(null);
    edgeEvent.setTenantId(null);
    edgeEvent.setEdgeId(new EdgeId(ModelConstants.NULL_UUID));
    edgeEvent.setEntityId(ModelConstants.NULL_UUID);

    // Act
    EdgeEventEntity actualEdgeEventEntity = new EdgeEventEntity(edgeEvent);

    // Assert
    UUID edgeId = actualEdgeEventEntity.getEdgeId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", edgeId.toString());
    assertNull(actualEdgeEventEntity.getId());
    assertNull(actualEdgeEventEntity.getUuid());
    assertNull(actualEdgeEventEntity.getTenantId());
    assertEquals(0L, actualEdgeEventEntity.getCreatedTime());
    assertSame(edgeId, actualEdgeEventEntity.getEntityId());
  }

  /**
   * Test {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventEntity.<init>(EdgeEvent)"})
  public void testNewEdgeEventEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setCreatedTime(1L);

    // Act
    EdgeEventEntity actualEdgeEventEntity = new EdgeEventEntity(edgeEvent);

    // Assert
    assertNull(actualEdgeEventEntity.getId());
    assertNull(actualEdgeEventEntity.getUuid());
    assertNull(actualEdgeEventEntity.getEdgeId());
    assertNull(actualEdgeEventEntity.getEntityId());
    assertNull(actualEdgeEventEntity.getTenantId());
    assertEquals(1L, actualEdgeEventEntity.getCreatedTime());
  }

  /**
   * Test {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}.
   *
   * <ul>
   *   <li>When {@link EdgeEventId#EdgeEventId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Id is EntityId.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventEntity.<init>(EdgeEvent)"})
  public void testNewEdgeEventEntity_whenEdgeEventIdWithIdIsNull_uuid_thenReturnIdIsEntityId() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent(new EdgeEventId(ModelConstants.NULL_UUID));
    edgeEvent.setTenantId(null);
    edgeEvent.setEdgeId(null);
    edgeEvent.setEntityId(ModelConstants.NULL_UUID);

    // Act
    EdgeEventEntity actualEdgeEventEntity = new EdgeEventEntity(edgeEvent);

    // Assert
    UUID entityId = actualEdgeEventEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertNull(actualEdgeEventEntity.getEdgeId());
    assertNull(actualEdgeEventEntity.getTenantId());
    assertEquals(0L, actualEdgeEventEntity.getCreatedTime());
    assertSame(entityId, actualEdgeEventEntity.getId());
    assertSame(entityId, actualEdgeEventEntity.getUuid());
  }

  /**
   * Test {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}.
   *
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventEntity.<init>(EdgeEvent)"})
  public void testNewEdgeEventEntity_whenEdgeEvent_thenReturnEntityIdIsNull() {
    // Arrange and Act
    EdgeEventEntity actualEdgeEventEntity = new EdgeEventEntity(new EdgeEvent());

    // Assert
    assertNull(actualEdgeEventEntity.getId());
    assertNull(actualEdgeEventEntity.getUuid());
    assertNull(actualEdgeEventEntity.getEdgeId());
    assertNull(actualEdgeEventEntity.getEntityId());
    assertNull(actualEdgeEventEntity.getTenantId());
    assertEquals(0L, actualEdgeEventEntity.getCreatedTime());
  }

  /**
   * Test {@link EdgeEventEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EdgeEventEntity#EdgeEventEntity()} EntityId is {@code null}.
   *   <li>Then Body return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeEvent EdgeEventEntity.toData()"})
  public void testToData_givenEdgeEventEntityEntityIdIsNull_thenBodyReturnObjectNode() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityId(null);

    // Act
    EdgeEvent actualToDataResult = edgeEventEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getBody() instanceof ObjectNode);
    assertEquals("1234", actualToDataResult.getUid());
    assertNull(actualToDataResult.getEntityId());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(1L, actualToDataResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualToDataResult.getAction());
    assertEquals(EdgeEventType.DASHBOARD, actualToDataResult.getType());
  }

  /**
   * Test {@link EdgeEventEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EdgeEventEntity#EdgeEventEntity()}.
   *   <li>Then return Body is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeEvent EdgeEventEntity.toData()"})
  public void testToData_givenEdgeEventEntity_thenReturnBodyIsNull() {
    // Arrange and Act
    EdgeEvent actualToDataResult = new EdgeEventEntity().toData();

    // Assert
    assertNull(actualToDataResult.getBody());
    assertNull(actualToDataResult.getUid());
    assertNull(actualToDataResult.getUuidId());
    EdgeId edgeId = actualToDataResult.getEdgeId();
    assertNull(edgeId.getId());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertNull(tenantId.getId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getAction());
    assertNull(actualToDataResult.getType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(0L, actualToDataResult.getSeqId());
    assertFalse(edgeId.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link EdgeEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then return EntityId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeEvent EdgeEventEntity.toData()"})
  public void testToData_thenReturnEntityIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act
    EdgeEvent actualToDataResult = edgeEventEntity.toData();

    // Assert
    UUID entityId = actualToDataResult.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertSame(entityId, actualToDataResult.getUuidId());
    assertSame(entityId, actualToDataResult.getEdgeId().getId());
    assertSame(entityId, actualToDataResult.getId().getId());
  }
}
