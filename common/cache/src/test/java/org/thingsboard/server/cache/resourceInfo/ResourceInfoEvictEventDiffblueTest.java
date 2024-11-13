package org.thingsboard.server.cache.resourceInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;

class ResourceInfoEvictEventDiffblueTest {
  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}, and
   * {@link ResourceInfoEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoEvictEvent#equals(Object)}
   *   <li>{@link ResourceInfoEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(tenantId,
        new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertEquals(resourceInfoEvictEvent, resourceInfoEvictEvent);
    int expectedHashCodeResult = resourceInfoEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, resourceInfoEvictEvent.hashCode());
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(tenantId,
        new TbResourceId(UUID.randomUUID()));
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, new ResourceInfoEvictEvent(tenantId2, new TbResourceId(UUID.randomUUID())));
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(null,
        new TbResourceId(UUID.randomUUID()));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID())));
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(new TenantId(UUID.randomUUID()),
        mock(TbResourceId.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID())));
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantId tenantId = new TenantId(null);
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(tenantId,
        new TbResourceId(UUID.randomUUID()));
    TenantId tenantId2 = new TenantId(null);

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, new ResourceInfoEvictEvent(tenantId2, new TbResourceId(UUID.randomUUID())));
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(null,
        new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, new ResourceInfoEvictEvent(null, new TbResourceId(UUID.randomUUID())));
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID())), null);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID())),
        "Different type to ResourceInfoEvictEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ResourceInfoEvictEvent#ResourceInfoEvictEvent(TenantId, TbResourceId)}
   *   <li>{@link ResourceInfoEvictEvent#toString()}
   *   <li>{@link ResourceInfoEvictEvent#getResourceId()}
   *   <li>{@link ResourceInfoEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TbResourceId resourceId = new TbResourceId(UUID.randomUUID());

    // Act
    ResourceInfoEvictEvent actualResourceInfoEvictEvent = new ResourceInfoEvictEvent(tenantId, resourceId);
    actualResourceInfoEvictEvent.toString();
    TbResourceId actualResourceId = actualResourceInfoEvictEvent.getResourceId();

    // Assert
    assertSame(resourceId, actualResourceId);
    assertSame(tenantId, actualResourceInfoEvictEvent.getTenantId());
  }
}
