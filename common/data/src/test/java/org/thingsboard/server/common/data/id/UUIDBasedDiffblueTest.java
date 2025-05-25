package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UUIDBasedDiffblueTest {
  /**
   * Test {@link UUIDBased#getId()}.
   * <p>
   * Method under test: {@link UUIDBased#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID UUIDBased.getId()"})
  void testGetId() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    UUID actualId = (new AdminSettingsId(id)).getId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualId.toString());
    assertSame(id, actualId);
  }

  /**
   * Test {@link UUIDBased#equals(Object)}, and {@link UUIDBased#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UUIDBased#equals(Object)}
   *   <li>{@link UUIDBased#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    TenantId tenantId2 = TenantId.SYS_TENANT_ID;

    // Act and Assert
    assertEquals(tenantId, tenantId2);
    int expectedHashCodeResult = tenantId.hashCode();
    assertEquals(expectedHashCodeResult, tenantId2.hashCode());
  }

  /**
   * Test {@link UUIDBased#equals(Object)}, and {@link UUIDBased#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UUIDBased#equals(Object)}
   *   <li>{@link UUIDBased#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(EntityId.NULL_UUID);
    TenantId tenantId2 = TenantId.SYS_TENANT_ID;

    // Act and Assert
    assertEquals(tenantId, tenantId2);
    int expectedHashCodeResult = tenantId.hashCode();
    assertEquals(expectedHashCodeResult, tenantId2.hashCode());
  }

  /**
   * Test {@link UUIDBased#equals(Object)}, and {@link UUIDBased#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UUIDBased#equals(Object)}
   *   <li>{@link UUIDBased#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act and Assert
    assertEquals(tenantId, tenantId);
    int expectedHashCodeResult = tenantId.hashCode();
    assertEquals(expectedHashCodeResult, tenantId.hashCode());
  }

  /**
   * Test {@link UUIDBased#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), TenantId.SYS_TENANT_ID);
  }

  /**
   * Test {@link UUIDBased#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantId(null), TenantId.SYS_TENANT_ID);
  }

  /**
   * Test {@link UUIDBased#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantId.SYS_TENANT_ID, null);
  }

  /**
   * Test {@link UUIDBased#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantId.SYS_TENANT_ID, "Different type to UUIDBased");
  }

  /**
   * Test {@link UUIDBased#toString()}.
   * <p>
   * Method under test: {@link UUIDBased#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String UUIDBased.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9",
        (new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))).toString());
  }
}
