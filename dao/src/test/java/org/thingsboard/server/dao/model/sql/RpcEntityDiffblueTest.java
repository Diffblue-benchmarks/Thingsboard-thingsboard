package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rpc.Rpc;
import org.thingsboard.server.common.data.rpc.RpcStatus;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class RpcEntityDiffblueTest {
  /**
   * Test {@link RpcEntity#equals(Object)}, and {@link RpcEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcEntity#equals(Object)}
   *   <li>{@link RpcEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(rpcEntity, rpcEntity2);
    int expectedHashCodeResult = rpcEntity.hashCode();
    assertEquals(expectedHashCodeResult, rpcEntity2.hashCode());
  }

  /**
   * Test {@link RpcEntity#equals(Object)}, and {@link RpcEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcEntity#equals(Object)}
   *   <li>{@link RpcEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(null);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(null);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(rpcEntity, rpcEntity2);
    int expectedHashCodeResult = rpcEntity.hashCode();
    assertEquals(expectedHashCodeResult, rpcEntity2.hashCode());
  }

  /**
   * Test {@link RpcEntity#equals(Object)}, and {@link RpcEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcEntity#equals(Object)}
   *   <li>{@link RpcEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(rpcEntity, rpcEntity);
    int expectedHashCodeResult = rpcEntity.hashCode();
    assertEquals(expectedHashCodeResult, rpcEntity.hashCode());
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(MissingNode.getInstance());
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(null);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(mock(JsonNode.class));
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(3L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.randomUUID());
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(null);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(3L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(MissingNode.getInstance());
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(null);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(MissingNode.getInstance());
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(null);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(null);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.SENT);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.randomUUID());
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(null);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(ModelConstants.NULL_UUID);
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, null);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(rpcEntity, "Different type to RpcEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcEntity#RpcEntity()}
   *   <li>{@link RpcEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link RpcEntity#setDeviceId(UUID)}
   *   <li>{@link RpcEntity#setExpirationTime(long)}
   *   <li>{@link RpcEntity#setRequest(JsonNode)}
   *   <li>{@link RpcEntity#setResponse(JsonNode)}
   *   <li>{@link RpcEntity#setStatus(RpcStatus)}
   *   <li>{@link RpcEntity#setTenantId(UUID)}
   *   <li>{@link RpcEntity#toString()}
   *   <li>{@link RpcEntity#getAdditionalInfo()}
   *   <li>{@link RpcEntity#getDeviceId()}
   *   <li>{@link RpcEntity#getExpirationTime()}
   *   <li>{@link RpcEntity#getRequest()}
   *   <li>{@link RpcEntity#getResponse()}
   *   <li>{@link RpcEntity#getStatus()}
   *   <li>{@link RpcEntity#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RpcEntity actualRpcEntity = new RpcEntity();
    actualRpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualRpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    actualRpcEntity.setExpirationTime(1L);
    actualRpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode response = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualRpcEntity.setResponse(response);
    actualRpcEntity.setStatus(RpcStatus.QUEUED);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualRpcEntity.setTenantId(tenantId);
    String actualToStringResult = actualRpcEntity.toString();
    JsonNode actualAdditionalInfo = actualRpcEntity.getAdditionalInfo();
    UUID actualDeviceId = actualRpcEntity.getDeviceId();
    long actualExpirationTime = actualRpcEntity.getExpirationTime();
    JsonNode actualRequest = actualRpcEntity.getRequest();
    JsonNode actualResponse = actualRpcEntity.getResponse();
    RpcStatus actualStatus = actualRpcEntity.getStatus();
    UUID actualTenantId = actualRpcEntity.getTenantId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDeviceId.toString());
    assertEquals(
        "RpcEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, deviceId=13814000-1dd2-11b2-8080-808080808080,"
            + " expirationTime=1, request={\"isPublic\":true}, response={\"isPublic\":true}, status=QUEUED, additionalInfo"
            + "={\"isPublic\":true})",
        actualToStringResult);
    assertEquals(0L, actualRpcEntity.getCreatedTime());
    assertEquals(1L, actualExpirationTime);
    assertEquals(RpcStatus.QUEUED, actualStatus);
    assertSame(response, actualAdditionalInfo);
    assertSame(response, actualRequest);
    assertSame(response, actualResponse);
    assertSame(tenantId, actualDeviceId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link RpcEntity#RpcEntity(Rpc)}.
   * <ul>
   *   <li>Then return DeviceId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#RpcEntity(Rpc)}
   */
  @Test
  public void testNewRpcEntity_thenReturnDeviceIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));
    rpc.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    RpcEntity actualRpcEntity = new RpcEntity(rpc);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRpcEntity.getDeviceId().toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRpcEntity.getTenantId().toString());
    assertNull(actualRpcEntity.getAdditionalInfo());
    assertNull(actualRpcEntity.getRequest());
    assertNull(actualRpcEntity.getResponse());
    assertNull(actualRpcEntity.getId());
    assertNull(actualRpcEntity.getUuid());
    assertNull(actualRpcEntity.getStatus());
    assertEquals(0L, actualRpcEntity.getCreatedTime());
    assertEquals(0L, actualRpcEntity.getExpirationTime());
  }

  /**
   * Test {@link RpcEntity#toData()}.
   * <ul>
   *   <li>Given {@link RpcEntity#RpcEntity()} TenantId is randomUUID.</li>
   *   <li>Then return TenantId Id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#toData()}
   */
  @Test
  public void testToData_givenRpcEntityTenantIdIsRandomUUID_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    UUID tenantId = UUID.randomUUID();
    rpcEntity.setTenantId(tenantId);

    // Act
    Rpc actualToDataResult = rpcEntity.toData();

    // Assert
    assertNull(actualToDataResult.getAdditionalInfo());
    assertNull(actualToDataResult.getRequest());
    assertNull(actualToDataResult.getResponse());
    assertNull(actualToDataResult.getUuidId());
    DeviceId deviceId = actualToDataResult.getDeviceId();
    assertNull(deviceId.getId());
    RpcId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getStatus());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(0L, actualToDataResult.getExpirationTime());
    assertEquals(EntityType.DEVICE, deviceId.getEntityType());
    assertEquals(EntityType.RPC, id.getEntityType());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(deviceId.isNullUid());
    assertFalse(id.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link RpcEntity#toData()}.
   * <ul>
   *   <li>Given {@link RpcEntity#RpcEntity()}.</li>
   *   <li>Then return TenantId Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcEntity#toData()}
   */
  @Test
  public void testToData_givenRpcEntity_thenReturnTenantIdIdIsNull() {
    // Arrange and Act
    Rpc actualToDataResult = (new RpcEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getAdditionalInfo());
    assertNull(actualToDataResult.getRequest());
    assertNull(actualToDataResult.getResponse());
    assertNull(actualToDataResult.getUuidId());
    DeviceId deviceId = actualToDataResult.getDeviceId();
    assertNull(deviceId.getId());
    RpcId id = actualToDataResult.getId();
    assertNull(id.getId());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertNull(tenantId.getId());
    assertNull(actualToDataResult.getStatus());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(0L, actualToDataResult.getExpirationTime());
    assertEquals(EntityType.DEVICE, deviceId.getEntityType());
    assertEquals(EntityType.RPC, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(deviceId.isNullUid());
    assertFalse(id.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
