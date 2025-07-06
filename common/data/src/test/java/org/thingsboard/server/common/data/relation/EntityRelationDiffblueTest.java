package org.thingsboard.server.common.data.relation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntityRelationDiffblueTest {
  /**
   * Test {@link EntityRelation#equals(Object)}, and {@link EntityRelation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelation#equals(Object)}
   *   <li>{@link EntityRelation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    EntityRelation entityRelation2 = new EntityRelation();

    // Act and Assert
    assertEquals(entityRelation, entityRelation2);
    int expectedHashCodeResult = entityRelation.hashCode();
    assertEquals(expectedHashCodeResult, entityRelation2.hashCode());
  }

  /**
   * Test {@link EntityRelation#equals(Object)}, and {@link EntityRelation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelation#equals(Object)}
   *   <li>{@link EntityRelation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.getType()).thenReturn(null);
    when(entityRelationInfo.getFrom()).thenReturn(null);
    when(entityRelationInfo.getTo()).thenReturn(null);
    when(entityRelationInfo.getTypeGroup()).thenReturn(null);
    when(entityRelationInfo.getVersion()).thenReturn(null);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(entityRelation, entityRelationInfo);
    int notExpectedHashCodeResult = entityRelation.hashCode();
    assertNotEquals(notExpectedHashCodeResult, entityRelationInfo.hashCode());
  }

  /**
   * Test {@link EntityRelation#equals(Object)}, and {@link EntityRelation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelation#equals(Object)}
   *   <li>{@link EntityRelation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityRelation entityRelation =
        new EntityRelation(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Type");
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.getType()).thenReturn("Type");
    when(entityRelationInfo.getFrom()).thenReturn(TenantId.SYS_TENANT_ID);
    when(entityRelationInfo.getTo()).thenReturn(TenantId.SYS_TENANT_ID);
    when(entityRelationInfo.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(entityRelationInfo.getVersion()).thenReturn(null);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(entityRelation, entityRelationInfo);
    int notExpectedHashCodeResult = entityRelation.hashCode();
    assertNotEquals(notExpectedHashCodeResult, entityRelationInfo.hashCode());
  }

  /**
   * Test {@link EntityRelation#equals(Object)}, and {@link EntityRelation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelation#equals(Object)}
   *   <li>{@link EntityRelation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setVersion(1L);
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.getType()).thenReturn(null);
    when(entityRelationInfo.getFrom()).thenReturn(null);
    when(entityRelationInfo.getTo()).thenReturn(null);
    when(entityRelationInfo.getTypeGroup()).thenReturn(null);
    when(entityRelationInfo.getVersion()).thenReturn(1L);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(entityRelation, entityRelationInfo);
    int notExpectedHashCodeResult = entityRelation.hashCode();
    assertNotEquals(notExpectedHashCodeResult, entityRelationInfo.hashCode());
  }

  /**
   * Test {@link EntityRelation#equals(Object)}, and {@link EntityRelation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelation#equals(Object)}
   *   <li>{@link EntityRelation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();

    // Act and Assert
    assertEquals(entityRelation, entityRelation);
    int expectedHashCodeResult = entityRelation.hashCode();
    assertEquals(expectedHashCodeResult, entityRelation.hashCode());
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityRelation entityRelation =
        new EntityRelation(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Type");

    // Act and Assert
    assertNotEquals(entityRelation, new EntityRelation());
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();

    // Act and Assert
    assertNotEquals(
        entityRelation, new EntityRelation(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Type"));
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(false);

    // Act and Assert
    assertNotEquals(entityRelation, entityRelationInfo);
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.getVersion()).thenReturn(1L);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityRelation, entityRelationInfo);
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.getType()).thenReturn("foo");
    when(entityRelationInfo.getFrom()).thenReturn(null);
    when(entityRelationInfo.getTo()).thenReturn(null);
    when(entityRelationInfo.getTypeGroup()).thenReturn(null);
    when(entityRelationInfo.getVersion()).thenReturn(null);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityRelation, entityRelationInfo);
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.getType()).thenReturn(null);
    when(entityRelationInfo.getFrom()).thenReturn(null);
    when(entityRelationInfo.getTo()).thenReturn(TenantId.SYS_TENANT_ID);
    when(entityRelationInfo.getTypeGroup()).thenReturn(null);
    when(entityRelationInfo.getVersion()).thenReturn(null);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityRelation, entityRelationInfo);
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.getType()).thenReturn(null);
    when(entityRelationInfo.getFrom()).thenReturn(null);
    when(entityRelationInfo.getTo()).thenReturn(null);
    when(entityRelationInfo.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(entityRelationInfo.getVersion()).thenReturn(null);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityRelation, entityRelationInfo);
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setTo(TenantId.SYS_TENANT_ID);
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.getType()).thenReturn(null);
    when(entityRelationInfo.getFrom()).thenReturn(null);
    when(entityRelationInfo.getTo()).thenReturn(null);
    when(entityRelationInfo.getTypeGroup()).thenReturn(null);
    when(entityRelationInfo.getVersion()).thenReturn(null);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityRelation, entityRelationInfo);
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setType("Type");
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.getType()).thenReturn(null);
    when(entityRelationInfo.getFrom()).thenReturn(null);
    when(entityRelationInfo.getTo()).thenReturn(null);
    when(entityRelationInfo.getTypeGroup()).thenReturn(null);
    when(entityRelationInfo.getVersion()).thenReturn(null);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityRelation, entityRelationInfo);
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.getType()).thenReturn(null);
    when(entityRelationInfo.getFrom()).thenReturn(null);
    when(entityRelationInfo.getTo()).thenReturn(null);
    when(entityRelationInfo.getTypeGroup()).thenReturn(null);
    when(entityRelationInfo.getVersion()).thenReturn(null);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityRelation, entityRelationInfo);
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setVersion(1L);
    EntityRelationInfo entityRelationInfo = mock(EntityRelationInfo.class);
    when(entityRelationInfo.getType()).thenReturn(null);
    when(entityRelationInfo.getFrom()).thenReturn(null);
    when(entityRelationInfo.getTo()).thenReturn(null);
    when(entityRelationInfo.getTypeGroup()).thenReturn(null);
    when(entityRelationInfo.getVersion()).thenReturn(null);
    when(entityRelationInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityRelation, entityRelationInfo);
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityRelation(), null);
  }

  /**
   * Test {@link EntityRelation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelation.equals(Object)", "int EntityRelation.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityRelation(), "Different type to EntityRelation");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelation#EntityRelation()}
   *   <li>{@link EntityRelation#setFrom(EntityId)}
   *   <li>{@link EntityRelation#setTo(EntityId)}
   *   <li>{@link EntityRelation#setType(String)}
   *   <li>{@link EntityRelation#setTypeGroup(RelationTypeGroup)}
   *   <li>{@link EntityRelation#setVersion(Long)}
   *   <li>{@link EntityRelation#toString()}
   *   <li>{@link EntityRelation#getFrom()}
   *   <li>{@link EntityRelation#getTo()}
   *   <li>{@link EntityRelation#getType()}
   *   <li>{@link EntityRelation#getTypeGroup()}
   *   <li>{@link EntityRelation#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityRelation.<init>()",
    "void EntityRelation.<init>(EntityId, EntityId, String, RelationTypeGroup)",
    "void EntityRelation.<init>(EntityId, EntityId, String, RelationTypeGroup, JsonNode)",
    "EntityId EntityRelation.getFrom()",
    "EntityId EntityRelation.getTo()",
    "String EntityRelation.getType()",
    "RelationTypeGroup EntityRelation.getTypeGroup()",
    "Long EntityRelation.getVersion()",
    "void EntityRelation.setFrom(EntityId)",
    "void EntityRelation.setTo(EntityId)",
    "void EntityRelation.setType(String)",
    "void EntityRelation.setTypeGroup(RelationTypeGroup)",
    "void EntityRelation.setVersion(Long)",
    "String EntityRelation.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityRelation actualEntityRelation = new EntityRelation();
    actualEntityRelation.setFrom(TenantId.SYS_TENANT_ID);
    actualEntityRelation.setTo(TenantId.SYS_TENANT_ID);
    actualEntityRelation.setType("Type");
    actualEntityRelation.setTypeGroup(RelationTypeGroup.COMMON);
    actualEntityRelation.setVersion(1L);
    String actualToStringResult = actualEntityRelation.toString();
    EntityId actualFrom = actualEntityRelation.getFrom();
    EntityId actualTo = actualEntityRelation.getTo();
    String actualType = actualEntityRelation.getType();
    RelationTypeGroup actualTypeGroup = actualEntityRelation.getTypeGroup();

    // Assert
    assertEquals(
        "EntityRelation(from=13814000-1dd2-11b2-8080-808080808080, to=13814000-1dd2-11b2-8080-808080808080,"
            + " type=Type, typeGroup=COMMON, version=1, additionalInfo=null)",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertEquals(1L, actualEntityRelation.getVersion().longValue());
    assertEquals(RelationTypeGroup.COMMON, actualTypeGroup);
    TenantId tenantId = ((TenantId) actualTo).SYS_TENANT_ID;
    assertSame(tenantId, actualFrom);
    assertSame(tenantId, actualTo);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelation#EntityRelation(EntityId, EntityId, String, RelationTypeGroup)}
   *   <li>{@link EntityRelation#setFrom(EntityId)}
   *   <li>{@link EntityRelation#setTo(EntityId)}
   *   <li>{@link EntityRelation#setType(String)}
   *   <li>{@link EntityRelation#setTypeGroup(RelationTypeGroup)}
   *   <li>{@link EntityRelation#setVersion(Long)}
   *   <li>{@link EntityRelation#toString()}
   *   <li>{@link EntityRelation#getFrom()}
   *   <li>{@link EntityRelation#getTo()}
   *   <li>{@link EntityRelation#getType()}
   *   <li>{@link EntityRelation#getTypeGroup()}
   *   <li>{@link EntityRelation#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when SYS_TENANT_ID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityRelation.<init>()",
    "void EntityRelation.<init>(EntityId, EntityId, String, RelationTypeGroup)",
    "void EntityRelation.<init>(EntityId, EntityId, String, RelationTypeGroup, JsonNode)",
    "EntityId EntityRelation.getFrom()",
    "EntityId EntityRelation.getTo()",
    "String EntityRelation.getType()",
    "RelationTypeGroup EntityRelation.getTypeGroup()",
    "Long EntityRelation.getVersion()",
    "void EntityRelation.setFrom(EntityId)",
    "void EntityRelation.setTo(EntityId)",
    "void EntityRelation.setType(String)",
    "void EntityRelation.setTypeGroup(RelationTypeGroup)",
    "void EntityRelation.setVersion(Long)",
    "String EntityRelation.toString()"
  })
  void testGettersAndSetters_whenSys_tenant_id() {
    // Arrange and Act
    EntityRelation actualEntityRelation =
        new EntityRelation(
            TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Type", RelationTypeGroup.COMMON);
    actualEntityRelation.setFrom(TenantId.SYS_TENANT_ID);
    actualEntityRelation.setTo(TenantId.SYS_TENANT_ID);
    actualEntityRelation.setType("Type");
    actualEntityRelation.setTypeGroup(RelationTypeGroup.COMMON);
    actualEntityRelation.setVersion(1L);
    String actualToStringResult = actualEntityRelation.toString();
    EntityId actualFrom = actualEntityRelation.getFrom();
    EntityId actualTo = actualEntityRelation.getTo();
    String actualType = actualEntityRelation.getType();
    RelationTypeGroup actualTypeGroup = actualEntityRelation.getTypeGroup();

    // Assert
    assertEquals(
        "EntityRelation(from=13814000-1dd2-11b2-8080-808080808080, to=13814000-1dd2-11b2-8080-808080808080,"
            + " type=Type, typeGroup=COMMON, version=1, additionalInfo=null)",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertEquals(1L, actualEntityRelation.getVersion().longValue());
    assertEquals(RelationTypeGroup.COMMON, actualTypeGroup);
    TenantId tenantId = ((TenantId) actualTo).SYS_TENANT_ID;
    assertSame(tenantId, actualFrom);
    assertSame(tenantId, actualTo);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When valueOf ten.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelation#EntityRelation(EntityId, EntityId, String, RelationTypeGroup,
   *       JsonNode)}
   *   <li>{@link EntityRelation#setFrom(EntityId)}
   *   <li>{@link EntityRelation#setTo(EntityId)}
   *   <li>{@link EntityRelation#setType(String)}
   *   <li>{@link EntityRelation#setTypeGroup(RelationTypeGroup)}
   *   <li>{@link EntityRelation#setVersion(Long)}
   *   <li>{@link EntityRelation#toString()}
   *   <li>{@link EntityRelation#getFrom()}
   *   <li>{@link EntityRelation#getTo()}
   *   <li>{@link EntityRelation#getType()}
   *   <li>{@link EntityRelation#getTypeGroup()}
   *   <li>{@link EntityRelation#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityRelation.<init>()",
    "void EntityRelation.<init>(EntityId, EntityId, String, RelationTypeGroup)",
    "void EntityRelation.<init>(EntityId, EntityId, String, RelationTypeGroup, JsonNode)",
    "EntityId EntityRelation.getFrom()",
    "EntityId EntityRelation.getTo()",
    "String EntityRelation.getType()",
    "RelationTypeGroup EntityRelation.getTypeGroup()",
    "Long EntityRelation.getVersion()",
    "void EntityRelation.setFrom(EntityId)",
    "void EntityRelation.setTo(EntityId)",
    "void EntityRelation.setType(String)",
    "void EntityRelation.setTypeGroup(RelationTypeGroup)",
    "void EntityRelation.setVersion(Long)",
    "String EntityRelation.toString()"
  })
  void testGettersAndSetters_whenValueOfTen() {
    // Arrange and Act
    EntityRelation actualEntityRelation =
        new EntityRelation(
            TenantId.SYS_TENANT_ID,
            TenantId.SYS_TENANT_ID,
            "Type",
            RelationTypeGroup.COMMON,
            DoubleNode.valueOf(10.0d));
    actualEntityRelation.setFrom(TenantId.SYS_TENANT_ID);
    actualEntityRelation.setTo(TenantId.SYS_TENANT_ID);
    actualEntityRelation.setType("Type");
    actualEntityRelation.setTypeGroup(RelationTypeGroup.COMMON);
    actualEntityRelation.setVersion(1L);
    String actualToStringResult = actualEntityRelation.toString();
    EntityId actualFrom = actualEntityRelation.getFrom();
    EntityId actualTo = actualEntityRelation.getTo();
    String actualType = actualEntityRelation.getType();
    RelationTypeGroup actualTypeGroup = actualEntityRelation.getTypeGroup();

    // Assert
    assertEquals(
        "EntityRelation(from=13814000-1dd2-11b2-8080-808080808080, to=13814000-1dd2-11b2-8080-808080808080,"
            + " type=Type, typeGroup=COMMON, version=1, additionalInfo=10.0)",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertEquals(1L, actualEntityRelation.getVersion().longValue());
    assertEquals(RelationTypeGroup.COMMON, actualTypeGroup);
    TenantId tenantId = ((TenantId) actualTo).SYS_TENANT_ID;
    assertSame(tenantId, actualFrom);
    assertSame(tenantId, actualTo);
  }

  /**
   * Test {@link EntityRelation#EntityRelation(EntityId, EntityId, String)}.
   *
   * <p>Method under test: {@link EntityRelation#EntityRelation(EntityId, EntityId, String)}
   */
  @Test
  @DisplayName("Test new EntityRelation(EntityId, EntityId, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityRelation.<init>(EntityId, EntityId, String)"})
  void testNewEntityRelation() {
    // Arrange
    TenantId resultTo = TenantId.SYS_TENANT_ID;

    // Act
    EntityRelation actualEntityRelation =
        new EntityRelation(TenantId.SYS_TENANT_ID, resultTo, "Type");

    // Assert
    assertEquals("Type", actualEntityRelation.getType());
    assertNull(actualEntityRelation.getAdditionalInfo());
    assertNull(actualEntityRelation.getVersion());
    assertEquals(RelationTypeGroup.COMMON, actualEntityRelation.getTypeGroup());
    TenantId tenantId = resultTo.SYS_TENANT_ID;
    assertSame(tenantId, actualEntityRelation.getFrom());
    assertSame(tenantId, actualEntityRelation.getTo());
  }

  /**
   * Test {@link EntityRelation#EntityRelation(EntityRelation)}.
   *
   * <ul>
   *   <li>When {@link EntityRelation#EntityRelation()}.
   *   <li>Then return {@link EntityRelation#EntityRelation()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#EntityRelation(EntityRelation)}
   */
  @Test
  @DisplayName(
      "Test new EntityRelation(EntityRelation); when EntityRelation(); then return EntityRelation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityRelation.<init>(EntityRelation)"})
  void testNewEntityRelation_whenEntityRelation_thenReturnEntityRelation() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();

    // Act and Assert
    assertEquals(entityRelation, new EntityRelation(entityRelation));
  }

  /**
   * Test {@link EntityRelation#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link EntityRelation#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode EntityRelation.getAdditionalInfo()"})
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new EntityRelation().getAdditionalInfo());
  }

  /**
   * Test {@link EntityRelation#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link EntityRelation#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityRelation.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.addObject();

    // Act
    entityRelation.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, entityRelation.getAdditionalInfo());
  }

  /**
   * Test {@link EntityRelation#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link EntityRelation#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityRelation.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo2() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.addObject();
    addInfo.addObject();

    // Act
    entityRelation.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, entityRelation.getAdditionalInfo());
  }

  /**
   * Test {@link EntityRelation#setAdditionalInfo(JsonNode)}.
   *
   * <ul>
   *   <li>Then {@link EntityRelation#EntityRelation()} AdditionalInfo is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelation#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setAdditionalInfo(JsonNode); then EntityRelation() AdditionalInfo is valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityRelation.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo_thenEntityRelationAdditionalInfoIsValueOfTen() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    DoubleNode addInfo = DoubleNode.valueOf(10.0d);

    // Act
    entityRelation.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, entityRelation.getAdditionalInfo());
  }
}
