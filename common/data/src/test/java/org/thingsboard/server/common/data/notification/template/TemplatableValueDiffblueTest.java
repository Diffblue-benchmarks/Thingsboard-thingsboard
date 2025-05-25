package org.thingsboard.server.common.data.notification.template;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TemplatableValueDiffblueTest {
  /**
   * Test {@link TemplatableValue#TemplatableValue(Supplier, Consumer)}.
   * <p>
   * Method under test: {@link TemplatableValue#TemplatableValue(Supplier, Consumer)}
   */
  @Test
  @DisplayName("Test new TemplatableValue(Supplier, Consumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TemplatableValue.<init>(Supplier, Consumer)"})
  void testNewTemplatableValue() {
    // Arrange, Act and Assert
    assertNull((new TemplatableValue(mock(Supplier.class), mock(Consumer.class))).get());
  }
}
