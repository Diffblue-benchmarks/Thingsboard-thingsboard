package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.DeviceInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeviceInfoEntityDiffblueTest {
  /**
   * Test {@link DeviceInfoEntity#equals(Object)}, and
   * {@link DeviceInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceInfoEntity#equals(Object)}
   *   <li>{@link DeviceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceInfoEntity, deviceInfoEntity2);
    int expectedHashCodeResult = deviceInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceInfoEntity2.hashCode());
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}, and
   * {@link DeviceInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceInfoEntity#equals(Object)}
   *   <li>{@link DeviceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    // Act and Assert
    assertEquals(deviceInfoEntity, deviceInfoEntity);
    int expectedHashCodeResult = deviceInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceInfoEntity.hashCode());
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(false);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(MissingNode.getInstance());
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(mock(JsonNode.class));
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(false);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Mr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle(null);
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("Type");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName(null);
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, null);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, "Different type to DeviceInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceInfoEntity}
   *   <li>{@link DeviceInfoEntity#setActive(boolean)}
   *   <li>{@link DeviceInfoEntity#setCustomerIsPublic(boolean)}
   *   <li>{@link DeviceInfoEntity#setCustomerTitle(String)}
   *   <li>{@link DeviceInfoEntity#setDeviceProfileName(String)}
   *   <li>{@link DeviceInfoEntity#toString()}
   *   <li>{@link DeviceInfoEntity#getCustomerTitle()}
   *   <li>{@link DeviceInfoEntity#getDeviceProfileName()}
   *   <li>{@link DeviceInfoEntity#isActive()}
   *   <li>{@link DeviceInfoEntity#isCustomerIsPublic()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DeviceInfoEntity actualDeviceInfoEntity = new DeviceInfoEntity();
    actualDeviceInfoEntity.setActive(true);
    actualDeviceInfoEntity.setCustomerIsPublic(true);
    actualDeviceInfoEntity.setCustomerTitle("Dr");
    actualDeviceInfoEntity.setDeviceProfileName("foo.txt");
    String actualToStringResult = actualDeviceInfoEntity.toString();
    String actualCustomerTitle = actualDeviceInfoEntity.getCustomerTitle();
    String actualDeviceProfileName = actualDeviceInfoEntity.getDeviceProfileName();
    boolean actualIsActiveResult = actualDeviceInfoEntity.isActive();
    boolean actualIsCustomerIsPublicResult = actualDeviceInfoEntity.isCustomerIsPublic();

    // Assert that nothing has changed
    assertEquals("DeviceInfoEntity(customerTitle=Dr, customerIsPublic=true, deviceProfileName=foo.txt, active=true)",
        actualToStringResult);
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("foo.txt", actualDeviceProfileName);
    assertEquals(0L, actualDeviceInfoEntity.getCreatedTime());
    assertTrue(actualIsActiveResult);
    assertTrue(actualIsCustomerIsPublicResult);
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link DeviceInfoEntity} (default constructor).</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  public void testToData_givenDeviceInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    DeviceInfo actualToDataResult = (new DeviceInfoEntity()).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getLabel());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getCustomerTitle());
    assertNull(actualToDataResult.getDeviceProfileName());
    assertNull(actualToDataResult.getUuidId());
    DeviceId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0, additionalInfo.size());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(actualToDataResult.isActive());
    assertFalse(actualToDataResult.isCustomerIsPublic());
    assertFalse(id.isNullUid());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   * <ul>
   *   <li>Then return CustomerId EntityType is {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnCustomerIdEntityTypeIsCustomer() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileId(null);
    deviceInfoEntity.setFirmwareId(null);
    deviceInfoEntity.setSoftwareId(null);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   * <ul>
   *   <li>Then return DeviceProfileId EntityType is {@code DEVICE_PROFILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnDeviceProfileIdEntityTypeIsDeviceProfile() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(null);
    deviceInfoEntity.setSoftwareId(null);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    DeviceProfileId deviceProfileId = actualToDataResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   * <ul>
   *   <li>Then return ExternalId EntityType is {@code DEVICE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnExternalIdEntityTypeIsDevice() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    deviceInfoEntity.setDeviceProfileId(null);
    deviceInfoEntity.setFirmwareId(null);
    deviceInfoEntity.setSoftwareId(null);
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    DeviceId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   * <ul>
   *   <li>Then return FirmwareId EntityType is {@code OTA_PACKAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnFirmwareIdEntityTypeIsOtaPackage() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    deviceInfoEntity.setDeviceProfileId(null);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setSoftwareId(null);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    OtaPackageId firmwareId = actualToDataResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertTrue(firmwareId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    UUID tenantId = UUID.randomUUID();
    deviceInfoEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = deviceInfoEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   * <ul>
   *   <li>Then return SoftwareId EntityType is {@code OTA_PACKAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnSoftwareIdEntityTypeIsOtaPackage() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    deviceInfoEntity.setDeviceProfileId(null);
    deviceInfoEntity.setFirmwareId(null);
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    OtaPackageId softwareId = actualToDataResult.getSoftwareId();
    assertEquals(EntityType.OTA_PACKAGE, softwareId.getEntityType());
    assertTrue(actualToDataResult.getId().isNullUid());
    assertTrue(softwareId.isNullUid());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId = deviceInfoEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
