package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.DeviceInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class DeviceInfoEntityDiffblueTest {
  /**
   * Test {@link DeviceInfoEntity#equals(Object)}, and {@link DeviceInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceInfoEntity#equals(Object)}
   *   <li>{@link DeviceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceInfoEntity, deviceInfoEntity2);
    int expectedHashCodeResult = deviceInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceInfoEntity2.hashCode());
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}, and {@link DeviceInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceInfoEntity#equals(Object)}
   *   <li>{@link DeviceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);

    // Act and Assert
    assertEquals(deviceInfoEntity, deviceInfoEntity);
    int expectedHashCodeResult = deviceInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceInfoEntity.hashCode());
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(false);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerIsPublic(false);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Mr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle(null);
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileName("Type");
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileName(null);
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, null);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, "Different type to DeviceInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DeviceInfoEntity.<init>()",
    "String DeviceInfoEntity.getCustomerTitle()",
    "String DeviceInfoEntity.getDeviceProfileName()",
    "boolean DeviceInfoEntity.isActive()",
    "boolean DeviceInfoEntity.isCustomerIsPublic()",
    "void DeviceInfoEntity.setActive(boolean)",
    "void DeviceInfoEntity.setCustomerIsPublic(boolean)",
    "void DeviceInfoEntity.setCustomerTitle(String)",
    "void DeviceInfoEntity.setDeviceProfileName(String)",
    "String DeviceInfoEntity.toString()"
  })
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

    // Assert
    assertEquals(
        "DeviceInfoEntity(customerTitle=Dr, customerIsPublic=true, deviceProfileName=foo.txt, active=true)",
        actualToStringResult);
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("foo.txt", actualDeviceProfileName);
    assertNull(actualDeviceInfoEntity.getAdditionalInfo());
    assertNull(actualDeviceInfoEntity.getDeviceData());
    assertNull(actualDeviceInfoEntity.getVersion());
    assertNull(actualDeviceInfoEntity.getLabel());
    assertNull(actualDeviceInfoEntity.getName());
    assertNull(actualDeviceInfoEntity.getType());
    assertNull(actualDeviceInfoEntity.getId());
    assertNull(actualDeviceInfoEntity.getUuid());
    assertNull(actualDeviceInfoEntity.getCustomerId());
    assertNull(actualDeviceInfoEntity.getDeviceProfileId());
    assertNull(actualDeviceInfoEntity.getExternalId());
    assertNull(actualDeviceInfoEntity.getFirmwareId());
    assertNull(actualDeviceInfoEntity.getSoftwareId());
    assertNull(actualDeviceInfoEntity.getTenantId());
    assertEquals(0L, actualDeviceInfoEntity.getCreatedTime());
    assertTrue(actualIsActiveResult);
    assertTrue(actualIsCustomerIsPublicResult);
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceInfoEntity} (default constructor).
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_givenDeviceInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    DeviceInfo actualToDataResult = new DeviceInfoEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getLabel());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getCustomerTitle());
    assertNull(actualToDataResult.getDeviceProfileName());
    assertNull(actualToDataResult.getUuidId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isActive());
    assertFalse(actualToDataResult.isCustomerIsPublic());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return CustomerId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceInfoEntity.setCustomerId(customerId);
    deviceInfoEntity.setDeviceProfileId(null);
    deviceInfoEntity.setFirmwareId(null);
    deviceInfoEntity.setSoftwareId(null);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act and Assert
    CustomerId customerId2 = deviceInfoEntity.toData().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return DeviceProfileId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnDeviceProfileIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceInfoEntity.setDeviceProfileId(deviceProfileId);
    deviceInfoEntity.setFirmwareId(null);
    deviceInfoEntity.setSoftwareId(null);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act and Assert
    DeviceProfileId deviceProfileId2 = deviceInfoEntity.toData().getDeviceProfileId();
    UUID id = deviceProfileId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId2.getEntityType());
    assertFalse(deviceProfileId2.isNullUid());
    assertSame(deviceProfileId, id);
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    deviceInfoEntity.setDeviceProfileId(null);
    deviceInfoEntity.setFirmwareId(null);
    deviceInfoEntity.setSoftwareId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceInfoEntity.setExternalId(externalId);
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    DeviceId externalId2 = actualToDataResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DEVICE, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertEquals(externalId2, actualToDataResult.getId());
    assertSame(externalId, id);
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return FirmwareId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnFirmwareIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    deviceInfoEntity.setDeviceProfileId(null);
    UUID firmwareId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceInfoEntity.setFirmwareId(firmwareId);
    deviceInfoEntity.setSoftwareId(null);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act and Assert
    OtaPackageId firmwareId2 = deviceInfoEntity.toData().getFirmwareId();
    UUID id = firmwareId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.OTA_PACKAGE, firmwareId2.getEntityType());
    assertFalse(firmwareId2.isNullUid());
    assertSame(firmwareId, id);
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return SoftwareId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnSoftwareIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    deviceInfoEntity.setDeviceProfileId(null);
    deviceInfoEntity.setFirmwareId(null);
    UUID softwareId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceInfoEntity.setSoftwareId(softwareId);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act and Assert
    OtaPackageId softwareId2 = deviceInfoEntity.toData().getSoftwareId();
    UUID id = softwareId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.OTA_PACKAGE, softwareId2.getEntityType());
    assertFalse(softwareId2.isNullUid());
    assertSame(softwareId, id);
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    UUID tenantId = UUID.randomUUID();
    deviceInfoEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = deviceInfoEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    TenantId tenantId = deviceInfoEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
