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
package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.transport.profile.TenantProfileUpdateResult;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.TenantProfileProto;

class DefaultTransportTenantProfileCacheDiffblueTest {
  /**
   * Test {@link DefaultTransportTenantProfileCache#put(TenantProfileProto)} with {@code proto}.
   *
   * <p>Method under test: {@link DefaultTransportTenantProfileCache#put(TenantProfileProto)}
   */
  @Test
  @DisplayName("Test put(TenantProfileProto) with 'proto'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfileUpdateResult DefaultTransportTenantProfileCache.put(TenantProfileProto)"
  })
  void testPutWithProto() throws UnsupportedEncodingException {
    // Arrange
    DefaultTransportTenantProfileCache defaultTransportTenantProfileCache =
        new DefaultTransportTenantProfileCache();

    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    TenantProfileProto proto = mock(TenantProfileProto.class);
    when(proto.getProfileData()).thenReturn(byteString);
    when(proto.getDescription()).thenReturn("The characteristics of someone or something");
    when(proto.getIsDefault()).thenReturn(true);
    when(proto.getIsolatedTbRuleEngine()).thenReturn(true);
    when(proto.hasDescription()).thenReturn(true);
    when(proto.hasProfileData()).thenReturn(true);
    when(proto.getName()).thenReturn("Name");
    when(proto.getCreatedTime()).thenReturn(1L);
    when(proto.getTenantProfileIdLSB()).thenReturn(1L);
    when(proto.getTenantProfileIdMSB()).thenReturn(1L);

    // Act
    TenantProfileUpdateResult actualPutResult = defaultTransportTenantProfileCache.put(proto);

    // Assert
    verify(byteString).toByteArray();
    verify(proto).getCreatedTime();
    verify(proto).getDescription();
    verify(proto).getIsDefault();
    verify(proto).getIsolatedTbRuleEngine();
    verify(proto).getName();
    verify(proto).getProfileData();
    verify(proto).getTenantProfileIdLSB();
    verify(proto).getTenantProfileIdMSB();
    verify(proto).hasDescription();
    verify(proto).hasProfileData();
    TenantProfile profile = actualPutResult.getProfile();
    UUID uuidId = profile.getUuidId();
    assertEquals("00000000-0000-0001-0000-000000000001", uuidId.toString());
    assertEquals("Name", profile.getName());
    assertEquals("The characteristics of someone or something", profile.getDescription());
    assertEquals(1L, profile.getCreatedTime());
    assertTrue(profile.isDefault());
    assertTrue(profile.isIsolatedTbRuleEngine());
    assertSame(uuidId, profile.getId().getId());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), profile.getProfileDataBytes());
  }

  /**
   * Test {@link DefaultTransportTenantProfileCache#put(TenantProfileProto)} with {@code proto}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return Profile ProfileDataBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportTenantProfileCache#put(TenantProfileProto)}
   */
  @Test
  @DisplayName(
      "Test put(TenantProfileProto) with 'proto'; given 'false'; then return Profile ProfileDataBytes is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfileUpdateResult DefaultTransportTenantProfileCache.put(TenantProfileProto)"
  })
  void testPutWithProto_givenFalse_thenReturnProfileProfileDataBytesIsNull() {
    // Arrange
    DefaultTransportTenantProfileCache defaultTransportTenantProfileCache =
        new DefaultTransportTenantProfileCache();

    TenantProfileProto proto = mock(TenantProfileProto.class);
    when(proto.hasDescription()).thenReturn(false);
    when(proto.hasProfileData()).thenReturn(false);
    when(proto.getIsDefault()).thenReturn(true);
    when(proto.getIsolatedTbRuleEngine()).thenReturn(true);
    when(proto.getName()).thenReturn("Name");
    when(proto.getCreatedTime()).thenReturn(1L);
    when(proto.getTenantProfileIdLSB()).thenReturn(1L);
    when(proto.getTenantProfileIdMSB()).thenReturn(1L);

    // Act
    TenantProfileUpdateResult actualPutResult = defaultTransportTenantProfileCache.put(proto);

    // Assert
    verify(proto).getCreatedTime();
    verify(proto).getIsDefault();
    verify(proto).getIsolatedTbRuleEngine();
    verify(proto).getName();
    verify(proto).getTenantProfileIdLSB();
    verify(proto).getTenantProfileIdMSB();
    verify(proto).hasDescription();
    verify(proto).hasProfileData();
    TenantProfile profile = actualPutResult.getProfile();
    UUID uuidId = profile.getUuidId();
    assertEquals("00000000-0000-0001-0000-000000000001", uuidId.toString());
    assertEquals("Name", profile.getName());
    assertNull(profile.getProfileDataBytes());
    assertNull(profile.getDescription());
    assertEquals(1L, profile.getCreatedTime());
    assertTrue(profile.isDefault());
    assertTrue(profile.isIsolatedTbRuleEngine());
    assertSame(uuidId, profile.getId().getId());
  }

  /**
   * Test {@link DefaultTransportTenantProfileCache#put(TenantProfileProto)} with {@code proto}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return Profile Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportTenantProfileCache#put(TenantProfileProto)}
   */
  @Test
  @DisplayName(
      "Test put(TenantProfileProto) with 'proto'; when DefaultInstance; then return Profile Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfileUpdateResult DefaultTransportTenantProfileCache.put(TenantProfileProto)"
  })
  void testPutWithProto_whenDefaultInstance_thenReturnProfileNameIsEmptyString() {
    // Arrange, Act and Assert
    TenantProfile profile =
        new DefaultTransportTenantProfileCache()
            .put(TenantProfileProto.getDefaultInstance())
            .getProfile();
    assertEquals("", profile.getName());
    UUID uuidId = profile.getUuidId();
    assertEquals("00000000-0000-0000-0000-000000000000", uuidId.toString());
    assertEquals(0L, profile.getCreatedTime());
    assertFalse(profile.isDefault());
    assertFalse(profile.isIsolatedTbRuleEngine());
    assertSame(uuidId, profile.getId().getId());
  }

  /**
   * Test {@link DefaultTransportTenantProfileCache#put(TenantId, TenantProfileId)} with {@code
   * tenantId}, {@code profileId}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportTenantProfileCache#put(TenantId, TenantProfileId)}
   */
  @Test
  @DisplayName(
      "Test put(TenantId, TenantProfileId) with 'tenantId', 'profileId'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTransportTenantProfileCache.put(TenantId, TenantProfileId)"})
  void testPutWithTenantIdProfileId_thenReturnFalse() {
    // Arrange
    DefaultTransportTenantProfileCache defaultTransportTenantProfileCache =
        new DefaultTransportTenantProfileCache();

    // Act and Assert
    assertFalse(defaultTransportTenantProfileCache.put(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Test {@link DefaultTransportTenantProfileCache#remove(TenantProfileId)}.
   *
   * <ul>
   *   <li>Given {@link DefaultTransportTenantProfileCache} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportTenantProfileCache#remove(TenantProfileId)}
   */
  @Test
  @DisplayName(
      "Test remove(TenantProfileId); given DefaultTransportTenantProfileCache (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set DefaultTransportTenantProfileCache.remove(TenantProfileId)"})
  void testRemove_givenDefaultTransportTenantProfileCache_thenReturnNull() {
    // Arrange
    DefaultTransportTenantProfileCache defaultTransportTenantProfileCache =
        new DefaultTransportTenantProfileCache();

    // Act
    Set<TenantId> actualRemoveResult =
        defaultTransportTenantProfileCache.remove(new TenantProfileId(UUID.randomUUID()));

    // Assert
    assertNull(actualRemoveResult);
  }
}
