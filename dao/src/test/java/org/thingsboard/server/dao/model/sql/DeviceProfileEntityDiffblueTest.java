package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;
import org.thingsboard.server.common.data.DeviceProfileType;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

class DeviceProfileEntityDiffblueTest {
  /**
   * Test {@link DeviceProfileEntity#equals(Object)}, and {@link DeviceProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileEntity#equals(Object)}
   *   <li>{@link DeviceProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceProfileEntity, deviceProfileEntity2);
    assertEquals(deviceProfileEntity.hashCode(), deviceProfileEntity2.hashCode());
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}, and {@link DeviceProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileEntity#equals(Object)}
   *   <li>{@link DeviceProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(null);
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(null);
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceProfileEntity, deviceProfileEntity2);
    assertEquals(deviceProfileEntity.hashCode(), deviceProfileEntity2.hashCode());
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}, and {@link DeviceProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileEntity#equals(Object)}
   *   <li>{@link DeviceProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    // Act and Assert
    assertEquals(deviceProfileEntity, deviceProfileEntity);
    int expectedHashCodeResult = deviceProfileEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfileEntity.hashCode());
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(3L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(false);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(null);
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(null);
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName(null);
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(null);
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("Name");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription(null);
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(null);
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(null);
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Name");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage(null);
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Image");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName(null);
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(DoubleNode.valueOf(10.0d));
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(null);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Name");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey(null);
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(null);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.ALLOW_CREATE_NEW_DEVICES);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(null);
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(null);
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual31() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(null);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual32() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.MQTT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual33() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(null);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual34() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    DeviceProfileEntity deviceProfileEntity2 = new DeviceProfileEntity();
    deviceProfileEntity2.setCreatedTime(1L);
    deviceProfileEntity2.setDefault(true);
    deviceProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setDescription("The characteristics of someone or something");
    deviceProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setImage("Image");
    deviceProfileEntity2.setName("Name");
    deviceProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity2.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity2.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity2.setType(null);
    deviceProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, deviceProfileEntity2);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, null);
  }

  /**
   * Test {@link DeviceProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileEntity.equals(Object)",
    "int DeviceProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfileEntity, "Different type to DeviceProfileEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileEntity#DeviceProfileEntity()}
   *   <li>{@link DeviceProfileEntity#setDefault(boolean)}
   *   <li>{@link DeviceProfileEntity#setDefaultDashboardId(UUID)}
   *   <li>{@link DeviceProfileEntity#setDefaultEdgeRuleChainId(UUID)}
   *   <li>{@link DeviceProfileEntity#setDefaultQueueName(String)}
   *   <li>{@link DeviceProfileEntity#setDefaultRuleChainId(UUID)}
   *   <li>{@link DeviceProfileEntity#setDescription(String)}
   *   <li>{@link DeviceProfileEntity#setExternalId(UUID)}
   *   <li>{@link DeviceProfileEntity#setFirmwareId(UUID)}
   *   <li>{@link DeviceProfileEntity#setImage(String)}
   *   <li>{@link DeviceProfileEntity#setName(String)}
   *   <li>{@link DeviceProfileEntity#setProfileData(JsonNode)}
   *   <li>{@link DeviceProfileEntity#setProvisionDeviceKey(String)}
   *   <li>{@link DeviceProfileEntity#setProvisionType(DeviceProfileProvisionType)}
   *   <li>{@link DeviceProfileEntity#setSoftwareId(UUID)}
   *   <li>{@link DeviceProfileEntity#setTenantId(UUID)}
   *   <li>{@link DeviceProfileEntity#setTransportType(DeviceTransportType)}
   *   <li>{@link DeviceProfileEntity#setType(DeviceProfileType)}
   *   <li>{@link DeviceProfileEntity#toString()}
   *   <li>{@link DeviceProfileEntity#getDefaultDashboardId()}
   *   <li>{@link DeviceProfileEntity#getDefaultEdgeRuleChainId()}
   *   <li>{@link DeviceProfileEntity#getDefaultQueueName()}
   *   <li>{@link DeviceProfileEntity#getDefaultRuleChainId()}
   *   <li>{@link DeviceProfileEntity#getDescription()}
   *   <li>{@link DeviceProfileEntity#getExternalId()}
   *   <li>{@link DeviceProfileEntity#getFirmwareId()}
   *   <li>{@link DeviceProfileEntity#getImage()}
   *   <li>{@link DeviceProfileEntity#getName()}
   *   <li>{@link DeviceProfileEntity#getProfileData()}
   *   <li>{@link DeviceProfileEntity#getProvisionDeviceKey()}
   *   <li>{@link DeviceProfileEntity#getProvisionType()}
   *   <li>{@link DeviceProfileEntity#getSoftwareId()}
   *   <li>{@link DeviceProfileEntity#getTenantId()}
   *   <li>{@link DeviceProfileEntity#getTransportType()}
   *   <li>{@link DeviceProfileEntity#getType()}
   *   <li>{@link DeviceProfileEntity#isDefault()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileEntity.<init>()",
    "UUID DeviceProfileEntity.getDefaultDashboardId()",
    "UUID DeviceProfileEntity.getDefaultEdgeRuleChainId()",
    "String DeviceProfileEntity.getDefaultQueueName()",
    "UUID DeviceProfileEntity.getDefaultRuleChainId()",
    "String DeviceProfileEntity.getDescription()",
    "UUID DeviceProfileEntity.getExternalId()",
    "UUID DeviceProfileEntity.getFirmwareId()",
    "String DeviceProfileEntity.getImage()",
    "String DeviceProfileEntity.getName()",
    "JsonNode DeviceProfileEntity.getProfileData()",
    "String DeviceProfileEntity.getProvisionDeviceKey()",
    "DeviceProfileProvisionType DeviceProfileEntity.getProvisionType()",
    "UUID DeviceProfileEntity.getSoftwareId()",
    "UUID DeviceProfileEntity.getTenantId()",
    "DeviceTransportType DeviceProfileEntity.getTransportType()",
    "DeviceProfileType DeviceProfileEntity.getType()",
    "boolean DeviceProfileEntity.isDefault()",
    "void DeviceProfileEntity.setDefault(boolean)",
    "void DeviceProfileEntity.setDefaultDashboardId(UUID)",
    "void DeviceProfileEntity.setDefaultEdgeRuleChainId(UUID)",
    "void DeviceProfileEntity.setDefaultQueueName(String)",
    "void DeviceProfileEntity.setDefaultRuleChainId(UUID)",
    "void DeviceProfileEntity.setDescription(String)",
    "void DeviceProfileEntity.setExternalId(UUID)",
    "void DeviceProfileEntity.setFirmwareId(UUID)",
    "void DeviceProfileEntity.setImage(String)",
    "void DeviceProfileEntity.setName(String)",
    "void DeviceProfileEntity.setProfileData(JsonNode)",
    "void DeviceProfileEntity.setProvisionDeviceKey(String)",
    "void DeviceProfileEntity.setProvisionType(DeviceProfileProvisionType)",
    "void DeviceProfileEntity.setSoftwareId(UUID)",
    "void DeviceProfileEntity.setTenantId(UUID)",
    "void DeviceProfileEntity.setTransportType(DeviceTransportType)",
    "void DeviceProfileEntity.setType(DeviceProfileType)",
    "String DeviceProfileEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceProfileEntity actualDeviceProfileEntity = new DeviceProfileEntity();
    actualDeviceProfileEntity.setDefault(true);
    UUID defaultDashboardId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDeviceProfileEntity.setDefaultDashboardId(defaultDashboardId);
    UUID defaultEdgeRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDeviceProfileEntity.setDefaultEdgeRuleChainId(defaultEdgeRuleChainId);
    actualDeviceProfileEntity.setDefaultQueueName("Default Queue Name");
    UUID defaultRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDeviceProfileEntity.setDefaultRuleChainId(defaultRuleChainId);
    actualDeviceProfileEntity.setDescription("The characteristics of someone or something");
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDeviceProfileEntity.setExternalId(externalId);
    UUID firmwareId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDeviceProfileEntity.setFirmwareId(firmwareId);
    actualDeviceProfileEntity.setImage("Image");
    actualDeviceProfileEntity.setName("Name");
    JsonNode profileData = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualDeviceProfileEntity.setProfileData(profileData);
    actualDeviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    actualDeviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    UUID softwareId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDeviceProfileEntity.setSoftwareId(softwareId);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDeviceProfileEntity.setTenantId(tenantId);
    actualDeviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    actualDeviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    String actualToStringResult = actualDeviceProfileEntity.toString();
    UUID actualDefaultDashboardId = actualDeviceProfileEntity.getDefaultDashboardId();
    UUID actualDefaultEdgeRuleChainId = actualDeviceProfileEntity.getDefaultEdgeRuleChainId();
    String actualDefaultQueueName = actualDeviceProfileEntity.getDefaultQueueName();
    UUID actualDefaultRuleChainId = actualDeviceProfileEntity.getDefaultRuleChainId();
    String actualDescription = actualDeviceProfileEntity.getDescription();
    UUID actualExternalId = actualDeviceProfileEntity.getExternalId();
    UUID actualFirmwareId = actualDeviceProfileEntity.getFirmwareId();
    String actualImage = actualDeviceProfileEntity.getImage();
    String actualName = actualDeviceProfileEntity.getName();
    JsonNode actualProfileData = actualDeviceProfileEntity.getProfileData();
    String actualProvisionDeviceKey = actualDeviceProfileEntity.getProvisionDeviceKey();
    DeviceProfileProvisionType actualProvisionType = actualDeviceProfileEntity.getProvisionType();
    UUID actualSoftwareId = actualDeviceProfileEntity.getSoftwareId();
    UUID actualTenantId = actualDeviceProfileEntity.getTenantId();
    DeviceTransportType actualTransportType = actualDeviceProfileEntity.getTransportType();
    DeviceProfileType actualType = actualDeviceProfileEntity.getType();
    boolean actualIsDefaultResult = actualDeviceProfileEntity.isDefault();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDefaultDashboardId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDefaultEdgeRuleChainId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDefaultRuleChainId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualFirmwareId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualSoftwareId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Default Queue Name", actualDefaultQueueName);
    assertEquals(
        "DeviceProfileEntity(super=BaseVersionedEntity{id=null, createdTime=0, version=null}, tenantId=784f394c"
            + "-42b6-435a-983c-b7beff2784f9, name=Name, type=DEFAULT, image=Image, transportType=DEFAULT, provisionType"
            + "=DISABLED, description=The characteristics of someone or something, isDefault=true, defaultRuleChainId"
            + "=784f394c-42b6-435a-983c-b7beff2784f9, defaultDashboardId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " defaultQueueName=Default Queue Name, profileData={\"isPublic\":true}, provisionDeviceKey=Provision"
            + " Device Key, firmwareId=784f394c-42b6-435a-983c-b7beff2784f9, softwareId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9, defaultEdgeRuleChainId=784f394c-42b6-435a-983c-b7beff2784f9, externalId=784f394c-42b6"
            + "-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals("Image", actualImage);
    assertEquals("Name", actualName);
    assertEquals("Provision Device Key", actualProvisionDeviceKey);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertNull(actualDeviceProfileEntity.getVersion());
    assertNull(actualDeviceProfileEntity.getId());
    assertNull(actualDeviceProfileEntity.getUuid());
    assertEquals(0L, actualDeviceProfileEntity.getCreatedTime());
    assertEquals(DeviceProfileProvisionType.DISABLED, actualProvisionType);
    assertEquals(DeviceProfileType.DEFAULT, actualType);
    assertEquals(DeviceTransportType.DEFAULT, actualTransportType);
    assertTrue(actualIsDefaultResult);
    assertSame(defaultDashboardId, actualDefaultDashboardId);
    assertSame(defaultEdgeRuleChainId, actualDefaultEdgeRuleChainId);
    assertSame(defaultRuleChainId, actualDefaultRuleChainId);
    assertSame(externalId, actualExternalId);
    assertSame(firmwareId, actualFirmwareId);
    assertSame(softwareId, actualSoftwareId);
    assertSame(tenantId, actualTenantId);
    assertSame(profileData, actualProfileData);
  }

  /**
   * Test {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}.
   *
   * <p>Method under test: {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfileEntity(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileEntity.<init>(DeviceProfile)"})
  void testNewDeviceProfileEntity() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    DeviceProfileEntity actualDeviceProfileEntity = new DeviceProfileEntity(deviceProfile);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualDeviceProfileEntity.getTenantId().toString());
    assertNull(actualDeviceProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfileEntity.getDefaultRuleChainId());
    assertFalse(actualDeviceProfileEntity.isDefault());
  }

  /**
   * Test {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}.
   *
   * <p>Method under test: {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfileEntity(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileEntity.<init>(DeviceProfile)"})
  void testNewDeviceProfileEntity2() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceProfile.setDefaultRuleChainId(new RuleChainId(id));

    // Act
    DeviceProfileEntity actualDeviceProfileEntity = new DeviceProfileEntity(deviceProfile);

    // Assert
    UUID defaultRuleChainId = actualDeviceProfileEntity.getDefaultRuleChainId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", defaultRuleChainId.toString());
    assertNull(actualDeviceProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfileEntity.getTenantId());
    assertFalse(actualDeviceProfileEntity.isDefault());
    assertSame(id, defaultRuleChainId);
  }

  /**
   * Test {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}.
   *
   * <p>Method under test: {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfileEntity(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileEntity.<init>(DeviceProfile)"})
  void testNewDeviceProfileEntity3() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceProfile.setDefaultEdgeRuleChainId(new RuleChainId(id));

    // Act
    DeviceProfileEntity actualDeviceProfileEntity = new DeviceProfileEntity(deviceProfile);

    // Assert
    UUID defaultEdgeRuleChainId = actualDeviceProfileEntity.getDefaultEdgeRuleChainId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", defaultEdgeRuleChainId.toString());
    assertNull(actualDeviceProfileEntity.getDefaultRuleChainId());
    assertNull(actualDeviceProfileEntity.getTenantId());
    assertFalse(actualDeviceProfileEntity.isDefault());
    assertSame(id, defaultEdgeRuleChainId);
  }

  /**
   * Test {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfileEntity(DeviceProfile); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileEntity.<init>(DeviceProfile)"})
  void testNewDeviceProfileEntity_givenA() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DeviceProfileEntity actualDeviceProfileEntity = new DeviceProfileEntity(deviceProfile);

    // Assert
    assertNull(actualDeviceProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfileEntity.getDefaultRuleChainId());
    assertNull(actualDeviceProfileEntity.getTenantId());
    assertFalse(actualDeviceProfileEntity.isDefault());
  }

  /**
   * Test {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfileEntity(DeviceProfile); given empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileEntity.<init>(DeviceProfile)"})
  void testNewDeviceProfileEntity_givenEmptyArrayOfByte() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[] {});

    // Act
    DeviceProfileEntity actualDeviceProfileEntity = new DeviceProfileEntity(deviceProfile);

    // Assert
    assertNull(actualDeviceProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfileEntity.getDefaultRuleChainId());
    assertNull(actualDeviceProfileEntity.getTenantId());
    assertFalse(actualDeviceProfileEntity.isDefault());
  }

  /**
   * Test {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return Default.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfileEntity(DeviceProfile); given 'true'; then return Default")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileEntity.<init>(DeviceProfile)"})
  void testNewDeviceProfileEntity_givenTrue_thenReturnDefault() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefault(true);

    // Act
    DeviceProfileEntity actualDeviceProfileEntity = new DeviceProfileEntity(deviceProfile);

    // Assert
    assertNull(actualDeviceProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfileEntity.getDefaultRuleChainId());
    assertNull(actualDeviceProfileEntity.getTenantId());
    assertTrue(actualDeviceProfileEntity.isDefault());
  }

  /**
   * Test {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}.
   *
   * <ul>
   *   <li>When {@link DeviceProfile#DeviceProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#DeviceProfileEntity(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfileEntity(DeviceProfile); when DeviceProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileEntity.<init>(DeviceProfile)"})
  void testNewDeviceProfileEntity_whenDeviceProfile() {
    // Arrange and Act
    DeviceProfileEntity actualDeviceProfileEntity = new DeviceProfileEntity(new DeviceProfile());

    // Assert
    assertNull(actualDeviceProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfileEntity.getDefaultRuleChainId());
    assertNull(actualDeviceProfileEntity.getTenantId());
    assertFalse(actualDeviceProfileEntity.isDefault());
  }

  /**
   * Test {@link DeviceProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileEntity#DeviceProfileEntity()} ProfileData is Instance.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given DeviceProfileEntity() ProfileData is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileEntity.toData()"})
  void testToData_givenDeviceProfileEntityProfileDataIsInstance() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceProfileEntity.setUuid(id);
    deviceProfileEntity.setVersion(1L);
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setProfileData(MissingNode.getInstance());

    // Act
    DeviceProfile actualToDataResult = deviceProfileEntity.toData();

    // Assert
    assertEquals("Default Queue Name", actualToDataResult.getDefaultQueueName());
    assertEquals("Image", actualToDataResult.getImage());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Provision Device Key", actualToDataResult.getProvisionDeviceKey());
    assertEquals(
        "The characteristics of someone or something", actualToDataResult.getDescription());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(DeviceProfileProvisionType.DISABLED, actualToDataResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualToDataResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualToDataResult.getTransportType());
    assertTrue(actualToDataResult.isDefault());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link DeviceProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileEntity#DeviceProfileEntity()} ProfileData is {@code null}.
   *   <li>Then return {@code Default Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given DeviceProfileEntity() ProfileData is 'null'; then return 'Default Queue Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileEntity.toData()"})
  void testToData_givenDeviceProfileEntityProfileDataIsNull_thenReturnDefaultQueueName() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceProfileEntity.setUuid(id);
    deviceProfileEntity.setVersion(1L);
    deviceProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setProfileData(null);

    // Act
    DeviceProfile actualToDataResult = deviceProfileEntity.toData();

    // Assert
    assertEquals("Default Queue Name", actualToDataResult.getDefaultQueueName());
    assertEquals("Image", actualToDataResult.getImage());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Provision Device Key", actualToDataResult.getProvisionDeviceKey());
    assertEquals(
        "The characteristics of someone or something", actualToDataResult.getDescription());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(DeviceProfileProvisionType.DISABLED, actualToDataResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualToDataResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualToDataResult.getTransportType());
    assertTrue(actualToDataResult.isDefault());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link DeviceProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileEntity#DeviceProfileEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given DeviceProfileEntity() TenantId is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileEntity.toData()"})
  void testToData_givenDeviceProfileEntityTenantIdIsRandomUUID() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceProfileEntity.setUuid(id);
    deviceProfileEntity.setVersion(1L);
    deviceProfileEntity.setTenantId(UUID.randomUUID());
    deviceProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfileEntity.setProfileData(null);

    // Act
    DeviceProfile actualToDataResult = deviceProfileEntity.toData();

    // Assert
    assertEquals("Default Queue Name", actualToDataResult.getDefaultQueueName());
    assertEquals("Image", actualToDataResult.getImage());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Provision Device Key", actualToDataResult.getProvisionDeviceKey());
    assertEquals(
        "The characteristics of someone or something", actualToDataResult.getDescription());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(DeviceProfileProvisionType.DISABLED, actualToDataResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualToDataResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualToDataResult.getTransportType());
    assertTrue(actualToDataResult.isDefault());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link DeviceProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileEntity#DeviceProfileEntity()}.
   *   <li>Then return Version is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given DeviceProfileEntity(); then return Version is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileEntity.toData()"})
  void testToData_givenDeviceProfileEntity_thenReturnVersionIsNull() {
    // Arrange and Act
    DeviceProfile actualToDataResult = new DeviceProfileEntity().toData();

    // Assert
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getDefaultQueueName());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getProvisionDeviceKey());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getProvisionType());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getTransportType());
    assertNull(actualToDataResult.getDefaultDashboardId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getFirmwareId());
    assertNull(actualToDataResult.getSoftwareId());
    assertNull(actualToDataResult.getDefaultEdgeRuleChainId());
    assertNull(actualToDataResult.getDefaultRuleChainId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDefault());
  }
}
