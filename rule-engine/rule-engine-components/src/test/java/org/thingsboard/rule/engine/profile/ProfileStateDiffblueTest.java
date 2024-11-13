package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.device.profile.AlarmCondition;
import org.thingsboard.server.common.data.device.profile.AlarmConditionFilterKey;
import org.thingsboard.server.common.data.device.profile.AlarmConditionSpec;
import org.thingsboard.server.common.data.device.profile.AlarmConditionSpecType;
import org.thingsboard.server.common.data.device.profile.AlarmRule;
import org.thingsboard.server.common.data.device.profile.AnyTimeSchedule;
import org.thingsboard.server.common.data.device.profile.DeviceProfileAlarm;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.common.data.id.DeviceProfileId;

class ProfileStateDiffblueTest {
  /**
   * Test {@link ProfileState#ProfileState(DeviceProfile)}.
   * <ul>
   *   <li>Then return AlarmSettings is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProfileState#ProfileState(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new ProfileState(DeviceProfile); then return AlarmSettings is ArrayList()")
  void testNewProfileState_thenReturnAlarmSettingsIsArrayList() {
    // Arrange
    AlarmConditionSpec spec = mock(AlarmConditionSpec.class);
    when(spec.getType()).thenReturn(AlarmConditionSpecType.SIMPLE);

    AlarmCondition condition = new AlarmCondition();
    condition.setCondition(new ArrayList<>());
    condition.setSpec(spec);

    AlarmRule clearRule = new AlarmRule();
    clearRule.setAlarmDetails("Alarm Details");
    clearRule.setCondition(condition);
    clearRule.setDashboardId(null);
    clearRule.setSchedule(new AnyTimeSchedule());

    DeviceProfileAlarm deviceProfileAlarm = new DeviceProfileAlarm();
    deviceProfileAlarm.setAlarmType("Alarm Type");
    deviceProfileAlarm.setClearRule(clearRule);
    deviceProfileAlarm.setCreateRules(new TreeMap<>());
    deviceProfileAlarm.setId("42");
    deviceProfileAlarm.setPropagate(true);
    deviceProfileAlarm.setPropagateRelationTypes(new ArrayList<>());
    deviceProfileAlarm.setPropagateToOwner(true);
    deviceProfileAlarm.setPropagateToTenant(true);

    ArrayList<DeviceProfileAlarm> alarms = new ArrayList<>();
    alarms.add(deviceProfileAlarm);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(alarms);
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act
    ProfileState actualProfileState = new ProfileState(deviceProfile);

    // Assert
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(spec).getType();
    assertEquals(alarms, actualProfileState.getAlarmSettings());
  }

  /**
   * Test {@link ProfileState#ProfileState(DeviceProfile)}.
   * <ul>
   *   <li>Then return ProfileId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProfileState#ProfileState(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new ProfileState(DeviceProfile); then return ProfileId is 'null'")
  void testNewProfileState_thenReturnProfileIdIsNull() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act
    ProfileState actualProfileState = new ProfileState(deviceProfile);

    // Assert
    verify(deviceProfile, atLeast(1)).getProfileData();
    assertNull(actualProfileState.getProfileId());
    assertTrue(actualProfileState.getAlarmSettings().isEmpty());
    assertTrue(actualProfileState.getEntityKeys().isEmpty());
  }

  /**
   * Test {@link ProfileState#updateDeviceProfile(DeviceProfile)}.
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getProfileData()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProfileState#updateDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test updateDeviceProfile(DeviceProfile); then calls getProfileData()")
  void testUpdateDeviceProfile_thenCallsGetProfileData() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    ProfileState profileState = new ProfileState(deviceProfile);

    DeviceProfileData deviceProfileData2 = new DeviceProfileData();
    deviceProfileData2.setAlarms(new ArrayList<>());
    deviceProfileData2.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData2.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData2.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile2 = mock(DeviceProfile.class);
    when(deviceProfile2.getProfileData()).thenReturn(deviceProfileData2);

    // Act
    profileState.updateDeviceProfile(deviceProfile2);

    // Assert
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfile2, atLeast(1)).getProfileData();
  }

  /**
   * Test {@link ProfileState#getProfileId()}.
   * <ul>
   *   <li>Given {@link DeviceProfileData} (default constructor) Alarms is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProfileState#getProfileId()}
   */
  @Test
  @DisplayName("Test getProfileId(); given DeviceProfileData (default constructor) Alarms is ArrayList(); then return 'null'")
  void testGetProfileId_givenDeviceProfileDataAlarmsIsArrayList_thenReturnNull() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenReturn(null);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act
    DeviceProfileId actualProfileId = (new ProfileState(deviceProfile)).getProfileId();

    // Assert
    verify(deviceProfile).getId();
    verify(deviceProfile, atLeast(1)).getProfileData();
    assertNull(actualProfileId);
  }

  /**
   * Test {@link ProfileState#getCreateAlarmKeys(String, AlarmSeverity)}.
   * <ul>
   *   <li>Given {@link DeviceProfileData} (default constructor) Alarms is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProfileState#getCreateAlarmKeys(String, AlarmSeverity)}
   */
  @Test
  @DisplayName("Test getCreateAlarmKeys(String, AlarmSeverity); given DeviceProfileData (default constructor) Alarms is ArrayList(); then return Empty")
  void testGetCreateAlarmKeys_givenDeviceProfileDataAlarmsIsArrayList_thenReturnEmpty() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act
    Set<AlarmConditionFilterKey> actualCreateAlarmKeys = (new ProfileState(deviceProfile)).getCreateAlarmKeys("42",
        AlarmSeverity.CRITICAL);

    // Assert
    verify(deviceProfile, atLeast(1)).getProfileData();
    assertTrue(actualCreateAlarmKeys.isEmpty());
  }

  /**
   * Test {@link ProfileState#getClearAlarmKeys(String)}.
   * <ul>
   *   <li>Given {@link DeviceProfileData} (default constructor) Alarms is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProfileState#getClearAlarmKeys(String)}
   */
  @Test
  @DisplayName("Test getClearAlarmKeys(String); given DeviceProfileData (default constructor) Alarms is ArrayList(); then return Empty")
  void testGetClearAlarmKeys_givenDeviceProfileDataAlarmsIsArrayList_thenReturnEmpty() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act
    Set<AlarmConditionFilterKey> actualClearAlarmKeys = (new ProfileState(deviceProfile)).getClearAlarmKeys("42");

    // Assert
    verify(deviceProfile, atLeast(1)).getProfileData();
    assertTrue(actualClearAlarmKeys.isEmpty());
  }
}
