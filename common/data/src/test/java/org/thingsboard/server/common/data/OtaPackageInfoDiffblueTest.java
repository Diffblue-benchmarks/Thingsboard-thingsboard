package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;

class OtaPackageInfoDiffblueTest {
  /**
   * Test {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return HasData.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test new OtaPackageInfo(OtaPackageInfo); given 'true'; then return HasData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageInfo.<init>(OtaPackageInfo)"})
  void testNewOtaPackageInfo_givenTrue_thenReturnHasData() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setHasData(true);

    // Act
    OtaPackageInfo actualOtaPackageInfo = new OtaPackageInfo(otaPackageInfo);

    // Assert
    assertTrue(actualOtaPackageInfo.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOtaPackageInfo.getDataSize());
    assertNull(actualOtaPackageInfo.getChecksum());
    assertNull(actualOtaPackageInfo.getContentType());
    assertNull(actualOtaPackageInfo.getFileName());
    assertNull(actualOtaPackageInfo.getName());
    assertNull(actualOtaPackageInfo.getTag());
    assertNull(actualOtaPackageInfo.getTitle());
    assertNull(actualOtaPackageInfo.getUrl());
    assertNull(actualOtaPackageInfo.getVersion());
    assertNull(actualOtaPackageInfo.getUuidId());
    assertNull(actualOtaPackageInfo.getDeviceProfileId());
    assertNull(actualOtaPackageInfo.getId());
    assertNull(actualOtaPackageInfo.getTenantId());
    assertNull(actualOtaPackageInfo.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfo.getType());
    assertEquals(0L, actualOtaPackageInfo.getCreatedTime());
    assertFalse(actualOtaPackageInfo.hasUrl());
    assertTrue(actualOtaPackageInfo.isHasData());
  }

  /**
   * Test {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.
   * <ul>
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)} with otaPackageInfo is {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test new OtaPackageInfo(OtaPackageInfo); when OtaPackageInfo(OtaPackageInfo) with otaPackageInfo is OtaPackageInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageInfo.<init>(OtaPackageInfo)"})
  void testNewOtaPackageInfo_whenOtaPackageInfoWithOtaPackageInfoIsOtaPackageInfo() {
    // Arrange and Act
    OtaPackageInfo actualOtaPackageInfo = new OtaPackageInfo(new OtaPackageInfo(new OtaPackageInfo()));

    // Assert
    assertTrue(actualOtaPackageInfo.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOtaPackageInfo.getDataSize());
    assertNull(actualOtaPackageInfo.getChecksum());
    assertNull(actualOtaPackageInfo.getContentType());
    assertNull(actualOtaPackageInfo.getFileName());
    assertNull(actualOtaPackageInfo.getName());
    assertNull(actualOtaPackageInfo.getTag());
    assertNull(actualOtaPackageInfo.getTitle());
    assertNull(actualOtaPackageInfo.getUrl());
    assertNull(actualOtaPackageInfo.getVersion());
    assertNull(actualOtaPackageInfo.getUuidId());
    assertNull(actualOtaPackageInfo.getDeviceProfileId());
    assertNull(actualOtaPackageInfo.getId());
    assertNull(actualOtaPackageInfo.getTenantId());
    assertNull(actualOtaPackageInfo.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfo.getType());
    assertEquals(0L, actualOtaPackageInfo.getCreatedTime());
    assertFalse(actualOtaPackageInfo.hasUrl());
    assertFalse(actualOtaPackageInfo.isHasData());
  }

  /**
   * Test {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.
   * <ul>
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)} with otaPackageInfo is {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test new OtaPackageInfo(OtaPackageInfo); when OtaPackageInfo(OtaPackageInfo) with otaPackageInfo is OtaPackageInfo(OtaPackageInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageInfo.<init>(OtaPackageInfo)"})
  void testNewOtaPackageInfo_whenOtaPackageInfoWithOtaPackageInfoIsOtaPackageInfo2() {
    // Arrange and Act
    OtaPackageInfo actualOtaPackageInfo = new OtaPackageInfo(
        new OtaPackageInfo(new OtaPackageInfo(new OtaPackageInfo())));

    // Assert
    assertTrue(actualOtaPackageInfo.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOtaPackageInfo.getDataSize());
    assertNull(actualOtaPackageInfo.getChecksum());
    assertNull(actualOtaPackageInfo.getContentType());
    assertNull(actualOtaPackageInfo.getFileName());
    assertNull(actualOtaPackageInfo.getName());
    assertNull(actualOtaPackageInfo.getTag());
    assertNull(actualOtaPackageInfo.getTitle());
    assertNull(actualOtaPackageInfo.getUrl());
    assertNull(actualOtaPackageInfo.getVersion());
    assertNull(actualOtaPackageInfo.getUuidId());
    assertNull(actualOtaPackageInfo.getDeviceProfileId());
    assertNull(actualOtaPackageInfo.getId());
    assertNull(actualOtaPackageInfo.getTenantId());
    assertNull(actualOtaPackageInfo.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfo.getType());
    assertEquals(0L, actualOtaPackageInfo.getCreatedTime());
    assertFalse(actualOtaPackageInfo.hasUrl());
    assertFalse(actualOtaPackageInfo.isHasData());
  }

  /**
   * Test {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.
   * <ul>
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   *   <li>Then return not HasData.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test new OtaPackageInfo(OtaPackageInfo); when OtaPackageInfo(); then return not HasData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageInfo.<init>(OtaPackageInfo)"})
  void testNewOtaPackageInfo_whenOtaPackageInfo_thenReturnNotHasData() {
    // Arrange and Act
    OtaPackageInfo actualOtaPackageInfo = new OtaPackageInfo(new OtaPackageInfo());

    // Assert
    assertTrue(actualOtaPackageInfo.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOtaPackageInfo.getDataSize());
    assertNull(actualOtaPackageInfo.getChecksum());
    assertNull(actualOtaPackageInfo.getContentType());
    assertNull(actualOtaPackageInfo.getFileName());
    assertNull(actualOtaPackageInfo.getName());
    assertNull(actualOtaPackageInfo.getTag());
    assertNull(actualOtaPackageInfo.getTitle());
    assertNull(actualOtaPackageInfo.getUrl());
    assertNull(actualOtaPackageInfo.getVersion());
    assertNull(actualOtaPackageInfo.getUuidId());
    assertNull(actualOtaPackageInfo.getDeviceProfileId());
    assertNull(actualOtaPackageInfo.getId());
    assertNull(actualOtaPackageInfo.getTenantId());
    assertNull(actualOtaPackageInfo.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfo.getType());
    assertEquals(0L, actualOtaPackageInfo.getCreatedTime());
    assertFalse(actualOtaPackageInfo.hasUrl());
    assertFalse(actualOtaPackageInfo.isHasData());
  }

  /**
   * Test {@link OtaPackageInfo#getId()}.
   * <p>
   * Method under test: {@link OtaPackageInfo#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.OtaPackageId OtaPackageInfo.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new OtaPackageInfo()).getId());
  }

  /**
   * Test {@link OtaPackageInfo#getCreatedTime()}.
   * <p>
   * Method under test: {@link OtaPackageInfo#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long OtaPackageInfo.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new OtaPackageInfo()).getCreatedTime());
  }

  /**
   * Test {@link OtaPackageInfo#hasUrl()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfo#OtaPackageInfo()} Url is {@link DataConstants#DEFAULT_SECRET_KEY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#hasUrl()}
   */
  @Test
  @DisplayName("Test hasUrl(); given OtaPackageInfo() Url is DEFAULT_SECRET_KEY; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.hasUrl()"})
  void testHasUrl_givenOtaPackageInfoUrlIsDefault_secret_key_thenReturnFalse() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setUrl(DataConstants.DEFAULT_SECRET_KEY);

    // Act and Assert
    assertFalse(otaPackageInfo.hasUrl());
  }

  /**
   * Test {@link OtaPackageInfo#hasUrl()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfo#OtaPackageInfo()} Url is {@code not empty}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#hasUrl()}
   */
  @Test
  @DisplayName("Test hasUrl(); given OtaPackageInfo() Url is 'not empty'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.hasUrl()"})
  void testHasUrl_givenOtaPackageInfoUrlIsNotEmpty_thenReturnTrue() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setUrl("not empty");

    // Act and Assert
    assertTrue(otaPackageInfo.hasUrl());
  }

  /**
   * Test {@link OtaPackageInfo#hasUrl()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#hasUrl()}
   */
  @Test
  @DisplayName("Test hasUrl(); given OtaPackageInfo(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.hasUrl()"})
  void testHasUrl_givenOtaPackageInfo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OtaPackageInfo()).hasUrl());
  }

  /**
   * Test {@link OtaPackageInfo#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)} with otaPackageInfo is {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given OtaPackageInfo(OtaPackageInfo) with otaPackageInfo is OtaPackageInfo(OtaPackageInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode OtaPackageInfo.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenOtaPackageInfoWithOtaPackageInfoIsOtaPackageInfo() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new OtaPackageInfo(new OtaPackageInfo(new OtaPackageInfo()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link OtaPackageInfo#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given OtaPackageInfo(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode OtaPackageInfo.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenOtaPackageInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OtaPackageInfo()).getAdditionalInfo());
  }

  /**
   * Test {@link OtaPackageInfo#getAdditionalInfo()}.
   * <ul>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); then return instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode OtaPackageInfo.getAdditionalInfo()"})
  void testGetAdditionalInfo_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new OtaPackageInfo(new OtaPackageInfo())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}, and {@link OtaPackageInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageInfo#equals(Object)}
   *   <li>{@link OtaPackageInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();

    // Act and Assert
    assertEquals(otaPackageInfo, otaPackageInfo2);
    int expectedHashCodeResult = otaPackageInfo.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageInfo2.hashCode());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}, and {@link OtaPackageInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageInfo#equals(Object)}
   *   <li>{@link OtaPackageInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    // Act and Assert
    assertEquals(otaPackageInfo, otaPackageInfo);
    int expectedHashCodeResult = otaPackageInfo.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageInfo.hashCode());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackage otaPackage = new OtaPackage();

    // Act and Assert
    assertNotEquals(otaPackage, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo(new OtaPackageInfo());

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackage());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setType(OtaPackageType.FIRMWARE);

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTag("Tag");

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setHasData(true);

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setFileName("foo.txt");

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setContentType("text/plain");

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setChecksumAlgorithm(ChecksumAlgorithm.MD5);

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setChecksum("Checksum");

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setDataSize(3L);

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();
    otaPackageInfo2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackageInfo2);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();
    otaPackageInfo2.setType(OtaPackageType.FIRMWARE);

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackageInfo2);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();
    otaPackageInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackageInfo2);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();
    otaPackageInfo2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackageInfo2);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();
    otaPackageInfo2.setTag("Tag");

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackageInfo2);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();
    otaPackageInfo2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackageInfo2);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();
    otaPackageInfo2.setFileName("foo.txt");

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackageInfo2);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();
    otaPackageInfo2.setContentType("text/plain");

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackageInfo2);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();
    otaPackageInfo2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackageInfo2);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();
    otaPackageInfo2.setChecksum("Checksum");

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackageInfo2);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();
    otaPackageInfo2.setDataSize(3L);

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackageInfo2);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtaPackageInfo(), null);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtaPackageInfo.equals(Object)", "int OtaPackageInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtaPackageInfo(), "Different type to OtaPackageInfo");
  }
}
