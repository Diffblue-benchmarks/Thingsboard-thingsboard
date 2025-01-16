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
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.AndroidConfig;
import org.thingsboard.server.common.data.mobile.MobileAppSettings;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class MobileAppSettingsEntityDiffblueTest {
  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}, and
   * {@link MobileAppSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppSettingsEntity#equals(Object)}
   *   <li>{@link MobileAppSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
    int expectedHashCodeResult = mobileAppSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppSettingsEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}, and
   * {@link MobileAppSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppSettingsEntity#equals(Object)}
   *   <li>{@link MobileAppSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(null);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(null);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
    int expectedHashCodeResult = mobileAppSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppSettingsEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}, and
   * {@link MobileAppSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppSettingsEntity#equals(Object)}
   *   <li>{@link MobileAppSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppSettingsEntity, mobileAppSettingsEntity);
    int expectedHashCodeResult = mobileAppSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppSettingsEntity.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(MissingNode.getInstance());
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(null);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(mock(JsonNode.class));
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(3L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(MissingNode.getInstance());
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(null);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(MissingNode.getInstance());
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(null);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.randomUUID());
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(null);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(false);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, null);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, "Different type to MobileAppSettingsEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppSettingsEntity#MobileAppSettingsEntity()}
   *   <li>{@link MobileAppSettingsEntity#setAndroidConfig(JsonNode)}
   *   <li>{@link MobileAppSettingsEntity#setIosConfig(JsonNode)}
   *   <li>{@link MobileAppSettingsEntity#setQrCodeConfig(JsonNode)}
   *   <li>{@link MobileAppSettingsEntity#setTenantId(UUID)}
   *   <li>{@link MobileAppSettingsEntity#setUseDefaultApp(boolean)}
   *   <li>{@link MobileAppSettingsEntity#toString()}
   *   <li>{@link MobileAppSettingsEntity#getAndroidConfig()}
   *   <li>{@link MobileAppSettingsEntity#getIosConfig()}
   *   <li>{@link MobileAppSettingsEntity#getQrCodeConfig()}
   *   <li>{@link MobileAppSettingsEntity#getTenantId()}
   *   <li>{@link MobileAppSettingsEntity#isUseDefaultApp()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MobileAppSettingsEntity actualMobileAppSettingsEntity = new MobileAppSettingsEntity();
    actualMobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualMobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode qrCodeConfig = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualMobileAppSettingsEntity.setQrCodeConfig(qrCodeConfig);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualMobileAppSettingsEntity.setTenantId(tenantId);
    actualMobileAppSettingsEntity.setUseDefaultApp(true);
    String actualToStringResult = actualMobileAppSettingsEntity.toString();
    JsonNode actualAndroidConfig = actualMobileAppSettingsEntity.getAndroidConfig();
    JsonNode actualIosConfig = actualMobileAppSettingsEntity.getIosConfig();
    JsonNode actualQrCodeConfig = actualMobileAppSettingsEntity.getQrCodeConfig();
    UUID actualTenantId = actualMobileAppSettingsEntity.getTenantId();
    boolean actualIsUseDefaultAppResult = actualMobileAppSettingsEntity.isUseDefaultApp();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.toString());
    assertEquals(
        "MobileAppSettingsEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, useDefaultApp=true, androidConfig"
            + "={\"isPublic\":true}, iosConfig={\"isPublic\":true}, qrCodeConfig={\"isPublic\":true})",
        actualToStringResult);
    assertEquals(0L, actualMobileAppSettingsEntity.getCreatedTime());
    assertTrue(actualIsUseDefaultAppResult);
    assertSame(qrCodeConfig, actualAndroidConfig);
    assertSame(qrCodeConfig, actualIosConfig);
    assertSame(qrCodeConfig, actualQrCodeConfig);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test
   * {@link MobileAppSettingsEntity#MobileAppSettingsEntity(MobileAppSettings)}.
   * <p>
   * Method under test:
   * {@link MobileAppSettingsEntity#MobileAppSettingsEntity(MobileAppSettings)}
   */
  @Test
  public void testNewMobileAppSettingsEntity() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    MobileAppSettingsEntity actualMobileAppSettingsEntity = new MobileAppSettingsEntity(mobileAppSettings);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualMobileAppSettingsEntity.getTenantId().toString());
    assertNull(actualMobileAppSettingsEntity.getAndroidConfig());
    assertNull(actualMobileAppSettingsEntity.getIosConfig());
    assertNull(actualMobileAppSettingsEntity.getQrCodeConfig());
    assertNull(actualMobileAppSettingsEntity.getId());
    assertNull(actualMobileAppSettingsEntity.getUuid());
    assertEquals(0L, actualMobileAppSettingsEntity.getCreatedTime());
    assertFalse(actualMobileAppSettingsEntity.isUseDefaultApp());
  }

  /**
   * Test
   * {@link MobileAppSettingsEntity#MobileAppSettingsEntity(MobileAppSettings)}.
   * <ul>
   *   <li>Then AndroidConfig iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppSettingsEntity#MobileAppSettingsEntity(MobileAppSettings)}
   */
  @Test
  public void testNewMobileAppSettingsEntity_thenAndroidConfigIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    AndroidConfig androidConfig = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    mobileAppSettings.setAndroidConfig(androidConfig);
    mobileAppSettings.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    JsonNode androidConfig2 = (new MobileAppSettingsEntity(mobileAppSettings)).getAndroidConfig();
    Iterator<JsonNode> iteratorResult = androidConfig2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(androidConfig2 instanceof ObjectNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonParser traverseResult3 = nextResult3.traverse();
    assertTrue(traverseResult3 instanceof TreeTraversingParser);
    JsonParser traverseResult4 = androidConfig2.traverse();
    assertTrue(traverseResult4 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    JsonStreamContext parsingContext3 = traverseResult3.getParsingContext();
    assertEquals("ROOT", parsingContext3.getTypeDesc());
    JsonStreamContext parsingContext4 = traverseResult4.getParsingContext();
    assertEquals("ROOT", parsingContext4.getTypeDesc());
    assertEquals("\"b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09\"", nextResult3.toPrettyString());
    assertEquals("\"java.text\"", nextResult2.toPrettyString());
    Version versionResult = traverseResult4.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n" + "  \"enabled\" : true,\r\n" + "  \"appPackage\" : \"java.text\",\r\n"
        + "  \"sha256CertFingerprints\" : \"b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09\",\r\n"
        + "  \"storeLink\" : \"Store Link\"\r\n" + "}", androidConfig2.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult3.getBinaryValue());
    assertNull(traverseResult4.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult3.getSchema());
    assertNull(traverseResult4.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult3.getCurrentToken());
    assertNull(traverseResult4.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult3.getLastClearedToken());
    assertNull(traverseResult4.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult3.getCodec());
    assertNull(traverseResult4.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    assertNull(traverseResult3.getNonBlockingInputFeeder());
    assertNull(traverseResult4.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult4.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult3.getCurrentValue());
    assertNull(traverseResult4.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult3.getEmbeddedObject());
    assertNull(traverseResult4.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult3.getInputSource());
    assertNull(traverseResult4.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult3.getObjectId());
    assertNull(traverseResult4.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(traverseResult3.getTypeId());
    assertNull(traverseResult4.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(parsingContext3.getCurrentValue());
    assertNull(parsingContext4.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult3.getCurrentName());
    assertNull(traverseResult4.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult3.getText());
    assertNull(traverseResult4.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(traverseResult3.getValueAsString());
    assertNull(traverseResult4.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult3.getCurrentTokenId());
    assertEquals(0, traverseResult4.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult3.getFeatureMask());
    assertEquals(0, traverseResult4.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult3.getFormatFeatures());
    assertEquals(0, traverseResult4.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult3.getTextOffset());
    assertEquals(0, traverseResult4.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, traverseResult3.getValueAsInt());
    assertEquals(0, traverseResult4.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext3.getCurrentIndex());
    assertEquals(0, parsingContext4.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext3.getEntryCount());
    assertEquals(0, parsingContext4.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, parsingContext3.getNestingDepth());
    assertEquals(0, parsingContext4.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0, nextResult2.size());
    assertEquals(0, nextResult3.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult3.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult4.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, traverseResult3.getValueAsLong());
    assertEquals(0L, traverseResult4.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(4, androidConfig2.size());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, androidConfig2.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult3.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult3.getValueAsBoolean());
    assertFalse(traverseResult4.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult3.hasCurrentToken());
    assertFalse(traverseResult4.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult3.hasTextCharacters());
    assertFalse(traverseResult4.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult3.isClosed());
    assertFalse(traverseResult4.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult3.isExpectedNumberIntToken());
    assertFalse(traverseResult4.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult3.isExpectedStartArrayToken());
    assertFalse(traverseResult4.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult3.isExpectedStartObjectToken());
    assertFalse(traverseResult4.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(traverseResult3.isNaN());
    assertFalse(traverseResult4.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext3.hasCurrentIndex());
    assertFalse(parsingContext4.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext3.hasCurrentName());
    assertFalse(parsingContext4.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(parsingContext3.hasPathSegment());
    assertFalse(parsingContext4.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(nextResult3.isArray());
    assertFalse(androidConfig2.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(nextResult3.isBigDecimal());
    assertFalse(androidConfig2.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(nextResult3.isBigInteger());
    assertFalse(androidConfig2.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult2.isBinary());
    assertFalse(nextResult3.isBinary());
    assertFalse(androidConfig2.isBinary());
    assertFalse(nextResult2.isBoolean());
    assertFalse(nextResult3.isBoolean());
    assertFalse(androidConfig2.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult3.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult2.isDouble());
    assertFalse(nextResult3.isDouble());
    assertFalse(androidConfig2.isDouble());
    assertFalse(androidConfig2.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult2.isFloat());
    assertFalse(nextResult3.isFloat());
    assertFalse(androidConfig2.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(nextResult3.isFloatingPointNumber());
    assertFalse(androidConfig2.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult2.isInt());
    assertFalse(nextResult3.isInt());
    assertFalse(androidConfig2.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(nextResult3.isIntegralNumber());
    assertFalse(androidConfig2.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult2.isLong());
    assertFalse(nextResult3.isLong());
    assertFalse(androidConfig2.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(nextResult3.isMissingNode());
    assertFalse(androidConfig2.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult2.isNull());
    assertFalse(nextResult3.isNull());
    assertFalse(androidConfig2.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult2.isNumber());
    assertFalse(nextResult3.isNumber());
    assertFalse(androidConfig2.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult3.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult2.isPojo());
    assertFalse(nextResult3.isPojo());
    assertFalse(androidConfig2.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult2.isShort());
    assertFalse(nextResult3.isShort());
    assertFalse(androidConfig2.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(androidConfig2.isTextual());
    assertFalse(androidConfig2.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(androidConfig2.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult2.isEmpty());
    assertTrue(nextResult3.isEmpty());
    assertTrue(androidConfig2.isObject());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult3.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(nextResult2.isValueNode());
    assertTrue(nextResult3.isValueNode());
    assertTrue(iteratorResult.hasNext());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult3.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(currentLocation, traverseResult3.getTokenLocation());
    assertSame(currentLocation, traverseResult4.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(versionResult, traverseResult2.version());
    assertSame(versionResult, traverseResult3.version());
  }

  /**
   * Test {@link MobileAppSettingsEntity#toData()}.
   * <ul>
   *   <li>Given {@link MobileAppSettingsEntity#MobileAppSettingsEntity()} IosConfig
   * is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#toData()}
   */
  @Test
  public void testToData_givenMobileAppSettingsEntityIosConfigIsInstance() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setIosConfig(MissingNode.getInstance());

    // Act
    MobileAppSettings actualToDataResult = mobileAppSettingsEntity.toData();

    // Assert
    assertNull(actualToDataResult.getDefaultAppStoreLink());
    assertNull(actualToDataResult.getDefaultGooglePlayLink());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertNull(tenantId.getId());
    assertNull(actualToDataResult.getAndroidConfig());
    assertNull(actualToDataResult.getIosConfig());
    assertNull(actualToDataResult.getQrCodeConfig());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertFalse(actualToDataResult.isUseDefaultApp());
  }

  /**
   * Test {@link MobileAppSettingsEntity#toData()}.
   * <ul>
   *   <li>Given {@link MobileAppSettingsEntity#MobileAppSettingsEntity()}.</li>
   *   <li>Then return DefaultAppStoreLink is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsEntity#toData()}
   */
  @Test
  public void testToData_givenMobileAppSettingsEntity_thenReturnDefaultAppStoreLinkIsNull() {
    // Arrange and Act
    MobileAppSettings actualToDataResult = (new MobileAppSettingsEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getDefaultAppStoreLink());
    assertNull(actualToDataResult.getDefaultGooglePlayLink());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertNull(tenantId.getId());
    assertNull(actualToDataResult.getAndroidConfig());
    assertNull(actualToDataResult.getIosConfig());
    assertNull(actualToDataResult.getQrCodeConfig());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertFalse(actualToDataResult.isUseDefaultApp());
  }
}
