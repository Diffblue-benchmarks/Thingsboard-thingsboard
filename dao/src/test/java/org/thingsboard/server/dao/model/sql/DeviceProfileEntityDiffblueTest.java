package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;
import org.thingsboard.server.common.data.DeviceProfileType;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class DeviceProfileEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileEntity.<init>()", "UUID DeviceProfileEntity.getDefaultDashboardId()",
      "UUID DeviceProfileEntity.getDefaultEdgeRuleChainId()", "String DeviceProfileEntity.getDefaultQueueName()",
      "UUID DeviceProfileEntity.getDefaultRuleChainId()", "String DeviceProfileEntity.getDescription()",
      "UUID DeviceProfileEntity.getExternalId()", "UUID DeviceProfileEntity.getFirmwareId()",
      "String DeviceProfileEntity.getImage()", "String DeviceProfileEntity.getName()",
      "JsonNode DeviceProfileEntity.getProfileData()", "String DeviceProfileEntity.getProvisionDeviceKey()",
      "DeviceProfileProvisionType DeviceProfileEntity.getProvisionType()", "UUID DeviceProfileEntity.getSoftwareId()",
      "UUID DeviceProfileEntity.getTenantId()", "DeviceTransportType DeviceProfileEntity.getTransportType()",
      "DeviceProfileType DeviceProfileEntity.getType()", "boolean DeviceProfileEntity.isDefault()",
      "void DeviceProfileEntity.setDefault(boolean)", "void DeviceProfileEntity.setDefaultDashboardId(UUID)",
      "void DeviceProfileEntity.setDefaultEdgeRuleChainId(UUID)",
      "void DeviceProfileEntity.setDefaultQueueName(String)", "void DeviceProfileEntity.setDefaultRuleChainId(UUID)",
      "void DeviceProfileEntity.setDescription(String)", "void DeviceProfileEntity.setExternalId(UUID)",
      "void DeviceProfileEntity.setFirmwareId(UUID)", "void DeviceProfileEntity.setImage(String)",
      "void DeviceProfileEntity.setName(String)", "void DeviceProfileEntity.setProfileData(JsonNode)",
      "void DeviceProfileEntity.setProvisionDeviceKey(String)",
      "void DeviceProfileEntity.setProvisionType(DeviceProfileProvisionType)",
      "void DeviceProfileEntity.setSoftwareId(UUID)", "void DeviceProfileEntity.setTenantId(UUID)",
      "void DeviceProfileEntity.setTransportType(DeviceTransportType)",
      "void DeviceProfileEntity.setType(DeviceProfileType)", "String DeviceProfileEntity.toString()"})
  public void testGettersAndSetters() {
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
}
