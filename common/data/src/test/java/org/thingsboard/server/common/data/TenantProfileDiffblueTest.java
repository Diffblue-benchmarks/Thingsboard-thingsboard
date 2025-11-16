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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.queue.ProcessingStrategy;
import org.thingsboard.server.common.data.queue.ProcessingStrategyType;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;

class TenantProfileDiffblueTest {
  /**
   * Test {@link TenantProfile#TenantProfile(TenantProfile)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and three.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName("Test new TenantProfile(TenantProfile); given array of byte with 'A' and three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.<init>(TenantProfile)"})
  void testNewTenantProfile_givenArrayOfByteWithAAndThree() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, actualTenantProfile.createdTime);
    assertEquals(1905, actualTenantProfile.getProfileDataBytes().length);
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link TenantProfile#TenantProfile(TenantProfile)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and zero.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName("Test new TenantProfile(TenantProfile); given array of byte with 'A' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.<init>(TenantProfile)"})
  void testNewTenantProfile_givenArrayOfByteWithAAndZero() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {'A', 0, 'A', 3, 'A', 3, 'A', 3});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, actualTenantProfile.createdTime);
    assertEquals(1905, actualTenantProfile.getProfileDataBytes().length);
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link TenantProfile#TenantProfile(TenantProfile)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code ;} and three.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName("Test new TenantProfile(TenantProfile); given array of byte with ';' and three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.<init>(TenantProfile)"})
  void testNewTenantProfile_givenArrayOfByteWithSemicolonAndThree() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {';', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, actualTenantProfile.createdTime);
    assertEquals(1905, actualTenantProfile.getProfileDataBytes().length);
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link TenantProfile#TenantProfile(TenantProfile)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with three and three.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName("Test new TenantProfile(TenantProfile); given array of byte with three and three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.<init>(TenantProfile)"})
  void testNewTenantProfile_givenArrayOfByteWithThreeAndThree() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {3, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, actualTenantProfile.createdTime);
    assertEquals(1905, actualTenantProfile.getProfileDataBytes().length);
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link TenantProfile#TenantProfile(TenantProfile)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and three.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName("Test new TenantProfile(TenantProfile); given array of byte with zero and three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.<init>(TenantProfile)"})
  void testNewTenantProfile_givenArrayOfByteWithZeroAndThree() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {0, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, actualTenantProfile.createdTime);
    assertEquals(1905, actualTenantProfile.getProfileDataBytes().length);
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link TenantProfile#TenantProfile(TenantProfile)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName("Test new TenantProfile(TenantProfile); given empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.<init>(TenantProfile)"})
  void testNewTenantProfile_givenEmptyArrayOfByte() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, actualTenantProfile.createdTime);
    assertEquals(1905, actualTenantProfile.getProfileDataBytes().length);
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link TenantProfile#TenantProfile(TenantProfile)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link TenantProfile#TenantProfile()} Default is {@code true}.
   *   <li>Then return Default.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName(
      "Test new TenantProfile(TenantProfile); given 'true'; when TenantProfile() Default is 'true'; then return Default")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.<init>(TenantProfile)"})
  void testNewTenantProfile_givenTrue_whenTenantProfileDefaultIsTrue_thenReturnDefault() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDefault(true);

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, actualTenantProfile.createdTime);
    assertEquals(1905, actualTenantProfile.getProfileDataBytes().length);
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
    assertTrue(actualTenantProfile.isDefault());
  }

  /**
   * Test {@link TenantProfile#TenantProfile(TenantProfile)}.
   *
   * <ul>
   *   <li>Then return {@link TenantProfile#TenantProfile(TenantProfile)} with tenantProfile is
   *       {@link TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName(
      "Test new TenantProfile(TenantProfile); then return TenantProfile(TenantProfile) with tenantProfile is TenantProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.<init>(TenantProfile)"})
  void testNewTenantProfile_thenReturnTenantProfileWithTenantProfileIsTenantProfile() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile(new TenantProfile());

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    assertEquals(tenantProfile, actualTenantProfile);
  }

  /**
   * Test {@link TenantProfile#TenantProfile(TenantProfile)}.
   *
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.
   *   <li>Then return not Default.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName(
      "Test new TenantProfile(TenantProfile); when TenantProfile(); then return not Default")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.<init>(TenantProfile)"})
  void testNewTenantProfile_whenTenantProfile_thenReturnNotDefault() {
    // Arrange and Act
    TenantProfile actualTenantProfile = new TenantProfile(new TenantProfile());

    // Assert
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, actualTenantProfile.createdTime);
    assertEquals(1905, actualTenantProfile.getProfileDataBytes().length);
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link TenantProfile#getId()}.
   *
   * <p>Method under test: {@link TenantProfile#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.TenantProfileId TenantProfile.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new TenantProfile().getId());
  }

  /**
   * Test {@link TenantProfile#getCreatedTime()}.
   *
   * <p>Method under test: {@link TenantProfile#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TenantProfile.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new TenantProfile().getCreatedTime());
  }

  /**
   * Test {@link TenantProfile#getProfileData()}.
   *
   * <p>Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileData TenantProfile.getProfileData()"})
  void testGetProfileData() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    assertTrue(actualProfileData.getConfiguration() instanceof DefaultTenantProfileConfiguration);
    assertNull(actualProfileData.getQueueConfiguration());
  }

  /**
   * Test {@link TenantProfile#getProfileData()}.
   *
   * <p>Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileData TenantProfile.getProfileData()"})
  void testGetProfileData2() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    assertTrue(actualProfileData.getConfiguration() instanceof DefaultTenantProfileConfiguration);
    assertNull(actualProfileData.getQueueConfiguration());
  }

  /**
   * Test {@link TenantProfile#getProfileData()}.
   *
   * <p>Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileData TenantProfile.getProfileData()"})
  void testGetProfileData3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    assertTrue(actualProfileData.getConfiguration() instanceof DefaultTenantProfileConfiguration);
    assertNull(actualProfileData.getQueueConfiguration());
  }

  /**
   * Test {@link TenantProfile#getProfileData()}.
   *
   * <ul>
   *   <li>Given {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData(); given ';'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileData TenantProfile.getProfileData()"})
  void testGetProfileData_givenSemicolon() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {0, 0, 'A', ';', 'A', 'X', 'A', 'X'});

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    assertTrue(actualProfileData.getConfiguration() instanceof DefaultTenantProfileConfiguration);
    assertNull(actualProfileData.getQueueConfiguration());
  }

  /**
   * Test {@link TenantProfile#getProfileData()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData(); given TenantProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileData TenantProfile.getProfileData()"})
  void testGetProfileData_givenTenantProfile() {
    // Arrange and Act
    TenantProfileData actualProfileData = new TenantProfile().getProfileData();

    // Assert
    assertTrue(actualProfileData.getConfiguration() instanceof DefaultTenantProfileConfiguration);
    assertNull(actualProfileData.getQueueConfiguration());
  }

  /**
   * Test {@link TenantProfile#getProfileData()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile()} ProfileDataBytes is array of {@code byte}
   *       with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  @DisplayName(
      "Test getProfileData(); given TenantProfile() ProfileDataBytes is array of byte with zero and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileData TenantProfile.getProfileData()"})
  void testGetProfileData_givenTenantProfileProfileDataBytesIsArrayOfByteWithZeroAndX() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    assertTrue(actualProfileData.getConfiguration() instanceof DefaultTenantProfileConfiguration);
    assertNull(actualProfileData.getQueueConfiguration());
  }

  /**
   * Test {@link TenantProfile#getProfileData()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile()} ProfileDataBytes is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  @DisplayName(
      "Test getProfileData(); given TenantProfile() ProfileDataBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileData TenantProfile.getProfileData()"})
  void testGetProfileData_givenTenantProfileProfileDataBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    assertTrue(actualProfileData.getConfiguration() instanceof DefaultTenantProfileConfiguration);
    assertNull(actualProfileData.getQueueConfiguration());
  }

  /**
   * Test {@link TenantProfile#getProfileData()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile()} ProfileDataBytes is empty array of {@code
   *       byte}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  @DisplayName(
      "Test getProfileData(); given TenantProfile() ProfileDataBytes is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileData TenantProfile.getProfileData()"})
  void testGetProfileData_givenTenantProfileProfileDataBytesIsEmptyArrayOfByte() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {});

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    assertTrue(actualProfileData.getConfiguration() instanceof DefaultTenantProfileConfiguration);
    assertNull(actualProfileData.getQueueConfiguration());
  }

  /**
   * Test {@link TenantProfile#getProfileData()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile()} ProfileDataBytes is {@code ;XAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  @DisplayName(
      "Test getProfileData(); given TenantProfile() ProfileDataBytes is ';XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileData TenantProfile.getProfileData()"})
  void testGetProfileData_givenTenantProfileProfileDataBytesIsXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(";XAXAXAX".getBytes("UTF-8"));

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    assertTrue(actualProfileData.getConfiguration() instanceof DefaultTenantProfileConfiguration);
    assertNull(actualProfileData.getQueueConfiguration());
  }

  /**
   * Test {@link TenantProfile#getProfileData()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile(TenantProfile)} with tenantProfile is {@link
   *       TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  @DisplayName(
      "Test getProfileData(); given TenantProfile(TenantProfile) with tenantProfile is TenantProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileData TenantProfile.getProfileData()"})
  void testGetProfileData_givenTenantProfileWithTenantProfileIsTenantProfile() {
    // Arrange and Act
    TenantProfileData actualProfileData = new TenantProfile(new TenantProfile()).getProfileData();

    // Assert
    assertTrue(actualProfileData.getConfiguration() instanceof DefaultTenantProfileConfiguration);
    assertNull(actualProfileData.getQueueConfiguration());
  }

  /**
   * Test {@link TenantProfile#getProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional TenantProfile.getProfileConfiguration()"})
  void testGetProfileConfiguration() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act and Assert
    assertTrue(tenantProfile.getProfileConfiguration().isPresent());
  }

  /**
   * Test {@link TenantProfile#getProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional TenantProfile.getProfileConfiguration()"})
  void testGetProfileConfiguration2() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {3, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act and Assert
    assertTrue(tenantProfile.getProfileConfiguration().isPresent());
  }

  /**
   * Test {@link TenantProfile#getProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional TenantProfile.getProfileConfiguration()"})
  void testGetProfileConfiguration3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {0, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act and Assert
    assertTrue(tenantProfile.getProfileConfiguration().isPresent());
  }

  /**
   * Test {@link TenantProfile#getProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional TenantProfile.getProfileConfiguration()"})
  void testGetProfileConfiguration4() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {';', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act and Assert
    assertTrue(tenantProfile.getProfileConfiguration().isPresent());
  }

  /**
   * Test {@link TenantProfile#getProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional TenantProfile.getProfileConfiguration()"})
  void testGetProfileConfiguration5() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {'A', 0, 'A', 3, 'A', 3, 'A', 3});

    // Act and Assert
    assertTrue(tenantProfile.getProfileConfiguration().isPresent());
  }

  /**
   * Test {@link TenantProfile#getProfileConfiguration()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getProfileConfiguration(); given TenantProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional TenantProfile.getProfileConfiguration()"})
  void testGetProfileConfiguration_givenTenantProfile() {
    // Arrange, Act and Assert
    assertTrue(new TenantProfile().getProfileConfiguration().isPresent());
  }

  /**
   * Test {@link TenantProfile#getProfileConfiguration()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile()} ProfileDataBytes is empty array of {@code
   *       byte}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  @DisplayName(
      "Test getProfileConfiguration(); given TenantProfile() ProfileDataBytes is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional TenantProfile.getProfileConfiguration()"})
  void testGetProfileConfiguration_givenTenantProfileProfileDataBytesIsEmptyArrayOfByte() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {});

    // Act and Assert
    assertTrue(tenantProfile.getProfileConfiguration().isPresent());
  }

  /**
   * Test {@link TenantProfile#getProfileConfiguration()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile(TenantProfile)} with tenantProfile is {@link
   *       TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  @DisplayName(
      "Test getProfileConfiguration(); given TenantProfile(TenantProfile) with tenantProfile is TenantProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional TenantProfile.getProfileConfiguration()"})
  void testGetProfileConfiguration_givenTenantProfileWithTenantProfileIsTenantProfile() {
    // Arrange, Act and Assert
    assertTrue(new TenantProfile(new TenantProfile()).getProfileConfiguration().isPresent());
  }

  /**
   * Test {@link TenantProfile#getDefaultProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getDefaultProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration() {
    // Arrange and Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration =
        new TenantProfile(new TenantProfile()).getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Test {@link TenantProfile#getDefaultProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getDefaultProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration2() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration =
        tenantProfile.getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Test {@link TenantProfile#getDefaultProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getDefaultProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration =
        tenantProfile.getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Test {@link TenantProfile#getDefaultProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getDefaultProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration4() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {3, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration =
        tenantProfile.getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Test {@link TenantProfile#getDefaultProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getDefaultProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration5() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {0, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration =
        tenantProfile.getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Test {@link TenantProfile#getDefaultProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getDefaultProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration6() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {';', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration =
        tenantProfile.getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Test {@link TenantProfile#getDefaultProfileConfiguration()}.
   *
   * <p>Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getDefaultProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration7() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {'A', 0, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration =
        tenantProfile.getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Test {@link TenantProfile#getDefaultProfileConfiguration()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getDefaultProfileConfiguration(); given TenantProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration_givenTenantProfile() {
    // Arrange and Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration =
        new TenantProfile().getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Test {@link TenantProfile#createDefaultTenantProfileData()}.
   *
   * <p>Method under test: {@link TenantProfile#createDefaultTenantProfileData()}
   */
  @Test
  @DisplayName("Test createDefaultTenantProfileData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileData TenantProfile.createDefaultTenantProfileData()"})
  void testCreateDefaultTenantProfileData() {
    // Arrange and Act
    TenantProfileData actualCreateDefaultTenantProfileDataResult =
        new TenantProfile().createDefaultTenantProfileData();

    // Assert
    assertTrue(
        actualCreateDefaultTenantProfileDataResult.getConfiguration()
            instanceof DefaultTenantProfileConfiguration);
    assertNull(actualCreateDefaultTenantProfileDataResult.getQueueConfiguration());
  }

  /**
   * Test {@link TenantProfile#setProfileData(TenantProfileData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then array length is {@code 1903}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName(
      "Test setProfileData(TenantProfileData); given ArrayList(); then array length is '1903'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_givenArrayList_thenArrayLengthIs1903() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfileData data = new TenantProfileData();
    data.setConfiguration(new DefaultTenantProfileConfiguration());
    data.setQueueConfiguration(new ArrayList<>());

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    assertEquals(1903, tenantProfile.getProfileDataBytes().length);
  }

  /**
   * Test {@link TenantProfile#setProfileData(TenantProfileData)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link TenantProfile#TenantProfile()} DefaultProfileConfiguration is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName(
      "Test setProfileData(TenantProfileData); given 'null'; then TenantProfile() DefaultProfileConfiguration is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_givenNull_thenTenantProfileDefaultProfileConfigurationIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfileData data = new TenantProfileData();
    data.setConfiguration(null);
    data.setQueueConfiguration(new ArrayList<>());

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    assertNull(tenantProfile.getDefaultProfileConfiguration());
    assertFalse(tenantProfile.getProfileConfiguration().isPresent());
    assertSame(data, tenantProfile.getProfileData());
    assertArrayEquals(
        "{\"configuration\":null,\"queueConfiguration\":[]}".getBytes("UTF-8"),
        tenantProfile.getProfileDataBytes());
  }

  /**
   * Test {@link TenantProfile#setProfileData(TenantProfileData)}.
   *
   * <ul>
   *   <li>Then {@code 2223} element is {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(TenantProfileData); then '2223' element is '['")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_then2223ElementIsLeftSquareBracket() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode additionalInfo = new ArrayNode(nf);
    additionalInfo.addObject();

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration =
        new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(additionalInfo);
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ArrayList<TenantProfileQueueConfiguration> queueConfiguration = new ArrayList<>();
    queueConfiguration.add(tenantProfileQueueConfiguration);

    TenantProfileData data = new TenantProfileData();
    data.setConfiguration(new DefaultTenantProfileConfiguration());
    data.setQueueConfiguration(queueConfiguration);

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    byte[] profileDataBytes = tenantProfile.getProfileDataBytes();
    assertEquals(2229, profileDataBytes.length);
    assertEquals('[', profileDataBytes[2222]);
    assertEquals(']', profileDataBytes[2225]);
    assertEquals(']', profileDataBytes[2227]);
    assertEquals('{', profileDataBytes[2223]);
    assertEquals('}', profileDataBytes[2224]);
    assertEquals('}', profileDataBytes[2228]);
  }

  /**
   * Test {@link TenantProfile#setProfileData(TenantProfileData)}.
   *
   * <ul>
   *   <li>Then {@code 2225} element is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(TenantProfileData); then '2225' element is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_then2225ElementIsDot() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration =
        new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ArrayList<TenantProfileQueueConfiguration> queueConfiguration = new ArrayList<>();
    queueConfiguration.add(tenantProfileQueueConfiguration);

    TenantProfileData data = new TenantProfileData();
    data.setConfiguration(new DefaultTenantProfileConfiguration());
    data.setQueueConfiguration(queueConfiguration);

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    byte[] profileDataBytes = tenantProfile.getProfileDataBytes();
    assertEquals(2229, profileDataBytes.length);
    assertEquals('.', profileDataBytes[2224]);
    assertEquals('0', profileDataBytes[2223]);
    assertEquals('0', profileDataBytes[2225]);
    assertEquals('1', profileDataBytes[2222]);
  }

  /**
   * Test {@link TenantProfile#setProfileData(TenantProfileData)}.
   *
   * <ul>
   *   <li>Then array length is {@code 2227}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(TenantProfileData); then array length is '2227'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_thenArrayLengthIs2227() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration =
        new TenantProfileQueueConfiguration();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    tenantProfileQueueConfiguration.setAdditionalInfo(new ArrayNode(nf));
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ArrayList<TenantProfileQueueConfiguration> queueConfiguration = new ArrayList<>();
    queueConfiguration.add(tenantProfileQueueConfiguration);

    TenantProfileData data = new TenantProfileData();
    data.setConfiguration(new DefaultTenantProfileConfiguration());
    data.setQueueConfiguration(queueConfiguration);

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    byte[] profileDataBytes = tenantProfile.getProfileDataBytes();
    assertEquals(2227, profileDataBytes.length);
    assertEquals('1', profileDataBytes[2202]);
    assertEquals(']', profileDataBytes[2223]);
    assertEquals('}', profileDataBytes[2203]);
  }

  /**
   * Test {@link TenantProfile#setProfileData(TenantProfileData)}.
   *
   * <ul>
   *   <li>Then array length is {@code 2239}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(TenantProfileData); then array length is '2239'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_thenArrayLengthIs2239() throws UnsupportedEncodingException {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration =
        new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(new BinaryNode("AXAXAXAX".getBytes("UTF-8")));
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ArrayList<TenantProfileQueueConfiguration> queueConfiguration = new ArrayList<>();
    queueConfiguration.add(tenantProfileQueueConfiguration);

    TenantProfileData data = new TenantProfileData();
    data.setConfiguration(new DefaultTenantProfileConfiguration());
    data.setQueueConfiguration(queueConfiguration);

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    byte[] profileDataBytes = tenantProfile.getProfileDataBytes();
    assertEquals(2239, profileDataBytes.length);
    assertEquals('=', profileDataBytes[2234]);
    assertEquals('B', profileDataBytes[2226]);
    assertEquals('E', profileDataBytes[2228]);
    assertEquals('F', profileDataBytes[2229]);
    assertEquals('Q', profileDataBytes[2223]);
    assertEquals('Q', profileDataBytes[2231]);
    assertEquals('V', profileDataBytes[2224]);
    assertEquals('V', profileDataBytes[2232]);
    assertEquals('W', profileDataBytes[2227]);
    assertEquals('Y', profileDataBytes[2230]);
    assertEquals('"', profileDataBytes[2222]);
    assertEquals('"', profileDataBytes[2235]);
    assertEquals(']', profileDataBytes[2237]);
    assertEquals('g', profileDataBytes[2233]);
    assertEquals('h', profileDataBytes[2225]);
    assertEquals('}', profileDataBytes[2236]);
    assertEquals('}', profileDataBytes[2238]);
  }

  /**
   * Test {@link TenantProfile#setProfileData(TenantProfileData)}.
   *
   * <ul>
   *   <li>Then array length is {@code 2780}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(TenantProfileData); then array length is '2780'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_thenArrayLengthIs2780() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfileData data = new TenantProfileData();
    data.setConfiguration(
        DefaultTenantProfileConfiguration.builder()
            .alarmsTtlDays(1)
            .cassandraQueryTenantRateLimitsConfiguration(
                "Cassandra Query Tenant Rate Limits Configuration")
            .customerServerRestLimitsConfiguration("Customer Server Rest Limits Configuration")
            .defaultStorageTtlDays(1)
            .edgeEventRateLimits("Edge Event Rate Limits")
            .edgeEventRateLimitsPerEdge("Edge Event Rate Limits Per Edge")
            .edgeUplinkMessagesRateLimits("Edge Uplink Messages Rate Limits")
            .edgeUplinkMessagesRateLimitsPerEdge("Edge Uplink Messages Rate Limits Per Edge")
            .maxAssets(1L)
            .maxCreatedAlarms(1L)
            .maxCustomers(1L)
            .maxDPStorageDays(1L)
            .maxDashboards(1L)
            .maxDevices(1L)
            .maxEmails(1L)
            .maxJSExecutions(1L)
            .maxOtaPackagesInBytes(1L)
            .maxREExecutions(1L)
            .maxResourceSize(3L)
            .maxResourcesInBytes(1L)
            .maxRuleChains(1L)
            .maxRuleNodeExecutionsPerMessage(3)
            .maxSms(1L)
            .maxTbelExecutions(1L)
            .maxTransportDataPoints(1L)
            .maxTransportMessages(1L)
            .maxUsers(1L)
            .maxWsSessionsPerCustomer(3)
            .maxWsSessionsPerPublicUser(3)
            .maxWsSessionsPerRegularUser(3)
            .maxWsSessionsPerTenant(3)
            .maxWsSubscriptionsPerCustomer(1L)
            .maxWsSubscriptionsPerPublicUser(1L)
            .maxWsSubscriptionsPerRegularUser(1L)
            .maxWsSubscriptionsPerTenant(1L)
            .queueStatsTtlDays(1)
            .rpcTtlDays(1)
            .ruleEngineExceptionsTtlDays(1)
            .smsEnabled(true)
            .tenantEntityExportRateLimit("Tenant Entity Export Rate Limit")
            .tenantEntityImportRateLimit("Tenant Entity Import Rate Limit")
            .tenantNotificationRequestsPerRuleRateLimit(
                "Tenant Notification Requests Per Rule Rate Limit")
            .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
            .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
            .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
            .transportDeviceTelemetryDataPointsRateLimit(
                "Transport Device Telemetry Data Points Rate Limit")
            .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
            .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
            .transportGatewayDeviceTelemetryDataPointsRateLimit(
                "Transport Gateway Device Telemetry Data Points Rate Limit")
            .transportGatewayDeviceTelemetryMsgRateLimit(
                "Transport Gateway Device Telemetry Msg Rate Limit")
            .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
            .transportGatewayTelemetryDataPointsRateLimit(
                "Transport Gateway Telemetry Data Points Rate Limit")
            .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
            .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
            .transportTenantTelemetryDataPointsRateLimit(
                "Transport Tenant Telemetry Data Points Rate Limit")
            .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
            .warnThreshold(10.0d)
            .wsMsgQueueLimitPerSession(1)
            .wsUpdatesPerSessionRateLimit("2020-03-01")
            .build());
    data.setQueueConfiguration(new ArrayList<>());

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    assertEquals(2780, tenantProfile.getProfileDataBytes().length);
  }

  /**
   * Test {@link TenantProfile#setProfileData(TenantProfileData)}.
   *
   * <ul>
   *   <li>Then array length is three hundred seventy-three.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName(
      "Test setProfileData(TenantProfileData); then array length is three hundred seventy-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_thenArrayLengthIsThreeHundredSeventyThree() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration =
        new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    tenantProfileQueueConfiguration.setConsumerPerPartition(false);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ArrayList<TenantProfileQueueConfiguration> queueConfiguration = new ArrayList<>();
    queueConfiguration.add(tenantProfileQueueConfiguration);

    TenantProfileData data = new TenantProfileData();
    data.setConfiguration(null);
    data.setQueueConfiguration(queueConfiguration);

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    assertEquals(373, tenantProfile.getProfileDataBytes().length);
  }

  /**
   * Test {@link TenantProfile#setProfileData(TenantProfileData)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link TenantProfile#TenantProfile()} ProfileDataBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName(
      "Test setProfileData(TenantProfileData); when 'null'; then TenantProfile() ProfileDataBytes is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_whenNull_thenTenantProfileProfileDataBytesIsNull() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    // Act
    tenantProfile.setProfileData(null);

    // Assert that nothing has changed
    assertNull(tenantProfile.getProfileDataBytes());
  }

  /**
   * Test {@link TenantProfile#equals(Object)}, and {@link TenantProfile#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfile#equals(Object)}
   *   <li>{@link TenantProfile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    TenantProfile tenantProfile2 = new TenantProfile();

    // Act and Assert
    assertEquals(tenantProfile, tenantProfile2);
    assertEquals(tenantProfile.hashCode(), tenantProfile2.hashCode());
  }

  /**
   * Test {@link TenantProfile#equals(Object)}, and {@link TenantProfile#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfile#equals(Object)}
   *   <li>{@link TenantProfile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setName("Name");

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setName("Name");

    // Act and Assert
    assertEquals(tenantProfile, tenantProfile2);
    assertEquals(tenantProfile.hashCode(), tenantProfile2.hashCode());
  }

  /**
   * Test {@link TenantProfile#equals(Object)}, and {@link TenantProfile#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfile#equals(Object)}
   *   <li>{@link TenantProfile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDescription("The characteristics of someone or something");

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(tenantProfile, tenantProfile2);
    assertEquals(tenantProfile.hashCode(), tenantProfile2.hashCode());
  }

  /**
   * Test {@link TenantProfile#equals(Object)}, and {@link TenantProfile#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfile#equals(Object)}
   *   <li>{@link TenantProfile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    // Act and Assert
    assertEquals(tenantProfile, tenantProfile);
    int expectedHashCodeResult = tenantProfile.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfile.hashCode());
  }

  /**
   * Test {@link TenantProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile(new TenantProfile());

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Test {@link TenantProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setName("Name");

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Test {@link TenantProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Test {@link TenantProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDefault(true);

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Test {@link TenantProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setIsolatedTbRuleEngine(true);

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Test {@link TenantProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Test {@link TenantProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setName("Name");

    // Act and Assert
    assertNotEquals(tenantProfile, tenantProfile2);
  }

  /**
   * Test {@link TenantProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(tenantProfile, tenantProfile2);
  }

  /**
   * Test {@link TenantProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantProfile(), null);
  }

  /**
   * Test {@link TenantProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantProfile(), "Different type to TenantProfile");
  }
}
