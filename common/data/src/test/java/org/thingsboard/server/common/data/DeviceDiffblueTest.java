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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.data.CoapDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.DefaultDeviceConfiguration;
import org.thingsboard.server.common.data.device.data.DefaultDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.DeviceConfiguration;
import org.thingsboard.server.common.data.device.data.DeviceData;
import org.thingsboard.server.common.data.device.data.DeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceDiffblueTest {
  /**
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  void testUpdateDevice() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertSame(device, device.updateDevice(new Device()));
  }

  /**
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  void testUpdateDevice2() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertSame(device, device.updateDevice(new Device(new Device())));
  }

  /**
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  void testUpdateDevice3() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertSame(device, device.updateDevice(device2));
  }

  /**
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  void testUpdateDevice4() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertSame(device, device.updateDevice(new Device(new Device(new Device()))));
  }

  /**
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  void testUpdateDevice5() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertSame(device, device.updateDevice(device2));
  }

  /**
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  void testUpdateDevice6() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertSame(device, device.updateDevice(device2));
  }

  /**
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  void testUpdateDevice7() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertSame(device, device.updateDevice(device2));
  }

  /**
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  void testUpdateDevice8() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[]{});

    // Act and Assert
    assertSame(device, device.updateDevice(device2));
  }

  /**
   * Method under test: {@link Device#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new Device()).getId());
  }

  /**
   * Method under test: {@link Device#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Device()).getCreatedTime());
  }

  /**
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  void testGetDeviceData() {
    // Arrange, Act and Assert
    assertNull((new Device()).getDeviceData());
  }

  /**
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  void testGetDeviceData2() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  void testGetDeviceData3() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  void testGetDeviceData4() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  void testGetDeviceData5() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  void testGetDeviceData6() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  void testGetDeviceData7() {
    // Arrange
    Device device = new Device(new Device());
    device.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  void testGetDeviceData8() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  void testGetDeviceData9() {
    // Arrange
    Device device = new Device(new Device(new Device()));
    device.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  void testGetDeviceData10() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  void testSetDeviceData() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(mock(DeviceConfiguration.class));
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    device.setDeviceData(data);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertSame(data, device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  void testSetDeviceData2() {
    // Arrange
    Device device = new Device();

    // Act
    device.setDeviceData(null);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertNull(device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  void testSetDeviceData3() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();

    DeviceData data = new DeviceData();
    data.setConfiguration(mock(DeviceConfiguration.class));
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    deviceInfo.setDeviceData(data);

    // Assert
    assertSame(data, deviceInfo.getDeviceData());
  }

  /**
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  void testSetDeviceData4() {
    // Arrange
    Device device = new Device(new Device());

    DeviceData data = new DeviceData();
    data.setConfiguration(mock(DeviceConfiguration.class));
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    device.setDeviceData(data);

    // Assert
    assertSame(data, device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  void testSetDeviceData5() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    device.setDeviceData(data);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertSame(data, device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  void testSetDeviceData6() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(new DefaultDeviceTransportConfiguration());

    // Act
    device.setDeviceData(data);

    // Assert
    byte[] deviceDataBytes = device.getDeviceDataBytes();
    assertEquals(80, deviceDataBytes.length);
    assertEquals(':', deviceDataBytes[24]);
    assertEquals(':', deviceDataBytes[60]);
    assertEquals(':', deviceDataBytes[68]);
    assertEquals(':', deviceDataBytes[Short.SIZE]);
    assertEquals('A', deviceDataBytes[73]);
    assertEquals('D', deviceDataBytes[70]);
    assertEquals('E', deviceDataBytes[71]);
    assertEquals('F', deviceDataBytes[72]);
    assertEquals('L', deviceDataBytes[75]);
    assertEquals('T', deviceDataBytes[76]);
    assertEquals('U', deviceDataBytes[74]);
    assertEquals('"', deviceDataBytes[1]);
    assertEquals('"', deviceDataBytes[15]);
    assertEquals('"', deviceDataBytes[18]);
    assertEquals('"', deviceDataBytes[23]);
    assertEquals('"', deviceDataBytes[59]);
    assertEquals('"', deviceDataBytes[62]);
    assertEquals('"', deviceDataBytes[67]);
    assertEquals('"', deviceDataBytes[69]);
    assertEquals('"', deviceDataBytes[77]);
    assertEquals('a', deviceDataBytes[10]);
    assertEquals('c', deviceDataBytes[2]);
    assertEquals('e', deviceDataBytes[22]);
    assertEquals('e', deviceDataBytes[66]);
    assertEquals('f', deviceDataBytes[5]);
    assertEquals('g', deviceDataBytes[7]);
    assertEquals('i', deviceDataBytes[12]);
    assertEquals('i', deviceDataBytes[56]);
    assertEquals('i', deviceDataBytes[6]);
    assertEquals('n', deviceDataBytes[14]);
    assertEquals('n', deviceDataBytes[4]);
    assertEquals('n', deviceDataBytes[58]);
    assertEquals('o', deviceDataBytes[13]);
    assertEquals('o', deviceDataBytes[3]);
    assertEquals('o', deviceDataBytes[57]);
    assertEquals('p', deviceDataBytes[21]);
    assertEquals('p', deviceDataBytes[65]);
    assertEquals('r', deviceDataBytes[9]);
    assertEquals('t', deviceDataBytes[11]);
    assertEquals('t', deviceDataBytes[19]);
    assertEquals('t', deviceDataBytes[55]);
    assertEquals('t', deviceDataBytes[63]);
    assertEquals('u', deviceDataBytes[8]);
    assertEquals('y', deviceDataBytes[20]);
    assertEquals('y', deviceDataBytes[Double.SIZE]);
    assertEquals('{', deviceDataBytes[0]);
    assertEquals('{', deviceDataBytes[17]);
    assertEquals('{', deviceDataBytes[61]);
    assertEquals('}', deviceDataBytes[78]);
    assertEquals('}', deviceDataBytes[79]);
    assertSame(data, device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  void testSetDeviceData7() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(new CoapDeviceTransportConfiguration());

    // Act
    device.setDeviceData(data);

    // Assert
    byte[] deviceDataBytes = device.getDeviceDataBytes();
    assertEquals(167, deviceDataBytes.length);
    assertEquals(':', deviceDataBytes[160]);
    assertEquals(':', deviceDataBytes[24]);
    assertEquals(':', deviceDataBytes[Short.SIZE]);
    assertEquals('W', deviceDataBytes[153]);
    assertEquals('"', deviceDataBytes[1]);
    assertEquals('"', deviceDataBytes[15]);
    assertEquals('"', deviceDataBytes[159]);
    assertEquals('"', deviceDataBytes[18]);
    assertEquals('"', deviceDataBytes[23]);
    assertEquals('a', deviceDataBytes[10]);
    assertEquals('a', deviceDataBytes[143]);
    assertEquals('c', deviceDataBytes[2]);
    assertEquals('d', deviceDataBytes[156]);
    assertEquals('e', deviceDataBytes[22]);
    assertEquals('f', deviceDataBytes[5]);
    assertEquals('g', deviceDataBytes[7]);
    assertEquals('i', deviceDataBytes[12]);
    assertEquals('i', deviceDataBytes[147]);
    assertEquals('i', deviceDataBytes[150]);
    assertEquals('i', deviceDataBytes[154]);
    assertEquals('i', deviceDataBytes[6]);
    assertEquals('l', deviceDataBytes[163]);
    assertEquals('l', deviceDataBytes[164]);
    assertEquals('m', deviceDataBytes[146]);
    assertEquals('n', deviceDataBytes[14]);
    assertEquals('n', deviceDataBytes[144]);
    assertEquals('n', deviceDataBytes[152]);
    assertEquals('n', deviceDataBytes[155]);
    assertEquals('n', deviceDataBytes[161]);
    assertEquals('n', deviceDataBytes[4]);
    assertEquals('o', deviceDataBytes[13]);
    assertEquals('o', deviceDataBytes[151]);
    assertEquals('o', deviceDataBytes[157]);
    assertEquals('o', deviceDataBytes[3]);
    assertEquals('p', deviceDataBytes[21]);
    assertEquals('r', deviceDataBytes[142]);
    assertEquals('r', deviceDataBytes[9]);
    assertEquals('s', deviceDataBytes[145]);
    assertEquals('s', deviceDataBytes[148]);
    assertEquals('s', deviceDataBytes[149]);
    assertEquals('t', deviceDataBytes[11]);
    assertEquals('t', deviceDataBytes[19]);
    assertEquals('u', deviceDataBytes[162]);
    assertEquals('u', deviceDataBytes[8]);
    assertEquals('w', deviceDataBytes[158]);
    assertEquals('y', deviceDataBytes[20]);
    assertEquals('{', deviceDataBytes[0]);
    assertEquals('{', deviceDataBytes[17]);
    assertEquals('}', deviceDataBytes[165]);
    assertEquals('}', deviceDataBytes[166]);
    assertSame(data, device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  void testSetDeviceData8() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(new SnmpDeviceTransportConfiguration());

    // Act
    device.setDeviceData(data);

    // Assert
    byte[] deviceDataBytes = device.getDeviceDataBytes();
    assertEquals(333, deviceDataBytes.length);
    assertEquals(',', deviceDataBytes[315]);
    assertEquals(':', deviceDataBytes[24]);
    assertEquals(':', deviceDataBytes[310]);
    assertEquals(':', deviceDataBytes[326]);
    assertEquals(':', deviceDataBytes[Short.SIZE]);
    assertEquals('I', deviceDataBytes[323]);
    assertEquals('"', deviceDataBytes[1]);
    assertEquals('"', deviceDataBytes[15]);
    assertEquals('"', deviceDataBytes[18]);
    assertEquals('"', deviceDataBytes[23]);
    assertEquals('"', deviceDataBytes[309]);
    assertEquals('"', deviceDataBytes[316]);
    assertEquals('"', deviceDataBytes[325]);
    assertEquals('a', deviceDataBytes[10]);
    assertEquals('c', deviceDataBytes[2]);
    assertEquals('d', deviceDataBytes[324]);
    assertEquals('e', deviceDataBytes[22]);
    assertEquals('e', deviceDataBytes[308]);
    assertEquals('e', deviceDataBytes[317]);
    assertEquals('e', deviceDataBytes[322]);
    assertEquals('f', deviceDataBytes[5]);
    assertEquals('g', deviceDataBytes[319]);
    assertEquals('g', deviceDataBytes[7]);
    assertEquals('i', deviceDataBytes[12]);
    assertEquals('i', deviceDataBytes[320]);
    assertEquals('i', deviceDataBytes[6]);
    assertEquals('l', deviceDataBytes[313]);
    assertEquals('l', deviceDataBytes[314]);
    assertEquals('l', deviceDataBytes[329]);
    assertEquals('l', deviceDataBytes[330]);
    assertEquals('n', deviceDataBytes[14]);
    assertEquals('n', deviceDataBytes[311]);
    assertEquals('n', deviceDataBytes[318]);
    assertEquals('n', deviceDataBytes[321]);
    assertEquals('n', deviceDataBytes[327]);
    assertEquals('n', deviceDataBytes[4]);
    assertEquals('o', deviceDataBytes[13]);
    assertEquals('o', deviceDataBytes[3]);
    assertEquals('p', deviceDataBytes[21]);
    assertEquals('r', deviceDataBytes[9]);
    assertEquals('t', deviceDataBytes[11]);
    assertEquals('t', deviceDataBytes[19]);
    assertEquals('u', deviceDataBytes[312]);
    assertEquals('u', deviceDataBytes[328]);
    assertEquals('u', deviceDataBytes[8]);
    assertEquals('y', deviceDataBytes[20]);
    assertEquals('{', deviceDataBytes[0]);
    assertEquals('{', deviceDataBytes[17]);
    assertEquals('}', deviceDataBytes[331]);
    assertEquals('}', deviceDataBytes[332]);
    assertSame(data, device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  void testSetDeviceData9() {
    // Arrange
    Device device = new Device();

    CoapDeviceTransportConfiguration transportConfiguration = new CoapDeviceTransportConfiguration();
    transportConfiguration.put("org.thingsboard.server.common.data.device.data.CoapDeviceTransportConfiguration",
        "Value");

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(transportConfiguration);

    // Act
    device.setDeviceData(data);

    // Assert
    byte[] deviceDataBytes = device.getDeviceDataBytes();
    assertEquals(257, deviceDataBytes.length);
    assertEquals(':', deviceDataBytes[24]);
    assertEquals(':', deviceDataBytes[247]);
    assertEquals(':', deviceDataBytes[Short.SIZE]);
    assertEquals('C', deviceDataBytes[233]);
    assertEquals('V', deviceDataBytes[249]);
    assertEquals('"', deviceDataBytes[1]);
    assertEquals('"', deviceDataBytes[15]);
    assertEquals('"', deviceDataBytes[18]);
    assertEquals('"', deviceDataBytes[23]);
    assertEquals('"', deviceDataBytes[246]);
    assertEquals('"', deviceDataBytes[248]);
    assertEquals('"', deviceDataBytes[254]);
    assertEquals('a', deviceDataBytes[10]);
    assertEquals('a', deviceDataBytes[241]);
    assertEquals('a', deviceDataBytes[250]);
    assertEquals('c', deviceDataBytes[2]);
    assertEquals('e', deviceDataBytes[22]);
    assertEquals('e', deviceDataBytes[253]);
    assertEquals('f', deviceDataBytes[236]);
    assertEquals('f', deviceDataBytes[5]);
    assertEquals('g', deviceDataBytes[238]);
    assertEquals('g', deviceDataBytes[7]);
    assertEquals('i', deviceDataBytes[12]);
    assertEquals('i', deviceDataBytes[237]);
    assertEquals('i', deviceDataBytes[243]);
    assertEquals('i', deviceDataBytes[6]);
    assertEquals('l', deviceDataBytes[251]);
    assertEquals('n', deviceDataBytes[14]);
    assertEquals('n', deviceDataBytes[235]);
    assertEquals('n', deviceDataBytes[245]);
    assertEquals('n', deviceDataBytes[4]);
    assertEquals('o', deviceDataBytes[13]);
    assertEquals('o', deviceDataBytes[234]);
    assertEquals('o', deviceDataBytes[244]);
    assertEquals('o', deviceDataBytes[3]);
    assertEquals('p', deviceDataBytes[21]);
    assertEquals('r', deviceDataBytes[240]);
    assertEquals('r', deviceDataBytes[9]);
    assertEquals('t', deviceDataBytes[11]);
    assertEquals('t', deviceDataBytes[19]);
    assertEquals('t', deviceDataBytes[232]);
    assertEquals('t', deviceDataBytes[242]);
    assertEquals('u', deviceDataBytes[239]);
    assertEquals('u', deviceDataBytes[252]);
    assertEquals('u', deviceDataBytes[8]);
    assertEquals('y', deviceDataBytes[20]);
    assertEquals('{', deviceDataBytes[0]);
    assertEquals('{', deviceDataBytes[17]);
    assertEquals('}', deviceDataBytes[255]);
    assertEquals('}', deviceDataBytes[256]);
    assertSame(data, device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  void testSetDeviceData10() {
    // Arrange
    Device device = new Device();

    CoapDeviceTransportConfiguration transportConfiguration = new CoapDeviceTransportConfiguration();
    transportConfiguration.put(null, "Value");

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(transportConfiguration);

    // Act
    device.setDeviceData(data);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertSame(data, device.getDeviceData());
  }

  /**
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  void testSetDeviceData11() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(null);
    data.setTransportConfiguration(null);

    // Act
    device.setDeviceData(data);

    // Assert
    assertSame(data, device.getDeviceData());
    byte[] expectedDeviceDataBytes = "{\"configuration\":null,\"transportConfiguration\":null}".getBytes("UTF-8");
    assertArrayEquals(expectedDeviceDataBytes, device.getDeviceDataBytes());
  }

  /**
   * Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new Device()).getAdditionalInfo());
  }

  /**
   * Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Device(new Device())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo3() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Device(new Device(new Device()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo4() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    JsonNode actualAdditionalInfo = (new Device(device)).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Device#equals(Object)}
   *   <li>{@link Device#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Device device = new Device();
    Device device2 = new Device();

    // Act and Assert
    assertEquals(device, device2);
    int expectedHashCodeResult = device.hashCode();
    assertEquals(expectedHashCodeResult, device2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Device#equals(Object)}
   *   <li>{@link Device#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertEquals(device, device);
    int expectedHashCodeResult = device.hashCode();
    assertEquals(expectedHashCodeResult, device.hashCode());
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();

    // Act and Assert
    assertNotEquals(deviceInfo, new Device());
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Device device = new Device(new Device());

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertNotEquals(device, new DeviceInfo());
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange, Act and Assert
    assertNotEquals(new Device(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Device device = new Device();
    device.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Device device = new Device();
    device.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Device device = new Device();
    device.setName("Name");

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Device device = new Device();
    device.setType("Type");

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Device device = new Device();
    device.setLabel("Label");

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Device device = new Device();
    device.setVersion(1L);

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setName("Name");

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setType("Type");

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setLabel("Label");

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setVersion(1L);

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Device(), null);
  }

  /**
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Device(), "Different type to Device");
  }

  /**
   * Method under test: {@link Device#getExternalId()}
   */
  @Test
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new Device()).getExternalId());
  }

  /**
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  void testNewDevice() throws IOException {
    // Arrange and Act
    Device actualDevice = new Device(new Device());

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDevice.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  void testNewDevice2() throws IOException {
    // Arrange
    Device device = new Device(new Device());

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(device.getDeviceDataBytes());
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(device.getVersion());
    assertNull(actualDevice.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(device.getLabel());
    assertNull(actualDevice.getLabel());
    assertNull(device.getName());
    assertNull(actualDevice.getName());
    assertNull(device.getType());
    assertNull(actualDevice.getType());
    assertNull(device.getUuidId());
    assertNull(actualDevice.getUuidId());
    assertNull(device.getDeviceData());
    assertNull(actualDevice.getDeviceData());
    assertNull(device.getCustomerId());
    assertNull(actualDevice.getCustomerId());
    assertNull(device.getExternalId());
    assertNull(actualDevice.getExternalId());
    assertNull(device.getId());
    assertNull(actualDevice.getId());
    assertNull(device.getDeviceProfileId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(device.getFirmwareId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(device.getSoftwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(device.getTenantId());
    assertNull(actualDevice.getTenantId());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, device.getCreatedTime());
    assertEquals(0L, actualDevice.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  void testNewDevice3() throws IOException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDevice.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  void testNewDevice4() throws IOException {
    // Arrange
    Device device = new Device(new Device(new Device()));

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(device.getDeviceDataBytes());
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(device.getVersion());
    assertNull(actualDevice.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(device.getLabel());
    assertNull(actualDevice.getLabel());
    assertNull(device.getName());
    assertNull(actualDevice.getName());
    assertNull(device.getType());
    assertNull(actualDevice.getType());
    assertNull(device.getUuidId());
    assertNull(actualDevice.getUuidId());
    assertNull(device.getDeviceData());
    assertNull(actualDevice.getDeviceData());
    assertNull(device.getCustomerId());
    assertNull(actualDevice.getCustomerId());
    assertNull(device.getExternalId());
    assertNull(actualDevice.getExternalId());
    assertNull(device.getId());
    assertNull(actualDevice.getId());
    assertNull(device.getDeviceProfileId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(device.getFirmwareId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(device.getSoftwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(device.getTenantId());
    assertNull(actualDevice.getTenantId());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, device.getCreatedTime());
    assertEquals(0L, actualDevice.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  void testNewDevice5() throws IOException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDevice.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  void testNewDevice6() throws IOException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDevice.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  void testNewDevice7() throws IOException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDevice.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  void testNewDevice8() throws IOException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDevice.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }
}
