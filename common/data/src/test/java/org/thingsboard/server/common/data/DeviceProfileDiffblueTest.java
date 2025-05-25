package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.profile.DefaultDeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DefaultDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.ObjectAttributes;
import org.thingsboard.server.common.data.device.profile.lwm2m.TelemetryMappingConfiguration;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceProfileDiffblueTest {
  /**
   * Test {@link DeviceProfile#getExternalId()}.
   * <p>
   * Method under test: {@link DeviceProfile#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.DeviceProfileId DeviceProfile.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new DeviceProfile()).getExternalId());
  }

  /**
   * Test {@link DeviceProfile#DeviceProfile(DeviceProfile)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and three.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfile(DeviceProfile); given array of byte with 'A' and three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.<init>(DeviceProfile)"})
  void testNewDeviceProfile_givenArrayOfByteWithAAndThree() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DeviceProfile actualDeviceProfile = new DeviceProfile(deviceProfile);

    // Assert
    assertNull(actualDeviceProfile.getProfileDataBytes());
    assertNull(actualDeviceProfile.getVersion());
    assertNull(actualDeviceProfile.getDefaultQueueName());
    assertNull(actualDeviceProfile.getDescription());
    assertNull(actualDeviceProfile.getImage());
    assertNull(actualDeviceProfile.getName());
    assertNull(actualDeviceProfile.getProvisionDeviceKey());
    assertNull(actualDeviceProfile.getUuidId());
    assertNull(actualDeviceProfile.getProvisionType());
    assertNull(actualDeviceProfile.getType());
    assertNull(actualDeviceProfile.getTransportType());
    assertNull(actualDeviceProfile.getProfileData());
    assertNull(actualDeviceProfile.getDefaultDashboardId());
    assertNull(actualDeviceProfile.getExternalId());
    assertNull(actualDeviceProfile.getId());
    assertNull(actualDeviceProfile.getFirmwareId());
    assertNull(actualDeviceProfile.getSoftwareId());
    assertNull(actualDeviceProfile.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfile.getDefaultRuleChainId());
    assertNull(actualDeviceProfile.getTenantId());
    assertEquals(0L, actualDeviceProfile.getCreatedTime());
    assertFalse(actualDeviceProfile.isDefault());
  }

  /**
   * Test {@link DeviceProfile#DeviceProfile(DeviceProfile)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfile(DeviceProfile); given array of byte with 'A' and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.<init>(DeviceProfile)"})
  void testNewDeviceProfile_givenArrayOfByteWithAAndZero() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{'A', 0, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DeviceProfile actualDeviceProfile = new DeviceProfile(deviceProfile);

    // Assert
    assertNull(actualDeviceProfile.getProfileDataBytes());
    assertNull(actualDeviceProfile.getVersion());
    assertNull(actualDeviceProfile.getDefaultQueueName());
    assertNull(actualDeviceProfile.getDescription());
    assertNull(actualDeviceProfile.getImage());
    assertNull(actualDeviceProfile.getName());
    assertNull(actualDeviceProfile.getProvisionDeviceKey());
    assertNull(actualDeviceProfile.getUuidId());
    assertNull(actualDeviceProfile.getProvisionType());
    assertNull(actualDeviceProfile.getType());
    assertNull(actualDeviceProfile.getTransportType());
    assertNull(actualDeviceProfile.getProfileData());
    assertNull(actualDeviceProfile.getDefaultDashboardId());
    assertNull(actualDeviceProfile.getExternalId());
    assertNull(actualDeviceProfile.getId());
    assertNull(actualDeviceProfile.getFirmwareId());
    assertNull(actualDeviceProfile.getSoftwareId());
    assertNull(actualDeviceProfile.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfile.getDefaultRuleChainId());
    assertNull(actualDeviceProfile.getTenantId());
    assertEquals(0L, actualDeviceProfile.getCreatedTime());
    assertFalse(actualDeviceProfile.isDefault());
  }

  /**
   * Test {@link DeviceProfile#DeviceProfile(DeviceProfile)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code ;} and three.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfile(DeviceProfile); given array of byte with ';' and three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.<init>(DeviceProfile)"})
  void testNewDeviceProfile_givenArrayOfByteWithSemicolonAndThree() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{';', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DeviceProfile actualDeviceProfile = new DeviceProfile(deviceProfile);

    // Assert
    assertNull(actualDeviceProfile.getProfileDataBytes());
    assertNull(actualDeviceProfile.getVersion());
    assertNull(actualDeviceProfile.getDefaultQueueName());
    assertNull(actualDeviceProfile.getDescription());
    assertNull(actualDeviceProfile.getImage());
    assertNull(actualDeviceProfile.getName());
    assertNull(actualDeviceProfile.getProvisionDeviceKey());
    assertNull(actualDeviceProfile.getUuidId());
    assertNull(actualDeviceProfile.getProvisionType());
    assertNull(actualDeviceProfile.getType());
    assertNull(actualDeviceProfile.getTransportType());
    assertNull(actualDeviceProfile.getProfileData());
    assertNull(actualDeviceProfile.getDefaultDashboardId());
    assertNull(actualDeviceProfile.getExternalId());
    assertNull(actualDeviceProfile.getId());
    assertNull(actualDeviceProfile.getFirmwareId());
    assertNull(actualDeviceProfile.getSoftwareId());
    assertNull(actualDeviceProfile.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfile.getDefaultRuleChainId());
    assertNull(actualDeviceProfile.getTenantId());
    assertEquals(0L, actualDeviceProfile.getCreatedTime());
    assertFalse(actualDeviceProfile.isDefault());
  }

  /**
   * Test {@link DeviceProfile#DeviceProfile(DeviceProfile)}.
   * <ul>
   *   <li>Given array of {@code byte} with three and three.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfile(DeviceProfile); given array of byte with three and three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.<init>(DeviceProfile)"})
  void testNewDeviceProfile_givenArrayOfByteWithThreeAndThree() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{3, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DeviceProfile actualDeviceProfile = new DeviceProfile(deviceProfile);

    // Assert
    assertNull(actualDeviceProfile.getProfileDataBytes());
    assertNull(actualDeviceProfile.getVersion());
    assertNull(actualDeviceProfile.getDefaultQueueName());
    assertNull(actualDeviceProfile.getDescription());
    assertNull(actualDeviceProfile.getImage());
    assertNull(actualDeviceProfile.getName());
    assertNull(actualDeviceProfile.getProvisionDeviceKey());
    assertNull(actualDeviceProfile.getUuidId());
    assertNull(actualDeviceProfile.getProvisionType());
    assertNull(actualDeviceProfile.getType());
    assertNull(actualDeviceProfile.getTransportType());
    assertNull(actualDeviceProfile.getProfileData());
    assertNull(actualDeviceProfile.getDefaultDashboardId());
    assertNull(actualDeviceProfile.getExternalId());
    assertNull(actualDeviceProfile.getId());
    assertNull(actualDeviceProfile.getFirmwareId());
    assertNull(actualDeviceProfile.getSoftwareId());
    assertNull(actualDeviceProfile.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfile.getDefaultRuleChainId());
    assertNull(actualDeviceProfile.getTenantId());
    assertEquals(0L, actualDeviceProfile.getCreatedTime());
    assertFalse(actualDeviceProfile.isDefault());
  }

  /**
   * Test {@link DeviceProfile#DeviceProfile(DeviceProfile)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and three.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfile(DeviceProfile); given array of byte with zero and three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.<init>(DeviceProfile)"})
  void testNewDeviceProfile_givenArrayOfByteWithZeroAndThree() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{0, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DeviceProfile actualDeviceProfile = new DeviceProfile(deviceProfile);

    // Assert
    assertNull(actualDeviceProfile.getProfileDataBytes());
    assertNull(actualDeviceProfile.getVersion());
    assertNull(actualDeviceProfile.getDefaultQueueName());
    assertNull(actualDeviceProfile.getDescription());
    assertNull(actualDeviceProfile.getImage());
    assertNull(actualDeviceProfile.getName());
    assertNull(actualDeviceProfile.getProvisionDeviceKey());
    assertNull(actualDeviceProfile.getUuidId());
    assertNull(actualDeviceProfile.getProvisionType());
    assertNull(actualDeviceProfile.getType());
    assertNull(actualDeviceProfile.getTransportType());
    assertNull(actualDeviceProfile.getProfileData());
    assertNull(actualDeviceProfile.getDefaultDashboardId());
    assertNull(actualDeviceProfile.getExternalId());
    assertNull(actualDeviceProfile.getId());
    assertNull(actualDeviceProfile.getFirmwareId());
    assertNull(actualDeviceProfile.getSoftwareId());
    assertNull(actualDeviceProfile.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfile.getDefaultRuleChainId());
    assertNull(actualDeviceProfile.getTenantId());
    assertEquals(0L, actualDeviceProfile.getCreatedTime());
    assertFalse(actualDeviceProfile.isDefault());
  }

  /**
   * Test {@link DeviceProfile#DeviceProfile(DeviceProfile)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfile(DeviceProfile); given empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.<init>(DeviceProfile)"})
  void testNewDeviceProfile_givenEmptyArrayOfByte() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{});

    // Act
    DeviceProfile actualDeviceProfile = new DeviceProfile(deviceProfile);

    // Assert
    assertNull(actualDeviceProfile.getProfileDataBytes());
    assertNull(actualDeviceProfile.getVersion());
    assertNull(actualDeviceProfile.getDefaultQueueName());
    assertNull(actualDeviceProfile.getDescription());
    assertNull(actualDeviceProfile.getImage());
    assertNull(actualDeviceProfile.getName());
    assertNull(actualDeviceProfile.getProvisionDeviceKey());
    assertNull(actualDeviceProfile.getUuidId());
    assertNull(actualDeviceProfile.getProvisionType());
    assertNull(actualDeviceProfile.getType());
    assertNull(actualDeviceProfile.getTransportType());
    assertNull(actualDeviceProfile.getProfileData());
    assertNull(actualDeviceProfile.getDefaultDashboardId());
    assertNull(actualDeviceProfile.getExternalId());
    assertNull(actualDeviceProfile.getId());
    assertNull(actualDeviceProfile.getFirmwareId());
    assertNull(actualDeviceProfile.getSoftwareId());
    assertNull(actualDeviceProfile.getDefaultEdgeRuleChainId());
    assertNull(actualDeviceProfile.getDefaultRuleChainId());
    assertNull(actualDeviceProfile.getTenantId());
    assertEquals(0L, actualDeviceProfile.getCreatedTime());
    assertFalse(actualDeviceProfile.isDefault());
  }

  /**
   * Test {@link DeviceProfile#DeviceProfile(DeviceProfile)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link DeviceProfile#DeviceProfile()} Default is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfile(DeviceProfile); given 'true'; when DeviceProfile() Default is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.<init>(DeviceProfile)"})
  void testNewDeviceProfile_givenTrue_whenDeviceProfileDefaultIsTrue() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefault(true);

    // Act and Assert
    assertEquals(deviceProfile, new DeviceProfile(deviceProfile));
  }

  /**
   * Test {@link DeviceProfile#DeviceProfile(DeviceProfile)}.
   * <ul>
   *   <li>When {@link DeviceProfile#DeviceProfile()}.</li>
   *   <li>Then return {@link DeviceProfile#DeviceProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfile(DeviceProfile); when DeviceProfile(); then return DeviceProfile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.<init>(DeviceProfile)"})
  void testNewDeviceProfile_whenDeviceProfile_thenReturnDeviceProfile() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertEquals(deviceProfile, new DeviceProfile(deviceProfile));
  }

  /**
   * Test {@link DeviceProfile#getId()}.
   * <p>
   * Method under test: {@link DeviceProfile#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.DeviceProfileId DeviceProfile.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new DeviceProfile()).getId());
  }

  /**
   * Test {@link DeviceProfile#getCreatedTime()}.
   * <p>
   * Method under test: {@link DeviceProfile#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long DeviceProfile.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DeviceProfile()).getCreatedTime());
  }

  /**
   * Test {@link DeviceProfile#getProfileData()}.
   * <p>
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceProfileData DeviceProfile.getProfileData()"})
  void testGetProfileData() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#getProfileData()}.
   * <p>
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceProfileData DeviceProfile.getProfileData()"})
  void testGetProfileData2() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#getProfileData()}.
   * <p>
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceProfileData DeviceProfile.getProfileData()"})
  void testGetProfileData3() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#getProfileData()}.
   * <ul>
   *   <li>Given {@link DeviceProfile#DeviceProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData(); given DeviceProfile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceProfileData DeviceProfile.getProfileData()"})
  void testGetProfileData_givenDeviceProfile() {
    // Arrange, Act and Assert
    assertNull((new DeviceProfile()).getProfileData());
  }

  /**
   * Test {@link DeviceProfile#getProfileData()}.
   * <ul>
   *   <li>Given {@link DeviceProfile#DeviceProfile()} ProfileDataBytes is array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData(); given DeviceProfile() ProfileDataBytes is array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceProfileData DeviceProfile.getProfileData()"})
  void testGetProfileData_givenDeviceProfileProfileDataBytesIsArrayOfByteWithZeroAndX() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#getProfileData()}.
   * <ul>
   *   <li>Given {@link DeviceProfile#DeviceProfile()} ProfileDataBytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData(); given DeviceProfile() ProfileDataBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceProfileData DeviceProfile.getProfileData()"})
  void testGetProfileData_givenDeviceProfileProfileDataBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#getProfileData()}.
   * <ul>
   *   <li>Given {@link DeviceProfile#DeviceProfile()} ProfileDataBytes is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData(); given DeviceProfile() ProfileDataBytes is empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceProfileData DeviceProfile.getProfileData()"})
  void testGetProfileData_givenDeviceProfileProfileDataBytesIsEmptyArrayOfByte() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{});

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#getProfileData()}.
   * <ul>
   *   <li>Given {@link DeviceProfile#DeviceProfile()} ProfileDataBytes is {@code ;XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData(); given DeviceProfile() ProfileDataBytes is ';XAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceProfileData DeviceProfile.getProfileData()"})
  void testGetProfileData_givenDeviceProfileProfileDataBytesIsXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(";XAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * <p>
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(DeviceProfileData)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.setProfileData(DeviceProfileData)"})
  void testSetProfileData() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile(new DeviceProfile());

    DeviceProfileData data = new DeviceProfileData();
    data.setAlarms(new ArrayList<>());
    data.setConfiguration(mock(DeviceProfileConfiguration.class));
    data.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    data.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    // Act
    deviceProfile.setProfileData(data);

    // Assert
    assertNull(deviceProfile.getProfileDataBytes());
    assertSame(data, deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * <ul>
   *   <li>Given {@link DeviceProfileConfiguration}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(DeviceProfileData); given DeviceProfileConfiguration")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.setProfileData(DeviceProfileData)"})
  void testSetProfileData_givenDeviceProfileConfiguration() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfileData data = new DeviceProfileData();
    data.setAlarms(new ArrayList<>());
    data.setConfiguration(mock(DeviceProfileConfiguration.class));
    data.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    data.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    // Act
    deviceProfile.setProfileData(data);

    // Assert
    assertNull(deviceProfile.getProfileDataBytes());
    assertSame(data, deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * <ul>
   *   <li>Given {@link DeviceProfile#DeviceProfile()} ProfileDataBytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(DeviceProfileData); given DeviceProfile() ProfileDataBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.setProfileData(DeviceProfileData)"})
  void testSetProfileData_givenDeviceProfileProfileDataBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes("AXAXAXAX".getBytes("UTF-8"));
    DeviceProfile deviceProfile2 = new DeviceProfile(deviceProfile);

    DeviceProfileData data = new DeviceProfileData();
    data.setAlarms(new ArrayList<>());
    data.setConfiguration(mock(DeviceProfileConfiguration.class));
    data.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    data.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    // Act
    deviceProfile2.setProfileData(data);

    // Assert
    assertNull(deviceProfile2.getProfileDataBytes());
    assertSame(data, deviceProfile2.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ObjectAttributes} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(DeviceProfileData); given HashMap() 'foo' is ObjectAttributes (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.setProfileData(DeviceProfileData)"})
  void testSetProfileData_givenHashMapFooIsObjectAttributes() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(3L);
    objectAttributes.setEpmax(3L);
    objectAttributes.setEpmin(3L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(3L);
    objectAttributes.setPmin(3L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    HashMap<String, ObjectAttributes> attributeLwm2m = new HashMap<>();
    attributeLwm2m.put("foo", objectAttributes);
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        new HashSet<>(), attributeLwm2m);

    Lwm2mDeviceProfileTransportConfiguration transportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    transportConfiguration.setObserveAttr(observeAttr);

    DeviceProfileData data = new DeviceProfileData();
    data.setAlarms(new ArrayList<>());
    data.setConfiguration(new DefaultDeviceProfileConfiguration());
    data.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    data.setTransportConfiguration(transportConfiguration);

    // Act
    deviceProfile.setProfileData(data);

    // Assert
    assertNull(deviceProfile.getProfileDataBytes());
    assertSame(data, deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code null} is {@link ObjectAttributes} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(DeviceProfileData); given HashMap() 'null' is ObjectAttributes (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.setProfileData(DeviceProfileData)"})
  void testSetProfileData_givenHashMapNullIsObjectAttributes() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(3L);
    objectAttributes.setEpmax(3L);
    objectAttributes.setEpmin(3L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(3L);
    objectAttributes.setPmin(3L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    HashMap<String, ObjectAttributes> attributeLwm2m = new HashMap<>();
    attributeLwm2m.put(null, objectAttributes);
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        new HashSet<>(), attributeLwm2m);

    Lwm2mDeviceProfileTransportConfiguration transportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    transportConfiguration.setObserveAttr(observeAttr);

    DeviceProfileData data = new DeviceProfileData();
    data.setAlarms(new ArrayList<>());
    data.setConfiguration(new DefaultDeviceProfileConfiguration());
    data.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    data.setTransportConfiguration(transportConfiguration);

    // Act
    deviceProfile.setProfileData(data);

    // Assert
    assertNull(deviceProfile.getProfileDataBytes());
    assertSame(data, deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * <ul>
   *   <li>Then array length is four hundred thirty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(DeviceProfileData); then array length is four hundred thirty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.setProfileData(DeviceProfileData)"})
  void testSetProfileData_thenArrayLengthIsFourHundredThirtyEight() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    Lwm2mDeviceProfileTransportConfiguration transportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    transportConfiguration.setObserveAttr(new TelemetryMappingConfiguration());

    DeviceProfileData data = new DeviceProfileData();
    data.setAlarms(new ArrayList<>());
    data.setConfiguration(new DefaultDeviceProfileConfiguration());
    data.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    data.setTransportConfiguration(transportConfiguration);

    // Act
    deviceProfile.setProfileData(data);

    // Assert
    assertEquals(438, deviceProfile.getProfileDataBytes().length);
  }

  /**
   * Test {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * <ul>
   *   <li>Then array length is four hundred twenty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(DeviceProfileData); then array length is four hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.setProfileData(DeviceProfileData)"})
  void testSetProfileData_thenArrayLengthIsFourHundredTwentyEight() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    Lwm2mDeviceProfileTransportConfiguration transportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    transportConfiguration
        .setObserveAttr(new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>()));

    DeviceProfileData data = new DeviceProfileData();
    data.setAlarms(new ArrayList<>());
    data.setConfiguration(new DefaultDeviceProfileConfiguration());
    data.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    data.setTransportConfiguration(transportConfiguration);

    // Act
    deviceProfile.setProfileData(data);

    // Assert
    assertEquals(428, deviceProfile.getProfileDataBytes().length);
  }

  /**
   * Test {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * <ul>
   *   <li>Then array length is three hundred fifty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(DeviceProfileData); then array length is three hundred fifty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.setProfileData(DeviceProfileData)"})
  void testSetProfileData_thenArrayLengthIsThreeHundredFiftyFive() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfileData data = new DeviceProfileData();
    data.setAlarms(new ArrayList<>());
    data.setConfiguration(new DefaultDeviceProfileConfiguration());
    data.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    data.setTransportConfiguration(new Lwm2mDeviceProfileTransportConfiguration());

    // Act
    deviceProfile.setProfileData(data);

    // Assert
    assertEquals(355, deviceProfile.getProfileDataBytes().length);
  }

  /**
   * Test {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * <ul>
   *   <li>Then array length is two hundred fifty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(DeviceProfileData); then array length is two hundred fifty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.setProfileData(DeviceProfileData)"})
  void testSetProfileData_thenArrayLengthIsTwoHundredFiftyEight() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfileData data = new DeviceProfileData();
    data.setAlarms(new ArrayList<>());
    data.setConfiguration(new DefaultDeviceProfileConfiguration());
    data.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    data.setTransportConfiguration(new DefaultDeviceProfileTransportConfiguration());

    // Act
    deviceProfile.setProfileData(data);

    // Assert
    assertEquals(258, deviceProfile.getProfileDataBytes().length);
  }

  /**
   * Test {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * <ul>
   *   <li>Then {@link DeviceProfile#DeviceProfile()} ProfileData is {@link DeviceProfileData} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(DeviceProfileData); then DeviceProfile() ProfileData is DeviceProfileData (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.setProfileData(DeviceProfileData)"})
  void testSetProfileData_thenDeviceProfileProfileDataIsDeviceProfileData() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfileData data = new DeviceProfileData();
    data.setAlarms(new ArrayList<>());
    data.setConfiguration(new DefaultDeviceProfileConfiguration());
    data.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    data.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    // Act
    deviceProfile.setProfileData(data);

    // Assert
    assertNull(deviceProfile.getProfileDataBytes());
    assertSame(data, deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#setProfileData(DeviceProfileData)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link DeviceProfile#DeviceProfile()} ProfileData is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(DeviceProfileData); when 'null'; then DeviceProfile() ProfileData is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfile.setProfileData(DeviceProfileData)"})
  void testSetProfileData_whenNull_thenDeviceProfileProfileDataIsNull() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    deviceProfile.setProfileData(null);

    // Assert that nothing has changed
    assertNull(deviceProfile.getProfileDataBytes());
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}, and {@link DeviceProfile#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfile#equals(Object)}
   *   <li>{@link DeviceProfile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    DeviceProfile deviceProfile2 = new DeviceProfile();

    // Act and Assert
    assertEquals(deviceProfile, deviceProfile2);
    int expectedHashCodeResult = deviceProfile.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfile2.hashCode());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}, and {@link DeviceProfile#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfile#equals(Object)}
   *   <li>{@link DeviceProfile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertEquals(deviceProfile, deviceProfile);
    int expectedHashCodeResult = deviceProfile.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfile.hashCode());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceProfile(), 1);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setName("Name");

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setImage("Image");

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefault(true);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setType(DeviceProfileType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTransportType(DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultQueueName("Default Queue Name");

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProvisionDeviceKey("Provision Device Key");

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultEdgeRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setName("Name");

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setImage("Image");

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setType(DeviceProfileType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setTransportType(DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setProvisionType(DeviceProfileProvisionType.DISABLED);

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setDefaultRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setDefaultQueueName("Default Queue Name");

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setProvisionDeviceKey("Provision Device Key");

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setDefaultEdgeRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceProfile(), null);
  }

  /**
   * Test {@link DeviceProfile#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceProfile.equals(Object)", "int DeviceProfile.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceProfile(), "Different type to DeviceProfile");
  }
}
