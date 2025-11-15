/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceProfileDiffblueTest {
  /**
   * Method under test: {@link DeviceProfile#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new DeviceProfile()).getId());
  }

  /**
   * Method under test: {@link DeviceProfile#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DeviceProfile()).getCreatedTime());
  }

  /**
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  void testGetProfileData() {
    // Arrange, Act and Assert
    assertNull((new DeviceProfile()).getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  void testGetProfileData2() throws UnsupportedEncodingException {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  void testGetProfileData3() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  void testGetProfileData4() throws UnsupportedEncodingException {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(";XAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  void testGetProfileData5() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  void testGetProfileData6() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{});

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  void testGetProfileData7() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#getProfileData()}
   */
  @Test
  void testGetProfileData8() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  void testSetProfileData() {
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
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  void testSetProfileData2() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    deviceProfile.setProfileData(null);

    // Assert
    assertNull(deviceProfile.getProfileDataBytes());
    assertNull(deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  void testSetProfileData3() {
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
    assertSame(data, deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  void testSetProfileData4() {
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
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  void testSetProfileData5() {
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
    byte[] profileDataBytes = deviceProfile.getProfileDataBytes();
    assertEquals(258, profileDataBytes.length);
    assertEquals(',', profileDataBytes[245]);
    assertEquals(':', profileDataBytes[238]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[254]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('[', profileDataBytes[255]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('"', profileDataBytes[237]);
    assertEquals('"', profileDataBytes[246]);
    assertEquals('"', profileDataBytes[253]);
    assertEquals(']', profileDataBytes[256]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[234]);
    assertEquals('a', profileDataBytes[240]);
    assertEquals('a', profileDataBytes[247]);
    assertEquals('a', profileDataBytes[249]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('c', profileDataBytes[233]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('e', profileDataBytes[236]);
    assertEquals('e', profileDataBytes[243]);
    assertEquals('f', profileDataBytes[239]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[241]);
    assertEquals('l', profileDataBytes[248]);
    assertEquals('m', profileDataBytes[251]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('r', profileDataBytes[250]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('s', profileDataBytes[242]);
    assertEquals('s', profileDataBytes[252]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('t', profileDataBytes[235]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[244]);
    assertEquals('}', profileDataBytes[257]);
    assertSame(data, deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  void testSetProfileData6() {
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
    byte[] profileDataBytes = deviceProfile.getProfileDataBytes();
    assertEquals(355, profileDataBytes.length);
    assertEquals(',', profileDataBytes[342]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[335]);
    assertEquals(':', profileDataBytes[351]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('[', profileDataBytes[352]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('"', profileDataBytes[334]);
    assertEquals('"', profileDataBytes[343]);
    assertEquals('"', profileDataBytes[350]);
    assertEquals(']', profileDataBytes[353]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[331]);
    assertEquals('a', profileDataBytes[337]);
    assertEquals('a', profileDataBytes[344]);
    assertEquals('a', profileDataBytes[346]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('c', profileDataBytes[330]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('e', profileDataBytes[333]);
    assertEquals('e', profileDataBytes[340]);
    assertEquals('f', profileDataBytes[336]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[338]);
    assertEquals('l', profileDataBytes[345]);
    assertEquals('m', profileDataBytes[348]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('r', profileDataBytes[347]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('s', profileDataBytes[339]);
    assertEquals('s', profileDataBytes[349]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('t', profileDataBytes[332]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[341]);
    assertEquals('}', profileDataBytes[354]);
    assertSame(data, deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  void testSetProfileData7() throws UnsupportedEncodingException {
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
    assertSame(data, deviceProfile2.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  void testSetProfileData8() {
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
    byte[] profileDataBytes = deviceProfile.getProfileDataBytes();
    assertEquals(438, profileDataBytes.length);
    assertEquals(',', profileDataBytes[425]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[418]);
    assertEquals(':', profileDataBytes[434]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('[', profileDataBytes[435]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('"', profileDataBytes[417]);
    assertEquals('"', profileDataBytes[426]);
    assertEquals('"', profileDataBytes[433]);
    assertEquals(']', profileDataBytes[436]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[414]);
    assertEquals('a', profileDataBytes[420]);
    assertEquals('a', profileDataBytes[427]);
    assertEquals('a', profileDataBytes[429]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('c', profileDataBytes[413]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('e', profileDataBytes[416]);
    assertEquals('e', profileDataBytes[423]);
    assertEquals('f', profileDataBytes[419]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[421]);
    assertEquals('l', profileDataBytes[428]);
    assertEquals('m', profileDataBytes[431]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('r', profileDataBytes[430]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('s', profileDataBytes[422]);
    assertEquals('s', profileDataBytes[432]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('t', profileDataBytes[415]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[424]);
    assertEquals('}', profileDataBytes[437]);
    assertSame(data, deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  void testSetProfileData9() {
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
    byte[] profileDataBytes = deviceProfile.getProfileDataBytes();
    assertEquals(428, profileDataBytes.length);
    assertEquals(',', profileDataBytes[415]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[408]);
    assertEquals(':', profileDataBytes[424]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('[', profileDataBytes[425]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('"', profileDataBytes[407]);
    assertEquals('"', profileDataBytes[416]);
    assertEquals('"', profileDataBytes[423]);
    assertEquals(']', profileDataBytes[426]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[404]);
    assertEquals('a', profileDataBytes[410]);
    assertEquals('a', profileDataBytes[417]);
    assertEquals('a', profileDataBytes[419]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('c', profileDataBytes[403]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('e', profileDataBytes[406]);
    assertEquals('e', profileDataBytes[413]);
    assertEquals('f', profileDataBytes[409]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[411]);
    assertEquals('l', profileDataBytes[418]);
    assertEquals('m', profileDataBytes[421]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('r', profileDataBytes[420]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('s', profileDataBytes[412]);
    assertEquals('s', profileDataBytes[422]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('t', profileDataBytes[405]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[414]);
    assertEquals('}', profileDataBytes[427]);
    assertSame(data, deviceProfile.getProfileData());
  }

  /**
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  void testSetProfileData10() {
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
   * Method under test: {@link DeviceProfile#setProfileData(DeviceProfileData)}
   */
  @Test
  void testSetProfileData11() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfile#equals(Object)}
   *   <li>{@link DeviceProfile#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfile#equals(Object)}
   *   <li>{@link DeviceProfile#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertEquals(deviceProfile, deviceProfile);
    int expectedHashCodeResult = deviceProfile.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfile.hashCode());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceProfile(), 1);
    assertNotEquals(new DeviceProfile(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setName("Name");

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setImage("Image");

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefault(true);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setType(DeviceProfileType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTransportType(DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultQueueName("Default Queue Name");

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProvisionDeviceKey("Provision Device Key");

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultEdgeRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(deviceProfile, new DeviceProfile());
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setName("Name");

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setImage("Image");

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setType(DeviceProfileType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setTransportType(DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setProvisionType(DeviceProfileProvisionType.DISABLED);

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setDefaultRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setDefaultQueueName("Default Queue Name");

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setProvisionDeviceKey("Provision Device Key");

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setDefaultEdgeRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceProfile, deviceProfile2);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceProfile(), null);
  }

  /**
   * Method under test: {@link DeviceProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceProfile(), "Different type to DeviceProfile");
  }

  /**
   * Method under test: {@link DeviceProfile#getExternalId()}
   */
  @Test
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new DeviceProfile()).getExternalId());
  }

  /**
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  void testNewDeviceProfile() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertEquals(deviceProfile, new DeviceProfile(deviceProfile));
  }

  /**
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  void testNewDeviceProfile2() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefault(true);

    // Act and Assert
    assertEquals(deviceProfile, new DeviceProfile(deviceProfile));
  }

  /**
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  void testNewDeviceProfile3() {
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
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  void testNewDeviceProfile4() {
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
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  void testNewDeviceProfile5() {
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
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  void testNewDeviceProfile6() {
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
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  void testNewDeviceProfile7() {
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
   * Method under test: {@link DeviceProfile#DeviceProfile(DeviceProfile)}
   */
  @Test
  void testNewDeviceProfile8() {
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
}
