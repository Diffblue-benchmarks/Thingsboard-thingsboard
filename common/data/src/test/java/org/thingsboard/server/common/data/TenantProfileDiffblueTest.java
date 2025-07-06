package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantProfile.<init>(TenantProfile)"})
  void testNewTenantProfile_thenReturnTenantProfileWithTenantProfileIsTenantProfile() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile(new TenantProfile());

    // Act and Assert
    assertEquals(tenantProfile, new TenantProfile(tenantProfile));
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Given {@link TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  @DisplayName("Test getProfileData(); given TenantProfile()")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration3() {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration4() {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration5() {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration6() {
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
   * <p>Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getDefaultProfileConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DefaultTenantProfileConfiguration TenantProfile.getDefaultProfileConfiguration()"
  })
  void testGetDefaultProfileConfiguration7() {
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
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  @DisplayName("Test getDefaultProfileConfiguration(); given TenantProfile()")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Given {@link DefaultTenantProfileConfiguration#DefaultTenantProfileConfiguration()}.
   *   <li>Then {@code 1900} element is {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName(
      "Test setProfileData(TenantProfileData); given DefaultTenantProfileConfiguration(); then '1900' element is ':'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_givenDefaultTenantProfileConfiguration_then1900ElementIsColon() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfileData data = new TenantProfileData();
    data.setConfiguration(new DefaultTenantProfileConfiguration());
    data.setQueueConfiguration(new ArrayList<>());

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    byte[] profileDataBytes = tenantProfile.getProfileDataBytes();
    assertEquals(1903, profileDataBytes.length);
    assertEquals(':', profileDataBytes[1899]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
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
  @Tag("MaintainedByDiffblue")
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
    byte[] expectedProfileDataBytes =
        "{\"configuration\":null,\"queueConfiguration\":[]}".getBytes("UTF-8");
    assertArrayEquals(expectedProfileDataBytes, tenantProfile.getProfileDataBytes());
  }

  /**
   * Test {@link TenantProfile#setProfileData(TenantProfileData)}.
   *
   * <ul>
   *   <li>Then {@code 1879} element is {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(TenantProfileData); then '1879' element is ','")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_then1879ElementIsComma() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile(new TenantProfile());

    TenantProfileData data = new TenantProfileData();
    data.setConfiguration(new DefaultTenantProfileConfiguration());
    data.setQueueConfiguration(new ArrayList<>());

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    byte[] profileDataBytes = tenantProfile.getProfileDataBytes();
    assertEquals(1903, profileDataBytes.length);
    assertEquals(',', profileDataBytes[1878]);
    assertEquals('[', profileDataBytes[1900]);
    assertEquals('"', profileDataBytes[1879]);
    assertEquals(']', profileDataBytes[1901]);
    assertEquals('}', profileDataBytes[1902]);
  }

  /**
   * Test {@link TenantProfile#setProfileData(TenantProfileData)}.
   *
   * <ul>
   *   <li>Then array length is {@code 2229}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName("Test setProfileData(TenantProfileData); then array length is '2229'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_thenArrayLengthIs2229() {
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
    assertEquals(2229, tenantProfile.getProfileDataBytes().length);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantProfile.setProfileData(TenantProfileData)"})
  void testSetProfileData_thenArrayLengthIs2780() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfileData data = new TenantProfileData();
    DefaultTenantProfileConfiguration configuration =
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
            .build();
    data.setConfiguration(configuration);
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
   *   <li>When {@code null}.
   *   <li>Then {@link TenantProfile#TenantProfile()} ProfileDataBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  @DisplayName(
      "Test setProfileData(TenantProfileData); when 'null'; then TenantProfile() ProfileDataBytes is 'null'")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    TenantProfile tenantProfile2 = new TenantProfile();

    // Act and Assert
    assertEquals(tenantProfile, tenantProfile2);
    int expectedHashCodeResult = tenantProfile.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfile2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setName("Name");

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setName("Name");

    // Act and Assert
    assertEquals(tenantProfile, tenantProfile2);
    int expectedHashCodeResult = tenantProfile.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfile2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDescription("The characteristics of someone or something");

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(tenantProfile, tenantProfile2);
    int expectedHashCodeResult = tenantProfile.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfile2.hashCode());
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfile.equals(Object)", "int TenantProfile.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantProfile(), "Different type to TenantProfile");
  }
}
