package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
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
   * Test {@link EdgeEventEntity#equals(Object)}, and
   * {@link EdgeEventEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEventEntity#equals(Object)}
   *   <li>{@link EdgeEventEntity#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = edgeEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEventEntity2.hashCode());
  }

  /**
   * Test {@link EdgeEventEntity#equals(Object)}, and
   * {@link EdgeEventEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEventEntity#equals(Object)}
   *   <li>{@link EdgeEventEntity#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(MissingNode.getInstance());
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(mock(JsonNode.class));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#equals(Object)}
   */
  @Test
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
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("1234", actualEdgeEventUid);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEdgeId.toString());
    assertEquals(
        "EdgeEventEntity(seqId=1, tenantId=13814000-1dd2-11b2-8080-808080808080, edgeId=13814000-1dd2-11b2-8080"
            + "-808080808080, entityId=13814000-1dd2-11b2-8080-808080808080, edgeEventType=DASHBOARD, edgeEventAction=ADDED,"
            + " entityBody={\"isPublic\":true}, edgeEventUid=1234, ts=1)",
        actualToStringResult);
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
   * <p>
   * Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
  public void testNewEdgeEventEntity() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setId(null);
    edgeEvent.setTenantId(null);
    edgeEvent.setEdgeId(null);
    edgeEvent.setEntityId(ModelConstants.NULL_UUID);

    // Act
    EdgeEventEntity actualEdgeEventEntity = new EdgeEventEntity(edgeEvent);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEdgeEventEntity.getEntityId().toString());
    assertNull(actualEdgeEventEntity.getId());
    assertNull(actualEdgeEventEntity.getUuid());
    assertNull(actualEdgeEventEntity.getEdgeId());
    assertNull(actualEdgeEventEntity.getTenantId());
    assertEquals(0L, actualEdgeEventEntity.getCreatedTime());
  }

  /**
   * Test {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}.
   * <p>
   * Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
  public void testNewEdgeEventEntity2() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setId(null);
    edgeEvent.setTenantId(ModelConstants.SYSTEM_TENANT);
    edgeEvent.setEdgeId(null);
    edgeEvent.setEntityId(null);

    // Act
    EdgeEventEntity actualEdgeEventEntity = new EdgeEventEntity(edgeEvent);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEdgeEventEntity.getTenantId().toString());
    assertNull(actualEdgeEventEntity.getId());
    assertNull(actualEdgeEventEntity.getUuid());
    assertNull(actualEdgeEventEntity.getEdgeId());
    assertNull(actualEdgeEventEntity.getEntityId());
    assertEquals(0L, actualEdgeEventEntity.getCreatedTime());
  }

  /**
   * Test {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}.
   * <p>
   * Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
  public void testNewEdgeEventEntity3() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setId(null);
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
   * <ul>
   *   <li>Given {@link EdgeEventId#EdgeEventId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Id is EntityId.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
  public void testNewEdgeEventEntity_givenEdgeEventIdWithIdIsNull_uuid_thenReturnIdIsEntityId() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setId(new EdgeEventId(ModelConstants.NULL_UUID));
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
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#EdgeEventEntity(EdgeEvent)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link EdgeEventEntity#EdgeEventEntity()}.</li>
   *   <li>Then return Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#toData()}
   */
  @Test
  public void testToData_givenEdgeEventEntity_thenReturnBodyIsNull() {
    // Arrange and Act
    EdgeEvent actualToDataResult = (new EdgeEventEntity()).toData();

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
   * <ul>
   *   <li>Then Body iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#toData()}
   */
  @Test
  public void testToData_thenBodyIteratorNextReturnBooleanNode() throws IOException {
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
    JsonNode body = actualToDataResult.getBody();
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(body instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = body.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    assertEquals("1234", actualToDataResult.getUid());
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", body.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(actualToDataResult.getEntityId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, body.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(1L, actualToDataResult.getSeqId());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, body.getNodeType());
    assertEquals(EdgeEventActionType.ADDED, actualToDataResult.getAction());
    assertEquals(EdgeEventType.DASHBOARD, actualToDataResult.getType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(body.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(body.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(body.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(body.isBinary());
    assertFalse(body.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(body.isDouble());
    assertFalse(body.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(body.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(body.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(body.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(body.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(body.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(body.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(body.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(body.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(body.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(body.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(body.isTextual());
    assertFalse(body.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(body.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(body.isObject());
    assertTrue(nextResult.isValueNode());
    EdgeId edgeId = actualToDataResult.getEdgeId();
    assertTrue(edgeId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, edgeId.getId());
    assertSame(uuidId, actualToDataResult.getId().getId());
  }

  /**
   * Test {@link EdgeEventEntity#toData()}.
   * <ul>
   *   <li>Then return EntityId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventEntity#toData()}
   */
  @Test
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
