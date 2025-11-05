package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceInfo;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class DeviceInfoEntityDiffblueTest {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
    assertEquals(deviceInfoEntity.hashCode(), deviceInfoEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  void testGettersAndSetters() {
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
   *   <li>Given {@link DeviceInfoEntity} (default constructor) DeviceData is Instance.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given DeviceInfoEntity (default constructor) DeviceData is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  void testToData_givenDeviceInfoEntityDeviceDataIsInstance() {
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
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceInfoEntity.setUuid(id);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceData(MissingNode.getInstance());

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Dr", actualToDataResult.getCustomerTitle());
    assertEquals("Label", actualToDataResult.getLabel());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Type", actualToDataResult.getType());
    assertEquals("foo.txt", actualToDataResult.getDeviceProfileName());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isActive());
    assertTrue(actualToDataResult.isCustomerIsPublic());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceInfoEntity} (default constructor) DeviceData is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given DeviceInfoEntity (default constructor) DeviceData is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  void testToData_givenDeviceInfoEntityDeviceDataIsNull() {
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
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceInfoEntity.setUuid(id);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Dr", actualToDataResult.getCustomerTitle());
    assertEquals("Label", actualToDataResult.getLabel());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Type", actualToDataResult.getType());
    assertEquals("foo.txt", actualToDataResult.getDeviceProfileName());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isActive());
    assertTrue(actualToDataResult.isCustomerIsPublic());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceInfoEntity} (default constructor) TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given DeviceInfoEntity (default constructor) TenantId is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  void testToData_givenDeviceInfoEntityTenantIdIsRandomUUID() {
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
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceInfoEntity.setUuid(id);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(UUID.randomUUID());
    deviceInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceInfoEntity.setDeviceData(MissingNode.getInstance());

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Dr", actualToDataResult.getCustomerTitle());
    assertEquals("Label", actualToDataResult.getLabel());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Type", actualToDataResult.getType());
    assertEquals("foo.txt", actualToDataResult.getDeviceProfileName());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isActive());
    assertTrue(actualToDataResult.isCustomerIsPublic());
    assertSame(id, actualToDataResult.getUuidId());
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
  @DisplayName(
      "Test toData(); given DeviceInfoEntity (default constructor); then AdditionalInfo return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  void testToData_givenDeviceInfoEntity_thenAdditionalInfoReturnNullNode() {
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
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getDeviceProfileId());
    assertNull(actualToDataResult.getFirmwareId());
    assertNull(actualToDataResult.getSoftwareId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isActive());
    assertFalse(actualToDataResult.isCustomerIsPublic());
  }
}
