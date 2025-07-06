package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.rpc.Rpc;
import org.thingsboard.server.common.data.rpc.RpcStatus;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class RpcEntityDiffblueTest {
  /**
   * Test {@link RpcEntity#equals(Object)}, and {@link RpcEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcEntity#equals(Object)}
   *   <li>{@link RpcEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(rpcEntity, rpcEntity2);
    int expectedHashCodeResult = rpcEntity.hashCode();
    assertEquals(expectedHashCodeResult, rpcEntity2.hashCode());
  }

  /**
   * Test {@link RpcEntity#equals(Object)}, and {@link RpcEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcEntity#equals(Object)}
   *   <li>{@link RpcEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(null);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(null);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(rpcEntity, rpcEntity2);
    int expectedHashCodeResult = rpcEntity.hashCode();
    assertEquals(expectedHashCodeResult, rpcEntity2.hashCode());
  }

  /**
   * Test {@link RpcEntity#equals(Object)}, and {@link RpcEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcEntity#equals(Object)}
   *   <li>{@link RpcEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(rpcEntity, rpcEntity);
    int expectedHashCodeResult = rpcEntity.hashCode();
    assertEquals(expectedHashCodeResult, rpcEntity.hashCode());
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(null);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(3L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(null);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(3L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(DoubleNode.valueOf(10.0d));
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(null);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(DoubleNode.valueOf(10.0d));
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(null);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(null);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.SENT);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(null);
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RpcEntity rpcEntity2 = new RpcEntity();
    rpcEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setCreatedTime(1L);
    rpcEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setExpirationTime(1L);
    rpcEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity2.setStatus(RpcStatus.QUEUED);
    rpcEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, rpcEntity2);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, null);
  }

  /**
   * Test {@link RpcEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcEntity.equals(Object)", "int RpcEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    rpcEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(rpcEntity, "Different type to RpcEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RpcEntity.<init>()",
    "JsonNode RpcEntity.getAdditionalInfo()",
    "UUID RpcEntity.getDeviceId()",
    "long RpcEntity.getExpirationTime()",
    "JsonNode RpcEntity.getRequest()",
    "JsonNode RpcEntity.getResponse()",
    "RpcStatus RpcEntity.getStatus()",
    "UUID RpcEntity.getTenantId()",
    "void RpcEntity.setAdditionalInfo(JsonNode)",
    "void RpcEntity.setDeviceId(UUID)",
    "void RpcEntity.setExpirationTime(long)",
    "void RpcEntity.setRequest(JsonNode)",
    "void RpcEntity.setResponse(JsonNode)",
    "void RpcEntity.setStatus(RpcStatus)",
    "void RpcEntity.setTenantId(UUID)",
    "String RpcEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RpcEntity actualRpcEntity = new RpcEntity();
    actualRpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRpcEntity.setDeviceId(deviceId);
    actualRpcEntity.setExpirationTime(1L);
    actualRpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode response = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualRpcEntity.setResponse(response);
    actualRpcEntity.setStatus(RpcStatus.QUEUED);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRpcEntity.setTenantId(tenantId);
    String actualToStringResult = actualRpcEntity.toString();
    JsonNode actualAdditionalInfo = actualRpcEntity.getAdditionalInfo();
    UUID actualDeviceId = actualRpcEntity.getDeviceId();
    long actualExpirationTime = actualRpcEntity.getExpirationTime();
    JsonNode actualRequest = actualRpcEntity.getRequest();
    JsonNode actualResponse = actualRpcEntity.getResponse();
    RpcStatus actualStatus = actualRpcEntity.getStatus();
    UUID actualTenantId = actualRpcEntity.getTenantId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDeviceId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals(
        "RpcEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, deviceId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " expirationTime=1, request={\"isPublic\":true}, response={\"isPublic\":true}, status=QUEUED, additionalInfo"
            + "={\"isPublic\":true})",
        actualToStringResult);
    assertNull(actualRpcEntity.getId());
    assertNull(actualRpcEntity.getUuid());
    assertEquals(0L, actualRpcEntity.getCreatedTime());
    assertEquals(1L, actualExpirationTime);
    assertEquals(RpcStatus.QUEUED, actualStatus);
    assertSame(deviceId, actualDeviceId);
    assertSame(tenantId, actualTenantId);
    assertSame(response, actualAdditionalInfo);
    assertSame(response, actualRequest);
    assertSame(response, actualResponse);
  }

  /**
   * Test {@link RpcEntity#RpcEntity(Rpc)}.
   *
   * <ul>
   *   <li>Then return TenantId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#RpcEntity(Rpc)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcEntity.<init>(Rpc)"})
  public void testNewRpcEntity_thenReturnTenantIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Rpc rpc = new Rpc();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    rpc.setDeviceId(new DeviceId(id));
    rpc.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    RpcEntity actualRpcEntity = new RpcEntity(rpc);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRpcEntity.getTenantId().toString());
    UUID deviceId = actualRpcEntity.getDeviceId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", deviceId.toString());
    assertNull(actualRpcEntity.getAdditionalInfo());
    assertNull(actualRpcEntity.getRequest());
    assertNull(actualRpcEntity.getResponse());
    assertNull(actualRpcEntity.getId());
    assertNull(actualRpcEntity.getUuid());
    assertNull(actualRpcEntity.getStatus());
    assertEquals(0L, actualRpcEntity.getCreatedTime());
    assertEquals(0L, actualRpcEntity.getExpirationTime());
    assertSame(id, deviceId);
  }

  /**
   * Test {@link RpcEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link RpcEntity#RpcEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Rpc RpcEntity.toData()"})
  public void testToData_givenRpcEntity() {
    // Arrange and Act
    Rpc actualToDataResult = new RpcEntity().toData();

    // Assert
    assertNull(actualToDataResult.getAdditionalInfo());
    assertNull(actualToDataResult.getRequest());
    assertNull(actualToDataResult.getResponse());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getStatus());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(0L, actualToDataResult.getExpirationTime());
  }

  /**
   * Test {@link RpcEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link RpcEntity#RpcEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link RpcEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Rpc RpcEntity.toData()"})
  public void testToData_givenRpcEntityTenantIdIsRandomUUID() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setTenantId(UUID.randomUUID());

    // Act
    Rpc actualToDataResult = rpcEntity.toData();

    // Assert
    assertNull(actualToDataResult.getAdditionalInfo());
    assertNull(actualToDataResult.getRequest());
    assertNull(actualToDataResult.getResponse());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getStatus());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(0L, actualToDataResult.getExpirationTime());
  }
}
