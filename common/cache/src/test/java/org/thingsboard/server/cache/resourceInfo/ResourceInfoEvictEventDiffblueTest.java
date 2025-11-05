package org.thingsboard.server.cache.resourceInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;

class ResourceInfoEvictEventDiffblueTest {
  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}, and {@link
   * ResourceInfoEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoEvictEvent#equals(Object)}
   *   <li>{@link ResourceInfoEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId resourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, resourceId);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId resourceId2 =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ResourceInfoEvictEvent resourceInfoEvictEvent2 =
        new ResourceInfoEvictEvent(tenantId2, resourceId2);

    // Act and Assert
    assertEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
    assertEquals(resourceInfoEvictEvent.hashCode(), resourceInfoEvictEvent2.hashCode());
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}, and {@link
   * ResourceInfoEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoEvictEvent#equals(Object)}
   *   <li>{@link ResourceInfoEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbResourceId resourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(null, resourceId);
    TbResourceId resourceId2 =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ResourceInfoEvictEvent resourceInfoEvictEvent2 = new ResourceInfoEvictEvent(null, resourceId2);

    // Act and Assert
    assertEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
    assertEquals(resourceInfoEvictEvent.hashCode(), resourceInfoEvictEvent2.hashCode());
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}, and {@link
   * ResourceInfoEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoEvictEvent#equals(Object)}
   *   <li>{@link ResourceInfoEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(tenantId, null);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ResourceInfoEvictEvent resourceInfoEvictEvent2 = new ResourceInfoEvictEvent(tenantId2, null);

    // Act and Assert
    assertEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
    assertEquals(resourceInfoEvictEvent.hashCode(), resourceInfoEvictEvent2.hashCode());
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}, and {@link
   * ResourceInfoEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoEvictEvent#equals(Object)}
   *   <li>{@link ResourceInfoEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId resourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, resourceId);

    // Act and Assert
    assertEquals(resourceInfoEvictEvent, resourceInfoEvictEvent);
    int expectedHashCodeResult = resourceInfoEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, resourceInfoEvictEvent.hashCode());
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TbResourceId resourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, resourceId);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId resourceId2 =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ResourceInfoEvictEvent resourceInfoEvictEvent2 =
        new ResourceInfoEvictEvent(tenantId2, resourceId2);

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbResourceId resourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(null, resourceId);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId resourceId2 =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ResourceInfoEvictEvent resourceInfoEvictEvent2 =
        new ResourceInfoEvictEvent(tenantId, resourceId2);

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID()));
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId resourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ResourceInfoEvictEvent resourceInfoEvictEvent2 =
        new ResourceInfoEvictEvent(tenantId2, resourceId);

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(tenantId, null);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId resourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ResourceInfoEvictEvent resourceInfoEvictEvent2 =
        new ResourceInfoEvictEvent(tenantId2, resourceId);

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId resourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, resourceId);

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, null);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId resourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, resourceId);

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, "Different type to ResourceInfoEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoEvictEvent#ResourceInfoEvictEvent(TenantId, TbResourceId)}
   *   <li>{@link ResourceInfoEvictEvent#toString()}
   *   <li>{@link ResourceInfoEvictEvent#getResourceId()}
   *   <li>{@link ResourceInfoEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceInfoEvictEvent.<init>(TenantId, TbResourceId)",
    "TbResourceId ResourceInfoEvictEvent.getResourceId()",
    "TenantId ResourceInfoEvictEvent.getTenantId()",
    "String ResourceInfoEvictEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceId resourceId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ResourceInfoEvictEvent actualResourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, resourceId);
    String actualToStringResult = actualResourceInfoEvictEvent.toString();
    TbResourceId actualResourceId = actualResourceInfoEvictEvent.getResourceId();

    // Assert
    assertEquals(
        "ResourceInfoEvictEvent(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, resourceId=784f394c-42b6-435a"
            + "-983c-b7beff2784f9)",
        actualToStringResult);
    assertSame(resourceId, actualResourceId);
    assertSame(tenantId, actualResourceInfoEvictEvent.getTenantId());
  }
}
