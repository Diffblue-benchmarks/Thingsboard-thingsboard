package org.thingsboard.server.service.security.permission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class ResourceDiffblueTest {
  /**
   * Test {@link Resource#getEntityTypes()}.
   * <p>
   * Method under test: {@link Resource#getEntityTypes()}
   */
  @Test
  @DisplayName("Test getEntityTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Resource.getEntityTypes()"})
  void testGetEntityTypes() {
    // Arrange, Act and Assert
    assertTrue(Resource.valueOf("ADMIN_SETTINGS").getEntityTypes().isEmpty());
  }

  /**
   * Test {@link Resource#of(EntityType)}.
   * <ul>
   *   <li>When {@code RULE_NODE}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Resource#of(EntityType)}
   */
  @Test
  @DisplayName("Test of(EntityType); when 'RULE_NODE'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Resource Resource.of(EntityType)"})
  void testOf_whenRuleNode_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Resource.of(EntityType.RULE_NODE));
  }

  /**
   * Test {@link Resource#of(EntityType)}.
   * <ul>
   *   <li>When {@code TENANT}.</li>
   *   <li>Then return {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Resource#of(EntityType)}
   */
  @Test
  @DisplayName("Test of(EntityType); when 'TENANT'; then return 'TENANT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Resource Resource.of(EntityType)"})
  void testOf_whenTenant_thenReturnTenant() {
    // Arrange, Act and Assert
    assertEquals(Resource.TENANT, Resource.of(EntityType.TENANT));
  }
}
