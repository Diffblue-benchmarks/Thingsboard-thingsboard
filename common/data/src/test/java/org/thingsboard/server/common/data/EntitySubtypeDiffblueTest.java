package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class EntitySubtypeDiffblueTest {
  /**
   * Test {@link EntitySubtype#equals(Object)}, and {@link EntitySubtype#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#equals(Object)}
   *   <li>{@link EntitySubtype#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type");
    EntitySubtype entitySubtype2 = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type");

    // Act and Assert
    assertEquals(entitySubtype, entitySubtype2);
    int expectedHashCodeResult = entitySubtype.hashCode();
    assertEquals(expectedHashCodeResult, entitySubtype2.hashCode());
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}, and {@link EntitySubtype#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#equals(Object)}
   *   <li>{@link EntitySubtype#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(null, EntityType.TENANT, "Type");
    EntitySubtype entitySubtype2 = new EntitySubtype(null, EntityType.TENANT, "Type");

    // Act and Assert
    assertEquals(entitySubtype, entitySubtype2);
    int expectedHashCodeResult = entitySubtype.hashCode();
    assertEquals(expectedHashCodeResult, entitySubtype2.hashCode());
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}, and {@link EntitySubtype#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#equals(Object)}
   *   <li>{@link EntitySubtype#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, null, "Type");
    EntitySubtype entitySubtype2 = new EntitySubtype(TenantId.SYS_TENANT_ID, null, "Type");

    // Act and Assert
    assertEquals(entitySubtype, entitySubtype2);
    int expectedHashCodeResult = entitySubtype.hashCode();
    assertEquals(expectedHashCodeResult, entitySubtype2.hashCode());
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}, and {@link EntitySubtype#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#equals(Object)}
   *   <li>{@link EntitySubtype#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, null);
    EntitySubtype entitySubtype2 = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, null);

    // Act and Assert
    assertEquals(entitySubtype, entitySubtype2);
    int expectedHashCodeResult = entitySubtype.hashCode();
    assertEquals(expectedHashCodeResult, entitySubtype2.hashCode());
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}, and {@link EntitySubtype#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#equals(Object)}
   *   <li>{@link EntitySubtype#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type");

    // Act and Assert
    assertEquals(entitySubtype, entitySubtype);
    int expectedHashCodeResult = entitySubtype.hashCode();
    assertEquals(expectedHashCodeResult, entitySubtype.hashCode());
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), EntityType.TENANT, "Type");

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"));
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(null, EntityType.TENANT, "Type");

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"));
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, null, "Type");

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"));
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.CUSTOMER, "Type");

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"));
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, null);

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"));
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "EntitySubtype{");

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"));
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"), null);
  }

  /**
   * Test {@link EntitySubtype#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySubtype.equals(Object)", "int EntitySubtype.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"),
        "Different type to EntitySubtype");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#EntitySubtype(TenantId, EntityType, String)}
   *   <li>{@link EntitySubtype#toString()}
   *   <li>{@link EntitySubtype#getEntityType()}
   *   <li>{@link EntitySubtype#getTenantId()}
   *   <li>{@link EntitySubtype#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitySubtype.<init>(TenantId, EntityType, String)",
      "EntityType EntitySubtype.getEntityType()", "TenantId EntitySubtype.getTenantId()",
      "String EntitySubtype.getType()", "String EntitySubtype.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntitySubtype actualEntitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type");
    String actualToStringResult = actualEntitySubtype.toString();
    EntityType actualEntityType = actualEntitySubtype.getEntityType();
    TenantId actualTenantId = actualEntitySubtype.getTenantId();

    // Assert
    assertEquals("EntitySubtype{tenantId=13814000-1dd2-11b2-8080-808080808080, entityType=TENANT, type='Type'}",
        actualToStringResult);
    assertEquals("Type", actualEntitySubtype.getType());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
