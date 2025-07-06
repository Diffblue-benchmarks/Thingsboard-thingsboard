package org.thingsboard.server.common.data.limit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;

class LimitedApiDiffblueTest {
  /**
   * Test {@link LimitedApi#getLimitConfig(DefaultTenantProfileConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_EXPORT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedApi#getLimitConfig(DefaultTenantProfileConfiguration)}
   */
  @Test
  @DisplayName(
      "Test getLimitConfig(DefaultTenantProfileConfiguration); given 'ENTITY_EXPORT'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LimitedApi.getLimitConfig(DefaultTenantProfileConfiguration)"})
  void testGetLimitConfig_givenEntityExport_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LimitedApi.ENTITY_EXPORT.getLimitConfig(new DefaultTenantProfileConfiguration()));
  }

  /**
   * Test {@link LimitedApi#getLimitConfig(DefaultTenantProfileConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code PASSWORD_RESET}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedApi#getLimitConfig(DefaultTenantProfileConfiguration)}
   */
  @Test
  @DisplayName(
      "Test getLimitConfig(DefaultTenantProfileConfiguration); given 'PASSWORD_RESET'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LimitedApi.getLimitConfig(DefaultTenantProfileConfiguration)"})
  void testGetLimitConfig_givenPasswordReset_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LimitedApi.PASSWORD_RESET.getLimitConfig(new DefaultTenantProfileConfiguration()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LimitedApi#getLabel()}
   *   <li>{@link LimitedApi#isPerTenant()}
   *   <li>{@link LimitedApi#isRefillRateLimitIntervally()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String LimitedApi.getLabel()",
    "boolean LimitedApi.isPerTenant()",
    "boolean LimitedApi.isRefillRateLimitIntervally()"
  })
  void testGettersAndSetters() {
    // Arrange
    LimitedApi valueOfResult = LimitedApi.valueOf("ENTITY_EXPORT");

    // Act
    String actualLabel = valueOfResult.getLabel();
    boolean actualIsPerTenantResult = valueOfResult.isPerTenant();

    // Assert
    assertEquals("entity version creation", actualLabel);
    assertFalse(valueOfResult.isRefillRateLimitIntervally());
    assertTrue(actualIsPerTenantResult);
  }
}
