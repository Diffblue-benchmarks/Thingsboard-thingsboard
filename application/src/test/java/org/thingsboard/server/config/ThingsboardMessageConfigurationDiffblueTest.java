package org.thingsboard.server.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ThingsboardMessageConfiguration.class})
@ExtendWith(SpringExtension.class)
class ThingsboardMessageConfigurationDiffblueTest {
  @Autowired
  private ThingsboardMessageConfiguration thingsboardMessageConfiguration;

  /**
   * Test {@link ThingsboardMessageConfiguration#messageSource()}.
   * <p>
   * Method under test: {@link ThingsboardMessageConfiguration#messageSource()}
   */
  @Test
  @DisplayName("Test messageSource()")
  void testMessageSource() {
    // Arrange and Act
    MessageSource actualMessageSourceResult = thingsboardMessageConfiguration.messageSource();

    // Assert
    assertTrue(actualMessageSourceResult instanceof ResourceBundleMessageSource);
    assertNull(((ResourceBundleMessageSource) actualMessageSourceResult).getParentMessageSource());
    Set<String> basenameSet = ((ResourceBundleMessageSource) actualMessageSourceResult).getBasenameSet();
    assertEquals(1, basenameSet.size());
    assertTrue(basenameSet.contains("i18n/messages"));
  }
}
