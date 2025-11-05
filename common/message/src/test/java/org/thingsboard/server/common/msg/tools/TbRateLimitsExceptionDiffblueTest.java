package org.thingsboard.server.common.msg.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class TbRateLimitsExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRateLimitsException#TbRateLimitsException(String)}
   *   <li>{@link TbRateLimitsException#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbRateLimitsException.<init>(String)",
    "EntityType TbRateLimitsException.getEntityType()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbRateLimitsException actualTbRateLimitsException =
        new TbRateLimitsException("An error occurred");
    EntityType actualEntityType = actualTbRateLimitsException.getEntityType();

    // Assert
    assertEquals("An error occurred", actualTbRateLimitsException.getMessage());
    assertNull(actualTbRateLimitsException.getCause());
    assertNull(actualEntityType);
    assertEquals(0, actualTbRateLimitsException.getSuppressed().length);
  }

  /**
   * Test {@link TbRateLimitsException#TbRateLimitsException(EntityType)}.
   *
   * <p>Method under test: {@link TbRateLimitsException#TbRateLimitsException(EntityType)}
   */
  @Test
  @DisplayName("Test new TbRateLimitsException(EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRateLimitsException.<init>(EntityType)"})
  void testNewTbRateLimitsException() {
    // Arrange and Act
    TbRateLimitsException actualTbRateLimitsException =
        new TbRateLimitsException(EntityType.TENANT);

    // Assert
    assertEquals("TENANT rate limits reached!", actualTbRateLimitsException.getLocalizedMessage());
    assertEquals("TENANT rate limits reached!", actualTbRateLimitsException.getMessage());
    assertNull(actualTbRateLimitsException.getCause());
    assertEquals(0, actualTbRateLimitsException.getSuppressed().length);
    assertEquals(EntityType.TENANT, actualTbRateLimitsException.getEntityType());
  }
}
