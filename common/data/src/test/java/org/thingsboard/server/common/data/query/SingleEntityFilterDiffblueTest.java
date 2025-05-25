package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class SingleEntityFilterDiffblueTest {
  /**
   * Test {@link SingleEntityFilter#equals(Object)}, and {@link SingleEntityFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityFilter#equals(Object)}
   *   <li>{@link SingleEntityFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityFilter.equals(Object)", "int SingleEntityFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(TenantId.SYS_TENANT_ID);

    SingleEntityFilter singleEntityFilter2 = new SingleEntityFilter();
    singleEntityFilter2.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(singleEntityFilter, singleEntityFilter2);
    int expectedHashCodeResult = singleEntityFilter.hashCode();
    assertEquals(expectedHashCodeResult, singleEntityFilter2.hashCode());
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}, and {@link SingleEntityFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityFilter#equals(Object)}
   *   <li>{@link SingleEntityFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityFilter.equals(Object)", "int SingleEntityFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(null);

    SingleEntityFilter singleEntityFilter2 = new SingleEntityFilter();
    singleEntityFilter2.setSingleEntity(null);

    // Act and Assert
    assertEquals(singleEntityFilter, singleEntityFilter2);
    int expectedHashCodeResult = singleEntityFilter.hashCode();
    assertEquals(expectedHashCodeResult, singleEntityFilter2.hashCode());
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}, and {@link SingleEntityFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SingleEntityFilter#equals(Object)}
   *   <li>{@link SingleEntityFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityFilter.equals(Object)", "int SingleEntityFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(singleEntityFilter, singleEntityFilter);
    int expectedHashCodeResult = singleEntityFilter.hashCode();
    assertEquals(expectedHashCodeResult, singleEntityFilter.hashCode());
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityFilter.equals(Object)", "int SingleEntityFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(null);

    SingleEntityFilter singleEntityFilter2 = new SingleEntityFilter();
    singleEntityFilter2.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(singleEntityFilter, singleEntityFilter2);
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityFilter.equals(Object)", "int SingleEntityFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    SingleEntityFilter singleEntityFilter2 = new SingleEntityFilter();
    singleEntityFilter2.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(singleEntityFilter, singleEntityFilter2);
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityFilter.equals(Object)", "int SingleEntityFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(singleEntityFilter, null);
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleEntityFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SingleEntityFilter.equals(Object)", "int SingleEntityFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(singleEntityFilter, "Different type to SingleEntityFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SingleEntityFilter}
   *   <li>{@link SingleEntityFilter#setSingleEntity(EntityId)}
   *   <li>{@link SingleEntityFilter#toString()}
   *   <li>{@link SingleEntityFilter#getSingleEntity()}
   *   <li>{@link SingleEntityFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SingleEntityFilter.<init>()", "EntityId SingleEntityFilter.getSingleEntity()",
      "EntityFilterType SingleEntityFilter.getType()", "void SingleEntityFilter.setSingleEntity(EntityId)",
      "String SingleEntityFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SingleEntityFilter actualSingleEntityFilter = new SingleEntityFilter();
    actualSingleEntityFilter.setSingleEntity(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualSingleEntityFilter.toString();
    EntityId actualSingleEntity = actualSingleEntityFilter.getSingleEntity();

    // Assert
    assertEquals("SingleEntityFilter(singleEntity=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals(EntityFilterType.SINGLE_ENTITY, actualSingleEntityFilter.getType());
    assertSame(((TenantId) actualSingleEntity).SYS_TENANT_ID, actualSingleEntity);
  }
}
