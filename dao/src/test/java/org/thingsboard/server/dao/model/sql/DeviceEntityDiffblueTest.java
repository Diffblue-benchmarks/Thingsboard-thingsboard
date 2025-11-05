package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class DeviceEntityDiffblueTest {
  /**
   * Test {@link DeviceEntity#equals(Object)}, and {@link DeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceEntity#equals(Object)}
   *   <li>{@link DeviceEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceEntity.equals(Object)", "int DeviceEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setType("Type");
    deviceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setVersion(1L);

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity2.setCreatedTime(1L);
    deviceEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity2.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setLabel("Label");
    deviceEntity2.setName("Name");
    deviceEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setType("Type");
    deviceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity2);
    assertEquals(deviceEntity.hashCode(), deviceEntity2.hashCode());
  }

  /**
   * Test {@link DeviceEntity#equals(Object)}, and {@link DeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceEntity#equals(Object)}
   *   <li>{@link DeviceEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceEntity.equals(Object)", "int DeviceEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setType("Type");
    deviceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setVersion(1L);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity);
    int expectedHashCodeResult = deviceEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceEntity.hashCode());
  }

  /**
   * Test {@link DeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceEntity.equals(Object)", "int DeviceEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setType("Type");
    deviceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setVersion(1L);

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity2.setCreatedTime(1L);
    deviceEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity2.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setLabel("Label");
    deviceEntity2.setName("Name");
    deviceEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setType("Type");
    deviceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link DeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceEntity.equals(Object)", "int DeviceEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setType("Type");
    deviceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceEntity, null);
  }

  /**
   * Test {@link DeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceEntity.equals(Object)", "int DeviceEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setType("Type");
    deviceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceEntity, "Different type to DeviceEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceEntity#DeviceEntity()}
   *   <li>{@link DeviceEntity#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceEntity.<init>()", "java.lang.String DeviceEntity.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceEntity actualDeviceEntity = new DeviceEntity();

    // Assert
    assertEquals("DeviceEntity()", actualDeviceEntity.toString());
    assertNull(actualDeviceEntity.getAdditionalInfo());
    assertNull(actualDeviceEntity.getDeviceData());
    assertNull(actualDeviceEntity.getVersion());
    assertNull(actualDeviceEntity.getLabel());
    assertNull(actualDeviceEntity.getName());
    assertNull(actualDeviceEntity.getType());
    assertNull(actualDeviceEntity.getId());
    assertNull(actualDeviceEntity.getUuid());
    assertNull(actualDeviceEntity.getCustomerId());
    assertNull(actualDeviceEntity.getDeviceProfileId());
    assertNull(actualDeviceEntity.getExternalId());
    assertNull(actualDeviceEntity.getFirmwareId());
    assertNull(actualDeviceEntity.getSoftwareId());
    assertNull(actualDeviceEntity.getTenantId());
    assertEquals(0L, actualDeviceEntity.getCreatedTime());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   *
   * <p>Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  @DisplayName("Test new DeviceEntity(Device)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceEntity.<init>(Device)"})
  void testNewDeviceEntity() {
    // Arrange
    Device device = new Device();
    device.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(device);

    // Assert
    UUID customerId = actualDeviceEntity.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.toString());
    CustomerId customerId2 = actualDeviceEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  @DisplayName("Test new DeviceEntity(Device); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceEntity.<init>(Device)"})
  void testNewDeviceEntity_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(device);

    // Assert
    assertNull(actualDeviceEntity.getCustomerId());
    assertNull(actualDeviceEntity.getTenantId());
    Device toDataResult = actualDeviceEntity.toData();
    assertNull(toDataResult.getCustomerId());
    assertNull(toDataResult.getTenantId());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   *
   * <ul>
   *   <li>Then return TenantId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  @DisplayName(
      "Test new DeviceEntity(Device); then return TenantId toString is '13814000-1dd2-11b2-8080-808080808080'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceEntity.<init>(Device)"})
  void testNewDeviceEntity_thenReturnTenantIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Device device = new Device();
    device.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(device);

    // Assert
    UUID tenantId = actualDeviceEntity.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.toString());
    TenantId tenantId2 = actualDeviceEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   *
   * <ul>
   *   <li>When {@link Device#Device()}.
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  @DisplayName("Test new DeviceEntity(Device); when Device(); then return CustomerId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceEntity.<init>(Device)"})
  void testNewDeviceEntity_whenDevice_thenReturnCustomerIdIsNull() {
    // Arrange and Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(new Device());

    // Assert
    assertNull(actualDeviceEntity.getCustomerId());
    assertNull(actualDeviceEntity.getTenantId());
    Device toDataResult = actualDeviceEntity.toData();
    assertNull(toDataResult.getCustomerId());
    assertNull(toDataResult.getTenantId());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} DeviceData is Instance.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given DeviceEntity() DeviceData is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  void testToData_givenDeviceEntityDeviceDataIsInstance() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setType("Type");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setUuid(id);
    deviceEntity.setVersion(1L);
    deviceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setDeviceData(MissingNode.getInstance());

    // Act
    Device actualToDataResult = deviceEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualToDataResult.getLabel());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Type", actualToDataResult.getType());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} DeviceData is {@code null}.
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given DeviceEntity() DeviceData is 'null'; then AdditionalInfo return ObjectNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  void testToData_givenDeviceEntityDeviceDataIsNull_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setType("Type");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setUuid(id);
    deviceEntity.setVersion(1L);
    deviceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDataResult = deviceEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualToDataResult.getLabel());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Type", actualToDataResult.getType());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given DeviceEntity() TenantId is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  void testToData_givenDeviceEntityTenantIdIsRandomUUID() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setType("Type");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setUuid(id);
    deviceEntity.setVersion(1L);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceEntity.setDeviceData(MissingNode.getInstance());

    // Act
    Device actualToDataResult = deviceEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualToDataResult.getLabel());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Type", actualToDataResult.getType());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given DeviceEntity(); then AdditionalInfo return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  void testToData_givenDeviceEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Device actualToDataResult = new DeviceEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getLabel());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getDeviceProfileId());
    assertNull(actualToDataResult.getFirmwareId());
    assertNull(actualToDataResult.getSoftwareId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }
}
