package org.thingsboard.server.cache.limits;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.limit.LimitedApi;

@ContextConfiguration(classes = {DefaultRateLimitService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class DefaultRateLimitServiceDiffblueTest {
  @Autowired private DefaultRateLimitService defaultRateLimitService;

  @MockBean private TenantProfileProvider tenantProfileProvider;

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, Object, String)} with {@code
   * api}, {@code level}, {@code rateLimitConfig}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, Object,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, Object, String) with 'api', 'level', 'rateLimitConfig'; when empty string; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultRateLimitService.checkRateLimit(LimitedApi, Object, String)"})
  void testCheckRateLimitWithApiLevelRateLimitConfig_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT, "Level", ""));
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, Object, String)} with {@code
   * api}, {@code level}, {@code rateLimitConfig}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, Object,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, Object, String) with 'api', 'level', 'rateLimitConfig'; when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultRateLimitService.checkRateLimit(LimitedApi, Object, String)"})
  void testCheckRateLimitWithApiLevelRateLimitConfig_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT, "Level", null));
  }
}
