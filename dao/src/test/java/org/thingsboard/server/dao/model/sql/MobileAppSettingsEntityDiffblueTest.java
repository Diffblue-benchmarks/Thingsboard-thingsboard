package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.AndroidConfig;
import org.thingsboard.server.common.data.mobile.MobileAppSettings;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

class MobileAppSettingsEntityDiffblueTest {
  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}, and {@link
   * MobileAppSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppSettingsEntity#equals(Object)}
   *   <li>{@link MobileAppSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
    assertEquals(mobileAppSettingsEntity.hashCode(), mobileAppSettingsEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}, and {@link
   * MobileAppSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppSettingsEntity#equals(Object)}
   *   <li>{@link MobileAppSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(null);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(null);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
    assertEquals(mobileAppSettingsEntity.hashCode(), mobileAppSettingsEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}, and {@link
   * MobileAppSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppSettingsEntity#equals(Object)}
   *   <li>{@link MobileAppSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(null);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(null);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
    assertEquals(mobileAppSettingsEntity.hashCode(), mobileAppSettingsEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}, and {@link
   * MobileAppSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppSettingsEntity#equals(Object)}
   *   <li>{@link MobileAppSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(null);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(null);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
    assertEquals(mobileAppSettingsEntity.hashCode(), mobileAppSettingsEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}, and {@link
   * MobileAppSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppSettingsEntity#equals(Object)}
   *   <li>{@link MobileAppSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(null);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(null);
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
    assertEquals(mobileAppSettingsEntity.hashCode(), mobileAppSettingsEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}, and {@link
   * MobileAppSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppSettingsEntity#equals(Object)}
   *   <li>{@link MobileAppSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppSettingsEntity, mobileAppSettingsEntity);
    int expectedHashCodeResult = mobileAppSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppSettingsEntity.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(DoubleNode.valueOf(10.0d));
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(null);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(3L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(DoubleNode.valueOf(10.0d));
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(null);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(DoubleNode.valueOf(10.0d));
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(null);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(null);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(false);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppSettingsEntity mobileAppSettingsEntity2 = new MobileAppSettingsEntity();
    mobileAppSettingsEntity2.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setCreatedTime(1L);
    mobileAppSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity2.setUseDefaultApp(true);
    mobileAppSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, mobileAppSettingsEntity2);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, null);
  }

  /**
   * Test {@link MobileAppSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEntity.equals(Object)",
    "int MobileAppSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppSettingsEntity, "Different type to MobileAppSettingsEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppSettingsEntity#MobileAppSettingsEntity()}
   *   <li>{@link MobileAppSettingsEntity#setAndroidConfig(JsonNode)}
   *   <li>{@link MobileAppSettingsEntity#setIosConfig(JsonNode)}
   *   <li>{@link MobileAppSettingsEntity#setQrCodeConfig(JsonNode)}
   *   <li>{@link MobileAppSettingsEntity#setTenantId(UUID)}
   *   <li>{@link MobileAppSettingsEntity#setUseDefaultApp(boolean)}
   *   <li>{@link MobileAppSettingsEntity#toString()}
   *   <li>{@link MobileAppSettingsEntity#getAndroidConfig()}
   *   <li>{@link MobileAppSettingsEntity#getIosConfig()}
   *   <li>{@link MobileAppSettingsEntity#getQrCodeConfig()}
   *   <li>{@link MobileAppSettingsEntity#getTenantId()}
   *   <li>{@link MobileAppSettingsEntity#isUseDefaultApp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsEntity.<init>()",
    "JsonNode MobileAppSettingsEntity.getAndroidConfig()",
    "JsonNode MobileAppSettingsEntity.getIosConfig()",
    "JsonNode MobileAppSettingsEntity.getQrCodeConfig()",
    "UUID MobileAppSettingsEntity.getTenantId()",
    "boolean MobileAppSettingsEntity.isUseDefaultApp()",
    "void MobileAppSettingsEntity.setAndroidConfig(JsonNode)",
    "void MobileAppSettingsEntity.setIosConfig(JsonNode)",
    "void MobileAppSettingsEntity.setQrCodeConfig(JsonNode)",
    "void MobileAppSettingsEntity.setTenantId(UUID)",
    "void MobileAppSettingsEntity.setUseDefaultApp(boolean)",
    "String MobileAppSettingsEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MobileAppSettingsEntity actualMobileAppSettingsEntity = new MobileAppSettingsEntity();
    actualMobileAppSettingsEntity.setAndroidConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualMobileAppSettingsEntity.setIosConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode qrCodeConfig = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualMobileAppSettingsEntity.setQrCodeConfig(qrCodeConfig);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualMobileAppSettingsEntity.setTenantId(tenantId);
    actualMobileAppSettingsEntity.setUseDefaultApp(true);
    String actualToStringResult = actualMobileAppSettingsEntity.toString();
    JsonNode actualAndroidConfig = actualMobileAppSettingsEntity.getAndroidConfig();
    JsonNode actualIosConfig = actualMobileAppSettingsEntity.getIosConfig();
    JsonNode actualQrCodeConfig = actualMobileAppSettingsEntity.getQrCodeConfig();
    UUID actualTenantId = actualMobileAppSettingsEntity.getTenantId();
    boolean actualIsUseDefaultAppResult = actualMobileAppSettingsEntity.isUseDefaultApp();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals(
        "MobileAppSettingsEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, useDefaultApp=true, androidConfig"
            + "={\"isPublic\":true}, iosConfig={\"isPublic\":true}, qrCodeConfig={\"isPublic\":true})",
        actualToStringResult);
    assertNull(actualMobileAppSettingsEntity.getId());
    assertNull(actualMobileAppSettingsEntity.getUuid());
    assertEquals(0L, actualMobileAppSettingsEntity.getCreatedTime());
    assertTrue(actualIsUseDefaultAppResult);
    assertSame(tenantId, actualTenantId);
    assertSame(qrCodeConfig, actualAndroidConfig);
    assertSame(qrCodeConfig, actualIosConfig);
    assertSame(qrCodeConfig, actualQrCodeConfig);
  }

  /**
   * Test {@link MobileAppSettingsEntity#MobileAppSettingsEntity(MobileAppSettings)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * MobileAppSettingsEntity#MobileAppSettingsEntity(MobileAppSettings)}
   */
  @Test
  @DisplayName(
      "Test new MobileAppSettingsEntity(MobileAppSettings); given one; then return CreatedTime is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppSettingsEntity.<init>(MobileAppSettings)"})
  void testNewMobileAppSettingsEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setTenantId(ModelConstants.SYSTEM_TENANT);
    mobileAppSettings.setCreatedTime(1L);

    // Act
    MobileAppSettingsEntity actualMobileAppSettingsEntity =
        new MobileAppSettingsEntity(mobileAppSettings);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualMobileAppSettingsEntity.getTenantId().toString());
    assertNull(actualMobileAppSettingsEntity.getAndroidConfig());
    assertNull(actualMobileAppSettingsEntity.getIosConfig());
    assertNull(actualMobileAppSettingsEntity.getQrCodeConfig());
    assertNull(actualMobileAppSettingsEntity.getId());
    assertNull(actualMobileAppSettingsEntity.getUuid());
    assertEquals(1L, actualMobileAppSettingsEntity.getCreatedTime());
    assertFalse(actualMobileAppSettingsEntity.isUseDefaultApp());
  }

  /**
   * Test {@link MobileAppSettingsEntity#MobileAppSettingsEntity(MobileAppSettings)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return CreatedTime is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * MobileAppSettingsEntity#MobileAppSettingsEntity(MobileAppSettings)}
   */
  @Test
  @DisplayName(
      "Test new MobileAppSettingsEntity(MobileAppSettings); given SYSTEM_TENANT; then return CreatedTime is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppSettingsEntity.<init>(MobileAppSettings)"})
  void testNewMobileAppSettingsEntity_givenSystem_tenant_thenReturnCreatedTimeIsZero() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    MobileAppSettingsEntity actualMobileAppSettingsEntity =
        new MobileAppSettingsEntity(mobileAppSettings);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualMobileAppSettingsEntity.getTenantId().toString());
    assertNull(actualMobileAppSettingsEntity.getAndroidConfig());
    assertNull(actualMobileAppSettingsEntity.getIosConfig());
    assertNull(actualMobileAppSettingsEntity.getQrCodeConfig());
    assertNull(actualMobileAppSettingsEntity.getId());
    assertNull(actualMobileAppSettingsEntity.getUuid());
    assertEquals(0L, actualMobileAppSettingsEntity.getCreatedTime());
    assertFalse(actualMobileAppSettingsEntity.isUseDefaultApp());
  }

  /**
   * Test {@link MobileAppSettingsEntity#MobileAppSettingsEntity(MobileAppSettings)}.
   *
   * <ul>
   *   <li>Then AndroidConfig return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MobileAppSettingsEntity#MobileAppSettingsEntity(MobileAppSettings)}
   */
  @Test
  @DisplayName(
      "Test new MobileAppSettingsEntity(MobileAppSettings); then AndroidConfig return ObjectNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppSettingsEntity.<init>(MobileAppSettings)"})
  void testNewMobileAppSettingsEntity_thenAndroidConfigReturnObjectNode() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setAndroidConfig(
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build());
    mobileAppSettings.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertTrue(
        new MobileAppSettingsEntity(mobileAppSettings).getAndroidConfig() instanceof ObjectNode);
  }

  /**
   * Test {@link MobileAppSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link MobileAppSettingsEntity#MobileAppSettingsEntity()} IosConfig is Instance.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given MobileAppSettingsEntity() IosConfig is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileAppSettings MobileAppSettingsEntity.toData()"})
  void testToData_givenMobileAppSettingsEntityIosConfigIsInstance() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    mobileAppSettingsEntity.setIosConfig(MissingNode.getInstance());

    // Act
    MobileAppSettings actualToDataResult = mobileAppSettingsEntity.toData();

    // Assert
    assertNull(actualToDataResult.getDefaultAppStoreLink());
    assertNull(actualToDataResult.getDefaultGooglePlayLink());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertNull(tenantId.getId());
    assertNull(actualToDataResult.getAndroidConfig());
    assertNull(actualToDataResult.getIosConfig());
    assertNull(actualToDataResult.getQrCodeConfig());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertFalse(actualToDataResult.isUseDefaultApp());
  }

  /**
   * Test {@link MobileAppSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link MobileAppSettingsEntity#MobileAppSettingsEntity()}.
   *   <li>Then return TenantId Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given MobileAppSettingsEntity(); then return TenantId Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileAppSettings MobileAppSettingsEntity.toData()"})
  void testToData_givenMobileAppSettingsEntity_thenReturnTenantIdIdIsNull() {
    // Arrange and Act
    MobileAppSettings actualToDataResult = new MobileAppSettingsEntity().toData();

    // Assert
    assertNull(actualToDataResult.getDefaultAppStoreLink());
    assertNull(actualToDataResult.getDefaultGooglePlayLink());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertNull(tenantId.getId());
    assertNull(actualToDataResult.getAndroidConfig());
    assertNull(actualToDataResult.getIosConfig());
    assertNull(actualToDataResult.getQrCodeConfig());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertFalse(actualToDataResult.isUseDefaultApp());
  }

  /**
   * Test {@link MobileAppSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileAppSettings MobileAppSettingsEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = new MobileAppSettingsEntity();
    UUID tenantId = UUID.randomUUID();
    mobileAppSettingsEntity.setTenantId(tenantId);

    // Act
    MobileAppSettings actualToDataResult = mobileAppSettingsEntity.toData();

    // Assert
    assertNull(actualToDataResult.getDefaultAppStoreLink());
    assertNull(actualToDataResult.getDefaultGooglePlayLink());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getAndroidConfig());
    assertNull(actualToDataResult.getIosConfig());
    assertNull(actualToDataResult.getQrCodeConfig());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertFalse(actualToDataResult.isUseDefaultApp());
    assertSame(tenantId, tenantId2.getId());
  }
}
