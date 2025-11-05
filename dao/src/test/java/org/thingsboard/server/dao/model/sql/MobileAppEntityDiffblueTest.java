package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.MobileApp;
import org.thingsboard.server.dao.model.ModelConstants;

class MobileAppEntityDiffblueTest {
  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity2);
    assertEquals(mobileAppEntity.hashCode(), mobileAppEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret(null);
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret(null);
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity2);
    assertEquals(mobileAppEntity.hashCode(), mobileAppEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(null);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(null);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity2);
    assertEquals(mobileAppEntity.hashCode(), mobileAppEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName(null);
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName(null);
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity2);
    assertEquals(mobileAppEntity.hashCode(), mobileAppEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(null);
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(null);
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity2);
    assertEquals(mobileAppEntity.hashCode(), mobileAppEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity);
    int expectedHashCodeResult = mobileAppEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppEntity.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("Pkg Name");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret(null);
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(3L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(false);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(null);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("App Secret");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName(null);
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(null);
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppEntity, null);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(mobileAppEntity, "Different type to MobileAppEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#MobileAppEntity()}
   *   <li>{@link MobileAppEntity#setAppSecret(String)}
   *   <li>{@link MobileAppEntity#setOauth2Enabled(Boolean)}
   *   <li>{@link MobileAppEntity#setPkgName(String)}
   *   <li>{@link MobileAppEntity#setTenantId(UUID)}
   *   <li>{@link MobileAppEntity#toString()}
   *   <li>{@link MobileAppEntity#getAppSecret()}
   *   <li>{@link MobileAppEntity#getOauth2Enabled()}
   *   <li>{@link MobileAppEntity#getPkgName()}
   *   <li>{@link MobileAppEntity#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppEntity.<init>()",
    "String MobileAppEntity.getAppSecret()",
    "Boolean MobileAppEntity.getOauth2Enabled()",
    "String MobileAppEntity.getPkgName()",
    "UUID MobileAppEntity.getTenantId()",
    "void MobileAppEntity.setAppSecret(String)",
    "void MobileAppEntity.setOauth2Enabled(Boolean)",
    "void MobileAppEntity.setPkgName(String)",
    "void MobileAppEntity.setTenantId(UUID)",
    "String MobileAppEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MobileAppEntity actualMobileAppEntity = new MobileAppEntity();
    actualMobileAppEntity.setAppSecret("App Secret");
    actualMobileAppEntity.setOauth2Enabled(true);
    actualMobileAppEntity.setPkgName("Pkg Name");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualMobileAppEntity.setTenantId(tenantId);
    String actualToStringResult = actualMobileAppEntity.toString();
    String actualAppSecret = actualMobileAppEntity.getAppSecret();
    Boolean actualOauth2Enabled = actualMobileAppEntity.getOauth2Enabled();
    String actualPkgName = actualMobileAppEntity.getPkgName();
    UUID actualTenantId = actualMobileAppEntity.getTenantId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("App Secret", actualAppSecret);
    assertEquals(
        "MobileAppEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, pkgName=Pkg Name, appSecret=App Secret,"
            + " oauth2Enabled=true)",
        actualToStringResult);
    assertEquals("Pkg Name", actualPkgName);
    assertNull(actualMobileAppEntity.getId());
    assertNull(actualMobileAppEntity.getUuid());
    assertEquals(0L, actualMobileAppEntity.getCreatedTime());
    assertTrue(actualOauth2Enabled);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link MobileAppEntity#MobileAppEntity(MobileApp)}.
   *
   * <p>Method under test: {@link MobileAppEntity#MobileAppEntity(MobileApp)}
   */
  @Test
  @DisplayName("Test new MobileAppEntity(MobileApp)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppEntity.<init>(MobileApp)"})
  void testNewMobileAppEntity() {
    // Arrange
    MobileApp mobile = new MobileApp();
    mobile.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    MobileAppEntity actualMobileAppEntity = new MobileAppEntity(mobile);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualMobileAppEntity.getTenantId().toString());
    assertNull(actualMobileAppEntity.getAppSecret());
    assertNull(actualMobileAppEntity.getPkgName());
    assertNull(actualMobileAppEntity.getId());
    assertNull(actualMobileAppEntity.getUuid());
    assertEquals(0L, actualMobileAppEntity.getCreatedTime());
    assertFalse(actualMobileAppEntity.getOauth2Enabled());
  }

  /**
   * Test {@link MobileAppEntity#MobileAppEntity(MobileApp)}.
   *
   * <ul>
   *   <li>When {@link MobileApp#MobileApp()}.
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#MobileAppEntity(MobileApp)}
   */
  @Test
  @DisplayName(
      "Test new MobileAppEntity(MobileApp); when MobileApp(); then return TenantId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppEntity.<init>(MobileApp)"})
  void testNewMobileAppEntity_whenMobileApp_thenReturnTenantIdIsNull() {
    // Arrange and Act
    MobileAppEntity actualMobileAppEntity = new MobileAppEntity(new MobileApp());

    // Assert
    assertNull(actualMobileAppEntity.getAppSecret());
    assertNull(actualMobileAppEntity.getPkgName());
    assertNull(actualMobileAppEntity.getId());
    assertNull(actualMobileAppEntity.getUuid());
    assertNull(actualMobileAppEntity.getTenantId());
    assertEquals(0L, actualMobileAppEntity.getCreatedTime());
    assertFalse(actualMobileAppEntity.getOauth2Enabled());
  }

  /**
   * Test {@link MobileAppEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileApp MobileAppEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID tenantId = UUID.randomUUID();
    mobileAppEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = mobileAppEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link MobileAppEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileApp MobileAppEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    TenantId tenantId = mobileAppEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link MobileAppEntity#toData()}.
   *
   * <ul>
   *   <li>Then return UuidId toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return UuidId toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileApp MobileAppEntity.toData()"})
  void testToData_thenReturnUuidIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    mobileAppEntity.setUuid(id);
    mobileAppEntity.setTenantId(null);

    // Act
    MobileApp actualToDataResult = mobileAppEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals("App Secret", actualToDataResult.getAppSecret());
    assertEquals("Pkg Name", actualToDataResult.getName());
    assertEquals("Pkg Name", actualToDataResult.getPkgName());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    MobileAppId id2 = actualToDataResult.getId();
    assertEquals(EntityType.MOBILE_APP, id2.getEntityType());
    assertFalse(id2.isNullUid());
    assertTrue(actualToDataResult.isOauth2Enabled());
    assertSame(id, uuidId);
    assertSame(id, id2.getId());
  }
}
