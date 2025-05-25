package org.thingsboard.server.common.data.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;

class BaseWidgetTypeDiffblueTest {
  /**
   * Test {@link BaseWidgetType#equals(Object)}, and {@link BaseWidgetType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#equals(Object)}
   *   <li>{@link BaseWidgetType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    BaseWidgetType baseWidgetType2 = new BaseWidgetType();

    // Act and Assert
    assertEquals(baseWidgetType, baseWidgetType2);
    int expectedHashCodeResult = baseWidgetType.hashCode();
    assertEquals(expectedHashCodeResult, baseWidgetType2.hashCode());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}, and {@link BaseWidgetType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#equals(Object)}
   *   <li>{@link BaseWidgetType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setTenantId(TenantId.SYS_TENANT_ID);

    BaseWidgetType baseWidgetType2 = new BaseWidgetType();
    baseWidgetType2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(baseWidgetType, baseWidgetType2);
    int expectedHashCodeResult = baseWidgetType.hashCode();
    assertEquals(expectedHashCodeResult, baseWidgetType2.hashCode());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}, and {@link BaseWidgetType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#equals(Object)}
   *   <li>{@link BaseWidgetType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setFqn("Fqn");

    BaseWidgetType baseWidgetType2 = new BaseWidgetType();
    baseWidgetType2.setFqn("Fqn");

    // Act and Assert
    assertEquals(baseWidgetType, baseWidgetType2);
    int expectedHashCodeResult = baseWidgetType.hashCode();
    assertEquals(expectedHashCodeResult, baseWidgetType2.hashCode());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}, and {@link BaseWidgetType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#equals(Object)}
   *   <li>{@link BaseWidgetType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setName("Name");

    BaseWidgetType baseWidgetType2 = new BaseWidgetType();
    baseWidgetType2.setName("Name");

    // Act and Assert
    assertEquals(baseWidgetType, baseWidgetType2);
    int expectedHashCodeResult = baseWidgetType.hashCode();
    assertEquals(expectedHashCodeResult, baseWidgetType2.hashCode());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}, and {@link BaseWidgetType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#equals(Object)}
   *   <li>{@link BaseWidgetType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setVersion(1L);

    BaseWidgetType baseWidgetType2 = new BaseWidgetType();
    baseWidgetType2.setVersion(1L);

    // Act and Assert
    assertEquals(baseWidgetType, baseWidgetType2);
    int expectedHashCodeResult = baseWidgetType.hashCode();
    assertEquals(expectedHashCodeResult, baseWidgetType2.hashCode());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}, and {@link BaseWidgetType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#equals(Object)}
   *   <li>{@link BaseWidgetType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();

    // Act and Assert
    assertEquals(baseWidgetType, baseWidgetType);
    int expectedHashCodeResult = baseWidgetType.hashCode();
    assertEquals(expectedHashCodeResult, baseWidgetType.hashCode());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType(
        new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(baseWidgetType, new BaseWidgetType());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();

    // Act and Assert
    assertNotEquals(baseWidgetType, new WidgetType());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(baseWidgetType, new BaseWidgetType());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setFqn("Fqn");

    // Act and Assert
    assertNotEquals(baseWidgetType, new BaseWidgetType());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setName("Name");

    // Act and Assert
    assertNotEquals(baseWidgetType, new BaseWidgetType());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setDeprecated(true);

    // Act and Assert
    assertNotEquals(baseWidgetType, new BaseWidgetType());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setScada(true);

    // Act and Assert
    assertNotEquals(baseWidgetType, new BaseWidgetType());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setVersion(1L);

    // Act and Assert
    assertNotEquals(baseWidgetType, new BaseWidgetType());
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();

    BaseWidgetType baseWidgetType2 = new BaseWidgetType();
    baseWidgetType2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(baseWidgetType, baseWidgetType2);
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();

    BaseWidgetType baseWidgetType2 = new BaseWidgetType();
    baseWidgetType2.setFqn("Fqn");

    // Act and Assert
    assertNotEquals(baseWidgetType, baseWidgetType2);
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();

    BaseWidgetType baseWidgetType2 = new BaseWidgetType();
    baseWidgetType2.setName("Name");

    // Act and Assert
    assertNotEquals(baseWidgetType, baseWidgetType2);
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();

    BaseWidgetType baseWidgetType2 = new BaseWidgetType();
    baseWidgetType2.setVersion(1L);

    // Act and Assert
    assertNotEquals(baseWidgetType, baseWidgetType2);
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseWidgetType(), null);
  }

  /**
   * Test {@link BaseWidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseWidgetType.equals(Object)", "int BaseWidgetType.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseWidgetType(), "Different type to BaseWidgetType");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#BaseWidgetType(WidgetTypeId)}
   *   <li>{@link BaseWidgetType#setDeprecated(boolean)}
   *   <li>{@link BaseWidgetType#setFqn(String)}
   *   <li>{@link BaseWidgetType#setName(String)}
   *   <li>{@link BaseWidgetType#setScada(boolean)}
   *   <li>{@link BaseWidgetType#setTenantId(TenantId)}
   *   <li>{@link BaseWidgetType#setVersion(Long)}
   *   <li>{@link BaseWidgetType#toString()}
   *   <li>{@link BaseWidgetType#getFqn()}
   *   <li>{@link BaseWidgetType#getName()}
   *   <li>{@link BaseWidgetType#getTenantId()}
   *   <li>{@link BaseWidgetType#getVersion()}
   *   <li>{@link BaseWidgetType#isDeprecated()}
   *   <li>{@link BaseWidgetType#isScada()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseWidgetType.<init>()", "void BaseWidgetType.<init>(WidgetTypeId)",
      "String BaseWidgetType.getFqn()", "String BaseWidgetType.getName()", "TenantId BaseWidgetType.getTenantId()",
      "Long BaseWidgetType.getVersion()", "boolean BaseWidgetType.isDeprecated()", "boolean BaseWidgetType.isScada()",
      "void BaseWidgetType.setDeprecated(boolean)", "void BaseWidgetType.setFqn(String)",
      "void BaseWidgetType.setName(String)", "void BaseWidgetType.setScada(boolean)",
      "void BaseWidgetType.setTenantId(TenantId)", "void BaseWidgetType.setVersion(Long)",
      "String BaseWidgetType.toString()"})
  void testGettersAndSetters() {
    // Arrange
    WidgetTypeId id = new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    BaseWidgetType actualBaseWidgetType = new BaseWidgetType(id);
    actualBaseWidgetType.setDeprecated(true);
    actualBaseWidgetType.setFqn("Fqn");
    actualBaseWidgetType.setName("Name");
    actualBaseWidgetType.setScada(true);
    actualBaseWidgetType.setTenantId(TenantId.SYS_TENANT_ID);
    actualBaseWidgetType.setVersion(1L);
    String actualToStringResult = actualBaseWidgetType.toString();
    String actualFqn = actualBaseWidgetType.getFqn();
    String actualName = actualBaseWidgetType.getName();
    TenantId actualTenantId = actualBaseWidgetType.getTenantId();
    Long actualVersion = actualBaseWidgetType.getVersion();
    boolean actualIsDeprecatedResult = actualBaseWidgetType.isDeprecated();
    boolean actualIsScadaResult = actualBaseWidgetType.isScada();

    // Assert
    assertEquals("BaseWidgetType(tenantId=13814000-1dd2-11b2-8080-808080808080, fqn=Fqn, name=Name, deprecated=true,"
        + " scada=true, version=1)", actualToStringResult);
    assertEquals("Fqn", actualFqn);
    assertEquals("Name", actualName);
    assertEquals(0L, actualBaseWidgetType.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertTrue(actualIsDeprecatedResult);
    assertTrue(actualIsScadaResult);
    assertSame(id, actualBaseWidgetType.getId());
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#BaseWidgetType()}
   *   <li>{@link BaseWidgetType#setDeprecated(boolean)}
   *   <li>{@link BaseWidgetType#setFqn(String)}
   *   <li>{@link BaseWidgetType#setName(String)}
   *   <li>{@link BaseWidgetType#setScada(boolean)}
   *   <li>{@link BaseWidgetType#setTenantId(TenantId)}
   *   <li>{@link BaseWidgetType#setVersion(Long)}
   *   <li>{@link BaseWidgetType#toString()}
   *   <li>{@link BaseWidgetType#getFqn()}
   *   <li>{@link BaseWidgetType#getName()}
   *   <li>{@link BaseWidgetType#getTenantId()}
   *   <li>{@link BaseWidgetType#getVersion()}
   *   <li>{@link BaseWidgetType#isDeprecated()}
   *   <li>{@link BaseWidgetType#isScada()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseWidgetType.<init>()", "void BaseWidgetType.<init>(WidgetTypeId)",
      "String BaseWidgetType.getFqn()", "String BaseWidgetType.getName()", "TenantId BaseWidgetType.getTenantId()",
      "Long BaseWidgetType.getVersion()", "boolean BaseWidgetType.isDeprecated()", "boolean BaseWidgetType.isScada()",
      "void BaseWidgetType.setDeprecated(boolean)", "void BaseWidgetType.setFqn(String)",
      "void BaseWidgetType.setName(String)", "void BaseWidgetType.setScada(boolean)",
      "void BaseWidgetType.setTenantId(TenantId)", "void BaseWidgetType.setVersion(Long)",
      "String BaseWidgetType.toString()"})
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    BaseWidgetType actualBaseWidgetType = new BaseWidgetType();
    actualBaseWidgetType.setDeprecated(true);
    actualBaseWidgetType.setFqn("Fqn");
    actualBaseWidgetType.setName("Name");
    actualBaseWidgetType.setScada(true);
    actualBaseWidgetType.setTenantId(TenantId.SYS_TENANT_ID);
    actualBaseWidgetType.setVersion(1L);
    String actualToStringResult = actualBaseWidgetType.toString();
    String actualFqn = actualBaseWidgetType.getFqn();
    String actualName = actualBaseWidgetType.getName();
    TenantId actualTenantId = actualBaseWidgetType.getTenantId();
    Long actualVersion = actualBaseWidgetType.getVersion();
    boolean actualIsDeprecatedResult = actualBaseWidgetType.isDeprecated();
    boolean actualIsScadaResult = actualBaseWidgetType.isScada();

    // Assert
    assertEquals("BaseWidgetType(tenantId=13814000-1dd2-11b2-8080-808080808080, fqn=Fqn, name=Name, deprecated=true,"
        + " scada=true, version=1)", actualToStringResult);
    assertEquals("Fqn", actualFqn);
    assertEquals("Name", actualName);
    assertNull(actualBaseWidgetType.getId());
    assertEquals(0L, actualBaseWidgetType.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertTrue(actualIsDeprecatedResult);
    assertTrue(actualIsScadaResult);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link BaseWidgetType#BaseWidgetType(BaseWidgetType)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link BaseWidgetType#BaseWidgetType()} Deprecated is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#BaseWidgetType(BaseWidgetType)}
   */
  @Test
  @DisplayName("Test new BaseWidgetType(BaseWidgetType); given 'true'; when BaseWidgetType() Deprecated is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseWidgetType.<init>(BaseWidgetType)"})
  void testNewBaseWidgetType_givenTrue_whenBaseWidgetTypeDeprecatedIsTrue() {
    // Arrange
    BaseWidgetType widgetType = new BaseWidgetType();
    widgetType.setDeprecated(true);

    // Act and Assert
    assertEquals(widgetType, new BaseWidgetType(widgetType));
  }

  /**
   * Test {@link BaseWidgetType#BaseWidgetType(BaseWidgetType)}.
   * <ul>
   *   <li>When {@link BaseWidgetType#BaseWidgetType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetType#BaseWidgetType(BaseWidgetType)}
   */
  @Test
  @DisplayName("Test new BaseWidgetType(BaseWidgetType); when BaseWidgetType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseWidgetType.<init>(BaseWidgetType)"})
  void testNewBaseWidgetType_whenBaseWidgetType() {
    // Arrange
    BaseWidgetType widgetType = new BaseWidgetType();

    // Act and Assert
    assertEquals(widgetType, new BaseWidgetType(widgetType));
  }

  /**
   * Test {@link BaseWidgetType#getId()}.
   * <p>
   * Method under test: {@link BaseWidgetType#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetTypeId BaseWidgetType.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new BaseWidgetType()).getId());
  }

  /**
   * Test {@link BaseWidgetType#getCreatedTime()}.
   * <p>
   * Method under test: {@link BaseWidgetType#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseWidgetType.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BaseWidgetType()).getCreatedTime());
  }
}
