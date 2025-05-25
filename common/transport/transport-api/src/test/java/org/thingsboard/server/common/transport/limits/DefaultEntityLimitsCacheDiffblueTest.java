package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class DefaultEntityLimitsCacheDiffblueTest {
  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   * <p>
   * Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    defaultEntityLimitsCache
        .put(new EntityLimitKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ""), true);

    // Act and Assert
    assertFalse(defaultEntityLimitsCache
        .get(new EntityLimitKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name")));
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet_thenReturnFalse() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);

    // Act and Assert
    assertFalse(defaultEntityLimitsCache
        .get(new EntityLimitKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name")));
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet_thenReturnTrue() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    defaultEntityLimitsCache.put(
        new EntityLimitKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name"), true);

    // Act and Assert
    assertTrue(defaultEntityLimitsCache
        .get(new EntityLimitKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name")));
  }
}
