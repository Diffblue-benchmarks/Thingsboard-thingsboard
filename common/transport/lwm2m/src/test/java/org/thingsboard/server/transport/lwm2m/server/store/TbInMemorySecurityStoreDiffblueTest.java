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
package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import org.eclipse.leshan.core.SecurityMode;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.security.NonUniqueSecurityInfoException;
import org.eclipse.leshan.server.security.SecurityInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.transport.lwm2m.bootstrap.secure.LwM2MBootstrapConfig;
import org.thingsboard.server.transport.lwm2m.secure.TbLwM2MSecurityInfo;

class TbInMemorySecurityStoreDiffblueTest {
  /**
   * Test new {@link TbInMemorySecurityStore} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbInMemorySecurityStore}
   */
  @Test
  @DisplayName("Test new TbInMemorySecurityStore (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbInMemorySecurityStore.<init>()"})
  void testNewTbInMemorySecurityStore() {
    // Arrange and Act
    TbInMemorySecurityStore actualTbInMemorySecurityStore = new TbInMemorySecurityStore();

    // Assert
    ReadWriteLock readWriteLock = actualTbInMemorySecurityStore.readWriteLock;
    assertTrue(readWriteLock instanceof ReentrantReadWriteLock);
    Lock lock = actualTbInMemorySecurityStore.writeLock;
    assertTrue(lock instanceof WriteLock);
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getQueueLength());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getReadHoldCount());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getReadLockCount());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getWriteHoldCount());
    assertEquals(0, ((WriteLock) lock).getHoldCount());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).hasQueuedThreads());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isFair());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isWriteLocked());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isWriteLockedByCurrentThread());
    assertFalse(((WriteLock) lock).isHeldByCurrentThread());
    assertTrue(actualTbInMemorySecurityStore.securityByEp.isEmpty());
    assertTrue(actualTbInMemorySecurityStore.securityByIdentity.isEmpty());
    Lock expectedReadLockResult = actualTbInMemorySecurityStore.readLock;
    assertSame(expectedReadLockResult, readWriteLock.readLock());
  }

  /**
   * Test {@link TbInMemorySecurityStore#getByEndpoint(String)}.
   *
   * <p>Method under test: {@link TbInMemorySecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getByEndpoint(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecurityInfo TbInMemorySecurityStore.getByEndpoint(String)"})
  void testGetByEndpoint() {
    // Arrange, Act and Assert
    assertNull(
        new TbInMemorySecurityStore().getByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbInMemorySecurityStore#getByIdentity(String)}.
   *
   * <p>Method under test: {@link TbInMemorySecurityStore#getByIdentity(String)}
   */
  @Test
  @DisplayName("Test getByIdentity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecurityInfo TbInMemorySecurityStore.getByIdentity(String)"})
  void testGetByIdentity() {
    // Arrange, Act and Assert
    assertNull(new TbInMemorySecurityStore().getByIdentity("Identity"));
  }

  /**
   * Test {@link TbInMemorySecurityStore#getByOscoreIdentity(OscoreIdentity)}.
   *
   * <p>Method under test: {@link TbInMemorySecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  @DisplayName("Test getByOscoreIdentity(OscoreIdentity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecurityInfo TbInMemorySecurityStore.getByOscoreIdentity(OscoreIdentity)"})
  void testGetByOscoreIdentity() throws UnsupportedEncodingException {
    // Arrange
    TbInMemorySecurityStore tbInMemorySecurityStore = new TbInMemorySecurityStore();

    // Act
    SecurityInfo actualByOscoreIdentity =
        tbInMemorySecurityStore.getByOscoreIdentity(
            new OscoreIdentity("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertNull(actualByOscoreIdentity);
  }

  /**
   * Test {@link TbInMemorySecurityStore#put(TbLwM2MSecurityInfo)}.
   *
   * <ul>
   *   <li>Given newX509CertInfo {@code https://config.us-east-2.amazonaws.com}.
   * </ul>
   *
   * <p>Method under test: {@link TbInMemorySecurityStore#put(TbLwM2MSecurityInfo)}
   */
  @Test
  @DisplayName(
      "Test put(TbLwM2MSecurityInfo); given newX509CertInfo 'https://config.us-east-2.amazonaws.com'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbInMemorySecurityStore.put(TbLwM2MSecurityInfo)"})
  void testPut_givenNewX509CertInfoHttpsConfigUsEast2AmazonawsCom()
      throws NonUniqueSecurityInfoException {
    // Arrange
    TbInMemorySecurityStore tbInMemorySecurityStore = new TbInMemorySecurityStore();

    TbLwM2MSecurityInfo tbSecurityInfo = new TbLwM2MSecurityInfo();
    tbSecurityInfo.setBootstrapConfig(new BootstrapConfig());
    tbSecurityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    tbSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbSecurityInfo.setSecurityInfo(
        SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    tbSecurityInfo.setSecurityMode(SecurityMode.PSK);

    // Act
    tbInMemorySecurityStore.put(tbSecurityInfo);

    // Assert
    Map<String, TbLwM2MSecurityInfo> stringTbLwM2MSecurityInfoMap =
        tbInMemorySecurityStore.securityByEp;
    assertEquals(1, stringTbLwM2MSecurityInfoMap.size());
    assertSame(
        tbSecurityInfo, stringTbLwM2MSecurityInfoMap.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbInMemorySecurityStore#put(TbLwM2MSecurityInfo)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbLwM2MSecurityInfo} (default constructor) SecurityInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbInMemorySecurityStore#put(TbLwM2MSecurityInfo)}
   */
  @Test
  @DisplayName(
      "Test put(TbLwM2MSecurityInfo); given 'null'; when TbLwM2MSecurityInfo (default constructor) SecurityInfo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbInMemorySecurityStore.put(TbLwM2MSecurityInfo)"})
  void testPut_givenNull_whenTbLwM2MSecurityInfoSecurityInfoIsNull()
      throws NonUniqueSecurityInfoException {
    // Arrange
    TbInMemorySecurityStore tbInMemorySecurityStore = new TbInMemorySecurityStore();

    TbLwM2MSecurityInfo tbSecurityInfo = new TbLwM2MSecurityInfo();
    tbSecurityInfo.setBootstrapConfig(new BootstrapConfig());
    tbSecurityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    tbSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbSecurityInfo.setSecurityMode(SecurityMode.PSK);
    tbSecurityInfo.setSecurityInfo(null);

    // Act
    tbInMemorySecurityStore.put(tbSecurityInfo);

    // Assert
    Map<String, TbLwM2MSecurityInfo> stringTbLwM2MSecurityInfoMap =
        tbInMemorySecurityStore.securityByEp;
    assertEquals(1, stringTbLwM2MSecurityInfoMap.size());
    assertSame(
        tbSecurityInfo, stringTbLwM2MSecurityInfoMap.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbInMemorySecurityStore#getTbLwM2MSecurityInfoByEndpoint(String)}.
   *
   * <p>Method under test: {@link TbInMemorySecurityStore#getTbLwM2MSecurityInfoByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getTbLwM2MSecurityInfoByEndpoint(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbLwM2MSecurityInfo TbInMemorySecurityStore.getTbLwM2MSecurityInfoByEndpoint(String)"
  })
  void testGetTbLwM2MSecurityInfoByEndpoint() {
    // Arrange, Act and Assert
    assertNull(
        new TbInMemorySecurityStore()
            .getTbLwM2MSecurityInfoByEndpoint("https://config.us-east-2.amazonaws.com"));
  }
}
