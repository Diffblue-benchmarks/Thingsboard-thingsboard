package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TemplateUtilsDiffblueTest {
  /**
   * Test {@link TemplateUtils#processTemplate(String, Map)}.
   * <ul>
   *   <li>Given {@code ${UUU:U}}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code ${UUU:U}} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateUtils#processTemplate(String, Map)}
   */
  @Test
  @DisplayName("Test processTemplate(String, Map); given '${UUU:U}'; when HashMap() computeIfPresent '${UUU:U}' and BiFunction")
  void testProcessTemplate_givenUuuU_whenHashMapComputeIfPresentUuuUAndBiFunction() {
    // Arrange
    HashMap<String, String> context = new HashMap<>();
    context.computeIfPresent("${UUU:U}", mock(BiFunction.class));

    // Act and Assert
    assertEquals("Template", TemplateUtils.processTemplate("Template", context));
  }

  /**
   * Test {@link TemplateUtils#processTemplate(String, Map)}.
   * <ul>
   *   <li>When {@code Template}.</li>
   *   <li>Then return {@code Template}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateUtils#processTemplate(String, Map)}
   */
  @Test
  @DisplayName("Test processTemplate(String, Map); when 'Template'; then return 'Template'")
  void testProcessTemplate_whenTemplate_thenReturnTemplate() {
    // Arrange, Act and Assert
    assertEquals("Template", TemplateUtils.processTemplate("Template", new HashMap<>()));
  }

  /**
   * Test {@link TemplateUtils#processTemplate(String, Map)}.
   * <ul>
   *   <li>When {@code ${UUU:U}}.</li>
   *   <li>Then return {@code ${UUU:U}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateUtils#processTemplate(String, Map)}
   */
  @Test
  @DisplayName("Test processTemplate(String, Map); when '${UUU:U}'; then return '${UUU:U}'")
  void testProcessTemplate_whenUuuU_thenReturnUuuU() {
    // Arrange, Act and Assert
    assertEquals("${UUU:U}", TemplateUtils.processTemplate("${UUU:U}", new HashMap<>()));
  }
}
